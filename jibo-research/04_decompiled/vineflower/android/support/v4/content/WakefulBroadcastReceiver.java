package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
   private static final SparseArray<WakeLock> a = new SparseArray();
   private static int b = 1;

   public static boolean a(Intent param0) {
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
      // 03: ldc "android.support.content.wakelockid"
      // 05: bipush 0
      // 06: invokevirtual android/content/Intent.getIntExtra (Ljava/lang/String;I)I
      // 09: istore 1
      // 0a: iload 1
      // 0b: ifne 10
      // 0e: iload 2
      // 0f: ireturn
      // 10: getstatic android/support/v4/content/WakefulBroadcastReceiver.a Landroid/util/SparseArray;
      // 13: astore 0
      // 14: aload 0
      // 15: monitorenter
      // 16: getstatic android/support/v4/content/WakefulBroadcastReceiver.a Landroid/util/SparseArray;
      // 19: iload 1
      // 1a: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 1d: checkcast android/os/PowerManager$WakeLock
      // 20: astore 3
      // 21: aload 3
      // 22: ifnull 37
      // 25: aload 3
      // 26: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // 29: getstatic android/support/v4/content/WakefulBroadcastReceiver.a Landroid/util/SparseArray;
      // 2c: iload 1
      // 2d: invokevirtual android/util/SparseArray.remove (I)V
      // 30: aload 0
      // 31: monitorexit
      // 32: bipush 1
      // 33: istore 2
      // 34: goto 0e
      // 37: new java/lang/StringBuilder
      // 3a: astore 3
      // 3b: aload 3
      // 3c: invokespecial java/lang/StringBuilder.<init> ()V
      // 3f: ldc "WakefulBroadcastReceiv."
      // 41: aload 3
      // 42: ldc "No active wake lock id #"
      // 44: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 47: iload 1
      // 48: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 4b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4e: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 51: pop
      // 52: aload 0
      // 53: monitorexit
      // 54: bipush 1
      // 55: istore 2
      // 56: goto 0e
      // 59: astore 3
      // 5a: aload 0
      // 5b: monitorexit
      // 5c: aload 3
      // 5d: athrow
      // try (15 -> 20): 50 null
      // try (22 -> 29): 50 null
      // try (32 -> 47): 50 null
      // try (51 -> 53): 50 null
   }

   public static ComponentName a_(Context param0, Intent param1) {
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
      // 00: getstatic android/support/v4/content/WakefulBroadcastReceiver.a Landroid/util/SparseArray;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic android/support/v4/content/WakefulBroadcastReceiver.b I
      // 09: istore 2
      // 0a: getstatic android/support/v4/content/WakefulBroadcastReceiver.b I
      // 0d: bipush 1
      // 0e: iadd
      // 0f: putstatic android/support/v4/content/WakefulBroadcastReceiver.b I
      // 12: getstatic android/support/v4/content/WakefulBroadcastReceiver.b I
      // 15: ifgt 1c
      // 18: bipush 1
      // 19: putstatic android/support/v4/content/WakefulBroadcastReceiver.b I
      // 1c: aload 1
      // 1d: ldc "android.support.content.wakelockid"
      // 1f: iload 2
      // 20: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;I)Landroid/content/Intent;
      // 23: pop
      // 24: aload 0
      // 25: aload 1
      // 26: invokevirtual android/content/Context.startService (Landroid/content/Intent;)Landroid/content/ComponentName;
      // 29: astore 1
      // 2a: aload 1
      // 2b: ifnonnull 34
      // 2e: aconst_null
      // 2f: astore 0
      // 30: aload 3
      // 31: monitorexit
      // 32: aload 0
      // 33: areturn
      // 34: aload 0
      // 35: ldc "power"
      // 37: invokevirtual android/content/Context.getSystemService (Ljava/lang/String;)Ljava/lang/Object;
      // 3a: checkcast android/os/PowerManager
      // 3d: astore 0
      // 3e: new java/lang/StringBuilder
      // 41: astore 4
      // 43: aload 4
      // 45: invokespecial java/lang/StringBuilder.<init> ()V
      // 48: aload 0
      // 49: bipush 1
      // 4a: aload 4
      // 4c: ldc "wake:"
      // 4e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 51: aload 1
      // 52: invokevirtual android/content/ComponentName.flattenToShortString ()Ljava/lang/String;
      // 55: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 58: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 5b: invokevirtual android/os/PowerManager.newWakeLock (ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
      // 5e: astore 0
      // 5f: aload 0
      // 60: bipush 0
      // 61: invokevirtual android/os/PowerManager$WakeLock.setReferenceCounted (Z)V
      // 64: aload 0
      // 65: ldc2_w 60000
      // 68: invokevirtual android/os/PowerManager$WakeLock.acquire (J)V
      // 6b: getstatic android/support/v4/content/WakefulBroadcastReceiver.a Landroid/util/SparseArray;
      // 6e: iload 2
      // 6f: aload 0
      // 70: invokevirtual android/util/SparseArray.put (ILjava/lang/Object;)V
      // 73: aload 3
      // 74: monitorexit
      // 75: aload 1
      // 76: astore 0
      // 77: goto 32
      // 7a: astore 0
      // 7b: aload 3
      // 7c: monitorexit
      // 7d: aload 0
      // 7e: athrow
      // try (4 -> 14): 66 null
      // try (14 -> 23): 66 null
      // try (27 -> 29): 66 null
      // try (31 -> 63): 66 null
      // try (67 -> 69): 66 null
   }
}
