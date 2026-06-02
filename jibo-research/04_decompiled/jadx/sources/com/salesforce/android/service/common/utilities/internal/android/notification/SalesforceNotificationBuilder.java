package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceNotificationBuilder implements NotificationBuilder {

    /* JADX INFO: renamed from: a */
    private final NotificationCompat.Builder f13838a;

    protected SalesforceNotificationBuilder(NotificationCompat.Builder builder) {
        this.f13838a = builder;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private NotificationCompat.Builder f13839a;

        /* JADX INFO: renamed from: b */
        private String f13840b;

        /* JADX INFO: renamed from: a */
        public Builder m14127a(NotificationChannel notificationChannel) {
            if (notificationChannel != null) {
                this.f13840b = notificationChannel.mo14122a();
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public SalesforceNotificationBuilder m14128a(Context context) {
            if (this.f13840b == null && Build.VERSION.SDK_INT >= 26) {
                this.f13840b = "miscellaneous";
            }
            if (this.f13839a == null) {
                this.f13839a = new NotificationCompat.Builder(context, this.f13840b);
            }
            return new SalesforceNotificationBuilder(this.f13839a);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: a */
    public NotificationBuilder mo14116a(int i) {
        this.f13838a.m1732a(i);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public NotificationBuilder m14126a(CharSequence charSequence) {
        this.f13838a.m1744b(charSequence);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: a */
    public NotificationBuilder mo14117a(PendingIntent pendingIntent) {
        this.f13838a.m1734a(pendingIntent);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: a */
    public NotificationBuilder mo14119a(boolean z) {
        this.f13838a.m1740a(z);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: b */
    public NotificationBuilder mo14120b(int i) {
        this.f13838a.m1742b(i);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: c */
    public NotificationBuilder mo14121c(int i) {
        this.f13838a.m1746c(i);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: a */
    public NotificationBuilder mo14118a(NotificationCompat.Style style) {
        this.f13838a.m1737a(style);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder
    /* JADX INFO: renamed from: a */
    public Notification mo14115a() {
        return this.f13838a.m1741b();
    }
}
