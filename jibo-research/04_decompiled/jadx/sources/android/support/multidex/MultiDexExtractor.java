package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
final class MultiDexExtractor implements Closeable {

    /* JADX INFO: renamed from: a */
    private final File f1085a;

    /* JADX INFO: renamed from: b */
    private final long f1086b;

    /* JADX INFO: renamed from: c */
    private final File f1087c;

    /* JADX INFO: renamed from: d */
    private final RandomAccessFile f1088d;

    /* JADX INFO: renamed from: e */
    private final FileChannel f1089e;

    /* JADX INFO: renamed from: f */
    private final FileLock f1090f;

    private static class ExtractedDex extends File {

        /* JADX INFO: renamed from: a */
        public long f1092a;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.f1092a = -1L;
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f1085a = file;
        this.f1087c = file2;
        this.f1086b = m1054b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.f1088d = new RandomAccessFile(file3, "rw");
        try {
            this.f1089e = this.f1088d.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f1090f = this.f1089e.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException | Error | RuntimeException e) {
                m1051a(this.f1089e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e2) {
            m1051a(this.f1088d);
            throw e2;
        }
    }

    /* JADX INFO: renamed from: a */
    List<? extends File> m1056a(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> listM1048a;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f1085a.getPath() + ", " + z + ", " + str + ")");
        if (!this.f1090f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z && !m1053a(context, this.f1085a, this.f1086b, str)) {
            try {
                listM1048a = m1049a(context, str);
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                listM1048a = m1048a();
                m1050a(context, str, m1046a(this.f1085a), this.f1086b, listM1048a);
            }
        } else {
            if (z) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            listM1048a = m1048a();
            m1050a(context, str, m1046a(this.f1085a), this.f1086b, listM1048a);
        }
        Log.i("MultiDex", "load found " + listM1048a.size() + " secondary dex files");
        return listM1048a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1090f.release();
        this.f1089e.close();
        this.f1088d.close();
    }

    /* JADX INFO: renamed from: a */
    private List<ExtractedDex> m1049a(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f1085a.getName() + ".classes";
        SharedPreferences sharedPreferencesM1047a = m1047a(context);
        int i = sharedPreferencesM1047a.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i - 1);
        for (int i2 = 2; i2 <= i; i2++) {
            ExtractedDex extractedDex = new ExtractedDex(this.f1087c, str2 + i2 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.f1092a = m1054b(extractedDex);
                long j = sharedPreferencesM1047a.getLong(str + "dex.crc." + i2, -1L);
                long j2 = sharedPreferencesM1047a.getLong(str + "dex.time." + i2, -1L);
                long jLastModified = extractedDex.lastModified();
                if (j2 != jLastModified || j != extractedDex.f1092a) {
                    throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + jLastModified + ", expected crc: " + j + ", file crc: " + extractedDex.f1092a);
                }
                arrayList.add(extractedDex);
            } else {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1053a(Context context, File file, long j, String str) {
        SharedPreferences sharedPreferencesM1047a = m1047a(context);
        return (sharedPreferencesM1047a.getLong(new StringBuilder().append(str).append("timestamp").toString(), -1L) == m1046a(file) && sharedPreferencesM1047a.getLong(new StringBuilder().append(str).append("crc").toString(), -1L) == j) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private static long m1046a(File file) {
        long jLastModified = file.lastModified();
        if (jLastModified == -1) {
            return jLastModified - 1;
        }
        return jLastModified;
    }

    /* JADX INFO: renamed from: b */
    private static long m1054b(File file) throws IOException {
        long jM1057a = ZipUtil.m1057a(file);
        if (jM1057a == -1) {
            return jM1057a - 1;
        }
        return jM1057a;
    }

    /* JADX INFO: renamed from: a */
    private List<ExtractedDex> m1048a() throws IOException {
        String str = this.f1085a.getName() + ".classes";
        m1055b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f1085a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.f1087c, str + i + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    m1052a(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.f1092a = m1054b(extractedDex);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e);
                        z = false;
                    }
                    Log.i("MultiDex", "Extraction " + (z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed") + " '" + extractedDex.getAbsolutePath() + "': length " + extractedDex.length() + " - crc: " + extractedDex.f1092a);
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                            i2 = i3;
                        }
                    }
                    i2 = i3;
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                int i4 = i + 1;
                entry = zipFile.getEntry("classes" + i4 + ".dex");
                i = i4;
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1050a(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor editorEdit = m1047a(context).edit();
        editorEdit.putLong(str + "timestamp", j);
        editorEdit.putLong(str + "crc", j2);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        Iterator<ExtractedDex> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                ExtractedDex next = it.next();
                editorEdit.putLong(str + "dex.crc." + i2, next.f1092a);
                editorEdit.putLong(str + "dex.time." + i2, next.lastModified());
                i = i2 + 1;
            } else {
                editorEdit.commit();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static SharedPreferences m1047a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* JADX INFO: renamed from: b */
    private void m1055b() {
        File[] fileArrListFiles = this.f1087c.listFiles(new FileFilter() { // from class: android.support.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f1087c.getPath() + ").");
            return;
        }
        for (File file : fileArrListFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1052a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i = inputStream.read(bArr); i != -1; i = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (!fileCreateTempFile.renameTo(file)) {
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            m1051a(inputStream);
            fileCreateTempFile.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1051a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
