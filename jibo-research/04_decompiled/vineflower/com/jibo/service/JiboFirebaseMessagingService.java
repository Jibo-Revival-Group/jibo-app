package com.jibo.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class JiboFirebaseMessagingService extends FirebaseMessagingService {
   private static final String b = JiboFirebaseMessagingService.class.getSimpleName();
   private static final CharSequence c = "channel_name";

   private void a(Map<String, String> var1, String var2, String var3, int var4, Bundle var5) {
      this.a(var1, var2, var3, var4, null, var5);
   }

   private void a(Map<String, String> var1, String var2, String var3, int var4, String var5, Bundle var6) {
      Intent var7;
      if (!var6.containsKey("android.intent.action.VIEW")) {
         Intent var8 = new Intent(this, OnBoardingActivity.class);
         var8.addFlags(67108864);
         var7 = var8;
         if (var6 != null) {
            var8.putExtra("ARG_EXTRAS", var6);
            var7 = var8;
         }
      } else {
         var7 = new Intent("android.intent.action.VIEW", Uri.parse(var6.getString("android.intent.action.VIEW")));
      }

      PendingIntent var18 = PendingIntent.getActivity(this, 0, var7, 134217728);
      NotificationChannel var13;
      String var14;
      if (VERSION.SDK_INT >= 26) {
         var13 = new NotificationChannel("my_channel_01", c, 3);
         var14 = "my_channel_01";
      } else {
         var14 = "";
         var13 = null;
      }

      NotificationCompat.Builder var9 = new NotificationCompat.Builder(this, var14).a(UIUtils.a());
      String var15;
      if (TextUtils.isEmpty(var2)) {
         var15 = this.getString(2131755063);
      } else {
         var15 = var2;
      }

      var9 = var9.a((CharSequence)var15);
      String var16;
      if (var1.get("loc-args") == null) {
         var16 = "";
      } else {
         var16 = ((String)var1.get("loc-args")).replace("[\"", "").replace("\"]", "");
      }

      NotificationCompat.Builder var17 = var9.b(String.format(var3, var16)).a(true).a(RingtoneManager.getDefaultUri(2)).a(var18);
      NotificationCompat.BigTextStyle var19 = new NotificationCompat.BigTextStyle(var17);
      String var10;
      if (var1.get("loc-args") == null) {
         var10 = "";
      } else {
         var10 = ((String)var1.get("loc-args")).replace("[\"", "").replace("\"]", "");
      }

      var19.b(String.format(var3, var10));
      String var11 = var2;
      if (TextUtils.isEmpty(var2)) {
         var11 = this.getString(2131755063);
      }

      var19.a(var11);
      var17.a(var19);
      if (VERSION.SDK_INT >= 21) {
         var17.d(this.getResources().getColor(2131099771));
      }

      NotificationManager var12 = (NotificationManager)this.getSystemService("notification");
      if (var12 != null) {
         if (VERSION.SDK_INT >= 26) {
            var12.createNotificationChannel(var13);
         }

         var12.notify(var5, var4, var17.b());
      }
   }

   @Override
   public void a(RemoteMessage var1) {
      super.a(var1);
      Map var3 = var1.a();
      if (var3.get("type") != null) {
         String var2 = ((String)var3.get("type")).replace("-", "_").replace(".", "_");
         if (var2.equals(JiboFirebaseMessagingService.MessageType.loop_changed_silent.toString())) {
            SyncHelper.a(this.getApplicationContext(), (String)var3.get("loopId"));
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.loop_invited.toString())) {
            SyncHelper.a(this.getApplicationContext(), (String)var3.get("loopId"));
            Bundle var5 = new Bundle();
            var5.putInt("ARG_TAB_SELECTED", 0);
            var5.putString("ARG_ENTITY_SELECTED", (String)var3.get("loopId"));
            this.a(var3, null, this.getString(2131755558), 2, (String)var3.get("loopId"), var5);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.loop_accepted.toString())) {
            SyncHelper.a(this.getApplicationContext(), (String)var3.get("loopId"));
            Bundle var6 = new Bundle();
            var6.putInt("ARG_TAB_SELECTED", 0);
            var6.putString("ARG_ENTITY_SELECTED", (String)var3.get("loopId"));
            this.a(var3, null, this.getString(2131755559), 3, var6);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.jot_created_silent.toString())) {
            SyncHelper.c(this.getApplicationContext(), (String)var3.get("loopId"));
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.media_created_silent.toString())) {
            new Timer()
               .schedule(
                  new TimerTask(this, var3) {
                     final Map a;
                     final JiboFirebaseMessagingService b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     @Override
                     public void run() {
                        SyncHelper.a(this.b.getApplicationContext(), (String)this.a.get("loopId"), false);
                        if (SharedPreferencesUtil.p(this.b)) {
                           Bundle var1x = new Bundle();
                           var1x.putInt("ARG_TAB_SELECTED", 1);
                           this.b
                              .a(
                                 this.a,
                                 this.b.getString(2131755563),
                                 this.b.getString(2131755562),
                                 4,
                                 JiboFirebaseMessagingService.MessageType.media_created_silent.toString(),
                                 var1x
                              );
                        }
                     }
                  },
                  4000L
               );
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.media_deleted_silent.toString())) {
            String var4 = (String)var3.get("path");
            MediaDeletingService.a(this.getApplicationContext(), new String[]{var4}, true);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.key_needed_silent.toString())) {
            KeyRequestingSharingService.a(this, var3);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.key_shared_silent.toString())) {
            KeyRequestingSharingService.b(this, var3);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.key_timeout_silent.toString())) {
            ArrayList var7 = new ArrayList();
            Collections.addAll(var7, SharedPreferencesUtil.n(this));
            if (var7.indexOf(var3.get("loopId")) == -1) {
               SharedPreferencesUtil.c(this, (String)var3.get("loopId"));
            }
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.version_installed.toString())) {
            Bundle var8 = new Bundle();
            var8.putString("android.intent.action.VIEW", this.getString(2131755618));
            this.a(var3, null, this.getString(2131755565), 5, var8);
         } else if (var2.equals(JiboFirebaseMessagingService.MessageType.version_updated.toString())) {
            Bundle var9 = new Bundle();
            var9.putString("android.intent.action.VIEW", this.getString(2131755618));
            this.a(var3, null, this.getString(2131755566), 5, var9);
         }
      }
   }

   enum MessageType {
      jot_created_silent,
      jot_created_tagged,
      key_needed_silent,
      key_shared_silent,
      key_timeout_silent,
      loop_accepted,
      loop_changed_silent,
      loop_invited,
      media_created_silent,
      media_deleted_silent,
      version_installed,
      version_updated;

      private static final JiboFirebaseMessagingService.MessageType[] $VALUES = new JiboFirebaseMessagingService.MessageType[]{
         JiboFirebaseMessagingService.MessageType.jot_created_silent,
         JiboFirebaseMessagingService.MessageType.jot_created_tagged,
         JiboFirebaseMessagingService.MessageType.loop_changed_silent,
         JiboFirebaseMessagingService.MessageType.loop_invited,
         JiboFirebaseMessagingService.MessageType.loop_accepted,
         JiboFirebaseMessagingService.MessageType.key_needed_silent,
         JiboFirebaseMessagingService.MessageType.key_shared_silent,
         JiboFirebaseMessagingService.MessageType.media_deleted_silent,
         JiboFirebaseMessagingService.MessageType.key_timeout_silent,
         JiboFirebaseMessagingService.MessageType.media_created_silent,
         JiboFirebaseMessagingService.MessageType.version_installed,
         JiboFirebaseMessagingService.MessageType.version_updated
      };
   }
}
