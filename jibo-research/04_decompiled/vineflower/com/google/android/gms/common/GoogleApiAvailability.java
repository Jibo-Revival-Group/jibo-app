package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.Notification.BigTextStyle;
import android.content.Context;
import android.content.IntentFilter;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.R;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zzbx;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;

public class GoogleApiAvailability extends zzf {
   public static final int a = zzf.b;
   private static final Object c = new Object();
   private static final GoogleApiAvailability d = new GoogleApiAvailability();
   private String e;

   GoogleApiAvailability() {
   }

   public static Dialog a(Activity var0, OnCancelListener var1) {
      ProgressBar var3 = new ProgressBar(var0, null, 16842874);
      var3.setIndeterminate(true);
      var3.setVisibility(0);
      Builder var2 = new Builder(var0);
      var2.setView(var3);
      var2.setMessage(zzu.c(var0, 18));
      var2.setPositiveButton("", null);
      AlertDialog var4 = var2.create();
      a(var0, var4, "GooglePlayServicesUpdatingDialog", var1);
      return var4;
   }

   static Dialog a(Context var0, int var1, zzv var2, OnCancelListener var3) {
      Builder var4 = null;
      TypedValue var5 = null;
      AlertDialog var6;
      if (var1 == 0) {
         var6 = var5;
      } else {
         var5 = new TypedValue();
         var0.getTheme().resolveAttribute(16843529, var5, true);
         if ("Theme.Dialog.Alert".equals(var0.getResources().getResourceEntryName(var5.resourceId))) {
            var4 = new Builder(var0, 5);
         }

         Builder var10 = var4;
         if (var4 == null) {
            var10 = new Builder(var0);
         }

         var10.setMessage(zzu.c(var0, var1));
         if (var3 != null) {
            var10.setOnCancelListener(var3);
         }

         String var8 = zzu.e(var0, var1);
         if (var8 != null) {
            var10.setPositiveButton(var8, var2);
         }

         String var7 = zzu.a(var0, var1);
         if (var7 != null) {
            var10.setTitle(var7);
         }

         var6 = var10.create();
      }

      return var6;
   }

   public static GoogleApiAvailability a() {
      return d;
   }

   public static zzbx a(Context var0, zzby var1) {
      IntentFilter var2 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
      var2.addDataScheme("package");
      zzbx var3 = new zzbx(var1);
      var0.registerReceiver(var3, var2);
      var3.a(var0);
      zzbx var4 = var3;
      if (!zzp.zzv(var0, "com.google.android.gms")) {
         var1.a();
         var3.a();
         var4 = null;
      }

      return var4;
   }

   @TargetApi(26)
   private final String a(Context var1, NotificationManager var2) {
      zzbq.a(com.google.android.gms.common.util.zzq.h());
      String var4 = this.c();
      String var3 = var4;
      if (var4 == null) {
         var4 = "com.google.android.gms.availability";
         NotificationChannel var5 = var2.getNotificationChannel("com.google.android.gms.availability");
         String var6 = zzu.a(var1);
         if (var5 == null) {
            var2.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", var6, 4));
            var3 = var4;
         } else {
            var3 = var4;
            if (!var6.equals(var5.getName())) {
               var5.setName(var6);
               var2.createNotificationChannel(var5);
               var3 = var4;
            }
         }
      }

      return var3;
   }

   static void a(Activity var0, Dialog var1, String var2, OnCancelListener var3) {
      if (var0 instanceof FragmentActivity) {
         FragmentManager var4 = ((FragmentActivity)var0).getSupportFragmentManager();
         SupportErrorDialogFragment.a(var1, var3).show(var4, var2);
      } else {
         android.app.FragmentManager var5 = var0.getFragmentManager();
         ErrorDialogFragment.a(var1, var3).show(var5, var2);
      }
   }

