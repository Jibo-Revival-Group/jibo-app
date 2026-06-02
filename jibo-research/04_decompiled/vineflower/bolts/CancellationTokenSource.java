package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class CancellationTokenSource implements Closeable {
   private final Object a;
   private final List<CancellationTokenRegistration> b;
   private ScheduledFuture<?> c;
   private boolean d;
   private boolean e;

   private void b() {
      if (this.e) {
         throw new IllegalStateException("Object already closed");
      }
   }

   private void c() {
      if (this.c != null) {
         this.c.cancel(true);
         this.c = null;
      }
   }

   void a(CancellationTokenRegistration param1) {
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
      // 01: getfield bolts/CancellationTokenSource.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial bolts/CancellationTokenSource.b ()V
      // 0b: aload 0
      // 0c: getfield bolts/CancellationTokenSource.b Ljava/util/List;
      // 0f: aload 1
      // 10: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 15: pop
      // 16: aload 2
      // 17: monitorexit
      // 18: return
      // 19: astore 1
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: aload 1
      // 1d: athrow
      // try (5 -> 14): 15 null
      // try (16 -> 18): 15 null
   }

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
      // 00: aload 0
      // 01: getfield bolts/CancellationTokenSource.a Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial bolts/CancellationTokenSource.b ()V
      // 0b: aload 0
      // 0c: getfield bolts/CancellationTokenSource.d Z
      // 0f: istore 1
      // 10: aload 3
      // 11: monitorexit
      // 12: iload 1
      // 13: ireturn
      // 14: astore 2
      // 15: aload 3
      // 16: monitorexit
      // 17: aload 2
      // 18: athrow
      // try (5 -> 12): 14 null
      // try (15 -> 17): 14 null
   }

   @Override
   public void close() {
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
      // 01: getfield bolts/CancellationTokenSource.a Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/CancellationTokenSource.e Z
      // 0b: ifeq 11
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: aload 0
      // 12: invokespecial bolts/CancellationTokenSource.c ()V
      // 15: aload 0
      // 16: getfield bolts/CancellationTokenSource.b Ljava/util/List;
      // 19: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1e: astore 2
      // 1f: aload 2
      // 20: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 25: ifeq 3c
      // 28: aload 2
      // 29: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2e: checkcast bolts/CancellationTokenRegistration
      // 31: invokevirtual bolts/CancellationTokenRegistration.close ()V
      // 34: goto 1f
      // 37: astore 2
      // 38: aload 1
      // 39: monitorexit
      // 3a: aload 2
      // 3b: athrow
      // 3c: aload 0
      // 3d: getfield bolts/CancellationTokenSource.b Ljava/util/List;
      // 40: invokeinterface java/util/List.clear ()V 1
      // 45: aload 0
      // 46: bipush 1
      // 47: putfield bolts/CancellationTokenSource.e Z
      // 4a: aload 1
      // 4b: monitorexit
      // 4c: goto 10
      // try (5 -> 10): 25 null
      // try (11 -> 17): 25 null
      // try (17 -> 24): 25 null
      // try (26 -> 28): 25 null
      // try (30 -> 38): 25 null
   }

   @Override
   public String toString() {
      return String.format(
         Locale.US, "%s@%s[cancellationRequested=%s]", this.getClass().getName(), Integer.toHexString(this.hashCode()), Boolean.toString(this.a())
      );
   }
}
