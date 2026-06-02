package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {
   private final Set<LifecycleListener> a = Collections.newSetFromMap(new WeakHashMap<>());
   private boolean b;
   private boolean c;

   void a() {
      this.b = true;
      Iterator var1 = Util.a(this.a).iterator();

      while (var1.hasNext()) {
         ((LifecycleListener)var1.next()).onStart();
      }
   }

   @Override
   public void a(LifecycleListener var1) {
      this.a.add(var1);
      if (this.c) {
         var1.onDestroy();
      } else if (this.b) {
         var1.onStart();
      } else {
         var1.onStop();
      }
   }

   void b() {
      this.b = false;
      Iterator var1 = Util.a(this.a).iterator();

      while (var1.hasNext()) {
         ((LifecycleListener)var1.next()).onStop();
      }
   }

   void c() {
      this.c = true;
      Iterator var1 = Util.a(this.a).iterator();

      while (var1.hasNext()) {
         ((LifecycleListener)var1.next()).onDestroy();
      }
   }
}
