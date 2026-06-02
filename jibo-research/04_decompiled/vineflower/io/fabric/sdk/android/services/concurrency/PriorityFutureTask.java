package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PriorityFutureTask<V> extends FutureTask<V> implements Dependency<Task>, PriorityProvider, Task {
   final Object b;

   public PriorityFutureTask(Runnable var1, V var2) {
      super(var1, (V)var2);
      this.b = this.a(var1);
   }

   public PriorityFutureTask(Callable<V> var1) {
      super(var1);
      this.b = this.a(var1);
   }

   public <T extends Dependency<Task> & PriorityProvider & Task> T a() {
      return (T)this.b;
   }

   protected <T extends Dependency<Task> & PriorityProvider & Task> T a(Object var1) {
      if (PriorityTask.a(var1)) {
         var1 = var1;
      } else {
         var1 = new PriorityTask();
      }

      return (T)var1;
   }

   public void a(Task var1) {
      this.a().c(var1);
   }

   @Override
   public void a(Throwable var1) {
      ((Task)((PriorityProvider)this.a())).a(var1);
   }

   @Override
   public Priority b() {
      return ((PriorityProvider)this.a()).b();
   }

   @Override
   public void b(boolean var1) {
      ((Task)((PriorityProvider)this.a())).b(var1);
   }

   @Override
   public Collection<Task> c() {
      return ((Dependency)((PriorityProvider)this.a())).c();
   }

   @Override
   public int compareTo(Object var1) {
      return ((PriorityProvider)this.a()).compareTo(var1);
   }

   @Override
   public boolean d() {
      return ((Dependency)((PriorityProvider)this.a())).d();
   }

   @Override
   public boolean f() {
      return ((Task)((PriorityProvider)this.a())).f();
   }
}
