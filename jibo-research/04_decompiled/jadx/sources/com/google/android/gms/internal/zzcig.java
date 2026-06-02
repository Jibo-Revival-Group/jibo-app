package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcig extends zzcjl {

    /* JADX INFO: renamed from: a */
    private static int f7305a = 65535;

    /* JADX INFO: renamed from: b */
    private static int f7306b = 2;

    /* JADX INFO: renamed from: c */
    private final Map<String, Map<String, String>> f7307c;

    /* JADX INFO: renamed from: d */
    private final Map<String, Map<String, Boolean>> f7308d;

    /* JADX INFO: renamed from: e */
    private final Map<String, Map<String, Boolean>> f7309e;

    /* JADX INFO: renamed from: f */
    private final Map<String, zzcly> f7310f;

    /* JADX INFO: renamed from: g */
    private final Map<String, Map<String, Integer>> f7311g;

    /* JADX INFO: renamed from: h */
    private final Map<String, String> f7312h;

    zzcig(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7307c = new ArrayMap();
        this.f7308d = new ArrayMap();
        this.f7309e = new ArrayMap();
        this.f7310f = new ArrayMap();
        this.f7312h = new ArrayMap();
        this.f7311g = new ArrayMap();
    }

    /* JADX INFO: renamed from: a */
    private final zzcly m8148a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzcly();
        }
        zzfjj zzfjjVarM8617a = zzfjj.m8617a(bArr, 0, bArr.length);
        zzcly zzclyVar = new zzcly();
        try {
            zzclyVar.mo8446a(zzfjjVarM8617a);
            mo7872t().m8101E().m8110a("Parsed config. version, gmp_app_id", zzclyVar.f7648a, zzclyVar.f7649b);
            return zzclyVar;
        } catch (IOException e) {
            mo7872t().m8097A().m8110a("Unable to merge remote config. appId", zzchm.m8093a(str), e);
            return new zzcly();
        }
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, String> m8149a(zzcly zzclyVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzclyVar != null && zzclyVar.f7650c != null) {
            for (zzclz zzclzVar : zzclyVar.f7650c) {
                if (zzclzVar != null) {
                    arrayMap.put(zzclzVar.f7655a, zzclzVar.f7656b);
                }
            }
        }
        return arrayMap;
    }

    /* JADX INFO: renamed from: a */
    private final void m8150a(String str, zzcly zzclyVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzclyVar != null && zzclyVar.f7651d != null) {
            for (zzclx zzclxVar : zzclyVar.f7651d) {
                if (TextUtils.isEmpty(zzclxVar.f7644a)) {
                    mo7872t().m8097A().m8108a("EventConfig contained null event name");
                } else {
                    String strM8916a = AppMeasurement.Event.m8916a(zzclxVar.f7644a);
                    if (!TextUtils.isEmpty(strM8916a)) {
                        zzclxVar.f7644a = strM8916a;
                    }
                    arrayMap.put(zzclxVar.f7644a, zzclxVar.f7645b);
                    arrayMap2.put(zzclxVar.f7644a, zzclxVar.f7646c);
                    if (zzclxVar.f7647d != null) {
                        if (zzclxVar.f7647d.intValue() < f7306b || zzclxVar.f7647d.intValue() > f7305a) {
                            mo7872t().m8097A().m8110a("Invalid sampling rate. Event name, sample rate", zzclxVar.f7644a, zzclxVar.f7647d);
                        } else {
                            arrayMap3.put(zzclxVar.f7644a, zzclxVar.f7647d);
                        }
                    }
                }
            }
        }
        this.f7308d.put(str, arrayMap);
        this.f7309e.put(str, arrayMap2);
        this.f7311g.put(str, arrayMap3);
    }

    /* JADX INFO: renamed from: e */
    private final void m8151e(String str) throws Throwable {
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        if (this.f7310f.get(str) == null) {
            byte[] bArrM7999d = mo7866n().m7999d(str);
            if (bArrM7999d != null) {
                zzcly zzclyVarM8148a = m8148a(str, bArrM7999d);
                this.f7307c.put(str, m8149a(zzclyVarM8148a));
                m8150a(str, zzclyVarM8148a);
                this.f7310f.put(str, zzclyVarM8148a);
                this.f7312h.put(str, null);
                return;
            }
            this.f7307c.put(str, null);
            this.f7308d.put(str, null);
            this.f7309e.put(str, null);
            this.f7310f.put(str, null);
            this.f7312h.put(str, null);
            this.f7311g.put(str, null);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final zzcly m8152a(String str) {
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        m8151e(str);
        return this.f7310f.get(str);
    }

    /* JADX INFO: renamed from: a */
    final String m8153a(String str, String str2) {
        mo7855c();
        m8151e(str);
        Map<String, String> map = this.f7307c.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    protected final boolean m8154a(String str, byte[] bArr, String str2) {
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        zzcly zzclyVarM8148a = m8148a(str, bArr);
        if (zzclyVarM8148a == null) {
            return false;
        }
        m8150a(str, zzclyVarM8148a);
        this.f7310f.put(str, zzclyVarM8148a);
        this.f7312h.put(str, str2);
        this.f7307c.put(str, m8149a(zzclyVarM8148a));
        zzcgk zzcgkVarMo7857e = mo7857e();
        zzclr[] zzclrVarArr = zzclyVarM8148a.f7652e;
        zzbq.m7373a(zzclrVarArr);
        for (zzclr zzclrVar : zzclrVarArr) {
            for (zzcls zzclsVar : zzclrVar.f7618c) {
                String strM8916a = AppMeasurement.Event.m8916a(zzclsVar.f7621b);
                if (strM8916a != null) {
                    zzclsVar.f7621b = strM8916a;
                }
                zzclt[] zzcltVarArr = zzclsVar.f7622c;
                for (zzclt zzcltVar : zzcltVarArr) {
                    String strM8919a = AppMeasurement.Param.m8919a(zzcltVar.f7629d);
                    if (strM8919a != null) {
                        zzcltVar.f7629d = strM8919a;
                    }
                }
            }
            for (zzclv zzclvVar : zzclrVar.f7617b) {
                String strM8920a = AppMeasurement.UserProperty.m8920a(zzclvVar.f7637b);
                if (strM8920a != null) {
                    zzclvVar.f7637b = strM8920a;
                }
            }
        }
        zzcgkVarMo7857e.mo7866n().m7987a(str, zzclrVarArr);
        try {
            zzclyVarM8148a.f7652e = null;
            byte[] bArr2 = new byte[zzclyVarM8148a.m8713f()];
            zzclyVarM8148a.mo8447a(zzfjk.m8648a(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            mo7872t().m8097A().m8110a("Unable to serialize reduced-size config. Storing full config instead. appId", zzchm.m8093a(str), e);
        }
        zzcgo zzcgoVarMo7866n = mo7866n();
        zzbq.m7375a(str);
        zzcgoVarMo7866n.mo7855c();
        zzcgoVarMo7866n.m8259Q();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzcgoVarMo7866n.m7968A().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                zzcgoVarMo7866n.mo7872t().m8106y().m8109a("Failed to update remote config (got 0). appId", zzchm.m8093a(str));
            }
        } catch (SQLiteException e2) {
            zzcgoVarMo7866n.mo7872t().m8106y().m8110a("Error storing remote config. appId", zzchm.m8093a(str), e2);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    protected final String m8155b(String str) {
        mo7855c();
        return this.f7312h.get(str);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: b */
    final boolean m8156b(String str, String str2) throws Throwable {
        Boolean bool;
        mo7855c();
        m8151e(str);
        if (mo7868p().m8441l(str) && zzclq.m8410i(str2)) {
            return true;
        }
        if (mo7868p().m8442m(str) && zzclq.m8394a(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f7308d.get(str);
        if (map != null && (bool = map.get(str2)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    /* JADX INFO: renamed from: c */
    protected final void m8157c(String str) {
        mo7855c();
        this.f7312h.put(str, null);
    }

    /* JADX INFO: renamed from: c */
    final boolean m8158c(String str, String str2) throws Throwable {
        Boolean bool;
        mo7855c();
        m8151e(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f7309e.get(str);
        if (map != null && (bool = map.get(str2)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    final int m8159d(String str, String str2) throws Throwable {
        Integer num;
        mo7855c();
        m8151e(str);
        Map<String, Integer> map = this.f7311g.get(str);
        if (map != null && (num = map.get(str2)) != null) {
            return num.intValue();
        }
        return 1;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    /* JADX INFO: renamed from: d */
    final void m8160d(String str) {
        mo7855c();
        this.f7310f.remove(str);
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
}
