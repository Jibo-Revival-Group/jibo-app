package com.jibo.api.iheart.model;

/* JADX INFO: loaded from: classes.dex */
public class LocationConfig {

    /* JADX INFO: renamed from: a */
    private String f9288a;

    /* JADX INFO: renamed from: b */
    private Config f9289b;

    /* JADX INFO: renamed from: a */
    public String m9892a() {
        return this.f9289b != null ? this.f9289b.f9290a : "";
    }

    public LocationConfig(String str, Config config) {
        this.f9288a = str;
        this.f9289b = config;
    }

    public static class Config {

        /* JADX INFO: renamed from: a */
        private String f9290a;

        public Config(String str) {
            this.f9290a = str;
        }
    }
}
