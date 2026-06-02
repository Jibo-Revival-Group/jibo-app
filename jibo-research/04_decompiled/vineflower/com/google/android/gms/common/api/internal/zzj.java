package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zzj {
   private final ArrayMap<zzh<?>, ConnectionResult> a;
   private final ArrayMap<zzh<?>, String> b = new ArrayMap<>();
   private final TaskCompletionSource<Map<zzh<?>, String>> c = new TaskCompletionSource<>();
   private int d;
   private boolean e = false;

   public zzj(Iterable<? extends GoogleApi<?>> var1) {
      this.a = new ArrayMap<>();

      for (GoogleApi var2 : var1) {
         this.a.put(var2.b(), null);
      }

      this.d = this.a.keySet().size();
   }

   public final Set<zzh<?>> a() {
      return this.a.keySet();
   }

   public final void a(zzh<?> var1, ConnectionResult var2, String var3) {
      this.a.put(var1, var2);
      this.b.put(var1, var3);
      this.d--;
      if (!var2.b()) {
         this.e = true;
      }

      if (this.d == 0) {
         if (this.e) {
            AvailabilityException var4 = new AvailabilityException(this.a);
            this.c.a(var4);
         } else {
            this.c.a(this.b);
         }
      }
   }

   public final Task<Map<zzh<?>, String>> b() {
      return this.c.a();
   }
}
