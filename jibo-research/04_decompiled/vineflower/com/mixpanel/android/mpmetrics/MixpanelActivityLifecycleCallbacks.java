package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import com.mixpanel.android.viewcrawler.GestureTracker;
import java.text.NumberFormat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
class MixpanelActivityLifecycleCallbacks implements ActivityLifecycleCallbacks {
   private static Double e;
   private Handler a = new Handler(Looper.getMainLooper());
   private Runnable b;
   private boolean c = true;
   private boolean d = true;
   private final MixpanelAPI f;
   private final MPConfig g;

   public MixpanelActivityLifecycleCallbacks(MixpanelAPI var1, MPConfig var2) {
      this.f = var1;
      this.g = var2;
      if (e == null) {
         e = (double)System.currentTimeMillis();
      }
   }

   private void a(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnonnull 05
      // 04: return
      // 05: aload 1
      // 06: ldc "mp_campaign_id"
      // 08: invokevirtual android/content/Intent.hasExtra (Ljava/lang/String;)Z
      // 0b: ifeq 04
      // 0e: aload 1
      // 0f: ldc "mp_message_id"
      // 11: invokevirtual android/content/Intent.hasExtra (Ljava/lang/String;)Z
      // 14: ifeq 04
      // 17: aload 1
      // 18: ldc "mp_campaign_id"
      // 1a: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 1d: astore 3
      // 1e: aload 1
      // 1f: ldc "mp_message_id"
      // 21: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 24: astore 4
      // 26: aload 1
      // 27: ldc "mp"
      // 29: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 2c: astore 5
      // 2e: aload 5
      // 30: ifnull 86
      // 33: new org/json/JSONObject
      // 36: astore 2
      // 37: aload 2
      // 38: aload 5
      // 3a: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 3d: aload 2
      // 3e: ldc "campaign_id"
      // 40: aload 3
      // 41: invokestatic java/lang/Integer.valueOf (Ljava/lang/String;)Ljava/lang/Integer;
      // 44: invokevirtual java/lang/Integer.intValue ()I
      // 47: invokevirtual org/json/JSONObject.put (Ljava/lang/String;I)Lorg/json/JSONObject;
      // 4a: pop
      // 4b: aload 2
      // 4c: ldc "message_id"
      // 4e: aload 4
      // 50: invokestatic java/lang/Integer.valueOf (Ljava/lang/String;)Ljava/lang/Integer;
      // 53: invokevirtual java/lang/Integer.intValue ()I
      // 56: invokevirtual org/json/JSONObject.put (Ljava/lang/String;I)Lorg/json/JSONObject;
      // 59: pop
      // 5a: aload 2
      // 5b: ldc "message_type"
      // 5d: ldc "push"
      // 5f: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 62: pop
      // 63: aload 0
      // 64: getfield com/mixpanel/android/mpmetrics/MixpanelActivityLifecycleCallbacks.f Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
      // 67: ldc "$app_open"
      // 69: aload 2
      // 6a: invokevirtual com/mixpanel/android/mpmetrics/MixpanelAPI.a (Ljava/lang/String;Lorg/json/JSONObject;)V
      // 6d: aload 1
      // 6e: ldc "mp_campaign_id"
      // 70: invokevirtual android/content/Intent.removeExtra (Ljava/lang/String;)V
      // 73: aload 1
      // 74: ldc "mp_message_id"
      // 76: invokevirtual android/content/Intent.removeExtra (Ljava/lang/String;)V
      // 79: aload 1
      // 7a: ldc "mp"
      // 7c: invokevirtual android/content/Intent.removeExtra (Ljava/lang/String;)V
      // 7f: goto 04
      // 82: astore 1
      // 83: goto 04
      // 86: new org/json/JSONObject
      // 89: dup
      // 8a: invokespecial org/json/JSONObject.<init> ()V
      // 8d: astore 2
      // 8e: goto 3d
      // 91: astore 2
      // 92: goto 6d
      // try (3 -> 23): 64 android/os/BadParcelableException
      // try (25 -> 30): 71 org/json/JSONException
      // try (25 -> 30): 64 android/os/BadParcelableException
      // try (30 -> 54): 71 org/json/JSONException
      // try (30 -> 54): 64 android/os/BadParcelableException
      // try (54 -> 63): 64 android/os/BadParcelableException
      // try (66 -> 70): 71 org/json/JSONException
      // try (66 -> 70): 64 android/os/BadParcelableException
   }

   protected boolean a() {
      return this.c;
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity var1) {
   }

   public void onActivityPaused(Activity var1) {
      this.d = true;
      if (this.b != null) {
         this.a.removeCallbacks(this.b);
      }

      Handler var3 = this.a;
      Runnable var2 = new Runnable(this) {
         final MixpanelActivityLifecycleCallbacks a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.c && this.a.d) {
               this.a.c = false;

               try {
                  double var1x = System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.e;
                  if (var1x >= this.a.g.s() && var1x < this.a.g.t()) {
                     NumberFormat var3x = NumberFormat.getNumberInstance(Locale.ENGLISH);
                     var3x.setMaximumFractionDigits(1);
                     String var6 = var3x.format((System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.e) / 1000.0);
                     JSONObject var4 = new JSONObject();
                     var4.put("$ae_session_length", var6);
                     this.a.f.a("$ae_session", var4, true);
                  }
               } catch (JSONException var5) {
                  var5.printStackTrace();
               }

               this.a.f.h();
            }
         }
      };
      this.b = var2;
      var3.postDelayed(var2, 500L);
   }

   public void onActivityResumed(Activity var1) {
      boolean var2 = false;
      if (VERSION.SDK_INT >= 16 && this.g.n()) {
         this.f.c().b();
      }

      this.d = false;
      if (!this.c) {
         var2 = true;
      }

      this.c = true;
      if (this.b != null) {
         this.a.removeCallbacks(this.b);
      }

      if (var2) {
         e = (double)System.currentTimeMillis();
      }
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
      this.a(var1.getIntent());
      if (VERSION.SDK_INT >= 16 && this.g.n()) {
         this.f.c().a(var1);
      }

      new GestureTracker(this.f, var1);
   }

   public void onActivityStopped(Activity var1) {
   }
}
