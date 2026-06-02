package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatUtil {
    /* JADX INFO: renamed from: a */
    public static File m1978a(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 100) {
                File file = new File(context.getCacheDir(), str + i2);
                if (!file.createNewFile()) {
                    i = i2 + 1;
                } else {
                    return file;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[Catch: IOException -> 0x0024, SYNTHETIC, TRY_ENTER, TryCatch #3 {IOException -> 0x0024, blocks: (B:3:0x0001, B:8:0x001b, B:14:0x0027, B:11:0x0020, B:22:0x0035, B:26:0x003e, B:25:0x003a, B:23:0x0038), top: B:32:0x0001, inners: #2, #5 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.nio.ByteBuffer m1981a(java.io.File r10) throws java.lang.Throwable {
        /*
            r6 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.io.IOException -> L24
            r7.<init>(r10)     // Catch: java.io.IOException -> L24
            r8 = 0
            java.nio.channels.FileChannel r0 = r7.getChannel()     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L42
            long r4 = r0.size()     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L42
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L42
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L42
            if (r7 == 0) goto L1e
            if (r6 == 0) goto L27
            r7.close()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L24
        L1e:
            return r0
        L1f:
            r1 = move-exception
            r8.addSuppressed(r1)     // Catch: java.io.IOException -> L24
            goto L1e
        L24:
            r0 = move-exception
            r0 = r6
            goto L1e
        L27:
            r7.close()     // Catch: java.io.IOException -> L24
            goto L1e
        L2b:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L2d
        L2d:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L31:
            if (r7 == 0) goto L38
            if (r1 == 0) goto L3e
            r7.close()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L39
        L38:
            throw r0     // Catch: java.io.IOException -> L24
        L39:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.io.IOException -> L24
            goto L38
        L3e:
            r7.close()     // Catch: java.io.IOException -> L24
            goto L38
        L42:
            r0 = move-exception
            r1 = r6
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.m1981a(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[Catch: IOException -> 0x001c, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x001c, blocks: (B:3:0x0005, B:8:0x0012, B:15:0x001f, B:12:0x0018, B:25:0x0048, B:45:0x006b, B:28:0x004d, B:39:0x0060, B:61:0x008b, B:60:0x0087, B:40:0x0063), top: B:80:0x0005, inners: #2, #7, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[Catch: Throwable -> 0x0056, all -> 0x0068, SYNTHETIC, TRY_ENTER, TryCatch #6 {all -> 0x0068, blocks: (B:17:0x0023, B:22:0x0041, B:41:0x0064, B:31:0x0052, B:53:0x0079, B:57:0x0082, B:56:0x007e, B:54:0x007c), top: B:75:0x0023 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.ByteBuffer m1980a(android.content.Context r12, android.os.CancellationSignal r13, android.net.Uri r14) throws java.lang.Throwable {
        /*
            r6 = 0
            android.content.ContentResolver r0 = r12.getContentResolver()
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r0.openFileDescriptor(r14, r1, r13)     // Catch: java.io.IOException -> L1c
            r8 = 0
            if (r7 != 0) goto L23
            if (r7 == 0) goto L15
            if (r6 == 0) goto L1f
            r7.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L1c
        L15:
            r0 = r6
        L16:
            return r0
        L17:
            r0 = move-exception
            r8.addSuppressed(r0)     // Catch: java.io.IOException -> L1c
            goto L15
        L1c:
            r0 = move-exception
            r0 = r6
            goto L16
        L1f:
            r7.close()     // Catch: java.io.IOException -> L1c
            goto L15
        L23:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            java.io.FileDescriptor r0 = r7.getFileDescriptor()     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            r10 = 0
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> L8f
            long r4 = r0.size()     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> L8f
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> L8f
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> L8f
            if (r9 == 0) goto L44
            if (r6 == 0) goto L64
            r9.close()     // Catch: java.lang.Throwable -> L51 java.lang.Throwable -> L68
        L44:
            if (r7 == 0) goto L16
            if (r6 == 0) goto L6b
            r7.close()     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L4c
            goto L16
        L4c:
            r1 = move-exception
            r8.addSuppressed(r1)     // Catch: java.io.IOException -> L1c
            goto L16
        L51:
            r1 = move-exception
            r10.addSuppressed(r1)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            goto L44
        L56:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L58
        L58:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L5c:
            if (r7 == 0) goto L63
            if (r1 == 0) goto L8b
            r7.close()     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L86
        L63:
            throw r0     // Catch: java.io.IOException -> L1c
        L64:
            r9.close()     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            goto L44
        L68:
            r0 = move-exception
            r1 = r6
            goto L5c
        L6b:
            r7.close()     // Catch: java.io.IOException -> L1c
            goto L16
        L6f:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L71
        L71:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L75:
            if (r9 == 0) goto L7c
            if (r1 == 0) goto L82
            r9.close()     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L7d
        L7c:
            throw r0     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
        L7d:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            goto L7c
        L82:
            r9.close()     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L68
            goto L7c
        L86:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.io.IOException -> L1c
            goto L63
        L8b:
            r7.close()     // Catch: java.io.IOException -> L1c
            goto L63
        L8f:
            r0 = move-exception
            r1 = r6
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.m1980a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* JADX INFO: renamed from: a */
    public static ByteBuffer m1979a(Context context, Resources resources, int i) {
        ByteBuffer byteBufferM1981a = null;
        File fileM1978a = m1978a(context);
        if (fileM1978a != null) {
            try {
                if (m1983a(fileM1978a, resources, i)) {
                    byteBufferM1981a = m1981a(fileM1978a);
                }
            } finally {
                fileM1978a.delete();
            }
        }
        return byteBufferM1981a;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1984a(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            m1982a(fileOutputStream);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m1982a(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                m1982a(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            m1982a(fileOutputStream);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1983a(File file, Resources resources, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            return m1984a(file, inputStreamOpenRawResource);
        } finally {
            m1982a(inputStreamOpenRawResource);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1982a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
