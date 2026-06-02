package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzctv {
   private static final ConcurrentHashMap<Uri, zzctv> a = new ConcurrentHashMap<>();
   private static String[] g = new String[]{"key", "value"};
   private final ContentResolver b;
   private final Uri c;
   private final ContentObserver d;
   private final Object e = new Object();
   private volatile Map<String, String> f;

   private zzctv(ContentResolver var1, Uri var2) {
      this.b = var1;
      this.c = var2;
      this.d = new zzctw(this, null);
   }

   public static zzctv a(ContentResolver var0, Uri var1) {
      zzctv var3 = a.get(var1);
      zzctv var2 = var3;
      if (var3 == null) {
         zzctv var4 = new zzctv(var0, var1);
         zzctv var5 = a.putIfAbsent(var1, var4);
         var2 = var5;
         if (var5 == null) {
            var4.b.registerContentObserver(var4.c, false, var4.d);
            var2 = var4;
         }
      }

      return var2;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private final Map<String, String> c() {
      HashMap var2 = new HashMap();
      Cursor var1 = this.b.query(this.c, g, null, null, null);
      if (var1 != null) {
         while (true) {
            boolean var4 = false /* VF: Semaphore variable */;

            try {
               var4 = true;
               if (var1.moveToNext()) {
                  var2.put(var1.getString(0), var1.getString(1));
                  var4 = false;
                  continue;
               }

               var4 = false;
            } finally {
               if (var4) {
                  var1.close();
               }
            }

            var1.close();
            break;
         }
      }

      return var2;
   }

   public final Map<String, String> a() {
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
      // 00: ldc "gms:phenotype:phenotype_flag:debug_disable_caching"
      // 02: bipush 0
      // 03: invokestatic com/google/android/gms/internal/zzcui.a (Ljava/lang/String;Z)Z
      // 06: ifeq 36
      // 09: aload 0
      // 0a: invokespecial com/google/android/gms/internal/zzctv.c ()Ljava/util/Map;
      // 0d: astore 1
      // 0e: aload 1
      // 0f: astore 2
      // 10: aload 1
      // 11: ifnonnull 34
      // 14: aload 0
      // 15: getfield com/google/android/gms/internal/zzctv.e Ljava/lang/Object;
      // 18: astore 3
      // 19: aload 3
      // 1a: monitorenter
      // 1b: aload 0
      // 1c: getfield com/google/android/gms/internal/zzctv.f Ljava/util/Map;
      // 1f: astore 2
      // 20: aload 2
      // 21: astore 1
      // 22: aload 2
      // 23: ifnonnull 30
      // 26: aload 0
      // 27: invokespecial com/google/android/gms/internal/zzctv.c ()Ljava/util/Map;
      // 2a: astore 1
      // 2b: aload 0
      // 2c: aload 1
      // 2d: putfield com/google/android/gms/internal/zzctv.f Ljava/util/Map;
      // 30: aload 3
      // 31: monitorexit
      // 32: aload 1
      // 33: astore 2
      // 34: aload 2
      // 35: areturn
      // 36: aload 0
      // 37: getfield com/google/android/gms/internal/zzctv.f Ljava/util/Map;
      // 3a: astore 1
      // 3b: goto 0e
      // 3e: astore 1
      // 3f: aload 3
      // 40: monitorexit
      // 41: aload 1
      // 42: athrow
      // try (16 -> 19): 39 null
      // try (23 -> 29): 39 null
      // try (29 -> 31): 39 null
      // try (40 -> 42): 39 null
   }

   public final void b() {
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
      // 01: getfield com/google/android/gms/internal/zzctv.e Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: aconst_null
      // 09: putfield com/google/android/gms/internal/zzctv.f Ljava/util/Map;
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: return
      // 0f: astore 2
      // 10: aload 1
      // 11: monitorexit
      // 12: aload 2
      // 13: athrow
      // try (5 -> 10): 11 null
      // try (12 -> 14): 11 null
   }
}
