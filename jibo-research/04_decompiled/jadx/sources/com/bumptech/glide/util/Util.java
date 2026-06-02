package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class Util {

    /* JADX INFO: renamed from: a */
    private static final char[] f5009a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b */
    private static final char[] f5010b = new char[64];

    /* JADX INFO: renamed from: c */
    private static final char[] f5011c = new char[40];

    /* JADX INFO: renamed from: a */
    public static String m5588a(byte[] bArr) {
        String strM5589a;
        synchronized (f5010b) {
            strM5589a = m5589a(bArr, f5010b);
        }
        return strM5589a;
    }

    /* JADX INFO: renamed from: a */
    private static String m5589a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f5009a[i2 >>> 4];
            cArr[(i * 2) + 1] = f5009a[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: a */
    public static int m5587a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    /* JADX INFO: renamed from: a */
    public static int m5585a(int i, int i2, Bitmap.Config config) {
        return i * i2 * m5586a(config);
    }

    /* JADX INFO: renamed from: a */
    private static int m5586a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (C03771.f5012a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1 */
    static /* synthetic */ class C03771 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5012a = new int[Bitmap.Config.values().length];

        static {
            try {
                f5012a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5012a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5012a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5012a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5593a(int i, int i2) {
        return m5595b(i) && m5595b(i2);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m5595b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: a */
    public static void m5592a() {
        if (!m5594b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m5594b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m5596c() {
        return !m5594b();
    }

    /* JADX INFO: renamed from: a */
    public static <T> Queue<T> m5591a(int i) {
        return new ArrayDeque(i);
    }

    /* JADX INFO: renamed from: a */
    public static <T> List<T> m5590a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
