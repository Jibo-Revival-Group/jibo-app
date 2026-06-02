package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
   static boolean a = false;
   private final LifecycleOwner b;
   private final LoaderManagerImpl.LoaderViewModel c;
   private boolean d;

   LoaderManagerImpl(LifecycleOwner var1, ViewModelStore var2) {
      this.b = var1;
      this.c = LoaderManagerImpl.LoaderViewModel.a(var2);
   }

   private <D> Loader<D> c(int var1, Bundle var2, LoaderManager.LoaderCallbacks<D> var3) {
      LoaderManagerImpl.LoaderInfo var5;
      try {
         this.d = true;
         Loader var4 = var3.a(var1, var2);
         if (var4.getClass().isMemberClass() && !Modifier.isStatic(var4.getClass().getModifiers())) {
            StringBuilder var10 = new StringBuilder();
            IllegalArgumentException var9 = new IllegalArgumentException(
               var10.append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(var4).toString()
            );
            throw var9;
         }

         var5 = new LoaderManagerImpl.LoaderInfo(var1, var2, var4);
         if (a) {
            StringBuilder var8 = new StringBuilder();
            Log.v("LoaderManager", var8.append("  Created new loader ").append(var5).toString());
         }

         this.c.a(var1, var5);
      } finally {
         this.d = false;
      }

      return var5.a(this.b, var3);
   }

   @Override
   public <D> Loader<D> a(int var1, Bundle var2, LoaderManager.LoaderCallbacks<D> var3) {
      if (this.d) {
         throw new IllegalStateException("Called while creating a loader");
      }

      if (Looper.getMainLooper() != Looper.myLooper()) {
         throw new IllegalStateException("initLoader must be called on the main thread");
      }

      LoaderManagerImpl.LoaderInfo var4 = this.c.a(var1);
      if (a) {
         Log.v("LoaderManager", "initLoader in " + this + ": args=" + var2);
      }

      Loader var5;
      if (var4 == null) {
         var5 = this.c(var1, var2, var3);
      } else {
         if (a) {
            Log.v("LoaderManager", "  Re-using existing loader " + var4);
         }

         var5 = var4.a(this.b, var3);
      }

      return var5;
   }

   @Override
   public void a(int var1) {
      if (this.d) {
         throw new IllegalStateException("Called while creating a loader");
      }

      if (Looper.getMainLooper() != Looper.myLooper()) {
         throw new IllegalStateException("destroyLoader must be called on the main thread");
      }

      if (a) {
         Log.v("LoaderManager", "destroyLoader in " + this + " of " + var1);
      }

      LoaderManagerImpl.LoaderInfo var2 = this.c.a(var1);
      if (var2 != null) {
         var2.i();
         this.c.b(var1);
      }
   }

   @Override
   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.c.a(var1, var2, var3, var4);
   }

   @Override
   public boolean a() {
      return this.c.b();
   }

   @Override
   public <D> Loader<D> b(int var1) {
      if (this.d) {
         throw new IllegalStateException("Called while creating a loader");
      }

      LoaderManagerImpl.LoaderInfo var2 = this.c.a(var1);
      Loader var3;
      if (var2 != null) {
         var3 = var2.f();
      } else {
         var3 = null;
      }

      return var3;
   }

   @Override
   public <D> Loader<D> b(int var1, Bundle var2, LoaderManager.LoaderCallbacks<D> var3) {
      if (this.d) {
         throw new IllegalStateException("Called while creating a loader");
      }

      if (Looper.getMainLooper() != Looper.myLooper()) {
         throw new IllegalStateException("restartLoader must be called on the main thread");
      }

      if (a) {
         Log.v("LoaderManager", "restartLoader in " + this + ": args=" + var2);
      }

      this.a(var1);
      return this.c(var1, var2, var3);
   }

   void b() {
      this.c.c();
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("LoaderManager{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" in ");
      DebugUtils.a(this.b, var1);
      var1.append("}}");
      return var1.toString();
   }

   public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
      private final int a;
      private final Bundle b;
      private final Loader<D> c;
      private LifecycleOwner d;
      private LoaderManagerImpl.LoaderObserver<D> e;

      LoaderInfo(int var1, Bundle var2, Loader<D> var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.c.a(var1, this);
      }

      Loader<D> a(LifecycleOwner var1, LoaderManager.LoaderCallbacks<D> var2) {
         LoaderManagerImpl.LoaderObserver var3 = new LoaderManagerImpl.LoaderObserver<>(this.c, var2);
         this.a(var1, var3);
         if (this.e != null) {
            this.a(this.e);
         }

         this.d = var1;
         this.e = var3;
         return this.c;
      }

      @Override
      public void a(Observer<D> var1) {
         super.a(var1);
         this.d = null;
         this.e = null;
      }

      @Override
      public void a(Loader<D> var1, D var2) {
         if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
         }

         if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b((D)var2);
         } else {
            if (LoaderManagerImpl.a) {
               Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }

            this.a((D)var2);
         }
      }

      public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
         var3.print(var1);
         var3.print("mId=");
         var3.print(this.a);
         var3.print(" mArgs=");
         var3.println(this.b);
         var3.print(var1);
         var3.print("mLoader=");
         var3.println(this.c);
         this.c.a(var1 + "  ", var2, var3, var4);
         if (this.e != null) {
            var3.print(var1);
            var3.print("mCallbacks=");
            var3.println(this.e);
            this.e.a(var1 + "  ", var3);
         }

         var3.print(var1);
         var3.print("mData=");
         var3.println(this.f().c(this.a()));
         var3.print(var1);
         var3.print("mStarted=");
         var3.println(this.d());
      }

      @Override
      protected void b() {
         if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Starting: " + this);
         }

         this.c.r();
      }

      @Override
      protected void c() {
         if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
         }

         this.c.u();
      }

      Loader<D> f() {
         return this.c;
      }

      void g() {
         LifecycleOwner var2 = this.d;
         LoaderManagerImpl.LoaderObserver var1 = this.e;
         if (var2 != null && var1 != null) {
            this.a(var1);
            this.a(var2, var1);
         }
      }

      boolean h() {
         boolean var2 = false;
         boolean var1;
         if (!this.d()) {
            var1 = var2;
         } else {
            var1 = var2;
            if (this.e != null) {
               var1 = var2;
               if (!this.e.a()) {
                  var1 = true;
               }
            }
         }

         return var1;
      }

      void i() {
         if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Destroying: " + this);
         }

         this.c.s();
         this.c.v();
         LoaderManagerImpl.LoaderObserver var1 = this.e;
         if (var1 != null) {
            this.a(var1);
            var1.b();
         }

         this.c.a(this);
         this.c.x();
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder(64);
         var1.append("LoaderInfo{");
         var1.append(Integer.toHexString(System.identityHashCode(this)));
         var1.append(" #");
         var1.append(this.a);
         var1.append(" : ");
         DebugUtils.a(this.c, var1);
         var1.append("}}");
         return var1.toString();
      }
   }

   static class LoaderObserver<D> implements Observer<D> {
      private final Loader<D> a;
      private final LoaderManager.LoaderCallbacks<D> b;
      private boolean c = false;

      LoaderObserver(Loader<D> var1, LoaderManager.LoaderCallbacks<D> var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(D var1) {
         if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.c((D)var1));
         }

         this.b.a(this.a, (D)var1);
         this.c = true;
      }

      public void a(String var1, PrintWriter var2) {
         var2.print(var1);
         var2.print("mDeliveredData=");
         var2.println(this.c);
      }

      boolean a() {
         return this.c;
      }

      void b() {
         if (this.c) {
            if (LoaderManagerImpl.a) {
               Log.v("LoaderManager", "  Resetting: " + this.a);
            }

            this.b.a(this.a);
         }
      }

      @Override
      public String toString() {
         return this.b.toString();
      }
   }

   static class LoaderViewModel extends ViewModel {
      private static final ViewModelProvider.Factory a = new ViewModelProvider.Factory() {
         @Override
         public <T extends ViewModel> T a(Class<T> var1) {
            return (T)(new LoaderManagerImpl.LoaderViewModel());
         }
      };
      private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> b = new SparseArrayCompat<>();

      static LoaderManagerImpl.LoaderViewModel a(ViewModelStore var0) {
         return new ViewModelProvider(var0, a).a(LoaderManagerImpl.LoaderViewModel.class);
      }

      <D> LoaderManagerImpl.LoaderInfo<D> a(int var1) {
         return this.b.a(var1);
      }

      @Override
      protected void a() {
         super.a();
         int var2 = this.b.b();

         for (int var1 = 0; var1 < var2; var1++) {
            this.b.e(var1).i();
         }

         this.b.c();
      }

      void a(int var1, LoaderManagerImpl.LoaderInfo var2) {
         this.b.b(var1, var2);
      }

      public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
         if (this.b.b() > 0) {
            var3.print(var1);
            var3.println("Loaders:");
            String var6 = var1 + "    ";

            for (int var5 = 0; var5 < this.b.b(); var5++) {
               LoaderManagerImpl.LoaderInfo var7 = this.b.e(var5);
               var3.print(var1);
               var3.print("  #");
               var3.print(this.b.d(var5));
               var3.print(": ");
               var3.println(var7.toString());
               var7.a(var6, var2, var3, var4);
            }
         }
      }

      void b(int var1) {
         this.b.c(var1);
      }

      boolean b() {
         int var2 = this.b.b();
         int var1 = 0;

         boolean var3;
         while (true) {
            if (var1 >= var2) {
               var3 = false;
               break;
            }

            if (this.b.e(var1).h()) {
               var3 = true;
               break;
            }

            var1++;
         }

         return var3;
      }

      void c() {
         int var2 = this.b.b();

         for (int var1 = 0; var1 < var2; var1++) {
            this.b.e(var1).g();
         }
      }
   }
}
