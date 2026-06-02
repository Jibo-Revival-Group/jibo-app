package com.salesforce.android.knowledge.ui.internal.logging;

import com.salesforce.android.service.common.analytics.ServiceAnalytics;
import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.HashMap;
import java.util.Map;

class AnalyticsHook implements ServiceAnalyticsListener {
   AnalyticsHook.Listener a;
   private final Map<String, AnalyticsHook.Translation> b = new HashMap<>();

   void a() {
      ServiceAnalytics.a(this);
   }

   void a(AnalyticsHook.Listener var1) {
      this.a = var1;
   }

   void a(String var1, AnalyticsHook.Translation var2) {
      this.b.put(var1, var2);
   }

   @Override
   public void a(String var1, Map<String, Object> var2) {
      if (this.a != null) {
         AnalyticsHook.Translation var3 = this.b.get(var1);
         if (var3 != null) {
            BaseEvent var4 = var3.a(var1, var2);
            if (var4 != null) {
               this.a.a(var4);
            }
         }
      }
   }

   void b() {
      ServiceAnalytics.b(this);
   }

   interface Listener {
      void a(BaseEvent var1);
   }

   interface Translation {
      BaseEvent a(String var1, Map<String, Object> var2);
   }
}
