package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PriorityTask implements Dependency<Task>, PriorityProvider, Task {
   private final List<Task> a = new ArrayList<>();
   private final AtomicBoolean b = new AtomicBoolean(false);
   private final AtomicReference<Throwable> c = new AtomicReference<>(null);

   public static boolean a(Object var0) {
      Dependency var2;
      Task var3;
      try {
         var2 = (Dependency)var0;
         var3 = (Task)var0;
         var5 = (PriorityProvider)var0;
      } catch (ClassCastException var4) {
         return false;
      }

      boolean var1;
      if (var2 != null && var3 != null && var5 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a(Task var1) {
      synchronized (this) {
         this.a.add(var1);
      }
   }

   @Override
   public void a(Throwable var1) {
      this.c.set(var1);
   }

   @Override
   public Priority b() {
      return Priority.NORMAL;
   }

   @Override
   public void b(boolean var1) {
      synchronized (this) {
         this.b.set(var1);
      }
   }

   @Override
   public Collection<Task> c() {
      synchronized (this) {
         return Collections.unmodifiableCollection(this.a);
      }
   }

   @Override
   public int compareTo(Object var1) {
      return Priority.compareTo(this, var1);
   }

   @Override
   public boolean d() {
      Iterator var2 = this.c().iterator();

      boolean var1;
      while (true) {
         if (var2.hasNext()) {
            if (((Task)var2.next()).f()) {
               continue;
            }

            var1 = false;
            break;
         }

         var1 = true;
         break;
      }

      return var1;
   }

   @Override
   public boolean f() {
      return this.b.get();
   }
}
