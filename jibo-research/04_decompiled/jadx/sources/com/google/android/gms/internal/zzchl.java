package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

/* JADX INFO: loaded from: classes.dex */
public final class zzchl extends zzd<zzche> {
    public zzchl(Context context, Looper looper, zzf zzfVar, zzg zzgVar) {
        super(context, looper, 93, zzfVar, zzgVar, null);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof zzche ? (zzche) iInterfaceQueryLocalInterface : new zzchg(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.measurement.START";
    }
}
