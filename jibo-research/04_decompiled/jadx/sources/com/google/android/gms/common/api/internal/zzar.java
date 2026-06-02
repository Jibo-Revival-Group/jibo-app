package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzar extends zzay {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ zzao f6216a;

    /* JADX INFO: renamed from: b */
    private final Map<Api.zze, zzaq> f6217b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzar(zzao zzaoVar, Map<Api.zze, zzaq> map) {
        super(zzaoVar, null);
        this.f6216a = zzaoVar;
        this.f6217b = map;
    }

    @Override // com.google.android.gms.common.api.internal.zzay
    /* JADX INFO: renamed from: a */
    public final void mo7055a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        Iterator<Api.zze> it = this.f6217b.keySet().iterator();
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            if (!it.hasNext()) {
                z4 = z6;
                z = false;
                break;
            }
            Api.zze next = it.next();
            if (!next.m6865j()) {
                z2 = false;
                z3 = z6;
            } else if (!this.f6217b.get(next).f6215c) {
                z = true;
                break;
            } else {
                z2 = z5;
                z3 = true;
            }
            z6 = z3;
            z5 = z2;
        }
        int iMo6834a = z4 ? this.f6216a.f6194d.mo6834a(this.f6216a.f6193c) : 0;
        if (iMo6834a != 0 && (z || z5)) {
            this.f6216a.f6191a.m7082a(new zzas(this, this.f6216a, new ConnectionResult(iMo6834a, null)));
            return;
        }
        if (this.f6216a.f6203m) {
            this.f6216a.f6201k.mo8498m();
        }
        for (Api.zze zzeVar : this.f6217b.keySet()) {
            zzaq zzaqVar = this.f6217b.get(zzeVar);
            if (!zzeVar.m6865j() || iMo6834a == 0) {
                zzeVar.m6858a(zzaqVar);
            } else {
                this.f6216a.f6191a.m7082a(new zzat(this, this.f6216a, zzaqVar));
            }
        }
    }
}
