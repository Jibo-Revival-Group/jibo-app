package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.zzv;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesUtil extends zzp {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        return GoogleApiAvailability.m6828a().m6836a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzp.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zzp.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return zzp.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zzp.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzp.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zzp.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability googleApiAvailabilityM6828a = GoogleApiAvailability.m6828a();
        if (fragment == null) {
            return googleApiAvailabilityM6828a.m6845b(activity, i, i2, onCancelListener);
        }
        GoogleApiAvailability.m6828a();
        Dialog dialogM6827a = GoogleApiAvailability.m6827a(activity, i, zzv.m7476a(fragment, zzf.m7528a(activity, i, "d"), i2), onCancelListener);
        if (dialogM6827a == null) {
            return false;
        }
        GoogleApiAvailability.m6831a(activity, dialogM6827a, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        GoogleApiAvailability googleApiAvailabilityM6828a = GoogleApiAvailability.m6828a();
        if (!zzp.zze(context, i)) {
            if (!(i == 9 ? zzp.zzv(context, "com.android.vending") : false)) {
                googleApiAvailabilityM6828a.m6839a(context, i);
                return;
            }
        }
        googleApiAvailabilityM6828a.m6844b(context);
    }
}
