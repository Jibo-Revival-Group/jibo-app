package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Cap extends zzbfm {

    /* JADX INFO: renamed from: b */
    private final int f8284b;

    /* JADX INFO: renamed from: c */
    private final BitmapDescriptor f8285c;

    /* JADX INFO: renamed from: d */
    private final Float f8286d;

    /* JADX INFO: renamed from: a */
    private static final String f8283a = Cap.class.getSimpleName();
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    protected Cap(int i) {
        this(i, (BitmapDescriptor) null, (Float) null);
    }

    Cap(int i, IBinder iBinder, Float f) {
        this(i, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.zza.m7552a(iBinder)), f);
    }

    private Cap(int i, BitmapDescriptor bitmapDescriptor, Float f) {
        zzbq.m7383b(i != 3 || (bitmapDescriptor != null && (f != null && (f.floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : (f.floatValue() == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i), bitmapDescriptor, f));
        this.f8284b = i;
        this.f8285c = bitmapDescriptor;
        this.f8286d = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f8284b == cap.f8284b && zzbg.m7371a(this.f8285c, cap.f8285c) && zzbg.m7371a(this.f8286d, cap.f8286d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8284b), this.f8285c, this.f8286d});
    }

    public String toString() {
        return new StringBuilder(23).append("[Cap: type=").append(this.f8284b).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 2, this.f8284b);
        zzbfp.m7741a(parcel, 3, this.f8285c == null ? null : this.f8285c.m8843a().asBinder(), false);
        zzbfp.m7745a(parcel, 4, this.f8286d, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
