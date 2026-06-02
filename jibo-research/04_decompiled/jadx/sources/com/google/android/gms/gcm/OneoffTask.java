package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class OneoffTask extends Task {
    public static final Parcelable.Creator<OneoffTask> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    private final long f6762a;

    /* JADX INFO: renamed from: b */
    private final long f6763b;

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.f6762a = parcel.readLong();
        this.f6763b = parcel.readLong();
    }

    /* synthetic */ OneoffTask(Parcel parcel, zzf zzfVar) {
        this(parcel);
    }

    /* JADX INFO: renamed from: a */
    public long m7587a() {
        return this.f6762a;
    }

    /* JADX INFO: renamed from: b */
    public long m7588b() {
        return this.f6763b;
    }

    public String toString() {
        String string = super.toString();
        long jM7587a = m7587a();
        return new StringBuilder(String.valueOf(string).length() + 64).append(string).append(" windowStart=").append(jM7587a).append(" windowEnd=").append(m7588b()).toString();
    }

    @Override // com.google.android.gms.gcm.Task, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f6762a);
        parcel.writeLong(this.f6763b);
    }
}
