package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompat {

    /* JADX INFO: renamed from: a */
    private static final TypefaceCompatImpl f1855a;

    /* JADX INFO: renamed from: b */
    private static final LruCache<String, Typeface> f1856b;

    interface TypefaceCompatImpl {
        /* JADX INFO: renamed from: a */
        Typeface mo1957a(Context context, Resources resources, int i, String str, int i2);

        /* JADX INFO: renamed from: a */
        Typeface mo1958a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i);

        /* JADX INFO: renamed from: a */
        Typeface mo1959a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f1855a = new TypefaceCompatApi26Impl();
        } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.m1962a()) {
            f1855a = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1855a = new TypefaceCompatApi21Impl();
        } else {
            f1855a = new TypefaceCompatBaseImpl();
        }
        f1856b = new LruCache<>(16);
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m1955a(Resources resources, int i, int i2) {
        return f1856b.m2417a(m1956b(resources, i, i2));
    }

    /* JADX INFO: renamed from: b */
    private static String m1956b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m1954a(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typefaceMo1959a;
        boolean z2 = true;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            if (z) {
                if (providerResourceEntry.m1914b() != 0) {
                    z2 = false;
                }
            } else if (fontCallback != null) {
                z2 = false;
            }
            typefaceMo1959a = FontsContractCompat.m2333a(context, providerResourceEntry.m1913a(), fontCallback, handler, z2, z ? providerResourceEntry.m1915c() : -1, i2);
        } else {
            typefaceMo1959a = f1855a.mo1959a(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
            if (fontCallback != null) {
                if (typefaceMo1959a != null) {
                    fontCallback.m1923a(typefaceMo1959a, handler);
                } else {
                    fontCallback.m1921a(-3, handler);
                }
            }
        }
        if (typefaceMo1959a != null) {
            f1856b.m2418a(m1956b(resources, i, i2), typefaceMo1959a);
        }
        return typefaceMo1959a;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m1952a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceMo1957a = f1855a.mo1957a(context, resources, i, str, i2);
        if (typefaceMo1957a != null) {
            f1856b.m2418a(m1956b(resources, i, i2), typefaceMo1957a);
        }
        return typefaceMo1957a;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m1953a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return f1855a.mo1958a(context, cancellationSignal, fontInfoArr, i);
    }
}
