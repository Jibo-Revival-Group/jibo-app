package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzewn implements Parcelable {
    public static final Parcelable.Creator<zzewn> CREATOR = new zzewo();

    /* JADX INFO: renamed from: a */
    private long f7888a;

    /* JADX INFO: renamed from: b */
    private long f7889b;

    public zzewn() {
        this.f7888a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f7889b = System.nanoTime();
    }

    private zzewn(Parcel parcel) {
        this.f7888a = parcel.readLong();
        this.f7889b = parcel.readLong();
    }

    /* synthetic */ zzewn(Parcel parcel, zzewo zzewoVar) {
        this(parcel);
    }

    /* JADX INFO: renamed from: a */
    public final long m8599a(zzewn zzewnVar) {
        return TimeUnit.NANOSECONDS.toMicros(zzewnVar.f7889b - this.f7889b);
    }

    /* JADX INFO: renamed from: a */
    public final void m8600a() {
        this.f7888a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f7889b = System.nanoTime();
    }

    /* JADX INFO: renamed from: b */
    public final long m8601b() {
        return this.f7888a;
    }

    /* JADX INFO: renamed from: c */
    public final long m8602c() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.f7889b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7888a);
        parcel.writeLong(this.f7889b);
    }
}
