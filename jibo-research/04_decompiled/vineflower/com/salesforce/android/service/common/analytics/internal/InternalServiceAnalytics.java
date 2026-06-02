package com.salesforce.android.service.common.analytics.internal;

import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class InternalServiceAnalytics {
   static final Set<ServiceAnalyticsListener> a = new HashSet<>();

   static Map<String, Object> a(Object... var0) {
      if (var0.length % 2 != 0) {
         throw new IllegalArgumentException("Analytics Event Data is invalid. Please specify an even number of data arguments. Data: " + Arrays.toString(var0));
      }

      HashMap var2 = new HashMap();

      for (byte var1 = 0; var1 < var0.length; var1 += 2) {
         var2.put(var0[var1].toString(), var0[var1 + 1]);
      }

      return var2;
   }

   public static void a(ServiceAnalyticsListener var0) {
      a.add(var0);
   }

   public static void a(String var0, Map<String, Object> var1) {
      Iterator var2 = a.iterator();

      while (var2.hasNext()) {
         ((ServiceAnalyticsListener)var2.next()).a(var0, var1);
      }
   }

   public static void a(String var0, Object... var1) {
      a(var0, a(var1));
   }

   public static void b(ServiceAnalyticsListener var0) {
      a.remove(var0);
   }
}
