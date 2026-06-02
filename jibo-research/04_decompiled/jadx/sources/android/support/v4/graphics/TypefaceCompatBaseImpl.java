package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class TypefaceCompatBaseImpl implements TypefaceCompat.TypefaceCompatImpl {

    private interface StyleExtractor<T> {
        /* JADX INFO: renamed from: a */
        boolean mo1976a(T t);

        /* JADX INFO: renamed from: b */
        int mo1977b(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m1973a(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        T t;
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t2 = null;
        int i3 = Integer.MAX_VALUE;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t3 = tArr[i4];
            int iAbs = (styleExtractor.mo1976a(t3) == z ? 0 : 1) + (Math.abs(styleExtractor.mo1977b(t3) - i2) * 2);
            if (t2 == null || i3 > iAbs) {
                i3 = iAbs;
                t = t3;
            } else {
                t = t2;
            }
            i4++;
            t2 = t;
        }
        return t2;
    }

    /* JADX INFO: renamed from: a */
    protected FontsContractCompat.FontInfo m1975a(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) m1973a(fontInfoArr, i, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.1
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo1977b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.m2352c();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo1976a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.m2353d();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected Typeface m1974a(Context context, InputStream inputStream) {
        Typeface typefaceCreateFromFile = null;
        File fileM1978a = TypefaceCompatUtil.m1978a(context);
        if (fileM1978a != null) {
            try {
                if (TypefaceCompatUtil.m1984a(fileM1978a, inputStream)) {
                    typefaceCreateFromFile = Typeface.createFromFile(fileM1978a.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                fileM1978a.delete();
            }
        }
        return typefaceCreateFromFile;
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1958a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Throwable th;
        Typeface typefaceM1974a = null;
        if (fontInfoArr.length >= 1) {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(m1975a(fontInfoArr, i).m2350a());
            } catch (IOException e) {
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                inputStreamOpenInputStream = null;
                th = th2;
            }
            try {
                typefaceM1974a = m1974a(context, inputStreamOpenInputStream);
                TypefaceCompatUtil.m1982a(inputStreamOpenInputStream);
            } catch (IOException e2) {
                TypefaceCompatUtil.m1982a(inputStreamOpenInputStream);
            } catch (Throwable th3) {
                th = th3;
                TypefaceCompatUtil.m1982a(inputStreamOpenInputStream);
                throw th;
            }
        }
        return typefaceM1974a;
    }

    /* JADX INFO: renamed from: a */
    private FontResourcesParserCompat.FontFileResourceEntry m1972a(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) m1973a(fontFamilyFilesResourceEntry.m1908a(), i, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.2
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo1977b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.m1910b();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo1976a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.m1911c();
            }
        });
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1959a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntryM1972a = m1972a(fontFamilyFilesResourceEntry, i);
        if (fontFileResourceEntryM1972a == null) {
            return null;
        }
        return TypefaceCompat.m1952a(context, resources, fontFileResourceEntryM1972a.m1912d(), fontFileResourceEntryM1972a.m1909a(), i);
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* JADX INFO: renamed from: a */
    public Typeface mo1957a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceCreateFromFile = null;
        File fileM1978a = TypefaceCompatUtil.m1978a(context);
        if (fileM1978a != null) {
            try {
                if (TypefaceCompatUtil.m1983a(fileM1978a, resources, i)) {
                    typefaceCreateFromFile = Typeface.createFromFile(fileM1978a.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                fileM1978a.delete();
            }
        }
        return typefaceCreateFromFile;
    }
}
