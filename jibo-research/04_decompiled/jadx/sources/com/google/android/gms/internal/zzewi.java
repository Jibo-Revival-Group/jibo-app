package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
enum zzewi {
    NETWORK("network", 10, 700, 10, 70),
    TRACE("trace", 10, 300, 10, 30);

    private final String prefix;
    private final int zzocr;
    private final int zzoct;
    private final int zzocq = 10;
    private final int zzocs = 10;

    zzewi(String str, int i, int i2, int i3, int i4) {
        this.prefix = str;
        this.zzocr = i2;
        this.zzoct = i4;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return name();
    }

    public final int zzckf() {
        return this.zzocq;
    }

    public final int zzckg() {
        return this.zzocr;
    }

    public final int zzckh() {
        return this.zzocs;
    }

    public final int zzcki() {
        return this.zzoct;
    }

    public final String zzckj() {
        return String.valueOf(this.prefix).concat("_flimit_time");
    }

    public final String zzckk() {
        return String.valueOf(this.prefix).concat("_flimit_events");
    }

    public final String zzckl() {
        return String.valueOf(this.prefix).concat("_blimit_time");
    }

    public final String zzckm() {
        return String.valueOf(this.prefix).concat("_blimit_events");
    }
}
