package retrofit2;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

final class OkHttpCall<T> implements Call<T> {
   private final ServiceMethod<T, ?> a;
   private final Object[] b;
   private volatile boolean c;
   private okhttp3.Call d;
   private Throwable e;
   private boolean f;

   OkHttpCall(ServiceMethod<T, ?> var1, Object[] var2) {
      this.a = var1;
      this.b = var2;
   }

   private okhttp3.Call d() throws IOException {
      Request var1 = this.a.a(this.b);
      okhttp3.Call var2 = this.a.c.a(var1);
      if (var2 == null) {
         throw new NullPointerException("Call.Factory returned null.");
      } else {
         return var2;
      }
   }

   Response<T> a(okhttp3.Response var1) throws IOException {
      OkHttpCall.ExceptionCatchingRequestBody var3 = var1.h();
      var1 = var1.i().a(new OkHttpCall.NoContentResponseBody(var3.a(), var3.b())).a();
      int var2 = var1.c();
      Response var9;
      if (var2 < 200 || var2 >= 300) {
         try {
            var9 = Response.a(Utils.a(var3), var1);
         } finally {
            var3.close();
         }
      } else if (var2 != 204 && var2 != 205) {
         var3 = new OkHttpCall.ExceptionCatchingRequestBody(var3);

         try {
            var9 = Response.a(this.a.a(var3), var1);
         } catch (RuntimeException var6) {
            var3.g();
            throw var6;
         }
      } else {
         var3.close();
         var9 = Response.a((T)null, var1);
      }

      return var9;
   }

   @Override
   public void a(Callback<T> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ldc "callback == null"
      // 03: invokestatic retrofit2/Utils.a (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 06: pop
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield retrofit2/OkHttpCall.f Z
      // 0d: ifeq 21
      // 10: new java/lang/IllegalStateException
      // 13: astore 1
      // 14: aload 1
      // 15: ldc "Already executed."
      // 17: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 1a: aload 1
      // 1b: athrow
      // 1c: astore 1
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: aload 1
      // 20: athrow
      // 21: aload 0
      // 22: bipush 1
      // 23: putfield retrofit2/OkHttpCall.f Z
      // 26: aload 0
      // 27: getfield retrofit2/OkHttpCall.d Lokhttp3/Call;
      // 2a: astore 2
      // 2b: aload 0
      // 2c: getfield retrofit2/OkHttpCall.e Ljava/lang/Throwable;
      // 2f: astore 3
      // 30: aload 2
      // 31: ifnonnull 7c
      // 34: aload 3
      // 35: ifnonnull 7c
      // 38: aload 0
      // 39: invokespecial retrofit2/OkHttpCall.d ()Lokhttp3/Call;
      // 3c: astore 4
      // 3e: aload 0
      // 3f: aload 4
      // 41: putfield retrofit2/OkHttpCall.d Lokhttp3/Call;
      // 44: aload 4
      // 46: astore 2
      // 47: aload 0
      // 48: monitorexit
      // 49: aload 3
      // 4a: ifnull 5f
      // 4d: aload 1
      // 4e: aload 0
      // 4f: aload 3
      // 50: invokeinterface retrofit2/Callback.a (Lretrofit2/Call;Ljava/lang/Throwable;)V 3
      // 55: return
      // 56: astore 3
      // 57: aload 0
      // 58: aload 3
      // 59: putfield retrofit2/OkHttpCall.e Ljava/lang/Throwable;
      // 5c: goto 47
      // 5f: aload 0
      // 60: getfield retrofit2/OkHttpCall.c Z
      // 63: ifeq 6c
      // 66: aload 2
      // 67: invokeinterface okhttp3/Call.c ()V 1
      // 6c: aload 2
      // 6d: new retrofit2/OkHttpCall$1
      // 70: dup
      // 71: aload 0
      // 72: aload 1
      // 73: invokespecial retrofit2/OkHttpCall$1.<init> (Lretrofit2/OkHttpCall;Lretrofit2/Callback;)V
      // 76: invokestatic com/google/firebase/perf/network/FirebasePerfOkHttpClient.enqueue (Lokhttp3/Call;Lokhttp3/Callback;)V
      // 79: goto 55
      // 7c: goto 47
      // try (6 -> 16): 16 null
      // try (17 -> 19): 16 null
      // try (21 -> 30): 16 null
      // try (34 -> 40): 51 java/lang/Throwable
      // try (34 -> 40): 16 null
      // try (42 -> 44): 16 null
      // try (52 -> 55): 16 null
   }

   @Override
   public boolean a() {
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
      // 00: bipush 1
      // 01: istore 2
      // 02: bipush 1
      // 03: istore 1
      // 04: aload 0
      // 05: getfield retrofit2/OkHttpCall.c Z
      // 08: ifeq 0d
      // 0b: iload 1
      // 0c: ireturn
      // 0d: aload 0
      // 0e: monitorenter
      // 0f: aload 0
      // 10: getfield retrofit2/OkHttpCall.d Lokhttp3/Call;
      // 13: ifnull 2e
      // 16: aload 0
      // 17: getfield retrofit2/OkHttpCall.d Lokhttp3/Call;
      // 1a: invokeinterface okhttp3/Call.d ()Z 1
      // 1f: ifeq 2e
      // 22: iload 2
      // 23: istore 1
      // 24: aload 0
      // 25: monitorexit
      // 26: goto 0b
      // 29: astore 3
      // 2a: aload 0
      // 2b: monitorexit
      // 2c: aload 3
      // 2d: athrow
      // 2e: bipush 0
      // 2f: istore 1
      // 30: goto 24
      // try (11 -> 18): 23 null
      // try (20 -> 22): 23 null
      // try (24 -> 26): 23 null
   }

   public OkHttpCall<T> c() {
      return new OkHttpCall<>(this.a, this.b);
   }

   static final class ExceptionCatchingRequestBody extends ResponseBody {
      IOException a;
      private final ResponseBody b;

      ExceptionCatchingRequestBody(ResponseBody var1) {
         this.b = var1;
      }

      @Override
      public MediaType a() {
         return this.b.a();
      }

      @Override
      public long b() {
         return this.b.b();
      }

      @Override
      public BufferedSource c() {
         return Okio.a(new ForwardingSource(this, this.b.c()) {
            final OkHttpCall.ExceptionCatchingRequestBody a;

            {
               this.a = var1;
            }

            @Override
            public long a(Buffer var1, long var2) throws IOException {
               try {
                  return super.a(var1, var2);
               } catch (IOException var4) {
                  this.a.a = var4;
                  throw var4;
               }
            }
         });
      }

      @Override
      public void close() {
         this.b.close();
      }

      void g() throws IOException {
         if (this.a != null) {
            throw this.a;
         }
      }
   }

   static final class NoContentResponseBody extends ResponseBody {
      private final MediaType a;
      private final long b;

      NoContentResponseBody(MediaType var1, long var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public MediaType a() {
         return this.a;
      }

      @Override
      public long b() {
         return this.b;
      }

      @Override
      public BufferedSource c() {
         throw new IllegalStateException("Cannot read raw response body of a converted body.");
      }
   }
}
