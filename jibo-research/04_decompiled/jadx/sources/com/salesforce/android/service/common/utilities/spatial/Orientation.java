package com.salesforce.android.service.common.utilities.spatial;

/* JADX INFO: loaded from: classes.dex */
public class Orientation {

    /* JADX INFO: renamed from: a */
    public static Orientation f13921a = m14211a(0);

    /* JADX INFO: renamed from: b */
    public static Orientation f13922b = m14211a(90);

    /* JADX INFO: renamed from: c */
    public static Orientation f13923c = m14211a(180);

    /* JADX INFO: renamed from: d */
    public static Orientation f13924d = m14211a(270);

    /* JADX INFO: renamed from: e */
    public static Orientation f13925e = f13921a;

    /* JADX INFO: renamed from: f */
    public static Orientation f13926f = f13922b;

    /* JADX INFO: renamed from: g */
    private final int f13927g;

    /* JADX INFO: renamed from: a */
    public static Orientation m14211a(int i) {
        return new Orientation(i);
    }

    private Orientation(int i) {
        this.f13927g = i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14212a() {
        return this.f13927g == 0 || this.f13927g == 180;
    }

    /* JADX INFO: renamed from: b */
    public boolean m14213b() {
        return this.f13927g == 90 || this.f13927g == 270;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Orientation) && this.f13927g == ((Orientation) obj).f13927g;
    }

    public int hashCode() {
        return Integer.valueOf(this.f13927g).hashCode();
    }

    public String toString() {
        return "[" + this.f13927g + "]";
    }
}
