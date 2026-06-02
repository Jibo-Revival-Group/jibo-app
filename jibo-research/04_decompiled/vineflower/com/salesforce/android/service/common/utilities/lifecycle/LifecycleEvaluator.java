package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LifecycleEvaluator<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
   private final S[] a;
   private final EnumSet<M> b;
   private S c;
   private S d;
   private S e;
   private final ServiceLogger f;
   private final Set<LifecycleListener<S, M>> g;
   private final LifecycleMetricWatcher<S, M> h;
   private final LifecycleStateWatcher<S, M> i;

   LifecycleEvaluator(Class<S> var1, Class<M> var2, LifecycleMetricWatcher<S, M> var3, LifecycleStateWatcher<S, M> var4, ServiceLogger var5) {
      this.a = (S[])var1.getEnumConstants();
      this.b = EnumSet.noneOf(var2);
      Enum var6 = this.a[0];
      this.c = (S)var6;
      this.d = (S)var6;
      this.g = Collections.newSetFromMap(new ConcurrentHashMap<>());
      this.h = var3;
      this.i = var4;
      this.f = var5;
      this.e = null;
   }

   public LifecycleEvaluator<S, M> a(S var1) {
      this.d = (S)var1;
      return this;
   }

   public LifecycleEvaluator<S, M> a(M var1, boolean var2) {
      if (var2) {
         this.b.add((M)var1);
      } else {
         this.b.remove(var1);
      }

      this.f.b("Metric {}.{} has been set to {}", var1.getClass().getSimpleName(), var1.name(), var2);
      return this;
   }

   public void a() {
      Enum var3 = this.c();
      Enum var2 = this.d();
      Enum var1;
      if (this.e != null) {
         var1 = this.e;
      } else {
         var1 = this.c;
      }

      if (var1.ordinal() < this.d.ordinal()) {
         var1 = var3;
      } else {
         var1 = this.d;
      }

      Iterator var6 = EnumSet.range(var1, var2).iterator();

      do {
         if (!var6.hasNext()) {
            var1 = var2;
            break;
         }

         var1 = (Enum)var6.next();
      } while (this.f((S)var1));

      this.e((S)var1);
      this.e = null;
   }

   public void a(LifecycleListener<S, M> var1) {
      this.g.add(var1);
   }

   public LifecycleEvaluator<S, M> b() {
      this.e = this.d;
      return this;
   }

   public LifecycleEvaluator<S, M> b(M var1) {
      return this.a((M)var1, true);
   }

   public LifecycleEvaluator<S, M> c(M var1) {
      return this.a((M)var1, false);
   }

   public S c() {
      return this.a[0];
   }

   public S d() {
      return this.a[this.a.length - 1];
   }

   boolean d(M var1) {
      return this.b.contains(var1);
   }

   public S e() {
      return this.c;
   }

   void e(S var1) {
      if (var1 != this.c) {
         this.i.a((S)var1, this);
      }
   }

   boolean f(S var1) {
      boolean var4;
      if (((LifecycleState)var1).getMetrics() == null) {
         var4 = true;
      } else {
         Enum[] var5 = ((LifecycleState)var1).getMetrics();
         int var3 = var5.length;
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var4 = true;
               break;
            }

            if (!this.d((M)var5[var2])) {
               var4 = false;
               break;
            }

            var2++;
         }
      }

      return var4;
   }

   void g(M var1) {
      Iterator var2 = this.g.iterator();

      while (var2.hasNext()) {
         ((LifecycleListener)var2.next()).a((M)var1);
      }
   }

   void h(S var1) {
      Enum var3 = this.c;
      this.c = (S)var1;
      if (this.c == this.d()) {
         this.h.b();
         this.i.a();
      } else {
         this.h.a(this.c, this);
      }

      Iterator var2 = this.g.iterator();

      while (var2.hasNext()) {
         ((LifecycleListener)var2.next()).a((S)var1, (S)var3);
      }
   }

   public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
      private LifecycleMetricWatcher<S, M> a;
      private LifecycleStateWatcher<S, M> b;
      private ServiceLogger c;

      public LifecycleEvaluator<S, M> a(Class<S> var1, Class<M> var2) {
         if (this.a == null) {
            this.a = new LifecycleMetricWatcher.Builder<S, M>().a(var1);
         }

         if (this.b == null) {
            this.b = new LifecycleStateWatcher.Builder<S, M>().a(var1);
         }

         if (this.c == null) {
            this.c = ServiceLogging.a(LifecycleEvaluator.class, String.format("LifecycleEvaluator:%s", var1.getSimpleName()));
         }

         return new LifecycleEvaluator<>(var1, var2, this.a, this.b, this.c);
      }
   }
}
