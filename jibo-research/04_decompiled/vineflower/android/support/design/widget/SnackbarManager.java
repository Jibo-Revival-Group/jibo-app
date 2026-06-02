package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager {
   private static SnackbarManager a;
   private final Object b = new Object();
   private final Handler c = new Handler(Looper.getMainLooper(), new android.os.Handler.Callback(this) {
      final SnackbarManager a;

      {
         this.a = var1;
      }

      public boolean handleMessage(Message var1) {
         boolean var2;
         switch (var1.what) {
            case 0:
               this.a.a((SnackbarManager.SnackbarRecord)var1.obj);
               var2 = true;
               break;
            default:
               var2 = false;
         }

         return var2;
      }
   });
   private SnackbarManager.SnackbarRecord d;
   private SnackbarManager.SnackbarRecord e;

   private SnackbarManager() {
   }

   static SnackbarManager a() {
      if (a == null) {
         a = new SnackbarManager();
      }

      return a;
   }

   private boolean a(SnackbarManager.SnackbarRecord var1, int var2) {
      SnackbarManager.Callback var4 = var1.a.get();
      boolean var3;
      if (var4 != null) {
         this.c.removeCallbacksAndMessages(var1);
         var4.a(var2);
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private void b() {
      if (this.e != null) {
         this.d = this.e;
         this.e = null;
         SnackbarManager.Callback var1 = this.d.a.get();
         if (var1 != null) {
            var1.a();
         } else {
            this.d = null;
         }
      }
   }

   private void b(SnackbarManager.SnackbarRecord var1) {
      if (var1.b != -2) {
         int var2 = 2750;
         if (var1.b > 0) {
            var2 = var1.b;
         } else if (var1.b == -1) {
            var2 = 1500;
         }

         this.c.removeCallbacksAndMessages(var1);
         this.c.sendMessageDelayed(Message.obtain(this.c, 0, var1), var2);
      }
   }

   private boolean g(SnackbarManager.Callback var1) {
      boolean var2;
      if (this.d != null && this.d.a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private boolean h(SnackbarManager.Callback var1) {
      boolean var2;
      if (this.e != null && this.e.a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void a(int param1, SnackbarManager.Callback param2) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 2
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 2d
      // 0f: aload 0
      // 10: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 13: iload 1
      // 14: putfield android/support/design/widget/SnackbarManager$SnackbarRecord.b I
      // 17: aload 0
      // 18: getfield android/support/design/widget/SnackbarManager.c Landroid/os/Handler;
      // 1b: aload 0
      // 1c: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 1f: invokevirtual android/os/Handler.removeCallbacksAndMessages (Ljava/lang/Object;)V
      // 22: aload 0
      // 23: aload 0
      // 24: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 27: invokespecial android/support/design/widget/SnackbarManager.b (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;)V
      // 2a: aload 3
      // 2b: monitorexit
      // 2c: return
      // 2d: aload 0
      // 2e: aload 2
      // 2f: invokespecial android/support/design/widget/SnackbarManager.h (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 32: ifeq 5a
      // 35: aload 0
      // 36: getfield android/support/design/widget/SnackbarManager.e Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 39: iload 1
      // 3a: putfield android/support/design/widget/SnackbarManager$SnackbarRecord.b I
      // 3d: aload 0
      // 3e: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 41: ifnull 6f
      // 44: aload 0
      // 45: aload 0
      // 46: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 49: bipush 4
      // 4a: invokespecial android/support/design/widget/SnackbarManager.a (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;I)Z
      // 4d: ifeq 6f
      // 50: aload 3
      // 51: monitorexit
      // 52: goto 2c
      // 55: astore 2
      // 56: aload 3
      // 57: monitorexit
      // 58: aload 2
      // 59: athrow
      // 5a: new android/support/design/widget/SnackbarManager$SnackbarRecord
      // 5d: astore 4
      // 5f: aload 4
      // 61: iload 1
      // 62: aload 2
      // 63: invokespecial android/support/design/widget/SnackbarManager$SnackbarRecord.<init> (ILandroid/support/design/widget/SnackbarManager$Callback;)V
      // 66: aload 0
      // 67: aload 4
      // 69: putfield android/support/design/widget/SnackbarManager.e Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 6c: goto 3d
      // 6f: aload 0
      // 70: aconst_null
      // 71: putfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 74: aload 0
      // 75: invokespecial android/support/design/widget/SnackbarManager.b ()V
      // 78: aload 3
      // 79: monitorexit
      // 7a: goto 2c
      // try (5 -> 24): 45 null
      // try (25 -> 33): 45 null
      // try (33 -> 44): 45 null
      // try (46 -> 48): 45 null
      // try (50 -> 59): 45 null
      // try (60 -> 67): 45 null
   }

   public void a(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 1f
      // 0f: aload 0
      // 10: aconst_null
      // 11: putfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 14: aload 0
      // 15: getfield android/support/design/widget/SnackbarManager.e Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 18: ifnull 1f
      // 1b: aload 0
      // 1c: invokespecial android/support/design/widget/SnackbarManager.b ()V
      // 1f: aload 2
      // 20: monitorexit
      // 21: return
      // 22: astore 1
      // 23: aload 2
      // 24: monitorexit
      // 25: aload 1
      // 26: athrow
      // try (5 -> 17): 20 null
      // try (17 -> 19): 20 null
      // try (21 -> 23): 20 null
   }

   public void a(SnackbarManager.Callback param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 1c
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 14: iload 2
      // 15: invokespecial android/support/design/widget/SnackbarManager.a (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;I)Z
      // 18: pop
      // 19: aload 3
      // 1a: monitorexit
      // 1b: return
      // 1c: aload 0
      // 1d: aload 1
      // 1e: invokespecial android/support/design/widget/SnackbarManager.h (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 21: ifeq 19
      // 24: aload 0
      // 25: aload 0
      // 26: getfield android/support/design/widget/SnackbarManager.e Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 29: iload 2
      // 2a: invokespecial android/support/design/widget/SnackbarManager.a (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;I)Z
      // 2d: pop
      // 2e: goto 19
      // 31: astore 1
      // 32: aload 3
      // 33: monitorexit
      // 34: aload 1
      // 35: athrow
      // try (5 -> 15): 29 null
      // try (15 -> 17): 29 null
      // try (18 -> 28): 29 null
      // try (30 -> 32): 29 null
   }

   void a(SnackbarManager.SnackbarRecord param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 0b: aload 1
      // 0c: if_acmpeq 17
      // 0f: aload 0
      // 10: getfield android/support/design/widget/SnackbarManager.e Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 13: aload 1
      // 14: if_acmpne 1e
      // 17: aload 0
      // 18: aload 1
      // 19: bipush 2
      // 1a: invokespecial android/support/design/widget/SnackbarManager.a (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;I)Z
      // 1d: pop
      // 1e: aload 2
      // 1f: monitorexit
      // 20: return
      // 21: astore 1
      // 22: aload 2
      // 23: monitorexit
      // 24: aload 1
      // 25: athrow
      // try (5 -> 13): 21 null
      // try (13 -> 18): 21 null
      // try (18 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   public void b(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 17
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 14: invokespecial android/support/design/widget/SnackbarManager.b (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;)V
      // 17: aload 2
      // 18: monitorexit
      // 19: return
      // 1a: astore 1
      // 1b: aload 2
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (5 -> 13): 16 null
      // try (13 -> 15): 16 null
      // try (17 -> 19): 16 null
   }

   public void c(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 2c
      // 0f: aload 0
      // 10: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 13: getfield android/support/design/widget/SnackbarManager$SnackbarRecord.c Z
      // 16: ifne 2c
      // 19: aload 0
      // 1a: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 1d: bipush 1
      // 1e: putfield android/support/design/widget/SnackbarManager$SnackbarRecord.c Z
      // 21: aload 0
      // 22: getfield android/support/design/widget/SnackbarManager.c Landroid/os/Handler;
      // 25: aload 0
      // 26: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 29: invokevirtual android/os/Handler.removeCallbacksAndMessages (Ljava/lang/Object;)V
      // 2c: aload 2
      // 2d: monitorexit
      // 2e: return
      // 2f: astore 1
      // 30: aload 2
      // 31: monitorexit
      // 32: aload 1
      // 33: athrow
      // try (5 -> 22): 25 null
      // try (22 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   public void d(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifeq 29
      // 0f: aload 0
      // 10: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 13: getfield android/support/design/widget/SnackbarManager$SnackbarRecord.c Z
      // 16: ifeq 29
      // 19: aload 0
      // 1a: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 1d: bipush 0
      // 1e: putfield android/support/design/widget/SnackbarManager$SnackbarRecord.c Z
      // 21: aload 0
      // 22: aload 0
      // 23: getfield android/support/design/widget/SnackbarManager.d Landroid/support/design/widget/SnackbarManager$SnackbarRecord;
      // 26: invokespecial android/support/design/widget/SnackbarManager.b (Landroid/support/design/widget/SnackbarManager$SnackbarRecord;)V
      // 29: aload 2
      // 2a: monitorexit
      // 2b: return
      // 2c: astore 1
      // 2d: aload 2
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // try (5 -> 21): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
   }

   public boolean e(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: istore 2
      // 0d: aload 3
      // 0e: monitorexit
      // 0f: iload 2
      // 10: ireturn
      // 11: astore 1
      // 12: aload 3
      // 13: monitorexit
      // 14: aload 1
      // 15: athrow
      // try (5 -> 11): 13 null
      // try (14 -> 16): 13 null
   }

   public boolean f(SnackbarManager.Callback param1) {
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
      // 01: getfield android/support/design/widget/SnackbarManager.b Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial android/support/design/widget/SnackbarManager.g (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 0c: ifne 17
      // 0f: aload 0
      // 10: aload 1
      // 11: invokespecial android/support/design/widget/SnackbarManager.h (Landroid/support/design/widget/SnackbarManager$Callback;)Z
      // 14: ifeq 1d
      // 17: bipush 1
      // 18: istore 2
      // 19: aload 3
      // 1a: monitorexit
      // 1b: iload 2
      // 1c: ireturn
      // 1d: bipush 0
      // 1e: istore 2
      // 1f: goto 19
      // 22: astore 1
      // 23: aload 3
      // 24: monitorexit
      // 25: aload 1
      // 26: athrow
      // try (5 -> 13): 22 null
      // try (15 -> 17): 22 null
      // try (23 -> 25): 22 null
   }

   interface Callback {
      void a();

      void a(int var1);
   }

   private static class SnackbarRecord {
      final WeakReference<SnackbarManager.Callback> a;
      int b;
      boolean c;

      SnackbarRecord(int var1, SnackbarManager.Callback var2) {
         this.a = new WeakReference<>(var2);
         this.b = var1;
      }

      boolean a(SnackbarManager.Callback var1) {
         boolean var2;
         if (var1 != null && this.a.get() == var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
