package com.salesforce.android.service.common.utilities.spatial;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Coordinate implements Serializable {

    /* JADX INFO: renamed from: a */
    private final int f13919a;

    /* JADX INFO: renamed from: b */
    private final int f13920b;

    /* JADX INFO: renamed from: a */
    public static Coordinate m14208a(int i, int i2) {
        return new Coordinate(i, i2);
    }

    private Coordinate(int i, int i2) {
        this.f13919a = i;
        this.f13920b = i2;
    }

    /* JADX INFO: renamed from: a */
    public int m14209a() {
        return this.f13919a;
    }

    /* JADX INFO: renamed from: b */
    public int m14210b() {
        return this.f13920b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) obj;
        return this.f13919a == coordinate.f13919a && this.f13920b == coordinate.f13920b;
    }

    public int hashCode() {
        return (this.f13919a * 31) + this.f13920b;
    }

    public String toString() {
        return "[" + this.f13919a + "," + this.f13920b + "]";
    }
}
