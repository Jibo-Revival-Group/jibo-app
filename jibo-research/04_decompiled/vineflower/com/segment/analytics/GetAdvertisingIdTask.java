package com.segment.analytics;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings.Secure;
import android.util.Pair;
import com.segment.analytics.integrations.Logger;
import java.util.concurrent.CountDownLatch;

class GetAdvertisingIdTask extends AsyncTask<Context, Void, Pair<String, Boolean>> {
   private final AnalyticsContext analyticsContext;
   private final CountDownLatch latch;
   private final Logger logger;

   GetAdvertisingIdTask(AnalyticsContext var1, CountDownLatch var2, Logger var3) {
      this.analyticsContext = var1;
      this.latch = var2;
      this.logger = var3;
   }

   private Pair<String, Boolean> getAmazonFireAdvertisingID(Context var1) throws Exception {
      ContentResolver var3 = var1.getContentResolver();
      boolean var2;
      if (Secure.getInt(var3, "limit_ad_tracking") != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Pair var4;
      if (var2) {
         this.logger.debug("Not collecting advertising ID because limit_ad_tracking (Amazon Fire OS) is true.");
         var4 = Pair.create(null, false);
      } else {
         var4 = Pair.create(Secure.getString(var3, "advertising_id"), true);
      }

      return var4;
   }

   private Pair<String, Boolean> getGooglePlayServicesAdvertisingID(Context var1) throws Exception {
      Pair var2 = (Pair)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient")
         .getMethod("getAdvertisingIdInfo", Context.class)
         .invoke(null, var1);
      if ((Boolean)var2.getClass().getMethod("isLimitAdTrackingEnabled").invoke(var2)) {
         this.logger.debug("Not collecting advertising ID because isLimitAdTrackingEnabled (Google Play Services) is true.");
         var2 = Pair.create(null, false);
      } else {
         var2 = Pair.create((String)var2.getClass().getMethod("getId").invoke(var2), true);
      }

      return var2;
   }

   protected Pair<String, Boolean> doInBackground(Context... var1) {
      Context var2 = var1[0];

      try {
         var5 = this.getGooglePlayServicesAdvertisingID(var2);
      } catch (Exception var4) {
         this.logger.error(var4, "Unable to collect advertising ID from Google Play Services.");

         try {
            var5 = this.getAmazonFireAdvertisingID(var2);
         } catch (Exception var3) {
            this.logger.error(var3, "Unable to collect advertising ID from Amazon Fire OS.");
            this.logger.debug("Unable to collect advertising ID from Amazon Fire OS and Google Play Services.");
            var5 = null;
         }
      }

      return var5;
   }

   protected void onPostExecute(Pair<String, Boolean> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial android/os/AsyncTask.onPostExecute (Ljava/lang/Object;)V
      // 05: aload 1
      // 06: ifnonnull 11
      // 09: aload 0
      // 0a: getfield com/segment/analytics/GetAdvertisingIdTask.latch Ljava/util/concurrent/CountDownLatch;
      // 0d: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 10: return
      // 11: aload 0
      // 12: getfield com/segment/analytics/GetAdvertisingIdTask.analyticsContext Lcom/segment/analytics/AnalyticsContext;
      // 15: invokevirtual com/segment/analytics/AnalyticsContext.device ()Lcom/segment/analytics/AnalyticsContext$Device;
      // 18: astore 2
      // 19: aload 2
      // 1a: ifnonnull 34
      // 1d: aload 0
      // 1e: getfield com/segment/analytics/GetAdvertisingIdTask.logger Lcom/segment/analytics/integrations/Logger;
      // 21: ldc "Not collecting advertising ID because context.device is null."
      // 23: bipush 0
      // 24: anewarray 46
      // 27: invokevirtual com/segment/analytics/integrations/Logger.debug (Ljava/lang/String;[Ljava/lang/Object;)V
      // 2a: aload 0
      // 2b: getfield com/segment/analytics/GetAdvertisingIdTask.latch Ljava/util/concurrent/CountDownLatch;
      // 2e: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 31: goto 10
      // 34: aload 2
      // 35: aload 1
      // 36: getfield android/util/Pair.first Ljava/lang/Object;
      // 39: checkcast java/lang/String
      // 3c: aload 1
      // 3d: getfield android/util/Pair.second Ljava/lang/Object;
      // 40: checkcast java/lang/Boolean
      // 43: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 46: invokevirtual com/segment/analytics/AnalyticsContext$Device.putAdvertisingInfo (Ljava/lang/String;Z)V
      // 49: aload 0
      // 4a: getfield com/segment/analytics/GetAdvertisingIdTask.latch Ljava/util/concurrent/CountDownLatch;
      // 4d: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 50: goto 10
      // 53: astore 1
      // 54: aload 0
      // 55: getfield com/segment/analytics/GetAdvertisingIdTask.latch Ljava/util/concurrent/CountDownLatch;
      // 58: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 5b: aload 1
      // 5c: athrow
      // try (9 -> 13): 38 null
      // try (15 -> 21): 38 null
      // try (25 -> 34): 38 null
   }
}
