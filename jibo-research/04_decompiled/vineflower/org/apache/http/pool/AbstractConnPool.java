package org.apache.http.pool;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
   private final LinkedList<E> available;
   private final ConnFactory<T, C> connFactory;
   private volatile int defaultMaxPerRoute;
   private volatile boolean isShutDown;
   private final Set<E> leased;
   private final Lock lock;
   private final Map<T, Integer> maxPerRoute;
   private volatile int maxTotal;
   private final LinkedList<PoolEntryFuture<E>> pending;
   private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
   private volatile int validateAfterInactivity;

   public AbstractConnPool(ConnFactory<T, C> var1, int var2, int var3) {
      this.connFactory = Args.notNull(var1, "Connection factory");
      this.defaultMaxPerRoute = Args.positive(var2, "Max per route value");
      this.maxTotal = Args.positive(var3, "Max total value");
      this.lock = new ReentrantLock();
      this.routeToPool = new HashMap<>();
      this.leased = new HashSet<>();
      this.available = new LinkedList<>();
      this.pending = new LinkedList<>();
      this.maxPerRoute = new HashMap<>();
   }

   private int getMax(T var1) {
      var1 = this.maxPerRoute.get(var1);
      int var2;
      if (var1 != null) {
         var2 = var1;
      } else {
         var2 = this.defaultMaxPerRoute;
      }

      return var2;
   }

   private RouteSpecificPool<T, C, E> getPool(T var1) {
      RouteSpecificPool var3 = this.routeToPool.get(var1);
      RouteSpecificPool var2 = var3;
      if (var3 == null) {
         var2 = new RouteSpecificPool<T, C, E>(this, var1, var1) {
            final AbstractConnPool this$0;
            final Object val$route;

            {
               this.this$0 = var1;
               this.val$route = var3x;
            }

            @Override
            protected E createEntry(C var1) {
               return (E)this.this$0.createEntry(this.val$route, var1);
            }
         };
         this.routeToPool.put((T)var1, var2);
      }

      return var2;
   }

   private E getPoolEntryBlocking(T param1, Object param2, long param3, TimeUnit param5, PoolEntryFuture<E> param6) throws IOException, InterruptedException, TimeoutException {
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
      // 000: aconst_null
      // 001: astore 11
      // 003: lload 3
      // 004: lconst_0
      // 005: lcmp
      // 006: ifle 01c
      // 009: new java/util/Date
      // 00c: dup
      // 00d: invokestatic java/lang/System.currentTimeMillis ()J
      // 010: aload 5
      // 012: lload 3
      // 013: invokevirtual java/util/concurrent/TimeUnit.toMillis (J)J
      // 016: ladd
      // 017: invokespecial java/util/Date.<init> (J)V
      // 01a: astore 11
      // 01c: aload 0
      // 01d: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 020: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 025: aload 0
      // 026: aload 1
      // 027: invokespecial org/apache/http/pool/AbstractConnPool.getPool (Ljava/lang/Object;)Lorg/apache/http/pool/RouteSpecificPool;
      // 02a: astore 13
      // 02c: aconst_null
      // 02d: astore 12
      // 02f: aload 12
      // 031: ifnonnull 208
      // 034: aload 0
      // 035: getfield org/apache/http/pool/AbstractConnPool.isShutDown Z
      // 038: ifne 07f
      // 03b: bipush 1
      // 03c: istore 10
      // 03e: iload 10
      // 040: ldc "Connection pool shut down"
      // 042: invokestatic org/apache/http/util/Asserts.check (ZLjava/lang/String;)V
      // 045: aload 13
      // 047: aload 2
      // 048: invokevirtual org/apache/http/pool/RouteSpecificPool.getFree (Ljava/lang/Object;)Lorg/apache/http/pool/PoolEntry;
      // 04b: astore 5
      // 04d: aload 5
      // 04f: ifnonnull 085
      // 052: aload 5
      // 054: ifnull 0e8
      // 057: aload 0
      // 058: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 05b: aload 5
      // 05d: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 060: pop
      // 061: aload 0
      // 062: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 065: aload 5
      // 067: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 06c: pop
      // 06d: aload 0
      // 06e: aload 5
      // 070: invokevirtual org/apache/http/pool/AbstractConnPool.onReuse (Lorg/apache/http/pool/PoolEntry;)V
      // 073: aload 0
      // 074: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 077: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 07c: aload 5
      // 07e: areturn
      // 07f: bipush 0
      // 080: istore 10
      // 082: goto 03e
      // 085: aload 5
      // 087: invokestatic java/lang/System.currentTimeMillis ()J
      // 08a: invokevirtual org/apache/http/pool/PoolEntry.isExpired (J)Z
      // 08d: ifeq 0be
      // 090: aload 5
      // 092: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 095: aload 5
      // 097: invokevirtual org/apache/http/pool/PoolEntry.isClosed ()Z
      // 09a: ifeq 052
      // 09d: aload 0
      // 09e: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 0a1: aload 5
      // 0a3: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 0a6: pop
      // 0a7: aload 13
      // 0a9: aload 5
      // 0ab: bipush 0
      // 0ac: invokevirtual org/apache/http/pool/RouteSpecificPool.free (Lorg/apache/http/pool/PoolEntry;Z)V
      // 0af: goto 045
      // 0b2: astore 1
      // 0b3: aload 0
      // 0b4: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 0b7: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 0bc: aload 1
      // 0bd: athrow
      // 0be: aload 0
      // 0bf: getfield org/apache/http/pool/AbstractConnPool.validateAfterInactivity I
      // 0c2: ifle 095
      // 0c5: aload 5
      // 0c7: invokevirtual org/apache/http/pool/PoolEntry.getUpdated ()J
      // 0ca: aload 0
      // 0cb: getfield org/apache/http/pool/AbstractConnPool.validateAfterInactivity I
      // 0ce: i2l
      // 0cf: ladd
      // 0d0: invokestatic java/lang/System.currentTimeMillis ()J
      // 0d3: lcmp
      // 0d4: ifgt 095
      // 0d7: aload 0
      // 0d8: aload 5
      // 0da: invokevirtual org/apache/http/pool/AbstractConnPool.validate (Lorg/apache/http/pool/PoolEntry;)Z
      // 0dd: ifne 095
      // 0e0: aload 5
      // 0e2: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 0e5: goto 095
      // 0e8: aload 0
      // 0e9: aload 1
      // 0ea: invokespecial org/apache/http/pool/AbstractConnPool.getMax (Ljava/lang/Object;)I
      // 0ed: istore 9
      // 0ef: bipush 0
      // 0f0: aload 13
      // 0f2: invokevirtual org/apache/http/pool/RouteSpecificPool.getAllocatedCount ()I
      // 0f5: bipush 1
      // 0f6: iadd
      // 0f7: iload 9
      // 0f9: isub
      // 0fa: invokestatic java/lang/Math.max (II)I
      // 0fd: istore 8
      // 0ff: iload 8
      // 101: ifle 11a
      // 104: bipush 0
      // 105: istore 7
      // 107: iload 7
      // 109: iload 8
      // 10b: if_icmpge 11a
      // 10e: aload 13
      // 110: invokevirtual org/apache/http/pool/RouteSpecificPool.getLastUsed ()Lorg/apache/http/pool/PoolEntry;
      // 113: astore 12
      // 115: aload 12
      // 117: ifnonnull 19e
      // 11a: aload 13
      // 11c: invokevirtual org/apache/http/pool/RouteSpecificPool.getAllocatedCount ()I
      // 11f: iload 9
      // 121: if_icmpge 1bb
      // 124: aload 0
      // 125: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 128: invokeinterface java/util/Set.size ()I 1
      // 12d: istore 7
      // 12f: aload 0
      // 130: getfield org/apache/http/pool/AbstractConnPool.maxTotal I
      // 133: iload 7
      // 135: isub
      // 136: bipush 0
      // 137: invokestatic java/lang/Math.max (II)I
      // 13a: istore 7
      // 13c: iload 7
      // 13e: ifle 1bb
      // 141: aload 0
      // 142: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 145: invokevirtual java/util/LinkedList.size ()I
      // 148: iload 7
      // 14a: bipush 1
      // 14b: isub
      // 14c: if_icmple 175
      // 14f: aload 0
      // 150: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 153: invokevirtual java/util/LinkedList.isEmpty ()Z
      // 156: ifne 175
      // 159: aload 0
      // 15a: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 15d: invokevirtual java/util/LinkedList.removeLast ()Ljava/lang/Object;
      // 160: checkcast org/apache/http/pool/PoolEntry
      // 163: astore 2
      // 164: aload 2
      // 165: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 168: aload 0
      // 169: aload 2
      // 16a: invokevirtual org/apache/http/pool/PoolEntry.getRoute ()Ljava/lang/Object;
      // 16d: invokespecial org/apache/http/pool/AbstractConnPool.getPool (Ljava/lang/Object;)Lorg/apache/http/pool/RouteSpecificPool;
      // 170: aload 2
      // 171: invokevirtual org/apache/http/pool/RouteSpecificPool.remove (Lorg/apache/http/pool/PoolEntry;)Z
      // 174: pop
      // 175: aload 13
      // 177: aload 0
      // 178: getfield org/apache/http/pool/AbstractConnPool.connFactory Lorg/apache/http/pool/ConnFactory;
      // 17b: aload 1
      // 17c: invokeinterface org/apache/http/pool/ConnFactory.create (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 181: invokevirtual org/apache/http/pool/RouteSpecificPool.add (Ljava/lang/Object;)Lorg/apache/http/pool/PoolEntry;
      // 184: astore 5
      // 186: aload 0
      // 187: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 18a: aload 5
      // 18c: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 191: pop
      // 192: aload 0
      // 193: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 196: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 19b: goto 07c
      // 19e: aload 12
      // 1a0: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 1a3: aload 0
      // 1a4: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 1a7: aload 12
      // 1a9: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 1ac: pop
      // 1ad: aload 13
      // 1af: aload 12
      // 1b1: invokevirtual org/apache/http/pool/RouteSpecificPool.remove (Lorg/apache/http/pool/PoolEntry;)Z
      // 1b4: pop
      // 1b5: iinc 7 1
      // 1b8: goto 107
      // 1bb: aload 13
      // 1bd: aload 6
      // 1bf: invokevirtual org/apache/http/pool/RouteSpecificPool.queue (Lorg/apache/http/pool/PoolEntryFuture;)V
      // 1c2: aload 0
      // 1c3: getfield org/apache/http/pool/AbstractConnPool.pending Ljava/util/LinkedList;
      // 1c6: aload 6
      // 1c8: invokevirtual java/util/LinkedList.add (Ljava/lang/Object;)Z
      // 1cb: pop
      // 1cc: aload 6
      // 1ce: aload 11
      // 1d0: invokevirtual org/apache/http/pool/PoolEntryFuture.await (Ljava/util/Date;)Z
      // 1d3: istore 10
      // 1d5: aload 13
      // 1d7: aload 6
      // 1d9: invokevirtual org/apache/http/pool/RouteSpecificPool.unqueue (Lorg/apache/http/pool/PoolEntryFuture;)V
      // 1dc: aload 0
      // 1dd: getfield org/apache/http/pool/AbstractConnPool.pending Ljava/util/LinkedList;
      // 1e0: aload 6
      // 1e2: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 1e5: pop
      // 1e6: aload 5
      // 1e8: astore 12
      // 1ea: iload 10
      // 1ec: ifne 02f
      // 1ef: aload 5
      // 1f1: astore 12
      // 1f3: aload 11
      // 1f5: ifnull 02f
      // 1f8: aload 5
      // 1fa: astore 12
      // 1fc: aload 11
      // 1fe: invokevirtual java/util/Date.getTime ()J
      // 201: invokestatic java/lang/System.currentTimeMillis ()J
      // 204: lcmp
      // 205: ifgt 02f
      // 208: new java/util/concurrent/TimeoutException
      // 20b: astore 1
      // 20c: aload 1
      // 20d: ldc_w "Timeout waiting for connection"
      // 210: invokespecial java/util/concurrent/TimeoutException.<init> (Ljava/lang/String;)V
      // 213: aload 1
      // 214: athrow
      // 215: astore 1
      // 216: aload 13
      // 218: aload 6
      // 21a: invokevirtual org/apache/http/pool/RouteSpecificPool.unqueue (Lorg/apache/http/pool/PoolEntryFuture;)V
      // 21d: aload 0
      // 21e: getfield org/apache/http/pool/AbstractConnPool.pending Ljava/util/LinkedList;
      // 221: aload 6
      // 223: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 226: pop
      // 227: aload 1
      // 228: athrow
      // try (18 -> 22): 82 null
      // try (26 -> 29): 82 null
      // try (31 -> 34): 82 null
      // try (34 -> 38): 82 null
      // try (42 -> 55): 82 null
      // try (63 -> 69): 82 null
      // try (69 -> 81): 82 null
      // try (88 -> 106): 82 null
      // try (107 -> 120): 82 null
      // try (127 -> 130): 82 null
      // try (132 -> 147): 82 null
      // try (149 -> 174): 82 null
      // try (174 -> 186): 82 null
      // try (190 -> 201): 82 null
      // try (203 -> 215): 245 null
      // try (215 -> 223): 82 null
      // try (233 -> 238): 82 null
      // try (238 -> 245): 82 null
      // try (246 -> 256): 82 null
   }

   private void purgePoolMap() {
      Iterator var2 = this.routeToPool.entrySet().iterator();

      while (var2.hasNext()) {
         RouteSpecificPool var3 = (RouteSpecificPool)((Entry)var2.next()).getValue();
         int var1 = var3.getPendingCount();
         if (var3.getAllocatedCount() + var1 == 0) {
            var2.remove();
         }
      }
   }

   public void closeExpired() {
      this.enumAvailable(new PoolEntryCallback<T, C>(this, System.currentTimeMillis()) {
         final AbstractConnPool this$0;
         final long val$now;

         {
            this.this$0 = var1;
            this.val$now = var2;
         }

         @Override
         public void process(PoolEntry<T, C> var1) {
            if (var1.isExpired(this.val$now)) {
               var1.close();
            }
         }
      });
   }

   public void closeIdle(long var1, TimeUnit var3) {
      long var4 = 0L;
      Args.notNull(var3, "Time unit");
      var1 = var3.toMillis(var1);
      if (var1 < 0L) {
         var1 = var4;
      }

      this.enumAvailable(new PoolEntryCallback<T, C>(this, System.currentTimeMillis() - var1) {
         final AbstractConnPool this$0;
         final long val$deadline;

         {
            this.this$0 = var1;
            this.val$deadline = var2;
         }

         @Override
         public void process(PoolEntry<T, C> var1) {
            if (var1.getUpdated() <= this.val$deadline) {
               var1.close();
            }
         }
      });
   }

   protected abstract E createEntry(T var1, C var2);

   protected void enumAvailable(PoolEntryCallback<T, C> param1) {
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
      // 01: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 0d: invokevirtual java/util/LinkedList.iterator ()Ljava/util/Iterator;
      // 10: astore 2
      // 11: aload 2
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 54
      // 1a: aload 2
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast org/apache/http/pool/PoolEntry
      // 23: astore 3
      // 24: aload 1
      // 25: aload 3
      // 26: invokeinterface org/apache/http/pool/PoolEntryCallback.process (Lorg/apache/http/pool/PoolEntry;)V 2
      // 2b: aload 3
      // 2c: invokevirtual org/apache/http/pool/PoolEntry.isClosed ()Z
      // 2f: ifeq 11
      // 32: aload 0
      // 33: aload 3
      // 34: invokevirtual org/apache/http/pool/PoolEntry.getRoute ()Ljava/lang/Object;
      // 37: invokespecial org/apache/http/pool/AbstractConnPool.getPool (Ljava/lang/Object;)Lorg/apache/http/pool/RouteSpecificPool;
      // 3a: aload 3
      // 3b: invokevirtual org/apache/http/pool/RouteSpecificPool.remove (Lorg/apache/http/pool/PoolEntry;)Z
      // 3e: pop
      // 3f: aload 2
      // 40: invokeinterface java/util/Iterator.remove ()V 1
      // 45: goto 11
      // 48: astore 1
      // 49: aload 0
      // 4a: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 4d: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 52: aload 1
      // 53: athrow
      // 54: aload 0
      // 55: invokespecial org/apache/http/pool/AbstractConnPool.purgePoolMap ()V
      // 58: aload 0
      // 59: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 5c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 61: return
      // try (3 -> 7): 30 null
      // try (7 -> 29): 30 null
      // try (36 -> 38): 30 null
   }

   protected void enumLeased(PoolEntryCallback<T, C> param1) {
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
      // 00: aload 0
      // 01: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 0d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 12: astore 2
      // 13: aload 2
      // 14: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 19: ifeq 3a
      // 1c: aload 1
      // 1d: aload 2
      // 1e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 23: checkcast org/apache/http/pool/PoolEntry
      // 26: invokeinterface org/apache/http/pool/PoolEntryCallback.process (Lorg/apache/http/pool/PoolEntry;)V 2
      // 2b: goto 13
      // 2e: astore 1
      // 2f: aload 0
      // 30: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 33: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 38: aload 1
      // 39: athrow
      // 3a: aload 0
      // 3b: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 3e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 43: return
      // try (3 -> 7): 16 null
      // try (7 -> 15): 16 null
   }

   @Override
   public int getDefaultMaxPerRoute() {
      this.lock.lock();

      try {
         return this.defaultMaxPerRoute;
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public int getMaxPerRoute(T var1) {
      Args.notNull(var1, "Route");
      this.lock.lock();

      try {
         return this.getMax((T)var1);
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public int getMaxTotal() {
      this.lock.lock();

      try {
         return this.maxTotal;
      } finally {
         this.lock.unlock();
      }
   }

   public Set<T> getRoutes() {
      this.lock.lock();

      try {
         return new HashSet<>(this.routeToPool.keySet());
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public PoolStats getStats(T var1) {
      Args.notNull(var1, "Route");
      this.lock.lock();

      try {
         RouteSpecificPool var2 = this.getPool((T)var1);
         return new PoolStats(var2.getLeasedCount(), var2.getPendingCount(), var2.getAvailableCount(), this.getMax((T)var1));
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public PoolStats getTotalStats() {
      this.lock.lock();

      try {
         return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      } finally {
         this.lock.unlock();
      }
   }

   public int getValidateAfterInactivity() {
      return this.validateAfterInactivity;
   }

   public boolean isShutdown() {
      return this.isShutDown;
   }

   public Future<E> lease(T var1, Object var2) {
      return this.lease((T)var1, var2, null);
   }

   @Override
   public Future<E> lease(T var1, Object var2, FutureCallback<E> var3) {
      Args.notNull(var1, "Route");
      boolean var4;
      if (!this.isShutDown) {
         var4 = true;
      } else {
         var4 = false;
      }

      Asserts.check(var4, "Connection pool shut down");
      return new PoolEntryFuture<E>(this, this.lock, var3, var1, var2) {
         final AbstractConnPool this$0;
         final Object val$route;
         final Object val$state;

         {
            this.this$0 = var1;
            this.val$route = var4x;
            this.val$state = var5;
         }

         public E getPoolEntry(long var1, TimeUnit var3x) throws InterruptedException, TimeoutException, IOException {
            PoolEntry var4x = this.this$0.getPoolEntryBlocking(this.val$route, this.val$state, var1, var3x, this);
            this.this$0.onLease((E)var4x);
            return (E)var4x;
         }
      };
   }

   protected void onLease(E var1) {
   }

   protected void onRelease(E var1) {
   }

   protected void onReuse(E var1) {
   }

   public void release(E param1, boolean param2) {
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
      // 01: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 0d: aload 1
      // 0e: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 13: ifeq 57
      // 16: aload 0
      // 17: aload 1
      // 18: invokevirtual org/apache/http/pool/PoolEntry.getRoute ()Ljava/lang/Object;
      // 1b: invokespecial org/apache/http/pool/AbstractConnPool.getPool (Ljava/lang/Object;)Lorg/apache/http/pool/RouteSpecificPool;
      // 1e: astore 3
      // 1f: aload 3
      // 20: aload 1
      // 21: iload 2
      // 22: invokevirtual org/apache/http/pool/RouteSpecificPool.free (Lorg/apache/http/pool/PoolEntry;Z)V
      // 25: iload 2
      // 26: ifeq 61
      // 29: aload 0
      // 2a: getfield org/apache/http/pool/AbstractConnPool.isShutDown Z
      // 2d: ifne 61
      // 30: aload 0
      // 31: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 34: aload 1
      // 35: invokevirtual java/util/LinkedList.addFirst (Ljava/lang/Object;)V
      // 38: aload 0
      // 39: aload 1
      // 3a: invokevirtual org/apache/http/pool/AbstractConnPool.onRelease (Lorg/apache/http/pool/PoolEntry;)V
      // 3d: aload 3
      // 3e: invokevirtual org/apache/http/pool/RouteSpecificPool.nextPending ()Lorg/apache/http/pool/PoolEntryFuture;
      // 41: astore 1
      // 42: aload 1
      // 43: ifnull 74
      // 46: aload 0
      // 47: getfield org/apache/http/pool/AbstractConnPool.pending Ljava/util/LinkedList;
      // 4a: aload 1
      // 4b: invokevirtual java/util/LinkedList.remove (Ljava/lang/Object;)Z
      // 4e: pop
      // 4f: aload 1
      // 50: ifnull 57
      // 53: aload 1
      // 54: invokevirtual org/apache/http/pool/PoolEntryFuture.wakeup ()V
      // 57: aload 0
      // 58: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 5b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 60: return
      // 61: aload 1
      // 62: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 65: goto 3d
      // 68: astore 1
      // 69: aload 0
      // 6a: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 6d: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 72: aload 1
      // 73: athrow
      // 74: aload 0
      // 75: getfield org/apache/http/pool/AbstractConnPool.pending Ljava/util/LinkedList;
      // 78: invokevirtual java/util/LinkedList.poll ()Ljava/lang/Object;
      // 7b: checkcast org/apache/http/pool/PoolEntryFuture
      // 7e: astore 1
      // 7f: goto 4f
      // try (3 -> 17): 50 null
      // try (19 -> 29): 50 null
      // try (29 -> 32): 50 null
      // try (34 -> 39): 50 null
      // try (41 -> 43): 50 null
      // try (47 -> 49): 50 null
      // try (56 -> 61): 50 null
   }

   @Override
   public void setDefaultMaxPerRoute(int var1) {
      Args.positive(var1, "Max per route value");
      this.lock.lock();

      try {
         this.defaultMaxPerRoute = var1;
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public void setMaxPerRoute(T var1, int var2) {
      Args.notNull(var1, "Route");
      Args.positive(var2, "Max per route value");
      this.lock.lock();

      try {
         this.maxPerRoute.put((T)var1, var2);
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public void setMaxTotal(int var1) {
      Args.positive(var1, "Max value");
      this.lock.lock();

      try {
         this.maxTotal = var1;
      } finally {
         this.lock.unlock();
      }
   }

   public void setValidateAfterInactivity(int var1) {
      this.validateAfterInactivity = var1;
   }

   public void shutdown() throws IOException {
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
      // 01: getfield org/apache/http/pool/AbstractConnPool.isShutDown Z
      // 04: ifeq 08
      // 07: return
      // 08: aload 0
      // 09: bipush 1
      // 0a: putfield org/apache/http/pool/AbstractConnPool.isShutDown Z
      // 0d: aload 0
      // 0e: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 11: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 16: aload 0
      // 17: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // 1a: invokevirtual java/util/LinkedList.iterator ()Ljava/util/Iterator;
      // 1d: astore 1
      // 1e: aload 1
      // 1f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 24: ifeq 42
      // 27: aload 1
      // 28: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2d: checkcast org/apache/http/pool/PoolEntry
      // 30: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 33: goto 1e
      // 36: astore 1
      // 37: aload 0
      // 38: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // 3b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 40: aload 1
      // 41: athrow
      // 42: aload 0
      // 43: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 46: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 4b: astore 1
      // 4c: aload 1
      // 4d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 52: ifeq 64
      // 55: aload 1
      // 56: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 5b: checkcast org/apache/http/pool/PoolEntry
      // 5e: invokevirtual org/apache/http/pool/PoolEntry.close ()V
      // 61: goto 4c
      // 64: aload 0
      // 65: getfield org/apache/http/pool/AbstractConnPool.routeToPool Ljava/util/Map;
      // 68: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 6d: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 72: astore 1
      // 73: aload 1
      // 74: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 79: ifeq 8b
      // 7c: aload 1
      // 7d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 82: checkcast org/apache/http/pool/RouteSpecificPool
      // 85: invokevirtual org/apache/http/pool/RouteSpecificPool.shutdown ()V
      // 88: goto 73
      // 8b: aload 0
      // 8c: getfield org/apache/http/pool/AbstractConnPool.routeToPool Ljava/util/Map;
      // 8f: invokeinterface java/util/Map.clear ()V 1
      // 94: aload 0
      // 95: getfield org/apache/http/pool/AbstractConnPool.leased Ljava/util/Set;
      // 98: invokeinterface java/util/Set.clear ()V 1
      // 9d: aload 0
      // 9e: getfield org/apache/http/pool/AbstractConnPool.available Ljava/util/LinkedList;
      // a1: invokevirtual java/util/LinkedList.clear ()V
      // a4: aload 0
      // a5: getfield org/apache/http/pool/AbstractConnPool.lock Ljava/util/concurrent/locks/Lock;
      // a8: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // ad: goto 07
      // try (10 -> 14): 22 null
      // try (14 -> 21): 22 null
      // try (28 -> 32): 22 null
      // try (32 -> 39): 22 null
      // try (40 -> 45): 22 null
      // try (45 -> 52): 22 null
      // try (53 -> 62): 22 null
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[leased: ");
      var1.append(this.leased);
      var1.append("][available: ");
      var1.append(this.available);
      var1.append("][pending: ");
      var1.append(this.pending);
      var1.append("]");
      return var1.toString();
   }

   protected boolean validate(E var1) {
      return true;
   }
}
