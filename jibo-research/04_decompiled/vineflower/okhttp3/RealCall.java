package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

final class RealCall implements Call {
   final OkHttpClient a;
   final RetryAndFollowUpInterceptor b;
   final EventListener c;
   final Request d;
   final boolean e;
   private boolean f;

   RealCall(OkHttpClient var1, Request var2, boolean var3) {
      EventListener.Factory var4 = var1.x();
      this.a = var1;
      this.d = var2;
      this.e = var3;
      this.b = new RetryAndFollowUpInterceptor(var1, var3);
      this.c = var4.a(this);
   }

   private void i() {
      Object var1 = Platform.b().a("response.body().close()");
      this.b.a(var1);
   }

   @Override
   public Request a() {
      return this.d;
   }

   @Override
   public void a(Callback param1) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/RealCall.f Z
      // 06: ifeq 1a
      // 09: new java/lang/IllegalStateException
      // 0c: astore 1
      // 0d: aload 1
      // 0e: ldc "Already Executed"
      // 10: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 13: aload 1
      // 14: athrow
      // 15: astore 1
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // 1a: aload 0
      // 1b: bipush 1
      // 1c: putfield okhttp3/RealCall.f Z
      // 1f: aload 0
      // 20: monitorexit
      // 21: aload 0
      // 22: invokespecial okhttp3/RealCall.i ()V
      // 25: aload 0
      // 26: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
      // 29: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
      // 2c: new okhttp3/RealCall$AsyncCall
      // 2f: dup
      // 30: aload 0
      // 31: aload 1
      // 32: invokespecial okhttp3/RealCall$AsyncCall.<init> (Lokhttp3/RealCall;Lokhttp3/Callback;)V
      // 35: invokevirtual okhttp3/Dispatcher.a (Lokhttp3/RealCall$AsyncCall;)V
      // 38: return
      // try (2 -> 12): 12 null
      // try (13 -> 15): 12 null
      // try (17 -> 22): 12 null
   }

   @Override
   public Response b() throws IOException {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/RealCall.f Z
      // 06: ifeq 1a
      // 09: new java/lang/IllegalStateException
      // 0c: astore 1
      // 0d: aload 1
      // 0e: ldc "Already Executed"
      // 10: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 13: aload 1
      // 14: athrow
      // 15: astore 1
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // 1a: aload 0
      // 1b: bipush 1
      // 1c: putfield okhttp3/RealCall.f Z
      // 1f: aload 0
      // 20: monitorexit
      // 21: aload 0
      // 22: invokespecial okhttp3/RealCall.i ()V
      // 25: aload 0
      // 26: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
      // 29: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
      // 2c: aload 0
      // 2d: invokevirtual okhttp3/Dispatcher.a (Lokhttp3/RealCall;)V
      // 30: aload 0
      // 31: invokevirtual okhttp3/RealCall.h ()Lokhttp3/Response;
      // 34: astore 1
      // 35: aload 1
      // 36: ifnonnull 53
      // 39: new java/io/IOException
      // 3c: astore 1
      // 3d: aload 1
      // 3e: ldc "Canceled"
      // 40: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
      // 4a: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
      // 4d: aload 0
      // 4e: invokevirtual okhttp3/Dispatcher.b (Lokhttp3/RealCall;)V
      // 51: aload 1
      // 52: athrow
      // 53: aload 0
      // 54: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
      // 57: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
      // 5a: aload 0
      // 5b: invokevirtual okhttp3/Dispatcher.b (Lokhttp3/RealCall;)V
      // 5e: aload 1
      // 5f: areturn
      // try (2 -> 12): 12 null
      // try (13 -> 15): 12 null
      // try (17 -> 22): 12 null
      // try (24 -> 32): 41 null
      // try (34 -> 41): 41 null
   }

   @Override
   public void c() {
      this.b.a();
   }

   @Override
   public boolean d() {
      return this.b.b();
   }

   public RealCall e() {
      return new RealCall(this.a, this.d, this.e);
   }

   String f() {
      StringBuilder var2 = new StringBuilder();
      String var1;
      if (this.d()) {
         var1 = "canceled ";
      } else {
         var1 = "";
      }

      var2 = var2.append(var1);
      if (this.e) {
         var1 = "web socket";
      } else {
         var1 = "call";
      }

      return var2.append(var1).append(" to ").append(this.g()).toString();
   }

   String g() {
      return this.d.a().o();
   }

   Response h() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.addAll(this.a.v());
      var1.add(this.b);
      var1.add(new BridgeInterceptor(this.a.f()));
      var1.add(new CacheInterceptor(this.a.g()));
      var1.add(new ConnectInterceptor(this.a));
      if (!this.e) {
         var1.addAll(this.a.w());
      }

      var1.add(new CallServerInterceptor(this.e));
      return new RealInterceptorChain(var1, null, null, null, 0, this.d).a(this.d);
   }

   final class AsyncCall extends NamedRunnable {
      final RealCall a;
      private final Callback c;

      AsyncCall(RealCall var1, Callback var2) {
         super("OkHttp %s", var1.g());
         this.a = var1;
         this.c = var2;
      }

      String a() {
         return this.a.d.a().g();
      }

      RealCall b() {
         return this.a;
      }

      @Override
      protected void c() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: bipush 1
         // 01: istore 1
         // 02: aload 0
         // 03: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 06: invokevirtual okhttp3/RealCall.h ()Lokhttp3/Response;
         // 09: astore 3
         // 0a: aload 0
         // 0b: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 0e: getfield okhttp3/RealCall.b Lokhttp3/internal/http/RetryAndFollowUpInterceptor;
         // 11: invokevirtual okhttp3/internal/http/RetryAndFollowUpInterceptor.b ()Z
         // 14: istore 2
         // 15: iload 2
         // 16: ifeq 48
         // 19: aload 0
         // 1a: getfield okhttp3/RealCall$AsyncCall.c Lokhttp3/Callback;
         // 1d: astore 5
         // 1f: aload 0
         // 20: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 23: astore 4
         // 25: new java/io/IOException
         // 28: astore 3
         // 29: aload 3
         // 2a: ldc "Canceled"
         // 2c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
         // 2f: aload 5
         // 31: aload 4
         // 33: aload 3
         // 34: invokeinterface okhttp3/Callback.onFailure (Lokhttp3/Call;Ljava/io/IOException;)V 3
         // 39: aload 0
         // 3a: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 3d: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
         // 40: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
         // 43: aload 0
         // 44: invokevirtual okhttp3/Dispatcher.b (Lokhttp3/RealCall$AsyncCall;)V
         // 47: return
         // 48: aload 0
         // 49: getfield okhttp3/RealCall$AsyncCall.c Lokhttp3/Callback;
         // 4c: aload 0
         // 4d: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 50: aload 3
         // 51: invokeinterface okhttp3/Callback.onResponse (Lokhttp3/Call;Lokhttp3/Response;)V 3
         // 56: goto 39
         // 59: astore 3
         // 5a: iload 1
         // 5b: ifeq 99
         // 5e: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
         // 61: astore 5
         // 63: new java/lang/StringBuilder
         // 66: astore 4
         // 68: aload 4
         // 6a: invokespecial java/lang/StringBuilder.<init> ()V
         // 6d: aload 5
         // 6f: bipush 4
         // 70: aload 4
         // 72: ldc "Callback failure for "
         // 74: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 77: aload 0
         // 78: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 7b: invokevirtual okhttp3/RealCall.f ()Ljava/lang/String;
         // 7e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 81: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 84: aload 3
         // 85: invokevirtual okhttp3/internal/platform/Platform.a (ILjava/lang/String;Ljava/lang/Throwable;)V
         // 88: aload 0
         // 89: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // 8c: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
         // 8f: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
         // 92: aload 0
         // 93: invokevirtual okhttp3/Dispatcher.b (Lokhttp3/RealCall$AsyncCall;)V
         // 96: goto 47
         // 99: aload 0
         // 9a: getfield okhttp3/RealCall$AsyncCall.c Lokhttp3/Callback;
         // 9d: aload 0
         // 9e: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // a1: aload 3
         // a2: invokeinterface okhttp3/Callback.onFailure (Lokhttp3/Call;Ljava/io/IOException;)V 3
         // a7: goto 88
         // aa: astore 3
         // ab: aload 0
         // ac: getfield okhttp3/RealCall$AsyncCall.a Lokhttp3/RealCall;
         // af: getfield okhttp3/RealCall.a Lokhttp3/OkHttpClient;
         // b2: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
         // b5: aload 0
         // b6: invokevirtual okhttp3/Dispatcher.b (Lokhttp3/RealCall$AsyncCall;)V
         // b9: aload 3
         // ba: athrow
         // bb: astore 3
         // bc: bipush 0
         // bd: istore 1
         // be: goto 5a
         // try (2 -> 11): 86 java/io/IOException
         // try (2 -> 11): 77 null
         // try (13 -> 28): 42 java/io/IOException
         // try (13 -> 28): 77 null
         // try (35 -> 41): 42 java/io/IOException
         // try (35 -> 41): 77 null
         // try (45 -> 63): 77 null
         // try (70 -> 76): 77 null
      }
   }
}
