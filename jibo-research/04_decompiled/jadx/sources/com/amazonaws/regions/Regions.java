package com.amazonaws.regions;

/* JADX INFO: loaded from: classes.dex */
public enum Regions {
    ApiDev("api-dev"),
    ServerDev("srvdev1-services"),
    Stage1("stg1-entrypoint"),
    Stage2("stg2-entrypoint");

    public static final Regions DEFAULT_REGION = ApiDev;
    private final String name;

    Regions(String str) {
        this.name = str;
    }

    public static Regions fromName(String str) {
        for (Regions regions : values()) {
            if (str.equals(regions.getName())) {
                return regions;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String getName() {
        return this.name;
    }
}
