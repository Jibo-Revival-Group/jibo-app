package android.arch.core.executor;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {
   private static volatile ArchTaskExecutor a;
   private static final Executor d = new Executor() {
      @Override
      public void execute(Runnable var1) {
         ArchTaskExecutor.a().b(var1);
      }
   };
   private static final Executor e = new Executor() {
      @Override
      public void execute(Runnable var1) {
         ArchTaskExecutor.a().a(var1);
      }
   };
   private TaskExecutor b;
   private TaskExecutor c = new DefaultTaskExecutor();

   private ArchTaskExecutor() {
      this.b = this.c;
   }

   public static ArchTaskExecutor a() {
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
      // 00: getstatic android/arch/core/executor/ArchTaskExecutor.a Landroid/arch/core/executor/ArchTaskExecutor;
      // 03: ifnull 0c
      // 06: getstatic android/arch/core/executor/ArchTaskExecutor.a Landroid/arch/core/executor/ArchTaskExecutor;
      // 09: astore 0
      // 0a: aload 0
      // 0b: areturn
      // 0c: ldc android/arch/core/executor/ArchTaskExecutor
      // 0e: monitorenter
      // 0f: getstatic android/arch/core/executor/ArchTaskExecutor.a Landroid/arch/core/executor/ArchTaskExecutor;
      // 12: ifnonnull 21
      // 15: new android/arch/core/executor/ArchTaskExecutor
      // 18: astore 0
      // 19: aload 0
      // 1a: invokespecial android/arch/core/executor/ArchTaskExecutor.<init> ()V
      // 1d: aload 0
      // 1e: putstatic android/arch/core/executor/ArchTaskExecutor.a Landroid/arch/core/executor/ArchTaskExecutor;
      // 21: ldc android/arch/core/executor/ArchTaskExecutor
      // 23: monitorexit
      // 24: getstatic android/arch/core/executor/ArchTaskExecutor.a Landroid/arch/core/executor/ArchTaskExecutor;
      // 27: astore 0
      // 28: goto 0a
      // 2b: astore 0
      // 2c: ldc android/arch/core/executor/ArchTaskExecutor
      // 2e: monitorexit
      // 2f: aload 0
      // 30: athrow
      // try (8 -> 16): 21 null
      // try (16 -> 18): 21 null
      // try (22 -> 24): 21 null
   }

   @Override
   public void a(Runnable var1) {
      this.b.a(var1);
   }

   @Override
   public void b(Runnable var1) {
      this.b.b(var1);
   }

   @Override
   public boolean b() {
      return this.b.b();
   }
}
