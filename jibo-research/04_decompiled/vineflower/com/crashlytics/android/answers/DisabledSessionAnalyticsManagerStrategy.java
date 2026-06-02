package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;

class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
   @Override
   public void a() {
   }

   @Override
   public void a(SessionEvent.Builder var1) {
   }

   @Override
   public void a(AnalyticsSettingsData var1, String var2) {
   }

   @Override
   public void b() {
   }

   @Override
   public boolean c() throws IOException {
      return false;
   }

   @Override
   public void d() {
   }
}
