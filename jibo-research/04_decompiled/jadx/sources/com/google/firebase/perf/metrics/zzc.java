package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Parcelable.Creator<Trace> {
    zzc() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Trace createFromParcel(Parcel parcel) {
        return new Trace(parcel, false, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Trace[] newArray(int i) {
        return new Trace[i];
    }
}
