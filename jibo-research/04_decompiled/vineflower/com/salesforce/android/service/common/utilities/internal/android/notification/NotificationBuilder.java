package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;

public interface NotificationBuilder {
   Notification a();

   NotificationBuilder a(int var1);

   NotificationBuilder a(PendingIntent var1);

   NotificationBuilder a(NotificationCompat.Style var1);

   NotificationBuilder a(boolean var1);

   NotificationBuilder b(int var1);

   NotificationBuilder c(int var1);
}
