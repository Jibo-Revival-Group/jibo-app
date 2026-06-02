package bolts;

class UnobservedErrorNotifier {
   private Task<?> a;

   public UnobservedErrorNotifier(Task<?> var1) {
      this.a = var1;
   }

   public void a() {
      this.a = null;
   }

   @Override
   protected void finalize() throws Throwable {
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
      // 01: getfield bolts/UnobservedErrorNotifier.a Lbolts/Task;
      // 04: astore 2
      // 05: aload 2
      // 06: ifnull 25
      // 09: invokestatic bolts/Task.a ()Lbolts/Task$UnobservedExceptionHandler;
      // 0c: astore 3
      // 0d: aload 3
      // 0e: ifnull 25
      // 11: new bolts/UnobservedTaskException
      // 14: astore 1
      // 15: aload 1
      // 16: aload 2
      // 17: invokevirtual bolts/Task.g ()Ljava/lang/Exception;
      // 1a: invokespecial bolts/UnobservedTaskException.<init> (Ljava/lang/Throwable;)V
      // 1d: aload 3
      // 1e: aload 2
      // 1f: aload 1
      // 20: invokeinterface bolts/Task$UnobservedExceptionHandler.a (Lbolts/Task;Lbolts/UnobservedTaskException;)V 3
      // 25: aload 0
      // 26: invokespecial java/lang/Object.finalize ()V
      // 29: return
      // 2a: astore 1
      // 2b: aload 0
      // 2c: invokespecial java/lang/Object.finalize ()V
      // 2f: aload 1
      // 30: athrow
      // try (0 -> 3): 22 null
      // try (5 -> 7): 22 null
      // try (9 -> 19): 22 null
   }
}
