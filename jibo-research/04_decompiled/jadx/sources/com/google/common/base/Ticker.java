package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
public abstract class Ticker {

    /* JADX INFO: renamed from: a */
    private static final Ticker f8575a = new Ticker() { // from class: com.google.common.base.Ticker.1
        @Override // com.google.common.base.Ticker
        /* JADX INFO: renamed from: a */
        public long mo9044a() {
            return Platform.m9010a();
        }
    };

    /* JADX INFO: renamed from: a */
    public abstract long mo9044a();

    protected Ticker() {
    }

    /* JADX INFO: renamed from: b */
    public static Ticker m9043b() {
        return f8575a;
    }
}
