package com.salesforce.android.service.common.utilities.logging;

import java.util.Iterator;

class ServiceLoggerImpl implements ServiceLogger {
   private final String a;
   private final String b;

   private ServiceLoggerImpl(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   static ServiceLoggerImpl a(String var0, String var1) {
      return new ServiceLoggerImpl(var0, var1);
   }

   private void a(int var1, String var2) {
      if (this.a(var1)) {
         this.b(var1, var2);
      }
   }

   private void a(int var1, String var2, Object[] var3) {
      if (this.a(var1)) {
         this.b(var1, this.f(var2, var3));
      }
   }

   private boolean a(int var1) {
      boolean var2;
      if (ServiceLogging.a() > var1 || ServiceLogging.b().isEmpty() || this.b != null && !ServiceLogging.a(this.b)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private void b(int var1, String var2) {
      Iterator var3 = ServiceLogging.b().iterator();

      while (var3.hasNext()) {
         ((ServiceLoggingSink)var3.next()).a(var1, this.a, var2);
      }
   }

   private String f(String var1, Object[] var2) {
      byte var4 = 0;
      if (var2 != null) {
         StringBuilder var7 = new StringBuilder();

         int var10;
         for (Object var8 : var2) {
            int var6 = var1.indexOf("{}", var10);
            if (var6 < 0) {
               break;
            }

            var7.append(var1, var10, var6);
            var7.append(var8);
            var10 = var6 + 2;
         }

         var7.append(var1, var10, var1.length());
         var1 = var7.toString();
      }

      return var1;
   }

   @Override
   public void a(String var1) {
      this.a(1, var1);
   }

   @Override
   public void a(String var1, Object... var2) {
      this.a(1, var1, var2);
   }

   @Override
   public void b(String var1) {
      this.a(2, var1);
   }

   @Override
   public void b(String var1, Object... var2) {
      this.a(2, var1, var2);
   }

   @Override
   public void c(String var1) {
      this.a(3, var1);
   }

   @Override
   public void c(String var1, Object... var2) {
      this.a(3, var1, var2);
   }

   @Override
   public void d(String var1) {
      this.a(4, var1);
   }

   @Override
   public void d(String var1, Object... var2) {
      this.a(4, var1, var2);
   }

   @Override
   public void e(String var1) {
      this.a(5, var1);
   }

   @Override
   public void e(String var1, Object... var2) {
      this.a(5, var1, var2);
   }
}
