package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
   private static final Object f = new Object();
   private static LocalBroadcastManager g;
   private final Context a;
   private final HashMap<BroadcastReceiver, ArrayList<LocalBroadcastManager.ReceiverRecord>> b = new HashMap<>();
   private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> c = new HashMap<>();
   private final ArrayList<LocalBroadcastManager.BroadcastRecord> d = new ArrayList<>();
   private final Handler e;

   private LocalBroadcastManager(Context var1) {
      this.a = var1;
      this.e = new Handler(this, var1.getMainLooper()) {
         final LocalBroadcastManager a;

         {
            this.a = var1;
         }

         public void handleMessage(Message var1) {
            switch (var1.what) {
               case 1:
                  this.a.a();
                  break;
               default:
                  super.handleMessage(var1);
            }
         }
      };
   }

   public static LocalBroadcastManager a(Context param0) {
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
      // 00: getstatic android/support/v4/content/LocalBroadcastManager.f Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic android/support/v4/content/LocalBroadcastManager.g Landroid/support/v4/content/LocalBroadcastManager;
      // 09: ifnonnull 1c
      // 0c: new android/support/v4/content/LocalBroadcastManager
      // 0f: astore 2
      // 10: aload 2
      // 11: aload 0
      // 12: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 15: invokespecial android/support/v4/content/LocalBroadcastManager.<init> (Landroid/content/Context;)V
      // 18: aload 2
      // 19: putstatic android/support/v4/content/LocalBroadcastManager.g Landroid/support/v4/content/LocalBroadcastManager;
      // 1c: getstatic android/support/v4/content/LocalBroadcastManager.g Landroid/support/v4/content/LocalBroadcastManager;
      // 1f: astore 0
      // 20: aload 1
      // 21: monitorexit
      // 22: aload 0
      // 23: areturn
      // 24: astore 0
      // 25: aload 1
      // 26: monitorexit
      // 27: aload 0
      // 28: athrow
      // try (4 -> 14): 20 null
      // try (14 -> 18): 20 null
      // try (21 -> 23): 20 null
   }

   private void a() {
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
      // 01: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield android/support/v4/content/LocalBroadcastManager.d Ljava/util/ArrayList;
      // 0d: invokevirtual java/util/ArrayList.size ()I
      // 10: istore 1
      // 11: iload 1
      // 12: ifgt 19
      // 15: aload 5
      // 17: monitorexit
      // 18: return
      // 19: iload 1
      // 1a: anewarray 8
      // 1d: astore 4
      // 1f: aload 0
      // 20: getfield android/support/v4/content/LocalBroadcastManager.d Ljava/util/ArrayList;
      // 23: aload 4
      // 25: invokevirtual java/util/ArrayList.toArray ([Ljava/lang/Object;)[Ljava/lang/Object;
      // 28: pop
      // 29: aload 0
      // 2a: getfield android/support/v4/content/LocalBroadcastManager.d Ljava/util/ArrayList;
      // 2d: invokevirtual java/util/ArrayList.clear ()V
      // 30: aload 5
      // 32: monitorexit
      // 33: bipush 0
      // 34: istore 1
      // 35: iload 1
      // 36: aload 4
      // 38: arraylength
      // 39: if_icmpge 00
      // 3c: aload 4
      // 3e: iload 1
      // 3f: aaload
      // 40: astore 5
      // 42: aload 5
      // 44: getfield android/support/v4/content/LocalBroadcastManager$BroadcastRecord.b Ljava/util/ArrayList;
      // 47: invokevirtual java/util/ArrayList.size ()I
      // 4a: istore 3
      // 4b: bipush 0
      // 4c: istore 2
      // 4d: iload 2
      // 4e: iload 3
      // 4f: if_icmpge 87
      // 52: aload 5
      // 54: getfield android/support/v4/content/LocalBroadcastManager$BroadcastRecord.b Ljava/util/ArrayList;
      // 57: iload 2
      // 58: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 5b: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 5e: astore 6
      // 60: aload 6
      // 62: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.d Z
      // 65: ifne 79
      // 68: aload 6
      // 6a: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.b Landroid/content/BroadcastReceiver;
      // 6d: aload 0
      // 6e: getfield android/support/v4/content/LocalBroadcastManager.a Landroid/content/Context;
      // 71: aload 5
      // 73: getfield android/support/v4/content/LocalBroadcastManager$BroadcastRecord.a Landroid/content/Intent;
      // 76: invokevirtual android/content/BroadcastReceiver.onReceive (Landroid/content/Context;Landroid/content/Intent;)V
      // 79: iinc 2 1
      // 7c: goto 4d
      // 7f: astore 4
      // 81: aload 5
      // 83: monitorexit
      // 84: aload 4
      // 86: athrow
      // 87: iinc 1 1
      // 8a: goto 35
      // try (5 -> 9): 64 null
      // try (11 -> 13): 64 null
      // try (14 -> 27): 64 null
      // try (65 -> 67): 64 null
   }

   public void a(BroadcastReceiver param1) {
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
      // 01: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 0d: aload 1
      // 0e: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 11: checkcast java/util/ArrayList
      // 14: astore 7
      // 16: aload 7
      // 18: ifnonnull 1f
      // 1b: aload 5
      // 1d: monitorexit
      // 1e: return
      // 1f: aload 7
      // 21: invokevirtual java/util/ArrayList.size ()I
      // 24: bipush 1
      // 25: isub
      // 26: istore 2
      // 27: iload 2
      // 28: iflt bd
      // 2b: aload 7
      // 2d: iload 2
      // 2e: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 31: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 34: astore 8
      // 36: aload 8
      // 38: bipush 1
      // 39: putfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.d Z
      // 3c: bipush 0
      // 3d: istore 3
      // 3e: iload 3
      // 3f: aload 8
      // 41: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.a Landroid/content/IntentFilter;
      // 44: invokevirtual android/content/IntentFilter.countActions ()I
      // 47: if_icmpge b7
      // 4a: aload 8
      // 4c: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.a Landroid/content/IntentFilter;
      // 4f: iload 3
      // 50: invokevirtual android/content/IntentFilter.getAction (I)Ljava/lang/String;
      // 53: astore 6
      // 55: aload 0
      // 56: getfield android/support/v4/content/LocalBroadcastManager.c Ljava/util/HashMap;
      // 59: aload 6
      // 5b: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 5e: checkcast java/util/ArrayList
      // 61: astore 10
      // 63: aload 10
      // 65: ifnull b1
      // 68: aload 10
      // 6a: invokevirtual java/util/ArrayList.size ()I
      // 6d: bipush 1
      // 6e: isub
      // 6f: istore 4
      // 71: iload 4
      // 73: iflt 9f
      // 76: aload 10
      // 78: iload 4
      // 7a: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 7d: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 80: astore 9
      // 82: aload 9
      // 84: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.b Landroid/content/BroadcastReceiver;
      // 87: aload 1
      // 88: if_acmpne 99
      // 8b: aload 9
      // 8d: bipush 1
      // 8e: putfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.d Z
      // 91: aload 10
      // 93: iload 4
      // 95: invokevirtual java/util/ArrayList.remove (I)Ljava/lang/Object;
      // 98: pop
      // 99: iinc 4 -1
      // 9c: goto 71
      // 9f: aload 10
      // a1: invokevirtual java/util/ArrayList.size ()I
      // a4: ifgt b1
      // a7: aload 0
      // a8: getfield android/support/v4/content/LocalBroadcastManager.c Ljava/util/HashMap;
      // ab: aload 6
      // ad: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // b0: pop
      // b1: iinc 3 1
      // b4: goto 3e
      // b7: iinc 2 -1
      // ba: goto 27
      // bd: aload 5
      // bf: monitorexit
      // c0: goto 1e
      // c3: astore 1
      // c4: aload 5
      // c6: monitorexit
      // c7: aload 1
      // c8: athrow
      // try (5 -> 11): 91 null
      // try (13 -> 15): 91 null
      // try (16 -> 21): 91 null
      // try (23 -> 31): 91 null
      // try (33 -> 49): 91 null
      // try (51 -> 56): 91 null
      // try (58 -> 74): 91 null
      // try (76 -> 84): 91 null
      // try (88 -> 90): 91 null
      // try (92 -> 94): 91 null
   }

   public void a(BroadcastReceiver param1, IntentFilter param2) {
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
      // 01: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 04: astore 6
      // 06: aload 6
      // 08: monitorenter
      // 09: new android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 0c: astore 7
      // 0e: aload 7
      // 10: aload 2
      // 11: aload 1
      // 12: invokespecial android/support/v4/content/LocalBroadcastManager$ReceiverRecord.<init> (Landroid/content/IntentFilter;Landroid/content/BroadcastReceiver;)V
      // 15: aload 0
      // 16: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 19: aload 1
      // 1a: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 1d: checkcast java/util/ArrayList
      // 20: astore 5
      // 22: aload 5
      // 24: astore 4
      // 26: aload 5
      // 28: ifnonnull 41
      // 2b: new java/util/ArrayList
      // 2e: astore 4
      // 30: aload 4
      // 32: bipush 1
      // 33: invokespecial java/util/ArrayList.<init> (I)V
      // 36: aload 0
      // 37: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 3a: aload 1
      // 3b: aload 4
      // 3d: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 40: pop
      // 41: aload 4
      // 43: aload 7
      // 45: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 48: pop
      // 49: bipush 0
      // 4a: istore 3
      // 4b: iload 3
      // 4c: aload 2
      // 4d: invokevirtual android/content/IntentFilter.countActions ()I
      // 50: if_icmpge 91
      // 53: aload 2
      // 54: iload 3
      // 55: invokevirtual android/content/IntentFilter.getAction (I)Ljava/lang/String;
      // 58: astore 5
      // 5a: aload 0
      // 5b: getfield android/support/v4/content/LocalBroadcastManager.c Ljava/util/HashMap;
      // 5e: aload 5
      // 60: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 63: checkcast java/util/ArrayList
      // 66: astore 4
      // 68: aload 4
      // 6a: astore 1
      // 6b: aload 4
      // 6d: ifnonnull 84
      // 70: new java/util/ArrayList
      // 73: astore 1
      // 74: aload 1
      // 75: bipush 1
      // 76: invokespecial java/util/ArrayList.<init> (I)V
      // 79: aload 0
      // 7a: getfield android/support/v4/content/LocalBroadcastManager.c Ljava/util/HashMap;
      // 7d: aload 5
      // 7f: aload 1
      // 80: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 83: pop
      // 84: aload 1
      // 85: aload 7
      // 87: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 8a: pop
      // 8b: iinc 3 1
      // 8e: goto 4b
      // 91: aload 6
      // 93: monitorexit
      // 94: return
      // 95: astore 1
      // 96: aload 6
      // 98: monitorexit
      // 99: aload 1
      // 9a: athrow
      // try (5 -> 17): 76 null
      // try (21 -> 32): 76 null
      // try (32 -> 36): 76 null
      // try (38 -> 52): 76 null
      // try (56 -> 67): 76 null
      // try (67 -> 71): 76 null
      // try (73 -> 75): 76 null
      // try (77 -> 79): 76 null
   }

   public boolean a(Intent param1) {
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
      // 000: aload 0
      // 001: getfield android/support/v4/content/LocalBroadcastManager.b Ljava/util/HashMap;
      // 004: astore 8
      // 006: aload 8
      // 008: monitorenter
      // 009: aload 1
      // 00a: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 00d: astore 12
      // 00f: aload 1
      // 010: aload 0
      // 011: getfield android/support/v4/content/LocalBroadcastManager.a Landroid/content/Context;
      // 014: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 017: invokevirtual android/content/Intent.resolveTypeIfNeeded (Landroid/content/ContentResolver;)Ljava/lang/String;
      // 01a: astore 13
      // 01c: aload 1
      // 01d: invokevirtual android/content/Intent.getData ()Landroid/net/Uri;
      // 020: astore 9
      // 022: aload 1
      // 023: invokevirtual android/content/Intent.getScheme ()Ljava/lang/String;
      // 026: astore 10
      // 028: aload 1
      // 029: invokevirtual android/content/Intent.getCategories ()Ljava/util/Set;
      // 02c: astore 11
      // 02e: aload 1
      // 02f: invokevirtual android/content/Intent.getFlags ()I
      // 032: bipush 8
      // 034: iand
      // 035: ifeq 101
      // 038: bipush 1
      // 039: istore 2
      // 03a: iload 2
      // 03b: ifeq 070
      // 03e: new java/lang/StringBuilder
      // 041: astore 6
      // 043: aload 6
      // 045: invokespecial java/lang/StringBuilder.<init> ()V
      // 048: ldc "LocalBroadcastManager"
      // 04a: aload 6
      // 04c: ldc "Resolving type "
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: aload 13
      // 053: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 056: ldc " scheme "
      // 058: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05b: aload 10
      // 05d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 060: ldc " of intent "
      // 062: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 065: aload 1
      // 066: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 069: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 06c: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 06f: pop
      // 070: aload 0
      // 071: getfield android/support/v4/content/LocalBroadcastManager.c Ljava/util/HashMap;
      // 074: aload 1
      // 075: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 078: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 07b: checkcast java/util/ArrayList
      // 07e: astore 14
      // 080: aload 14
      // 082: ifnull 22d
      // 085: iload 2
      // 086: ifeq 0a8
      // 089: new java/lang/StringBuilder
      // 08c: astore 6
      // 08e: aload 6
      // 090: invokespecial java/lang/StringBuilder.<init> ()V
      // 093: ldc "LocalBroadcastManager"
      // 095: aload 6
      // 097: ldc "Action list: "
      // 099: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09c: aload 14
      // 09e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0a1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0a4: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0a7: pop
      // 0a8: aconst_null
      // 0a9: astore 6
      // 0ab: bipush 0
      // 0ac: istore 3
      // 0ad: iload 3
      // 0ae: aload 14
      // 0b0: invokevirtual java/util/ArrayList.size ()I
      // 0b3: if_icmpge 1d2
      // 0b6: aload 14
      // 0b8: iload 3
      // 0b9: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 0bc: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 0bf: astore 7
      // 0c1: iload 2
      // 0c2: ifeq 0e7
      // 0c5: new java/lang/StringBuilder
      // 0c8: astore 15
      // 0ca: aload 15
      // 0cc: invokespecial java/lang/StringBuilder.<init> ()V
      // 0cf: ldc "LocalBroadcastManager"
      // 0d1: aload 15
      // 0d3: ldc "Matching against filter "
      // 0d5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d8: aload 7
      // 0da: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.a Landroid/content/IntentFilter;
      // 0dd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0e0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e3: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0e6: pop
      // 0e7: aload 7
      // 0e9: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.c Z
      // 0ec: ifeq 106
      // 0ef: iload 2
      // 0f0: ifeq 1b3
      // 0f3: ldc "LocalBroadcastManager"
      // 0f5: ldc "  Filter's target already added"
      // 0f7: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0fa: pop
      // 0fb: iinc 3 1
      // 0fe: goto 0ad
      // 101: bipush 0
      // 102: istore 2
      // 103: goto 03a
      // 106: aload 7
      // 108: getfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.a Landroid/content/IntentFilter;
      // 10b: aload 12
      // 10d: aload 13
      // 10f: aload 10
      // 111: aload 9
      // 113: aload 11
      // 115: ldc "LocalBroadcastManager"
      // 117: invokevirtual android/content/IntentFilter.match (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Set;Ljava/lang/String;)I
      // 11a: istore 4
      // 11c: iload 4
      // 11e: iflt 16d
      // 121: iload 2
      // 122: ifeq 147
      // 125: new java/lang/StringBuilder
      // 128: astore 15
      // 12a: aload 15
      // 12c: invokespecial java/lang/StringBuilder.<init> ()V
      // 12f: ldc "LocalBroadcastManager"
      // 131: aload 15
      // 133: ldc "  Filter matched!  match=0x"
      // 135: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 138: iload 4
      // 13a: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 13d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 140: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 143: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 146: pop
      // 147: aload 6
      // 149: ifnonnull 236
      // 14c: new java/util/ArrayList
      // 14f: astore 6
      // 151: aload 6
      // 153: invokespecial java/util/ArrayList.<init> ()V
      // 156: aload 6
      // 158: aload 7
      // 15a: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 15d: pop
      // 15e: aload 7
      // 160: bipush 1
      // 161: putfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.c Z
      // 164: goto 0fb
      // 167: astore 1
      // 168: aload 8
      // 16a: monitorexit
      // 16b: aload 1
      // 16c: athrow
      // 16d: iload 2
      // 16e: ifeq 1b3
      // 171: iload 4
      // 173: tableswitch 29 -4 -1 74 67 81 88
      // 190: ldc "unknown reason"
      // 192: astore 7
      // 194: new java/lang/StringBuilder
      // 197: astore 15
      // 199: aload 15
      // 19b: invokespecial java/lang/StringBuilder.<init> ()V
      // 19e: ldc "LocalBroadcastManager"
      // 1a0: aload 15
      // 1a2: ldc "  Filter did not match: "
      // 1a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a7: aload 7
      // 1a9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ac: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1af: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 1b2: pop
      // 1b3: goto 0fb
      // 1b6: ldc "action"
      // 1b8: astore 7
      // 1ba: goto 194
      // 1bd: ldc "category"
      // 1bf: astore 7
      // 1c1: goto 194
      // 1c4: ldc "data"
      // 1c6: astore 7
      // 1c8: goto 194
      // 1cb: ldc "type"
      // 1cd: astore 7
      // 1cf: goto 194
      // 1d2: aload 6
      // 1d4: ifnull 22d
      // 1d7: bipush 0
      // 1d8: istore 2
      // 1d9: iload 2
      // 1da: aload 6
      // 1dc: invokevirtual java/util/ArrayList.size ()I
      // 1df: if_icmpge 1f5
      // 1e2: aload 6
      // 1e4: iload 2
      // 1e5: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 1e8: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
      // 1eb: bipush 0
      // 1ec: putfield android/support/v4/content/LocalBroadcastManager$ReceiverRecord.c Z
      // 1ef: iinc 2 1
      // 1f2: goto 1d9
      // 1f5: aload 0
      // 1f6: getfield android/support/v4/content/LocalBroadcastManager.d Ljava/util/ArrayList;
      // 1f9: astore 7
      // 1fb: new android/support/v4/content/LocalBroadcastManager$BroadcastRecord
      // 1fe: astore 9
      // 200: aload 9
      // 202: aload 1
      // 203: aload 6
      // 205: invokespecial android/support/v4/content/LocalBroadcastManager$BroadcastRecord.<init> (Landroid/content/Intent;Ljava/util/ArrayList;)V
      // 208: aload 7
      // 20a: aload 9
      // 20c: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 20f: pop
      // 210: aload 0
      // 211: getfield android/support/v4/content/LocalBroadcastManager.e Landroid/os/Handler;
      // 214: bipush 1
      // 215: invokevirtual android/os/Handler.hasMessages (I)Z
      // 218: ifne 224
      // 21b: aload 0
      // 21c: getfield android/support/v4/content/LocalBroadcastManager.e Landroid/os/Handler;
      // 21f: bipush 1
      // 220: invokevirtual android/os/Handler.sendEmptyMessage (I)Z
      // 223: pop
      // 224: bipush 1
      // 225: istore 5
      // 227: aload 8
      // 229: monitorexit
      // 22a: iload 5
      // 22c: ireturn
      // 22d: aload 8
      // 22f: monitorexit
      // 230: bipush 0
      // 231: istore 5
      // 233: goto 22a
      // 236: goto 156
      // try (5 -> 28): 162 null
      // try (32 -> 53): 162 null
      // try (53 -> 60): 162 null
      // try (64 -> 77): 162 null
      // try (81 -> 90): 162 null
      // try (92 -> 106): 162 null
      // try (106 -> 109): 162 null
      // try (111 -> 115): 162 null
      // try (120 -> 130): 162 null
      // try (134 -> 148): 162 null
      // try (150 -> 154): 162 null
      // try (154 -> 161): 162 null
      // try (163 -> 165): 162 null
      // try (173 -> 186): 162 null
      // try (203 -> 213): 162 null
      // try (215 -> 238): 162 null
      // try (240 -> 242): 162 null
      // try (244 -> 246): 162 null
   }

   private static final class BroadcastRecord {
      final Intent a;
      final ArrayList<LocalBroadcastManager.ReceiverRecord> b;

      BroadcastRecord(Intent var1, ArrayList<LocalBroadcastManager.ReceiverRecord> var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   private static final class ReceiverRecord {
      final IntentFilter a;
      final BroadcastReceiver b;
      boolean c;
      boolean d;

      ReceiverRecord(IntentFilter var1, BroadcastReceiver var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder(128);
         var1.append("Receiver{");
         var1.append(this.b);
         var1.append(" filter=");
         var1.append(this.a);
         if (this.d) {
            var1.append(" DEAD");
         }

         var1.append("}");
         return var1.toString();
      }
   }
}
