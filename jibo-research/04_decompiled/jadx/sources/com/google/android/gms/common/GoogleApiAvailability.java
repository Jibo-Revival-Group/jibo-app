package com.google.android.gms.common;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zzbx;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;

/* JADX INFO: loaded from: classes.dex */
public class GoogleApiAvailability extends zzf {

    /* JADX INFO: renamed from: e */
    private String f6074e;

    /* JADX INFO: renamed from: c */
    private static final Object f6072c = new Object();

    /* JADX INFO: renamed from: d */
    private static final GoogleApiAvailability f6073d = new GoogleApiAvailability();

    /* JADX INFO: renamed from: a */
    public static final int f6071a = zzf.f6704b;

    @SuppressLint({"HandlerLeak"})
    class zza extends Handler {

        /* JADX INFO: renamed from: a */
        private final Context f6075a;

        public zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f6075a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int iMo6834a = GoogleApiAvailability.this.mo6834a(this.f6075a);
                    if (GoogleApiAvailability.this.mo6840a(iMo6834a)) {
                        GoogleApiAvailability.this.m6839a(this.f6075a, iMo6834a);
                    }
                    break;
                default:
                    Log.w("GoogleApiAvailability", new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what).toString());
                    break;
            }
        }
    }

    GoogleApiAvailability() {
    }

    /* JADX INFO: renamed from: a */
    public static Dialog m6826a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zzu.m7472c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        m6831a(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    /* JADX INFO: renamed from: a */
    static Dialog m6827a(Context context, int i, zzv zzvVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zzu.m7472c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strM7474e = zzu.m7474e(context, i);
        if (strM7474e != null) {
            builder.setPositiveButton(strM7474e, zzvVar);
        }
        String strM7467a = zzu.m7467a(context, i);
        if (strM7467a != null) {
            builder.setTitle(strM7467a);
        }
        return builder.create();
    }

    /* JADX INFO: renamed from: a */
    public static GoogleApiAvailability m6828a() {
        return f6073d;
    }

    /* JADX INFO: renamed from: a */
    public static zzbx m6829a(Context context, zzby zzbyVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zzbx zzbxVar = new zzbx(zzbyVar);
        context.registerReceiver(zzbxVar, intentFilter);
        zzbxVar.m7154a(context);
        if (zzp.zzv(context, "com.google.android.gms")) {
            return zzbxVar;
        }
        zzbyVar.mo7077a();
        zzbxVar.m7153a();
        return null;
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    private final String m6830a(Context context, NotificationManager notificationManager) {
        zzbq.m7378a(com.google.android.gms.common.util.zzq.m7517h());
        String strM6833c = m6833c();
        if (strM6833c == null) {
            strM6833c = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String strM7466a = zzu.m7466a(context);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", strM7466a, 4));
            } else if (!strM7466a.equals(notificationChannel.getName())) {
                notificationChannel.setName(strM7466a);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        return strM6833c;
    }

    /* JADX INFO: renamed from: a */
    static void m6831a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.m6848a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            ErrorDialogFragment.m6825a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @TargetApi(20)
    /* JADX INFO: renamed from: a */
    private final void m6832a(Context context, int i, String str, PendingIntent pendingIntent) {
        Notification notificationM1741b;
        int i2;
        if (i == 18) {
            m6844b(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strM7471b = zzu.m7471b(context, i);
        String strM7473d = zzu.m7473d(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (com.google.android.gms.common.util.zzi.m7503b(context)) {
            zzbq.m7378a(com.google.android.gms.common.util.zzq.m7514e());
            Notification.Builder builderAddAction = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(strM7471b).setStyle(new Notification.BigTextStyle().bigText(strM7473d)).addAction(com.google.android.gms.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.R.string.common_open_on_phone), pendingIntent);
            if (com.google.android.gms.common.util.zzq.m7517h() && com.google.android.gms.common.util.zzq.m7517h()) {
                builderAddAction.setChannelId(m6830a(context, notificationManager));
            }
            notificationM1741b = builderAddAction.build();
        } else {
            NotificationCompat.Builder builderM1737a = new NotificationCompat.Builder(context).m1732a(R.drawable.stat_sys_warning).m1747c(resources.getString(com.google.android.gms.R.string.common_google_play_services_notification_ticker)).m1733a(System.currentTimeMillis()).m1740a(true).m1734a(pendingIntent).m1738a((CharSequence) strM7471b).m1744b(strM7473d).m1745b(true).m1737a(new NotificationCompat.BigTextStyle().m1728b(strM7473d));
            if (com.google.android.gms.common.util.zzq.m7517h() && com.google.android.gms.common.util.zzq.m7517h()) {
                builderM1737a.m1739a(m6830a(context, notificationManager));
            }
            notificationM1741b = builderM1737a.m1741b();
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                i2 = 10436;
                zzp.zzfln.set(false);
                break;
            default:
                i2 = 39789;
                break;
        }
        notificationManager.notify(i2, notificationM1741b);
    }

    /* JADX INFO: renamed from: c */
    private final String m6833c() {
        String str;
        synchronized (f6072c) {
            str = this.f6074e;
        }
        return str;
    }

    @Override // com.google.android.gms.common.zzf
    /* JADX INFO: renamed from: a */
    public int mo6834a(Context context) {
        return super.mo6834a(context);
    }

    /* JADX INFO: renamed from: a */
    public Dialog m6835a(Activity activity, int i, int i2) {
        return m6836a(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    /* JADX INFO: renamed from: a */
    public Dialog m6836a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m6827a(activity, i, zzv.m7475a(activity, zzf.m7528a(activity, i, "d"), i2), onCancelListener);
    }

    @Override // com.google.android.gms.common.zzf
    /* JADX INFO: renamed from: a */
    public PendingIntent mo6837a(Context context, int i, int i2) {
        return super.mo6837a(context, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public PendingIntent m6838a(Context context, ConnectionResult connectionResult) {
        return connectionResult.m6820a() ? connectionResult.m6823d() : mo6837a(context, connectionResult.m6822c(), 0);
    }

    /* JADX INFO: renamed from: a */
    public void m6839a(Context context, int i) {
        m6832a(context, i, (String) null, m7534a(context, i, 0, "n"));
    }

    @Override // com.google.android.gms.common.zzf
    /* JADX INFO: renamed from: a */
    public final boolean mo6840a(int i) {
        return super.mo6840a(i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6841a(Activity activity, zzcf zzcfVar, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM6827a = m6827a(activity, i, zzv.m7477a(zzcfVar, zzf.m7528a(activity, i, "d"), 2), onCancelListener);
        if (dialogM6827a == null) {
            return false;
        }
        m6831a(activity, dialogM6827a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6842a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntentM6838a = m6838a(context, connectionResult);
        if (pendingIntentM6838a == null) {
            return false;
        }
        m6832a(context, connectionResult.m6822c(), (String) null, GoogleApiActivity.m6884a(context, pendingIntentM6838a, i));
        return true;
    }

    @Override // com.google.android.gms.common.zzf
    /* JADX INFO: renamed from: b */
    public final String mo6843b(int i) {
        return super.mo6843b(i);
    }

    /* JADX INFO: renamed from: b */
    final void m6844b(Context context) {
        new zza(context).sendEmptyMessageDelayed(1, 120000L);
    }

    /* JADX INFO: renamed from: b */
    public boolean m6845b(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM6836a = m6836a(activity, i, i2, onCancelListener);
        if (dialogM6836a == null) {
            return false;
        }
        m6831a(activity, dialogM6836a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
