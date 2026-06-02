package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult> {
   public static final ExecutorService a = BoltsExecutors.a();
   public static final Executor b = AndroidExecutors.b();
   private static final Executor c = BoltsExecutors.b();
   private static volatile Task.UnobservedExceptionHandler d;
   private static Task<?> m = new Task(null);
   private static Task<Boolean> n = new Task<>(Boolean.valueOf(true));
   private static Task<Boolean> o = new Task<>(Boolean.valueOf(false));
   private static Task<?> p = new Task(true);
   private final Object e = new Object();
   private boolean f;
   private boolean g;
   private TResult h;
   private Exception i;
   private boolean j;
   private UnobservedErrorNotifier k;
   private List<Continuation<TResult, Void>> l = new ArrayList<>();

   Task() {
   }

   private Task(TResult var1) {
      this.b((TResult)var1);
   }

   private Task(boolean var1) {
      if (var1) {
         this.i();
      } else {
         this.b((TResult)null);
      }
   }

   public static Task.UnobservedExceptionHandler a() {
      return d;
   }

   public static <TResult> Task<TResult> a(Exception var0) {
      bolts.TaskCompletionSource var1 = new bolts.TaskCompletionSource();
      var1.b(var0);
      return var1.a();
   }

   public static <TResult> Task<TResult> a(TResult var0) {
      Task var2;
      if (var0 == null) {
         var2 = m;
      } else if (var0 instanceof Boolean) {
         if ((Boolean)var0) {
            var2 = n;
         } else {
            var2 = o;
         }
      } else {
         bolts.TaskCompletionSource var1 = new bolts.TaskCompletionSource();
         var1.b(var0);
         var2 = var1.a();
      }

      return var2;
   }

   public static <TResult> Task<TResult>.TaskCompletionSource b() {
      Task var0 = new Task();
      return var0.new TaskCompletionSource(var0);
   }

   private static <TContinuationResult, TResult> void c(
      bolts.TaskCompletionSource<TContinuationResult> var0,
      Continuation<TResult, TContinuationResult> var1,
      Task<TResult> var2,
      Executor var3,
      CancellationToken var4
   ) {
      try {
         Runnable var5 = new Runnable(var4, var0, var1, var2) {
            final CancellationToken a;
            final bolts.TaskCompletionSource b;
            final Continuation c;
            final Task d;

            {
               this.a = var1;
               this.b = var2x;
               this.c = var3x;
               this.d = var4x;
            }

            @Override
            public void run() {
               if (this.a != null && this.a.a()) {
                  this.b.c();
               } else {
                  try {
                     Object var1x = this.c.then(this.d);
                     this.b.b(var1x);
                  } catch (CancellationException var2x) {
                     this.b.c();
                  } catch (Exception var3x) {
                     this.b.b(var3x);
                  }
               }
            }
         };
         var3.execute(var5);
      } catch (Exception var6) {
         var0.b(new ExecutorException(var6));
      }
   }

   private static <TContinuationResult, TResult> void d(
      bolts.TaskCompletionSource<TContinuationResult> var0,
      Continuation<TResult, Task<TContinuationResult>> var1,
      Task<TResult> var2,
      Executor var3,
      CancellationToken var4
   ) {
      try {
         Runnable var5 = new Runnable(var4, var0, var1, var2) {
            final CancellationToken a;
            final bolts.TaskCompletionSource b;
            final Continuation c;
            final Task d;

            {
               this.a = var1;
               this.b = var2x;
               this.c = var3x;
               this.d = var4x;
            }

            // $VF: Duplicated exception handlers to handle obfuscated exceptions
            @Override
            public void run() {
               if (this.a != null && this.a.a()) {
                  this.b.c();
               } else {
                  Task var2x;
                  try {
                     var2x = (Task)this.c.then(this.d);
                  } catch (CancellationException var7) {
                     this.b.c();
                     return;
                  } catch (Exception var8) {
                     this.b.b(var8);
                     return;
                  }

                  if (var2x == null) {
                     try {
                        this.b.b((TResult)null);
                     } catch (CancellationException var5x) {
                        this.b.c();
                     } catch (Exception var6) {
                        this.b.b(var6);
                     }
                  } else {
                     try {
                        Continuation var1x = new Continuation<TContinuationResult, Void>(this) {
                           final <unrepresentable> a;

                           {
                              this.a = var1;
                           }

                           public Void a(Task<TContinuationResult> var1) {
                              if (this.a.a != null && this.a.a.a()) {
                                 this.a.b.c();
                              } else if (var1.d()) {
                                 this.a.b.c();
                              } else if (var1.e()) {
                                 this.a.b.b(var1.g());
                              } else {
                                 this.a.b.b(var1.f());
                              }

                              return null;
                           }
                        };
                        var2x.a(var1x);
                     } catch (CancellationException var3x) {
                        this.b.c();
                     } catch (Exception var4x) {
                        this.b.b(var4x);
                     }
                  }
               }
            }
         };
         var3.execute(var5);
      } catch (Exception var6) {
         var0.b(new ExecutorException(var6));
      }
   }

   public static <TResult> Task<TResult> h() {
      return (Task<TResult>)p;
   }

   private void j() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/Task.l Ljava/util/List;
      // 0b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 10: astore 2
      // 11: aload 2
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 43
      // 1a: aload 2
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast bolts/Continuation
      // 23: astore 3
      // 24: aload 3
      // 25: aload 0
      // 26: invokeinterface bolts/Continuation.then (Lbolts/Task;)Ljava/lang/Object; 2
      // 2b: pop
      // 2c: goto 11
      // 2f: astore 2
      // 30: aload 2
      // 31: athrow
      // 32: astore 2
      // 33: aload 1
      // 34: monitorexit
      // 35: aload 2
      // 36: athrow
      // 37: astore 2
      // 38: new java/lang/RuntimeException
      // 3b: astore 3
      // 3c: aload 3
      // 3d: aload 2
      // 3e: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 41: aload 3
      // 42: athrow
      // 43: aload 0
      // 44: aconst_null
      // 45: putfield bolts/Task.l Ljava/util/List;
      // 48: aload 1
      // 49: monitorexit
      // 4a: return
      // try (5 -> 9): 24 null
      // try (9 -> 16): 24 null
      // try (16 -> 20): 21 java/lang/RuntimeException
      // try (16 -> 20): 29 java/lang/Exception
      // try (16 -> 20): 24 null
      // try (22 -> 24): 24 null
      // try (25 -> 27): 24 null
      // try (30 -> 37): 24 null
      // try (37 -> 42): 24 null
   }

   public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> var1) {
      return this.a(var1, c, null);
   }

   public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, Task<TContinuationResult>> var1, Executor var2) {
      return this.b(var1, var2, null);
   }

   public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> param1, Executor param2, CancellationToken param3) {
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
      // 00: new bolts/TaskCompletionSource
      // 03: dup
      // 04: invokespecial bolts/TaskCompletionSource.<init> ()V
      // 07: astore 6
      // 09: aload 0
      // 0a: getfield bolts/Task.e Ljava/lang/Object;
      // 0d: astore 5
      // 0f: aload 5
      // 11: monitorenter
      // 12: aload 0
      // 13: invokevirtual bolts/Task.c ()Z
      // 16: istore 4
      // 18: iload 4
      // 1a: ifne 3d
      // 1d: aload 0
      // 1e: getfield bolts/Task.l Ljava/util/List;
      // 21: astore 8
      // 23: new bolts/Task$10
      // 26: astore 7
      // 28: aload 7
      // 2a: aload 0
      // 2b: aload 6
      // 2d: aload 1
      // 2e: aload 2
      // 2f: aload 3
      // 30: invokespecial bolts/Task$10.<init> (Lbolts/Task;Lbolts/TaskCompletionSource;Lbolts/Continuation;Ljava/util/concurrent/Executor;Lbolts/CancellationToken;)V
      // 33: aload 8
      // 35: aload 7
      // 37: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 3c: pop
      // 3d: aload 5
      // 3f: monitorexit
      // 40: iload 4
      // 42: ifeq 4e
      // 45: aload 6
      // 47: aload 1
      // 48: aload 0
      // 49: aload 2
      // 4a: aload 3
      // 4b: invokestatic bolts/Task.c (Lbolts/TaskCompletionSource;Lbolts/Continuation;Lbolts/Task;Ljava/util/concurrent/Executor;Lbolts/CancellationToken;)V
      // 4e: aload 6
      // 50: invokevirtual bolts/TaskCompletionSource.a ()Lbolts/Task;
      // 53: areturn
      // 54: astore 1
      // 55: aload 5
      // 57: monitorexit
      // 58: aload 1
      // 59: athrow
      // try (9 -> 12): 43 null
      // try (14 -> 30): 43 null
      // try (30 -> 32): 43 null
      // try (44 -> 46): 43 null
   }

   public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, TContinuationResult> var1) {
      return this.c(var1, c, null);
   }

   public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> param1, Executor param2, CancellationToken param3) {
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
      // 00: new bolts/TaskCompletionSource
      // 03: dup
      // 04: invokespecial bolts/TaskCompletionSource.<init> ()V
      // 07: astore 6
      // 09: aload 0
      // 0a: getfield bolts/Task.e Ljava/lang/Object;
      // 0d: astore 5
      // 0f: aload 5
      // 11: monitorenter
      // 12: aload 0
      // 13: invokevirtual bolts/Task.c ()Z
      // 16: istore 4
      // 18: iload 4
      // 1a: ifne 3d
      // 1d: aload 0
      // 1e: getfield bolts/Task.l Ljava/util/List;
      // 21: astore 7
      // 23: new bolts/Task$11
      // 26: astore 8
      // 28: aload 8
      // 2a: aload 0
      // 2b: aload 6
      // 2d: aload 1
      // 2e: aload 2
      // 2f: aload 3
      // 30: invokespecial bolts/Task$11.<init> (Lbolts/Task;Lbolts/TaskCompletionSource;Lbolts/Continuation;Ljava/util/concurrent/Executor;Lbolts/CancellationToken;)V
      // 33: aload 7
      // 35: aload 8
      // 37: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 3c: pop
      // 3d: aload 5
      // 3f: monitorexit
      // 40: iload 4
      // 42: ifeq 4e
      // 45: aload 6
      // 47: aload 1
      // 48: aload 0
      // 49: aload 2
      // 4a: aload 3
      // 4b: invokestatic bolts/Task.d (Lbolts/TaskCompletionSource;Lbolts/Continuation;Lbolts/Task;Ljava/util/concurrent/Executor;Lbolts/CancellationToken;)V
      // 4e: aload 6
      // 50: invokevirtual bolts/TaskCompletionSource.a ()Lbolts/Task;
      // 53: areturn
      // 54: astore 1
      // 55: aload 5
      // 57: monitorexit
      // 58: aload 1
      // 59: athrow
      // try (9 -> 12): 43 null
      // try (14 -> 30): 43 null
      // try (30 -> 32): 43 null
      // try (44 -> 46): 43 null
   }

   boolean b(Exception param1) {
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
      // 02: aload 0
      // 03: getfield bolts/Task.e Ljava/lang/Object;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield bolts/Task.f Z
      // 0d: ifeq 14
      // 10: aload 3
      // 11: monitorexit
      // 12: iload 2
      // 13: ireturn
      // 14: aload 0
      // 15: bipush 1
      // 16: putfield bolts/Task.f Z
      // 19: aload 0
      // 1a: aload 1
      // 1b: putfield bolts/Task.i Ljava/lang/Exception;
      // 1e: aload 0
      // 1f: bipush 0
      // 20: putfield bolts/Task.j Z
      // 23: aload 0
      // 24: getfield bolts/Task.e Ljava/lang/Object;
      // 27: invokevirtual java/lang/Object.notifyAll ()V
      // 2a: aload 0
      // 2b: invokespecial bolts/Task.j ()V
      // 2e: aload 0
      // 2f: getfield bolts/Task.j Z
      // 32: ifne 49
      // 35: invokestatic bolts/Task.a ()Lbolts/Task$UnobservedExceptionHandler;
      // 38: ifnull 49
      // 3b: new bolts/UnobservedErrorNotifier
      // 3e: astore 1
      // 3f: aload 1
      // 40: aload 0
      // 41: invokespecial bolts/UnobservedErrorNotifier.<init> (Lbolts/Task;)V
      // 44: aload 0
      // 45: aload 1
      // 46: putfield bolts/Task.k Lbolts/UnobservedErrorNotifier;
      // 49: aload 3
      // 4a: monitorexit
      // 4b: bipush 1
      // 4c: istore 2
      // 4d: goto 12
      // 50: astore 1
      // 51: aload 3
      // 52: monitorexit
      // 53: aload 1
      // 54: athrow
      // try (7 -> 12): 46 null
      // try (14 -> 41): 46 null
      // try (41 -> 43): 46 null
      // try (47 -> 49): 46 null
   }

   boolean b(TResult param1) {
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
      // 02: aload 0
      // 03: getfield bolts/Task.e Ljava/lang/Object;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield bolts/Task.f Z
      // 0d: ifeq 16
      // 10: bipush 0
      // 11: istore 2
      // 12: aload 3
      // 13: monitorexit
      // 14: iload 2
      // 15: ireturn
      // 16: aload 0
      // 17: bipush 1
      // 18: putfield bolts/Task.f Z
      // 1b: aload 0
      // 1c: aload 1
      // 1d: putfield bolts/Task.h Ljava/lang/Object;
      // 20: aload 0
      // 21: getfield bolts/Task.e Ljava/lang/Object;
      // 24: invokevirtual java/lang/Object.notifyAll ()V
      // 27: aload 0
      // 28: invokespecial bolts/Task.j ()V
      // 2b: aload 3
      // 2c: monitorexit
      // 2d: goto 14
      // 30: astore 1
      // 31: aload 3
      // 32: monitorexit
      // 33: aload 1
      // 34: athrow
      // try (7 -> 10): 30 null
      // try (12 -> 14): 30 null
      // try (16 -> 29): 30 null
      // try (31 -> 33): 30 null
   }

   public <TContinuationResult> Task<TContinuationResult> c(Continuation<TResult, TContinuationResult> var1, Executor var2, CancellationToken var3) {
      return this.a(new Continuation<TResult, Task<TContinuationResult>>(this, var3, var1) {
         final CancellationToken a;
         final Continuation b;
         final Task c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         public Task<TContinuationResult> a(Task<TResult> var1) {
            if (this.a != null && this.a.a()) {
               var1 = Task.h();
            } else if (var1.e()) {
               var1 = Task.a(var1.g());
            } else if (var1.d()) {
               var1 = Task.h();
            } else {
               var1 = var1.a(this.b);
            }

            return var1;
         }
      }, var2);
   }

   public boolean c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/Task.f Z
      // 0b: istore 1
      // 0c: aload 3
      // 0d: monitorexit
      // 0e: iload 1
      // 0f: ireturn
      // 10: astore 2
      // 11: aload 3
      // 12: monitorexit
      // 13: aload 2
      // 14: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   public boolean d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/Task.g Z
      // 0b: istore 1
      // 0c: aload 2
      // 0d: monitorexit
      // 0e: iload 1
      // 0f: ireturn
      // 10: astore 3
      // 11: aload 2
      // 12: monitorexit
      // 13: aload 3
      // 14: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   public boolean e() {
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
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: invokevirtual bolts/Task.g ()Ljava/lang/Exception;
      // 0b: ifnull 14
      // 0e: bipush 1
      // 0f: istore 1
      // 10: aload 3
      // 11: monitorexit
      // 12: iload 1
      // 13: ireturn
      // 14: bipush 0
      // 15: istore 1
      // 16: goto 10
      // 19: astore 2
      // 1a: aload 3
      // 1b: monitorexit
      // 1c: aload 2
      // 1d: athrow
      // try (5 -> 8): 17 null
      // try (10 -> 12): 17 null
      // try (18 -> 20): 17 null
   }

   public TResult f() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/Task.h Ljava/lang/Object;
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

   public Exception g() {
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
      // 01: getfield bolts/Task.e Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/Task.i Ljava/lang/Exception;
      // 0b: ifnull 26
      // 0e: aload 0
      // 0f: bipush 1
      // 10: putfield bolts/Task.j Z
      // 13: aload 0
      // 14: getfield bolts/Task.k Lbolts/UnobservedErrorNotifier;
      // 17: ifnull 26
      // 1a: aload 0
      // 1b: getfield bolts/Task.k Lbolts/UnobservedErrorNotifier;
      // 1e: invokevirtual bolts/UnobservedErrorNotifier.a ()V
      // 21: aload 0
      // 22: aconst_null
      // 23: putfield bolts/Task.k Lbolts/UnobservedErrorNotifier;
      // 26: aload 0
      // 27: getfield bolts/Task.i Ljava/lang/Exception;
      // 2a: astore 2
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 2
      // 2e: areturn
      // 2f: astore 2
      // 30: aload 1
      // 31: monitorexit
      // 32: aload 2
      // 33: athrow
      // try (5 -> 20): 27 null
      // try (20 -> 25): 27 null
      // try (28 -> 30): 27 null
   }

   boolean i() {
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
      // 01: istore 1
      // 02: aload 0
      // 03: getfield bolts/Task.e Ljava/lang/Object;
      // 06: astore 2
      // 07: aload 2
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield bolts/Task.f Z
      // 0d: ifeq 16
      // 10: bipush 0
      // 11: istore 1
      // 12: aload 2
      // 13: monitorexit
      // 14: iload 1
      // 15: ireturn
      // 16: aload 0
      // 17: bipush 1
      // 18: putfield bolts/Task.f Z
      // 1b: aload 0
      // 1c: bipush 1
      // 1d: putfield bolts/Task.g Z
      // 20: aload 0
      // 21: getfield bolts/Task.e Ljava/lang/Object;
      // 24: invokevirtual java/lang/Object.notifyAll ()V
      // 27: aload 0
      // 28: invokespecial bolts/Task.j ()V
      // 2b: aload 2
      // 2c: monitorexit
      // 2d: goto 14
      // 30: astore 3
      // 31: aload 2
      // 32: monitorexit
      // 33: aload 3
      // 34: athrow
      // try (7 -> 10): 30 null
      // try (12 -> 14): 30 null
      // try (16 -> 29): 30 null
      // try (31 -> 33): 30 null
   }

   public class TaskCompletionSource extends bolts.TaskCompletionSource<TResult> {
      final Task a;

      TaskCompletionSource(Task var1) {
         this.a = var1;
      }
   }

   public interface UnobservedExceptionHandler {
      void a(Task<?> var1, UnobservedTaskException var2);
   }
}
