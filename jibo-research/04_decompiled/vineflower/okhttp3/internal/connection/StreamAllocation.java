package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {
   static final boolean b;
   public final Address a;
   private Route c;
   private final ConnectionPool d;
   private final Object e;
   private final RouteSelector f;
   private int g;
   private RealConnection h;
   private boolean i;
   private boolean j;
   private HttpCodec k;

   static {
      boolean var0;
      if (!StreamAllocation.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
   }

   public StreamAllocation(ConnectionPool var1, Address var2, Object var3) {
      this.d = var1;
      this.a = var2;
      this.f = new RouteSelector(var2, this.g());
      this.e = var3;
   }

   private Socket a(boolean var1, boolean var2, boolean var3) {
      Object var5 = null;
      if (!b && !Thread.holdsLock(this.d)) {
         throw new AssertionError();
      }

      if (var3) {
         this.k = null;
      }

      if (var2) {
         this.i = true;
      }

      Socket var4 = (Socket)var5;
      if (this.h != null) {
         if (var1) {
            this.h.a = true;
         }

         var4 = (Socket)var5;
         if (this.k == null) {
            if (!this.i) {
               var4 = (Socket)var5;
               if (!this.h.a) {
                  return var4;
               }
            }

            label30: {
               this.c(this.h);
               if (this.h.d.isEmpty()) {
                  this.h.e = System.nanoTime();
                  if (Internal.a.a(this.d, this.h)) {
                     var4 = this.h.d();
                     break label30;
                  }
               }

               var4 = null;
            }

            this.h = null;
         }
      }

      return var4;
   }

   private RealConnection a(int param1, int param2, int param3, boolean param4) throws IOException {
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
      // 000: aconst_null
      // 001: astore 6
      // 003: aload 0
      // 004: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 007: astore 8
      // 009: aload 8
      // 00b: monitorenter
      // 00c: aload 0
      // 00d: getfield okhttp3/internal/connection/StreamAllocation.i Z
      // 010: ifeq 02a
      // 013: new java/lang/IllegalStateException
      // 016: astore 5
      // 018: aload 5
      // 01a: ldc "released"
      // 01c: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 01f: aload 5
      // 021: athrow
      // 022: astore 5
      // 024: aload 8
      // 026: monitorexit
      // 027: aload 5
      // 029: athrow
      // 02a: aload 0
      // 02b: getfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 02e: ifnull 040
      // 031: new java/lang/IllegalStateException
      // 034: astore 5
      // 036: aload 5
      // 038: ldc "codec != null"
      // 03a: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 03d: aload 5
      // 03f: athrow
      // 040: aload 0
      // 041: getfield okhttp3/internal/connection/StreamAllocation.j Z
      // 044: ifeq 056
      // 047: new java/io/IOException
      // 04a: astore 5
      // 04c: aload 5
      // 04e: ldc "Canceled"
      // 050: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 053: aload 5
      // 055: athrow
      // 056: aload 0
      // 057: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 05a: astore 5
      // 05c: aload 5
      // 05e: ifnull 06f
      // 061: aload 5
      // 063: getfield okhttp3/internal/connection/RealConnection.a Z
      // 066: ifne 06f
      // 069: aload 8
      // 06b: monitorexit
      // 06c: aload 5
      // 06e: areturn
      // 06f: getstatic okhttp3/internal/Internal.a Lokhttp3/internal/Internal;
      // 072: aload 0
      // 073: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 076: aload 0
      // 077: getfield okhttp3/internal/connection/StreamAllocation.a Lokhttp3/Address;
      // 07a: aload 0
      // 07b: aconst_null
      // 07c: invokevirtual okhttp3/internal/Internal.a (Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/Route;)Lokhttp3/internal/connection/RealConnection;
      // 07f: pop
      // 080: aload 0
      // 081: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 084: ifnull 093
      // 087: aload 0
      // 088: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 08b: astore 5
      // 08d: aload 8
      // 08f: monitorexit
      // 090: goto 06c
      // 093: aload 0
      // 094: getfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 097: astore 7
      // 099: aload 8
      // 09b: monitorexit
      // 09c: aload 7
      // 09e: astore 5
      // 0a0: aload 7
      // 0a2: ifnonnull 0ae
      // 0a5: aload 0
      // 0a6: getfield okhttp3/internal/connection/StreamAllocation.f Lokhttp3/internal/connection/RouteSelector;
      // 0a9: invokevirtual okhttp3/internal/connection/RouteSelector.b ()Lokhttp3/Route;
      // 0ac: astore 5
      // 0ae: aload 0
      // 0af: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 0b2: astore 8
      // 0b4: aload 8
      // 0b6: monitorenter
      // 0b7: aload 0
      // 0b8: getfield okhttp3/internal/connection/StreamAllocation.j Z
      // 0bb: ifeq 0d5
      // 0be: new java/io/IOException
      // 0c1: astore 5
      // 0c3: aload 5
      // 0c5: ldc "Canceled"
      // 0c7: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0ca: aload 5
      // 0cc: athrow
      // 0cd: astore 5
      // 0cf: aload 8
      // 0d1: monitorexit
      // 0d2: aload 5
      // 0d4: athrow
      // 0d5: getstatic okhttp3/internal/Internal.a Lokhttp3/internal/Internal;
      // 0d8: aload 0
      // 0d9: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 0dc: aload 0
      // 0dd: getfield okhttp3/internal/connection/StreamAllocation.a Lokhttp3/Address;
      // 0e0: aload 0
      // 0e1: aload 5
      // 0e3: invokevirtual okhttp3/internal/Internal.a (Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/Route;)Lokhttp3/internal/connection/RealConnection;
      // 0e6: pop
      // 0e7: aload 0
      // 0e8: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 0eb: ifnull 0fa
      // 0ee: aload 0
      // 0ef: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 0f2: astore 5
      // 0f4: aload 8
      // 0f6: monitorexit
      // 0f7: goto 06c
      // 0fa: aload 0
      // 0fb: aload 5
      // 0fd: putfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 100: aload 0
      // 101: bipush 0
      // 102: putfield okhttp3/internal/connection/StreamAllocation.g I
      // 105: new okhttp3/internal/connection/RealConnection
      // 108: astore 7
      // 10a: aload 7
      // 10c: aload 0
      // 10d: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 110: aload 5
      // 112: invokespecial okhttp3/internal/connection/RealConnection.<init> (Lokhttp3/ConnectionPool;Lokhttp3/Route;)V
      // 115: aload 0
      // 116: aload 7
      // 118: invokevirtual okhttp3/internal/connection/StreamAllocation.a (Lokhttp3/internal/connection/RealConnection;)V
      // 11b: aload 8
      // 11d: monitorexit
      // 11e: aload 7
      // 120: iload 1
      // 121: iload 2
      // 122: iload 3
      // 123: iload 4
      // 125: invokevirtual okhttp3/internal/connection/RealConnection.a (IIIZ)V
      // 128: aload 0
      // 129: invokespecial okhttp3/internal/connection/StreamAllocation.g ()Lokhttp3/internal/connection/RouteDatabase;
      // 12c: aload 7
      // 12e: invokevirtual okhttp3/internal/connection/RealConnection.a ()Lokhttp3/Route;
      // 131: invokevirtual okhttp3/internal/connection/RouteDatabase.b (Lokhttp3/Route;)V
      // 134: aload 0
      // 135: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 138: astore 8
      // 13a: aload 8
      // 13c: monitorenter
      // 13d: getstatic okhttp3/internal/Internal.a Lokhttp3/internal/Internal;
      // 140: aload 0
      // 141: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 144: aload 7
      // 146: invokevirtual okhttp3/internal/Internal.b (Lokhttp3/ConnectionPool;Lokhttp3/internal/connection/RealConnection;)V
      // 149: aload 7
      // 14b: invokevirtual okhttp3/internal/connection/RealConnection.f ()Z
      // 14e: ifeq 17b
      // 151: getstatic okhttp3/internal/Internal.a Lokhttp3/internal/Internal;
      // 154: aload 0
      // 155: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 158: aload 0
      // 159: getfield okhttp3/internal/connection/StreamAllocation.a Lokhttp3/Address;
      // 15c: aload 0
      // 15d: invokevirtual okhttp3/internal/Internal.a (Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/StreamAllocation;)Ljava/net/Socket;
      // 160: astore 6
      // 162: aload 0
      // 163: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 166: astore 5
      // 168: aload 8
      // 16a: monitorexit
      // 16b: aload 6
      // 16d: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 170: goto 06c
      // 173: astore 5
      // 175: aload 8
      // 177: monitorexit
      // 178: aload 5
      // 17a: athrow
      // 17b: aload 7
      // 17d: astore 5
      // 17f: goto 168
      // try (7 -> 17): 17 null
      // try (18 -> 20): 17 null
      // try (22 -> 32): 17 null
      // try (32 -> 42): 17 null
      // try (42 -> 45): 17 null
      // try (47 -> 52): 17 null
      // try (54 -> 71): 17 null
      // try (72 -> 77): 17 null
      // try (90 -> 100): 100 null
      // try (101 -> 103): 100 null
      // try (105 -> 122): 100 null
      // try (123 -> 141): 100 null
      // try (157 -> 176): 181 null
      // try (176 -> 178): 181 null
      // try (182 -> 184): 181 null
   }

   private RealConnection a(int param1, int param2, int param3, boolean param4, boolean param5) throws IOException {
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
      // 01: iload 1
      // 02: iload 2
      // 03: iload 3
      // 04: iload 4
      // 06: invokespecial okhttp3/internal/connection/StreamAllocation.a (IIIZ)Lokhttp3/internal/connection/RealConnection;
      // 09: astore 7
      // 0b: aload 0
      // 0c: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 0f: astore 6
      // 11: aload 6
      // 13: monitorenter
      // 14: aload 7
      // 16: getfield okhttp3/internal/connection/RealConnection.b I
      // 19: ifne 22
      // 1c: aload 6
      // 1e: monitorexit
      // 1f: aload 7
      // 21: areturn
      // 22: aload 6
      // 24: monitorexit
      // 25: aload 7
      // 27: iload 5
      // 29: invokevirtual okhttp3/internal/connection/RealConnection.a (Z)Z
      // 2c: ifne 1f
      // 2f: aload 0
      // 30: invokevirtual okhttp3/internal/connection/StreamAllocation.d ()V
      // 33: goto 00
      // 36: astore 7
      // 38: aload 6
      // 3a: monitorexit
      // 3b: aload 7
      // 3d: athrow
      // try (12 -> 17): 28 null
      // try (19 -> 21): 28 null
      // try (29 -> 31): 28 null
   }

   private void c(RealConnection var1) {
      int var3 = var1.d.size();

      for (int var2 = 0; var2 < var3; var2++) {
         if (var1.d.get(var2).get() == this) {
            var1.d.remove(var2);
            return;
         }
      }

      throw new IllegalStateException();
   }

   private RouteDatabase g() {
      return Internal.a.a(this.d);
   }

   public HttpCodec a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 0b: astore 2
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: aload 2
      // 0f: areturn
      // 10: astore 2
      // 11: aload 1
      // 12: monitorexit
      // 13: aload 2
      // 14: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   public HttpCodec a(OkHttpClient param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokevirtual okhttp3/OkHttpClient.a ()I
      // 04: istore 4
      // 06: aload 1
      // 07: invokevirtual okhttp3/OkHttpClient.b ()I
      // 0a: istore 5
      // 0c: aload 1
      // 0d: invokevirtual okhttp3/OkHttpClient.c ()I
      // 10: istore 3
      // 11: aload 1
      // 12: invokevirtual okhttp3/OkHttpClient.r ()Z
      // 15: istore 6
      // 17: aload 0
      // 18: iload 4
      // 1a: iload 5
      // 1c: iload 3
      // 1d: iload 6
      // 1f: iload 2
      // 20: invokespecial okhttp3/internal/connection/StreamAllocation.a (IIIZZ)Lokhttp3/internal/connection/RealConnection;
      // 23: aload 1
      // 24: aload 0
      // 25: invokevirtual okhttp3/internal/connection/RealConnection.a (Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/http/HttpCodec;
      // 28: astore 7
      // 2a: aload 0
      // 2b: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 2e: astore 1
      // 2f: aload 1
      // 30: monitorenter
      // 31: aload 0
      // 32: aload 7
      // 34: putfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 37: aload 1
      // 38: monitorexit
      // 39: aload 7
      // 3b: areturn
      // 3c: astore 7
      // 3e: aload 1
      // 3f: monitorexit
      // 40: aload 7
      // 42: athrow
      // 43: astore 1
      // 44: new okhttp3/internal/connection/RouteException
      // 47: dup
      // 48: aload 1
      // 49: invokespecial okhttp3/internal/connection/RouteException.<init> (Ljava/io/IOException;)V
      // 4c: athrow
      // try (12 -> 28): 40 java/io/IOException
      // try (28 -> 33): 35 null
      // try (36 -> 38): 35 null
      // try (38 -> 40): 40 java/io/IOException
   }

   public void a(IOException param1) {
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
      // 01: istore 3
      // 02: aload 0
      // 03: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 06: astore 4
      // 08: aload 4
      // 0a: monitorenter
      // 0b: aload 1
      // 0c: instanceof okhttp3/internal/http2/StreamResetException
      // 0f: ifeq 56
      // 12: aload 1
      // 13: checkcast okhttp3/internal/http2/StreamResetException
      // 16: astore 1
      // 17: aload 1
      // 18: getfield okhttp3/internal/http2/StreamResetException.a Lokhttp3/internal/http2/ErrorCode;
      // 1b: getstatic okhttp3/internal/http2/ErrorCode.REFUSED_STREAM Lokhttp3/internal/http2/ErrorCode;
      // 1e: if_acmpne 2b
      // 21: aload 0
      // 22: aload 0
      // 23: getfield okhttp3/internal/connection/StreamAllocation.g I
      // 26: bipush 1
      // 27: iadd
      // 28: putfield okhttp3/internal/connection/StreamAllocation.g I
      // 2b: aload 1
      // 2c: getfield okhttp3/internal/http2/StreamResetException.a Lokhttp3/internal/http2/ErrorCode;
      // 2f: getstatic okhttp3/internal/http2/ErrorCode.REFUSED_STREAM Lokhttp3/internal/http2/ErrorCode;
      // 32: if_acmpne 3f
      // 35: iload 3
      // 36: istore 2
      // 37: aload 0
      // 38: getfield okhttp3/internal/connection/StreamAllocation.g I
      // 3b: bipush 1
      // 3c: if_icmple 46
      // 3f: aload 0
      // 40: aconst_null
      // 41: putfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 44: bipush 1
      // 45: istore 2
      // 46: aload 0
      // 47: iload 2
      // 48: bipush 0
      // 49: bipush 1
      // 4a: invokespecial okhttp3/internal/connection/StreamAllocation.a (ZZZ)Ljava/net/Socket;
      // 4d: astore 1
      // 4e: aload 4
      // 50: monitorexit
      // 51: aload 1
      // 52: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 55: return
      // 56: iload 3
      // 57: istore 2
      // 58: aload 0
      // 59: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 5c: ifnull 46
      // 5f: aload 0
      // 60: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 63: invokevirtual okhttp3/internal/connection/RealConnection.f ()Z
      // 66: ifeq 72
      // 69: iload 3
      // 6a: istore 2
      // 6b: aload 1
      // 6c: instanceof okhttp3/internal/http2/ConnectionShutdownException
      // 6f: ifeq 46
      // 72: aload 0
      // 73: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 76: getfield okhttp3/internal/connection/RealConnection.b I
      // 79: ifne 44
      // 7c: aload 0
      // 7d: getfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 80: ifnull 93
      // 83: aload 1
      // 84: ifnull 93
      // 87: aload 0
      // 88: getfield okhttp3/internal/connection/StreamAllocation.f Lokhttp3/internal/connection/RouteSelector;
      // 8b: aload 0
      // 8c: getfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 8f: aload 1
      // 90: invokevirtual okhttp3/internal/connection/RouteSelector.a (Lokhttp3/Route;Ljava/io/IOException;)V
      // 93: aload 0
      // 94: aconst_null
      // 95: putfield okhttp3/internal/connection/StreamAllocation.c Lokhttp3/Route;
      // 98: goto 44
      // 9b: astore 1
      // 9c: aload 4
      // 9e: monitorexit
      // 9f: aload 1
      // a0: athrow
      // try (7 -> 23): 82 null
      // try (23 -> 27): 82 null
      // try (29 -> 33): 82 null
      // try (33 -> 36): 82 null
      // try (38 -> 46): 82 null
      // try (51 -> 58): 82 null
      // try (60 -> 63): 82 null
      // try (63 -> 70): 82 null
      // try (72 -> 78): 82 null
      // try (78 -> 81): 82 null
      // try (83 -> 85): 82 null
   }

   public void a(RealConnection var1) {
      if (!b && !Thread.holdsLock(this.d)) {
         throw new AssertionError();
      }

      if (this.h != null) {
         throw new IllegalStateException();
      }

      this.h = var1;
      var1.d.add(new StreamAllocation.StreamAllocationReference(this, this.e));
   }

   public void a(boolean param1, HttpCodec param2) {
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
      // 01: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 2
      // 08: ifnull 13
      // 0b: aload 2
      // 0c: aload 0
      // 0d: getfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 10: if_acmpeq 4a
      // 13: new java/lang/IllegalStateException
      // 16: astore 4
      // 18: new java/lang/StringBuilder
      // 1b: astore 5
      // 1d: aload 5
      // 1f: invokespecial java/lang/StringBuilder.<init> ()V
      // 22: aload 4
      // 24: aload 5
      // 26: ldc "expected "
      // 28: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2b: aload 0
      // 2c: getfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 2f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 32: ldc_w " but was "
      // 35: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 38: aload 2
      // 39: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 3c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 42: aload 4
      // 44: athrow
      // 45: astore 2
      // 46: aload 3
      // 47: monitorexit
      // 48: aload 2
      // 49: athrow
      // 4a: iload 1
      // 4b: ifne 5d
      // 4e: aload 0
      // 4f: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 52: astore 2
      // 53: aload 2
      // 54: aload 2
      // 55: getfield okhttp3/internal/connection/RealConnection.b I
      // 58: bipush 1
      // 59: iadd
      // 5a: putfield okhttp3/internal/connection/RealConnection.b I
      // 5d: aload 0
      // 5e: iload 1
      // 5f: bipush 0
      // 60: bipush 1
      // 61: invokespecial okhttp3/internal/connection/StreamAllocation.a (ZZZ)Ljava/net/Socket;
      // 64: astore 2
      // 65: aload 3
      // 66: monitorexit
      // 67: aload 2
      // 68: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 6b: return
      // try (7 -> 11): 32 null
      // try (11 -> 32): 32 null
      // try (33 -> 35): 32 null
      // try (39 -> 48): 32 null
      // try (48 -> 56): 32 null
   }

   public Socket b(RealConnection var1) {
      if (!b && !Thread.holdsLock(this.d)) {
         throw new AssertionError();
      } else if (this.k == null && this.h.d.size() == 1) {
         Reference var3 = this.h.d.get(0);
         Socket var2 = this.a(true, false, false);
         this.h = var1;
         var1.d.add(var3);
         return var2;
      } else {
         throw new IllegalStateException();
      }
   }

   public RealConnection b() {
      synchronized (this) {
         return this.h;
      }
   }

   public void c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: bipush 0
      // 09: bipush 1
      // 0a: bipush 0
      // 0b: invokespecial okhttp3/internal/connection/StreamAllocation.a (ZZZ)Ljava/net/Socket;
      // 0e: astore 2
      // 0f: aload 1
      // 10: monitorexit
      // 11: aload 2
      // 12: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 15: return
      // 16: astore 2
      // 17: aload 1
      // 18: monitorexit
      // 19: aload 2
      // 1a: athrow
      // try (5 -> 13): 16 null
      // try (17 -> 19): 16 null
   }

   public void d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: bipush 1
      // 09: bipush 0
      // 0a: bipush 0
      // 0b: invokespecial okhttp3/internal/connection/StreamAllocation.a (ZZZ)Ljava/net/Socket;
      // 0e: astore 2
      // 0f: aload 1
      // 10: monitorexit
      // 11: aload 2
      // 12: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 15: return
      // 16: astore 2
      // 17: aload 1
      // 18: monitorexit
      // 19: aload 2
      // 1a: athrow
      // try (5 -> 13): 16 null
      // try (17 -> 19): 16 null
   }

   public void e() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield okhttp3/internal/connection/StreamAllocation.d Lokhttp3/ConnectionPool;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: bipush 1
      // 09: putfield okhttp3/internal/connection/StreamAllocation.j Z
      // 0c: aload 0
      // 0d: getfield okhttp3/internal/connection/StreamAllocation.k Lokhttp3/internal/http/HttpCodec;
      // 10: astore 3
      // 11: aload 0
      // 12: getfield okhttp3/internal/connection/StreamAllocation.h Lokhttp3/internal/connection/RealConnection;
      // 15: astore 2
      // 16: aload 1
      // 17: monitorexit
      // 18: aload 3
      // 19: ifnull 28
      // 1c: aload 3
      // 1d: invokeinterface okhttp3/internal/http/HttpCodec.c ()V 1
      // 22: return
      // 23: astore 2
      // 24: aload 1
      // 25: monitorexit
      // 26: aload 2
      // 27: athrow
      // 28: aload 2
      // 29: ifnull 22
      // 2c: aload 2
      // 2d: invokevirtual okhttp3/internal/connection/RealConnection.c ()V
      // 30: goto 22
      // try (5 -> 16): 21 null
      // try (22 -> 24): 21 null
   }

   public boolean f() {
      boolean var1;
      if (this.c == null && !this.f.a()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public String toString() {
      RealConnection var1 = this.b();
      String var2;
      if (var1 != null) {
         var2 = var1.toString();
      } else {
         var2 = this.a.toString();
      }

      return var2;
   }

   public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
      public final Object a;

      StreamAllocationReference(StreamAllocation var1, Object var2) {
         super(var1);
         this.a = var2;
      }
   }
}
