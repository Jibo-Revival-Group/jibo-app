package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
   private final Set<Request> a = Collections.newSetFromMap(new WeakHashMap<>());
   private final List<Request> b = new ArrayList<>();
   private boolean c;

   public void a() {
      this.c = true;

      for (Request var2 : Util.a(this.a)) {
         if (var2.f()) {
            var2.e();
            this.b.add(var2);
         }
      }
   }

   public void a(Request var1) {
      this.a.add(var1);
      if (!this.c) {
         var1.b();
      } else {
         this.b.add(var1);
      }
   }

   public void b() {
      this.c = false;

      for (Request var2 : Util.a(this.a)) {
         if (!var2.g() && !var2.i() && !var2.f()) {
            var2.b();
         }
      }

      this.b.clear();
   }

   public void b(Request var1) {
      this.a.remove(var1);
      this.b.remove(var1);
   }

   public void c() {
      Iterator var1 = Util.a(this.a).iterator();

      while (var1.hasNext()) {
         ((Request)var1.next()).d();
      }

      this.b.clear();
   }

   public void d() {
      for (Request var1 : Util.a(this.a)) {
         if (!var1.g() && !var1.i()) {
            var1.e();
            if (!this.c) {
               var1.b();
            } else {
               this.b.add(var1);
            }
         }
      }
   }
}
