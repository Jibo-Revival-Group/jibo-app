package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    private int f6127a;

    /* JADX INFO: renamed from: b */
    private final String f6128b;

    Scope(int i, String str) {
        zzbq.m7376a(str, (Object) "scopeUri must not be null or empty");
        this.f6127a = i;
        this.f6128b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    /* JADX INFO: renamed from: a */
    public final String m6933a() {
        return this.f6128b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f6128b.equals(((Scope) obj).f6128b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6128b.hashCode();
    }

    public final String toString() {
        return this.f6128b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6127a);
        zzbfp.m7748a(parcel, 2, this.f6128b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
