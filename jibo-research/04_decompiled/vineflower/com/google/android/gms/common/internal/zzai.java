package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import java.util.HashMap;

final class zzai extends zzag implements Callback {
   private final HashMap<zzah, zzaj> a = new HashMap<>();
   private final Context b;
   private final Handler c;
   private final com.google.android.gms.common.stats.zza d;
   private final long e;
   private final long f;

   zzai(Context var1) {
      this.b = var1.getApplicationContext();
      this.c = new Handler(var1.getMainLooper(), this);
      this.d = com.google.android.gms.common.stats.zza.a();
      this.e = 5000L;
      this.f = 300000L;
   }

   @Override
   protected final boolean a(zzah param1, ServiceConnection param2, String param3) {
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
      // 00: aload 2
      // 01: ldc "ServiceConnection must not be null"
      // 03: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 06: pop
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 0b: astore 7
      // 0d: aload 7
      // 0f: monitorenter
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 14: aload 1
      // 15: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 18: checkcast com/google/android/gms/common/internal/zzaj
      // 1b: astore 6
      // 1d: aload 6
      // 1f: ifnonnull 55
      // 22: new com/google/android/gms/common/internal/zzaj
      // 25: astore 6
      // 27: aload 6
      // 29: aload 0
      // 2a: aload 1
      // 2b: invokespecial com/google/android/gms/common/internal/zzaj.<init> (Lcom/google/android/gms/common/internal/zzai;Lcom/google/android/gms/common/internal/zzah;)V
      // 2e: aload 6
      // 30: aload 2
      // 31: aload 3
      // 32: invokevirtual com/google/android/gms/common/internal/zzaj.a (Landroid/content/ServiceConnection;Ljava/lang/String;)V
      // 35: aload 6
      // 37: aload 3
      // 38: invokevirtual com/google/android/gms/common/internal/zzaj.a (Ljava/lang/String;)V
      // 3b: aload 0
      // 3c: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 3f: aload 1
      // 40: aload 6
      // 42: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 45: pop
      // 46: aload 6
      // 48: astore 1
      // 49: aload 1
      // 4a: invokevirtual com/google/android/gms/common/internal/zzaj.a ()Z
      // 4d: istore 5
      // 4f: aload 7
      // 51: monitorexit
      // 52: iload 5
      // 54: ireturn
      // 55: aload 0
      // 56: getfield com/google/android/gms/common/internal/zzai.c Landroid/os/Handler;
      // 59: bipush 0
      // 5a: aload 1
      // 5b: invokevirtual android/os/Handler.removeMessages (ILjava/lang/Object;)V
      // 5e: aload 6
      // 60: aload 2
      // 61: invokevirtual com/google/android/gms/common/internal/zzaj.a (Landroid/content/ServiceConnection;)Z
      // 64: ifeq 9f
      // 67: new java/lang/IllegalStateException
      // 6a: astore 2
      // 6b: aload 1
      // 6c: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 6f: astore 1
      // 70: aload 1
      // 71: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 74: invokevirtual java/lang/String.length ()I
      // 77: istore 4
      // 79: new java/lang/StringBuilder
      // 7c: astore 3
      // 7d: aload 3
      // 7e: iload 4
      // 80: bipush 81
      // 82: iadd
      // 83: invokespecial java/lang/StringBuilder.<init> (I)V
      // 86: aload 2
      // 87: aload 3
      // 88: ldc "Trying to bind a GmsServiceConnection that was already connected before.  config="
      // 8a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8d: aload 1
      // 8e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 91: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 94: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 97: aload 2
      // 98: athrow
      // 99: astore 1
      // 9a: aload 7
      // 9c: monitorexit
      // 9d: aload 1
      // 9e: athrow
      // 9f: aload 6
      // a1: aload 2
      // a2: aload 3
      // a3: invokevirtual com/google/android/gms/common/internal/zzaj.a (Landroid/content/ServiceConnection;Ljava/lang/String;)V
      // a6: aload 6
      // a8: invokevirtual com/google/android/gms/common/internal/zzaj.b ()I
      // ab: tableswitch 21 1 2 27 49
      // c0: aload 6
      // c2: astore 1
      // c3: goto 49
      // c6: aload 2
      // c7: aload 6
      // c9: invokevirtual com/google/android/gms/common/internal/zzaj.e ()Landroid/content/ComponentName;
      // cc: aload 6
      // ce: invokevirtual com/google/android/gms/common/internal/zzaj.d ()Landroid/os/IBinder;
      // d1: invokeinterface android/content/ServiceConnection.onServiceConnected (Landroid/content/ComponentName;Landroid/os/IBinder;)V 3
      // d6: aload 6
      // d8: astore 1
      // d9: goto 49
      // dc: aload 6
      // de: aload 3
      // df: invokevirtual com/google/android/gms/common/internal/zzaj.a (Ljava/lang/String;)V
      // e2: aload 6
      // e4: astore 1
      // e5: goto 49
      // try (9 -> 15): 80 null
      // try (17 -> 36): 80 null
      // try (38 -> 43): 80 null
      // try (45 -> 80): 80 null
      // try (81 -> 83): 80 null
      // try (85 -> 92): 80 null
      // try (95 -> 101): 80 null
      // try (104 -> 107): 80 null
   }

