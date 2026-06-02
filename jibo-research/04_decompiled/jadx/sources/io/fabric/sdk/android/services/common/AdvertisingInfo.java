package io.fabric.sdk.android.services.common;

/* JADX INFO: loaded from: classes2.dex */
class AdvertisingInfo {

    /* JADX INFO: renamed from: a */
    public final String f14557a;

    /* JADX INFO: renamed from: b */
    public final boolean f14558b;

    AdvertisingInfo(String str, boolean z) {
        this.f14557a = str;
        this.f14558b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
        if (this.f14558b != advertisingInfo.f14558b) {
            return false;
        }
        if (this.f14557a != null) {
            if (this.f14557a.equals(advertisingInfo.f14557a)) {
                return true;
            }
        } else if (advertisingInfo.f14557a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f14557a != null ? this.f14557a.hashCode() : 0) * 31) + (this.f14558b ? 1 : 0);
    }
}
