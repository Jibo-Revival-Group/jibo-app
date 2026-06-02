package com.google.firebase.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicReference;

public final class zzb {
   private static final AtomicReference<zzb> a = new AtomicReference<>();

   private zzb(Context var1) {
   }

   public static zzb a(Context var0) {
      a.compareAndSet(null, new zzb(var0));
      return a.get();
   }

   public static void a(FirebaseApp var0) {
   }
}
