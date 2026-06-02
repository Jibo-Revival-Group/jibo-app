package android.support.v4.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.provider.SelfDestructiveThread;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat {

    /* JADX INFO: renamed from: a */
    private static final LruCache<String, Typeface> f2124a = new LruCache<>(16);

    /* JADX INFO: renamed from: b */
    private static final SelfDestructiveThread f2125b = new SelfDestructiveThread("fonts", 10, 10000);

    /* JADX INFO: renamed from: c */
    private static final Object f2126c = new Object();

    /* JADX INFO: renamed from: d */
    private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> f2127d = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: e */
    private static final Comparator<byte[]> f2128e = new Comparator<byte[]>() { // from class: android.support.v4.provider.FontsContractCompat.5
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static TypefaceResult m2342b(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fontFamilyResultM2334a = m2334a(context, (CancellationSignal) null, fontRequest);
            if (fontFamilyResultM2334a.m2348a() == 0) {
                Typeface typefaceM1953a = TypefaceCompat.m1953a(context, null, fontFamilyResultM2334a.m2349b(), i);
                return new TypefaceResult(typefaceM1953a, typefaceM1953a != null ? 0 : -3);
            }
            return new TypefaceResult(null, fontFamilyResultM2334a.m2348a() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException e) {
            return new TypefaceResult(null, -1);
        }
    }

    private static final class TypefaceResult {

        /* JADX INFO: renamed from: a */
        final Typeface f2143a;

        /* JADX INFO: renamed from: b */
        final int f2144b;

        TypefaceResult(Typeface typeface, int i) {
            this.f2143a = typeface;
            this.f2144b = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m2333a(final Context context, final FontRequest fontRequest, final ResourcesCompat.FontCallback fontCallback, final Handler handler, boolean z, int i, final int i2) {
        final String str = fontRequest.m2331f() + "-" + i2;
        Typeface typefaceM2417a = f2124a.m2417a(str);
        if (typefaceM2417a != null) {
            if (fontCallback != null) {
                fontCallback.mo1922a(typefaceM2417a);
            }
            return typefaceM2417a;
        }
        if (z && i == -1) {
            TypefaceResult typefaceResultM2342b = m2342b(context, fontRequest, i2);
            if (fontCallback != null) {
                if (typefaceResultM2342b.f2144b == 0) {
                    fontCallback.m1923a(typefaceResultM2342b.f2143a, handler);
                } else {
                    fontCallback.m1921a(typefaceResultM2342b.f2144b, handler);
                }
            }
            return typefaceResultM2342b.f2143a;
        }
        Callable<TypefaceResult> callable = new Callable<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TypefaceResult call() throws Exception {
                TypefaceResult typefaceResultM2342b2 = FontsContractCompat.m2342b(context, fontRequest, i2);
                if (typefaceResultM2342b2.f2143a != null) {
                    FontsContractCompat.f2124a.m2418a(str, typefaceResultM2342b2.f2143a);
                }
                return typefaceResultM2342b2;
            }
        };
        if (z) {
            try {
                return ((TypefaceResult) f2125b.m2360a(callable, i)).f2143a;
            } catch (InterruptedException e) {
                return null;
            }
        }
        SelfDestructiveThread.ReplyCallback<TypefaceResult> replyCallback = fontCallback == null ? null : new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.2
            @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2346a(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    fontCallback.m1921a(1, handler);
                } else if (typefaceResult.f2144b == 0) {
                    fontCallback.m1923a(typefaceResult.f2143a, handler);
                } else {
                    fontCallback.m1921a(typefaceResult.f2144b, handler);
                }
            }
        };
        synchronized (f2126c) {
            if (f2127d.containsKey(str)) {
                if (replyCallback != null) {
                    f2127d.get(str).add(replyCallback);
                }
                return null;
            }
            if (replyCallback != null) {
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = new ArrayList<>();
                arrayList.add(replyCallback);
                f2127d.put(str, arrayList);
            }
            f2125b.m2361a(callable, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.3
                @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo2346a(TypefaceResult typefaceResult) {
                    synchronized (FontsContractCompat.f2126c) {
                        ArrayList arrayList2 = (ArrayList) FontsContractCompat.f2127d.get(str);
                        if (arrayList2 != null) {
                            FontsContractCompat.f2127d.remove(str);
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < arrayList2.size()) {
                                    ((SelfDestructiveThread.ReplyCallback) arrayList2.get(i4)).mo2346a(typefaceResult);
                                    i3 = i4 + 1;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            });
            return null;
        }
    }

    public static class FontInfo {

        /* JADX INFO: renamed from: a */
        private final Uri f2138a;

        /* JADX INFO: renamed from: b */
        private final int f2139b;

        /* JADX INFO: renamed from: c */
        private final int f2140c;

        /* JADX INFO: renamed from: d */
        private final boolean f2141d;

        /* JADX INFO: renamed from: e */
        private final int f2142e;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.f2138a = (Uri) Preconditions.m2441a(uri);
            this.f2139b = i;
            this.f2140c = i2;
            this.f2141d = z;
            this.f2142e = i3;
        }

        /* JADX INFO: renamed from: a */
        public Uri m2350a() {
            return this.f2138a;
        }

        /* JADX INFO: renamed from: b */
        public int m2351b() {
            return this.f2139b;
        }

        /* JADX INFO: renamed from: c */
        public int m2352c() {
            return this.f2140c;
        }

        /* JADX INFO: renamed from: d */
        public boolean m2353d() {
            return this.f2141d;
        }

        /* JADX INFO: renamed from: e */
        public int m2354e() {
            return this.f2142e;
        }
    }

    public static class FontFamilyResult {

        /* JADX INFO: renamed from: a */
        private final int f2136a;

        /* JADX INFO: renamed from: b */
        private final FontInfo[] f2137b;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.f2136a = i;
            this.f2137b = fontInfoArr;
        }

        /* JADX INFO: renamed from: a */
        public int m2348a() {
            return this.f2136a;
        }

        /* JADX INFO: renamed from: b */
        public FontInfo[] m2349b() {
            return this.f2137b;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Map<Uri, ByteBuffer> m2339a(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.m2354e() == 0) {
                Uri uriM2350a = fontInfo.m2350a();
                if (!map.containsKey(uriM2350a)) {
                    map.put(uriM2350a, TypefaceCompatUtil.m1980a(context, cancellationSignal, uriM2350a));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: a */
    public static FontFamilyResult m2334a(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM2332a = m2332a(context.getPackageManager(), fontRequest, context.getResources());
        if (providerInfoM2332a == null) {
            return new FontFamilyResult(1, null);
        }
        return new FontFamilyResult(0, m2341a(context, fontRequest, providerInfoM2332a.authority, cancellationSignal));
    }

    /* JADX INFO: renamed from: a */
    public static ProviderInfo m2332a(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        int i = 0;
        String strM2326a = fontRequest.m2326a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM2326a, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM2326a);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fontRequest.m2327b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM2326a + ", but package was not " + fontRequest.m2327b());
        }
        List<byte[]> listM2338a = m2338a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listM2338a, f2128e);
        List<List<byte[]>> listM2337a = m2337a(fontRequest, resources);
        while (true) {
            int i2 = i;
            if (i2 < listM2337a.size()) {
                ArrayList arrayList = new ArrayList(listM2337a.get(i2));
                Collections.sort(arrayList, f2128e);
                if (m2340a(listM2338a, arrayList)) {
                    return providerInfoResolveContentProvider;
                }
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static List<List<byte[]>> m2337a(FontRequest fontRequest, Resources resources) {
        if (fontRequest.m2329d() != null) {
            return fontRequest.m2329d();
        }
        return FontResourcesParserCompat.m1902a(resources, fontRequest.m2330e());
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2340a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static List<byte[]> m2338a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static android.support.v4.provider.FontsContractCompat.FontInfo[] m2341a(android.content.Context r18, android.support.v4.provider.FontRequest r19, java.lang.String r20, android.os.CancellationSignal r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.m2341a(android.content.Context, android.support.v4.provider.FontRequest, java.lang.String, android.os.CancellationSignal):android.support.v4.provider.FontsContractCompat$FontInfo[]");
    }
}
