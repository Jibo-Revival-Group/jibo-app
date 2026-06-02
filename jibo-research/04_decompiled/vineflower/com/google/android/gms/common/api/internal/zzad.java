package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Map;

final class zzad implements OnCompleteListener<Map<zzh<?>, String>> {
   private zzcu a;
   private zzaa b;

   zzad(zzaa var1, zzcu var2) {
      this.b = var1;
      super();
      this.a = var2;
   }

   final void a() {
      this.a.h();
   }

   @Override
   public final void a(Task<Map<zzh<?>, String>> param1) {
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
      // 000: aload 0
      // 001: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 004: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 007: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 00c: aload 0
      // 00d: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 010: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;)Z
      // 013: ifne 02c
      // 016: aload 0
      // 017: getfield com/google/android/gms/common/api/internal/zzad.a Lcom/google/android/gms/common/api/internal/zzcu;
      // 01a: invokeinterface com/google/android/gms/common/api/internal/zzcu.h ()V 1
      // 01f: aload 0
      // 020: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 023: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 026: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 02b: return
      // 02c: aload 1
      // 02d: invokevirtual com/google/android/gms/tasks/Task.b ()Z
      // 030: ifeq 09d
      // 033: aload 0
      // 034: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 037: astore 2
      // 038: new android/support/v4/util/ArrayMap
      // 03b: astore 1
      // 03c: aload 1
      // 03d: aload 0
      // 03e: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 041: invokestatic com/google/android/gms/common/api/internal/zzaa.m (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 044: invokeinterface java/util/Map.size ()I 1
      // 049: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // 04c: aload 2
      // 04d: aload 1
      // 04e: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 051: pop
      // 052: aload 0
      // 053: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 056: invokestatic com/google/android/gms/common/api/internal/zzaa.m (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 059: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 05e: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 063: astore 2
      // 064: aload 2
      // 065: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 06a: ifeq 15c
      // 06d: aload 2
      // 06e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 073: checkcast com/google/android/gms/common/api/internal/zzz
      // 076: astore 1
      // 077: aload 0
      // 078: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 07b: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 07e: aload 1
      // 07f: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 082: getstatic com/google/android/gms/common/ConnectionResult.a Lcom/google/android/gms/common/ConnectionResult;
      // 085: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 08a: pop
      // 08b: goto 064
      // 08e: astore 1
      // 08f: aload 0
      // 090: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 093: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 096: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 09b: aload 1
      // 09c: athrow
      // 09d: aload 1
      // 09e: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 0a1: instanceof com/google/android/gms/common/api/AvailabilityException
      // 0a4: ifeq 1b5
      // 0a7: aload 1
      // 0a8: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 0ab: checkcast com/google/android/gms/common/api/AvailabilityException
      // 0ae: astore 1
      // 0af: aload 0
      // 0b0: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 0b3: invokestatic com/google/android/gms/common/api/internal/zzaa.e (Lcom/google/android/gms/common/api/internal/zzaa;)Z
      // 0b6: ifeq 150
      // 0b9: aload 0
      // 0ba: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 0bd: astore 3
      // 0be: new android/support/v4/util/ArrayMap
      // 0c1: astore 2
      // 0c2: aload 2
      // 0c3: aload 0
      // 0c4: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 0c7: invokestatic com/google/android/gms/common/api/internal/zzaa.m (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 0ca: invokeinterface java/util/Map.size ()I 1
      // 0cf: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // 0d2: aload 3
      // 0d3: aload 2
      // 0d4: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 0d7: pop
      // 0d8: aload 0
      // 0d9: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 0dc: invokestatic com/google/android/gms/common/api/internal/zzaa.m (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 0df: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0e4: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0e9: astore 2
      // 0ea: aload 2
      // 0eb: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0f0: ifeq 15c
      // 0f3: aload 2
      // 0f4: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f9: checkcast com/google/android/gms/common/api/internal/zzz
      // 0fc: astore 5
      // 0fe: aload 5
      // 100: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 103: astore 3
      // 104: aload 1
      // 105: aload 5
      // 107: invokevirtual com/google/android/gms/common/api/AvailabilityException.a (Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/common/ConnectionResult;
      // 10a: astore 4
      // 10c: aload 0
      // 10d: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 110: aload 5
      // 112: aload 4
      // 114: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/api/internal/zzz;Lcom/google/android/gms/common/ConnectionResult;)Z
      // 117: ifeq 13d
      // 11a: aload 0
      // 11b: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 11e: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 121: astore 4
      // 123: new com/google/android/gms/common/ConnectionResult
      // 126: astore 5
      // 128: aload 5
      // 12a: bipush 16
      // 12c: invokespecial com/google/android/gms/common/ConnectionResult.<init> (I)V
      // 12f: aload 4
      // 131: aload 3
      // 132: aload 5
      // 134: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 139: pop
      // 13a: goto 0ea
      // 13d: aload 0
      // 13e: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 141: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 144: aload 3
      // 145: aload 4
      // 147: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 14c: pop
      // 14d: goto 0ea
      // 150: aload 0
      // 151: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 154: aload 1
      // 155: invokevirtual com/google/android/gms/common/api/AvailabilityException.a ()Landroid/support/v4/util/ArrayMap;
      // 158: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 15b: pop
      // 15c: aload 0
      // 15d: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 160: invokevirtual com/google/android/gms/common/api/internal/zzaa.d ()Z
      // 163: ifeq 19d
      // 166: aload 0
      // 167: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 16a: invokestatic com/google/android/gms/common/api/internal/zzaa.d (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 16d: aload 0
      // 16e: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 171: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 174: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 179: aload 0
      // 17a: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 17d: invokestatic com/google/android/gms/common/api/internal/zzaa.f (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/ConnectionResult;
      // 180: ifnonnull 19d
      // 183: aload 0
      // 184: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 187: invokestatic com/google/android/gms/common/api/internal/zzaa.i (Lcom/google/android/gms/common/api/internal/zzaa;)V
      // 18a: aload 0
      // 18b: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 18e: invokestatic com/google/android/gms/common/api/internal/zzaa.j (Lcom/google/android/gms/common/api/internal/zzaa;)V
      // 191: aload 0
      // 192: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 195: invokestatic com/google/android/gms/common/api/internal/zzaa.l (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Condition;
      // 198: invokeinterface java/util/concurrent/locks/Condition.signalAll ()V 1
      // 19d: aload 0
      // 19e: getfield com/google/android/gms/common/api/internal/zzad.a Lcom/google/android/gms/common/api/internal/zzcu;
      // 1a1: invokeinterface com/google/android/gms/common/api/internal/zzcu.h ()V 1
      // 1a6: aload 0
      // 1a7: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 1aa: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 1ad: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1b2: goto 02b
      // 1b5: ldc "ConnectionlessGAC"
      // 1b7: ldc "Unexpected availability exception"
      // 1b9: aload 1
      // 1ba: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 1bd: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 1c0: pop
      // 1c1: aload 0
      // 1c2: getfield com/google/android/gms/common/api/internal/zzad.b Lcom/google/android/gms/common/api/internal/zzaa;
      // 1c5: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 1c8: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 1cb: pop
      // 1cc: goto 15c
      // try (4 -> 11): 56 null
      // try (16 -> 40): 56 null
      // try (40 -> 55): 56 null
      // try (63 -> 96): 56 null
      // try (96 -> 130): 56 null
      // try (131 -> 138): 56 null
      // try (139 -> 145): 56 null
      // try (145 -> 170): 56 null
      // try (170 -> 173): 56 null
      // try (178 -> 189): 56 null
   }
}
