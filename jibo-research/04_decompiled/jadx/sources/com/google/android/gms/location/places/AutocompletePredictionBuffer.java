package com.google.android.gms.location.places;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.places.internal.zzd;

/* JADX INFO: loaded from: classes.dex */
public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public Status mo6927a() {
        return PlacesStatusCodes.m8774c(this.f6459a.m7273b());
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction mo7265a(int i) {
        return new zzd(this.f6459a, i);
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, mo6927a()).toString();
    }
}
