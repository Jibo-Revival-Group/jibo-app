package com.google.android.gms.maps.model;

/* JADX INFO: loaded from: classes.dex */
public final class CustomCap extends Cap {

    /* JADX INFO: renamed from: a */
    public final BitmapDescriptor f8296a;

    /* JADX INFO: renamed from: b */
    public final float f8297b;

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        String strValueOf = String.valueOf(this.f8296a);
        return new StringBuilder(String.valueOf(strValueOf).length() + 55).append("[CustomCap: bitmapDescriptor=").append(strValueOf).append(" refWidth=").append(this.f8297b).append("]").toString();
    }
}
