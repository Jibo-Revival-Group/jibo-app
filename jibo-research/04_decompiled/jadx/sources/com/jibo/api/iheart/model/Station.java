package com.jibo.api.iheart.model;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Station {

    /* JADX INFO: renamed from: a */
    private int f9291a;

    /* JADX INFO: renamed from: b */
    private String f9292b;

    /* JADX INFO: renamed from: c */
    private String f9293c;

    /* JADX INFO: renamed from: d */
    private List<Market> f9294d;

    /* JADX INFO: renamed from: e */
    private String f9295e;

    public Station(int i, String str, String str2, String str3) {
        this.f9291a = i;
        this.f9292b = str;
        this.f9293c = str2;
        this.f9295e = str3;
    }

    /* JADX INFO: renamed from: a */
    public int m9894a() {
        return this.f9291a;
    }

    /* JADX INFO: renamed from: b */
    public String m9895b() {
        return this.f9292b;
    }

    /* JADX INFO: renamed from: c */
    public String m9896c() {
        return this.f9293c;
    }

    /* JADX INFO: renamed from: d */
    public String m9897d() {
        Market market = (this.f9294d == null || this.f9294d.isEmpty()) ? null : this.f9294d.get(0);
        if (market == null) {
            return "";
        }
        return market.f9296a;
    }

    /* JADX INFO: renamed from: e */
    public String m9898e() {
        Market market = (this.f9294d == null || this.f9294d.isEmpty()) ? null : this.f9294d.get(0);
        if (market == null) {
            return "";
        }
        return market.f9297b;
    }

    /* JADX INFO: renamed from: f */
    public String m9899f() {
        return "Digital".equals(m9897d()) ? "Digital" : m9897d() + ", " + m9898e();
    }

    /* JADX INFO: renamed from: g */
    public String m9900g() {
        return this.f9295e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Station)) {
            return false;
        }
        Station station = (Station) obj;
        if (station.m9894a() != 0) {
            return station.m9894a() == m9894a();
        }
        return false;
    }

    public static class Market {

        /* JADX INFO: renamed from: a */
        private String f9296a;

        /* JADX INFO: renamed from: b */
        private String f9297b;
    }
}
