package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zze {

    /* JADX INFO: renamed from: a */
    private IBinder f6629a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzd f6630b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzd zzdVar, int i, IBinder iBinder, Bundle bundle) {
        super(zzdVar, i, bundle);
        this.f6630b = zzdVar;
        this.f6629a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zze
    /* JADX INFO: renamed from: a */
    protected final void mo7441a(ConnectionResult connectionResult) {
        if (this.f6630b.f6612v != null) {
            this.f6630b.f6612v.mo7317a(connectionResult);
        }
        this.f6630b.m7422a(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zze
    /* JADX INFO: renamed from: a */
    protected final boolean mo7443a() {
        try {
            String interfaceDescriptor = this.f6629a.getInterfaceDescriptor();
            if (!this.f6630b.mo6769b().equals(interfaceDescriptor)) {
                String strMo6769b = this.f6630b.mo6769b();
                Log.e("GmsClient", new StringBuilder(String.valueOf(strMo6769b).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(strMo6769b).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            }
            IInterface iInterfaceMo6768a = this.f6630b.mo6768a(this.f6629a);
            if (iInterfaceMo6768a == null) {
                return false;
            }
            if (!this.f6630b.m7405a(2, 4, iInterfaceMo6768a) && !this.f6630b.m7405a(3, 4, iInterfaceMo6768a)) {
                return false;
            }
            this.f6630b.f6615y = null;
            Bundle bundleM7417a = this.f6630b.m7417a();
            if (this.f6630b.f6611u != null) {
                this.f6630b.f6611u.mo7316a(bundleM7417a);
            }
            return true;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
