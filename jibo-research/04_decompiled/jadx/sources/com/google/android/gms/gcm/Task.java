package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public class Task implements ReflectedParcelable {

    /* JADX INFO: renamed from: a */
    private final String f6767a;

    /* JADX INFO: renamed from: b */
    private final String f6768b;

    /* JADX INFO: renamed from: c */
    private final boolean f6769c;

    /* JADX INFO: renamed from: d */
    private final boolean f6770d;

    /* JADX INFO: renamed from: e */
    private final int f6771e;

    /* JADX INFO: renamed from: f */
    private final boolean f6772f;

    /* JADX INFO: renamed from: g */
    private final boolean f6773g;

    /* JADX INFO: renamed from: h */
    private final zzi f6774h;

    /* JADX INFO: renamed from: i */
    private final Bundle f6775i;

    @Deprecated
    Task(Parcel parcel) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.f6767a = parcel.readString();
        this.f6768b = parcel.readString();
        this.f6769c = parcel.readInt() == 1;
        this.f6770d = parcel.readInt() == 1;
        this.f6771e = 2;
        this.f6772f = false;
        this.f6773g = false;
        this.f6774h = zzi.f6780a;
        this.f6775i = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6767a);
        parcel.writeString(this.f6768b);
        parcel.writeInt(this.f6769c ? 1 : 0);
        parcel.writeInt(this.f6770d ? 1 : 0);
    }
}
