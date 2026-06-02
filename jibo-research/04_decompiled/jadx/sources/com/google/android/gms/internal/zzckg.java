package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzckg extends zzcjl {

    /* JADX INFO: renamed from: a */
    private final zzcku f7508a;

    /* JADX INFO: renamed from: b */
    private zzche f7509b;

    /* JADX INFO: renamed from: c */
    private volatile Boolean f7510c;

    /* JADX INFO: renamed from: d */
    private final zzcgs f7511d;

    /* JADX INFO: renamed from: e */
    private final zzclk f7512e;

    /* JADX INFO: renamed from: f */
    private final List<Runnable> f7513f;

    /* JADX INFO: renamed from: g */
    private final zzcgs f7514g;

    protected zzckg(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7513f = new ArrayList();
        this.f7512e = new zzclk(zzcimVar.m8248u());
        this.f7508a = new zzcku(this);
        this.f7511d = new zzckh(this, zzcimVar);
        this.f7514g = new zzckm(this, zzcimVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F */
    public final void m8319F() {
        mo7855c();
        this.f7512e.m8375a();
        this.f7511d.m8016a(zzchc.f7168I.m8041b().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G */
    public final void m8320G() {
        mo7855c();
        if (m8347y()) {
            mo7872t().m8101E().m8108a("Inactivity, disconnecting from the service");
            m8336E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H */
    public final void m8321H() {
        mo7855c();
        mo7872t().m8101E().m8109a("Processing queued up service tasks", Integer.valueOf(this.f7513f.size()));
        Iterator<Runnable> it = this.f7513f.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Throwable th) {
                mo7872t().m8106y().m8109a("Task exception while flushing queue", th);
            }
        }
        this.f7513f.clear();
        this.f7514g.m8018c();
    }

    /* JADX INFO: renamed from: a */
    private final zzcgi m8322a(boolean z) {
        return mo7859g().m8062a(z ? mo7872t().m8102F() : null);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ zzche m8323a(zzckg zzckgVar, zzche zzcheVar) {
        zzckgVar.f7509b = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m8325a(ComponentName componentName) {
        mo7855c();
        if (this.f7509b != null) {
            this.f7509b = null;
            mo7872t().m8101E().m8109a("Disconnected from device MeasurementService", componentName);
            mo7855c();
            m8334C();
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8327a(Runnable runnable) throws IllegalStateException {
        mo7855c();
        if (m8347y()) {
            runnable.run();
        } else {
            if (this.f7513f.size() >= 1000) {
                mo7872t().m8106y().m8108a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f7513f.add(runnable);
            this.f7514g.m8016a(60000L);
            m8334C();
        }
    }

    /* JADX INFO: renamed from: A */
    protected final void m8332A() {
        mo7855c();
        m8259Q();
        zzcgi zzcgiVarM8322a = m8322a(false);
        mo7865m().m8072y();
        m8327a(new zzcki(this, zzcgiVarM8322a));
    }

    /* JADX INFO: renamed from: B */
    protected final void m8333B() {
        mo7855c();
        m8259Q();
        m8327a(new zzckk(this, m8322a(true)));
    }

    /* JADX INFO: renamed from: C */
    final void m8334C() {
        boolean z;
        boolean z2;
        mo7855c();
        m8259Q();
        if (m8347y()) {
            return;
        }
        if (this.f7510c == null) {
            mo7855c();
            m8259Q();
            Boolean boolM8122A = mo7873u().m8122A();
            if (boolM8122A == null || !boolM8122A.booleanValue()) {
                if (mo7859g().m8061C() != 1) {
                    mo7872t().m8101E().m8108a("Checking service availability");
                    int iMo6834a = zzf.m7530b().mo6834a(mo7868p().mo7864l());
                    switch (iMo6834a) {
                        case 0:
                            mo7872t().m8101E().m8108a("Service available");
                            z = true;
                            z2 = true;
                            break;
                        case 1:
                            mo7872t().m8101E().m8108a("Service missing");
                            z = true;
                            z2 = false;
                            break;
                        case 2:
                            mo7872t().m8100D().m8108a("Service container out of date");
                            zzclq zzclqVarMo7868p = mo7868p();
                            zzf.m7530b();
                            if (zzf.m7533d(zzclqVarMo7868p.mo7864l()) >= 11400) {
                                Boolean boolM8122A2 = mo7873u().m8122A();
                                z2 = boolM8122A2 == null || boolM8122A2.booleanValue();
                                z = false;
                            } else {
                                z = true;
                                z2 = false;
                            }
                            break;
                        case 3:
                            mo7872t().m8097A().m8108a("Service disabled");
                            z = false;
                            z2 = false;
                            break;
                        case 9:
                            mo7872t().m8097A().m8108a("Service invalid");
                            z = false;
                            z2 = false;
                            break;
                        case 18:
                            mo7872t().m8097A().m8108a("Service updating");
                            z = true;
                            z2 = true;
                            break;
                        default:
                            mo7872t().m8097A().m8109a("Unexpected service status", Integer.valueOf(iMo6834a));
                            z = false;
                            z2 = false;
                            break;
                    }
                } else {
                    z = true;
                    z2 = true;
                }
                if (z) {
                    mo7873u().m8126a(z2);
                }
            } else {
                z2 = true;
            }
            this.f7510c = Boolean.valueOf(z2);
        }
        if (this.f7510c.booleanValue()) {
            this.f7508a.m8350a();
            return;
        }
        List<ResolveInfo> listQueryIntentServices = mo7864l().getPackageManager().queryIntentServices(new Intent().setClassName(mo7864l(), "com.google.android.gms.measurement.AppMeasurementService"), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (!(listQueryIntentServices != null && listQueryIntentServices.size() > 0)) {
            mo7872t().m8106y().m8108a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(mo7864l(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.f7508a.m8351a(intent);
    }

    /* JADX INFO: renamed from: D */
    final Boolean m8335D() {
        return this.f7510c;
    }

    /* JADX INFO: renamed from: E */
    public final void m8336E() {
        mo7855c();
        m8259Q();
        try {
            zza.m7483a();
            mo7864l().unbindService(this.f7508a);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        this.f7509b = null;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    protected final void m8337a(zzcgl zzcglVar) {
        zzbq.m7373a(zzcglVar);
        mo7855c();
        m8259Q();
        m8327a(new zzckp(this, true, mo7865m().m8069a(zzcglVar), new zzcgl(zzcglVar), m8322a(true), zzcglVar));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8338a(zzcha zzchaVar, String str) {
        zzbq.m7373a(zzchaVar);
        mo7855c();
        m8259Q();
        m8327a(new zzcko(this, true, mo7865m().m8070a(zzchaVar), zzchaVar, m8322a(true), str));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8339a(zzche zzcheVar) {
        mo7855c();
        zzbq.m7373a(zzcheVar);
        this.f7509b = zzcheVar;
        m8319F();
        m8321H();
    }

    /* JADX INFO: renamed from: a */
    final void m8340a(zzche zzcheVar, zzbfm zzbfmVar, zzcgi zzcgiVar) throws Throwable {
        mo7855c();
        m8259Q();
        int size = 100;
        for (int i = 0; i < 1001 && size == 100; i++) {
            ArrayList arrayList = new ArrayList();
            List<zzbfm> listM8068a = mo7865m().m8068a(100);
            if (listM8068a != null) {
                arrayList.addAll(listM8068a);
                size = listM8068a.size();
            } else {
                size = 0;
            }
            if (zzbfmVar != null && size < 100) {
                arrayList.add(zzbfmVar);
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj = arrayList2.get(i2);
                i2++;
                zzbfm zzbfmVar2 = (zzbfm) obj;
                if (zzbfmVar2 instanceof zzcha) {
                    try {
                        zzcheVar.mo8051a((zzcha) zzbfmVar2, zzcgiVar);
                    } catch (RemoteException e) {
                        mo7872t().m8106y().m8109a("Failed to send event to the service", e);
                    }
                } else if (zzbfmVar2 instanceof zzcln) {
                    try {
                        zzcheVar.mo8053a((zzcln) zzbfmVar2, zzcgiVar);
                    } catch (RemoteException e2) {
                        mo7872t().m8106y().m8109a("Failed to send attribute to the service", e2);
                    }
                } else if (zzbfmVar2 instanceof zzcgl) {
                    try {
                        zzcheVar.mo8050a((zzcgl) zzbfmVar2, zzcgiVar);
                    } catch (RemoteException e3) {
                        mo7872t().m8106y().m8109a("Failed to send conditional property to the service", e3);
                    }
                } else {
                    mo7872t().m8106y().m8108a("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m8341a(zzcln zzclnVar) {
        mo7855c();
        m8259Q();
        m8327a(new zzcks(this, mo7865m().m8071a(zzclnVar), zzclnVar, m8322a(true)));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8342a(AppMeasurement.zzb zzbVar) {
        mo7855c();
        m8259Q();
        m8327a(new zzckl(this, zzbVar));
    }

    /* JADX INFO: renamed from: a */
    public final void m8343a(AtomicReference<String> atomicReference) {
        mo7855c();
        m8259Q();
        m8327a(new zzckj(this, atomicReference, m8322a(false)));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8344a(AtomicReference<List<zzcgl>> atomicReference, String str, String str2, String str3) {
        mo7855c();
        m8259Q();
        m8327a(new zzckq(this, atomicReference, str, str2, str3, m8322a(false)));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8345a(AtomicReference<List<zzcln>> atomicReference, String str, String str2, String str3, boolean z) {
        mo7855c();
        m8259Q();
        m8327a(new zzckr(this, atomicReference, str, str2, str3, z, m8322a(false)));
    }

    /* JADX INFO: renamed from: a */
    protected final void m8346a(AtomicReference<List<zzcln>> atomicReference, boolean z) {
        mo7855c();
        m8259Q();
        m8327a(new zzckt(this, atomicReference, m8322a(false), z));
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
    public final boolean m8347y() {
        mo7855c();
        m8259Q();
        return this.f7509b != null;
    }

    /* JADX INFO: renamed from: z */
    protected final void m8348z() {
        mo7855c();
        m8259Q();
        m8327a(new zzckn(this, m8322a(true)));
    }
}
