package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends zzav implements AutocompletePrediction {
    public zzd(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* JADX INFO: renamed from: b */
    private final String m8797b() {
        return m8794a("ap_description", "");
    }

    /* JADX INFO: renamed from: c */
    private final List<zzb> m8798c() {
        return m8795a("ap_matched_subscriptions", zzb.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    /* JADX INFO: renamed from: a */
    public final CharSequence mo8760a(CharacterStyle characterStyle) {
        return zzg.m8799a(m8797b(), m8798c(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    /* JADX INFO: renamed from: a */
    public final String mo8761a() {
        return m8794a("ap_place_id", (String) null);
    }
}
