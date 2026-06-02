package com.salesforce.android.service.common.utilities.logging;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public class ServiceLogging {
   public static final ServiceLoggingSink a = new ServiceLogging.LogCatSink();
   private static int b = 6;
   private static final Set<ServiceLoggingSink> c = new HashSet<>();
   private static final Set<String> d = new HashSet<>();

   public static int a() {
      return b;
   }

   public static ServiceLogger a(Class<?> var0) {
      return a(var0, null);
   }

   public static ServiceLogger a(Class<?> var0, String var1) {
      return ServiceLoggerImpl.a(var0.getSimpleName(), var1);
   }

   static boolean a(String var0) {
      boolean var1;
      if (!d.contains(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   static Set<ServiceLoggingSink> b() {
      return c;
   }

   private static class LogCatSink implements ServiceLoggingSink {
      LogCatSink() {
      }

      @Override
      public void a(int var1, String var2, String var3) {
         switch (var1) {
            case 1:
               Log.v(var2, var3);
               break;
            case 2:
               Log.d(var2, var3);
               break;
            case 3:
               Log.i(var2, var3);
               break;
            case 4:
               Log.w(var2, var3);
               break;
            case 5:
               Log.e(var2, var3);
         }
      }
   }
}
