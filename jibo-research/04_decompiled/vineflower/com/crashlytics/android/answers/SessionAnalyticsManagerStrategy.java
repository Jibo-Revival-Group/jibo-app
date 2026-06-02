package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.events.FileRollOverManager;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

interface SessionAnalyticsManagerStrategy extends FileRollOverManager {
   void a();

   void a(SessionEvent.Builder var1);

   void a(AnalyticsSettingsData var1, String var2);

   void b();
}
