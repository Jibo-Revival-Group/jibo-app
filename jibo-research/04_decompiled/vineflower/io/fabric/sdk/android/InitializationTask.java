package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {
   final Kit<Result> a;

   public InitializationTask(Kit<Result> var1) {
      this.a = var1;
   }

   private TimingMetric a(String var1) {
      TimingMetric var2 = new TimingMetric(this.a.b() + "." + var1, "KitInitialization");
      var2.a();
      return var2;
   }

   protected Result a(Void... var1) {
      TimingMetric var2 = this.a("doInBackground");
      Object var3 = null;
      if (!this.e()) {
         var3 = this.a.f();
      }

      var2.b();
      return (Result)var3;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   protected void a() {
      super.a();
      TimingMetric var2 = this.a("onPreExecute");
      boolean var7 = false /* VF: Semaphore variable */;

      boolean var1;
      label53: {
         try {
            var7 = true;
            var1 = this.a.a_();
            var7 = false;
            break label53;
         } catch (UnmetDependencyException var8) {
            throw var8;
         } catch (Exception var9) {
            Fabric.h().e("Fabric", "Failure onPreExecute()", var9);
            var7 = false;
         } finally {
            if (var7) {
               var2.b();
               this.a(true);
            }
         }

         var2.b();
         this.a(true);
         return;
      }

      var2.b();
      if (!var1) {
         this.a(true);
      }
   }

   @Override
   protected void a(Result var1) {
      this.a.a((Result)var1);
      this.a.h.a((Result)var1);
   }

   @Override
   public Priority b() {
      return Priority.HIGH;
   }

   @Override
   protected void b(Result var1) {
      this.a.b((Result)var1);
      var1 = new InitializationException(this.a.b() + " Initialization was cancelled");
      this.a.h.a(var1);
   }
}
