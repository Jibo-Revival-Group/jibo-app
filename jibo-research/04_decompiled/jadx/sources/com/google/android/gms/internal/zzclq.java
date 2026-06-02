package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public final class zzclq extends zzcjl {

    /* JADX INFO: renamed from: a */
    private static String[] f7611a = {"firebase_"};

    /* JADX INFO: renamed from: b */
    private SecureRandom f7612b;

    /* JADX INFO: renamed from: c */
    private final AtomicLong f7613c;

    /* JADX INFO: renamed from: d */
    private int f7614d;

    zzclq(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7613c = new AtomicLong(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[ORIG_RETURN, RETURN] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int m8384a(java.lang.String r8, java.lang.Object r9, boolean r10) {
        /*
            r7 = this;
            r1 = 1
            r6 = 0
            if (r10 == 0) goto L39
            java.lang.String r2 = "param"
            boolean r0 = r9 instanceof android.os.Parcelable[]
            if (r0 == 0) goto L29
            r0 = r9
            android.os.Parcelable[] r0 = (android.os.Parcelable[]) r0
            int r0 = r0.length
        Le:
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r0 <= r3) goto L37
            com.google.android.gms.internal.zzchm r1 = r7.mo7872t()
            com.google.android.gms.internal.zzcho r1 = r1.m8097A()
            java.lang.String r3 = "Parameter array is too long; discarded. Value kind, name, array length"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.m8111a(r3, r2, r8, r0)
            r0 = r6
        L24:
            if (r0 != 0) goto L39
            r0 = 17
        L28:
            return r0
        L29:
            boolean r0 = r9 instanceof java.util.ArrayList
            if (r0 == 0) goto L35
            r0 = r9
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            goto Le
        L35:
            r0 = r1
            goto L24
        L37:
            r0 = r1
            goto L24
        L39:
            boolean r0 = m8410i(r8)
            if (r0 == 0) goto L4f
            java.lang.String r1 = "param"
            r3 = 256(0x100, float:3.59E-43)
            r0 = r7
            r2 = r8
            r4 = r9
            r5 = r10
            boolean r0 = r0.m8397a(r1, r2, r3, r4, r5)
        L4b:
            if (r0 == 0) goto L5c
            r0 = r6
            goto L28
        L4f:
            java.lang.String r1 = "param"
            r3 = 100
            r0 = r7
            r2 = r8
            r4 = r9
            r5 = r10
            boolean r0 = r0.m8397a(r1, r2, r3, r4, r5)
            goto L4b
        L5c:
            r0 = 4
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.m8384a(java.lang.String, java.lang.Object, boolean):int");
    }

    /* JADX INFO: renamed from: a */
    private static Object m8385a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return m8387a(String.valueOf(obj), i, z);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static Object m8386a(zzcmb zzcmbVar, String str) {
        for (zzcmc zzcmcVar : zzcmbVar.f7663a) {
            if (zzcmcVar.f7669a.equals(str)) {
                if (zzcmcVar.f7670b != null) {
                    return zzcmcVar.f7670b;
                }
                if (zzcmcVar.f7671c != null) {
                    return zzcmcVar.f7671c;
                }
                if (zzcmcVar.f7672d != null) {
                    return zzcmcVar.f7672d;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m8387a(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m8388a(String str, String[] strArr, String[] strArr2) {
        zzbq.m7373a(strArr);
        zzbq.m7373a(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            if (m8396a(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m8389a(Bundle bundle, Object obj) {
        zzbq.m7373a(bundle);
        if (obj != null) {
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                bundle.putLong("_el", String.valueOf(obj).length());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8390a(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 4)) == null) {
                return false;
            }
            return serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8391a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8392a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    /* JADX INFO: renamed from: a */
    static boolean m8393a(zzcha zzchaVar, zzcgi zzcgiVar) {
        zzbq.m7373a(zzchaVar);
        zzbq.m7373a(zzcgiVar);
        return !TextUtils.isEmpty(zzcgiVar.f7088b);
    }

    /* JADX INFO: renamed from: a */
    static boolean m8394a(String str) {
        zzbq.m7375a(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8395a(String str, int i, String str2) {
        if (str2 == null) {
            mo7872t().m8106y().m8109a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        mo7872t().m8106y().m8111a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8396a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8397a(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) <= i) {
                return true;
            }
            mo7872t().m8097A().m8111a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
            return false;
        }
        if ((obj instanceof Bundle) && z) {
            return true;
        }
        if ((obj instanceof Parcelable[]) && z) {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    mo7872t().m8097A().m8110a("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof ArrayList) || !z) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            if (!(obj2 instanceof Bundle)) {
                mo7872t().m8097A().m8110a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8398a(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            mo7872t().m8106y().m8109a("Name is required and can't be null. Type", str);
            return false;
        }
        zzbq.m7373a(str2);
        int i = 0;
        while (true) {
            if (i >= f7611a.length) {
                z = false;
                break;
            }
            if (str2.startsWith(f7611a[i])) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            mo7872t().m8106y().m8110a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            zzbq.m7373a(strArr);
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z2 = false;
                    break;
                }
                if (m8396a(str2, strArr[i2])) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                mo7872t().m8106y().m8110a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8399a(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    /* JADX INFO: renamed from: a */
    static byte[] m8400a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public static long[] m8401a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64 && (i << 6) + i2 < bitSet.length(); i2++) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle[] m8402a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: renamed from: a */
    static zzcmc[] m8403a(zzcmc[] zzcmcVarArr, String str, Object obj) {
        for (zzcmc zzcmcVar : zzcmcVarArr) {
            if (Objects.equals(zzcmcVar.f7669a, str)) {
                zzcmcVar.f7671c = null;
                zzcmcVar.f7670b = null;
                zzcmcVar.f7672d = null;
                if (obj instanceof Long) {
                    zzcmcVar.f7671c = (Long) obj;
                    return zzcmcVarArr;
                }
                if (obj instanceof String) {
                    zzcmcVar.f7670b = (String) obj;
                    return zzcmcVarArr;
                }
                if (!(obj instanceof Double)) {
                    return zzcmcVarArr;
                }
                zzcmcVar.f7672d = (Double) obj;
                return zzcmcVarArr;
            }
        }
        zzcmc[] zzcmcVarArr2 = new zzcmc[zzcmcVarArr.length + 1];
        System.arraycopy(zzcmcVarArr, 0, zzcmcVarArr2, 0, zzcmcVarArr.length);
        zzcmc zzcmcVar2 = new zzcmc();
        zzcmcVar2.f7669a = str;
        if (obj instanceof Long) {
            zzcmcVar2.f7671c = (Long) obj;
        } else if (obj instanceof String) {
            zzcmcVar2.f7670b = (String) obj;
        } else if (obj instanceof Double) {
            zzcmcVar2.f7672d = (Double) obj;
        }
        zzcmcVarArr2[zzcmcVarArr.length] = zzcmcVar2;
        return zzcmcVarArr2;
    }

    /* JADX INFO: renamed from: b */
    public static Object m8404b(Object obj) throws Throwable {
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        try {
            if (obj == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
                try {
                    Object object = objectInputStream.readObject();
                    objectOutputStream.close();
                    objectInputStream.close();
                    return object;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                objectOutputStream = null;
            }
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private final boolean m8405b(String str, String str2) {
        if (str2 == null) {
            mo7872t().m8106y().m8109a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo7872t().m8106y().m8109a("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            mo7872t().m8106y().m8110a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo7872t().m8106y().m8110a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    static long m8406c(byte[] bArr) {
        int i = 0;
        zzbq.m7373a(bArr);
        zzbq.m7378a(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: renamed from: c */
    private final boolean m8407c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoM7814b = zzbhf.m7816a(context).m7814b(str, 64);
            if (packageInfoM7814b != null && packageInfoM7814b.signatures != null && packageInfoM7814b.signatures.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfoM7814b.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (PackageManager.NameNotFoundException e) {
            mo7872t().m8106y().m8109a("Package name not found", e);
        } catch (CertificateException e2) {
            mo7872t().m8106y().m8109a("Error obtaining certificate", e2);
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    private final boolean m8408c(String str, String str2) {
        if (str2 == null) {
            mo7872t().m8106y().m8109a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo7872t().m8106y().m8109a("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            mo7872t().m8106y().m8110a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo7872t().m8106y().m8110a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    static MessageDigest m8409g(String str) {
        MessageDigest messageDigest;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: i */
    public static boolean m8410i(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: renamed from: k */
    static boolean m8411k(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: renamed from: n */
    static boolean m8412n(String str) {
        zzbq.m7375a(str);
        switch (str) {
            case "_in":
            case "_ui":
            case "_ug":
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: o */
    private final int m8413o(String str) {
        if (!m8405b("event param", str)) {
            return 3;
        }
        if (m8398a("event param", (String[]) null, str)) {
            return m8395a("event param", 40, str) ? 0 : 3;
        }
        return 14;
    }

    /* JADX INFO: renamed from: p */
    private final int m8414p(String str) {
        if (!m8408c("event param", str)) {
            return 3;
        }
        if (m8398a("event param", (String[]) null, str)) {
            return m8395a("event param", 40, str) ? 0 : 3;
        }
        return 14;
    }

    /* JADX INFO: renamed from: q */
    private static int m8415q(String str) {
        return "_ldl".equals(str) ? 2048 : 36;
    }

    /* JADX INFO: renamed from: a */
    public final Bundle m8416a(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        Bundle bundle = null;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter4 = uri.getQueryParameter("utm_campaign");
                    queryParameter3 = uri.getQueryParameter("utm_source");
                    queryParameter2 = uri.getQueryParameter("utm_medium");
                    queryParameter = uri.getQueryParameter("gclid");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                }
                if (!TextUtils.isEmpty(queryParameter4) || !TextUtils.isEmpty(queryParameter3) || !TextUtils.isEmpty(queryParameter2) || !TextUtils.isEmpty(queryParameter)) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("campaign", queryParameter4);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString(ShareConstants.FEED_SOURCE_PARAM, queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("medium", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("gclid", queryParameter);
                    }
                    String queryParameter5 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("term", queryParameter5);
                    }
                    String queryParameter6 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        bundle.putString("content", queryParameter6);
                    }
                    String queryParameter7 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        bundle.putString("aclid", queryParameter7);
                    }
                    String queryParameter8 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter8)) {
                        bundle.putString("cp1", queryParameter8);
                    }
                    String queryParameter9 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter9)) {
                        bundle.putString("anid", queryParameter9);
                    }
                }
            } catch (UnsupportedOperationException e) {
                mo7872t().m8097A().m8109a("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    final Bundle m8417a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objM8421a = m8421a(str, bundle.get(str));
                if (objM8421a == null) {
                    mo7872t().m8097A().m8109a("Param value can't be null", mo7867o().m8091b(str));
                } else {
                    m8423a(bundle2, str, objM8421a);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: renamed from: a */
    public final Bundle m8418a(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            if (list == null || !list.contains(str2)) {
                iM8413o = z ? m8413o(str2) : 0;
                if (iM8413o == 0) {
                    iM8413o = m8414p(str2);
                }
            }
            if (iM8413o != 0) {
                if (m8392a(bundle2, iM8413o)) {
                    bundle2.putString("_ev", m8387a(str2, 40, true));
                    if (iM8413o == 3) {
                        m8389a(bundle2, str2);
                    }
                }
                bundle2.remove(str2);
            } else {
                int iM8384a = m8384a(str2, bundle.get(str2), z2);
                if (iM8384a != 0 && !"_ev".equals(str2)) {
                    if (m8392a(bundle2, iM8384a)) {
                        bundle2.putString("_ev", m8387a(str2, 40, true));
                        m8389a(bundle2, bundle.get(str2));
                    }
                    bundle2.remove(str2);
                } else if (!m8394a(str2) || (i = i + 1) <= 25) {
                    i = i;
                } else {
                    mo7872t().m8106y().m8110a(new StringBuilder(48).append("Event can't contain more then 25 params").toString(), mo7867o().m8090a(str), mo7867o().m8084a(bundle));
                    m8392a(bundle2, 5);
                    bundle2.remove(str2);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: renamed from: a */
    final <T extends Parcelable> T m8419a(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (zzbfo e) {
            mo7872t().m8106y().m8108a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    final zzcha m8420a(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (m8434c(str) != 0) {
            mo7872t().m8106y().m8109a("Invalid conditional property event name", mo7867o().m8092c(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new zzcha(str, new zzcgx(m8417a(m8418a(str, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    /* JADX INFO: renamed from: a */
    public final Object m8421a(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m8385a(256, obj, true);
        }
        return m8385a(m8410i(str) ? 256 : 100, obj, false);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8422a(int i, String str, String str2, int i2) {
        m8426a((String) null, i, str, str2, i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8423a(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (str != null) {
            mo7872t().m8098B().m8110a("Not putting event parameter. Invalid value type. name, type", mo7867o().m8091b(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8424a(zzcmc zzcmcVar, Object obj) {
        zzbq.m7373a(obj);
        zzcmcVar.f7670b = null;
        zzcmcVar.f7671c = null;
        zzcmcVar.f7672d = null;
        if (obj instanceof String) {
            zzcmcVar.f7670b = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzcmcVar.f7671c = (Long) obj;
        } else if (obj instanceof Double) {
            zzcmcVar.f7672d = (Double) obj;
        } else {
            mo7872t().m8106y().m8109a("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8425a(zzcmg zzcmgVar, Object obj) {
        zzbq.m7373a(obj);
        zzcmgVar.f7716c = null;
        zzcmgVar.f7717d = null;
        zzcmgVar.f7718e = null;
        if (obj instanceof String) {
            zzcmgVar.f7716c = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzcmgVar.f7717d = (Long) obj;
        } else if (obj instanceof Double) {
            zzcmgVar.f7718e = (Double) obj;
        } else {
            mo7872t().m8106y().m8109a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8426a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m8392a(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        this.f7441p.m8239l().m8289a("auto", "_err", bundle);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8427a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo7863k().mo7496a() - j) > j2;
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m8428a(zzcmd zzcmdVar) {
        try {
            byte[] bArr = new byte[zzcmdVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzcmdVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            return bArr;
        } catch (IOException e) {
            mo7872t().m8106y().m8109a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m8429a(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo7872t().m8106y().m8109a("Failed to gzip content", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m8430b(String str) {
        if (!m8405b("event", str)) {
            return 2;
        }
        if (m8398a("event", AppMeasurement.Event.f8390a, str)) {
            return m8395a("event", 40, str) ? 0 : 2;
        }
        return 13;
    }

    /* JADX INFO: renamed from: b */
    public final int m8431b(String str, Object obj) {
        return "_ldl".equals(str) ? m8397a("user property referrer", str, m8415q(str), obj, false) : m8397a("user property", str, m8415q(str), obj, false) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006b -> B:18:0x0078). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final long m8432b(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = -1
            r8.mo7855c()
            com.google.android.gms.common.internal.zzbq.m7373a(r9)
            com.google.android.gms.common.internal.zzbq.m7375a(r10)
            r2 = 0
            android.content.pm.PackageManager r4 = r9.getPackageManager()
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = m8409g(r5)
            if (r5 != 0) goto L27
            com.google.android.gms.internal.zzchm r2 = r8.mo7872t()
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()
            java.lang.String r3 = "Could not get MD5 instance"
            r2.m8108a(r3)
        L26:
            return r0
        L27:
            if (r4 == 0) goto L78
            boolean r4 = r8.m8407c(r9, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            if (r4 != 0) goto L78
            com.google.android.gms.internal.zzbhe r4 = com.google.android.gms.internal.zzbhf.m7816a(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            android.content.Context r6 = r8.mo7864l()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            java.lang.String r6 = r6.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            r7 = 64
            android.content.pm.PackageInfo r4 = r4.m7814b(r6, r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            android.content.pm.Signature[] r6 = r4.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            if (r6 == 0) goto L5c
            android.content.pm.Signature[] r6 = r4.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            int r6 = r6.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            if (r6 <= 0) goto L5c
            android.content.pm.Signature[] r0 = r4.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            r1 = 0
            r0 = r0[r1]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            byte[] r0 = r0.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            byte[] r0 = r5.digest(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            long r0 = m8406c(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            goto L26
        L5c:
            com.google.android.gms.internal.zzchm r4 = r8.mo7872t()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            com.google.android.gms.internal.zzcho r4 = r4.m8097A()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            java.lang.String r5 = "Could not get signatures"
            r4.m8108a(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            goto L26
        L6a:
            r0 = move-exception
            com.google.android.gms.internal.zzchm r1 = r8.mo7872t()
            com.google.android.gms.internal.zzcho r1 = r1.m8106y()
            java.lang.String r4 = "Package name not found"
            r1.m8109a(r4, r0)
        L78:
            r0 = r2
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.m8432b(android.content.Context, java.lang.String):long");
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: b */
    public final byte[] m8433b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            mo7872t().m8106y().m8109a("Failed to ungzip content", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m8434c(String str) {
        if (!m8408c("event", str)) {
            return 2;
        }
        if (m8398a("event", AppMeasurement.Event.f8390a, str)) {
            return m8395a("event", 40, str) ? 0 : 2;
        }
        return 13;
    }

    /* JADX INFO: renamed from: c */
    public final Object m8435c(String str, Object obj) {
        return "_ldl".equals(str) ? m8385a(m8415q(str), obj, true) : m8385a(m8415q(str), obj, false);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    /* JADX INFO: renamed from: d */
    public final int m8436d(String str) {
        if (!m8405b("user property", str)) {
            return 6;
        }
        if (m8398a("user property", AppMeasurement.UserProperty.f8394a, str)) {
            return m8395a("user property", 24, str) ? 0 : 6;
        }
        return 15;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: d_ */
    protected final void mo8063d_() {
        mo7855c();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                mo7872t().m8097A().m8108a("Utils falling back to Random for random id");
            }
        }
        this.f7613c.set(jNextLong);
    }

    /* JADX INFO: renamed from: e */
    public final int m8437e(String str) {
        if (!m8408c("user property", str)) {
            return 6;
        }
        if (m8398a("user property", AppMeasurement.UserProperty.f8394a, str)) {
            return m8395a("user property", 24, str) ? 0 : 6;
        }
        return 15;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    /* JADX INFO: renamed from: f */
    public final boolean m8438f(String str) {
        if (TextUtils.isEmpty(str)) {
            mo7872t().m8106y().m8108a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbq.m7373a(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        mo7872t().m8106y().m8109a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    /* JADX INFO: renamed from: h */
    public final boolean m8439h(String str) {
        mo7855c();
        if (zzbhf.m7816a(mo7864l()).m7809a(str) == 0) {
            return true;
        }
        mo7872t().m8100D().m8109a("Permission not granted", str);
        return false;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    /* JADX INFO: renamed from: j */
    public final boolean m8440j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return mo7874v().m7940A().equals(str);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    /* JADX INFO: renamed from: l */
    final boolean m8441l(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(mo7869q().m8153a(str, "measurement.upload.blacklist_internal"));
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    /* JADX INFO: renamed from: m */
    final boolean m8442m(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(mo7869q().m8153a(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return true;
    }

    /* JADX INFO: renamed from: y */
    public final long m8443y() {
        long andIncrement;
        if (this.f7613c.get() == 0) {
            synchronized (this.f7613c) {
                long jNextLong = new Random(System.nanoTime() ^ mo7863k().mo7496a()).nextLong();
                int i = this.f7614d + 1;
                this.f7614d = i;
                andIncrement = jNextLong + ((long) i);
            }
        } else {
            synchronized (this.f7613c) {
                this.f7613c.compareAndSet(-1L, 1L);
                andIncrement = this.f7613c.getAndIncrement();
            }
        }
        return andIncrement;
    }

    /* JADX INFO: renamed from: z */
    final SecureRandom m8444z() {
        mo7855c();
        if (this.f7612b == null) {
            this.f7612b = new SecureRandom();
        }
        return this.f7612b;
    }
}
