package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzchm extends zzcjl {

    /* JADX INFO: renamed from: a */
    private final String f7219a;

    /* JADX INFO: renamed from: b */
    private final char f7220b;

    /* JADX INFO: renamed from: c */
    private final long f7221c;

    /* JADX INFO: renamed from: d */
    private final zzcho f7222d;

    /* JADX INFO: renamed from: e */
    private final zzcho f7223e;

    /* JADX INFO: renamed from: f */
    private final zzcho f7224f;

    /* JADX INFO: renamed from: g */
    private final zzcho f7225g;

    /* JADX INFO: renamed from: h */
    private final zzcho f7226h;

    /* JADX INFO: renamed from: i */
    private final zzcho f7227i;

    /* JADX INFO: renamed from: j */
    private final zzcho f7228j;

    /* JADX INFO: renamed from: k */
    private final zzcho f7229k;

    /* JADX INFO: renamed from: l */
    private final zzcho f7230l;

    zzchm(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7219a = zzchc.f7177c.m8041b();
        this.f7221c = 11910L;
        if (mo7874v().m7946w()) {
            this.f7220b = 'C';
        } else {
            this.f7220b = 'c';
        }
        this.f7222d = new zzcho(this, 6, false, false);
        this.f7223e = new zzcho(this, 6, true, false);
        this.f7224f = new zzcho(this, 6, false, true);
        this.f7225g = new zzcho(this, 5, false, false);
        this.f7226h = new zzcho(this, 5, true, false);
        this.f7227i = new zzcho(this, 5, false, true);
        this.f7228j = new zzcho(this, 4, false, false);
        this.f7229k = new zzcho(this, 3, false, false);
        this.f7230l = new zzcho(this, 2, false, false);
    }

    /* JADX INFO: renamed from: a */
    protected static Object m8093a(String str) {
        if (str == null) {
            return null;
        }
        return new zzchp(str);
    }

    /* JADX INFO: renamed from: a */
    private static String m8094a(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        Object objValueOf = obj instanceof Integer ? Long.valueOf(((Integer) obj).intValue()) : obj;
        if (objValueOf instanceof Long) {
            if (z && Math.abs(((Long) objValueOf).longValue()) >= 100) {
                String str = String.valueOf(objValueOf).charAt(0) == '-' ? "-" : "";
                String strValueOf = String.valueOf(Math.abs(((Long) objValueOf).longValue()));
                return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, strValueOf.length() - 1))).append("...").append(str).append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d)).toString();
            }
            return String.valueOf(objValueOf);
        }
        if (objValueOf instanceof Boolean) {
            return String.valueOf(objValueOf);
        }
        if (!(objValueOf instanceof Throwable)) {
            return objValueOf instanceof zzchp ? ((zzchp) objValueOf).f7237a : z ? "-" : String.valueOf(objValueOf);
        }
        Throwable th = (Throwable) objValueOf;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String strM8096b = m8096b(AppMeasurement.class.getCanonicalName());
        String strM8096b2 = m8096b(zzcim.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                String strM8096b3 = m8096b(className);
                if (strM8096b3.equals(strM8096b) || strM8096b3.equals(strM8096b2)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m8095a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String strM8094a = m8094a(z, obj);
        String strM8094a2 = m8094a(z, obj2);
        String strM8094a3 = m8094a(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(strM8094a)) {
            sb.append(str2);
            sb.append(strM8094a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strM8094a2)) {
            sb.append(str2);
            sb.append(strM8094a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strM8094a3)) {
            sb.append(str2);
            sb.append(strM8094a3);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private static String m8096b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : str;
    }

    /* JADX INFO: renamed from: A */
    public final zzcho m8097A() {
        return this.f7225g;
    }

    /* JADX INFO: renamed from: B */
    public final zzcho m8098B() {
        return this.f7227i;
    }

    /* JADX INFO: renamed from: C */
    public final zzcho m8099C() {
        return this.f7228j;
    }

    /* JADX INFO: renamed from: D */
    public final zzcho m8100D() {
        return this.f7229k;
    }

    /* JADX INFO: renamed from: E */
    public final zzcho m8101E() {
        return this.f7230l;
    }

    /* JADX INFO: renamed from: F */
    public final String m8102F() {
        Pair<String, Long> pairM8140a = mo7873u().f7257b.m8140a();
        if (pairM8140a == null || pairM8140a == zzchx.f7256a) {
            return null;
        }
        String strValueOf = String.valueOf(pairM8140a.second);
        String str = (String) pairM8140a.first;
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(str).length()).append(strValueOf).append(":").append(str).toString();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    protected final void m8103a(int i, String str) {
        Log.println(i, this.f7219a, str);
    }

    /* JADX INFO: renamed from: a */
    protected final void m8104a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m8105a(i)) {
            m8103a(i, m8095a(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        zzbq.m7373a(str);
        zzcih zzcihVarM8238k = this.f7441p.m8238k();
        if (zzcihVarM8238k == null) {
            m8103a(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzcihVarM8238k.m8258P()) {
            m8103a(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        int i2 = i < 0 ? 0 : i;
        if (i2 >= 9) {
            i2 = 8;
        }
        char cCharAt = "01VDIWEA?".charAt(i2);
        char c = this.f7220b;
        long j = this.f7221c;
        String strM8095a = m8095a(true, str, obj, obj2, obj3);
        String string = new StringBuilder(String.valueOf("2").length() + 23 + String.valueOf(strM8095a).length()).append("2").append(cCharAt).append(c).append(j).append(":").append(strM8095a).toString();
        if (string.length() > 1024) {
            string = str.substring(0, 1024);
        }
        zzcihVarM8238k.m8173a(new zzchn(this, string));
    }

    /* JADX INFO: renamed from: a */
    protected final boolean m8105a(int i) {
        return Log.isLoggable(this.f7219a, i);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
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

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
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
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final zzcho m8106y() {
        return this.f7222d;
    }

    /* JADX INFO: renamed from: z */
    public final zzcho m8107z() {
        return this.f7223e;
    }
}
