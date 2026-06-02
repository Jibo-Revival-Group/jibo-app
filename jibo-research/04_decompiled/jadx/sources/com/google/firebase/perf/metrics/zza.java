package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable {

    /* JADX INFO: renamed from: a */
    private final String f8752a;

    /* JADX INFO: renamed from: b */
    private long f8753b;

    /* JADX INFO: renamed from: c */
    private static final Map<String, zza> f8751c = new HashMap();
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    private zza(Parcel parcel) {
        this.f8752a = parcel.readString();
        this.f8753b = parcel.readLong();
    }

    /* synthetic */ zza(Parcel parcel, zzb zzbVar) {
        this(parcel);
    }

    public zza(String str) {
        this.f8752a = str;
    }

    /* JADX INFO: renamed from: a */
    final long m9259a() {
        return this.f8753b;
    }

    /* JADX INFO: renamed from: a */
    public final void m9260a(long j) {
        this.f8753b += j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8752a);
        parcel.writeLong(this.f8753b);
    }
}
