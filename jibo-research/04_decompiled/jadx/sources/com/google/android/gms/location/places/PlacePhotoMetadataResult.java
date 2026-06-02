package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoMetadataResult extends zzbfm implements Result {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzj();

    /* JADX INFO: renamed from: a */
    private final Status f8112a;

    /* JADX INFO: renamed from: b */
    private DataHolder f8113b;

    /* JADX INFO: renamed from: c */
    private final PlacePhotoMetadataBuffer f8114c;

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this.f8112a = status;
        this.f8113b = dataHolder;
        if (dataHolder == null) {
            this.f8114c = null;
        } else {
            this.f8114c = new PlacePhotoMetadataBuffer(this.f8113b);
        }
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public Status mo6927a() {
        return this.f8112a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) mo6927a(), i, false);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8113b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
