package io.fabric.sdk.android;

import android.util.Log;

public class DefaultLogger implements Logger {
   private int a;

   public DefaultLogger() {
      this.a = 4;
   }

   public DefaultLogger(int var1) {
      this.a = var1;
   }

   @Override
   public void a(int var1, String var2, String var3) {
      this.a(var1, var2, var3, false);
   }

   public void a(int var1, String var2, String var3, boolean var4) {
      if (var4 || this.a(var2, var1)) {
         Log.println(var1, var2, var3);
      }
   }

   @Override
   public void a(String var1, String var2) {
      this.a(var1, var2, null);
   }

   @Override
   public void a(String var1, String var2, Throwable var3) {
      if (this.a(var1, 3)) {
         Log.d(var1, var2, var3);
      }
   }

   @Override
   public boolean a(String var1, int var2) {
      boolean var3;
      if (this.a <= var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public void b(String var1, String var2) {
      this.b(var1, var2, null);
   }

   public void b(String var1, String var2, Throwable var3) {
      if (this.a(var1, 2)) {
         Log.v(var1, var2, var3);
      }
   }

   @Override
   public void c(String var1, String var2) {
      this.c(var1, var2, null);
   }

   public void c(String var1, String var2, Throwable var3) {
      if (this.a(var1, 4)) {
         Log.i(var1, var2, var3);
      }
   }

   @Override
   public void d(String var1, String var2) {
      this.d(var1, var2, null);
   }

   @Override
   public void d(String var1, String var2, Throwable var3) {
      if (this.a(var1, 5)) {
         Log.w(var1, var2, var3);
      }
   }

   @Override
   public void e(String var1, String var2) {
      this.e(var1, var2, null);
   }

   @Override
   public void e(String var1, String var2, Throwable var3) {
      if (this.a(var1, 6)) {
         Log.e(var1, var2, var3);
      }
   }
}
