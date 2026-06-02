package com.google.android.gms.location.places;

import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.places.internal.zzah;
import com.google.android.gms.location.places.internal.zzaj;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {

    /* JADX INFO: renamed from: b */
    private static final Comparator<zzah> f8107b = new zzi();

    /* JADX INFO: renamed from: c */
    private final String f8108c;

    /* JADX INFO: renamed from: d */
    private final int f8109d;

    /* JADX INFO: renamed from: e */
    private final Status f8110e;

    /* JADX INFO: renamed from: f */
    private final boolean f8111f;

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i) {
        this(dataHolder, false, i);
    }

    private PlaceLikelihoodBuffer(DataHolder dataHolder, boolean z, int i) {
        super(dataHolder);
        this.f8110e = PlacesStatusCodes.m8774c(dataHolder.m7273b());
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                this.f8109d = i;
                this.f8111f = false;
                if (dataHolder == null || dataHolder.m7276c() == null) {
                    this.f8108c = null;
                    return;
                } else {
                    this.f8108c = dataHolder.m7276c().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
                    return;
                }
            default:
                throw new IllegalArgumentException(new StringBuilder(27).append("invalid source: ").append(i).toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m8767a(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public Status mo6927a() {
        return this.f8110e;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood mo7265a(int i) {
        return new zzaj(this.f6459a, i);
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, mo6927a()).m7372a("attributions", this.f8108c).toString();
    }
}
