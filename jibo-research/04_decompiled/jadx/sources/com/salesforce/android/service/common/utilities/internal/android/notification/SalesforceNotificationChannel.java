package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.annotation.TargetApi;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceNotificationChannel implements NotificationChannel {

    /* JADX INFO: renamed from: a */
    private NotificationChannel f13841a;

    public SalesforceNotificationChannel(String str, CharSequence charSequence, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f13841a = new OreoNotificationChannel(str, charSequence, i);
        } else {
            this.f13841a = new CompatNotificationChannel();
        }
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
    /* JADX INFO: renamed from: a */
    public String mo14122a() {
        return this.f13841a.mo14122a();
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
    /* JADX INFO: renamed from: b */
    public android.app.NotificationChannel mo14123b() {
        return this.f13841a.mo14123b();
    }

    @TargetApi(26)
    protected static class OreoNotificationChannel implements NotificationChannel {

        /* JADX INFO: renamed from: a */
        private android.app.NotificationChannel f13842a;

        OreoNotificationChannel(String str, CharSequence charSequence, int i) {
            this.f13842a = new android.app.NotificationChannel(str, charSequence, i);
        }

        @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
        /* JADX INFO: renamed from: a */
        public String mo14122a() {
            return this.f13842a.getId();
        }

        @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
        /* JADX INFO: renamed from: b */
        public android.app.NotificationChannel mo14123b() {
            return this.f13842a;
        }
    }

    protected static class CompatNotificationChannel implements NotificationChannel {
        protected CompatNotificationChannel() {
        }

        @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
        /* JADX INFO: renamed from: a */
        public String mo14122a() {
            return "";
        }

        @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel
        /* JADX INFO: renamed from: b */
        public android.app.NotificationChannel mo14123b() {
            throw new IllegalStateException("Notification Channels are not supported by this version of Android.");
        }
    }
}
