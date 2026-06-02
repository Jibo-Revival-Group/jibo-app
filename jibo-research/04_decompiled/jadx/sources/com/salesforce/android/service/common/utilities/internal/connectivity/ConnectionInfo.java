package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.net.NetworkInfo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionInfo {

    /* JADX INFO: renamed from: a */
    private final Technology f13845a;

    /* JADX INFO: renamed from: b */
    private final RadioType f13846b;

    /* JADX INFO: renamed from: c */
    private final boolean f13847c;

    protected ConnectionInfo(Builder builder) {
        NetworkInfo networkInfo = builder.f13848a;
        if (networkInfo == null) {
            this.f13845a = Technology.WIFI;
            this.f13846b = RadioType.UNKNOWN;
            this.f13847c = false;
        } else {
            this.f13845a = Technology.fromType(networkInfo.getType());
            this.f13846b = RadioType.fromType(networkInfo.getSubtype());
            this.f13847c = networkInfo.isConnected();
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m14130a() {
        return this.f13847c;
    }

    /* JADX INFO: renamed from: b */
    public Technology m14131b() {
        return this.f13845a;
    }

    /* JADX INFO: renamed from: c */
    public RadioType m14132c() {
        return this.f13846b;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "ConnectionInfo[IsConnected=%s, Technology=%s, RadioType=%s]", Boolean.valueOf(this.f13847c), this.f13845a, this.f13846b);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected NetworkInfo f13848a;

        /* JADX INFO: renamed from: a */
        public Builder m14133a(NetworkInfo networkInfo) {
            this.f13848a = networkInfo;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ConnectionInfo m14134a() {
            return new ConnectionInfo(this);
        }
    }
}
