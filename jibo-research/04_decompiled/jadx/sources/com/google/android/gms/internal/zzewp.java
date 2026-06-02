package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class zzewp {

    /* JADX INFO: renamed from: a */
    private final URL f7890a;

    public zzewp(URL url) {
        this.f7890a = url;
    }

    /* JADX INFO: renamed from: a */
    public final URLConnection m8603a() throws IOException {
        return this.f7890a.openConnection();
    }

    public final String toString() {
        return this.f7890a.toString();
    }
}
