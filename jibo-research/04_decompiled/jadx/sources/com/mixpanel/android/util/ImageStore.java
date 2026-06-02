package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.util.Base64;
import com.mixpanel.android.mpmetrics.MPConfig;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class ImageStore {

    /* JADX INFO: renamed from: e */
    private static LruCache<String, Bitmap> f12083e;

    /* JADX INFO: renamed from: a */
    private final File f12084a;

    /* JADX INFO: renamed from: b */
    private final RemoteService f12085b;

    /* JADX INFO: renamed from: c */
    private final MessageDigest f12086c;

    /* JADX INFO: renamed from: d */
    private final MPConfig f12087d;

    public static class CantGetImageException extends Exception {
        public CantGetImageException(String str) {
            super(str);
        }

        public CantGetImageException(String str, Throwable th) {
            super(str, th);
        }
    }

    public ImageStore(Context context, String str) {
        this(context, "MixpanelAPI.Images." + str, new HttpService());
    }

    public ImageStore(Context context, String str, RemoteService remoteService) {
        MessageDigest messageDigest;
        this.f12084a = context.getDir(str, 0);
        this.f12085b = remoteService;
        this.f12087d = MPConfig.m11762a(context);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            MPLog.m12028d("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
            messageDigest = null;
        }
        this.f12086c = messageDigest;
        if (f12083e == null) {
            synchronized (ImageStore.class) {
                if (f12083e == null) {
                    f12083e = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / this.f12087d.m11764A()) { // from class: com.mixpanel.android.util.ImageStore.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.support.v4.util.LruCache
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int mo2422b(String str2, Bitmap bitmap) {
                            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                        }
                    };
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File m12015a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r2 = 0
            java.io.File r0 = r5.m12014f(r6)
            if (r0 == 0) goto Ld
            boolean r1 = r0.exists()
            if (r1 != 0) goto L31
        Ld:
            com.mixpanel.android.mpmetrics.MPConfig r1 = r5.f12087d     // Catch: java.io.IOException -> L32 com.mixpanel.android.util.RemoteService.ServiceUnavailableException -> L3b
            javax.net.ssl.SSLSocketFactory r1 = r1.m11789y()     // Catch: java.io.IOException -> L32 com.mixpanel.android.util.RemoteService.ServiceUnavailableException -> L3b
            com.mixpanel.android.util.RemoteService r3 = r5.f12085b     // Catch: java.io.IOException -> L32 com.mixpanel.android.util.RemoteService.ServiceUnavailableException -> L3b
            r4 = 0
            byte[] r3 = r3.mo12008a(r6, r4, r1)     // Catch: java.io.IOException -> L32 com.mixpanel.android.util.RemoteService.ServiceUnavailableException -> L3b
            if (r3 == 0) goto L31
            if (r0 == 0) goto L31
            int r1 = r3.length
            r4 = 10000000(0x989680, float:1.4012985E-38)
            if (r1 >= r4) goto L31
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L4d java.io.IOException -> L5f java.lang.Throwable -> L68
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L4d java.io.IOException -> L5f java.lang.Throwable -> L68
            r1.write(r3)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L73 java.io.FileNotFoundException -> L76
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.io.IOException -> L44
        L31:
            return r0
        L32:
            r0 = move-exception
            com.mixpanel.android.util.ImageStore$CantGetImageException r1 = new com.mixpanel.android.util.ImageStore$CantGetImageException
            java.lang.String r2 = "Can't download bitmap"
            r1.<init>(r2, r0)
            throw r1
        L3b:
            r0 = move-exception
            com.mixpanel.android.util.ImageStore$CantGetImageException r1 = new com.mixpanel.android.util.ImageStore$CantGetImageException
            java.lang.String r2 = "Couldn't download image due to service availability"
            r1.<init>(r2, r0)
            throw r1
        L44:
            r1 = move-exception
            java.lang.String r2 = "MixpanelAPI.ImageStore"
            java.lang.String r3 = "Problem closing output file"
            com.mixpanel.android.util.MPLog.m12029d(r2, r3, r1)
            goto L31
        L4d:
            r0 = move-exception
            r1 = r2
        L4f:
            com.mixpanel.android.util.ImageStore$CantGetImageException r2 = new com.mixpanel.android.util.ImageStore$CantGetImageException     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = "It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory"
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L57
            throw r2     // Catch: java.lang.Throwable -> L57
        L57:
            r0 = move-exception
            r2 = r1
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.io.IOException -> L6a
        L5e:
            throw r0
        L5f:
            r0 = move-exception
        L60:
            com.mixpanel.android.util.ImageStore$CantGetImageException r1 = new com.mixpanel.android.util.ImageStore$CantGetImageException     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "Can't store bitmap"
            r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L68
            throw r1     // Catch: java.lang.Throwable -> L68
        L68:
            r0 = move-exception
            goto L59
        L6a:
            r1 = move-exception
            java.lang.String r2 = "MixpanelAPI.ImageStore"
            java.lang.String r3 = "Problem closing output file"
            com.mixpanel.android.util.MPLog.m12029d(r2, r3, r1)
            goto L5e
        L73:
            r0 = move-exception
            r2 = r1
            goto L60
        L76:
            r0 = move-exception
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.ImageStore.m12015a(java.lang.String):java.io.File");
    }

    /* JADX INFO: renamed from: b */
    public Bitmap m12016b(String str) throws CantGetImageException {
        Bitmap bitmapM12012d = m12012d(str);
        if (bitmapM12012d == null) {
            Bitmap bitmapM12010a = m12010a(m12015a(str));
            m12011a(str, bitmapM12010a);
            return bitmapM12010a;
        }
        return bitmapM12012d;
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m12010a(File file) throws CantGetImageException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (options.outWidth * options.outHeight > m12009a()) {
            throw new CantGetImageException("Do not have enough memory for the image");
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile == null) {
            file.delete();
            throw new CantGetImageException("Bitmap on disk can't be opened or was corrupt");
        }
        return bitmapDecodeFile;
    }

    /* JADX INFO: renamed from: a */
    private static float m12009a() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    /* JADX INFO: renamed from: c */
    public void m12017c(String str) {
        File fileM12014f = m12014f(str);
        if (fileM12014f != null) {
            fileM12014f.delete();
            m12013e(str);
        }
    }

    /* JADX INFO: renamed from: f */
    private File m12014f(String str) {
        if (this.f12086c == null) {
            return null;
        }
        return new File(this.f12084a, "MP_IMG_" + Base64.encodeToString(this.f12086c.digest(str.getBytes()), 10));
    }

    /* JADX INFO: renamed from: a */
    public static void m12011a(String str, Bitmap bitmap) {
        if (m12012d(str) == null) {
            synchronized (f12083e) {
                f12083e.m2418a(str, bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static Bitmap m12012d(String str) {
        Bitmap bitmapM2417a;
        synchronized (f12083e) {
            bitmapM2417a = f12083e.m2417a(str);
        }
        return bitmapM2417a;
    }

    /* JADX INFO: renamed from: e */
    public static void m12013e(String str) {
        synchronized (f12083e) {
            f12083e.m2423b(str);
        }
    }
}
