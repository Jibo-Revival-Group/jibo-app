package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PatternItem extends zzbfm {

    /* JADX INFO: renamed from: b */
    private final int f8333b;

    /* JADX INFO: renamed from: c */
    private final Float f8334c;

    /* JADX INFO: renamed from: a */
    private static final String f8332a = PatternItem.class.getSimpleName();
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzi();

    public PatternItem(int i, Float f) {
        boolean z = true;
        if (i != 1 && (f == null || f.floatValue() < CropImageView.DEFAULT_ASPECT_RATIO)) {
            z = false;
        }
        String strValueOf = String.valueOf(f);
        zzbq.m7383b(z, new StringBuilder(String.valueOf(strValueOf).length() + 45).append("Invalid PatternItem: type=").append(i).append(" length=").append(strValueOf).toString());
        this.f8333b = i;
        this.f8334c = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f8333b == patternItem.f8333b && zzbg.m7371a(this.f8334c, patternItem.f8334c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8333b), this.f8334c});
    }

    public String toString() {
        int i = this.f8333b;
        String strValueOf = String.valueOf(this.f8334c);
        return new StringBuilder(String.valueOf(strValueOf).length() + 39).append("[PatternItem: type=").append(i).append(" length=").append(strValueOf).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 2, this.f8333b);
        zzbfp.m7745a(parcel, 3, this.f8334c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
