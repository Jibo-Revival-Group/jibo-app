package com.google.android.gms.common.api.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzcm {
   private final Set<zzci<?>> a = Collections.newSetFromMap(new WeakHashMap<>());

   public final void a() {
      Iterator var1 = this.a.iterator();

      while (var1.hasNext()) {
         ((zzci)var1.next()).a();
      }

      this.a.clear();
   }
}
