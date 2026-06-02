package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
   private static final long a = TimeUnit.SECONDS.toMillis(60L);
   static AsyncTimeout b;
   private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
   private boolean e;
   private AsyncTimeout f;
   private long g;

   private static void a(AsyncTimeout param0, long param1, boolean param3) {
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
      // 00: ldc okio/AsyncTimeout
      // 02: monitorenter
      // 03: getstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
      // 06: ifnonnull 27
      // 09: new okio/AsyncTimeout
      // 0c: astore 6
      // 0e: aload 6
      // 10: invokespecial okio/AsyncTimeout.<init> ()V
      // 13: aload 6
      // 15: putstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
      // 18: new okio/AsyncTimeout$Watchdog
      // 1b: astore 6
      // 1d: aload 6
      // 1f: invokespecial okio/AsyncTimeout$Watchdog.<init> ()V
      // 22: aload 6
      // 24: invokevirtual okio/AsyncTimeout$Watchdog.start ()V
      // 27: invokestatic java/lang/System.nanoTime ()J
      // 2a: lstore 4
      // 2c: lload 1
      // 2d: lconst_0
      // 2e: lcmp
      // 2f: ifeq 8b
      // 32: iload 3
      // 33: ifeq 8b
      // 36: aload 0
      // 37: lload 1
      // 38: aload 0
      // 39: invokevirtual okio/AsyncTimeout.d ()J
      // 3c: lload 4
      // 3e: lsub
      // 3f: invokestatic java/lang/Math.min (JJ)J
      // 42: lload 4
      // 44: ladd
      // 45: putfield okio/AsyncTimeout.g J
      // 48: aload 0
      // 49: lload 4
      // 4b: invokespecial okio/AsyncTimeout.b (J)J
      // 4e: lstore 1
      // 4f: getstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
      // 52: astore 6
      // 54: aload 6
      // 56: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 59: ifnull 6b
      // 5c: lload 1
      // 5d: aload 6
      // 5f: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 62: lload 4
      // 64: invokespecial okio/AsyncTimeout.b (J)J
      // 67: lcmp
      // 68: ifge bb
      // 6b: aload 0
      // 6c: aload 6
      // 6e: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 71: putfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 74: aload 6
      // 76: aload 0
      // 77: putfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 7a: aload 6
      // 7c: getstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
      // 7f: if_acmpne 87
      // 82: ldc okio/AsyncTimeout
      // 84: invokevirtual java/lang/Object.notify ()V
      // 87: ldc okio/AsyncTimeout
      // 89: monitorexit
      // 8a: return
      // 8b: lload 1
      // 8c: lconst_0
      // 8d: lcmp
      // 8e: ifeq a2
      // 91: aload 0
      // 92: lload 4
      // 94: lload 1
      // 95: ladd
      // 96: putfield okio/AsyncTimeout.g J
      // 99: goto 48
      // 9c: astore 0
      // 9d: ldc okio/AsyncTimeout
      // 9f: monitorexit
      // a0: aload 0
      // a1: athrow
      // a2: iload 3
      // a3: ifeq b1
      // a6: aload 0
      // a7: aload 0
      // a8: invokevirtual okio/AsyncTimeout.d ()J
      // ab: putfield okio/AsyncTimeout.g J
      // ae: goto 48
      // b1: new java/lang/AssertionError
      // b4: astore 0
      // b5: aload 0
      // b6: invokespecial java/lang/AssertionError.<init> ()V
      // b9: aload 0
      // ba: athrow
      // bb: aload 6
      // bd: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // c0: astore 6
      // c2: goto 54
      // try (2 -> 16): 75 null
      // try (16 -> 18): 75 null
      // try (24 -> 34): 75 null
      // try (34 -> 40): 75 null
      // try (40 -> 50): 75 null
      // try (50 -> 62): 75 null
      // try (69 -> 74): 75 null
      // try (82 -> 86): 75 null
      // try (87 -> 93): 75 null
      // try (93 -> 96): 75 null
   }

   private static boolean a(AsyncTimeout param0) {
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
      // 00: ldc okio/AsyncTimeout
      // 02: monitorenter
      // 03: getstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
      // 06: astore 2
      // 07: aload 2
      // 08: ifnull 2f
      // 0b: aload 2
      // 0c: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 0f: aload 0
      // 10: if_acmpne 27
      // 13: aload 2
      // 14: aload 0
      // 15: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 18: putfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 1b: aload 0
      // 1c: aconst_null
      // 1d: putfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 20: bipush 0
      // 21: istore 1
      // 22: ldc okio/AsyncTimeout
      // 24: monitorexit
      // 25: iload 1
      // 26: ireturn
      // 27: aload 2
      // 28: getfield okio/AsyncTimeout.f Lokio/AsyncTimeout;
      // 2b: astore 2
      // 2c: goto 07
      // 2f: bipush 1
      // 30: istore 1
      // 31: goto 22
      // 34: astore 0
      // 35: ldc okio/AsyncTimeout
      // 37: monitorexit
      // 38: aload 0
      // 39: athrow
      // try (2 -> 4): 30 null
      // try (6 -> 17): 30 null
      // try (23 -> 26): 30 null
   }

   private long b(long var1) {
      return this.g - var1;
   }

   static AsyncTimeout e() throws InterruptedException {
      Object var5 = null;
      AsyncTimeout var4 = b.f;
      if (var4 == null) {
         long var0 = System.nanoTime();
         AsyncTimeout.class.wait(a);
         var4 = (AsyncTimeout)var5;
         if (b.f == null) {
            var4 = (AsyncTimeout)var5;
            if (System.nanoTime() - var0 >= d) {
               var4 = b;
            }
         }
      } else {
         long var2 = var4.b(System.nanoTime());
         if (var2 > 0L) {
            long var6 = var2 / 1000000L;
            AsyncTimeout.class.wait(var6, (int)(var2 - 1000000L * var6));
            var4 = (AsyncTimeout)var5;
         } else {
            b.f = var4.f;
            var4.f = null;
         }
      }

      return var4;
   }

   protected IOException a(IOException var1) {
      InterruptedIOException var2 = new InterruptedIOException("timeout");
      if (var1 != null) {
         var2.initCause(var1);
      }

      return var2;
   }

   public final Sink a(Sink var1) {
      return new Sink(this, var1) {
         final Sink a;
         final AsyncTimeout b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public Timeout a() {
            return this.b;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public void a_(Buffer var1, long var2) throws IOException {
            Util.a(var1.b, 0L, var2);

            while (var2 > 0L) {
               Segment var8 = var1.a;
               long var4 = 0L;

               long var6;
               while (true) {
                  var6 = var4;
                  if (var4 >= 65536L) {
                     break;
                  }

                  var4 += var1.a.c - var1.a.b;
                  if (var4 >= var2) {
                     var6 = var2;
                     break;
                  }

                  var8 = var8.f;
               }

               this.b.c();
               boolean var11 = false /* VF: Semaphore variable */;

               try {
                  var11 = true;
                  this.a.a_(var1, var6);
                  var11 = false;
               } catch (IOException var12) {
                  throw this.b.b(var12);
               } finally {
                  if (var11) {
                     this.b.a(false);
                  }
               }

               var2 -= var6;
               this.b.a(true);
            }
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public void close() throws IOException {
            this.b.c();
            boolean var4 = false /* VF: Semaphore variable */;

            try {
               var4 = true;
               this.a.close();
               var4 = false;
            } catch (IOException var5) {
               throw this.b.b(var5);
            } finally {
               if (var4) {
                  this.b.a(false);
               }
            }

            this.b.a(true);
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public void flush() throws IOException {
            this.b.c();
            boolean var4 = false /* VF: Semaphore variable */;

            try {
               var4 = true;
               this.a.flush();
               var4 = false;
            } catch (IOException var5) {
               throw this.b.b(var5);
            } finally {
               if (var4) {
                  this.b.a(false);
               }
            }

            this.b.a(true);
         }

         @Override
         public String toString() {
            return "AsyncTimeout.sink(" + this.a + ")";
         }
      };
   }

   public final Source a(Source var1) {
      return new Source(this, var1) {
         final Source a;
         final AsyncTimeout b;

         {
            this.b = var1;
            this.a = var2;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public long a(Buffer var1, long var2) throws IOException {
            this.b.c();
            boolean var6 = false /* VF: Semaphore variable */;

            try {
               var6 = true;
               var2 = this.a.a(var1, var2);
               var6 = false;
            } catch (IOException var7) {
               throw this.b.b(var7);
            } finally {
               if (var6) {
                  this.b.a(false);
               }
            }

            this.b.a(true);
            return var2;
         }

         @Override
         public Timeout a() {
            return this.b;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public void close() throws IOException {
            boolean var4 = false /* VF: Semaphore variable */;

            try {
               var4 = true;
               this.a.close();
               var4 = false;
            } catch (IOException var5) {
               throw this.b.b(var5);
            } finally {
               if (var4) {
                  this.b.a(false);
               }
            }

            this.b.a(true);
         }

         @Override
         public String toString() {
            return "AsyncTimeout.source(" + this.a + ")";
         }
      };
   }

   protected void a() {
   }

   final void a(boolean var1) throws IOException {
      if (this.w_() && var1) {
         throw this.a((IOException)null);
      }
   }

   final IOException b(IOException var1) throws IOException {
      if (this.w_()) {
         var1 = this.a(var1);
      }

      return var1;
   }

   public final void c() {
      if (this.e) {
         throw new IllegalStateException("Unbalanced enter/exit");
      }

      long var2 = this.x_();
      boolean var1 = this.y_();
      if (var2 != 0L || var1) {
         this.e = true;
         a(this, var2, var1);
      }
   }

   public final boolean w_() {
      boolean var1 = false;
      if (this.e) {
         this.e = false;
         var1 = a(this);
      }

      return var1;
   }

   private static final class Watchdog extends Thread {
      Watchdog() {
         super("Okio Watchdog");
         this.setDaemon(true);
      }

      @Override
      public void run() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: ldc okio/AsyncTimeout
         // 02: monitorenter
         // 03: invokestatic okio/AsyncTimeout.e ()Lokio/AsyncTimeout;
         // 06: astore 1
         // 07: aload 1
         // 08: ifnonnull 1b
         // 0b: ldc okio/AsyncTimeout
         // 0d: monitorexit
         // 0e: goto 00
         // 11: astore 1
         // 12: ldc okio/AsyncTimeout
         // 14: monitorexit
         // 15: aload 1
         // 16: athrow
         // 17: astore 1
         // 18: goto 00
         // 1b: aload 1
         // 1c: getstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
         // 1f: if_acmpne 2a
         // 22: aconst_null
         // 23: putstatic okio/AsyncTimeout.b Lokio/AsyncTimeout;
         // 26: ldc okio/AsyncTimeout
         // 28: monitorexit
         // 29: return
         // 2a: ldc okio/AsyncTimeout
         // 2c: monitorexit
         // 2d: aload 1
         // 2e: invokevirtual okio/AsyncTimeout.a ()V
         // 31: goto 00
         // try (0 -> 2): 14 java/lang/InterruptedException
         // try (2 -> 4): 9 null
         // try (6 -> 8): 9 null
         // try (10 -> 12): 9 null
         // try (12 -> 14): 14 java/lang/InterruptedException
         // try (16 -> 23): 9 null
         // try (24 -> 26): 9 null
         // try (26 -> 28): 14 java/lang/InterruptedException
      }
   }
}
