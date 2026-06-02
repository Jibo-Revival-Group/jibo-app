package com.salesforce.android.service.common.liveagentlogging.internal;

import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Arrays;

public class PodProvider {
   private static String a;
   private final ArraySet<String> b = new ArraySet<>();
   private ArraySet<String> c = new ArraySet<>();

   public PodProvider(PodProvider.Builder var1) {
      if (a != null) {
         this.b.add(a);
         this.c.add(a);
      } else {
         this.b.addAll(Arrays.asList(var1.a));
         this.c.a(this.b);
      }
   }

   public String a() {
      if (this.b.isEmpty()) {
         throw new AllPodsUnavailableException();
      }

      if (this.c.isEmpty()) {
         this.c.a(this.b);
      }

      return this.c.c((int)(Math.random() * this.c.size()));
   }

   public void a(String var1) {
      this.b.remove(var1);
   }

   public static class Builder {
      protected String[] a;

      PodProvider.Builder a(String... var1) {
         this.a = var1;
         return this;
      }

      public PodProvider a() {
         Arguments.a(this.a);
         return new PodProvider(this);
      }
   }
}
