package android.support.v4.os;

public final class CancellationSignal {
   private boolean a;
   private CancellationSignal.OnCancelListener b;
   private Object c;
   private boolean d;

   public boolean a() {
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
      // 0: aload 0
      // 1: monitorenter
      // 2: aload 0
      // 3: getfield android/support/v4/os/CancellationSignal.a Z
      // 6: istore 1
      // 7: aload 0
      // 8: monitorexit
      // 9: iload 1
      // a: ireturn
      // b: astore 2
      // c: aload 0
      // d: monitorexit
      // e: aload 2
      // f: athrow
      // try (2 -> 7): 9 null
      // try (10 -> 12): 9 null
   }

   public void b() {
      if (this.a()) {
         throw new OperationCanceledException();
      }
   }

   public void c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield android/support/v4/os/CancellationSignal.a Z
      // 06: ifeq 0c
      // 09: aload 0
      // 0a: monitorexit
      // 0b: return
      // 0c: aload 0
      // 0d: bipush 1
      // 0e: putfield android/support/v4/os/CancellationSignal.a Z
      // 11: aload 0
      // 12: bipush 1
      // 13: putfield android/support/v4/os/CancellationSignal.d Z
      // 16: aload 0
      // 17: getfield android/support/v4/os/CancellationSignal.b Landroid/support/v4/os/CancellationSignal$OnCancelListener;
      // 1a: astore 1
      // 1b: aload 0
      // 1c: getfield android/support/v4/os/CancellationSignal.c Ljava/lang/Object;
      // 1f: astore 2
      // 20: aload 0
      // 21: monitorexit
      // 22: aload 1
      // 23: ifnull 2c
      // 26: aload 1
      // 27: invokeinterface android/support/v4/os/CancellationSignal$OnCancelListener.a ()V 1
      // 2c: aload 2
      // 2d: ifnull 3f
      // 30: getstatic android/os/Build$VERSION.SDK_INT I
      // 33: bipush 16
      // 35: if_icmplt 3f
      // 38: aload 2
      // 39: checkcast android/os/CancellationSignal
      // 3c: invokevirtual android/os/CancellationSignal.cancel ()V
      // 3f: aload 0
      // 40: monitorenter
      // 41: aload 0
      // 42: bipush 0
      // 43: putfield android/support/v4/os/CancellationSignal.d Z
      // 46: aload 0
      // 47: invokevirtual java/lang/Object.notifyAll ()V
      // 4a: aload 0
      // 4b: monitorexit
      // 4c: goto 0b
      // 4f: astore 1
      // 50: aload 0
      // 51: monitorexit
      // 52: aload 1
      // 53: athrow
      // 54: astore 1
      // 55: aload 0
      // 56: monitorexit
      // 57: aload 1
      // 58: athrow
      // 59: astore 1
      // 5a: aload 0
      // 5b: monitorenter
      // 5c: aload 0
      // 5d: bipush 0
      // 5e: putfield android/support/v4/os/CancellationSignal.d Z
      // 61: aload 0
      // 62: invokevirtual java/lang/Object.notifyAll ()V
      // 65: aload 0
      // 66: monitorexit
      // 67: aload 1
      // 68: athrow
      // 69: astore 1
      // 6a: aload 0
      // 6b: monitorexit
      // 6c: aload 1
      // 6d: athrow
      // try (2 -> 7): 49 null
      // try (8 -> 22): 49 null
      // try (24 -> 26): 54 null
      // try (28 -> 34): 54 null
      // try (36 -> 43): 44 null
      // try (45 -> 47): 44 null
      // try (50 -> 52): 49 null
      // try (57 -> 64): 66 null
      // try (67 -> 69): 66 null
   }

   public Object d() {
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
      // 00: getstatic android/os/Build$VERSION.SDK_INT I
      // 03: bipush 16
      // 05: if_icmpge 0c
      // 08: aconst_null
      // 09: astore 1
      // 0a: aload 1
      // 0b: areturn
      // 0c: aload 0
      // 0d: monitorenter
      // 0e: aload 0
      // 0f: getfield android/support/v4/os/CancellationSignal.c Ljava/lang/Object;
      // 12: ifnonnull 33
      // 15: new android/os/CancellationSignal
      // 18: astore 1
      // 19: aload 1
      // 1a: invokespecial android/os/CancellationSignal.<init> ()V
      // 1d: aload 0
      // 1e: aload 1
      // 1f: putfield android/support/v4/os/CancellationSignal.c Ljava/lang/Object;
      // 22: aload 0
      // 23: getfield android/support/v4/os/CancellationSignal.a Z
      // 26: ifeq 33
      // 29: aload 0
      // 2a: getfield android/support/v4/os/CancellationSignal.c Ljava/lang/Object;
      // 2d: checkcast android/os/CancellationSignal
      // 30: invokevirtual android/os/CancellationSignal.cancel ()V
      // 33: aload 0
      // 34: getfield android/support/v4/os/CancellationSignal.c Ljava/lang/Object;
      // 37: astore 1
      // 38: aload 0
      // 39: monitorexit
      // 3a: goto 0a
      // 3d: astore 1
      // 3e: aload 0
      // 3f: monitorexit
      // 40: aload 1
      // 41: athrow
      // try (9 -> 26): 32 null
      // try (26 -> 31): 32 null
      // try (33 -> 35): 32 null
   }

   public interface OnCancelListener {
      void a();
   }
}
