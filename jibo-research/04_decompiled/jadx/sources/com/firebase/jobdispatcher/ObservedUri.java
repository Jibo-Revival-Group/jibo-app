package com.firebase.jobdispatcher;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class ObservedUri {

    /* JADX INFO: renamed from: a */
    private final Uri f5782a;

    /* JADX INFO: renamed from: b */
    private final int f5783b;

    public ObservedUri(Uri uri, int i) {
        if (uri == null) {
            throw new IllegalArgumentException("URI must not be null.");
        }
        this.f5782a = uri;
        this.f5783b = i;
    }

    /* JADX INFO: renamed from: a */
    public Uri m6637a() {
        return this.f5782a;
    }

    /* JADX INFO: renamed from: b */
    public int m6638b() {
        return this.f5783b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObservedUri)) {
            return false;
        }
        ObservedUri observedUri = (ObservedUri) obj;
        return this.f5783b == observedUri.f5783b && this.f5782a.equals(observedUri.f5782a);
    }

    public int hashCode() {
        return this.f5782a.hashCode() ^ this.f5783b;
    }
}
