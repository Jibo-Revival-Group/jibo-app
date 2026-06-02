package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.UUID;

class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {
   private AnalyticsSettingsData g;

   SessionAnalyticsFilesManager(Context var1, SessionEventTransform var2, CurrentTimeProvider var3, EventsStorage var4) throws IOException {
      super(var1, var2, var3, var4, 100);
   }

   @Override
   protected String a() {
      UUID var1 = UUID.randomUUID();
      return "sa" + "_" + var1.toString() + "_" + this.c.a() + ".tap";
   }

   void a(AnalyticsSettingsData var1) {
      this.g = var1;
   }

   @Override
   protected int b() {
      int var1;
      if (this.g == null) {
         var1 = super.b();
      } else {
         var1 = this.g.e;
      }

      return var1;
   }

   @Override
   protected int c() {
      int var1;
      if (this.g == null) {
         var1 = super.c();
      } else {
         var1 = this.g.c;
      }

      return var1;
   }
}
