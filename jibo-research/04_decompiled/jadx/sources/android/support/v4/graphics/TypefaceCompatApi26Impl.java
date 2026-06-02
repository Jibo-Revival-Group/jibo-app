package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* JADX INFO: renamed from: a */
    private static final Class f1861a;

    /* JADX INFO: renamed from: b */
    private static final Constructor f1862b;

    /* JADX INFO: renamed from: c */
    private static final Method f1863c;

    /* JADX INFO: renamed from: d */
    private static final Method f1864d;

    /* JADX INFO: renamed from: e */
    private static final Method f1865e;

    /* JADX INFO: renamed from: f */
    private static final Method f1866f;

    /* JADX INFO: renamed from: g */
    private static final Method f1867g;

    static {
        Method declaredMethod;
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Class<?> cls;
        Method method4 = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls2.getConstructor(new Class[0]);
            Method method5 = cls2.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            Method method6 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            Method method7 = cls2.getMethod("freeze", new Class[0]);
            Method method8 = cls2.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls2, 1).getClass(), Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            method4 = method8;
            method = method7;
            method2 = method6;
            method3 = method5;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            declaredMethod = null;
            method = null;
            method2 = null;
            method3 = null;
            constructor = null;
            cls = null;
        }
        f1862b = constructor;
        f1861a = cls;
        f1863c = method3;
        f1864d = method2;
        f1865e = method;
        f1866f = method4;
        f1867g = declaredMethod;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1966a() {
        if (f1863c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f1863c != null;
    }

    /* JADX INFO: renamed from: b */
    private static Object m1969b() {
        try {
            return f1862b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1967a(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) f1863c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1968a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f1864d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m1965a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f1861a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f1867g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1970b(Object obj) {
        try {
            return ((Boolean) f1865e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m1971c(Object obj) {
        try {
            f1866f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1959a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!m1966a()) {
            return super.mo1959a(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object objM1969b = m1969b();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.m1908a()) {
            if (!m1967a(context, objM1969b, fontFileResourceEntry.m1909a(), 0, fontFileResourceEntry.m1910b(), fontFileResourceEntry.m1911c() ? 1 : 0)) {
                m1971c(objM1969b);
                return null;
            }
        }
        if (m1970b(objM1969b)) {
            return m1965a(objM1969b);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface mo1958a(android.content.Context r11, android.os.CancellationSignal r12, android.support.v4.provider.FontsContractCompat.FontInfo[] r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.mo1958a(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1957a(Context context, Resources resources, int i, String str, int i2) {
        if (!m1966a()) {
            return super.mo1957a(context, resources, i, str, i2);
        }
        Object objM1969b = m1969b();
        if (!m1967a(context, objM1969b, str, 0, -1, -1)) {
            m1971c(objM1969b);
            return null;
        }
        if (m1970b(objM1969b)) {
            return m1965a(objM1969b);
        }
        return null;
    }
}
