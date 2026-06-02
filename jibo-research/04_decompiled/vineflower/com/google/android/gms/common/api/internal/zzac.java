package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Map;

final class zzac implements OnCompleteListener<Map<zzh<?>, String>> {
   private zzaa a;

   private zzac(zzaa var1) {
      this.a = var1;
      super();
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
      // 001: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 004: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 007: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 00c: aload 0
      // 00d: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 010: invokestatic com/google/android/gms/common/api/internal/zzaa.b (Lcom/google/android/gms/common/api/internal/zzaa;)Z
      // 013: istore 2
      // 014: iload 2
      // 015: ifne 025
      // 018: aload 0
      // 019: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 01c: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 01f: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 024: return
      // 025: aload 1
      // 026: invokevirtual com/google/android/gms/tasks/Task.b ()Z
      // 029: ifeq 096
      // 02c: aload 0
      // 02d: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 030: astore 1
      // 031: new android/support/v4/util/ArrayMap
      // 034: astore 3
      // 035: aload 3
      // 036: aload 0
      // 037: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 03a: invokestatic com/google/android/gms/common/api/internal/zzaa.c (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 03d: invokeinterface java/util/Map.size ()I 1
      // 042: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // 045: aload 1
      // 046: aload 3
      // 047: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 04a: pop
      // 04b: aload 0
      // 04c: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 04f: invokestatic com/google/android/gms/common/api/internal/zzaa.c (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 052: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 057: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 05c: astore 3
      // 05d: aload 3
      // 05e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 063: ifeq 16a
      // 066: aload 3
      // 067: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 06c: checkcast com/google/android/gms/common/api/internal/zzz
      // 06f: astore 1
      // 070: aload 0
      // 071: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 074: invokestatic com/google/android/gms/common/api/internal/zzaa.d (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 077: aload 1
      // 078: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 07b: getstatic com/google/android/gms/common/ConnectionResult.a Lcom/google/android/gms/common/ConnectionResult;
      // 07e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 083: pop
      // 084: goto 05d
      // 087: astore 1
      // 088: aload 0
      // 089: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 08c: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 08f: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 094: aload 1
      // 095: athrow
      // 096: aload 1
      // 097: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 09a: instanceof com/google/android/gms/common/api/AvailabilityException
      // 09d: ifeq 1c9
      // 0a0: aload 1
      // 0a1: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 0a4: checkcast com/google/android/gms/common/api/AvailabilityException
      // 0a7: astore 1
      // 0a8: aload 0
      // 0a9: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 0ac: invokestatic com/google/android/gms/common/api/internal/zzaa.e (Lcom/google/android/gms/common/api/internal/zzaa;)Z
      // 0af: ifeq 14f
      // 0b2: aload 0
      // 0b3: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 0b6: astore 3
      // 0b7: new android/support/v4/util/ArrayMap
      // 0ba: astore 4
      // 0bc: aload 4
      // 0be: aload 0
      // 0bf: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 0c2: invokestatic com/google/android/gms/common/api/internal/zzaa.c (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 0c5: invokeinterface java/util/Map.size ()I 1
      // 0ca: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // 0cd: aload 3
      // 0ce: aload 4
      // 0d0: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 0d3: pop
      // 0d4: aload 0
      // 0d5: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 0d8: invokestatic com/google/android/gms/common/api/internal/zzaa.c (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 0db: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0e0: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0e5: astore 4
      // 0e7: aload 4
      // 0e9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ee: ifeq 15b
      // 0f1: aload 4
      // 0f3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f8: checkcast com/google/android/gms/common/api/internal/zzz
      // 0fb: astore 6
      // 0fd: aload 6
      // 0ff: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 102: astore 3
      // 103: aload 1
      // 104: aload 6
      // 106: invokevirtual com/google/android/gms/common/api/AvailabilityException.a (Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/common/ConnectionResult;
      // 109: astore 5
      // 10b: aload 0
      // 10c: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 10f: aload 6
      // 111: aload 5
      // 113: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/api/internal/zzz;Lcom/google/android/gms/common/ConnectionResult;)Z
      // 116: ifeq 13c
      // 119: aload 0
      // 11a: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 11d: invokestatic com/google/android/gms/common/api/internal/zzaa.d (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 120: astore 5
      // 122: new com/google/android/gms/common/ConnectionResult
      // 125: astore 6
      // 127: aload 6
      // 129: bipush 16
      // 12b: invokespecial com/google/android/gms/common/ConnectionResult.<init> (I)V
      // 12e: aload 5
      // 130: aload 3
      // 131: aload 6
      // 133: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 138: pop
      // 139: goto 0e7
      // 13c: aload 0
      // 13d: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 140: invokestatic com/google/android/gms/common/api/internal/zzaa.d (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 143: aload 3
      // 144: aload 5
      // 146: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 14b: pop
      // 14c: goto 0e7
      // 14f: aload 0
      // 150: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 153: aload 1
      // 154: invokevirtual com/google/android/gms/common/api/AvailabilityException.a ()Landroid/support/v4/util/ArrayMap;
      // 157: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 15a: pop
      // 15b: aload 0
      // 15c: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 15f: aload 0
      // 160: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 163: invokestatic com/google/android/gms/common/api/internal/zzaa.f (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/ConnectionResult;
      // 166: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
      // 169: pop
      // 16a: aload 0
      // 16b: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 16e: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 171: ifnull 196
      // 174: aload 0
      // 175: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 178: invokestatic com/google/android/gms/common/api/internal/zzaa.d (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 17b: aload 0
      // 17c: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 17f: invokestatic com/google/android/gms/common/api/internal/zzaa.g (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/Map;
      // 182: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 187: aload 0
      // 188: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 18b: aload 0
      // 18c: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 18f: invokestatic com/google/android/gms/common/api/internal/zzaa.f (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/ConnectionResult;
      // 192: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
      // 195: pop
      // 196: aload 0
      // 197: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 19a: invokestatic com/google/android/gms/common/api/internal/zzaa.h (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/ConnectionResult;
      // 19d: ifnonnull 1f8
      // 1a0: aload 0
      // 1a1: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1a4: invokestatic com/google/android/gms/common/api/internal/zzaa.i (Lcom/google/android/gms/common/api/internal/zzaa;)V
      // 1a7: aload 0
      // 1a8: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1ab: invokestatic com/google/android/gms/common/api/internal/zzaa.j (Lcom/google/android/gms/common/api/internal/zzaa;)V
      // 1ae: aload 0
      // 1af: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1b2: invokestatic com/google/android/gms/common/api/internal/zzaa.l (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Condition;
      // 1b5: invokeinterface java/util/concurrent/locks/Condition.signalAll ()V 1
      // 1ba: aload 0
      // 1bb: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1be: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;)Ljava/util/concurrent/locks/Lock;
      // 1c1: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1c6: goto 024
      // 1c9: ldc "ConnectionlessGAC"
      // 1cb: ldc "Unexpected availability exception"
      // 1cd: aload 1
      // 1ce: invokevirtual com/google/android/gms/tasks/Task.d ()Ljava/lang/Exception;
      // 1d1: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 1d4: pop
      // 1d5: aload 0
      // 1d6: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1d9: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 1dc: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Ljava/util/Map;)Ljava/util/Map;
      // 1df: pop
      // 1e0: aload 0
      // 1e1: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1e4: astore 1
      // 1e5: new com/google/android/gms/common/ConnectionResult
      // 1e8: astore 3
      // 1e9: aload 3
      // 1ea: bipush 8
      // 1ec: invokespecial com/google/android/gms/common/ConnectionResult.<init> (I)V
      // 1ef: aload 1
      // 1f0: aload 3
      // 1f1: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
      // 1f4: pop
      // 1f5: goto 16a
      // 1f8: aload 0
      // 1f9: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 1fc: bipush 0
      // 1fd: invokestatic com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/internal/zzaa;Z)Z
      // 200: pop
      // 201: aload 0
      // 202: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 205: invokestatic com/google/android/gms/common/api/internal/zzaa.k (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/api/internal/zzba;
      // 208: aload 0
      // 209: getfield com/google/android/gms/common/api/internal/zzac.a Lcom/google/android/gms/common/api/internal/zzaa;
      // 20c: invokestatic com/google/android/gms/common/api/internal/zzaa.h (Lcom/google/android/gms/common/api/internal/zzaa;)Lcom/google/android/gms/common/ConnectionResult;
      // 20f: invokevirtual com/google/android/gms/common/api/internal/zzba.a (Lcom/google/android/gms/common/ConnectionResult;)V
      // 212: goto 1ae
      // try (4 -> 8): 55 null
      // try (15 -> 39): 55 null
      // try (39 -> 54): 55 null
      // try (62 -> 95): 55 null
      // try (95 -> 129): 55 null
      // try (130 -> 137): 55 null
      // try (138 -> 144): 55 null
      // try (144 -> 151): 55 null
      // try (151 -> 169): 55 null
      // try (169 -> 179): 55 null
      // try (179 -> 183): 55 null
      // try (188 -> 211): 55 null
      // try (212 -> 224): 55 null
   }
}
