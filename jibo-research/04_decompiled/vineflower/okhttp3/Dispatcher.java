package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public final class Dispatcher {
   private int a = 64;
   private int b = 5;
   private Runnable c;
   private ExecutorService d;
   private final Deque<RealCall.AsyncCall> e = new ArrayDeque<>();
   private final Deque<RealCall.AsyncCall> f = new ArrayDeque<>();
   private final Deque<RealCall> g = new ArrayDeque<>();

   public Dispatcher() {
   }

   public Dispatcher(ExecutorService var1) {
      this.d = var1;
   }

   private <T> void a(Deque<T> param1, T param2, boolean param3) {
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
      // 02: aload 1
      // 03: aload 2
      // 04: invokeinterface java/util/Deque.remove (Ljava/lang/Object;)Z 2
      // 09: ifne 1d
      // 0c: new java/lang/AssertionError
      // 0f: astore 1
      // 10: aload 1
      // 11: ldc "Call wasn't in-flight!"
      // 13: invokespecial java/lang/AssertionError.<init> (Ljava/lang/Object;)V
      // 16: aload 1
      // 17: athrow
      // 18: astore 1
      // 19: aload 0
      // 1a: monitorexit
      // 1b: aload 1
      // 1c: athrow
      // 1d: iload 3
      // 1e: ifeq 25
      // 21: aload 0
      // 22: invokespecial okhttp3/Dispatcher.d ()V
      // 25: aload 0
      // 26: invokevirtual okhttp3/Dispatcher.c ()I
      // 29: istore 4
      // 2b: aload 0
      // 2c: getfield okhttp3/Dispatcher.c Ljava/lang/Runnable;
      // 2f: astore 1
      // 30: aload 0
      // 31: monitorexit
      // 32: iload 4
      // 34: ifne 41
      // 37: aload 1
      // 38: ifnull 41
      // 3b: aload 1
      // 3c: invokeinterface java/lang/Runnable.run ()V 1
      // 41: return
      // try (2 -> 13): 13 null
      // try (14 -> 16): 13 null
      // try (20 -> 22): 13 null
      // try (22 -> 30): 13 null
   }

   private int c(RealCall.AsyncCall var1) {
      Iterator var3 = this.f.iterator();
      int var2 = 0;

      while (var3.hasNext()) {
         if (((RealCall.AsyncCall)var3.next()).a().equals(var1.a())) {
            var2++;
         }
      }

      return var2;
   }

   private void d() {
      if (this.f.size() < this.a && !this.e.isEmpty()) {
         Iterator var2 = this.e.iterator();

         while (var2.hasNext()) {
            RealCall.AsyncCall var1 = (RealCall.AsyncCall)var2.next();
            if (this.c(var1) < this.b) {
               var2.remove();
               this.f.add(var1);
               this.a().execute(var1);
            }

            if (this.f.size() >= this.a) {
               break;
            }
         }
      }
   }

   public ExecutorService a() {
      synchronized (this) {
         if (this.d == null) {
            TimeUnit var1 = TimeUnit.SECONDS;
            SynchronousQueue var2 = new SynchronousQueue();
            ThreadPoolExecutor var3 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, var1, var2, Util.a("OkHttp Dispatcher", false));
            this.d = var3;
         }

         return this.d;
      }
   }

   public void a(int param1) {
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
      // 02: iload 1
      // 03: bipush 1
      // 04: if_icmpge 2b
      // 07: new java/lang/IllegalArgumentException
      // 0a: astore 2
      // 0b: new java/lang/StringBuilder
      // 0e: astore 3
      // 0f: aload 3
      // 10: invokespecial java/lang/StringBuilder.<init> ()V
      // 13: aload 2
      // 14: aload 3
      // 15: ldc "max < 1: "
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a: iload 1
      // 1b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 21: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 24: aload 2
      // 25: athrow
      // 26: astore 2
      // 27: aload 0
      // 28: monitorexit
      // 29: aload 2
      // 2a: athrow
      // 2b: aload 0
      // 2c: iload 1
      // 2d: putfield okhttp3/Dispatcher.a I
      // 30: aload 0
      // 31: invokespecial okhttp3/Dispatcher.d ()V
      // 34: aload 0
      // 35: monitorexit
      // 36: return
      // try (5 -> 21): 21 null
      // try (26 -> 31): 21 null
   }

   void a(RealCall.AsyncCall var1) {
      synchronized (this) {
         if (this.f.size() < this.a && this.c(var1) < this.b) {
            this.f.add(var1);
            this.a().execute(var1);
         } else {
            this.e.add(var1);
         }
      }
   }

   void a(RealCall var1) {
      synchronized (this) {
         this.g.add(var1);
      }
   }

   public void b() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/Dispatcher.e Ljava/util/Deque;
      // 06: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 0b: astore 1
      // 0c: aload 1
      // 0d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 12: ifeq 2c
      // 15: aload 1
      // 16: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1b: checkcast okhttp3/RealCall$AsyncCall
      // 1e: invokevirtual okhttp3/RealCall$AsyncCall.b ()Lokhttp3/RealCall;
      // 21: invokevirtual okhttp3/RealCall.c ()V
      // 24: goto 0c
      // 27: astore 1
      // 28: aload 0
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield okhttp3/Dispatcher.f Ljava/util/Deque;
      // 30: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 35: astore 1
      // 36: aload 1
      // 37: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3c: ifeq 51
      // 3f: aload 1
      // 40: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 45: checkcast okhttp3/RealCall$AsyncCall
      // 48: invokevirtual okhttp3/RealCall$AsyncCall.b ()Lokhttp3/RealCall;
      // 4b: invokevirtual okhttp3/RealCall.c ()V
      // 4e: goto 36
      // 51: aload 0
      // 52: getfield okhttp3/Dispatcher.g Ljava/util/Deque;
      // 55: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 5a: astore 1
      // 5b: aload 1
      // 5c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 61: ifeq 73
      // 64: aload 1
      // 65: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 6a: checkcast okhttp3/RealCall
      // 6d: invokevirtual okhttp3/RealCall.c ()V
      // 70: goto 5b
      // 73: aload 0
      // 74: monitorexit
      // 75: return
      // try (2 -> 6): 15 null
      // try (6 -> 14): 15 null
      // try (20 -> 24): 15 null
      // try (24 -> 32): 15 null
      // try (33 -> 37): 15 null
      // try (37 -> 44): 15 null
   }

   public void b(int param1) {
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
      // 02: iload 1
      // 03: bipush 1
      // 04: if_icmpge 2b
      // 07: new java/lang/IllegalArgumentException
      // 0a: astore 2
      // 0b: new java/lang/StringBuilder
      // 0e: astore 3
      // 0f: aload 3
      // 10: invokespecial java/lang/StringBuilder.<init> ()V
      // 13: aload 2
      // 14: aload 3
      // 15: ldc "max < 1: "
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a: iload 1
      // 1b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 21: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 24: aload 2
      // 25: athrow
      // 26: astore 2
      // 27: aload 0
      // 28: monitorexit
      // 29: aload 2
      // 2a: athrow
      // 2b: aload 0
      // 2c: iload 1
      // 2d: putfield okhttp3/Dispatcher.b I
      // 30: aload 0
      // 31: invokespecial okhttp3/Dispatcher.d ()V
      // 34: aload 0
      // 35: monitorexit
      // 36: return
      // try (5 -> 21): 21 null
      // try (26 -> 31): 21 null
   }

   void b(RealCall.AsyncCall var1) {
      this.a(this.f, var1, true);
   }

   void b(RealCall var1) {
      this.a(this.g, var1, false);
   }

   public int c() {
      int var1;
      int var2;
      synchronized (this) {
         var1 = this.f.size();
         var2 = this.g.size();
      }

      return var1 + var2;
   }
}
