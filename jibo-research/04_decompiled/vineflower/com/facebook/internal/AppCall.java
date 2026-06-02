package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

public class AppCall {
   private static AppCall currentPendingCall;
   private UUID callId;
   private int requestCode;
   private Intent requestIntent;

   public AppCall(int var1) {
      this(var1, UUID.randomUUID());
   }

   public AppCall(int var1, UUID var2) {
      this.callId = var2;
      this.requestCode = var1;
   }

   public static AppCall finishPendingCall(UUID param0, int param1) {
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
      // 00: ldc com/facebook/internal/AppCall
      // 02: monitorenter
      // 03: invokestatic com/facebook/internal/AppCall.getCurrentPendingCall ()Lcom/facebook/internal/AppCall;
      // 06: astore 3
      // 07: aload 3
      // 08: ifnull 20
      // 0b: aload 3
      // 0c: invokevirtual com/facebook/internal/AppCall.getCallId ()Ljava/util/UUID;
      // 0f: aload 0
      // 10: invokevirtual java/util/UUID.equals (Ljava/lang/Object;)Z
      // 13: ifeq 20
      // 16: aload 3
      // 17: invokevirtual com/facebook/internal/AppCall.getRequestCode ()I
      // 1a: istore 2
      // 1b: iload 2
      // 1c: iload 1
      // 1d: if_icmpeq 27
      // 20: aconst_null
      // 21: astore 0
      // 22: ldc com/facebook/internal/AppCall
      // 24: monitorexit
      // 25: aload 0
      // 26: areturn
      // 27: aconst_null
      // 28: invokestatic com/facebook/internal/AppCall.setCurrentPendingCall (Lcom/facebook/internal/AppCall;)Z
      // 2b: pop
      // 2c: aload 3
      // 2d: astore 0
      // 2e: goto 22
      // 31: astore 0
      // 32: ldc com/facebook/internal/AppCall
      // 34: monitorexit
      // 35: aload 0
      // 36: athrow
      // try (2 -> 4): 29 null
      // try (6 -> 14): 29 null
      // try (23 -> 26): 29 null
   }

   public static AppCall getCurrentPendingCall() {
      return currentPendingCall;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static boolean setCurrentPendingCall(AppCall var0) {
      synchronized (AppCall.class){} // $VF: monitorenter 
      boolean var4 = false /* VF: Semaphore variable */;

      AppCall var2;
      try {
         var4 = true;
         var2 = getCurrentPendingCall();
         currentPendingCall = var0;
         var4 = false;
      } finally {
         if (var4) {
            // $VF: monitorexit
         }
      }

      boolean var1;
      if (var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      // $VF: monitorexit
      return var1;
   }

   public UUID getCallId() {
      return this.callId;
   }

   public int getRequestCode() {
      return this.requestCode;
   }

   public Intent getRequestIntent() {
      return this.requestIntent;
   }

   public boolean setPending() {
      return setCurrentPendingCall(this);
   }

   public void setRequestCode(int var1) {
      this.requestCode = var1;
   }

   public void setRequestIntent(Intent var1) {
      this.requestIntent = var1;
   }
}
