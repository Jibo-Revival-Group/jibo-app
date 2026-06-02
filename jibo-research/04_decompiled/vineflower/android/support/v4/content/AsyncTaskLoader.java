package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
   volatile AsyncTaskLoader<D>.LoadTask a;
   volatile AsyncTaskLoader<D>.LoadTask b;
   long c;
   long d = -10000L;
   Handler e;
   private final Executor f;

   public AsyncTaskLoader(Context var1) {
      this(var1, ModernAsyncTask.c);
   }

   private AsyncTaskLoader(Context var1, Executor var2) {
      super(var1);
      this.f = var2;
   }

   @Override
   protected void a() {
      super.a();
      this.s();
      this.a = new AsyncTaskLoader.LoadTask(this);
      this.c();
   }

   void a(AsyncTaskLoader<D>.LoadTask var1, D var2) {
      this.a((D)var2);
      if (this.b == var1) {
         this.A();
         this.d = SystemClock.uptimeMillis();
         this.b = null;
         this.l();
         this.c();
      }
   }

   public void a(D var1) {
   }

   @Override
   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.a(var1, var2, var3, var4);
      if (this.a != null) {
         var3.print(var1);
         var3.print("mTask=");
         var3.print(this.a);
         var3.print(" waiting=");
         var3.println(this.a.a);
      }

      if (this.b != null) {
         var3.print(var1);
         var3.print("mCancellingTask=");
         var3.print(this.b);
         var3.print(" waiting=");
         var3.println(this.b.a);
      }

      if (this.c != 0L) {
         var3.print(var1);
         var3.print("mUpdateThrottle=");
         TimeUtils.a(this.c, var3);
         var3.print(" mLastLoadCompleteTime=");
         TimeUtils.a(this.d, SystemClock.uptimeMillis(), var3);
         var3.println();
      }
   }

   void b(AsyncTaskLoader<D>.LoadTask var1, D var2) {
      if (this.a != var1) {
         this.a(var1, (D)var2);
      } else if (this.p()) {
         this.a((D)var2);
      } else {
         this.z();
         this.d = SystemClock.uptimeMillis();
         this.a = null;
         this.b((D)var2);
      }
   }

   @Override
   protected boolean b() {
      boolean var2 = false;
      boolean var1 = var2;
      if (this.a != null) {
         if (!this.r) {
            this.u = true;
         }

         if (this.b != null) {
            if (this.a.a) {
               this.a.a = false;
               this.e.removeCallbacks(this.a);
            }

            this.a = null;
            var1 = var2;
         } else if (this.a.a) {
            this.a.a = false;
            this.e.removeCallbacks(this.a);
            this.a = null;
            var1 = var2;
         } else {
            var1 = this.a.a(false);
            if (var1) {
               this.b = this.a;
               this.f();
            }

            this.a = null;
         }
      }

      return var1;
   }

   void c() {
      if (this.b == null && this.a != null) {
         if (this.a.a) {
            this.a.a = false;
            this.e.removeCallbacks(this.a);
         }

         if (this.c > 0L && SystemClock.uptimeMillis() < this.d + this.c) {
            this.a.a = true;
            this.e.postAtTime(this.a, this.d + this.c);
         } else {
            this.a.a(this.f, (Void[])null);
         }
      }
   }

   public abstract D d();

   protected D e() {
      return this.d();
   }

   public void f() {
   }

   public boolean g() {
      boolean var1;
      if (this.b != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
      boolean a;
      final AsyncTaskLoader b;
      private final CountDownLatch d;

      LoadTask(AsyncTaskLoader var1) {
         this.b = var1;
         this.d = new CountDownLatch(1);
      }

      protected D a(Void... var1) {
         try {
            var3 = this.b.e();
         } catch (OperationCanceledException var2) {
            if (!this.c()) {
               throw var2;
            }

            var3 = null;
         }

         return (D)var3;
      }

      @Override
      protected void a(D var1) {
         try {
            this.b.b(this, var1);
         } finally {
            this.d.countDown();
         }
      }

      @Override
      protected void b(D var1) {
         try {
            this.b.a(this, var1);
         } finally {
            this.d.countDown();
         }
      }

      @Override
      public void run() {
         this.a = false;
         this.b.c();
      }
   }
}
