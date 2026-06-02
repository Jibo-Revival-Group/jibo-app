package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class SharedPreferencesLoader {
   private final Executor a = Executors.newSingleThreadExecutor();

   public SharedPreferencesLoader() {
   }

   public Future<SharedPreferences> a(Context var1, String var2, SharedPreferencesLoader.OnPrefsLoadedListener var3) {
      FutureTask var4 = new FutureTask<>(new SharedPreferencesLoader.LoadSharedPreferences(var1, var2, var3));
      this.a.execute(var4);
      return var4;
   }

   private static class LoadSharedPreferences implements Callable<SharedPreferences> {
      private final Context a;
      private final String b;
      private final SharedPreferencesLoader.OnPrefsLoadedListener c;

      public LoadSharedPreferences(Context var1, String var2, SharedPreferencesLoader.OnPrefsLoadedListener var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public SharedPreferences a() {
         SharedPreferences var1 = this.a.getSharedPreferences(this.b, 0);
         if (this.c != null) {
            this.c.a(var1);
         }

         return var1;
      }
   }

   interface OnPrefsLoadedListener {
      void a(SharedPreferences var1);
   }
}
