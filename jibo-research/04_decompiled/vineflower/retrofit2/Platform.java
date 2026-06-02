package retrofit2;

import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class Platform {
   private static final Platform a = c();

   static Platform a() {
      return a;
   }

   private static Platform c() {
      try {
         Class.forName("android.os.Build");
         if (VERSION.SDK_INT != 0) {
            Platform.Android var3 = new Platform.Android();
            return var3;
         }
      } catch (ClassNotFoundException var2) {
      }

      Platform var0;
      try {
         Class.forName("java.util.Optional");
         var0 = new Platform.Java8();
      } catch (ClassNotFoundException var1) {
         var0 = new Platform();
      }

      return var0;
   }

   Object a(Method var1, Class<?> var2, Object var3, Object... var4) throws Throwable {
      throw new UnsupportedOperationException();
   }

   CallAdapter.Factory a(Executor var1) {
      CallAdapter.Factory var2;
      if (var1 != null) {
         var2 = new ExecutorCallAdapterFactory(var1);
      } else {
         var2 = DefaultCallAdapterFactory.a;
      }

      return var2;
   }

   boolean a(Method var1) {
      return false;
   }

   Executor b() {
      return null;
   }

   static class Android extends Platform {
      @Override
      CallAdapter.Factory a(Executor var1) {
         if (var1 == null) {
            throw new AssertionError();
         } else {
            return new ExecutorCallAdapterFactory(var1);
         }
      }

      @Override
      public Executor b() {
         return new Platform.Android.MainThreadExecutor();
      }

      static class MainThreadExecutor implements Executor {
         private final Handler a = new Handler(Looper.getMainLooper());

         @Override
         public void execute(Runnable var1) {
            this.a.post(var1);
         }
      }
   }

   static class Java8 extends Platform {
      @Override
      Object a(Method var1, Class<?> var2, Object var3, Object... var4) throws Throwable {
         Constructor var5 = Lookup.class.getDeclaredConstructor(Class.class, int.class);
         var5.setAccessible(true);
         return ((Lookup)var5.newInstance(var2, -1)).unreflectSpecial(var1, var2).bindTo(var3).invokeWithArguments(var4);
      }

      @Override
      boolean a(Method var1) {
         return var1.isDefault();
      }
   }
}
