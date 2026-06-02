package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceNotificationManager implements NotificationManager {

    /* JADX INFO: renamed from: a */
    private NotificationManagerCompat f13843a;

    /* JADX INFO: renamed from: b */
    private android.app.NotificationManager f13844b;

    /* JADX INFO: renamed from: a */
    public static SalesforceNotificationManager m14129a(Context context) {
        return new SalesforceNotificationManager(context);
    }

    private SalesforceNotificationManager(Context context) {
        this.f13843a = NotificationManagerCompat.m1763a(context);
        this.f13844b = (android.app.NotificationManager) context.getSystemService("notification");
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager
    /* JADX INFO: renamed from: a */
    public void mo14124a(int i, Notification notification) {
        this.f13843a.m1767a(i, notification);
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager
    /* JADX INFO: renamed from: a */
    public void mo14125a(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f13844b.createNotificationChannel(notificationChannel.mo14123b());
        }
    }
}
