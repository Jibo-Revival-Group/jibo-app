package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: a */
    public final String f8128a;

    /* JADX INFO: renamed from: b */
    public final String f8129b;

    /* JADX INFO: renamed from: c */
    public final int f8130c;

    /* JADX INFO: renamed from: d */
    public final String f8131d;

    /* JADX INFO: renamed from: e */
    public final Locale f8132e;

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private int f8133a = 0;

        /* JADX INFO: renamed from: a */
        public PlacesOptions m8772a() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.f8128a = null;
        this.f8129b = null;
        this.f8130c = 0;
        this.f8131d = null;
        this.f8132e = null;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof PlacesOptions) && zzbg.m7371a(null, null) && zzbg.m7371a(null, null) && zzbg.m7371a(0, 0) && zzbg.m7371a(null, null) && zzbg.m7371a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, null, 0, null, null});
    }
}
