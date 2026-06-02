package com.segment.analytics.integrations;

import android.app.Activity;
import android.os.Bundle;
import com.segment.analytics.Analytics;
import com.segment.analytics.ValueMap;

public abstract class Integration<T> {
   public void alias(AliasPayload var1) {
   }

   public void flush() {
   }

   public T getUnderlyingInstance() {
      return null;
   }

   public void group(GroupPayload var1) {
   }

   public void identify(IdentifyPayload var1) {
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity var1) {
   }

   public void onActivityPaused(Activity var1) {
   }

   public void onActivityResumed(Activity var1) {
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
   }

   public void onActivityStopped(Activity var1) {
   }

   public void reset() {
   }

   public void screen(ScreenPayload var1) {
   }

   public void track(TrackPayload var1) {
   }

   public interface Factory {
      Integration<?> create(ValueMap var1, Analytics var2);

      String key();
   }
}
