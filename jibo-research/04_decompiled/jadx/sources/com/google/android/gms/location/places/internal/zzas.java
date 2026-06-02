package com.google.android.gms.location.places.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzav implements Place {

    /* JADX INFO: renamed from: c */
    private final String f8194c;

    /* JADX INFO: renamed from: d */
    private final zzaf f8195d;

    public zzas(DataHolder dataHolder, int i) {
        zzaf zzafVar;
        super(dataHolder, i);
        this.f8194c = m8794a("place_id", "");
        if (m8786c().size() > 0 || (m8785b() != null && m8785b().length() > 0) || (!(m8789f() == null || m8789f().equals(Uri.EMPTY)) || m8788e() >= CropImageView.DEFAULT_ASPECT_RATIO || m8787d() >= 0)) {
            zzafVar = new zzaf(m8786c(), m8785b() != null ? m8785b().toString() : null, m8789f(), m8788e(), m8787d());
        } else {
            zzafVar = null;
        }
        this.f8195d = zzafVar;
    }

    @Override // com.google.android.gms.location.places.Place
    /* JADX INFO: renamed from: a */
    public final LatLng mo8765a() {
        return (LatLng) m8793a("place_lat_lng", LatLng.CREATOR);
    }

    /* JADX INFO: renamed from: b */
    public final CharSequence m8785b() {
        return m8794a("place_phone_number", "");
    }

    /* JADX INFO: renamed from: c */
    public final List<Integer> m8786c() {
        return m8796a("place_types", Collections.emptyList());
    }

    /* JADX INFO: renamed from: d */
    public final int m8787d() {
        return m8792a("place_price_level", -1);
    }

    /* JADX INFO: renamed from: e */
    public final float m8788e() {
        return m8791a("place_rating", -1.0f);
    }

    /* JADX INFO: renamed from: f */
    public final Uri m8789f() {
        String strM8794a = m8794a("place_website_uri", (String) null);
        if (strM8794a == null) {
            return null;
        }
        return Uri.parse(strM8794a);
    }
}
