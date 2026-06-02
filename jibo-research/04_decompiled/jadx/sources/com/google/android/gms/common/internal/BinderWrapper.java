package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzq();

    /* JADX INFO: renamed from: a */
    private IBinder f6519a;

    public BinderWrapper() {
        this.f6519a = null;
    }

    private BinderWrapper(Parcel parcel) {
        this.f6519a = null;
        this.f6519a = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzq zzqVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6519a);
    }
}
