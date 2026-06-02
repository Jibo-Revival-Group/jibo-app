package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

/* JADX INFO: loaded from: classes2.dex */
class GJCacheKey {

    /* JADX INFO: renamed from: a */
    private final DateTimeZone f15910a;

    /* JADX INFO: renamed from: b */
    private final Instant f15911b;

    /* JADX INFO: renamed from: c */
    private final int f15912c;

    GJCacheKey(DateTimeZone dateTimeZone, Instant instant, int i) {
        this.f15910a = dateTimeZone;
        this.f15911b = instant;
        this.f15912c = i;
    }

    public int hashCode() {
        return (((((this.f15911b == null ? 0 : this.f15911b.hashCode()) + 31) * 31) + this.f15912c) * 31) + (this.f15910a != null ? this.f15910a.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof GJCacheKey)) {
            GJCacheKey gJCacheKey = (GJCacheKey) obj;
            if (this.f15911b == null) {
                if (gJCacheKey.f15911b != null) {
                    return false;
                }
            } else if (!this.f15911b.equals(gJCacheKey.f15911b)) {
                return false;
            }
            if (this.f15912c != gJCacheKey.f15912c) {
                return false;
            }
            return this.f15910a == null ? gJCacheKey.f15910a == null : this.f15910a.equals(gJCacheKey.f15910a);
        }
        return false;
    }
}
