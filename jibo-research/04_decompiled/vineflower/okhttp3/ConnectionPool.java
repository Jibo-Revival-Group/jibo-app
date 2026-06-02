package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {
   static final boolean c;
   private static final Executor d;
   final RouteDatabase a;
   boolean b;
   private final int e;
   private final long f;
   private final Runnable g = new Runnable(this) {
      final ConnectionPool a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
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
         // 01: getfield okhttp3/ConnectionPool$1.a Lokhttp3/ConnectionPool;
         // 04: invokestatic java/lang/System.nanoTime ()J
         // 07: invokevirtual okhttp3/ConnectionPool.a (J)J
         // 0a: lstore 1
         // 0b: lload 1
         // 0c: ldc2_w -1
         // 0f: lcmp
         // 10: ifne 14
         // 13: return
         // 14: lload 1
         // 15: lconst_0
         // 16: lcmp
         // 17: ifle 00
         // 1a: lload 1
         // 1b: ldc2_w 1000000
         // 1e: ldiv
         // 1f: lstore 3
         // 20: aload 0
         // 21: getfield okhttp3/ConnectionPool$1.a Lokhttp3/ConnectionPool;
         // 24: astore 5
         // 26: aload 5
         // 28: monitorenter
         // 29: aload 0
         // 2a: getfield okhttp3/ConnectionPool$1.a Lokhttp3/ConnectionPool;
         // 2d: lload 3
         // 2e: lload 1
         // 2f: lload 3
         // 30: ldc2_w 1000000
         // 33: lmul
         // 34: lsub
         // 35: l2i
         // 36: invokevirtual java/lang/Object.wait (JI)V
         // 39: aload 5
         // 3b: monitorexit
         // 3c: goto 00
         // 3f: astore 6
         // 41: aload 5
         // 43: monitorexit
         // 44: aload 6
         // 46: athrow
         // 47: astore 6
         // 49: goto 39
         // try (23 -> 33): 41 java/lang/InterruptedException
         // try (23 -> 33): 36 null
         // try (33 -> 35): 36 null
         // try (37 -> 39): 36 null
      }
   };
   private final Deque<RealConnection> h = new ArrayDeque<>();

   static {
      boolean var0;
      if (!ConnectionPool.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      c = var0;
      d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), Util.a("OkHttp ConnectionPool", true));
   }

   public ConnectionPool() {
      this(5, 5L, TimeUnit.MINUTES);
   }

   public ConnectionPool(int var1, long var2, TimeUnit var4) {
      this.a = new RouteDatabase();
      this.e = var1;
      this.f = var4.toNanos(var2);
      if (var2 <= 0L) {
         throw new IllegalArgumentException("keepAliveDuration <= 0: " + var2);
      }
   }

   private int a(RealConnection var1, long var2) {
      byte var5 = 0;
      List var6 = var1.d;
      int var4 = 0;

      while (true) {
         if (var4 < var6.size()) {
            Reference var7 = (Reference)var6.get(var4);
            if (var7.get() != null) {
               var4++;
               continue;
            }

            StreamAllocation.StreamAllocationReference var8 = (StreamAllocation.StreamAllocationReference)var7;
            String var10 = "A connection to " + var1.a().a().a() + " was leaked. Did you forget to close a response body?";
            Platform.b().a(var10, var8.a);
            var6.remove(var4);
            var1.a = true;
            if (!var6.isEmpty()) {
               continue;
            }

            var1.e = var2 - this.f;
            var4 = var5;
            break;
         }

         var4 = var6.size();
         break;
      }

      return var4;
   }

   long a(long param1) {
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
      // 00: aconst_null
      // 01: astore 9
      // 03: ldc2_w -9223372036854775808
      // 06: lstore 5
      // 08: aload 0
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield okhttp3/ConnectionPool.h Ljava/util/Deque;
      // 0e: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 13: astore 11
      // 15: bipush 0
      // 16: istore 4
      // 18: bipush 0
      // 19: istore 3
      // 1a: aload 11
      // 1c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 21: ifeq 5f
      // 24: aload 11
      // 26: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2b: checkcast okhttp3/internal/connection/RealConnection
      // 2e: astore 10
      // 30: aload 0
      // 31: aload 10
      // 33: lload 1
      // 34: invokespecial okhttp3/ConnectionPool.a (Lokhttp3/internal/connection/RealConnection;J)I
      // 37: ifle 40
      // 3a: iinc 3 1
      // 3d: goto 1a
      // 40: lload 1
      // 41: aload 10
      // 43: getfield okhttp3/internal/connection/RealConnection.e J
      // 46: lsub
      // 47: lstore 7
      // 49: lload 7
      // 4b: lload 5
      // 4d: lcmp
      // 4e: ifle c1
      // 51: aload 10
      // 53: astore 9
      // 55: lload 7
      // 57: lstore 5
      // 59: iinc 4 1
      // 5c: goto 1a
      // 5f: lload 5
      // 61: aload 0
      // 62: getfield okhttp3/ConnectionPool.f J
      // 65: lcmp
      // 66: ifge 72
      // 69: iload 4
      // 6b: aload 0
      // 6c: getfield okhttp3/ConnectionPool.e I
      // 6f: if_icmple 8c
      // 72: aload 0
      // 73: getfield okhttp3/ConnectionPool.h Ljava/util/Deque;
      // 76: aload 9
      // 78: invokeinterface java/util/Deque.remove (Ljava/lang/Object;)Z 2
      // 7d: pop
      // 7e: aload 0
      // 7f: monitorexit
      // 80: aload 9
      // 82: invokevirtual okhttp3/internal/connection/RealConnection.d ()Ljava/net/Socket;
      // 85: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 88: lconst_0
      // 89: lstore 1
      // 8a: lload 1
      // 8b: lreturn
      // 8c: iload 4
      // 8e: ifle a5
      // 91: aload 0
      // 92: getfield okhttp3/ConnectionPool.f J
      // 95: lload 5
      // 97: lsub
      // 98: lstore 1
      // 99: aload 0
      // 9a: monitorexit
      // 9b: goto 8a
      // 9e: astore 9
      // a0: aload 0
      // a1: monitorexit
      // a2: aload 9
      // a4: athrow
      // a5: iload 3
      // a6: ifle b3
      // a9: aload 0
      // aa: getfield okhttp3/ConnectionPool.f J
      // ad: lstore 1
      // ae: aload 0
      // af: monitorexit
      // b0: goto 8a
      // b3: aload 0
      // b4: bipush 0
      // b5: putfield okhttp3/ConnectionPool.b Z
      // b8: ldc2_w -1
      // bb: lstore 1
      // bc: aload 0
      // bd: monitorexit
      // be: goto 8a
      // c1: goto 59
      // try (6 -> 10): 76 null
      // try (14 -> 26): 76 null
      // try (28 -> 33): 76 null
      // try (43 -> 52): 76 null
      // try (52 -> 59): 76 null
      // try (68 -> 75): 76 null
      // try (77 -> 79): 76 null
      // try (83 -> 88): 76 null
      // try (89 -> 92): 76 null
      // try (94 -> 96): 76 null
   }

   Socket a(Address var1, StreamAllocation var2) {
      if (!c && !Thread.holdsLock(this)) {
         throw new AssertionError();
      }

      Iterator var4 = this.h.iterator();

      while (true) {
         if (var4.hasNext()) {
            RealConnection var3 = (RealConnection)var4.next();
            if (!var3.a(var1, null) || !var3.f() || var3 == var2.b()) {
               continue;
            }

            var5 = var2.b(var3);
            break;
         }

         var5 = null;
         break;
      }

      return var5;
   }

   RealConnection a(Address var1, StreamAllocation var2, Route var3) {
      if (!c && !Thread.holdsLock(this)) {
         throw new AssertionError();
      }

      Iterator var5 = this.h.iterator();

      while (true) {
         if (var5.hasNext()) {
            RealConnection var4 = (RealConnection)var5.next();
            if (!var4.a(var1, var3)) {
               continue;
            }

            var2.a(var4);
            var6 = var4;
            break;
         }

         var6 = null;
         break;
      }

      return var6;
   }

   void a(RealConnection var1) {
      if (!c && !Thread.holdsLock(this)) {
         throw new AssertionError();
      }

      if (!this.b) {
         this.b = true;
         d.execute(this.g);
      }

      this.h.add(var1);
   }

   boolean b(RealConnection var1) {
      if (!c && !Thread.holdsLock(this)) {
         throw new AssertionError();
      }

      boolean var2;
      if (!var1.a && this.e != 0) {
         this.notifyAll();
         var2 = false;
      } else {
         this.h.remove(var1);
         var2 = true;
      }

      return var2;
   }
}
