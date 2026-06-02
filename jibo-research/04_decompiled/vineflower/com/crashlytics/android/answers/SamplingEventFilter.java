package com.crashlytics.android.answers;

import java.util.HashSet;
import java.util.Set;

class SamplingEventFilter implements EventFilter {
   static final Set<SessionEvent.Type> b = new HashSet<SessionEvent.Type>() {
      {
         this.add(SessionEvent.Type.START);
         this.add(SessionEvent.Type.RESUME);
         this.add(SessionEvent.Type.PAUSE);
         this.add(SessionEvent.Type.STOP);
      }
   };
   final int a;

   public SamplingEventFilter(int var1) {
      this.a = var1;
   }

   @Override
   public boolean a(SessionEvent var1) {
      boolean var4 = true;
      boolean var2;
      if (b.contains(var1.c) && var1.a.g == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if (Math.abs(var1.a.c.hashCode() % this.a) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (!var2 || !var3) {
         var4 = false;
      }

      return var4;
   }
}
