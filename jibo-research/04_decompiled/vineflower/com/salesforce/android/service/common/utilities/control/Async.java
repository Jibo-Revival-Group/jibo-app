package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.functional.Function;

public interface Async<T> {
   Async<T> a(Async.CompletionHandler var1);

   Async<T> a(Async.ErrorHandler var1);

   Async<T> a(Async.ResultHandler<? super T> var1);

   Async<T> a(ResultReceiver<? super T> var1);

   <S> Async<S> a(Function<? super T, ? extends S> var1);

   <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> b(S var1);

   <S> Async<S> b(Function<? super T, ? extends Async<? extends S>> var1);

   <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> c(S var1);

   void c();

   boolean d();

   boolean e();

   boolean f();

   interface CompletionHandler {
      void a(Async<?> var1);
   }

   interface ErrorHandler {
      void a(Async<?> var1, Throwable var2);
   }

   interface Handler extends Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler {
   }

   interface ResultHandler<T> {
      void a(Async<?> var1, T var2);
   }
}
