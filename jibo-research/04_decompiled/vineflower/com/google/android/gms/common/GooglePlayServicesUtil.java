package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.zzv;

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
   public static Dialog getErrorDialog(int var0, Activity var1, int var2) {
      return getErrorDialog(var0, var1, var2, null);
   }

   @Deprecated
   public static Dialog getErrorDialog(int var0, Activity var1, int var2, OnCancelListener var3) {
      int var4 = var0;
      if (zzp.zze(var1, var0)) {
         var4 = 18;
      }

      return GoogleApiAvailability.a().a(var1, var4, var2, var3);
   }

   @Deprecated
   public static PendingIntent getErrorPendingIntent(int var0, Context var1, int var2) {
      return zzp.getErrorPendingIntent(var0, var1, var2);
   }

   @Deprecated
   public static String getErrorString(int var0) {
      return zzp.getErrorString(var0);
   }

   public static Context getRemoteContext(Context var0) {
      return zzp.getRemoteContext(var0);
   }

   public static Resources getRemoteResource(Context var0) {
      return zzp.getRemoteResource(var0);
   }

   @Deprecated
   public static int isGooglePlayServicesAvailable(Context var0) {
      return zzp.isGooglePlayServicesAvailable(var0);
   }

   @Deprecated
   public static boolean isUserRecoverableError(int var0) {
      return zzp.isUserRecoverableError(var0);
   }

   @Deprecated
   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2) {
      return showErrorDialogFragment(var0, var1, var2, null);
   }

   @Deprecated
   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2, OnCancelListener var3) {
      return showErrorDialogFragment(var0, var1, null, var2, var3);
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      int var5 = var0;
      if (zzp.zze(var1, var0)) {
         var5 = 18;
      }

      GoogleApiAvailability var7 = GoogleApiAvailability.a();
      boolean var6;
      if (var2 == null) {
         var6 = var7.b(var1, var5, var3, var4);
      } else {
         GoogleApiAvailability.a();
         Dialog var8 = GoogleApiAvailability.a(var1, var5, zzv.a(var2, zzf.a(var1, var5, "d"), var3), var4);
         if (var8 == null) {
            var6 = false;
         } else {
            GoogleApiAvailability.a(var1, var8, "GooglePlayServicesErrorDialog", var4);
            var6 = true;
         }
      }

      return var6;
   }

   @Deprecated
   public static void showErrorNotification(int var0, Context var1) {
      GoogleApiAvailability var3 = GoogleApiAvailability.a();
      if (!zzp.zze(var1, var0)) {
         boolean var2;
         if (var0 == 9) {
            var2 = zzp.zzv(var1, "com.android.vending");
         } else {
            var2 = false;
         }

         if (!var2) {
            var3.a(var1, var0);
            return;
         }
      }

      var3.b(var1);
   }
}
