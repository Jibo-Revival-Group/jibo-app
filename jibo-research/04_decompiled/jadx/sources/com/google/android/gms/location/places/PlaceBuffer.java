package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzas;

/* JADX INFO: loaded from: classes.dex */
public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {

    /* JADX INFO: renamed from: b */
    private final Status f8097b;

    /* JADX INFO: renamed from: c */
    private final String f8098c;

    public PlaceBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f8097b = PlacesStatusCodes.m8774c(dataHolder.m7273b());
        if (dataHolder == null || dataHolder.m7276c() == null) {
            this.f8098c = null;
        } else {
            this.f8098c = dataHolder.m7276c().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public Status mo6927a() {
        return this.f8097b;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Place mo7265a(int i) {
        return new zzas(this.f6459a, i);
    }
}
