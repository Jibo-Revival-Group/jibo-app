package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzq;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfq extends zzbfm {
    public static final Parcelable.Creator<zzcfq> CREATOR = new zzcfr();

    /* JADX INFO: renamed from: a */
    private int f7027a;

    /* JADX INFO: renamed from: b */
    private zzcfo f7028b;

    /* JADX INFO: renamed from: c */
    private zzs f7029c;

    /* JADX INFO: renamed from: d */
    private PendingIntent f7030d;

    /* JADX INFO: renamed from: e */
    private zzp f7031e;

    /* JADX INFO: renamed from: f */
    private zzceu f7032f;

    zzcfq(int i, zzcfo zzcfoVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzceu zzcewVar = null;
        this.f7027a = i;
        this.f7028b = zzcfoVar;
        this.f7029c = iBinder == null ? null : zzt.m8814a(iBinder);
        this.f7030d = pendingIntent;
        this.f7031e = iBinder2 == null ? null : zzq.m8813a(iBinder2);
        if (iBinder3 != null && iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzcewVar = iInterfaceQueryLocalInterface instanceof zzceu ? (zzceu) iInterfaceQueryLocalInterface : new zzcew(iBinder3);
        }
        this.f7032f = zzcewVar;
    }

    /* JADX INFO: renamed from: a */
    public static zzcfq m7839a(zzp zzpVar, zzceu zzceuVar) {
        return new zzcfq(2, null, null, null, zzpVar.asBinder(), zzceuVar != null ? zzceuVar.asBinder() : null);
    }

    /* JADX INFO: renamed from: a */
    public static zzcfq m7840a(zzs zzsVar, zzceu zzceuVar) {
        return new zzcfq(2, null, zzsVar.asBinder(), null, null, zzceuVar != null ? zzceuVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7027a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f7028b, i, false);
        zzbfp.m7741a(parcel, 3, this.f7029c == null ? null : this.f7029c.asBinder(), false);
        zzbfp.m7743a(parcel, 4, (Parcelable) this.f7030d, i, false);
        zzbfp.m7741a(parcel, 5, this.f7031e == null ? null : this.f7031e.asBinder(), false);
        zzbfp.m7741a(parcel, 6, this.f7032f != null ? this.f7032f.asBinder() : null, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
