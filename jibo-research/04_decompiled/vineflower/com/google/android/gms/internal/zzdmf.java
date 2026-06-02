package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzdmf {
   private static Uri a = Uri.parse("content://com.google.android.gsf.gservices");
   private static Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
   private static Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
   private static Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
   private static final AtomicBoolean e = new AtomicBoolean();
   private static HashMap<String, String> f;
   private static HashMap<String, Boolean> g = new HashMap<>();
   private static HashMap<String, Integer> h = new HashMap<>();
   private static HashMap<String, Long> i = new HashMap<>();
   private static HashMap<String, Float> j = new HashMap<>();
   private static Object k;
   private static boolean l;
   private static String[] m = new String[0];

   public static long a(ContentResolver var0, String var1, long var2) {
      Object var5 = b(var0);
      Long var4 = a(i, var1, Long.valueOf(0L));
      if (var4 != null) {
         var2 = var4;
      } else {
         String var7 = a(var0, var1, null);
         Long var8;
         if (var7 == null) {
            var8 = var4;
            var2 = 0L;
         } else {
            label24: {
               try {
                  var2 = Long.parseLong(var7);
               } catch (NumberFormatException var6) {
                  var8 = var4;
                  var2 = 0L;
                  break label24;
               }

               var8 = var2;
            }
         }

         a(var5, i, var1, var8);
      }

      return var2;
   }

   private static <T> T a(HashMap<String, T> param0, String param1, T param2) {
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
      // 00: ldc com/google/android/gms/internal/zzdmf
      // 02: monitorenter
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual java/util/HashMap.containsKey (Ljava/lang/Object;)Z
      // 08: ifeq 1f
      // 0b: aload 0
      // 0c: aload 1
      // 0d: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: astore 0
      // 11: aload 0
      // 12: ifnull 1a
      // 15: ldc com/google/android/gms/internal/zzdmf
      // 17: monitorexit
      // 18: aload 0
      // 19: areturn
      // 1a: aload 2
      // 1b: astore 0
      // 1c: goto 15
      // 1f: ldc com/google/android/gms/internal/zzdmf
      // 21: monitorexit
      // 22: aconst_null
      // 23: astore 0
      // 24: goto 18
      // 27: astore 0
      // 28: ldc com/google/android/gms/internal/zzdmf
      // 2a: monitorexit
      // 2b: aload 0
      // 2c: athrow
      // try (2 -> 10): 24 null
      // try (12 -> 14): 24 null
      // try (19 -> 21): 24 null
      // try (25 -> 27): 24 null
   }

   public static String a(ContentResolver param0, String param1, String param2) {
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
      // 000: aconst_null
      // 001: astore 5
      // 003: aconst_null
      // 004: astore 6
      // 006: aconst_null
      // 007: astore 2
      // 008: aconst_null
      // 009: astore 7
      // 00b: ldc com/google/android/gms/internal/zzdmf
      // 00d: monitorenter
      // 00e: aload 0
      // 00f: invokestatic com/google/android/gms/internal/zzdmf.a (Landroid/content/ContentResolver;)V
      // 012: getstatic com/google/android/gms/internal/zzdmf.k Ljava/lang/Object;
      // 015: astore 8
      // 017: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 01a: aload 1
      // 01b: invokevirtual java/util/HashMap.containsKey (Ljava/lang/Object;)Z
      // 01e: ifeq 03a
      // 021: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 024: aload 1
      // 025: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 028: checkcast java/lang/String
      // 02b: astore 1
      // 02c: aload 7
      // 02e: astore 0
      // 02f: aload 1
      // 030: ifnull 035
      // 033: aload 1
      // 034: astore 0
      // 035: ldc com/google/android/gms/internal/zzdmf
      // 037: monitorexit
      // 038: aload 0
      // 039: areturn
      // 03a: getstatic com/google/android/gms/internal/zzdmf.m [Ljava/lang/String;
      // 03d: astore 7
      // 03f: aload 7
      // 041: arraylength
      // 042: istore 4
      // 044: bipush 0
      // 045: istore 3
      // 046: iload 3
      // 047: iload 4
      // 049: if_icmpge 0b2
      // 04c: aload 1
      // 04d: aload 7
      // 04f: iload 3
      // 050: aaload
      // 051: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 054: ifeq 0ac
      // 057: getstatic com/google/android/gms/internal/zzdmf.l Z
      // 05a: ifeq 066
      // 05d: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 060: invokevirtual java/util/HashMap.isEmpty ()Z
      // 063: ifeq 0a3
      // 066: getstatic com/google/android/gms/internal/zzdmf.m [Ljava/lang/String;
      // 069: astore 2
      // 06a: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 06d: aload 0
      // 06e: aload 2
      // 06f: invokestatic com/google/android/gms/internal/zzdmf.a (Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
      // 072: invokevirtual java/util/HashMap.putAll (Ljava/util/Map;)V
      // 075: bipush 1
      // 076: putstatic com/google/android/gms/internal/zzdmf.l Z
      // 079: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 07c: aload 1
      // 07d: invokevirtual java/util/HashMap.containsKey (Ljava/lang/Object;)Z
      // 080: ifeq 0a3
      // 083: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 086: aload 1
      // 087: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 08a: checkcast java/lang/String
      // 08d: astore 1
      // 08e: aload 6
      // 090: astore 0
      // 091: aload 1
      // 092: ifnull 097
      // 095: aload 1
      // 096: astore 0
      // 097: ldc com/google/android/gms/internal/zzdmf
      // 099: monitorexit
      // 09a: goto 038
      // 09d: astore 0
      // 09e: ldc com/google/android/gms/internal/zzdmf
      // 0a0: monitorexit
      // 0a1: aload 0
      // 0a2: athrow
      // 0a3: ldc com/google/android/gms/internal/zzdmf
      // 0a5: monitorexit
      // 0a6: aload 5
      // 0a8: astore 0
      // 0a9: goto 038
      // 0ac: iinc 3 1
      // 0af: goto 046
      // 0b2: ldc com/google/android/gms/internal/zzdmf
      // 0b4: monitorexit
      // 0b5: aload 0
      // 0b6: getstatic com/google/android/gms/internal/zzdmf.a Landroid/net/Uri;
      // 0b9: aconst_null
      // 0ba: aconst_null
      // 0bb: bipush 1
      // 0bc: anewarray 79
      // 0bf: dup
      // 0c0: bipush 0
      // 0c1: aload 1
      // 0c2: aastore
      // 0c3: aconst_null
      // 0c4: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0c7: astore 6
      // 0c9: aload 6
      // 0cb: ifnull 0d8
      // 0ce: aload 6
      // 0d0: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0d5: ifne 0f4
      // 0d8: aload 8
      // 0da: aload 1
      // 0db: aconst_null
      // 0dc: invokestatic com/google/android/gms/internal/zzdmf.a (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
      // 0df: aload 5
      // 0e1: astore 0
      // 0e2: aload 6
      // 0e4: ifnull 038
      // 0e7: aload 6
      // 0e9: invokeinterface android/database/Cursor.close ()V 1
      // 0ee: aload 5
      // 0f0: astore 0
      // 0f1: goto 038
      // 0f4: aload 6
      // 0f6: bipush 1
      // 0f7: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0fc: astore 5
      // 0fe: aload 5
      // 100: astore 0
      // 101: aload 5
      // 103: ifnull 114
      // 106: aload 5
      // 108: astore 0
      // 109: aload 5
      // 10b: aconst_null
      // 10c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10f: ifeq 114
      // 112: aconst_null
      // 113: astore 0
      // 114: aload 8
      // 116: aload 1
      // 117: aload 0
      // 118: invokestatic com/google/android/gms/internal/zzdmf.a (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
      // 11b: aload 2
      // 11c: astore 1
      // 11d: aload 0
      // 11e: ifnull 123
      // 121: aload 0
      // 122: astore 1
      // 123: aload 1
      // 124: astore 0
      // 125: aload 6
      // 127: ifnull 038
      // 12a: aload 6
      // 12c: invokeinterface android/database/Cursor.close ()V 1
      // 131: aload 1
      // 132: astore 0
      // 133: goto 038
      // 136: astore 0
      // 137: aload 6
      // 139: ifnull 143
      // 13c: aload 6
      // 13e: invokeinterface android/database/Cursor.close ()V 1
      // 143: aload 0
      // 144: athrow
      // try (10 -> 23): 81 null
      // try (29 -> 31): 81 null
      // try (33 -> 38): 81 null
      // try (43 -> 54): 81 null
      // try (54 -> 72): 81 null
      // try (78 -> 80): 81 null
      // try (82 -> 84): 81 null
      // try (86 -> 88): 81 null
      // try (93 -> 95): 81 null
      // try (110 -> 113): 161 null
      // try (113 -> 117): 161 null
      // try (126 -> 130): 161 null
      // try (136 -> 140): 161 null
      // try (142 -> 146): 161 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static Map<String, String> a(ContentResolver var0, String... var1) {
      Cursor var5 = var0.query(b, null, null, var1, null);
      TreeMap var6 = new TreeMap();
      if (var5 != null) {
         while (true) {
            boolean var3 = false /* VF: Semaphore variable */;

            try {
               var3 = true;
               if (var5.moveToNext()) {
                  var6.put(var5.getString(0), var5.getString(1));
                  var3 = false;
                  continue;
               }

               var3 = false;
            } finally {
               if (var3) {
                  var5.close();
               }
            }

            var5.close();
            break;
         }
      }

      return var6;
   }

   private static void a(ContentResolver var0) {
      if (f == null) {
         e.set(false);
         f = new HashMap<>();
         k = new Object();
         l = false;
         var0.registerContentObserver(a, true, new zzdmg(null));
      } else if (e.getAndSet(false)) {
         f.clear();
         g.clear();
         h.clear();
         i.clear();
         j.clear();
         k = new Object();
         l = false;
      }
   }

   private static void a(Object param0, String param1, String param2) {
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
      // 00: ldc com/google/android/gms/internal/zzdmf
      // 02: monitorenter
      // 03: aload 0
      // 04: getstatic com/google/android/gms/internal/zzdmf.k Ljava/lang/Object;
      // 07: if_acmpne 13
      // 0a: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 0d: aload 1
      // 0e: aload 2
      // 0f: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 12: pop
      // 13: ldc com/google/android/gms/internal/zzdmf
      // 15: monitorexit
      // 16: return
      // 17: astore 0
      // 18: ldc com/google/android/gms/internal/zzdmf
      // 1a: monitorexit
      // 1b: aload 0
      // 1c: athrow
      // try (2 -> 10): 13 null
      // try (10 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   private static <T> void a(Object param0, HashMap<String, T> param1, String param2, T param3) {
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
      // 00: ldc com/google/android/gms/internal/zzdmf
      // 02: monitorenter
      // 03: aload 0
      // 04: getstatic com/google/android/gms/internal/zzdmf.k Ljava/lang/Object;
      // 07: if_acmpne 19
      // 0a: aload 1
      // 0b: aload 2
      // 0c: aload 3
      // 0d: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 10: pop
      // 11: getstatic com/google/android/gms/internal/zzdmf.f Ljava/util/HashMap;
      // 14: aload 2
      // 15: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 18: pop
      // 19: ldc com/google/android/gms/internal/zzdmf
      // 1b: monitorexit
      // 1c: return
      // 1d: astore 0
      // 1e: ldc com/google/android/gms/internal/zzdmf
      // 20: monitorexit
      // 21: aload 0
      // 22: athrow
      // try (2 -> 14): 17 null
      // try (14 -> 16): 17 null
      // try (18 -> 20): 17 null
   }

   public static boolean a(ContentResolver var0, String var1, boolean var2) {
      Object var5 = b(var0);
      Boolean var4 = a(g, var1, Boolean.valueOf(var2));
      boolean var3;
      if (var4 != null) {
         var3 = var4;
      } else {
         String var6 = a(var0, var1, null);
         Boolean var7 = var4;
         var3 = var2;
         if (var6 != null) {
            if (var6.equals("")) {
               var3 = var2;
               var7 = var4;
            } else if (c.matcher(var6).matches()) {
               var7 = true;
               var3 = true;
            } else if (d.matcher(var6).matches()) {
               var7 = false;
               var3 = false;
            } else {
               Log.w("Gservices", "attempt to read gservices key " + var1 + " (value \"" + var6 + "\") as boolean");
               var7 = var4;
               var3 = var2;
            }
         }

         a(var5, g, var1, var7);
      }

      return var3;
   }

   private static Object b(ContentResolver param0) {
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
      // 00: ldc com/google/android/gms/internal/zzdmf
      // 02: monitorenter
      // 03: aload 0
      // 04: invokestatic com/google/android/gms/internal/zzdmf.a (Landroid/content/ContentResolver;)V
      // 07: getstatic com/google/android/gms/internal/zzdmf.k Ljava/lang/Object;
      // 0a: astore 0
      // 0b: ldc com/google/android/gms/internal/zzdmf
      // 0d: monitorexit
      // 0e: aload 0
      // 0f: areturn
      // 10: astore 0
      // 11: ldc com/google/android/gms/internal/zzdmf
      // 13: monitorexit
      // 14: aload 0
      // 15: athrow
      // try (2 -> 8): 10 null
      // try (11 -> 13): 10 null
   }
}
