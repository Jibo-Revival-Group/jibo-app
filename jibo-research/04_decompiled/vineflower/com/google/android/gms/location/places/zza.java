package com.google.android.gms.location.places;

import com.google.android.gms.internal.zzbfm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zza extends zzbfm {
   static <E> List<E> a(Collection<E> var0) {
      if (var0 != null && !var0.isEmpty()) {
         var0 = new ArrayList<>(var0);
      } else {
         var0 = Collections.emptyList();
      }

      return var0;
   }

   static <E> Set<E> a(List<E> var0) {
      Set var1;
      if (var0 != null && !var0.isEmpty()) {
         var1 = Collections.unmodifiableSet(new HashSet<>(var0));
      } else {
         var1 = Collections.emptySet();
      }

      return var1;
   }
}
