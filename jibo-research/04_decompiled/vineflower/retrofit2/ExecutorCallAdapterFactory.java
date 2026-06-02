package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
   final Executor a;

   ExecutorCallAdapterFactory(Executor var1) {
      this.a = var1;
   }

   @Override
   public CallAdapter<?, ?> a(Type var1, Annotation[] var2, Retrofit var3) {
      CallAdapter var4;
      if (a(var1) != Call.class) {
         var4 = null;
      } else {
         var4 = new CallAdapter<Object, Call<?>>(this, Utils.e(var1)) {
            final Type a;
            final ExecutorCallAdapterFactory b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public Type a() {
               return this.a;
            }

            public Call<Object> b(Call<Object> var1) {
               return new ExecutorCallAdapterFactory.ExecutorCallbackCall<>(this.b.a, var1);
            }
         };
      }

      return var4;
   }

   static final class ExecutorCallbackCall<T> implements Call<T> {
      final Executor a;
      final Call<T> b;

      ExecutorCallbackCall(Executor var1, Call<T> var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(Callback<T> var1) {
         Utils.a(var1, "callback == null");
         this.b.a(new Callback<T>(this, var1) {
            final Callback a;
            final ExecutorCallAdapterFactory.ExecutorCallbackCall b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Call<T> var1, Throwable var2) {
               this.b.a.execute(new Runnable(this, var2) {
                  final Throwable a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.a(this.b.b, this.a);
                  }
               });
            }

            @Override
            public void a(Call<T> var1, Response<T> var2) {
               this.b.a.execute(new Runnable(this, var2) {
                  final Response a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     if (this.b.b.b.a()) {
                        this.b.a.a(this.b.b, new IOException("Canceled"));
                     } else {
                        this.b.a.a(this.b.b, this.a);
                     }
                  }
               });
            }
         });
      }

      @Override
      public boolean a() {
         return this.b.a();
      }

      @Override
      public Call<T> b() {
         return new ExecutorCallAdapterFactory.ExecutorCallbackCall<>(this.a, this.b.b());
      }
   }
}
