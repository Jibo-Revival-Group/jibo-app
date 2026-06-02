package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class PriorityAsyncTask<Params, Progress, Result>
   extends AsyncTask<Params, Progress, Result>
   implements Dependency<Task>,
   PriorityProvider,
   Task {
   private final PriorityTask a = new PriorityTask();

   public void a(Task var1) {
      if (this.u_() != AsyncTask.Status.PENDING) {
         throw new IllegalStateException("Must not add Dependency after task is running");
      }

      this.g().c(var1);
   }

   @Override
   public void a(Throwable var1) {
      ((Task)((PriorityProvider)this.g())).a(var1);
   }

   public final void a(ExecutorService var1, Params... var2) {
      super.a(new PriorityAsyncTask.ProxyExecutor(var1, this), (Params[])var2);
   }

   @Override
   public Priority b() {
      return ((PriorityProvider)this.g()).b();
   }

   @Override
   public void b(boolean var1) {
      ((Task)((PriorityProvider)this.g())).b(var1);
   }

   @Override
   public Collection<Task> c() {
      return ((Dependency)((PriorityProvider)this.g())).c();
   }

   @Override
   public int compareTo(Object var1) {
      return Priority.compareTo(this, var1);
   }

   @Override
   public boolean d() {
      return ((Dependency)((PriorityProvider)this.g())).d();
   }

   @Override
   public boolean f() {
      return ((Task)((PriorityProvider)this.g())).f();
   }

   public <T extends Dependency<Task> & PriorityProvider & Task> T g() {
      return (T)this.a;
   }

   private static class ProxyExecutor<Result> implements Executor {
      private final Executor a;
      private final PriorityAsyncTask b;

      public ProxyExecutor(Executor var1, PriorityAsyncTask var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void execute(Runnable var1) {
         this.a.execute(new PriorityFutureTask<Result>(this, var1, null) {
            final PriorityAsyncTask.ProxyExecutor a;

            {
               this.a = var1;
            }

            @Override
            public <T extends Dependency<Task> & PriorityProvider & Task> T a() {
               return (T)this.a.b;
            }
         });
      }
   }
}
