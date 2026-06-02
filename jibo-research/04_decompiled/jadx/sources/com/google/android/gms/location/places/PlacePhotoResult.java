package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoResult extends zzbfm implements Result {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzk();

    /* JADX INFO: renamed from: a */
    private final Status f8115a;

    /* JADX INFO: renamed from: b */
    private BitmapTeleporter f8116b;

    /* JADX INFO: renamed from: c */
    private final Bitmap f8117c;

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.f8115a = status;
        this.f8116b = bitmapTeleporter;
        if (this.f8116b != null) {
            this.f8117c = bitmapTeleporter.m7264a();
        } else {
            this.f8117c = null;
        }
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public Status mo6927a() {
        return this.f8115a;
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f8115a).m7372a("bitmap", this.f8117c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) mo6927a(), i, false);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8116b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