   @Override
   protected final void b(zzah param1, ServiceConnection param2, String param3) {
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
      // 00: aload 2
      // 01: ldc "ServiceConnection must not be null"
      // 03: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 06: pop
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 0b: astore 5
      // 0d: aload 5
      // 0f: monitorenter
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 14: aload 1
      // 15: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 18: checkcast com/google/android/gms/common/internal/zzaj
      // 1b: astore 6
      // 1d: aload 6
      // 1f: ifnonnull 5a
      // 22: new java/lang/IllegalStateException
      // 25: astore 2
      // 26: aload 1
      // 27: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 2a: astore 3
      // 2b: aload 3
      // 2c: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 2f: invokevirtual java/lang/String.length ()I
      // 32: istore 4
      // 34: new java/lang/StringBuilder
      // 37: astore 1
      // 38: aload 1
      // 39: iload 4
      // 3b: bipush 50
      // 3d: iadd
      // 3e: invokespecial java/lang/StringBuilder.<init> (I)V
      // 41: aload 2
      // 42: aload 1
      // 43: ldc "Nonexistent connection status for service config: "
      // 45: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 48: aload 3
      // 49: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 52: aload 2
      // 53: athrow
      // 54: astore 1
      // 55: aload 5
      // 57: monitorexit
      // 58: aload 1
      // 59: athrow
      // 5a: aload 6
      // 5c: aload 2
      // 5d: invokevirtual com/google/android/gms/common/internal/zzaj.a (Landroid/content/ServiceConnection;)Z
      // 60: ifne 95
      // 63: new java/lang/IllegalStateException
      // 66: astore 2
      // 67: aload 1
      // 68: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 6b: astore 3
      // 6c: aload 3
      // 6d: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 70: invokevirtual java/lang/String.length ()I
      // 73: istore 4
      // 75: new java/lang/StringBuilder
      // 78: astore 1
      // 79: aload 1
      // 7a: iload 4
      // 7c: bipush 76
      // 7e: iadd
      // 7f: invokespecial java/lang/StringBuilder.<init> (I)V
      // 82: aload 2
      // 83: aload 1
      // 84: ldc "Trying to unbind a GmsServiceConnection  that was not bound before.  config="
      // 86: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 89: aload 3
      // 8a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 90: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 93: aload 2
      // 94: athrow
      // 95: aload 6
      // 97: aload 2
      // 98: aload 3
      // 99: invokevirtual com/google/android/gms/common/internal/zzaj.b (Landroid/content/ServiceConnection;Ljava/lang/String;)V
      // 9c: aload 6
      // 9e: invokevirtual com/google/android/gms/common/internal/zzaj.c ()Z
      // a1: ifeq bb
      // a4: aload 0
      // a5: getfield com/google/android/gms/common/internal/zzai.c Landroid/os/Handler;
      // a8: bipush 0
      // a9: aload 1
      // aa: invokevirtual android/os/Handler.obtainMessage (ILjava/lang/Object;)Landroid/os/Message;
      // ad: astore 1
      // ae: aload 0
      // af: getfield com/google/android/gms/common/internal/zzai.c Landroid/os/Handler;
      // b2: aload 1
      // b3: aload 0
      // b4: getfield com/google/android/gms/common/internal/zzai.e J
      // b7: invokevirtual android/os/Handler.sendMessageDelayed (Landroid/os/Message;J)Z
      // ba: pop
      // bb: aload 5
      // bd: monitorexit
      // be: return
      // try (9 -> 15): 43 null
      // try (17 -> 43): 43 null
      // try (44 -> 46): 43 null
      // try (48 -> 78): 43 null
      // try (78 -> 98): 43 null
      // try (98 -> 100): 43 null
   }

