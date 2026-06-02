package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgx extends zzbfm implements Iterable<String> {
    public static final Parcelable.Creator<zzcgx> CREATOR = new zzcgz();

    /* JADX INFO: renamed from: a */
    private final Bundle f7153a;

    zzcgx(Bundle bundle) {
        this.f7153a = bundle;
    }

    /* JADX INFO: renamed from: a */
    public final int m8029a() {
        return this.f7153a.size();
    }

    /* JADX INFO: renamed from: a */
    final Object m8030a(String str) {
        return this.f7153a.get(str);
    }

    /* JADX INFO: renamed from: b */
    public final Bundle m8031b() {
        return new Bundle(this.f7153a);
    }

    /* JADX INFO: renamed from: b */
    final Long m8032b(String str) {
        return Long.valueOf(this.f7153a.getLong(str));
    }

    /* JADX INFO: renamed from: c */
    final Double m8033c(String str) {
        return Double.valueOf(this.f7153a.getDouble(str));
    }

    /* JADX INFO: renamed from: d */
    final String m8034d(String str) {
        return this.f7153a.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzcgy(this);
    }

    public final String toString() {
        return this.f7153a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7740a(parcel, 2, m8031b(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
