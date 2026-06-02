package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
   static final CallAdapter.Factory a = new DefaultCallAdapterFactory();

   @Override
   public CallAdapter<?, ?> a(Type var1, Annotation[] var2, Retrofit var3) {
      CallAdapter var4;
      if (a(var1) != Call.class) {
         var4 = null;
      } else {
         var4 = new CallAdapter<Object, Call<?>>(this, Utils.e(var1)) {
            final Type a;
            final DefaultCallAdapterFactory b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public Type a() {
               return this.a;
            }

            public Call<Object> b(Call<Object> var1) {
               return var1;
            }
         };
      }

      return var4;
   }
}