   public final boolean handleMessage(Message param1) {
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
      // 000: aload 1
      // 001: getfield android/os/Message.what I
      // 004: tableswitch 24 0 1 28 109
      // 01c: bipush 0
      // 01d: istore 3
      // 01e: iload 3
      // 01f: ireturn
      // 020: aload 0
      // 021: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 024: astore 4
      // 026: aload 4
      // 028: monitorenter
      // 029: aload 1
      // 02a: getfield android/os/Message.obj Ljava/lang/Object;
      // 02d: checkcast com/google/android/gms/common/internal/zzah
      // 030: astore 1
      // 031: aload 0
      // 032: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 035: aload 1
      // 036: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 039: checkcast com/google/android/gms/common/internal/zzaj
      // 03c: astore 5
      // 03e: aload 5
      // 040: ifnull 063
      // 043: aload 5
      // 045: invokevirtual com/google/android/gms/common/internal/zzaj.c ()Z
      // 048: ifeq 063
      // 04b: aload 5
      // 04d: invokevirtual com/google/android/gms/common/internal/zzaj.a ()Z
      // 050: ifeq 05a
      // 053: aload 5
      // 055: ldc "GmsClientSupervisor"
      // 057: invokevirtual com/google/android/gms/common/internal/zzaj.b (Ljava/lang/String;)V
      // 05a: aload 0
      // 05b: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 05e: aload 1
      // 05f: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 062: pop
      // 063: aload 4
      // 065: monitorexit
      // 066: bipush 1
      // 067: istore 3
      // 068: goto 01e
      // 06b: astore 1
      // 06c: aload 4
      // 06e: monitorexit
      // 06f: aload 1
      // 070: athrow
      // 071: aload 0
      // 072: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 075: astore 5
      // 077: aload 5
      // 079: monitorenter
      // 07a: aload 1
      // 07b: getfield android/os/Message.obj Ljava/lang/Object;
      // 07e: checkcast com/google/android/gms/common/internal/zzah
      // 081: astore 7
      // 083: aload 0
      // 084: getfield com/google/android/gms/common/internal/zzai.a Ljava/util/HashMap;
      // 087: aload 7
      // 089: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 08c: checkcast com/google/android/gms/common/internal/zzaj
      // 08f: astore 6
      // 091: aload 6
      // 093: ifnull 10a
      // 096: aload 6
      // 098: invokevirtual com/google/android/gms/common/internal/zzaj.b ()I
      // 09b: bipush 3
      // 09c: if_icmpne 10a
      // 09f: aload 7
      // 0a1: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0a4: astore 1
      // 0a5: aload 1
      // 0a6: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0a9: invokevirtual java/lang/String.length ()I
      // 0ac: istore 2
      // 0ad: new java/lang/StringBuilder
      // 0b0: astore 4
      // 0b2: aload 4
      // 0b4: iload 2
      // 0b5: bipush 47
      // 0b7: iadd
      // 0b8: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0bb: aload 4
      // 0bd: ldc "Timeout waiting for ServiceConnection callback "
      // 0bf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c2: aload 1
      // 0c3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0c9: astore 4
      // 0cb: new java/lang/Exception
      // 0ce: astore 1
      // 0cf: aload 1
      // 0d0: invokespecial java/lang/Exception.<init> ()V
      // 0d3: ldc "GmsClientSupervisor"
      // 0d5: aload 4
      // 0d7: aload 1
      // 0d8: invokestatic android/util/Log.wtf (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0db: pop
      // 0dc: aload 6
      // 0de: invokevirtual com/google/android/gms/common/internal/zzaj.e ()Landroid/content/ComponentName;
      // 0e1: astore 4
      // 0e3: aload 4
      // 0e5: astore 1
      // 0e6: aload 4
      // 0e8: ifnonnull 0f1
      // 0eb: aload 7
      // 0ed: invokevirtual com/google/android/gms/common/internal/zzah.b ()Landroid/content/ComponentName;
      // 0f0: astore 1
      // 0f1: aload 1
      // 0f2: ifnonnull 118
      // 0f5: new android/content/ComponentName
      // 0f8: astore 1
      // 0f9: aload 1
      // 0fa: aload 7
      // 0fc: invokevirtual com/google/android/gms/common/internal/zzah.a ()Ljava/lang/String;
      // 0ff: ldc "unknown"
      // 101: invokespecial android/content/ComponentName.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 104: aload 6
      // 106: aload 1
      // 107: invokevirtual com/google/android/gms/common/internal/zzaj.onServiceDisconnected (Landroid/content/ComponentName;)V
      // 10a: aload 5
      // 10c: monitorexit
      // 10d: bipush 1
      // 10e: istore 3
      // 10f: goto 01e
      // 112: astore 1
      // 113: aload 5
      // 115: monitorexit
      // 116: aload 1
      // 117: athrow
      // 118: goto 104
      // try (12 -> 22): 43 null
      // try (24 -> 33): 43 null
      // try (33 -> 38): 43 null
      // try (38 -> 40): 43 null
      // try (44 -> 46): 43 null
      // try (53 -> 63): 126 null
      // try (65 -> 102): 126 null
      // try (106 -> 109): 126 null
      // try (111 -> 118): 126 null
      // try (118 -> 121): 126 null
      // try (121 -> 123): 126 null
      // try (127 -> 129): 126 null
   }
}
