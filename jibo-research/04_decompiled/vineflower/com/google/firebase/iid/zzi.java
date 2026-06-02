package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzi {
   private static zzi a;
   private final Context b;
   private final ScheduledExecutorService c;
   private zzk d = new zzk(this, null);
   private int e = 1;

   private zzi(Context var1, ScheduledExecutorService var2) {
      this.c = var2;
      this.b = var1.getApplicationContext();
   }

   private final int a() {
      int var1;
      synchronized (this) {
         var1 = this.e++;
      }

      return var1;
   }

   private final <T> Task<T> a(zzr<T> var1) {
      synchronized (this) {
         if (Log.isLoggable("MessengerIpcClient", 3)) {
            String var3 = String.valueOf(var1);
            int var2 = String.valueOf(var3).length();
            StringBuilder var4 = new StringBuilder(var2 + 9);
            Log.d("MessengerIpcClient", var4.append("Queueing ").append(var3).toString());
         }

         if (!this.d.a(var1)) {
            zzk var7 = new zzk(this, null);
            this.d = var7;
            this.d.a(var1);
         }

         return var1.b.a();
      }
   }

   public static zzi a(Context var0) {
      synchronized (zzi.class) {
         if (a == null) {
            zzi var1 = new zzi(var0, Executors.newSingleThreadScheduledExecutor());
            a = var1;
         }

         return a;
      }
   }

   public final Task<Void> a(int var1, Bundle var2) {
      return this.a(new zzq(this.a(), 2, var2));
   }

   public final Task<Bundle> b(int var1, Bundle var2) {
      return this.a(new zzt(this.a(), 1, var2));
   }
}
