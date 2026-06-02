package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzn;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdz extends zzbfm {
    public static final Parcelable.Creator<zzcdz> CREATOR = new zzcea();

    /* JADX INFO: renamed from: a */
    private int f6999a;

    /* JADX INFO: renamed from: b */
    private zzcdx f7000b;

    /* JADX INFO: renamed from: c */
    private zzm f7001c;

    /* JADX INFO: renamed from: d */
    private zzceu f7002d;

    zzcdz(int i, zzcdx zzcdxVar, IBinder iBinder, IBinder iBinder2) {
        zzceu zzcewVar = null;
        this.f6999a = i;
        this.f7000b = zzcdxVar;
        this.f7001c = iBinder == null ? null : zzn.m8812a(iBinder);
        if (iBinder2 != null && iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzcewVar = iInterfaceQueryLocalInterface instanceof zzceu ? (zzceu) iInterfaceQueryLocalInterface : new zzcew(iBinder2);
        }
        this.f7002d = zzcewVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6999a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f7000b, i, false);
        zzbfp.m7741a(parcel, 3, this.f7001c == null ? null : this.f7001c.asBinder(), false);
        zzbfp.m7741a(parcel, 4, this.f7002d != null ? this.f7002d.asBinder() : null, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
