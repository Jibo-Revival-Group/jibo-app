package com.fasterxml.jackson.core;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonStreamContext {

    /* JADX INFO: renamed from: a */
    protected int f5414a;

    /* JADX INFO: renamed from: b */
    protected int f5415b;

    protected JsonStreamContext() {
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6078a() {
        return this.f5414a == 1;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m6079b() {
        return this.f5414a == 0;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m6080c() {
        return this.f5414a == 2;
    }

    /* JADX INFO: renamed from: d */
    public final String m6081d() {
        switch (this.f5414a) {
            case 0:
                return "ROOT";
            case 1:
                return "ARRAY";
            case 2:
                return "OBJECT";
            default:
                return "?";
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m6082e() {
        return this.f5415b + 1;
    }

    /* JADX INFO: renamed from: f */
    public final int m6083f() {
        if (this.f5415b < 0) {
            return 0;
        }
        return this.f5415b;
    }
}
