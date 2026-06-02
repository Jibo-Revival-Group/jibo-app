package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BasicAsync<T> implements Async<T>, ResultReceiver<T> {
   private T a;
   private Throwable b;
   private boolean c;
   private boolean d;
   private Set<Async.ResultHandler<? super T>> e = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private Set<Async.ErrorHandler> f = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private Set<Async.CompletionHandler> g = Collections.newSetFromMap(new ConcurrentHashMap<>());

   public static <T> BasicAsync<T> c(T var0) {
      return new BasicAsync<T>().a((T)var0).a();
   }

   public static <T> BasicAsync<T> c(Throwable var0) {
      return new BasicAsync<T>().a(var0);
   }

   public static <T> BasicAsync<T> g() {
      return new BasicAsync<>();
   }

   public static <T> BasicAsync<T> h() {
      return new BasicAsync<T>().a();
   }

   @Override
   public Async<T> a(Async.CompletionHandler var1) {
      if (!this.d && this.b == null) {
         if (this.c) {
            var1.a(this);
         } else {
            this.g.add(var1);
         }
      }

      return this;
   }

   @Override
   public Async<T> a(Async.ErrorHandler var1) {
      if (!this.d && !this.c) {
         if (this.b != null) {
            var1.a(this, this.b);
         } else {
            this.f.add(var1);
         }
      }

      return this;
   }

   @Override
   public Async<T> a(Async.ResultHandler<? super T> var1) {
      if (!this.d && this.b == null) {
         if (this.a != null) {
            var1.a(this, this.a);
         }

         if (!this.c) {
            this.e.add(var1);
         }
      }

      return this;
   }

   @Override
   public Async<T> a(ResultReceiver<? super T> var1) {
      if (var1 != this) {
         this.b(new Async.Handler<T>(this, var1) {
            final ResultReceiver a;
            final BasicAsync b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Async<?> var1) {
               this.a.b();
            }

            @Override
            public void a(Async<?> var1, T var2) {
               this.a.b(var2);
            }

            @Override
            public void a(Async<?> var1, Throwable var2) {
               this.a.b(var2);
            }
         });
      }

      return this;
   }

   public BasicAsync<T> a() {
      if (this.f()) {
         this.c = true;
         Iterator var1 = this.g.iterator();

         while (var1.hasNext()) {
            ((Async.CompletionHandler)var1.next()).a(this);
         }

         this.e.clear();
         this.f.clear();
         this.g.clear();
      }

      return this;
   }

   public BasicAsync<T> a(T var1) {
      if (this.f() && var1 != null) {
         this.a = (T)var1;
         Iterator var2 = this.e.iterator();

         while (var2.hasNext()) {
            ((Async.ResultHandler)var2.next()).a(this, var1);
         }
      }

      return this;
   }

   public BasicAsync<T> a(Throwable var1) {
      if (this.f()) {
         this.b = var1;
         Iterator var2 = this.f.iterator();

         while (var2.hasNext()) {
            ((Async.ErrorHandler)var2.next()).a(this, var1);
         }

         this.e.clear();
         this.f.clear();
         this.g.clear();
      }

      return this;
   }

   public Async<T> b(Async.CompletionHandler var1) {
      this.g.remove(var1);
      return this;
   }

   public Async<T> b(Async.ErrorHandler var1) {
      this.f.remove(var1);
      return this;
   }

   @Override
   public <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> b(S var1) {
      this.a(var1);
      this.a((Async.ErrorHandler)var1);
      this.a((Async.CompletionHandler)var1);
      return this;
   }

   @Override
   public <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> c(S var1) {
      this.d(var1);
      this.b((Async.ErrorHandler)var1);
      this.b((Async.CompletionHandler)var1);
      return this;
   }

   public <S> BasicAsync<S> c(Function<? super T, ? extends S> var1) {
      return new BasicAsync.MappedAsync<>(this, var1);
   }

   @Override
   public void c() {
      if (this.f()) {
         this.d = true;
         this.e.clear();
         this.f.clear();
      }
   }

   public Async<T> d(Async.ResultHandler<? super T> var1) {
      this.e.remove(var1);
      return this;
   }

   public <S> BasicAsync<S> d(Function<? super T, ? extends Async<? extends S>> var1) {
      return new BasicAsync.ChainedAsync<>(this, var1);
   }

   @Override
   public boolean d() {
      return this.c;
   }

   @Override
   public boolean e() {
      boolean var1;
      if (this.b != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean f() {
      boolean var1;
      if (!this.i() && !this.d() && !this.e()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean i() {
      return this.d;
   }

   private static class ChainedAsync<T, S> extends BasicAsync<S> implements Async.ErrorHandler, Async.ResultHandler<T> {
      private final BasicAsync<T> a;
      private Async<? extends S> b;
      private final Function<? super T, ? extends Async<? extends S>> c;

      ChainedAsync(BasicAsync<T> var1, Function<? super T, ? extends Async<? extends S>> var2) {
         this.a = var1;
         this.c = var2;
         this.a.a(this);
         this.a.a(this);
      }

      @Override
      public void a(Async<?> var1, T var2) {
         try {
            this.b = (Async<? extends S>)this.c.a((T)var2);
         } catch (Throwable var3) {
            this.a(var3);
            return;
         }

         this.b.a(this);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a(var2);
      }

      @Override
      public void c() {
         super.c();
         this.a.c();
         if (this.b != null) {
            this.b.c();
         }
      }
   }

   private static class MappedAsync<T, S> extends BasicAsync<S> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {
      private final BasicAsync<T> a;
      private final Function<? super T, ? extends S> b;

      MappedAsync(BasicAsync<T> var1, Function<? super T, ? extends S> var2) {
         this.a = var1;
         this.b = var2;
         var1.b(this);
      }

      @Override
      public void a(Async<?> var1) {
         this.a();
      }

      @Override
      public void a(Async<?> var1, T var2) {
         try {
            var4 = this.b.a((T)var2);
         } catch (Throwable var3) {
            this.a(var3);
            return;
         }

         this.a((S)var4);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a(var2);
      }

      @Override
      public void c() {
         super.c();
         this.a.c();
      }
   }
}