   @TargetApi(20)
   private final void a(Context var1, int var2, String var3, PendingIntent var4) {
      if (var2 == 18) {
         this.b(var1);
      } else if (var4 == null) {
         if (var2 == 6) {
            Log.w(
               "GoogleApiAvailability",
               "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead."
            );
         }
      } else {
         String var5 = zzu.b(var1, var2);
         String var6 = zzu.d(var1, var2);
         Resources var7 = var1.getResources();
         NotificationManager var10 = (NotificationManager)var1.getSystemService("notification");
         Notification var8;
         if (com.google.android.gms.common.util.zzi.b(var1)) {
            zzbq.a(com.google.android.gms.common.util.zzq.e());
            android.app.Notification.Builder var11 = new android.app.Notification.Builder(var1)
               .setSmallIcon(var1.getApplicationInfo().icon)
               .setPriority(2)
               .setAutoCancel(true)
               .setContentTitle(var5)
               .setStyle(new BigTextStyle().bigText(var6))
               .addAction(R.drawable.common_full_open_on_phone, var7.getString(R.string.common_open_on_phone), var4);
            if (com.google.android.gms.common.util.zzq.h() && com.google.android.gms.common.util.zzq.h()) {
               var11.setChannelId(this.a(var1, var10));
            }

            var8 = var11.build();
         } else {
            NotificationCompat.Builder var12 = new NotificationCompat.Builder(var1)
               .a(17301642)
               .c(var7.getString(R.string.common_google_play_services_notification_ticker))
               .a(System.currentTimeMillis())
               .a(true)
               .a(var4)
               .a((CharSequence)var5)
               .b(var6)
               .b(true)
               .a(new NotificationCompat.BigTextStyle().b(var6));
            if (com.google.android.gms.common.util.zzq.h() && com.google.android.gms.common.util.zzq.h()) {
               var12.a(this.a(var1, var10));
            }

            var8 = var12.b();
         }

         char var9;
         switch (var2) {
            case 1:
            case 2:
            case 3:
               var9 = 10436;
               zzp.zzfln.set(false);
               break;
            default:
               var9 = '魭';
         }

         var10.notify(var9, var8);
      }
   }

   private final String c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/common/GoogleApiAvailability.c Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield com/google/android/gms/common/GoogleApiAvailability.e Ljava/lang/String;
      // 0a: astore 2
      // 0b: aload 1
      // 0c: monitorexit
      // 0d: aload 2
      // 0e: areturn
      // 0f: astore 2
      // 10: aload 1
      // 11: monitorexit
      // 12: aload 2
      // 13: athrow
      // try (4 -> 9): 11 null
      // try (12 -> 14): 11 null
   }

   @Override
   public int a(Context var1) {
      return super.a(var1);
   }

   public Dialog a(Activity var1, int var2, int var3) {
      return this.a(var1, var2, var3, null);
   }

   public Dialog a(Activity var1, int var2, int var3, OnCancelListener var4) {
      return a(var1, var2, zzv.a(var1, zzf.a(var1, var2, "d"), var3), var4);
   }

   @Override
   public PendingIntent a(Context var1, int var2, int var3) {
      return super.a(var1, var2, var3);
   }

   public PendingIntent a(Context var1, ConnectionResult var2) {
      PendingIntent var3;
      if (var2.a()) {
         var3 = var2.d();
      } else {
         var3 = this.a(var1, var2.c(), 0);
      }

      return var3;
   }

   public void a(Context var1, int var2) {
      this.a(var1, var2, null, this.a(var1, var2, 0, "n"));
   }

   @Override
   public final boolean a(int var1) {
      return super.a(var1);
   }

   public final boolean a(Activity var1, zzcf var2, int var3, int var4, OnCancelListener var5) {
      Dialog var7 = a(var1, var3, zzv.a(var2, zzf.a(var1, var3, "d"), 2), var5);
      boolean var6;
      if (var7 == null) {
         var6 = false;
      } else {
         a(var1, var7, "GooglePlayServicesErrorDialog", var5);
         var6 = true;
      }

      return var6;
   }

   public final boolean a(Context var1, ConnectionResult var2, int var3) {
      PendingIntent var5 = this.a(var1, var2);
      boolean var4;
      if (var5 != null) {
         this.a(var1, var2.c(), null, GoogleApiActivity.a(var1, var5, var3));
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public final String b(int var1) {
      return super.b(var1);
   }

   final void b(Context var1) {
      new GoogleApiAvailability.zza(this, var1).sendEmptyMessageDelayed(1, 120000L);
   }

   public boolean b(Activity var1, int var2, int var3, OnCancelListener var4) {
      Dialog var6 = this.a(var1, var2, var3, var4);
      boolean var5;
      if (var6 == null) {
         var5 = false;
      } else {
         a(var1, var6, "GooglePlayServicesErrorDialog", var4);
         var5 = true;
      }

      return var5;
   }

   @SuppressLint("HandlerLeak")
   final class zza extends Handler {
      private final Context a;
      private GoogleApiAvailability b;

      public zza(GoogleApiAvailability var1, Context var2) {
         this.b = var1;
         Looper var3;
         if (Looper.myLooper() == null) {
            var3 = Looper.getMainLooper();
         } else {
            var3 = Looper.myLooper();
         }

         super(var3);
         this.a = var2.getApplicationContext();
      }

      public final void handleMessage(Message var1) {
         switch (var1.what) {
            case 1:
               int var3 = this.b.a(this.a);
               if (this.b.a(var3)) {
                  this.b.a(this.a, var3);
               }
               break;
            default:
               int var2 = var1.what;
               Log.w("GoogleApiAvailability", new StringBuilder(50).append("Don't know how to handle this message: ").append(var2).toString());
         }
      }
   }
}
