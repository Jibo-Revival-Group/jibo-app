package com.mixpanel.android.viewcrawler;

/* JADX INFO: loaded from: classes.dex */
class PropertyDescription {

    /* JADX INFO: renamed from: a */
    public final String f12154a;

    /* JADX INFO: renamed from: b */
    public final Class<?> f12155b;

    /* JADX INFO: renamed from: c */
    public final Caller f12156c;

    /* JADX INFO: renamed from: d */
    private final String f12157d;

    public PropertyDescription(String str, Class<?> cls, Caller caller, String str2) {
        this.f12154a = str;
        this.f12155b = cls;
        this.f12156c = caller;
        this.f12157d = str2;
    }

    /* JADX INFO: renamed from: a */
    public Caller m12097a(Object[] objArr) throws NoSuchMethodException {
        if (this.f12157d == null) {
            return null;
        }
        return new Caller(this.f12155b, this.f12157d, objArr, Void.TYPE);
    }

    public String toString() {
        return "[PropertyDescription " + this.f12154a + "," + this.f12155b + ", " + this.f12156c + "/" + this.f12157d + "]";
    }
}
