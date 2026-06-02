package com.jibo.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/* JADX INFO: loaded from: classes.dex */
public class ServiceUtils {
    /* JADX INFO: renamed from: a */
    private static String m11425a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        NotificationChannel notificationChannel = new NotificationChannel("my_service", "My Background Service", 0);
        notificationChannel.setLightColor(-16776961);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        return "my_service";
    }

    /* JADX INFO: renamed from: a */
    public static void m11427a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 26) {
            context.startService(intent);
        } else {
            context.startForegroundService(intent);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11426a(Service service) {
        service.startForeground(1, new NotificationCompat.Builder(service, m11425a((Context) service)).m1741b());
    }

    /* JADX INFO: renamed from: b */
    public static void m11428b(Service service) {
        service.stopForeground(true);
    }
}
