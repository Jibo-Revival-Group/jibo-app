package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class zzewo implements Parcelable.Creator<zzewn> {
    zzewo() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzewn createFromParcel(Parcel parcel) {
        return new zzewn(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzewn[] newArray(int i) {
        return new zzewn[i];
    }
}
