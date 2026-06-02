package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class Retrofit {
   final okhttp3.Call.Factory a;
   final HttpUrl b;
   final List<Converter.Factory> c;
   final List<CallAdapter.Factory> d;
   final Executor e;
   final boolean f;
   private final Map<Method, ServiceMethod<?, ?>> g = new ConcurrentHashMap<>();

   Retrofit(okhttp3.Call.Factory var1, HttpUrl var2, List<Converter.Factory> var3, List<CallAdapter.Factory> var4, Executor var5, boolean var6) {
      this.a = var1;
      this.b = var2;
      this.c = Collections.unmodifiableList(var3);
      this.d = Collections.unmodifiableList(var4);
      this.e = var5;
      this.f = var6;
   }

   private void b(Class<?> var1) {
      Platform var4 = Platform.a();

      for (Method var6 : var1.getDeclaredMethods()) {
         if (!var4.a(var6)) {
            this.a(var6);
         }
      }
   }

   public <T> T a(Class<T> var1) {
      Utils.a(var1);
      if (this.f) {
         this.b(var1);
      }

      ClassLoader var3 = var1.getClassLoader();
      InvocationHandler var2 = new InvocationHandler(this, var1) {
         final Class a;
         final Retrofit b;
         private final Platform c;

         {
            this.b = var1;
            this.a = var2x;
            this.c = Platform.a();
         }

         @Override
         public Object invoke(Object var1, Method var2x, Object[] var3x) throws Throwable {
            if (var2x.getDeclaringClass() == Object.class) {
               var1 = var2x.invoke(this, var3x);
            } else if (this.c.a(var2x)) {
               var1 = this.c.a(var2x, this.a, var1, var3x);
            } else {
               var1 = this.b.a(var2x);
               OkHttpCall var6 = new OkHttpCall(var1, var3x);
               var1 = var1.d.a(var6);
            }

            return var1;
         }
      };
      return (T)Proxy.newProxyInstance(var3, new Class[]{var1}, var2);
   }

   public okhttp3.Call.Factory a() {
      return this.a;
   }

   public CallAdapter<?, ?> a(Type var1, Annotation[] var2) {
      return this.a((CallAdapter.Factory)null, var1, var2);
   }

   public CallAdapter<?, ?> a(CallAdapter.Factory var1, Type var2, Annotation[] var3) {
      Utils.a(var2, "returnType == null");
      Utils.a(var3, "annotations == null");
      int var4 = this.d.indexOf(var1) + 1;
      int var6 = this.d.size();

      for (int var5 = var4; var5 < var6; var5++) {
         CallAdapter var7 = this.d.get(var5).a(var2, var3, this);
         if (var7 != null) {
            return var7;
         }
      }

      StringBuilder var8 = new StringBuilder("Could not locate call adapter for ").append(var2).append(".\n");
      if (var1 != null) {
         var8.append("  Skipped:");

         for (int var9 = 0; var9 < var4; var9++) {
            var8.append("\n   * ").append(this.d.get(var9).getClass().getName());
         }

         var8.append('\n');
      }

      var8.append("  Tried:");

      for (int var10 = this.d.size(); var4 < var10; var4++) {
         var8.append("\n   * ").append(this.d.get(var4).getClass().getName());
      }

      throw new IllegalArgumentException(var8.toString());
   }

   public <T> Converter<T, RequestBody> a(Type var1, Annotation[] var2, Annotation[] var3) {
      return this.a(null, var1, var2, var3);
   }

   public <T> Converter<ResponseBody, T> a(Converter.Factory var1, Type var2, Annotation[] var3) {
      Utils.a(var2, "type == null");
      Utils.a(var3, "annotations == null");
      int var4 = this.c.indexOf(var1) + 1;
      int var6 = this.c.size();

      for (int var5 = var4; var5 < var6; var5++) {
         Converter var7 = this.c.get(var5).a(var2, var3, this);
         if (var7 != null) {
            return var7;
         }
      }

      StringBuilder var8 = new StringBuilder("Could not locate ResponseBody converter for ").append(var2).append(".\n");
      if (var1 != null) {
         var8.append("  Skipped:");

         for (int var9 = 0; var9 < var4; var9++) {
            var8.append("\n   * ").append(this.c.get(var9).getClass().getName());
         }

         var8.append('\n');
      }

      var8.append("  Tried:");

      for (int var10 = this.c.size(); var4 < var10; var4++) {
         var8.append("\n   * ").append(this.c.get(var4).getClass().getName());
      }

      throw new IllegalArgumentException(var8.toString());
   }

   public <T> Converter<T, RequestBody> a(Converter.Factory var1, Type var2, Annotation[] var3, Annotation[] var4) {
      Utils.a(var2, "type == null");
      Utils.a(var3, "parameterAnnotations == null");
      Utils.a(var4, "methodAnnotations == null");
      int var5 = this.c.indexOf(var1) + 1;
      int var7 = this.c.size();

      for (int var6 = var5; var6 < var7; var6++) {
         Converter var8 = this.c.get(var6).a(var2, var3, var4, this);
         if (var8 != null) {
            return var8;
         }
      }

      StringBuilder var9 = new StringBuilder("Could not locate RequestBody converter for ").append(var2).append(".\n");
      if (var1 != null) {
         var9.append("  Skipped:");

         for (int var10 = 0; var10 < var5; var10++) {
            var9.append("\n   * ").append(this.c.get(var10).getClass().getName());
         }

         var9.append('\n');
      }

      var9.append("  Tried:");

      for (int var11 = this.c.size(); var5 < var11; var5++) {
         var9.append("\n   * ").append(this.c.get(var5).getClass().getName());
      }

      throw new IllegalArgumentException(var9.toString());
   }

   ServiceMethod<?, ?> a(Method param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield retrofit2/Retrofit.g Ljava/util/Map;
      // 04: aload 1
      // 05: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0a: checkcast retrofit2/ServiceMethod
      // 0d: astore 2
      // 0e: aload 2
      // 0f: ifnull 14
      // 12: aload 2
      // 13: areturn
      // 14: aload 0
      // 15: getfield retrofit2/Retrofit.g Ljava/util/Map;
      // 18: astore 4
      // 1a: aload 4
      // 1c: monitorenter
      // 1d: aload 0
      // 1e: getfield retrofit2/Retrofit.g Ljava/util/Map;
      // 21: aload 1
      // 22: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 27: checkcast retrofit2/ServiceMethod
      // 2a: astore 3
      // 2b: aload 3
      // 2c: astore 2
      // 2d: aload 3
      // 2e: ifnonnull 4c
      // 31: new retrofit2/ServiceMethod$Builder
      // 34: astore 2
      // 35: aload 2
      // 36: aload 0
      // 37: aload 1
      // 38: invokespecial retrofit2/ServiceMethod$Builder.<init> (Lretrofit2/Retrofit;Ljava/lang/reflect/Method;)V
      // 3b: aload 2
      // 3c: invokevirtual retrofit2/ServiceMethod$Builder.a ()Lretrofit2/ServiceMethod;
      // 3f: astore 2
      // 40: aload 0
      // 41: getfield retrofit2/Retrofit.g Ljava/util/Map;
      // 44: aload 1
      // 45: aload 2
      // 46: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 4b: pop
      // 4c: aload 4
      // 4e: monitorexit
      // 4f: goto 12
      // 52: astore 1
      // 53: aload 4
      // 55: monitorexit
      // 56: aload 1
      // 57: athrow
      // try (15 -> 21): 43 null
      // try (25 -> 40): 43 null
      // try (40 -> 42): 43 null
      // try (44 -> 46): 43 null
   }

   public HttpUrl b() {
      return this.b;
   }

   public <T> Converter<ResponseBody, T> b(Type var1, Annotation[] var2) {
      return this.a((Converter.Factory)null, var1, var2);
   }

   public <T> Converter<T, String> c(Type var1, Annotation[] var2) {
      Utils.a(var1, "type == null");
      Utils.a(var2, "annotations == null");
      int var4 = this.c.size();
      int var3 = 0;

      while (true) {
         if (var3 >= var4) {
            var6 = BuiltInConverters.ToStringConverter.a;
            break;
         }

         Converter var5 = this.c.get(var3).b(var1, var2, this);
         if (var5 != null) {
            var6 = var5;
            break;
         }

         var3++;
      }

      return var6;
   }

   public static final class Builder {
      private final Platform a;
      private okhttp3.Call.Factory b;
      private HttpUrl c;
      private final List<Converter.Factory> d = new ArrayList<>();
      private final List<CallAdapter.Factory> e = new ArrayList<>();
      private Executor f;
      private boolean g;

      public Builder() {
         this(Platform.a());
      }

      Builder(Platform var1) {
         this.a = var1;
         this.d.add(new BuiltInConverters());
      }

      public Retrofit.Builder a(String var1) {
         Utils.a(var1, "baseUrl == null");
         HttpUrl var2 = HttpUrl.e(var1);
         if (var2 == null) {
            throw new IllegalArgumentException("Illegal URL: " + var1);
         } else {
            return this.a(var2);
         }
      }

      public Retrofit.Builder a(okhttp3.Call.Factory var1) {
         this.b = Utils.a(var1, "factory == null");
         return this;
      }

      public Retrofit.Builder a(HttpUrl var1) {
         Utils.a(var1, "baseUrl == null");
         List var2 = var1.k();
         if (!"".equals(var2.get(var2.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + var1);
         }

         this.c = var1;
         return this;
      }

      public Retrofit.Builder a(OkHttpClient var1) {
         return this.a(Utils.a(var1, "client == null"));
      }

      public Retrofit.Builder a(Converter.Factory var1) {
         this.d.add(Utils.a(var1, "factory == null"));
         return this;
      }

      public Retrofit a() {
         if (this.c == null) {
            throw new IllegalStateException("Base URL required.");
         }

         okhttp3.Call.Factory var2 = this.b;
         okhttp3.Call.Factory var1 = var2;
         if (var2 == null) {
            var1 = new OkHttpClient();
         }

         Executor var3 = this.f;
         Executor var5 = var3;
         if (var3 == null) {
            var5 = this.a.b();
         }

         ArrayList var6 = new ArrayList<>(this.e);
         var6.add(this.a.a(var5));
         ArrayList var4 = new ArrayList<>(this.d);
         return new Retrofit(var1, this.c, var4, var6, var5, this.g);
      }
   }
}
