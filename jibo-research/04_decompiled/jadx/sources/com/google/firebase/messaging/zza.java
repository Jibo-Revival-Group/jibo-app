package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.R;
import com.google.android.gms.common.util.zzq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zza {

    /* JADX INFO: renamed from: a */
    private static zza f8712a;

    /* JADX INFO: renamed from: b */
    private final Context f8713b;

    /* JADX INFO: renamed from: c */
    private Bundle f8714c;

    /* JADX INFO: renamed from: d */
    private Method f8715d;

    /* JADX INFO: renamed from: e */
    private Method f8716e;

    /* JADX INFO: renamed from: f */
    private final AtomicInteger f8717f = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.f8713b = context.getApplicationContext();
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    private final Notification m9200a(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Notification.Builder smallIcon = new Notification.Builder(this.f8713b).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.f8715d == null) {
                this.f8715d = m9204a("setChannelId");
            }
            if (this.f8715d == null) {
                this.f8715d = m9204a("setChannel");
            }
            if (this.f8715d == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    this.f8715d.invoke(smallIcon, str2);
                } catch (IllegalAccessException e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                } catch (IllegalArgumentException e2) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
                } catch (SecurityException e3) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e3);
                } catch (InvocationTargetException e4) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e4);
                }
            }
        }
        return smallIcon.build();
    }

    /* JADX INFO: renamed from: a */
    private final Bundle m9201a() {
        if (this.f8714c != null) {
            return this.f8714c;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.f8713b.getPackageManager().getApplicationInfo(this.f8713b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.f8714c = applicationInfo.metaData;
        return this.f8714c;
    }

    /* JADX INFO: renamed from: a */
    static synchronized zza m9202a(Context context) {
        if (f8712a == null) {
            f8712a = new zza(context);
        }
        return f8712a;
    }

    /* JADX INFO: renamed from: a */
    static String m9203a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    private static Method m9204a(String str) {
        try {
            return Notification.Builder.class.getMethod(str, String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m9205a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    private final boolean m9206a(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            Drawable drawable = this.f8713b.getResources().getDrawable(i, null);
            if (drawable.getBounds().height() != 0 && drawable.getBounds().width() != 0) {
                return true;
            }
            Log.e("FirebaseMessaging", new StringBuilder(72).append("Icon with id: ").append(i).append(" uses an invalid gradient. Using fallback icon.").toString());
            return false;
        } catch (Resources.NotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m9207a(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(m9203a(bundle, "gcm.n.e")) || m9203a(bundle, "gcm.n.icon") != null;
    }

    /* JADX INFO: renamed from: b */
    static Uri m9208b(Bundle bundle) {
        String strM9203a = m9203a(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(strM9203a)) {
            strM9203a = m9203a(bundle, "gcm.n.link");
        }
        if (TextUtils.isEmpty(strM9203a)) {
            return null;
        }
        return Uri.parse(strM9203a);
    }

    /* JADX INFO: renamed from: b */
    private final Integer m9209b(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException e) {
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.").toString());
            }
        }
        int i = m9201a().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.m1840c(this.f8713b, i));
        } catch (Resources.NotFoundException e2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    static String m9210b(Bundle bundle, String str) {
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_key");
        return m9203a(bundle, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: c */
    private final String m9211c(String str) {
        if (!zzq.m7517h()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.f8713b.getSystemService(NotificationManager.class);
        try {
            if (this.f8716e == null) {
                this.f8716e = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.f8716e.invoke(notificationManager, str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 122).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.").toString());
            }
            String string = m9201a().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (this.f8716e.invoke(notificationManager, string) != null) {
                    return string;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (this.f8716e.invoke(notificationManager, "fcm_fallback_notification_channel") == null) {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.f8713b.getString(R.string.fcm_fallback_notification_channel_label), 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (ClassNotFoundException e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e3);
            return null;
        } catch (InstantiationException e4) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e4);
            return null;
        } catch (LinkageError e5) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e5);
            return null;
        } catch (NoSuchMethodException e6) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e6);
            return null;
        } catch (SecurityException e7) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e7);
            return null;
        } catch (InvocationTargetException e8) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e8);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    static Object[] m9212c(Bundle bundle, String str) {
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_args");
        String strM9203a = m9203a(bundle, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (TextUtils.isEmpty(strM9203a)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(strM9203a);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            String strValueOf3 = String.valueOf(str);
            String strValueOf4 = String.valueOf("_loc_args");
            String strSubstring = (strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).substring(6);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strSubstring).length() + 41 + String.valueOf(strM9203a).length()).append("Malformed ").append(strSubstring).append(": ").append(strM9203a).append("  Default value will be used.").toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    static String m9213d(Bundle bundle) {
        String strM9203a = m9203a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(strM9203a) ? m9203a(bundle, "gcm.n.sound") : strM9203a;
    }

    /* JADX INFO: renamed from: d */
    private final String m9214d(Bundle bundle, String str) {
        String strM9203a = m9203a(bundle, str);
        if (!TextUtils.isEmpty(strM9203a)) {
            return strM9203a;
        }
        String strM9210b = m9210b(bundle, str);
        if (TextUtils.isEmpty(strM9210b)) {
            return null;
        }
        Resources resources = this.f8713b.getResources();
        int identifier = resources.getIdentifier(strM9210b, "string", this.f8713b.getPackageName());
        if (identifier == 0) {
            String strValueOf = String.valueOf(str);
            String strValueOf2 = String.valueOf("_loc_key");
            String strSubstring = (strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).substring(6);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(strM9210b).length()).append(strSubstring).append(" resource not found: ").append(strM9210b).append(" Default value will be used.").toString());
            return null;
        }
        Object[] objArrM9212c = m9212c(bundle, str);
        if (objArrM9212c == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrM9212c);
        } catch (MissingFormatArgumentException e) {
            String string = Arrays.toString(objArrM9212c);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strM9210b).length() + 58 + String.valueOf(string).length()).append("Missing format argument for ").append(strM9210b).append(": ").append(string).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    private final PendingIntent m9215e(Bundle bundle) {
        Intent intent;
        String strM9203a = m9203a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(strM9203a)) {
            Uri uriM9208b = m9208b(bundle);
            if (uriM9208b != null) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setPackage(this.f8713b.getPackageName());
                intent2.setData(uriM9208b);
                intent = intent2;
            } else {
                Intent launchIntentForPackage = this.f8713b.getPackageManager().getLaunchIntentForPackage(this.f8713b.getPackageName());
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
                intent = launchIntentForPackage;
            }
        } else {
            Intent intent3 = new Intent(strM9203a);
            intent3.setPackage(this.f8713b.getPackageName());
            intent3.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent = intent3;
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.m9193a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f8713b, this.f8717f.incrementAndGet(), intent, 1073741824);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c4  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean m9216c(android.os.Bundle r14) {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.m9216c(android.os.Bundle):boolean");
    }
}
