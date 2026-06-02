package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
abstract class zze extends zzi<Boolean> {

    /* JADX INFO: renamed from: a */
    private int f6617a;

    /* JADX INFO: renamed from: b */
    private Bundle f6618b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzd f6619c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected zze(zzd zzdVar, int i, Bundle bundle) {
        super(zzdVar, true);
        this.f6619c = zzdVar;
        this.f6617a = i;
        this.f6618b = bundle;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7441a(ConnectionResult connectionResult);

    @Override // com.google.android.gms.common.internal.zzi
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo7442a(Boolean bool) {
        if (bool == null) {
            this.f6619c.m7402a(1, (IInterface) null);
            return;
        }
        switch (this.f6617a) {
            case 0:
                if (mo7443a()) {
                    return;
                }
                this.f6619c.m7402a(1, (IInterface) null);
                mo7441a(new ConnectionResult(8, null));
                return;
            case 10:
                this.f6619c.m7402a(1, (IInterface) null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f6619c.m7402a(1, (IInterface) null);
                mo7441a(new ConnectionResult(this.f6617a, this.f6618b != null ? (PendingIntent) this.f6618b.getParcelable("pendingIntent") : null));
                return;
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo7443a();
}
