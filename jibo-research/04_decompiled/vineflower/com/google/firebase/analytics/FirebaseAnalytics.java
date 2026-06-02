package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.tasks.Task;

@Keep
public final class FirebaseAnalytics {
   private final zzcim zziwf;

   public FirebaseAnalytics(zzcim var1) {
      zzbq.a(var1);
      this.zziwf = var1;
   }

   @Keep
   public static FirebaseAnalytics getInstance(Context var0) {
      return zzcim.a(var0).n();
   }

   public final Task<String> getAppInstanceId() {
      return this.zziwf.l().y();
   }

   public final void logEvent(String var1, Bundle var2) {
      this.zziwf.m().logEvent(var1, var2);
   }

   public final void resetAnalyticsData() {
      this.zziwf.l().A();
   }

   public final void setAnalyticsCollectionEnabled(boolean var1) {
      this.zziwf.m().setMeasurementEnabled(var1);
   }

   @Keep
   public final void setCurrentScreen(Activity var1, String var2, String var3) {
      this.zziwf.v().a(var1, var2, var3);
   }

   public final void setMinimumSessionDuration(long var1) {
      this.zziwf.m().setMinimumSessionDuration(var1);
   }

   public final void setSessionTimeoutDuration(long var1) {
      this.zziwf.m().setSessionTimeoutDuration(var1);
   }

   public final void setUserId(String var1) {
      this.zziwf.m().setUserPropertyInternal("app", "_id", var1);
   }

   public final void setUserProperty(String var1, String var2) {
      this.zziwf.m().setUserProperty(var1, var2);
   }

   public static class Event {
   }

   public static class Param {
   }

   public static class UserProperty {
   }
}
