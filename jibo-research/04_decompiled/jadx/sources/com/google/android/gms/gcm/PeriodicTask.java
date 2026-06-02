package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PeriodicTask extends Task {
    public static final Parcelable.Creator<PeriodicTask> CREATOR = new zzh();

    /* JADX INFO: renamed from: a */
    protected long f6765a;

    /* JADX INFO: renamed from: b */
    protected long f6766b;

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.f6765a = -1L;
        this.f6766b = -1L;
        this.f6765a = parcel.readLong();
        this.f6766b = Math.min(parcel.readLong(), this.f6765a);
    }

    /* synthetic */ PeriodicTask(Parcel parcel, zzh zzhVar) {
        this(parcel);
    }

    /* JADX INFO: renamed from: a */
    public long m7589a() {
        return this.f6765a;
    }

    /* JADX INFO: renamed from: b */
    public long m7590b() {
        return this.f6766b;
    }

    public String toString() {
        String string = super.toString();
        long jM7589a = m7589a();
        return new StringBuilder(String.valueOf(string).length() + 54).append(string).append(" period=").append(jM7589a).append(" flex=").append(m7590b()).toString();
    }

    @Override // com.google.android.gms.gcm.Task, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f6765a);
        parcel.writeLong(this.f6766b);
    }
}
