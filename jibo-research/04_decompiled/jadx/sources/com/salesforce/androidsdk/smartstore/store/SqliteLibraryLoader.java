package com.salesforce.androidsdk.smartstore.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SqliteLibraryLoader {

    /* JADX INFO: renamed from: a */
    private static final String f14340a = SqliteLibraryLoader.class.getSimpleName();

    /* JADX INFO: renamed from: a */
    public static boolean m14808a(Context context) {
        try {
            m14812b(context);
            return true;
        } catch (Exception e) {
            SmartStoreLogger.m14825a(f14340a, "Error occurred while loading native libs for SQLCipher", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            return m14809a(context, "libsqlcipher.so", m14811a());
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m14809a(Context context, String str, String[] strArr) {
        boolean z;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String string = context.getFilesDir().toString();
        SmartStoreLogger.m14826b(f14340a, "Extracting to destination: " + string);
        try {
            String str2 = string + File.separator + str;
            new File(str2).delete();
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                String str3 = strArr[i];
                SmartStoreLogger.m14826b(f14340a, "Using ABI: " + str3);
                UnzipUtil.m14813a(applicationInfo.sourceDir, "lib/" + str3 + "/" + str, string);
                if (!m14810a(new File(str2))) {
                    i++;
                } else {
                    SmartStoreLogger.m14826b(f14340a, "File exists after extracting to " + str3);
                    z = true;
                    break;
                }
            }
            if (z) {
                System.load(str2);
                return true;
            }
        } catch (IOException | UnsatisfiedLinkError e) {
            SmartStoreLogger.m14825a(f14340a, "Error occurred while extracting and loading libs", e);
        }
        return false;
    }

    public static class UnzipUtil {
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        
            r0 = r0.getName();
            r3 = r0.lastIndexOf(java.io.File.separator);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        
            if (r3 <= (-1)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        
            r0 = r0.substring(r3 + 1, r0.length());
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        
            m14814a(r2, r7 + java.io.File.separator + r0);
         */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m14813a(java.lang.String r5, java.lang.String r6, java.lang.String r7) throws java.io.IOException {
            /*
                java.io.FileInputStream r1 = new java.io.FileInputStream
                r1.<init>(r5)
                if (r1 == 0) goto L5b
                java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
                r2.<init>(r1)
                java.util.zip.ZipEntry r0 = r2.getNextEntry()
            L10:
                if (r0 == 0) goto L53
                boolean r3 = r0.isDirectory()     // Catch: java.lang.Throwable -> L64
                if (r3 != 0) goto L5c
                java.lang.String r3 = r0.getName()     // Catch: java.lang.Throwable -> L64
                boolean r3 = r6.equals(r3)     // Catch: java.lang.Throwable -> L64
                if (r3 == 0) goto L5c
                java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L64
                java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L64
                int r3 = r0.lastIndexOf(r3)     // Catch: java.lang.Throwable -> L64
                r4 = -1
                if (r3 <= r4) goto L39
                int r3 = r3 + 1
                int r4 = r0.length()     // Catch: java.lang.Throwable -> L64
                java.lang.String r0 = r0.substring(r3, r4)     // Catch: java.lang.Throwable -> L64
            L39:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
                r3.<init>()     // Catch: java.lang.Throwable -> L64
                java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> L64
                java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L64
                java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L64
                java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L64
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L64
                m14814a(r2, r0)     // Catch: java.lang.Throwable -> L64
            L53:
                if (r2 == 0) goto L58
                r2.close()
            L58:
                r1.close()
            L5b:
                return
            L5c:
                r2.closeEntry()     // Catch: java.lang.Throwable -> L64
                java.util.zip.ZipEntry r0 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L64
                goto L10
            L64:
                r0 = move-exception
                if (r2 == 0) goto L6a
                r2.close()
            L6a:
                r1.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.SqliteLibraryLoader.UnzipUtil.m14813a(java.lang.String, java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: renamed from: a */
        private static void m14814a(ZipInputStream zipInputStream, String str) throws IOException {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = zipInputStream.read(bArr);
                    if (i != -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                    } else {
                        return;
                    }
                }
            } finally {
                bufferedOutputStream.close();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m14812b(Context context) throws UnsatisfiedLinkError {
        SQLiteDatabase.loadLibs(context);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m14810a(File file) {
        return file.canRead();
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public static String[] m14811a() {
        return (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : Build.SUPPORTED_ABIS;
    }
}
