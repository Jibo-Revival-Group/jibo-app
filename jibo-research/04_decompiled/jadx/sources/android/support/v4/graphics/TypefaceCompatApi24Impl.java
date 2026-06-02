package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* JADX INFO: renamed from: a */
    private static final Class f1857a;

    /* JADX INFO: renamed from: b */
    private static final Constructor f1858b;

    /* JADX INFO: renamed from: c */
    private static final Method f1859c;

    /* JADX INFO: renamed from: d */
    private static final Method f1860d;

    TypefaceCompatApi24Impl() {
    }

    static {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2 = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls2.getConstructor(new Class[0]);
            Method method3 = cls2.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls2, 1).getClass());
            method2 = method3;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
        }
        f1858b = constructor;
        f1857a = cls;
        f1859c = method2;
        f1860d = method;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1962a() {
        if (f1859c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f1859c != null;
    }

    /* JADX INFO: renamed from: b */
    private static Object m1964b() {
        try {
            return f1858b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1963a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1859c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m1961a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f1857a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f1860d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1958a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) throws Throwable {
        Object objM1964b = m1964b();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri uriM2350a = fontInfo.m2350a();
            ByteBuffer byteBufferM1980a = (ByteBuffer) simpleArrayMap.get(uriM2350a);
            if (byteBufferM1980a == null) {
                byteBufferM1980a = TypefaceCompatUtil.m1980a(context, cancellationSignal, uriM2350a);
                simpleArrayMap.put(uriM2350a, byteBufferM1980a);
            }
            if (!m1963a(objM1964b, byteBufferM1980a, fontInfo.m2351b(), fontInfo.m2352c(), fontInfo.m2353d())) {
                return null;
            }
        }
        return Typeface.create(m1961a(objM1964b), i);
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1959a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object objM1964b = m1964b();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.m1908a()) {
            ByteBuffer byteBufferM1979a = TypefaceCompatUtil.m1979a(context, resources, fontFileResourceEntry.m1912d());
            if (byteBufferM1979a == null || !m1963a(objM1964b, byteBufferM1979a, 0, fontFileResourceEntry.m1910b(), fontFileResourceEntry.m1911c())) {
                return null;
            }
        }
        return m1961a(objM1964b);
    }
}
