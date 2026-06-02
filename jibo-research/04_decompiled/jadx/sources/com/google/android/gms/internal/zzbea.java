package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class zzbea {

    /* JADX INFO: renamed from: a */
    private int f6875a;

    /* JADX INFO: renamed from: b */
    private String f6876b;

    /* JADX INFO: renamed from: c */
    private String f6877c;

    /* JADX INFO: renamed from: d */
    private String f6878d;

    /* JADX INFO: renamed from: e */
    private int f6879e;

    /* JADX INFO: renamed from: f */
    private final zzbec f6880f;

    /* JADX INFO: renamed from: g */
    private ArrayList<Integer> f6881g;

    /* JADX INFO: renamed from: h */
    private ArrayList<String> f6882h;

    /* JADX INFO: renamed from: i */
    private ArrayList<Integer> f6883i;

    /* JADX INFO: renamed from: j */
    private ArrayList<zzctx> f6884j;

    /* JADX INFO: renamed from: k */
    private ArrayList<byte[]> f6885k;

    /* JADX INFO: renamed from: l */
    private boolean f6886l;

    /* JADX INFO: renamed from: m */
    private final zzfkq f6887m;

    /* JADX INFO: renamed from: n */
    private boolean f6888n;

    /* JADX INFO: renamed from: o */
    private /* synthetic */ zzbdy f6889o;

    private zzbea(zzbdy zzbdyVar, byte[] bArr) {
        this(zzbdyVar, bArr, (zzbec) null);
    }

    /* synthetic */ zzbea(zzbdy zzbdyVar, byte[] bArr, zzbdz zzbdzVar) {
        this(zzbdyVar, bArr);
    }

    private zzbea(zzbdy zzbdyVar, byte[] bArr, zzbec zzbecVar) {
        this.f6889o = zzbdyVar;
        this.f6875a = this.f6889o.f6866j;
        this.f6876b = this.f6889o.f6865i;
        zzbdy zzbdyVar2 = this.f6889o;
        this.f6877c = null;
        zzbdy zzbdyVar3 = this.f6889o;
        this.f6878d = null;
        this.f6879e = 0;
        this.f6881g = null;
        this.f6882h = null;
        this.f6883i = null;
        this.f6884j = null;
        this.f6885k = null;
        this.f6886l = true;
        this.f6887m = new zzfkq();
        this.f6888n = false;
        this.f6877c = null;
        this.f6878d = null;
        this.f6887m.f7994a = zzbdyVar.f6872p.mo7496a();
        this.f6887m.f7995b = zzbdyVar.f6872p.mo7497b();
        zzfkq zzfkqVar = this.f6887m;
        zzbed unused = zzbdyVar.f6873q;
        zzfkqVar.f7997d = TimeZone.getDefault().getOffset(this.f6887m.f7994a) / 1000;
        if (bArr != null) {
            this.f6887m.f7996c = bArr;
        }
        this.f6880f = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m7668a() {
        if (this.f6888n) {
            throw new IllegalStateException("do not reuse LogEventBuilder");
        }
        this.f6888n = true;
        zzbeh zzbehVar = new zzbeh(new zzbew(this.f6889o.f6863g, this.f6889o.f6864h, this.f6875a, this.f6876b, this.f6877c, this.f6878d, this.f6889o.f6869m, 0), this.f6887m, null, null, zzbdy.m7659b((ArrayList<Integer>) null), null, zzbdy.m7659b((ArrayList<Integer>) null), null, null, this.f6886l);
        zzbew zzbewVar = zzbehVar.f6893a;
        if (this.f6889o.f6874r.mo7669a(zzbewVar.f6916b, zzbewVar.f6915a)) {
            this.f6889o.f6871o.mo7671a(zzbehVar);
        } else {
            PendingResults.m6925a(Status.f6129a);
        }
    }
}
