package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {
   static final boolean i;
   long a = 0L;
   long b;
   final int c;
   final Http2Connection d;
   final Http2Stream.FramingSink e;
   final Http2Stream.StreamTimeout f = new Http2Stream.StreamTimeout(this);
   final Http2Stream.StreamTimeout g = new Http2Stream.StreamTimeout(this);
   ErrorCode h = null;
   private final List<Header> j;
   private List<Header> k;
   private boolean l;
   private final Http2Stream.FramingSource m;

   static {
      boolean var0;
      if (!Http2Stream.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      i = var0;
   }

   Http2Stream(int var1, Http2Connection var2, boolean var3, boolean var4, List<Header> var5) {
      if (var2 == null) {
         throw new NullPointerException("connection == null");
      }

      if (var5 == null) {
         throw new NullPointerException("requestHeaders == null");
      }

      this.c = var1;
      this.d = var2;
      this.b = var2.m.d();
      this.m = new Http2Stream.FramingSource(this, var2.l.d());
      this.e = new Http2Stream.FramingSink(this);
      this.m.b = var4;
      this.e.b = var3;
      this.j = var5;
   }

   private boolean d(ErrorCode param1) {
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
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic okhttp3/internal/http2/Http2Stream.i Z
      // 05: ifne 17
      // 08: aload 0
      // 09: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
      // 0c: ifeq 17
      // 0f: new java/lang/AssertionError
      // 12: dup
      // 13: invokespecial java/lang/AssertionError.<init> ()V
      // 16: athrow
      // 17: aload 0
      // 18: monitorenter
      // 19: aload 0
      // 1a: getfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
      // 1d: ifnull 24
      // 20: aload 0
      // 21: monitorexit
      // 22: iload 2
      // 23: ireturn
      // 24: aload 0
      // 25: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 28: getfield okhttp3/internal/http2/Http2Stream$FramingSource.b Z
      // 2b: ifeq 42
      // 2e: aload 0
      // 2f: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 32: getfield okhttp3/internal/http2/Http2Stream$FramingSink.b Z
      // 35: ifeq 42
      // 38: aload 0
      // 39: monitorexit
      // 3a: goto 22
      // 3d: astore 1
      // 3e: aload 0
      // 3f: monitorexit
      // 40: aload 1
      // 41: athrow
      // 42: aload 0
      // 43: aload 1
      // 44: putfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
      // 47: aload 0
      // 48: invokevirtual java/lang/Object.notifyAll ()V
      // 4b: aload 0
      // 4c: monitorexit
      // 4d: aload 0
      // 4e: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
      // 51: aload 0
      // 52: getfield okhttp3/internal/http2/Http2Stream.c I
      // 55: invokevirtual okhttp3/internal/http2/Http2Connection.b (I)Lokhttp3/internal/http2/Http2Stream;
      // 58: pop
      // 59: bipush 1
      // 5a: istore 2
      // 5b: goto 22
      // try (13 -> 18): 31 null
      // try (20 -> 30): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 43): 31 null
   }

   public int a() {
      return this.c;
   }

   void a(long var1) {
      this.b += var1;
      if (var1 > 0L) {
         this.notifyAll();
      }
   }

   void a(List<Header> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 2
      // 02: getstatic okhttp3/internal/http2/Http2Stream.i Z
      // 05: ifne 17
      // 08: aload 0
      // 09: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
      // 0c: ifeq 17
      // 0f: new java/lang/AssertionError
      // 12: dup
      // 13: invokespecial java/lang/AssertionError.<init> ()V
      // 16: athrow
      // 17: aload 0
      // 18: monitorenter
      // 19: aload 0
      // 1a: bipush 1
      // 1b: putfield okhttp3/internal/http2/Http2Stream.l Z
      // 1e: aload 0
      // 1f: getfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 22: ifnonnull 46
      // 25: aload 0
      // 26: aload 1
      // 27: putfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 2a: aload 0
      // 2b: invokevirtual okhttp3/internal/http2/Http2Stream.b ()Z
      // 2e: istore 2
      // 2f: aload 0
      // 30: invokevirtual java/lang/Object.notifyAll ()V
      // 33: aload 0
      // 34: monitorexit
      // 35: iload 2
      // 36: ifne 45
      // 39: aload 0
      // 3a: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
      // 3d: aload 0
      // 3e: getfield okhttp3/internal/http2/Http2Stream.c I
      // 41: invokevirtual okhttp3/internal/http2/Http2Connection.b (I)Lokhttp3/internal/http2/Http2Stream;
      // 44: pop
      // 45: return
      // 46: new java/util/ArrayList
      // 49: astore 3
      // 4a: aload 3
      // 4b: invokespecial java/util/ArrayList.<init> ()V
      // 4e: aload 3
      // 4f: aload 0
      // 50: getfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 53: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 58: pop
      // 59: aload 3
      // 5a: aconst_null
      // 5b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 60: pop
      // 61: aload 3
      // 62: aload 1
      // 63: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 68: pop
      // 69: aload 0
      // 6a: aload 3
      // 6b: putfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 6e: goto 33
      // 71: astore 1
      // 72: aload 0
      // 73: monitorexit
      // 74: aload 1
      // 75: athrow
      // try (13 -> 27): 59 null
      // try (27 -> 29): 59 null
      // try (38 -> 58): 59 null
      // try (60 -> 62): 59 null
   }

   public void a(ErrorCode var1) throws IOException {
      if (this.d(var1)) {
         this.d.b(this.c, var1);
      }
   }

   void a(BufferedSource var1, int var2) throws IOException {
      if (!i && Thread.holdsLock(this)) {
         throw new AssertionError();
      }

      this.m.a(var1, var2);
   }

   public void b(ErrorCode var1) {
      if (this.d(var1)) {
         this.d.a(this.c, var1);
      }
   }

   public boolean b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
      // 08: astore 3
      // 09: aload 3
      // 0a: ifnull 11
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: iload 1
      // 10: ireturn
      // 11: aload 0
      // 12: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 15: getfield okhttp3/internal/http2/Http2Stream$FramingSource.b Z
      // 18: ifne 25
      // 1b: aload 0
      // 1c: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 1f: getfield okhttp3/internal/http2/Http2Stream$FramingSource.a Z
      // 22: ifeq 42
      // 25: aload 0
      // 26: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 29: getfield okhttp3/internal/http2/Http2Stream$FramingSink.b Z
      // 2c: ifne 39
      // 2f: aload 0
      // 30: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 33: getfield okhttp3/internal/http2/Http2Stream$FramingSink.a Z
      // 36: ifeq 42
      // 39: aload 0
      // 3a: getfield okhttp3/internal/http2/Http2Stream.l Z
      // 3d: istore 2
      // 3e: iload 2
      // 3f: ifne 0d
      // 42: bipush 1
      // 43: istore 1
      // 44: goto 0d
      // 47: astore 3
      // 48: aload 0
      // 49: monitorexit
      // 4a: aload 3
      // 4b: athrow
      // try (4 -> 7): 37 null
      // try (13 -> 21): 37 null
      // try (21 -> 29): 37 null
      // try (29 -> 32): 37 null
   }

   void c(ErrorCode var1) {
      synchronized (this) {
         if (this.h == null) {
            this.h = var1;
            this.notifyAll();
         }
      }
   }

   public boolean c() {
      boolean var2 = true;
      boolean var1;
      if ((this.c & 1) == 1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (this.d.b == var1) {
         var1 = var2;
      } else {
         var1 = false;
      }

      return var1;
   }

   public List<Header> d() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual okhttp3/internal/http2/Http2Stream.c ()Z
      // 06: ifne 1a
      // 09: new java/lang/IllegalStateException
      // 0c: astore 1
      // 0d: aload 1
      // 0e: ldc "servers cannot read response headers"
      // 10: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 13: aload 1
      // 14: athrow
      // 15: astore 1
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // 1a: aload 0
      // 1b: getfield okhttp3/internal/http2/Http2Stream.f Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      // 1e: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.c ()V
      // 21: aload 0
      // 22: getfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 25: ifnonnull 40
      // 28: aload 0
      // 29: getfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
      // 2c: ifnonnull 40
      // 2f: aload 0
      // 30: invokevirtual okhttp3/internal/http2/Http2Stream.l ()V
      // 33: goto 21
      // 36: astore 1
      // 37: aload 0
      // 38: getfield okhttp3/internal/http2/Http2Stream.f Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      // 3b: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
      // 3e: aload 1
      // 3f: athrow
      // 40: aload 0
      // 41: getfield okhttp3/internal/http2/Http2Stream.f Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      // 44: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
      // 47: aload 0
      // 48: getfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 4b: astore 1
      // 4c: aload 1
      // 4d: ifnull 59
      // 50: aload 0
      // 51: aconst_null
      // 52: putfield okhttp3/internal/http2/Http2Stream.k Ljava/util/List;
      // 55: aload 0
      // 56: monitorexit
      // 57: aload 1
      // 58: areturn
      // 59: new okhttp3/internal/http2/StreamResetException
      // 5c: astore 1
      // 5d: aload 1
      // 5e: aload 0
      // 5f: getfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
      // 62: invokespecial okhttp3/internal/http2/StreamResetException.<init> (Lokhttp3/internal/http2/ErrorCode;)V
      // 65: aload 1
      // 66: athrow
      // try (2 -> 12): 12 null
      // try (17 -> 20): 12 null
      // try (20 -> 28): 29 null
      // try (30 -> 35): 12 null
      // try (35 -> 41): 12 null
      // try (43 -> 46): 12 null
      // try (50 -> 58): 12 null
   }

   public Timeout e() {
      return this.f;
   }

   public Timeout f() {
      return this.g;
   }

   public Source g() {
      return this.m;
   }

   public Sink h() {
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
      // 03: getfield okhttp3/internal/http2/Http2Stream.l Z
      // 06: ifne 21
      // 09: aload 0
      // 0a: invokevirtual okhttp3/internal/http2/Http2Stream.c ()Z
      // 0d: ifne 21
      // 10: new java/lang/IllegalStateException
      // 13: astore 1
      // 14: aload 1
      // 15: ldc "reply before requesting the sink"
      // 17: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 1a: aload 1
      // 1b: athrow
      // 1c: astore 1
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: aload 1
      // 20: athrow
      // 21: aload 0
      // 22: monitorexit
      // 23: aload 0
      // 24: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 27: areturn
      // try (2 -> 15): 15 null
      // try (16 -> 18): 15 null
      // try (20 -> 22): 15 null
   }

   void i() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic okhttp3/internal/http2/Http2Stream.i Z
      // 03: ifne 15
      // 06: aload 0
      // 07: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
      // 0a: ifeq 15
      // 0d: new java/lang/AssertionError
      // 10: dup
      // 11: invokespecial java/lang/AssertionError.<init> ()V
      // 14: athrow
      // 15: aload 0
      // 16: monitorenter
      // 17: aload 0
      // 18: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 1b: bipush 1
      // 1c: putfield okhttp3/internal/http2/Http2Stream$FramingSource.b Z
      // 1f: aload 0
      // 20: invokevirtual okhttp3/internal/http2/Http2Stream.b ()Z
      // 23: istore 1
      // 24: aload 0
      // 25: invokevirtual java/lang/Object.notifyAll ()V
      // 28: aload 0
      // 29: monitorexit
      // 2a: iload 1
      // 2b: ifne 3a
      // 2e: aload 0
      // 2f: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
      // 32: aload 0
      // 33: getfield okhttp3/internal/http2/Http2Stream.c I
      // 36: invokevirtual okhttp3/internal/http2/Http2Connection.b (I)Lokhttp3/internal/http2/Http2Stream;
      // 39: pop
      // 3a: return
      // 3b: astore 2
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 2
      // 3f: athrow
      // try (11 -> 22): 31 null
      // try (32 -> 34): 31 null
   }

   void j() throws IOException {
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
      // 00: getstatic okhttp3/internal/http2/Http2Stream.i Z
      // 03: ifne 15
      // 06: aload 0
      // 07: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
      // 0a: ifeq 15
      // 0d: new java/lang/AssertionError
      // 10: dup
      // 11: invokespecial java/lang/AssertionError.<init> ()V
      // 14: athrow
      // 15: aload 0
      // 16: monitorenter
      // 17: aload 0
      // 18: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 1b: getfield okhttp3/internal/http2/Http2Stream$FramingSource.b Z
      // 1e: ifne 54
      // 21: aload 0
      // 22: getfield okhttp3/internal/http2/Http2Stream.m Lokhttp3/internal/http2/Http2Stream$FramingSource;
      // 25: getfield okhttp3/internal/http2/Http2Stream$FramingSource.a Z
      // 28: ifeq 54
      // 2b: aload 0
      // 2c: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 2f: getfield okhttp3/internal/http2/Http2Stream$FramingSink.b Z
      // 32: ifne 3f
      // 35: aload 0
      // 36: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
      // 39: getfield okhttp3/internal/http2/Http2Stream$FramingSink.a Z
      // 3c: ifeq 54
      // 3f: bipush 1
      // 40: istore 1
      // 41: aload 0
      // 42: invokevirtual okhttp3/internal/http2/Http2Stream.b ()Z
      // 45: istore 2
      // 46: aload 0
      // 47: monitorexit
      // 48: iload 1
      // 49: ifeq 5e
      // 4c: aload 0
      // 4d: getstatic okhttp3/internal/http2/ErrorCode.CANCEL Lokhttp3/internal/http2/ErrorCode;
      // 50: invokevirtual okhttp3/internal/http2/Http2Stream.a (Lokhttp3/internal/http2/ErrorCode;)V
      // 53: return
      // 54: bipush 0
      // 55: istore 1
      // 56: goto 41
      // 59: astore 3
      // 5a: aload 0
      // 5b: monitorexit
      // 5c: aload 3
      // 5d: athrow
      // 5e: iload 2
      // 5f: ifne 53
      // 62: aload 0
      // 63: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
      // 66: aload 0
      // 67: getfield okhttp3/internal/http2/Http2Stream.c I
      // 6a: invokevirtual okhttp3/internal/http2/Http2Connection.b (I)Lokhttp3/internal/http2/Http2Stream;
      // 6d: pop
      // 6e: goto 53
      // try (11 -> 27): 43 null
      // try (29 -> 34): 43 null
      // try (44 -> 46): 43 null
   }

   void k() throws IOException {
      if (this.e.a) {
         throw new IOException("stream closed");
      }

      if (this.e.b) {
         throw new IOException("stream finished");
      }

      if (this.h != null) {
         throw new StreamResetException(this.h);
      }
   }

   void l() throws InterruptedIOException {
      try {
         this.wait();
      } catch (InterruptedException var2) {
         throw new InterruptedIOException();
      }
   }

   final class FramingSink implements Sink {
      static final boolean c;
      boolean a;
      boolean b;
      final Http2Stream d;
      private final Buffer e;

      static {
         boolean var0;
         if (!Http2Stream.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         c = var0;
      }

      FramingSink(Http2Stream var1) {
         this.d = var1;
         this.e = new Buffer();
      }

      private void a(boolean param1) throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 04: astore 5
         // 06: aload 5
         // 08: monitorenter
         // 09: aload 0
         // 0a: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 0d: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // 10: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.c ()V
         // 13: aload 0
         // 14: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 17: getfield okhttp3/internal/http2/Http2Stream.b J
         // 1a: lconst_0
         // 1b: lcmp
         // 1c: ifgt 58
         // 1f: aload 0
         // 20: getfield okhttp3/internal/http2/Http2Stream$FramingSink.b Z
         // 23: ifne 58
         // 26: aload 0
         // 27: getfield okhttp3/internal/http2/Http2Stream$FramingSink.a Z
         // 2a: ifne 58
         // 2d: aload 0
         // 2e: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 31: getfield okhttp3/internal/http2/Http2Stream.h Lokhttp3/internal/http2/ErrorCode;
         // 34: ifnonnull 58
         // 37: aload 0
         // 38: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 3b: invokevirtual okhttp3/internal/http2/Http2Stream.l ()V
         // 3e: goto 13
         // 41: astore 6
         // 43: aload 0
         // 44: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 47: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // 4a: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
         // 4d: aload 6
         // 4f: athrow
         // 50: astore 6
         // 52: aload 5
         // 54: monitorexit
         // 55: aload 6
         // 57: athrow
         // 58: aload 0
         // 59: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 5c: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // 5f: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
         // 62: aload 0
         // 63: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 66: invokevirtual okhttp3/internal/http2/Http2Stream.k ()V
         // 69: aload 0
         // 6a: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 6d: getfield okhttp3/internal/http2/Http2Stream.b J
         // 70: aload 0
         // 71: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // 74: invokevirtual okio/Buffer.b ()J
         // 77: invokestatic java/lang/Math.min (JJ)J
         // 7a: lstore 3
         // 7b: aload 0
         // 7c: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 7f: astore 6
         // 81: aload 6
         // 83: aload 6
         // 85: getfield okhttp3/internal/http2/Http2Stream.b J
         // 88: lload 3
         // 89: lsub
         // 8a: putfield okhttp3/internal/http2/Http2Stream.b J
         // 8d: aload 5
         // 8f: monitorexit
         // 90: aload 0
         // 91: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 94: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // 97: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.c ()V
         // 9a: aload 0
         // 9b: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 9e: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // a1: astore 5
         // a3: aload 0
         // a4: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // a7: getfield okhttp3/internal/http2/Http2Stream.c I
         // aa: istore 2
         // ab: iload 1
         // ac: ifeq d4
         // af: lload 3
         // b0: aload 0
         // b1: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // b4: invokevirtual okio/Buffer.b ()J
         // b7: lcmp
         // b8: ifne d4
         // bb: bipush 1
         // bc: istore 1
         // bd: aload 5
         // bf: iload 2
         // c0: iload 1
         // c1: aload 0
         // c2: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // c5: lload 3
         // c6: invokevirtual okhttp3/internal/http2/Http2Connection.a (IZLokio/Buffer;J)V
         // c9: aload 0
         // ca: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // cd: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // d0: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
         // d3: return
         // d4: bipush 0
         // d5: istore 1
         // d6: goto bd
         // d9: astore 5
         // db: aload 0
         // dc: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // df: getfield okhttp3/internal/http2/Http2Stream.g Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
         // e2: invokevirtual okhttp3/internal/http2/Http2Stream$StreamTimeout.b ()V
         // e5: aload 5
         // e7: athrow
         // try (5 -> 9): 36 null
         // try (9 -> 28): 29 null
         // try (30 -> 36): 36 null
         // try (37 -> 39): 36 null
         // try (41 -> 67): 36 null
         // try (71 -> 79): 104 null
         // try (81 -> 87): 104 null
         // try (89 -> 96): 104 null
      }

      @Override
      public Timeout a() {
         return this.d.g;
      }

      @Override
      public void a_(Buffer var1, long var2) throws IOException {
         if (!c && Thread.holdsLock(this.d)) {
            throw new AssertionError();
         }

         this.e.a_(var1, var2);

         while (this.e.b() >= 16384L) {
            this.a(false);
         }
      }

      @Override
      public void close() throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         //
         // Bytecode:
         // 00: getstatic okhttp3/internal/http2/Http2Stream$FramingSink.c Z
         // 03: ifne 18
         // 06: aload 0
         // 07: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 0a: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
         // 0d: ifeq 18
         // 10: new java/lang/AssertionError
         // 13: dup
         // 14: invokespecial java/lang/AssertionError.<init> ()V
         // 17: athrow
         // 18: aload 0
         // 19: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 1c: astore 1
         // 1d: aload 1
         // 1e: monitorenter
         // 1f: aload 0
         // 20: getfield okhttp3/internal/http2/Http2Stream$FramingSink.a Z
         // 23: ifeq 29
         // 26: aload 1
         // 27: monitorexit
         // 28: return
         // 29: aload 1
         // 2a: monitorexit
         // 2b: aload 0
         // 2c: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 2f: getfield okhttp3/internal/http2/Http2Stream.e Lokhttp3/internal/http2/Http2Stream$FramingSink;
         // 32: getfield okhttp3/internal/http2/Http2Stream$FramingSink.b Z
         // 35: ifne 71
         // 38: aload 0
         // 39: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // 3c: invokevirtual okio/Buffer.b ()J
         // 3f: lconst_0
         // 40: lcmp
         // 41: ifle 5d
         // 44: aload 0
         // 45: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // 48: invokevirtual okio/Buffer.b ()J
         // 4b: lconst_0
         // 4c: lcmp
         // 4d: ifle 71
         // 50: aload 0
         // 51: bipush 1
         // 52: invokespecial okhttp3/internal/http2/Http2Stream$FramingSink.a (Z)V
         // 55: goto 44
         // 58: astore 2
         // 59: aload 1
         // 5a: monitorexit
         // 5b: aload 2
         // 5c: athrow
         // 5d: aload 0
         // 5e: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 61: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 64: aload 0
         // 65: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 68: getfield okhttp3/internal/http2/Http2Stream.c I
         // 6b: bipush 1
         // 6c: aconst_null
         // 6d: lconst_0
         // 6e: invokevirtual okhttp3/internal/http2/Http2Connection.a (IZLokio/Buffer;J)V
         // 71: aload 0
         // 72: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 75: astore 2
         // 76: aload 2
         // 77: monitorenter
         // 78: aload 0
         // 79: bipush 1
         // 7a: putfield okhttp3/internal/http2/Http2Stream$FramingSink.a Z
         // 7d: aload 2
         // 7e: monitorexit
         // 7f: aload 0
         // 80: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 83: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 86: invokevirtual okhttp3/internal/http2/Http2Connection.b ()V
         // 89: aload 0
         // 8a: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 8d: invokevirtual okhttp3/internal/http2/Http2Stream.j ()V
         // 90: goto 28
         // 93: astore 1
         // 94: aload 2
         // 95: monitorexit
         // 96: aload 1
         // 97: athrow
         // try (15 -> 20): 44 null
         // try (21 -> 23): 44 null
         // try (45 -> 47): 44 null
         // try (64 -> 69): 77 null
         // try (78 -> 80): 77 null
      }

      @Override
      public void flush() throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         //
         // Bytecode:
         // 00: getstatic okhttp3/internal/http2/Http2Stream$FramingSink.c Z
         // 03: ifne 18
         // 06: aload 0
         // 07: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 0a: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
         // 0d: ifeq 18
         // 10: new java/lang/AssertionError
         // 13: dup
         // 14: invokespecial java/lang/AssertionError.<init> ()V
         // 17: athrow
         // 18: aload 0
         // 19: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 1c: astore 1
         // 1d: aload 1
         // 1e: monitorenter
         // 1f: aload 0
         // 20: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 23: invokevirtual okhttp3/internal/http2/Http2Stream.k ()V
         // 26: aload 1
         // 27: monitorexit
         // 28: aload 0
         // 29: getfield okhttp3/internal/http2/Http2Stream$FramingSink.e Lokio/Buffer;
         // 2c: invokevirtual okio/Buffer.b ()J
         // 2f: lconst_0
         // 30: lcmp
         // 31: ifle 4b
         // 34: aload 0
         // 35: bipush 0
         // 36: invokespecial okhttp3/internal/http2/Http2Stream$FramingSink.a (Z)V
         // 39: aload 0
         // 3a: getfield okhttp3/internal/http2/Http2Stream$FramingSink.d Lokhttp3/internal/http2/Http2Stream;
         // 3d: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 40: invokevirtual okhttp3/internal/http2/Http2Connection.b ()V
         // 43: goto 28
         // 46: astore 2
         // 47: aload 1
         // 48: monitorexit
         // 49: aload 2
         // 4a: athrow
         // 4b: return
         // try (15 -> 20): 34 null
         // try (35 -> 37): 34 null
      }
   }

   private final class FramingSource implements Source {
      static final boolean c;
      boolean a;
      boolean b;
      final Http2Stream d;
      private final Buffer e;
      private final Buffer f;
      private final long g;

      static {
         boolean var0;
         if (!Http2Stream.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         c = var0;
      }

      FramingSource(Http2Stream var1, long var2) {
         this.d = var1;
         this.e = new Buffer();
         this.f = new Buffer();
         this.g = var2;
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      private void b() throws IOException {
         this.d.f.c();

         while (true) {
            boolean var3 = false /* VF: Semaphore variable */;

            try {
               var3 = true;
               if (this.f.b() == 0L) {
                  if (!this.b) {
                     if (!this.a) {
                        if (this.d.h == null) {
                           this.d.l();
                           var3 = false;
                           continue;
                        }

                        var3 = false;
                        break;
                     }

                     var3 = false;
                     break;
                  }

                  var3 = false;
                  break;
               }

               var3 = false;
               break;
            } finally {
               if (var3) {
                  this.d.f.b();
               }
            }
         }

         this.d.f.b();
      }

      private void c() throws IOException {
         if (this.a) {
            throw new IOException("stream closed");
         }

         if (this.d.h != null) {
            throw new StreamResetException(this.d.h);
         }
      }

      @Override
      public long a(Buffer param1, long param2) throws IOException {
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
         // 000: lload 2
         // 001: lconst_0
         // 002: lcmp
         // 003: ifge 021
         // 006: new java/lang/IllegalArgumentException
         // 009: dup
         // 00a: new java/lang/StringBuilder
         // 00d: dup
         // 00e: invokespecial java/lang/StringBuilder.<init> ()V
         // 011: ldc "byteCount < 0: "
         // 013: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 016: lload 2
         // 017: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
         // 01a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 01d: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
         // 020: athrow
         // 021: aload 0
         // 022: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 025: astore 4
         // 027: aload 4
         // 029: monitorenter
         // 02a: aload 0
         // 02b: invokespecial okhttp3/internal/http2/Http2Stream$FramingSource.b ()V
         // 02e: aload 0
         // 02f: invokespecial okhttp3/internal/http2/Http2Stream$FramingSource.c ()V
         // 032: aload 0
         // 033: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 036: invokevirtual okio/Buffer.b ()J
         // 039: lconst_0
         // 03a: lcmp
         // 03b: ifne 047
         // 03e: ldc2_w -1
         // 041: lstore 2
         // 042: aload 4
         // 044: monitorexit
         // 045: lload 2
         // 046: lreturn
         // 047: aload 0
         // 048: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 04b: aload 1
         // 04c: lload 2
         // 04d: aload 0
         // 04e: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 051: invokevirtual okio/Buffer.b ()J
         // 054: invokestatic java/lang/Math.min (JJ)J
         // 057: invokevirtual okio/Buffer.a (Lokio/Buffer;J)J
         // 05a: lstore 2
         // 05b: aload 0
         // 05c: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 05f: astore 1
         // 060: aload 1
         // 061: aload 1
         // 062: getfield okhttp3/internal/http2/Http2Stream.a J
         // 065: lload 2
         // 066: ladd
         // 067: putfield okhttp3/internal/http2/Http2Stream.a J
         // 06a: aload 0
         // 06b: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 06e: getfield okhttp3/internal/http2/Http2Stream.a J
         // 071: aload 0
         // 072: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 075: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 078: getfield okhttp3/internal/http2/Http2Connection.l Lokhttp3/internal/http2/Settings;
         // 07b: invokevirtual okhttp3/internal/http2/Settings.d ()I
         // 07e: bipush 2
         // 07f: idiv
         // 080: i2l
         // 081: lcmp
         // 082: iflt 0a5
         // 085: aload 0
         // 086: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 089: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 08c: aload 0
         // 08d: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 090: getfield okhttp3/internal/http2/Http2Stream.c I
         // 093: aload 0
         // 094: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 097: getfield okhttp3/internal/http2/Http2Stream.a J
         // 09a: invokevirtual okhttp3/internal/http2/Http2Connection.a (IJ)V
         // 09d: aload 0
         // 09e: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0a1: lconst_0
         // 0a2: putfield okhttp3/internal/http2/Http2Stream.a J
         // 0a5: aload 4
         // 0a7: monitorexit
         // 0a8: aload 0
         // 0a9: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0ac: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0af: astore 1
         // 0b0: aload 1
         // 0b1: monitorenter
         // 0b2: aload 0
         // 0b3: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0b6: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0b9: astore 4
         // 0bb: aload 4
         // 0bd: aload 4
         // 0bf: getfield okhttp3/internal/http2/Http2Connection.j J
         // 0c2: lload 2
         // 0c3: ladd
         // 0c4: putfield okhttp3/internal/http2/Http2Connection.j J
         // 0c7: aload 0
         // 0c8: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0cb: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0ce: getfield okhttp3/internal/http2/Http2Connection.j J
         // 0d1: aload 0
         // 0d2: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0d5: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0d8: getfield okhttp3/internal/http2/Http2Connection.l Lokhttp3/internal/http2/Settings;
         // 0db: invokevirtual okhttp3/internal/http2/Settings.d ()I
         // 0de: bipush 2
         // 0df: idiv
         // 0e0: i2l
         // 0e1: lcmp
         // 0e2: iflt 105
         // 0e5: aload 0
         // 0e6: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0e9: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0ec: bipush 0
         // 0ed: aload 0
         // 0ee: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0f1: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 0f4: getfield okhttp3/internal/http2/Http2Connection.j J
         // 0f7: invokevirtual okhttp3/internal/http2/Http2Connection.a (IJ)V
         // 0fa: aload 0
         // 0fb: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 0fe: getfield okhttp3/internal/http2/Http2Stream.d Lokhttp3/internal/http2/Http2Connection;
         // 101: lconst_0
         // 102: putfield okhttp3/internal/http2/Http2Connection.j J
         // 105: aload 1
         // 106: monitorexit
         // 107: goto 045
         // 10a: astore 4
         // 10c: aload 1
         // 10d: monitorexit
         // 10e: aload 4
         // 110: athrow
         // 111: astore 1
         // 112: aload 4
         // 114: monitorexit
         // 115: aload 1
         // 116: athrow
         // try (21 -> 31): 137 null
         // try (33 -> 35): 137 null
         // try (37 -> 83): 137 null
         // try (83 -> 85): 137 null
         // try (91 -> 129): 132 null
         // try (129 -> 131): 132 null
         // try (133 -> 135): 132 null
         // try (138 -> 140): 137 null
      }

      @Override
      public Timeout a() {
         return this.d.f;
      }

      void a(BufferedSource param1, long param2) throws IOException {
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
         // 00: lload 2
         // 01: lstore 6
         // 03: getstatic okhttp3/internal/http2/Http2Stream$FramingSource.c Z
         // 06: ifne 57
         // 09: lload 2
         // 0a: lstore 6
         // 0c: aload 0
         // 0d: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 10: invokestatic java/lang/Thread.holdsLock (Ljava/lang/Object;)Z
         // 13: ifeq 57
         // 16: new java/lang/AssertionError
         // 19: dup
         // 1a: invokespecial java/lang/AssertionError.<init> ()V
         // 1d: athrow
         // 1e: lload 6
         // 20: lload 2
         // 21: lsub
         // 22: lstore 6
         // 24: aload 0
         // 25: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 28: astore 8
         // 2a: aload 8
         // 2c: monitorenter
         // 2d: aload 0
         // 2e: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 31: invokevirtual okio/Buffer.b ()J
         // 34: lconst_0
         // 35: lcmp
         // 36: ifne d6
         // 39: bipush 1
         // 3a: istore 4
         // 3c: aload 0
         // 3d: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 40: aload 0
         // 41: getfield okhttp3/internal/http2/Http2Stream$FramingSource.e Lokio/Buffer;
         // 44: invokevirtual okio/Buffer.a (Lokio/Source;)J
         // 47: pop2
         // 48: iload 4
         // 4a: ifeq 54
         // 4d: aload 0
         // 4e: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 51: invokevirtual java/lang/Object.notifyAll ()V
         // 54: aload 8
         // 56: monitorexit
         // 57: lload 6
         // 59: lconst_0
         // 5a: lcmp
         // 5b: ifle 9c
         // 5e: aload 0
         // 5f: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 62: astore 8
         // 64: aload 8
         // 66: monitorenter
         // 67: aload 0
         // 68: getfield okhttp3/internal/http2/Http2Stream$FramingSource.b Z
         // 6b: istore 5
         // 6d: aload 0
         // 6e: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 71: invokevirtual okio/Buffer.b ()J
         // 74: lload 6
         // 76: ladd
         // 77: aload 0
         // 78: getfield okhttp3/internal/http2/Http2Stream$FramingSource.g J
         // 7b: lcmp
         // 7c: ifle 9d
         // 7f: bipush 1
         // 80: istore 4
         // 82: aload 8
         // 84: monitorexit
         // 85: iload 4
         // 87: ifeq a9
         // 8a: aload 1
         // 8b: lload 6
         // 8d: invokeinterface okio/BufferedSource.i (J)V 3
         // 92: aload 0
         // 93: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 96: getstatic okhttp3/internal/http2/ErrorCode.FLOW_CONTROL_ERROR Lokhttp3/internal/http2/ErrorCode;
         // 99: invokevirtual okhttp3/internal/http2/Http2Stream.b (Lokhttp3/internal/http2/ErrorCode;)V
         // 9c: return
         // 9d: bipush 0
         // 9e: istore 4
         // a0: goto 82
         // a3: astore 1
         // a4: aload 8
         // a6: monitorexit
         // a7: aload 1
         // a8: athrow
         // a9: iload 5
         // ab: ifeq b9
         // ae: aload 1
         // af: lload 6
         // b1: invokeinterface okio/BufferedSource.i (J)V 3
         // b6: goto 9c
         // b9: aload 1
         // ba: aload 0
         // bb: getfield okhttp3/internal/http2/Http2Stream$FramingSource.e Lokio/Buffer;
         // be: lload 6
         // c0: invokeinterface okio/BufferedSource.a (Lokio/Buffer;J)J 4
         // c5: lstore 2
         // c6: lload 2
         // c7: ldc2_w -1
         // ca: lcmp
         // cb: ifne 1e
         // ce: new java/io/EOFException
         // d1: dup
         // d2: invokespecial java/io/EOFException.<init> ()V
         // d5: athrow
         // d6: bipush 0
         // d7: istore 4
         // d9: goto 3c
         // dc: astore 1
         // dd: aload 8
         // df: monitorexit
         // e0: aload 1
         // e1: athrow
         // try (23 -> 29): 110 null
         // try (31 -> 37): 110 null
         // try (39 -> 42): 110 null
         // try (42 -> 44): 110 null
         // try (53 -> 65): 82 null
         // try (67 -> 69): 82 null
         // try (83 -> 85): 82 null
         // try (111 -> 113): 110 null
      }

      @Override
      public void close() throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 04: astore 2
         // 05: aload 2
         // 06: monitorenter
         // 07: aload 0
         // 08: bipush 1
         // 09: putfield okhttp3/internal/http2/Http2Stream$FramingSource.a Z
         // 0c: aload 0
         // 0d: getfield okhttp3/internal/http2/Http2Stream$FramingSource.f Lokio/Buffer;
         // 10: invokevirtual okio/Buffer.u ()V
         // 13: aload 0
         // 14: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 17: invokevirtual java/lang/Object.notifyAll ()V
         // 1a: aload 2
         // 1b: monitorexit
         // 1c: aload 0
         // 1d: getfield okhttp3/internal/http2/Http2Stream$FramingSource.d Lokhttp3/internal/http2/Http2Stream;
         // 20: invokevirtual okhttp3/internal/http2/Http2Stream.j ()V
         // 23: return
         // 24: astore 1
         // 25: aload 2
         // 26: monitorexit
         // 27: aload 1
         // 28: athrow
         // try (5 -> 16): 20 null
         // try (21 -> 23): 20 null
      }
   }

   class StreamTimeout extends AsyncTimeout {
      final Http2Stream a;

      StreamTimeout(Http2Stream var1) {
         this.a = var1;
      }

      @Override
      protected IOException a(IOException var1) {
         SocketTimeoutException var2 = new SocketTimeoutException("timeout");
         if (var1 != null) {
            var2.initCause(var1);
         }

         return var2;
      }

      @Override
      protected void a() {
         this.a.b(ErrorCode.CANCEL);
      }

      public void b() throws IOException {
         if (this.w_()) {
            throw this.a(null);
         }
      }
   }
}
