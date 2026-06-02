package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.util.MPLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GCMReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            m11720a(intent);
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            m11719a(context, intent);
        }
    }

    protected static class NotificationData {

        /* JADX INFO: renamed from: a */
        public final int f11870a;

        /* JADX INFO: renamed from: b */
        public final int f11871b;

        /* JADX INFO: renamed from: c */
        public final int f11872c;

        /* JADX INFO: renamed from: d */
        public final CharSequence f11873d;

        /* JADX INFO: renamed from: e */
        public final String f11874e;

        /* JADX INFO: renamed from: f */
        public final Intent f11875f;

        /* JADX INFO: renamed from: g */
        public final int f11876g;

        private NotificationData(int i, int i2, int i3, CharSequence charSequence, String str, Intent intent, int i4) {
            this.f11870a = i;
            this.f11871b = i2;
            this.f11872c = i3;
            this.f11873d = charSequence;
            this.f11874e = str;
            this.f11875f = intent;
            this.f11876g = i4;
        }
    }

    /* JADX INFO: renamed from: a */
    Intent m11724a(Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    }

    /* JADX INFO: renamed from: a */
    NotificationData m11725a(Context context, Intent intent, ResourceIds resourceIds) {
        int iMo11925b;
        int iMo11925b2;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        String stringExtra = intent.getStringExtra("mp_message");
        String stringExtra2 = intent.getStringExtra("mp_icnm");
        String stringExtra3 = intent.getStringExtra("mp_icnm_l");
        String stringExtra4 = intent.getStringExtra("mp_icnm_w");
        String stringExtra5 = intent.getStringExtra("mp_cta");
        CharSequence stringExtra6 = intent.getStringExtra("mp_title");
        String stringExtra7 = intent.getStringExtra("mp_color");
        String stringExtra8 = intent.getStringExtra("mp_campaign_id");
        String stringExtra9 = intent.getStringExtra("mp_message_id");
        String stringExtra10 = intent.getStringExtra("mp");
        int color = -1;
        m11721a(stringExtra8, stringExtra9, stringExtra10);
        if (stringExtra7 != null) {
            try {
                color = Color.parseColor(stringExtra7);
            } catch (IllegalArgumentException e) {
            }
        }
        if (stringExtra == null) {
            return null;
        }
        int iMo11925b3 = -1;
        if (stringExtra2 != null && resourceIds.mo11924a(stringExtra2)) {
            iMo11925b3 = resourceIds.mo11925b(stringExtra2);
        }
        if (stringExtra3 == null || !resourceIds.mo11924a(stringExtra3)) {
            iMo11925b = -1;
        } else {
            iMo11925b = resourceIds.mo11925b(stringExtra3);
        }
        if (stringExtra4 == null || !resourceIds.mo11924a(stringExtra4)) {
            iMo11925b2 = -1;
        } else {
            iMo11925b2 = resourceIds.mo11925b(stringExtra4);
        }
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            applicationInfo = null;
        }
        if (iMo11925b3 == -1 && applicationInfo != null) {
            iMo11925b3 = applicationInfo.icon;
        }
        int i = iMo11925b3 == -1 ? 17301651 : iMo11925b3;
        if (stringExtra6 == null && applicationInfo != null) {
            stringExtra6 = packageManager.getApplicationLabel(applicationInfo);
        }
        return new NotificationData(i, iMo11925b, iMo11925b2, stringExtra6 == null ? "A message for you" : stringExtra6, stringExtra, m11718a(context, stringExtra5, stringExtra8, stringExtra9, stringExtra10), color);
    }

    /* JADX INFO: renamed from: a */
    private Intent m11718a(Context context, String str, String str2, String str3, String str4) {
        Uri uri;
        Intent intent;
        if (str == null) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri == null) {
            intent = m11724a(context);
        } else {
            intent = new Intent("android.intent.action.VIEW", uri);
        }
        if (str2 != null) {
            intent.putExtra("mp_campaign_id", str2);
        }
        if (str3 != null) {
            intent.putExtra("mp_message_id", str3);
        }
        if (str4 != null) {
            intent.putExtra("mp", str4);
        }
        return intent;
    }

    /* JADX INFO: renamed from: b */
    private Notification m11722b(Context context, Intent intent, ResourceIds resourceIds) {
        NotificationData notificationDataM11725a = m11725a(context, intent, resourceIds);
        if (notificationDataM11725a == null) {
            return null;
        }
        MPLog.m12023b("MixpanelAPI.GCMReceiver", "MP GCM notification received: " + notificationDataM11725a.f11874e);
        PendingIntent activity = PendingIntent.getActivity(context, 0, notificationDataM11725a.f11875f, 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            return m11729e(context, activity, notificationDataM11725a);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return m11728d(context, activity, notificationDataM11725a);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return m11727c(context, activity, notificationDataM11725a);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return m11726b(context, activity, notificationDataM11725a);
        }
        return m11723a(context, activity, notificationDataM11725a);
    }

    /* JADX INFO: renamed from: a */
    private void m11720a(Intent intent) {
        final String stringExtra = intent.getStringExtra("registration_id");
        if (intent.getStringExtra("error") != null) {
            MPLog.m12030e("MixpanelAPI.GCMReceiver", "Error when registering for GCM: " + intent.getStringExtra("error"));
            return;
        }
        if (stringExtra != null) {
            MPLog.m12023b("MixpanelAPI.GCMReceiver", "Registering GCM ID: " + stringExtra);
            MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.GCMReceiver.1
                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
                /* JADX INFO: renamed from: a */
                public void mo11692a(MixpanelAPI mixpanelAPI) {
                    mixpanelAPI.m11842c().mo11869b(stringExtra);
                }
            });
        } else if (intent.getStringExtra("unregistered") != null) {
            MPLog.m12023b("MixpanelAPI.GCMReceiver", "Unregistering from GCM");
            MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.GCMReceiver.2
                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
                /* JADX INFO: renamed from: a */
                public void mo11692a(MixpanelAPI mixpanelAPI) {
                    mixpanelAPI.m11842c().mo11859a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11719a(Context context, Intent intent) {
        String strM11788x = MPConfig.m11762a(context).m11788x();
        if (strM11788x == null) {
            strM11788x = context.getPackageName();
        }
        Notification notificationM11722b = m11722b(context.getApplicationContext(), intent, new ResourceReader.Drawables(strM11788x, context));
        if (notificationM11722b != null) {
            ((NotificationManager) context.getSystemService("notification")).notify(0, notificationM11722b);
        }
    }

    @TargetApi(9)
    /* JADX INFO: renamed from: a */
    protected Notification m11723a(Context context, PendingIntent pendingIntent, NotificationData notificationData) {
        NotificationCompat.Builder builderM1742b = new NotificationCompat.Builder(context).m1732a(notificationData.f11870a).m1747c(notificationData.f11874e).m1733a(System.currentTimeMillis()).m1738a(notificationData.f11873d).m1744b(notificationData.f11874e).m1734a(pendingIntent).m1742b(MPConfig.m11762a(context).m11782r());
        if (notificationData.f11871b != -1) {
            builderM1742b.m1735a(BitmapFactory.decodeResource(context.getResources(), notificationData.f11871b));
        }
        Notification notificationM1731a = builderM1742b.m1731a();
        notificationM1731a.flags |= 16;
        return notificationM1731a;
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: b */
    protected Notification m11726b(Context context, PendingIntent pendingIntent, NotificationData notificationData) {
        Notification.Builder defaults = new Notification.Builder(context).setSmallIcon(notificationData.f11870a).setTicker(notificationData.f11874e).setWhen(System.currentTimeMillis()).setContentTitle(notificationData.f11873d).setContentText(notificationData.f11874e).setContentIntent(pendingIntent).setDefaults(MPConfig.m11762a(context).m11782r());
        if (notificationData.f11871b != -1) {
            defaults.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), notificationData.f11871b));
        }
        Notification notification = defaults.getNotification();
        notification.flags |= 16;
        return notification;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    /* JADX INFO: renamed from: c */
    protected Notification m11727c(Context context, PendingIntent pendingIntent, NotificationData notificationData) {
        Notification.Builder defaults = new Notification.Builder(context).setSmallIcon(notificationData.f11870a).setTicker(notificationData.f11874e).setWhen(System.currentTimeMillis()).setContentTitle(notificationData.f11873d).setContentText(notificationData.f11874e).setContentIntent(pendingIntent).setStyle(new Notification.BigTextStyle().bigText(notificationData.f11874e)).setDefaults(MPConfig.m11762a(context).m11782r());
        if (notificationData.f11871b != -1) {
            defaults.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), notificationData.f11871b));
        }
        Notification notificationBuild = defaults.build();
        notificationBuild.flags |= 16;
        return notificationBuild;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(21)
    /* JADX INFO: renamed from: d */
    protected Notification m11728d(Context context, PendingIntent pendingIntent, NotificationData notificationData) {
        Notification.Builder defaults = new Notification.Builder(context).setTicker(notificationData.f11874e).setWhen(System.currentTimeMillis()).setContentTitle(notificationData.f11873d).setContentText(notificationData.f11874e).setContentIntent(pendingIntent).setStyle(new Notification.BigTextStyle().bigText(notificationData.f11874e)).setDefaults(MPConfig.m11762a(context).m11782r());
        if (notificationData.f11872c != -1) {
            defaults.setSmallIcon(notificationData.f11872c);
        } else {
            defaults.setSmallIcon(notificationData.f11870a);
        }
        if (notificationData.f11871b != -1) {
            defaults.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), notificationData.f11871b));
        }
        if (notificationData.f11876g != -1) {
            defaults.setColor(notificationData.f11876g);
        }
        Notification notificationBuild = defaults.build();
        notificationBuild.flags |= 16;
        return notificationBuild;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(26)
    /* JADX INFO: renamed from: e */
    protected Notification m11729e(Context context, PendingIntent pendingIntent, NotificationData notificationData) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        String strM11785u = MPConfig.m11762a(context).m11785u();
        NotificationChannel notificationChannel = new NotificationChannel(strM11785u, MPConfig.m11762a(context).m11786v(), MPConfig.m11762a(context).m11787w());
        int iM11782r = MPConfig.m11762a(context).m11782r();
        if (iM11782r == 2 || iM11782r == -1) {
            notificationChannel.enableVibration(true);
        }
        if (iM11782r == 4 || iM11782r == -1) {
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-1);
        }
        notificationManager.createNotificationChannel(notificationChannel);
        Notification.Builder channelId = new Notification.Builder(context).setTicker(notificationData.f11874e).setWhen(System.currentTimeMillis()).setContentTitle(notificationData.f11873d).setContentText(notificationData.f11874e).setContentIntent(pendingIntent).setStyle(new Notification.BigTextStyle().bigText(notificationData.f11874e)).setChannelId(strM11785u);
        if (notificationData.f11872c != -1) {
            channelId.setSmallIcon(notificationData.f11872c);
        } else {
            channelId.setSmallIcon(notificationData.f11870a);
        }
        if (notificationData.f11871b != -1) {
            channelId.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), notificationData.f11871b));
        }
        if (notificationData.f11876g != -1) {
            channelId.setColor(notificationData.f11876g);
        }
        Notification notificationBuild = channelId.build();
        notificationBuild.flags |= 16;
        return notificationBuild;
    }

    /* JADX INFO: renamed from: a */
    private void m11721a(final String str, final String str2, final String str3) {
        if (str != null && str2 != null) {
            MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.GCMReceiver.3
                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
                /* JADX INFO: renamed from: a */
                public void mo11692a(MixpanelAPI mixpanelAPI) {
                    JSONObject jSONObject;
                    if (mixpanelAPI.m11846g()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject = str3 != null ? new JSONObject(str3) : jSONObject2;
                        } catch (JSONException e) {
                            jSONObject = jSONObject2;
                        }
                        try {
                            jSONObject.put("campaign_id", Integer.valueOf(str).intValue());
                            jSONObject.put("message_id", Integer.valueOf(str2).intValue());
                            jSONObject.put("message_type", "push");
                            mixpanelAPI.m11836a("$campaign_received", jSONObject);
                        } catch (JSONException e2) {
                        }
                    }
                }
            });
        }
    }
}
