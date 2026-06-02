package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors {
   private static final BoltsExecutors a = new BoltsExecutors();
   private final ExecutorService b;
   private final ScheduledExecutorService c;
   private final Executor d;

   private BoltsExecutors() {
      ExecutorService var1;
      if (!c()) {
         var1 = Executors.newCachedThreadPool();
      } else {
         var1 = AndroidExecutors.a();
      }

      this.b = var1;
      this.c = Executors.newSingleThreadScheduledExecutor();
      this.d = new BoltsExecutors.ImmediateExecutor();
   }

   public static ExecutorService a() {
      return a.b;
   }

   static Executor b() {
      return a.d;
   }

   private static boolean c() {
      String var1 = System.getProperty("java.runtime.name");
      boolean var0;
      if (var1 == null) {
         var0 = false;
      } else {
         var0 = var1.toLowerCase(Locale.US).contains("android");
      }

      return var0;
   }

   private static class ImmediateExecutor implements Executor {
      private ThreadLocal<Integer> a = new ThreadLocal<>();

      private ImmediateExecutor() {
      }

      private int a() {
         Integer var3 = this.a.get();
         Integer var2 = var3;
         if (var3 == null) {
            var2 = 0;
         }

         int var1 = var2 + 1;
         this.a.set(var1);
         return var1;
      }

      private int b() {
         Integer var3 = this.a.get();
         Integer var2 = var3;
         if (var3 == null) {
            var2 = 0;
         }

         int var1 = var2 - 1;
         if (var1 == 0) {
            this.a.remove();
         } else {
            this.a.set(var1);
         }

         return var1;
      }

      @Override
      public void execute(Runnable param1) {
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
         // 01: invokespecial bolts/BoltsExecutors$ImmediateExecutor.a ()I
         // 04: bipush 15
         // 06: if_icmpgt 15
         // 09: aload 1
         // 0a: invokeinterface java/lang/Runnable.run ()V 1
         // 0f: aload 0
         // 10: invokespecial bolts/BoltsExecutors$ImmediateExecutor.b ()I
         // 13: pop
         // 14: return
         // 15: invokestatic bolts/BoltsExecutors.a ()Ljava/util/concurrent/ExecutorService;
         // 18: aload 1
         // 19: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
         // 1e: goto 0f
         // 21: astore 1
         // 22: aload 0
         // 23: invokespecial bolts/BoltsExecutors$ImmediateExecutor.b ()I
         // 26: pop
         // 27: aload 1
         // 28: athrow
         // try (4 -> 6): 14 null
         // try (10 -> 13): 14 null
      }
   }
}
