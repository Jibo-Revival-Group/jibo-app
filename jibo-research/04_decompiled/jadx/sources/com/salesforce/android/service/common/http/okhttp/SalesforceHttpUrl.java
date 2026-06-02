package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceHttpUrl implements HttpUrl {

    /* JADX INFO: renamed from: a */
    private okhttp3.HttpUrl f13470a;

    /* JADX INFO: renamed from: a */
    public static SalesforceHttpUrl m13784a(okhttp3.HttpUrl httpUrl) {
        return new SalesforceHttpUrl(httpUrl);
    }

    protected SalesforceHttpUrl(okhttp3.HttpUrl httpUrl) {
        this.f13470a = httpUrl;
    }

    @Override // com.salesforce.android.service.common.http.HttpUrl
    /* JADX INFO: renamed from: a */
    public okhttp3.HttpUrl mo13778a() {
        return this.f13470a;
    }

    public String toString() {
        return this.f13470a.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && this.f13470a.equals(((HttpUrl) obj).mo13778a());
    }

    public int hashCode() {
        return this.f13470a.hashCode();
    }
}
