package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class DeviceIdentifier {

    /* JADX INFO: renamed from: a */
    private final SharedPreferences f13866a;

    /* JADX INFO: renamed from: b */
    private final String f13867b;

    protected DeviceIdentifier(Builder builder) {
        this.f13866a = builder.f13868a;
        if (m14146b()) {
            this.f13867b = m14147c();
        } else {
            this.f13867b = builder.f13869b.m14114a().toString();
            m14145a(this.f13867b);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14148a() {
        return this.f13867b;
    }

    /* JADX INFO: renamed from: b */
    private boolean m14146b() {
        return this.f13866a.contains("unique_device_id");
    }

    /* JADX INFO: renamed from: a */
    private void m14145a(String str) {
        this.f13866a.edit().putString("unique_device_id", str).apply();
    }

    /* JADX INFO: renamed from: c */
    private String m14147c() {
        return this.f13866a.getString("unique_device_id", "UNKNOWN-DEVICE-ID");
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected SharedPreferences f13868a;

        /* JADX INFO: renamed from: b */
        protected UUIDProvider f13869b;

        /* JADX INFO: renamed from: c */
        private Context f13870c;

        /* JADX INFO: renamed from: a */
        public Builder m14149a(Context context) {
            this.f13870c = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public DeviceIdentifier m14150a() {
            Arguments.m14235a(this.f13870c);
            if (this.f13868a == null) {
                this.f13868a = this.f13870c.getSharedPreferences("com.salesforce.android.service", 0);
            }
            if (this.f13869b == null) {
                this.f13869b = new UUIDProvider();
            }
            return new DeviceIdentifier(this);
        }
    }
}
