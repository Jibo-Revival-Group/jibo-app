package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: a */
    private static final String[] f1789a = {"_display_name", "_size"};

    /* JADX INFO: renamed from: b */
    private static final File f1790b = new File("/");

    /* JADX INFO: renamed from: c */
    private static HashMap<String, PathStrategy> f1791c = new HashMap<>();

    /* JADX INFO: renamed from: d */
    private PathStrategy f1792d;

    interface PathStrategy {
        /* JADX INFO: renamed from: a */
        Uri mo1854a(File file);

        /* JADX INFO: renamed from: a */
        File mo1855a(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f1792d = m1849a(context, providerInfo.authority);
    }

    /* JADX INFO: renamed from: a */
    public static Uri m1848a(Context context, String str, File file) {
        return m1849a(context, str).mo1854a(file);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileMo1855a = this.f1792d.mo1855a(uri);
        if (strArr == null) {
            strArr = f1789a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i = i3 + 1;
                objArr[i3] = fileMo1855a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i = i3 + 1;
                objArr[i3] = Long.valueOf(fileMo1855a.length());
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        String[] strArrM1852a = m1852a(strArr3, i3);
        Object[] objArrM1851a = m1851a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArrM1852a, 1);
        matrixCursor.addRow(objArrM1851a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileMo1855a = this.f1792d.mo1855a(uri);
        int iLastIndexOf = fileMo1855a.getName().lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMo1855a.getName().substring(iLastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f1792d.mo1855a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f1792d.mo1855a(uri), m1847a(str));
    }

    /* JADX INFO: renamed from: a */
    private static PathStrategy m1849a(Context context, String str) {
        PathStrategy pathStrategyM1853b;
        synchronized (f1791c) {
            pathStrategyM1853b = f1791c.get(str);
            if (pathStrategyM1853b == null) {
                try {
                    try {
                        pathStrategyM1853b = m1853b(context, str);
                        f1791c.put(str, pathStrategyM1853b);
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                    }
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategyM1853b;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.support.v4.content.FileProvider.PathStrategy m1853b(android.content.Context r10, java.lang.String r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r9 = 1
            r1 = 0
            r8 = 0
            android.support.v4.content.FileProvider$SimplePathStrategy r2 = new android.support.v4.content.FileProvider$SimplePathStrategy
            r2.<init>(r11)
            android.content.pm.PackageManager r0 = r10.getPackageManager()
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r11, r3)
            android.content.pm.PackageManager r3 = r10.getPackageManager()
            java.lang.String r4 = "android.support.FILE_PROVIDER_PATHS"
            android.content.res.XmlResourceParser r3 = r0.loadXmlMetaData(r3, r4)
            if (r3 != 0) goto L26
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Missing android.support.FILE_PROVIDER_PATHS meta-data"
            r0.<init>(r1)
            throw r0
        L26:
            int r0 = r3.next()
            if (r0 == r9) goto Lba
            r4 = 2
            if (r0 != r4) goto L26
            java.lang.String r0 = r3.getName()
            java.lang.String r4 = "name"
            java.lang.String r4 = r3.getAttributeValue(r1, r4)
            java.lang.String r5 = "path"
            java.lang.String r5 = r3.getAttributeValue(r1, r5)
            java.lang.String r6 = "root-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L57
            java.io.File r0 = android.support.v4.content.FileProvider.f1790b
        L49:
            if (r0 == 0) goto L26
            java.lang.String[] r6 = new java.lang.String[r9]
            r6[r8] = r5
            java.io.File r0 = m1850a(r0, r6)
            r2.m1856a(r4, r0)
            goto L26
        L57:
            java.lang.String r6 = "files-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L64
            java.io.File r0 = r10.getFilesDir()
            goto L49
        L64:
            java.lang.String r6 = "cache-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L71
            java.io.File r0 = r10.getCacheDir()
            goto L49
        L71:
            java.lang.String r6 = "external-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L7e
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            goto L49
        L7e:
            java.lang.String r6 = "external-files-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L90
            java.io.File[] r0 = android.support.v4.content.ContextCompat.m1836a(r10, r1)
            int r6 = r0.length
            if (r6 <= 0) goto Lbb
            r0 = r0[r8]
            goto L49
        L90:
            java.lang.String r6 = "external-cache-path"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto La2
            java.io.File[] r0 = android.support.v4.content.ContextCompat.m1835a(r10)
            int r6 = r0.length
            if (r6 <= 0) goto Lbb
            r0 = r0[r8]
            goto L49
        La2:
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 21
            if (r6 < r7) goto Lbb
            java.lang.String r6 = "external-media-path"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto Lbb
            java.io.File[] r0 = r10.getExternalMediaDirs()
            int r6 = r0.length
            if (r6 <= 0) goto Lbb
            r0 = r0[r8]
            goto L49
        Lba:
            return r2
        Lbb:
            r0 = r1
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.FileProvider.m1853b(android.content.Context, java.lang.String):android.support.v4.content.FileProvider$PathStrategy");
    }

    static class SimplePathStrategy implements PathStrategy {

        /* JADX INFO: renamed from: a */
        private final String f1793a;

        /* JADX INFO: renamed from: b */
        private final HashMap<String, File> f1794b = new HashMap<>();

        SimplePathStrategy(String str) {
            this.f1793a = str;
        }

        /* JADX INFO: renamed from: a */
        void m1856a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f1794b.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }

        @Override // android.support.v4.content.FileProvider.PathStrategy
        /* JADX INFO: renamed from: a */
        public Uri mo1854a(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f1794b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= entry.getValue().getPath().length())) {
                        entry2 = entry;
                    }
                    entry = entry2;
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(this.f1793a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // android.support.v4.content.FileProvider.PathStrategy
        /* JADX INFO: renamed from: a */
        public File mo1855a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f1794b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (!canonicalFile.getPath().startsWith(file.getPath())) {
                    throw new SecurityException("Resolved path jumped beyond configured root");
                }
                return canonicalFile;
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m1847a(String str) {
        if ("r".equals(str)) {
            return SQLiteDatabase.CREATE_IF_NECESSARY;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* JADX INFO: renamed from: a */
    private static File m1850a(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            i++;
            file2 = str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    /* JADX INFO: renamed from: a */
    private static String[] m1852a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* JADX INFO: renamed from: a */
    private static Object[] m1851a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
