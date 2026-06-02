package com.jibo.api.iheart.model;

/* JADX INFO: loaded from: classes.dex */
public class Genre {

    /* JADX INFO: renamed from: a */
    private int f9285a;

    /* JADX INFO: renamed from: b */
    private String f9286b;

    /* JADX INFO: renamed from: c */
    private Station f9287c;

    public Genre(int i, String str) {
        this.f9285a = i;
        this.f9286b = str;
    }

    /* JADX INFO: renamed from: a */
    public int m9889a() {
        return this.f9285a;
    }

    /* JADX INFO: renamed from: b */
    public String m9890b() {
        return this.f9286b;
    }

    /* JADX INFO: renamed from: c */
    public Station m9891c() {
        return this.f9287c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Genre)) {
            return false;
        }
        Genre genre = (Genre) obj;
        if (genre.m9889a() != 0) {
            return genre.m9889a() == m9889a();
        }
        return false;
    }
}
