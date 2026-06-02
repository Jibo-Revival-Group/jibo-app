package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import com.salesforce.androidsdk.util.JSONObjectHelper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmartStore {
   protected SQLiteDatabase a;
   protected SQLiteOpenHelper b;
   protected String c;
   protected SmartStore.FtsExtension d = SmartStore.FtsExtension.fts5;
   private final ExecutorService e = Executors.newFixedThreadPool(1);

   @Deprecated
   public SmartStore(SQLiteDatabase var1) {
      this.a = var1;
   }

   public SmartStore(SQLiteOpenHelper var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   private static Object a(Object var0, String[] var1, int var2) {
      if (var2 != var1.length) {
         if (var0 != null) {
            String var4 = var1[var2];
            if (var0 instanceof JSONObject) {
               var0 = a(JSONObjectHelper.a((JSONObject)var0, var4), var1, var2 + 1);
               return var0;
            }

            if (var0 instanceof JSONArray) {
               JSONArray var5 = (JSONArray)var0;
               JSONArray var7 = new JSONArray();

               for (int var3 = 0; var3 < var5.length(); var3++) {
                  var0 = a(JSONObjectHelper.a(var5, var3), var1, var2);
                  if (var0 != null) {
                     var7.put(var0);
                  }
               }

               JSONArray var8 = var7;
               if (var7.length() == 0) {
                  var8 = null;
               }

               return var8;
            }
         }

         var0 = null;
      }

      return var0;
   }

   public static Object a(JSONObject var0, String var1) {
      Object var2;
      if (var0 == null) {
         var2 = null;
      } else {
         var2 = var0;
         if (var1 != null) {
            var2 = var0;
            if (!var1.equals("")) {
               var2 = a(var0, var1.split("[.]"), 0);
            }
         }
      }

      return var2;
   }

   public static String a(long var0) {
      return "TABLE_" + var0;
   }

   private String a(String var1, String var2) {
      return String.format("%s IN (%s)", var1, var2);
   }

   private String a(Long[] var1) {
      return this.a("id", TextUtils.join(",", var1));
   }

   private JSONArray a(Cursor var1) throws JSONException {
      JSONArray var8 = new JSONArray();
      int var4 = var1.getColumnCount();
      int var2 = 0;

      while (var2 < var4) {
         int var5 = var1.getType(var2);
         int var3;
         if (var5 == 0) {
            var8.put(null);
            var3 = var2;
         } else if (var5 == 3) {
            String var9 = var1.getString(var2);
            if (var1.getColumnName(var2).equals("externalStorage")) {
               var9 = var1.getString(var2);
               long var6 = var1.getLong(var2 + 1);
               var8.put(((DBOpenHelper)this.b).a(var9, Long.valueOf(var6), this.c));
               var2++;
            } else if (var1.getColumnName(var2).endsWith("soup")) {
               var8.put(new JSONObject(var9));
            } else {
               var8.put(var9);
            }

            var3 = var2;
         } else if (var5 == 1) {
            var8.put(var1.getLong(var2));
            var3 = var2;
         } else {
            var3 = var2;
            if (var5 == 2) {
               var8.put(var1.getDouble(var2));
               var3 = var2;
            }
         }

         var2 = var3 + 1;
      }

      return var8;
   }

   public static void a(SQLiteDatabase param0) {
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
      // 000: bipush 0
      // 001: istore 1
      // 002: aload 0
      // 003: monitorenter
      // 004: new java/lang/StringBuilder
      // 007: astore 3
      // 008: aload 3
      // 009: invokespecial java/lang/StringBuilder.<init> ()V
      // 00c: aload 3
      // 00d: ldc "CREATE TABLE "
      // 00f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 012: ldc "soup_index_map"
      // 014: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 017: ldc " ("
      // 019: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 01c: ldc "soupName"
      // 01e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 021: ldc " TEXT"
      // 023: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 026: ldc ","
      // 028: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02b: ldc "path"
      // 02d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 030: ldc " TEXT"
      // 032: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 035: ldc ","
      // 037: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03a: ldc "columnName"
      // 03c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03f: ldc " TEXT"
      // 041: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 044: ldc ","
      // 046: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 049: ldc "columnType"
      // 04b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04e: ldc " TEXT"
      // 050: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 053: ldc ")"
      // 055: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 058: pop
      // 059: aload 0
      // 05a: aload 3
      // 05b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 05e: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 061: aload 0
      // 062: ldc "CREATE INDEX %s on %s ( %s )"
      // 064: bipush 3
      // 065: anewarray 4
      // 068: dup
      // 069: bipush 0
      // 06a: ldc "soup_index_map_0"
      // 06c: aastore
      // 06d: dup
      // 06e: bipush 1
      // 06f: ldc "soup_index_map"
      // 071: aastore
      // 072: dup
      // 073: bipush 2
      // 074: ldc "soupName"
      // 076: aastore
      // 077: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 07a: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 07d: new java/lang/StringBuilder
      // 080: astore 5
      // 082: aload 5
      // 084: invokespecial java/lang/StringBuilder.<init> ()V
      // 087: aload 5
      // 089: ldc "CREATE TABLE "
      // 08b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08e: ldc "soup_attrs"
      // 090: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 093: ldc " ("
      // 095: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 098: ldc "id"
      // 09a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09d: ldc " INTEGER PRIMARY KEY AUTOINCREMENT"
      // 09f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a2: ldc ","
      // 0a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a7: ldc "soupName"
      // 0a9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ac: ldc " TEXT"
      // 0ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b1: pop
      // 0b2: getstatic com/salesforce/androidsdk/smartstore/store/SoupSpec.a [Ljava/lang/String;
      // 0b5: astore 3
      // 0b6: aload 3
      // 0b7: arraylength
      // 0b8: istore 2
      // 0b9: iload 1
      // 0ba: iload 2
      // 0bb: if_icmpge 0db
      // 0be: aload 3
      // 0bf: iload 1
      // 0c0: aaload
      // 0c1: astore 4
      // 0c3: aload 5
      // 0c5: ldc ","
      // 0c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ca: aload 4
      // 0cc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0cf: ldc " INTEGER DEFAULT 0"
      // 0d1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d4: pop
      // 0d5: iinc 1 1
      // 0d8: goto 0b9
      // 0db: aload 5
      // 0dd: ldc ")"
      // 0df: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e2: pop
      // 0e3: aload 0
      // 0e4: aload 5
      // 0e6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e9: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 0ec: aload 0
      // 0ed: ldc "CREATE INDEX %s on %s ( %s )"
      // 0ef: bipush 3
      // 0f0: anewarray 4
      // 0f3: dup
      // 0f4: bipush 0
      // 0f5: ldc "soup_attrs_0"
      // 0f7: aastore
      // 0f8: dup
      // 0f9: bipush 1
      // 0fa: ldc "soup_attrs"
      // 0fc: aastore
      // 0fd: dup
      // 0fe: bipush 2
      // 0ff: ldc "soupName"
      // 101: aastore
      // 102: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 105: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 108: aload 0
      // 109: invokestatic com/salesforce/androidsdk/smartstore/store/SmartStore.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 10c: aload 0
      // 10d: monitorexit
      // 10e: return
      // 10f: astore 3
      // 110: aload 0
      // 111: monitorexit
      // 112: aload 3
      // 113: athrow
      // try (4 -> 89): 137 null
      // try (96 -> 104): 137 null
      // try (106 -> 136): 137 null
      // try (138 -> 140): 137 null
   }

   public static void a(SQLiteDatabase param0, String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 02: monitorenter
      // 03: aload 0
      // 04: monitorenter
      // 05: aload 2
      // 06: ifnull 39
      // 09: aload 2
      // 0a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0d: ldc ""
      // 0f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 12: ifne 39
      // 15: new java/lang/StringBuilder
      // 18: astore 3
      // 19: aload 3
      // 1a: invokespecial java/lang/StringBuilder.<init> ()V
      // 1d: aload 0
      // 1e: aload 3
      // 1f: ldc "PRAGMA rekey = '"
      // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 24: aload 2
      // 25: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 28: ldc "'"
      // 2a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 30: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 33: aload 0
      // 34: aload 1
      // 35: aload 2
      // 36: invokestatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
      // 39: aload 0
      // 3a: monitorexit
      // 3b: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 3d: monitorexit
      // 3e: return
      // 3f: astore 1
      // 40: aload 0
      // 41: monitorexit
      // 42: aload 1
      // 43: athrow
      // 44: astore 0
      // 45: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 47: monitorexit
      // 48: aload 0
      // 49: athrow
      // try (2 -> 4): 39 null
      // try (6 -> 29): 34 null
      // try (29 -> 31): 34 null
      // try (35 -> 37): 34 null
      // try (37 -> 39): 39 null
   }

   public static void a(SQLiteDatabase param0, String param1, String param2, String[] param3) {
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
      // 00: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 02: monitorenter
      // 03: new java/lang/StringBuilder
      // 06: astore 6
      // 08: aload 6
      // 0a: invokespecial java/lang/StringBuilder.<init> ()V
      // 0d: aload 3
      // 0e: ifnull 57
      // 11: aload 3
      // 12: arraylength
      // 13: ifle 57
      // 16: aload 3
      // 17: arraylength
      // 18: istore 5
      // 1a: bipush 0
      // 1b: istore 4
      // 1d: iload 4
      // 1f: iload 5
      // 21: if_icmpge 4e
      // 24: aload 3
      // 25: iload 4
      // 27: aaload
      // 28: astore 7
      // 2a: aload 6
      // 2c: ldc_w "ALTER TABLE "
      // 2f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 32: aload 1
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: ldc_w " ADD COLUMN "
      // 39: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3c: aload 7
      // 3e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 41: ldc_w " INTEGER DEFAULT 0;"
      // 44: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 47: pop
      // 48: iinc 4 1
      // 4b: goto 1d
      // 4e: aload 0
      // 4f: aload 6
      // 51: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 54: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 57: aload 1
      // 58: ifnull 8a
      // 5b: aload 2
      // 5c: ifnull 8a
      // 5f: new java/lang/StringBuilder
      // 62: astore 3
      // 63: aload 3
      // 64: invokespecial java/lang/StringBuilder.<init> ()V
      // 67: aload 3
      // 68: ldc_w "ALTER TABLE "
      // 6b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 6e: aload 1
      // 6f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 72: ldc_w " RENAME TO "
      // 75: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 78: aload 2
      // 79: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7c: bipush 59
      // 7e: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 81: pop
      // 82: aload 0
      // 83: aload 3
      // 84: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 87: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 8a: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 8c: monitorexit
      // 8d: return
      // 8e: astore 0
      // 8f: ldc com/salesforce/androidsdk/smartstore/store/SmartStore
      // 91: monitorexit
      // 92: aload 0
      // 93: athrow
      // try (2 -> 6): 68 null
      // try (8 -> 14): 68 null
      // try (23 -> 35): 68 null
      // try (37 -> 41): 68 null
      // try (45 -> 65): 68 null
      // try (65 -> 67): 68 null
      // try (69 -> 71): 68 null
   }

   private void a(JSONObject var1, ContentValues var2, IndexSpec var3) {
      Object var9 = null;
      Object var8 = null;
      Object var10 = a(var1, var3.a);
      switch (<unrepresentable>.a[var3.b.ordinal()]) {
         case 1:
            label28: {
               long var6;
               try {
                  var6 = ((Number)var10).longValue();
               } catch (Exception var12) {
                  SmartStoreLogger.a("SmartStore", "Unexpected error", var12);
                  var15 = null;
                  break label28;
               }

               var15 = var6;
            }

            var2.put(var3.c, var15);
            break;
         case 2:
         case 3:
            String var16 = var3.c;
            String var14 = (String)var8;
            if (var10 != null) {
               var14 = var10.toString();
            }

            var2.put(var16, var14);
            break;
         case 4:
            label24: {
               double var4;
               try {
                  var4 = ((Number)var10).doubleValue();
               } catch (Exception var11) {
                  SmartStoreLogger.a("SmartStore", "Unexpected error", var11);
                  var13 = (Double)var9;
                  break label24;
               }

               var13 = var4;
            }

            var2.put(var3.c, var13);
      }
   }

   private void a(JSONObject var1, ContentValues var2, IndexSpec[] var3, SmartStore.TypeGroup var4) {
      for (IndexSpec var7 : var3) {
         if (var4.isMember(var7.b)) {
            this.a(var1, var2, var7);
         }
      }
   }

   private void b(Cursor var1) {
      if (var1 != null) {
         var1.close();
      }
   }

   private void b(SoupSpec var1, IndexSpec[] var2) {
      JSONArray var3 = new JSONArray();
      if (IndexSpec.c(var2)) {
         var3.put("JSON1");
      }

      if (IndexSpec.b(var2)) {
         var3.put("FTS");
      }

      if (var1.b().contains("externalStorage")) {
         var3.put("ExternalStorage");
      }

      JSONObject var5 = new JSONObject();

      try {
         var5.put("features", var3);
      } catch (JSONException var4) {
         SmartStoreLogger.a("SmartStore", "Exception thrown while building page object", var4);
      }

      EventBuilderHelper.b("registerSoup", null, "SmartStore", var5);
   }

   public static void b(SQLiteDatabase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: new java/lang/StringBuilder
      // 05: astore 1
      // 06: aload 1
      // 07: invokespecial java/lang/StringBuilder.<init> ()V
      // 0a: aload 1
      // 0b: ldc_w "CREATE TABLE IF NOT EXISTS "
      // 0e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11: ldc_w "long_operations_status"
      // 14: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 17: ldc " ("
      // 19: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c: ldc "id"
      // 1e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 21: ldc " INTEGER PRIMARY KEY AUTOINCREMENT"
      // 23: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 26: ldc ","
      // 28: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2b: ldc_w "type"
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: ldc " TEXT"
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: ldc ","
      // 38: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3b: ldc_w "details"
      // 3e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 41: ldc " TEXT"
      // 43: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 46: ldc ","
      // 48: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4b: ldc_w "status"
      // 4e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 51: ldc " TEXT"
      // 53: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 56: ldc_w ", "
      // 59: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5c: ldc_w "created"
      // 5f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 62: ldc_w " INTEGER"
      // 65: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 68: ldc_w ", "
      // 6b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 6e: ldc_w "lastModified"
      // 71: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 74: ldc_w " INTEGER"
      // 77: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7a: ldc ")"
      // 7c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7f: pop
      // 80: aload 0
      // 81: aload 1
      // 82: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 85: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 88: aload 0
      // 89: monitorexit
      // 8a: return
      // 8b: astore 1
      // 8c: aload 0
      // 8d: monitorexit
      // 8e: aload 1
      // 8f: athrow
      // try (2 -> 56): 57 null
      // try (58 -> 60): 57 null
   }

   private boolean f(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 3
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0b: aload 3
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.e (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Z
      // 10: istore 2
      // 11: aload 3
      // 12: monitorexit
      // 13: iload 2
      // 14: ireturn
      // 15: astore 1
      // 16: aload 3
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   public long a(String param1, String param2, String param3) {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 7
      // 06: aload 7
      // 08: monitorenter
      // 09: aload 7
      // 0b: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0e: aload 7
      // 10: aload 1
      // 11: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 14: astore 6
      // 16: aload 6
      // 18: ifnonnull 47
      // 1b: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 1e: astore 3
      // 1f: new java/lang/StringBuilder
      // 22: astore 2
      // 23: aload 2
      // 24: invokespecial java/lang/StringBuilder.<init> ()V
      // 27: aload 3
      // 28: aload 2
      // 29: ldc_w "Soup: "
      // 2c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2f: aload 1
      // 30: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 33: ldc_w " does not exist"
      // 36: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 39: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3c: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 3f: aload 3
      // 40: athrow
      // 41: astore 1
      // 42: aload 7
      // 44: monitorexit
      // 45: aload 1
      // 46: athrow
      // 47: aload 7
      // 49: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 4c: aload 7
      // 4e: aload 1
      // 4f: aload 2
      // 50: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 53: astore 1
      // 54: new java/lang/StringBuilder
      // 57: astore 8
      // 59: aload 8
      // 5b: invokespecial java/lang/StringBuilder.<init> ()V
      // 5e: aload 8
      // 60: aload 1
      // 61: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 64: ldc_w " = ?"
      // 67: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 6a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 6d: astore 1
      // 6e: aload 7
      // 70: aload 6
      // 72: bipush 1
      // 73: anewarray 92
      // 76: dup
      // 77: bipush 0
      // 78: ldc "id"
      // 7a: aastore
      // 7b: aload 1
      // 7c: bipush 1
      // 7d: anewarray 92
      // 80: dup
      // 81: bipush 0
      // 82: aload 3
      // 83: aastore
      // 84: aconst_null
      // 85: aconst_null
      // 86: aconst_null
      // 87: invokevirtual net/sqlcipher/database/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 8a: astore 6
      // 8c: aload 6
      // 8e: invokeinterface android/database/Cursor.getCount ()I 1
      // 93: bipush 1
      // 94: if_icmple be
      // 97: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 9a: astore 1
      // 9b: aload 1
      // 9c: ldc_w "There are more than one soup elements where %s is %s"
      // 9f: bipush 2
      // a0: anewarray 4
      // a3: dup
      // a4: bipush 0
      // a5: aload 2
      // a6: aastore
      // a7: dup
      // a8: bipush 1
      // a9: aload 3
      // aa: aastore
      // ab: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // ae: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // b1: aload 1
      // b2: athrow
      // b3: astore 1
      // b4: aload 6
      // b6: astore 2
      // b7: aload 0
      // b8: aload 2
      // b9: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // bc: aload 1
      // bd: athrow
      // be: aload 6
      // c0: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // c5: ifeq de
      // c8: aload 6
      // ca: bipush 0
      // cb: invokeinterface android/database/Cursor.getLong (I)J 2
      // d0: lstore 4
      // d2: aload 0
      // d3: aload 6
      // d5: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // d8: aload 7
      // da: monitorexit
      // db: lload 4
      // dd: lreturn
      // de: aload 0
      // df: aload 6
      // e1: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // e4: aload 7
      // e6: monitorexit
      // e7: ldc2_w -1
      // ea: lstore 4
      // ec: goto db
      // ef: astore 1
      // f0: aconst_null
      // f1: astore 2
      // f2: goto b7
      // try (5 -> 11): 31 null
      // try (13 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 43): 31 null
      // try (43 -> 74): 126 null
      // try (74 -> 96): 96 null
      // try (99 -> 104): 31 null
      // try (104 -> 111): 96 null
      // try (111 -> 116): 31 null
      // try (118 -> 123): 31 null
   }

   public SQLiteDatabase a() {
      SQLiteDatabase var1;
      if (this.a != null) {
         var1 = this.a;
      } else {
         var1 = this.b.getWritableDatabase(this.c);
      }

      return var1;
   }

   public JSONArray a(QuerySpec param1, int param2) throws JSONException {
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
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 10
      // 006: aload 10
      // 008: monitorenter
      // 009: aload 1
      // 00a: getfield com/salesforce/androidsdk/smartstore/store/QuerySpec.a Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
      // 00d: astore 11
      // 00f: aload 0
      // 010: aload 1
      // 011: getfield com/salesforce/androidsdk/smartstore/store/QuerySpec.c Ljava/lang/String;
      // 014: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.d (Ljava/lang/String;)Ljava/lang/String;
      // 017: astore 9
      // 019: aload 1
      // 01a: getfield com/salesforce/androidsdk/smartstore/store/QuerySpec.b I
      // 01d: istore 4
      // 01f: aload 1
      // 020: getfield com/salesforce/androidsdk/smartstore/store/QuerySpec.b I
      // 023: istore 3
      // 024: new java/lang/StringBuilder
      // 027: astore 8
      // 029: aload 8
      // 02b: invokespecial java/lang/StringBuilder.<init> ()V
      // 02e: aload 8
      // 030: iload 4
      // 032: iload 2
      // 033: imul
      // 034: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 037: ldc ","
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: iload 3
      // 03d: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 040: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 043: astore 12
      // 045: aconst_null
      // 046: astore 8
      // 048: aload 10
      // 04a: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 04d: aload 10
      // 04f: aload 9
      // 051: aload 12
      // 053: aload 1
      // 054: invokevirtual com/salesforce/androidsdk/smartstore/store/QuerySpec.a ()[Ljava/lang/String;
      // 057: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 05a: astore 9
      // 05c: aload 9
      // 05e: astore 8
      // 060: new org/json/JSONArray
      // 063: astore 12
      // 065: aload 9
      // 067: astore 8
      // 069: aload 12
      // 06b: invokespecial org/json/JSONArray.<init> ()V
      // 06e: aload 9
      // 070: astore 8
      // 072: aload 9
      // 074: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 079: ifeq 0b5
      // 07c: aload 9
      // 07e: astore 8
      // 080: aload 11
      // 082: getstatic com/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType.smart Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
      // 085: if_acmpeq 093
      // 088: aload 9
      // 08a: astore 8
      // 08c: aload 1
      // 08d: getfield com/salesforce/androidsdk/smartstore/store/QuerySpec.g [Ljava/lang/String;
      // 090: ifnull 0c1
      // 093: aload 9
      // 095: astore 8
      // 097: aload 12
      // 099: aload 0
      // 09a: aload 9
      // 09c: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Landroid/database/Cursor;)Lorg/json/JSONArray;
      // 09f: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 0a2: pop
      // 0a3: aload 9
      // 0a5: astore 8
      // 0a7: aload 9
      // 0a9: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0ae: istore 7
      // 0b0: iload 7
      // 0b2: ifne 07c
      // 0b5: aload 0
      // 0b6: aload 9
      // 0b8: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 0bb: aload 10
      // 0bd: monitorexit
      // 0be: aload 12
      // 0c0: areturn
      // 0c1: aload 9
      // 0c3: astore 8
      // 0c5: aload 9
      // 0c7: ldc "externalStorage"
      // 0c9: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0ce: iflt 132
      // 0d1: aload 9
      // 0d3: astore 8
      // 0d5: aload 9
      // 0d7: aload 9
      // 0d9: ldc "externalStorage"
      // 0db: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0e0: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0e5: astore 13
      // 0e7: aload 9
      // 0e9: astore 8
      // 0eb: aload 9
      // 0ed: aload 9
      // 0ef: ldc_w "_soupEntryId"
      // 0f2: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0f7: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0fc: lstore 5
      // 0fe: aload 9
      // 100: astore 8
      // 102: aload 12
      // 104: aload 0
      // 105: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 108: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 10b: aload 13
      // 10d: lload 5
      // 10f: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 112: invokevirtual java/lang/Long.longValue ()J
      // 115: aload 0
      // 116: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 119: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;
      // 11c: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 11f: pop
      // 120: goto 0a3
      // 123: astore 1
      // 124: aload 0
      // 125: aload 8
      // 127: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 12a: aload 1
      // 12b: athrow
      // 12c: astore 1
      // 12d: aload 10
      // 12f: monitorexit
      // 130: aload 1
      // 131: athrow
      // 132: aload 9
      // 134: astore 8
      // 136: new org/json/JSONObject
      // 139: astore 13
      // 13b: aload 9
      // 13d: astore 8
      // 13f: aload 13
      // 141: aload 9
      // 143: bipush 0
      // 144: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 149: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 14c: aload 9
      // 14e: astore 8
      // 150: aload 12
      // 152: aload 13
      // 154: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 157: pop
      // 158: goto 0a3
      // try (5 -> 34): 134 null
      // try (36 -> 45): 128 null
      // try (47 -> 49): 128 null
      // try (51 -> 53): 128 null
      // try (55 -> 58): 128 null
      // try (60 -> 63): 128 null
      // try (65 -> 68): 128 null
      // try (70 -> 76): 128 null
      // try (78 -> 81): 128 null
      // try (83 -> 88): 134 null
      // try (92 -> 96): 128 null
      // try (98 -> 104): 128 null
      // try (106 -> 112): 128 null
      // try (114 -> 127): 128 null
      // try (129 -> 134): 134 null
      // try (135 -> 137): 134 null
      // try (141 -> 143): 128 null
      // try (145 -> 150): 128 null
      // try (152 -> 156): 128 null
   }

   public JSONArray a(String param1, Long... param2) throws JSONException {
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
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 8
      // 006: aload 8
      // 008: monitorenter
      // 009: aload 8
      // 00b: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 00e: aload 8
      // 010: aload 1
      // 011: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 014: astore 10
      // 016: aload 10
      // 018: ifnonnull 04a
      // 01b: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 01e: astore 9
      // 020: new java/lang/StringBuilder
      // 023: astore 2
      // 024: aload 2
      // 025: invokespecial java/lang/StringBuilder.<init> ()V
      // 028: aload 9
      // 02a: aload 2
      // 02b: ldc_w "Soup: "
      // 02e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 031: aload 1
      // 032: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 035: ldc_w " does not exist"
      // 038: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 03e: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 041: aload 9
      // 043: athrow
      // 044: astore 1
      // 045: aload 8
      // 047: monitorexit
      // 048: aload 1
      // 049: athrow
      // 04a: new org/json/JSONArray
      // 04d: astore 9
      // 04f: aload 9
      // 051: invokespecial org/json/JSONArray.<init> ()V
      // 054: aload 0
      // 055: aload 1
      // 056: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 059: ifeq 09e
      // 05c: aload 0
      // 05d: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 060: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 063: ifeq 09e
      // 066: aload 2
      // 067: arraylength
      // 068: istore 4
      // 06a: bipush 0
      // 06b: istore 3
      // 06c: iload 3
      // 06d: iload 4
      // 06f: if_icmpge 113
      // 072: aload 2
      // 073: iload 3
      // 074: aaload
      // 075: invokevirtual java/lang/Long.longValue ()J
      // 078: lstore 5
      // 07a: aload 0
      // 07b: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 07e: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 081: aload 10
      // 083: lload 5
      // 085: aload 0
      // 086: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 089: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;
      // 08c: astore 1
      // 08d: aload 1
      // 08e: ifnull 098
      // 091: aload 9
      // 093: aload 1
      // 094: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 097: pop
      // 098: iinc 3 1
      // 09b: goto 06c
      // 09e: aload 8
      // 0a0: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0a3: astore 1
      // 0a4: aload 0
      // 0a5: aload 2
      // 0a6: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a ([Ljava/lang/Long;)Ljava/lang/String;
      // 0a9: astore 11
      // 0ab: aconst_null
      // 0ac: checkcast [Ljava/lang/String;
      // 0af: astore 2
      // 0b0: aload 1
      // 0b1: aload 8
      // 0b3: aload 10
      // 0b5: bipush 1
      // 0b6: anewarray 92
      // 0b9: dup
      // 0ba: bipush 0
      // 0bb: ldc "soup"
      // 0bd: aastore
      // 0be: aconst_null
      // 0bf: aconst_null
      // 0c0: aload 11
      // 0c2: aload 2
      // 0c3: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 0c6: astore 1
      // 0c7: aload 1
      // 0c8: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0cd: istore 7
      // 0cf: iload 7
      // 0d1: ifne 0df
      // 0d4: aload 0
      // 0d5: aload 1
      // 0d6: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 0d9: aload 8
      // 0db: monitorexit
      // 0dc: aload 9
      // 0de: areturn
      // 0df: aload 1
      // 0e0: aload 1
      // 0e1: ldc "soup"
      // 0e3: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0e8: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0ed: astore 2
      // 0ee: new org/json/JSONObject
      // 0f1: astore 10
      // 0f3: aload 10
      // 0f5: aload 2
      // 0f6: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 0f9: aload 9
      // 0fb: aload 10
      // 0fd: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 100: pop
      // 101: aload 1
      // 102: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 107: istore 7
      // 109: iload 7
      // 10b: ifne 0df
      // 10e: aload 0
      // 10f: aload 1
      // 110: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 113: aload 8
      // 115: monitorexit
      // 116: goto 0dc
      // 119: astore 2
      // 11a: aconst_null
      // 11b: astore 1
      // 11c: aload 0
      // 11d: aload 1
      // 11e: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 121: aload 2
      // 122: athrow
      // 123: astore 2
      // 124: goto 11c
      // try (5 -> 11): 31 null
      // try (13 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 51): 31 null
      // try (56 -> 70): 31 null
      // try (72 -> 76): 31 null
      // try (78 -> 103): 141 null
      // try (103 -> 106): 149 null
      // try (108 -> 113): 31 null
      // try (115 -> 133): 149 null
      // try (135 -> 138): 31 null
      // try (138 -> 140): 31 null
      // try (144 -> 149): 31 null
   }

   public JSONObject a(String param1, JSONObject param2) throws JSONException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: aload 2
      // 0a: ldc_w "_soupEntryId"
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
      // 10: astore 1
      // 11: aload 3
      // 12: monitorexit
      // 13: aload 1
      // 14: areturn
      // 15: astore 1
      // 16: aload 3
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   public JSONObject a(String param1, JSONObject param2, long param3, boolean param5) throws JSONException {
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
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 10
      // 006: aload 10
      // 008: monitorenter
      // 009: iload 5
      // 00b: ifeq 013
      // 00e: aload 10
      // 010: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 013: aload 10
      // 015: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 018: aload 10
      // 01a: aload 1
      // 01b: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 01e: astore 11
      // 020: aload 11
      // 022: ifnonnull 061
      // 025: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 028: astore 11
      // 02a: new java/lang/StringBuilder
      // 02d: astore 2
      // 02e: aload 2
      // 02f: invokespecial java/lang/StringBuilder.<init> ()V
      // 032: aload 11
      // 034: aload 2
      // 035: ldc_w "Soup: "
      // 038: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03b: aload 1
      // 03c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03f: ldc_w " does not exist"
      // 042: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 045: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 048: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 04b: aload 11
      // 04d: athrow
      // 04e: astore 1
      // 04f: iload 5
      // 051: ifeq 059
      // 054: aload 10
      // 056: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 059: aload 1
      // 05a: athrow
      // 05b: astore 1
      // 05c: aload 10
      // 05e: monitorexit
      // 05f: aload 1
      // 060: athrow
      // 061: aload 10
      // 063: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 066: aload 10
      // 068: aload 1
      // 069: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.c (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 06c: astore 12
      // 06e: invokestatic java/lang/System.currentTimeMillis ()J
      // 071: lstore 6
      // 073: aload 2
      // 074: ldc_w "_soupEntryId"
      // 077: lload 3
      // 078: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 07b: pop
      // 07c: aload 2
      // 07d: ldc_w "_soupLastModifiedDate"
      // 080: lload 6
      // 082: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 085: pop
      // 086: new android/content/ContentValues
      // 089: astore 15
      // 08b: aload 15
      // 08d: invokespecial android/content/ContentValues.<init> ()V
      // 090: aload 15
      // 092: ldc_w "lastModified"
      // 095: lload 6
      // 097: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 09a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 09d: aload 0
      // 09e: aload 2
      // 09f: aload 15
      // 0a1: aload 12
      // 0a3: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 0a6: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 0a9: aload 0
      // 0aa: aload 1
      // 0ab: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 0ae: ifne 0bc
      // 0b1: aload 15
      // 0b3: ldc "soup"
      // 0b5: aload 2
      // 0b6: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
      // 0b9: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0bc: aload 10
      // 0be: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0c1: astore 13
      // 0c3: new java/lang/StringBuilder
      // 0c6: astore 14
      // 0c8: aload 14
      // 0ca: invokespecial java/lang/StringBuilder.<init> ()V
      // 0cd: aload 13
      // 0cf: aload 10
      // 0d1: aload 11
      // 0d3: aload 15
      // 0d5: ldc_w "id = ?"
      // 0d8: bipush 1
      // 0d9: anewarray 92
      // 0dc: dup
      // 0dd: bipush 0
      // 0de: aload 14
      // 0e0: lload 3
      // 0e1: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 0e4: ldc ""
      // 0e6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ec: aastore
      // 0ed: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0f0: bipush 1
      // 0f1: if_icmpne 1ce
      // 0f4: bipush 1
      // 0f5: istore 9
      // 0f7: iload 9
      // 0f9: istore 8
      // 0fb: iload 9
      // 0fd: ifeq 179
      // 100: iload 9
      // 102: istore 8
      // 104: aload 0
      // 105: aload 1
      // 106: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.f (Ljava/lang/String;)Z
      // 109: ifeq 179
      // 10c: new java/lang/StringBuilder
      // 10f: astore 13
      // 111: aload 13
      // 113: invokespecial java/lang/StringBuilder.<init> ()V
      // 116: aload 13
      // 118: aload 11
      // 11a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11d: ldc_w "_fts"
      // 120: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 123: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 126: astore 14
      // 128: new android/content/ContentValues
      // 12b: astore 13
      // 12d: aload 13
      // 12f: invokespecial android/content/ContentValues.<init> ()V
      // 132: aload 0
      // 133: aload 2
      // 134: aload 13
      // 136: aload 12
      // 138: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_fts_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 13b: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 13e: aload 10
      // 140: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 143: astore 12
      // 145: new java/lang/StringBuilder
      // 148: astore 15
      // 14a: aload 15
      // 14c: invokespecial java/lang/StringBuilder.<init> ()V
      // 14f: aload 12
      // 151: aload 10
      // 153: aload 14
      // 155: aload 13
      // 157: ldc_w "rowid =?"
      // 15a: bipush 1
      // 15b: anewarray 92
      // 15e: dup
      // 15f: bipush 0
      // 160: aload 15
      // 162: lload 3
      // 163: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 166: ldc ""
      // 168: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 16e: aastore
      // 16f: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 172: bipush 1
      // 173: if_icmpne 1d4
      // 176: bipush 1
      // 177: istore 8
      // 179: iload 8
      // 17b: istore 9
      // 17d: iload 8
      // 17f: ifeq 1b0
      // 182: iload 8
      // 184: istore 9
      // 186: aload 0
      // 187: aload 1
      // 188: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 18b: ifeq 1b0
      // 18e: iload 8
      // 190: istore 9
      // 192: aload 0
      // 193: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 196: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 199: ifeq 1b0
      // 19c: aload 0
      // 19d: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 1a0: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 1a3: aload 11
      // 1a5: lload 3
      // 1a6: aload 2
      // 1a7: aload 0
      // 1a8: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 1ab: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLorg/json/JSONObject;Ljava/lang/String;)Z
      // 1ae: istore 9
      // 1b0: iload 9
      // 1b2: ifeq 1da
      // 1b5: iload 5
      // 1b7: ifeq 1bf
      // 1ba: aload 10
      // 1bc: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 1bf: iload 5
      // 1c1: ifeq 1c9
      // 1c4: aload 10
      // 1c6: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 1c9: aload 10
      // 1cb: monitorexit
      // 1cc: aload 2
      // 1cd: areturn
      // 1ce: bipush 0
      // 1cf: istore 9
      // 1d1: goto 0f7
      // 1d4: bipush 0
      // 1d5: istore 8
      // 1d7: goto 179
      // 1da: aconst_null
      // 1db: astore 2
      // 1dc: iload 5
      // 1de: ifeq 1e6
      // 1e1: aload 10
      // 1e3: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 1e6: aload 10
      // 1e8: monitorexit
      // 1e9: goto 1cc
      // try (7 -> 9): 35 null
      // try (9 -> 15): 35 null
      // try (17 -> 35): 35 null
      // try (38 -> 40): 42 null
      // try (40 -> 42): 42 null
      // try (43 -> 45): 42 null
      // try (47 -> 89): 35 null
      // try (89 -> 115): 35 null
      // try (123 -> 174): 35 null
      // try (182 -> 186): 35 null
      // try (188 -> 202): 35 null
      // try (206 -> 208): 35 null
      // try (210 -> 212): 42 null
      // try (212 -> 214): 42 null
      // try (226 -> 228): 42 null
      // try (228 -> 230): 42 null
   }

   public JSONObject a(String param1, JSONObject param2, String param3) throws JSONException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: aload 1
      // 0b: aload 2
      // 0c: aload 3
      // 0d: bipush 1
      // 0e: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)Lorg/json/JSONObject;
      // 11: astore 1
      // 12: aload 4
      // 14: monitorexit
      // 15: aload 1
      // 16: areturn
      // 17: astore 1
      // 18: aload 4
      // 1a: monitorexit
      // 1b: aload 1
      // 1c: athrow
      // try (5 -> 14): 16 null
      // try (17 -> 19): 16 null
   }

   public JSONObject a(String param1, JSONObject param2, String param3, boolean param4) throws JSONException {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 7
      // 06: aload 7
      // 08: monitorenter
      // 09: aload 3
      // 0a: ldc_w "_soupEntryId"
      // 0d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10: ifeq 3f
      // 13: aload 2
      // 14: ldc_w "_soupEntryId"
      // 17: invokevirtual org/json/JSONObject.has (Ljava/lang/String;)Z
      // 1a: ifeq 84
      // 1d: aload 2
      // 1e: ldc_w "_soupEntryId"
      // 21: invokevirtual org/json/JSONObject.getLong (Ljava/lang/String;)J
      // 24: lstore 5
      // 26: lload 5
      // 28: ldc2_w -1
      // 2b: lcmp
      // 2c: ifeq 6f
      // 2f: aload 0
      // 30: aload 1
      // 31: aload 2
      // 32: lload 5
      // 34: iload 4
      // 36: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;Lorg/json/JSONObject;JZ)Lorg/json/JSONObject;
      // 39: astore 1
      // 3a: aload 7
      // 3c: monitorexit
      // 3d: aload 1
      // 3e: areturn
      // 3f: aload 2
      // 40: aload 3
      // 41: invokestatic com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;
      // 44: astore 9
      // 46: aload 9
      // 48: ifnull 84
      // 4b: new java/lang/StringBuilder
      // 4e: astore 8
      // 50: aload 8
      // 52: invokespecial java/lang/StringBuilder.<init> ()V
      // 55: aload 0
      // 56: aload 1
      // 57: aload 3
      // 58: aload 8
      // 5a: aload 9
      // 5c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 5f: ldc ""
      // 61: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 64: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 67: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
      // 6a: lstore 5
      // 6c: goto 26
      // 6f: aload 0
      // 70: aload 1
      // 71: aload 2
      // 72: iload 4
      // 74: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
      // 77: astore 1
      // 78: aload 7
      // 7a: monitorexit
      // 7b: goto 3d
      // 7e: astore 1
      // 7f: aload 7
      // 81: monitorexit
      // 82: aload 1
      // 83: athrow
      // 84: ldc2_w -1
      // 87: lstore 5
      // 89: goto 26
      // try (5 -> 17): 63 null
      // try (21 -> 30): 63 null
      // try (32 -> 36): 63 null
      // try (38 -> 53): 63 null
      // try (54 -> 62): 63 null
      // try (64 -> 66): 63 null
   }

   public JSONObject a(String param1, JSONObject param2, boolean param3) throws JSONException {
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
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 10
      // 006: aload 10
      // 008: monitorenter
      // 009: aload 10
      // 00b: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 00e: aload 10
      // 010: aload 1
      // 011: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 014: astore 11
      // 016: aload 11
      // 018: ifnonnull 04a
      // 01b: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 01e: astore 2
      // 01f: new java/lang/StringBuilder
      // 022: astore 11
      // 024: aload 11
      // 026: invokespecial java/lang/StringBuilder.<init> ()V
      // 029: aload 2
      // 02a: aload 11
      // 02c: ldc_w "Soup: "
      // 02f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 032: aload 1
      // 033: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 036: ldc_w " does not exist"
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 03f: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 042: aload 2
      // 043: athrow
      // 044: astore 1
      // 045: aload 10
      // 047: monitorexit
      // 048: aload 1
      // 049: athrow
      // 04a: aload 10
      // 04c: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 04f: aload 10
      // 051: aload 1
      // 052: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.c (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 055: astore 12
      // 057: iload 3
      // 058: ifeq 060
      // 05b: aload 10
      // 05d: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 060: invokestatic java/lang/System.currentTimeMillis ()J
      // 063: lstore 8
      // 065: aload 10
      // 067: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 06a: aload 10
      // 06c: aload 11
      // 06e: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)J
      // 071: lstore 6
      // 073: aload 2
      // 074: ldc_w "_soupEntryId"
      // 077: lload 6
      // 079: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 07c: pop
      // 07d: aload 2
      // 07e: ldc_w "_soupLastModifiedDate"
      // 081: lload 8
      // 083: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 086: pop
      // 087: new android/content/ContentValues
      // 08a: astore 13
      // 08c: aload 13
      // 08e: invokespecial android/content/ContentValues.<init> ()V
      // 091: aload 13
      // 093: ldc "id"
      // 095: lload 6
      // 097: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 09a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 09d: aload 13
      // 09f: ldc_w "created"
      // 0a2: lload 8
      // 0a4: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0a7: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 0aa: aload 13
      // 0ac: ldc_w "lastModified"
      // 0af: lload 8
      // 0b1: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0b4: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 0b7: aload 0
      // 0b8: aload 1
      // 0b9: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 0bc: ifne 0ca
      // 0bf: aload 13
      // 0c1: ldc "soup"
      // 0c3: aload 2
      // 0c4: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
      // 0c7: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0ca: aload 0
      // 0cb: aload 2
      // 0cc: aload 13
      // 0ce: aload 12
      // 0d0: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 0d3: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 0d6: aload 10
      // 0d8: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0db: aload 10
      // 0dd: aload 11
      // 0df: aload 13
      // 0e1: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 0e4: lload 6
      // 0e6: lcmp
      // 0e7: ifne 198
      // 0ea: bipush 1
      // 0eb: istore 4
      // 0ed: iload 4
      // 0ef: ifeq 144
      // 0f2: aload 0
      // 0f3: aload 1
      // 0f4: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.f (Ljava/lang/String;)Z
      // 0f7: ifeq 144
      // 0fa: new java/lang/StringBuilder
      // 0fd: astore 13
      // 0ff: aload 13
      // 101: invokespecial java/lang/StringBuilder.<init> ()V
      // 104: aload 13
      // 106: aload 11
      // 108: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10b: ldc_w "_fts"
      // 10e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 111: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 114: astore 14
      // 116: new android/content/ContentValues
      // 119: astore 13
      // 11b: aload 13
      // 11d: invokespecial android/content/ContentValues.<init> ()V
      // 120: aload 13
      // 122: ldc_w "rowid"
      // 125: lload 6
      // 127: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 12a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 12d: aload 0
      // 12e: aload 2
      // 12f: aload 13
      // 131: aload 12
      // 133: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_fts_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 136: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 139: aload 10
      // 13b: aload 14
      // 13d: aconst_null
      // 13e: aload 13
      // 140: invokevirtual net/sqlcipher/database/SQLiteDatabase.insert (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 143: pop2
      // 144: iload 4
      // 146: istore 5
      // 148: iload 4
      // 14a: ifeq 17c
      // 14d: iload 4
      // 14f: istore 5
      // 151: aload 0
      // 152: aload 1
      // 153: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 156: ifeq 17c
      // 159: iload 4
      // 15b: istore 5
      // 15d: aload 0
      // 15e: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 161: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 164: ifeq 17c
      // 167: aload 0
      // 168: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 16b: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 16e: aload 11
      // 170: lload 6
      // 172: aload 2
      // 173: aload 0
      // 174: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 177: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLorg/json/JSONObject;Ljava/lang/String;)Z
      // 17a: istore 5
      // 17c: iload 5
      // 17e: ifeq 19e
      // 181: iload 3
      // 182: ifeq 18a
      // 185: aload 10
      // 187: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 18a: iload 3
      // 18b: ifeq 193
      // 18e: aload 10
      // 190: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 193: aload 10
      // 195: monitorexit
      // 196: aload 2
      // 197: areturn
      // 198: bipush 0
      // 199: istore 4
      // 19b: goto 0ed
      // 19e: iload 3
      // 19f: ifeq 1a7
      // 1a2: aload 10
      // 1a4: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 1a7: aload 10
      // 1a9: monitorexit
      // 1aa: aconst_null
      // 1ab: astore 2
      // 1ac: goto 196
      // 1af: astore 1
      // 1b0: iload 3
      // 1b1: ifeq 1b9
      // 1b4: aload 10
      // 1b6: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 1b9: aload 1
      // 1ba: athrow
      // try (5 -> 11): 31 null
      // try (13 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 42): 31 null
      // try (44 -> 46): 199 null
      // try (46 -> 92): 199 null
      // try (92 -> 107): 199 null
      // try (111 -> 147): 199 null
      // try (153 -> 157): 199 null
      // try (159 -> 173): 199 null
      // try (177 -> 179): 199 null
      // try (181 -> 183): 31 null
      // try (183 -> 185): 31 null
      // try (192 -> 194): 31 null
      // try (194 -> 196): 31 null
      // try (202 -> 204): 31 null
      // try (204 -> 206): 31 null
   }

   public void a(SoupSpec param1, IndexSpec[] param2) {
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
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 3
      // 005: aload 3
      // 006: monitorenter
      // 007: aload 1
      // 008: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.a ()Ljava/lang/String;
      // 00b: astore 4
      // 00d: aload 4
      // 00f: ifnonnull 038
      // 012: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 015: astore 2
      // 016: new java/lang/StringBuilder
      // 019: astore 1
      // 01a: aload 1
      // 01b: invokespecial java/lang/StringBuilder.<init> ()V
      // 01e: aload 2
      // 01f: aload 1
      // 020: ldc_w "Bogus soup name:"
      // 023: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 026: aload 4
      // 028: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 02e: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 031: aload 2
      // 032: athrow
      // 033: astore 1
      // 034: aload 3
      // 035: monitorexit
      // 036: aload 1
      // 037: athrow
      // 038: aload 2
      // 039: arraylength
      // 03a: ifne 05e
      // 03d: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 040: astore 2
      // 041: new java/lang/StringBuilder
      // 044: astore 1
      // 045: aload 1
      // 046: invokespecial java/lang/StringBuilder.<init> ()V
      // 049: aload 2
      // 04a: aload 1
      // 04b: ldc_w "No indexSpecs specified for soup: "
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: aload 4
      // 053: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 056: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 059: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 05c: aload 2
      // 05d: athrow
      // 05e: aload 2
      // 05f: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.c ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z
      // 062: ifeq 094
      // 065: aload 1
      // 066: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 069: ldc "externalStorage"
      // 06b: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 070: ifeq 094
      // 073: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 076: astore 1
      // 077: new java/lang/StringBuilder
      // 07a: astore 2
      // 07b: aload 2
      // 07c: invokespecial java/lang/StringBuilder.<init> ()V
      // 07f: aload 1
      // 080: aload 2
      // 081: ldc_w "Can't have JSON1 index specs in externally stored soup:"
      // 084: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 087: aload 4
      // 089: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08f: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 092: aload 1
      // 093: athrow
      // 094: aload 0
      // 095: aload 4
      // 097: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.c (Ljava/lang/String;)Z
      // 09a: ifeq 0a0
      // 09d: aload 3
      // 09e: monitorexit
      // 09f: return
      // 0a0: new android/content/ContentValues
      // 0a3: astore 5
      // 0a5: aload 5
      // 0a7: invokespecial android/content/ContentValues.<init> ()V
      // 0aa: aload 5
      // 0ac: ldc "soupName"
      // 0ae: aload 4
      // 0b0: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0b3: aload 1
      // 0b4: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 0b7: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0bc: astore 4
      // 0be: aload 4
      // 0c0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0c5: ifeq 0de
      // 0c8: aload 5
      // 0ca: aload 4
      // 0cc: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d1: checkcast java/lang/String
      // 0d4: bipush 1
      // 0d5: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0d8: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 0db: goto 0be
      // 0de: aload 3
      // 0df: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 0e2: aload 0
      // 0e3: aload 1
      // 0e4: aload 2
      // 0e5: aload 3
      // 0e6: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0e9: aload 3
      // 0ea: ldc "soup_attrs"
      // 0ec: aload 5
      // 0ee: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 0f1: invokestatic com/salesforce/androidsdk/smartstore/store/SmartStore.a (J)Ljava/lang/String;
      // 0f4: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Ljava/lang/String;)V
      // 0f7: aload 3
      // 0f8: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 0fb: aload 3
      // 0fc: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 0ff: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 102: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.C ()Z
      // 105: ifeq 11a
      // 108: aload 0
      // 109: aload 1
      // 10a: aload 2
      // 10b: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
      // 10e: aload 3
      // 10f: monitorexit
      // 110: goto 09f
      // 113: astore 1
      // 114: aload 3
      // 115: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 118: aload 1
      // 119: athrow
      // 11a: aload 0
      // 11b: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.e Ljava/util/concurrent/ExecutorService;
      // 11e: astore 5
      // 120: new com/salesforce/androidsdk/smartstore/store/SmartStore$1
      // 123: astore 4
      // 125: aload 4
      // 127: aload 0
      // 128: aload 1
      // 129: aload 2
      // 12a: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$1.<init> (Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
      // 12d: aload 5
      // 12f: aload 4
      // 131: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
      // 136: goto 10e
      // try (5 -> 8): 26 null
      // try (10 -> 26): 26 null
      // try (27 -> 29): 26 null
      // try (31 -> 50): 26 null
      // try (50 -> 74): 26 null
      // try (74 -> 80): 26 null
      // try (81 -> 93): 26 null
      // try (93 -> 103): 26 null
      // try (104 -> 119): 131 null
      // try (119 -> 128): 26 null
      // try (128 -> 130): 26 null
      // try (132 -> 136): 26 null
      // try (136 -> 149): 26 null
   }

   protected void a(SoupSpec param1, IndexSpec[] param2, String param3) {
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
      // 000: new java/lang/StringBuilder
      // 003: dup
      // 004: invokespecial java/lang/StringBuilder.<init> ()V
      // 007: astore 12
      // 009: new java/lang/StringBuilder
      // 00c: dup
      // 00d: invokespecial java/lang/StringBuilder.<init> ()V
      // 010: astore 10
      // 012: new java/util/ArrayList
      // 015: dup
      // 016: invokespecial java/util/ArrayList.<init> ()V
      // 019: astore 11
      // 01b: new java/util/ArrayList
      // 01e: dup
      // 01f: invokespecial java/util/ArrayList.<init> ()V
      // 022: astore 9
      // 024: aload 2
      // 025: arraylength
      // 026: anewarray 272
      // 029: astore 7
      // 02b: new java/util/ArrayList
      // 02e: dup
      // 02f: invokespecial java/util/ArrayList.<init> ()V
      // 032: astore 13
      // 034: aload 1
      // 035: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.a ()Ljava/lang/String;
      // 038: astore 8
      // 03a: aload 12
      // 03c: ldc "CREATE TABLE "
      // 03e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 041: aload 3
      // 042: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 045: ldc " ("
      // 047: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04a: ldc "id"
      // 04c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04f: ldc " INTEGER PRIMARY KEY AUTOINCREMENT"
      // 051: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 054: pop
      // 055: aload 0
      // 056: aload 8
      // 058: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 05b: ifne 071
      // 05e: aload 12
      // 060: ldc_w ", "
      // 063: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 066: ldc "soup"
      // 068: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06b: ldc " TEXT"
      // 06d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 070: pop
      // 071: aload 12
      // 073: ldc_w ", "
      // 076: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 079: ldc_w "created"
      // 07c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07f: ldc_w " INTEGER"
      // 082: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 085: ldc_w ", "
      // 088: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08b: ldc_w "lastModified"
      // 08e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 091: ldc_w " INTEGER"
      // 094: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 097: pop
      // 098: bipush 2
      // 099: anewarray 92
      // 09c: astore 14
      // 09e: aload 14
      // 0a0: bipush 0
      // 0a1: ldc_w "created"
      // 0a4: aastore
      // 0a5: aload 14
      // 0a7: bipush 1
      // 0a8: ldc_w "lastModified"
      // 0ab: aastore
      // 0ac: aload 14
      // 0ae: arraylength
      // 0af: istore 5
      // 0b1: bipush 0
      // 0b2: istore 4
      // 0b4: iload 4
      // 0b6: iload 5
      // 0b8: if_icmpge 0e9
      // 0bb: aload 14
      // 0bd: iload 4
      // 0bf: aaload
      // 0c0: astore 1
      // 0c1: aload 11
      // 0c3: ldc_w "CREATE INDEX %s_%s_idx on %s ( %s )"
      // 0c6: bipush 4
      // 0c7: anewarray 4
      // 0ca: dup
      // 0cb: bipush 0
      // 0cc: aload 3
      // 0cd: aastore
      // 0ce: dup
      // 0cf: bipush 1
      // 0d0: aload 1
      // 0d1: aastore
      // 0d2: dup
      // 0d3: bipush 2
      // 0d4: aload 3
      // 0d5: aastore
      // 0d6: dup
      // 0d7: bipush 3
      // 0d8: aload 1
      // 0d9: aastore
      // 0da: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 0dd: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0e2: pop
      // 0e3: iinc 4 1
      // 0e6: goto 0b4
      // 0e9: aload 2
      // 0ea: arraylength
      // 0eb: istore 6
      // 0ed: bipush 0
      // 0ee: istore 5
      // 0f0: bipush 0
      // 0f1: istore 4
      // 0f3: iload 4
      // 0f5: iload 6
      // 0f7: if_icmpge 21f
      // 0fa: aload 2
      // 0fb: iload 4
      // 0fd: aaload
      // 0fe: astore 14
      // 100: new java/lang/StringBuilder
      // 103: dup
      // 104: invokespecial java/lang/StringBuilder.<init> ()V
      // 107: aload 3
      // 108: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10b: ldc_w "_"
      // 10e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 111: iload 5
      // 113: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 116: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 119: astore 1
      // 11a: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_indexed_with_json_extract Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 11d: aload 14
      // 11f: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 122: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.isMember (Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z
      // 125: ifeq 147
      // 128: new java/lang/StringBuilder
      // 12b: dup
      // 12c: invokespecial java/lang/StringBuilder.<init> ()V
      // 12f: ldc_w "json_extract(soup, '$."
      // 132: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 135: aload 14
      // 137: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.a Ljava/lang/String;
      // 13a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 13d: ldc_w "')"
      // 140: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 143: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 146: astore 1
      // 147: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 14a: aload 14
      // 14c: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 14f: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.isMember (Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z
      // 152: ifeq 177
      // 155: aload 14
      // 157: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 15a: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 15d: astore 15
      // 15f: aload 12
      // 161: ldc_w ", "
      // 164: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 167: aload 1
      // 168: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16b: ldc_w " "
      // 16e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 171: aload 15
      // 173: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 176: pop
      // 177: aload 14
      // 179: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 17c: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$Type.full_text Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 17f: if_acmpne 18b
      // 182: aload 13
      // 184: aload 1
      // 185: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 18a: pop
      // 18b: new android/content/ContentValues
      // 18e: dup
      // 18f: invokespecial android/content/ContentValues.<init> ()V
      // 192: astore 15
      // 194: aload 15
      // 196: ldc "soupName"
      // 198: aload 8
      // 19a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 19d: aload 15
      // 19f: ldc "path"
      // 1a1: aload 14
      // 1a3: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.a Ljava/lang/String;
      // 1a6: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 1a9: aload 15
      // 1ab: ldc "columnName"
      // 1ad: aload 1
      // 1ae: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 1b1: aload 15
      // 1b3: ldc "columnType"
      // 1b5: aload 14
      // 1b7: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 1ba: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.toString ()Ljava/lang/String;
      // 1bd: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 1c0: aload 9
      // 1c2: aload 15
      // 1c4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1c9: pop
      // 1ca: aload 11
      // 1cc: ldc_w "CREATE INDEX %s_%s_idx on %s ( %s )"
      // 1cf: bipush 4
      // 1d0: anewarray 4
      // 1d3: dup
      // 1d4: bipush 0
      // 1d5: aload 3
      // 1d6: aastore
      // 1d7: dup
      // 1d8: bipush 1
      // 1d9: new java/lang/StringBuilder
      // 1dc: dup
      // 1dd: invokespecial java/lang/StringBuilder.<init> ()V
      // 1e0: ldc ""
      // 1e2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e5: iload 5
      // 1e7: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1ea: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1ed: aastore
      // 1ee: dup
      // 1ef: bipush 2
      // 1f0: aload 3
      // 1f1: aastore
      // 1f2: dup
      // 1f3: bipush 3
      // 1f4: aload 1
      // 1f5: aastore
      // 1f6: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 1f9: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1fe: pop
      // 1ff: aload 7
      // 201: iload 5
      // 203: new com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 206: dup
      // 207: aload 14
      // 209: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.a Ljava/lang/String;
      // 20c: aload 14
      // 20e: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 211: aload 1
      // 212: invokespecial com/salesforce/androidsdk/smartstore/store/IndexSpec.<init> (Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V
      // 215: aastore
      // 216: iinc 5 1
      // 219: iinc 4 1
      // 21c: goto 0f3
      // 21f: aload 12
      // 221: ldc ")"
      // 223: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 226: pop
      // 227: aload 13
      // 229: invokeinterface java/util/List.size ()I 1
      // 22e: ifle 25c
      // 231: aload 10
      // 233: ldc_w "CREATE VIRTUAL TABLE %s%s USING %s(%s)"
      // 236: bipush 4
      // 237: anewarray 4
      // 23a: dup
      // 23b: bipush 0
      // 23c: aload 3
      // 23d: aastore
      // 23e: dup
      // 23f: bipush 1
      // 240: ldc_w "_fts"
      // 243: aastore
      // 244: dup
      // 245: bipush 2
      // 246: aload 0
      // 247: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.d Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;
      // 24a: aastore
      // 24b: dup
      // 24c: bipush 3
      // 24d: ldc ","
      // 24f: aload 13
      // 251: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 254: aastore
      // 255: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 258: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 25b: pop
      // 25c: aload 0
      // 25d: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 260: astore 1
      // 261: aload 1
      // 262: aload 12
      // 264: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 267: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 26a: aload 13
      // 26c: invokeinterface java/util/List.size ()I 1
      // 271: ifle 27d
      // 274: aload 1
      // 275: aload 10
      // 277: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 27a: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 27d: aload 11
      // 27f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 284: astore 2
      // 285: aload 2
      // 286: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28b: ifeq 2a1
      // 28e: aload 1
      // 28f: aload 2
      // 290: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 295: checkcast java/lang/String
      // 298: invokevirtual java/lang/String.toString ()Ljava/lang/String;
      // 29b: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 29e: goto 285
      // 2a1: aload 1
      // 2a2: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 2a5: aload 9
      // 2a7: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2ac: astore 9
      // 2ae: aload 9
      // 2b0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2b5: ifeq 2d9
      // 2b8: aload 9
      // 2ba: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2bf: checkcast android/content/ContentValues
      // 2c2: astore 2
      // 2c3: aload 1
      // 2c4: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 2c7: aload 1
      // 2c8: ldc "soup_index_map"
      // 2ca: aload 2
      // 2cb: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 2ce: pop2
      // 2cf: goto 2ae
      // 2d2: astore 2
      // 2d3: aload 1
      // 2d4: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 2d7: aload 2
      // 2d8: athrow
      // 2d9: aload 0
      // 2da: aload 8
      // 2dc: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 2df: ifeq 2f8
      // 2e2: aload 0
      // 2e3: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 2e6: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 2e9: ifeq 2f8
      // 2ec: aload 0
      // 2ed: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 2f0: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 2f3: aload 3
      // 2f4: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.b (Ljava/lang/String;)Z
      // 2f7: pop
      // 2f8: aload 1
      // 2f9: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 2fc: aload 1
      // 2fd: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 300: aload 8
      // 302: aload 3
      // 303: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Ljava/lang/String;Ljava/lang/String;)V
      // 306: aload 1
      // 307: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 30a: aload 8
      // 30c: aload 7
      // 30e: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
      // 311: aload 1
      // 312: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 315: return
      // try (313 -> 318): 333 null
      // try (318 -> 332): 333 null
      // try (338 -> 352): 333 null
      // try (352 -> 364): 333 null
   }

   public void a(String var1, IndexSpec[] var2) {
      this.a(new SoupSpec(var1), var2);
   }

   public void a(String param1, String[] param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 004: astore 9
      // 006: aload 9
      // 008: monitorenter
      // 009: aload 9
      // 00b: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 00e: aload 9
      // 010: aload 1
      // 011: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 014: astore 10
      // 016: aload 10
      // 018: ifnonnull 04a
      // 01b: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 01e: astore 8
      // 020: new java/lang/StringBuilder
      // 023: astore 2
      // 024: aload 2
      // 025: invokespecial java/lang/StringBuilder.<init> ()V
      // 028: aload 8
      // 02a: aload 2
      // 02b: ldc_w "Soup: "
      // 02e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 031: aload 1
      // 032: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 035: ldc_w " does not exist"
      // 038: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 03e: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 041: aload 8
      // 043: athrow
      // 044: astore 1
      // 045: aload 9
      // 047: monitorexit
      // 048: aload 1
      // 049: athrow
      // 04a: aload 0
      // 04b: aload 1
      // 04c: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 04f: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.a ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;
      // 052: astore 11
      // 054: new java/util/ArrayList
      // 057: astore 8
      // 059: aload 8
      // 05b: invokespecial java/util/ArrayList.<init> ()V
      // 05e: aload 2
      // 05f: arraylength
      // 060: istore 5
      // 062: bipush 0
      // 063: istore 4
      // 065: iload 4
      // 067: iload 5
      // 069: if_icmpge 0d3
      // 06c: aload 2
      // 06d: iload 4
      // 06f: aaload
      // 070: astore 13
      // 072: aload 11
      // 074: aload 13
      // 076: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 07b: ifeq 0aa
      // 07e: aload 11
      // 080: aload 13
      // 082: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 087: checkcast com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 08a: astore 12
      // 08c: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 08f: aload 12
      // 091: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 094: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.isMember (Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z
      // 097: ifeq 0a4
      // 09a: aload 8
      // 09c: aload 12
      // 09e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0a3: pop
      // 0a4: iinc 4 1
      // 0a7: goto 065
      // 0aa: new java/lang/StringBuilder
      // 0ad: astore 12
      // 0af: aload 12
      // 0b1: invokespecial java/lang/StringBuilder.<init> ()V
      // 0b4: ldc_w "SmartStore"
      // 0b7: aload 12
      // 0b9: ldc_w "Can not re-index "
      // 0bc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0bf: aload 13
      // 0c1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c4: ldc_w " - it does not have an index"
      // 0c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ca: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0cd: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;)V
      // 0d0: goto 0a4
      // 0d3: aload 8
      // 0d5: bipush 0
      // 0d6: anewarray 272
      // 0d9: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 0de: checkcast [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 0e1: astore 11
      // 0e3: aload 11
      // 0e5: arraylength
      // 0e6: ifne 0ed
      // 0e9: aload 9
      // 0eb: monitorexit
      // 0ec: return
      // 0ed: aload 11
      // 0ef: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.b ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z
      // 0f2: istore 6
      // 0f4: iload 3
      // 0f5: ifeq 0fd
      // 0f8: aload 9
      // 0fa: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 0fd: aload 0
      // 0fe: aload 1
      // 0ff: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 102: ifeq 240
      // 105: bipush 1
      // 106: anewarray 92
      // 109: astore 2
      // 10a: aload 2
      // 10b: bipush 0
      // 10c: ldc "id"
      // 10e: aastore
      // 10f: aload 9
      // 111: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 114: aload 9
      // 116: aload 10
      // 118: aload 2
      // 119: aconst_null
      // 11a: aconst_null
      // 11b: aconst_null
      // 11c: bipush 0
      // 11d: anewarray 92
      // 120: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 123: astore 8
      // 125: aload 8
      // 127: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 12c: ifeq 226
      // 12f: aload 8
      // 131: bipush 0
      // 132: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 137: astore 12
      // 139: aload 0
      // 13a: aload 1
      // 13b: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.e (Ljava/lang/String;)Z
      // 13e: ifeq 26e
      // 141: aload 0
      // 142: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 145: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 148: ifeq 26e
      // 14b: aload 0
      // 14c: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 14f: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 152: aload 10
      // 154: aload 12
      // 156: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
      // 159: aload 0
      // 15a: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 15d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;
      // 160: astore 2
      // 161: new android/content/ContentValues
      // 164: astore 15
      // 166: aload 15
      // 168: invokespecial android/content/ContentValues.<init> ()V
      // 16b: aload 0
      // 16c: aload 2
      // 16d: aload 15
      // 16f: aload 11
      // 171: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 174: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 177: aload 9
      // 179: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 17c: astore 13
      // 17e: new java/lang/StringBuilder
      // 181: astore 14
      // 183: aload 14
      // 185: invokespecial java/lang/StringBuilder.<init> ()V
      // 188: aload 13
      // 18a: aload 9
      // 18c: aload 10
      // 18e: aload 15
      // 190: ldc_w "id = ?"
      // 193: bipush 1
      // 194: anewarray 92
      // 197: dup
      // 198: bipush 0
      // 199: aload 14
      // 19b: aload 12
      // 19d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a0: ldc ""
      // 1a2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a5: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1a8: aastore
      // 1a9: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 1ac: pop
      // 1ad: iload 6
      // 1af: ifeq 218
      // 1b2: new java/lang/StringBuilder
      // 1b5: astore 13
      // 1b7: aload 13
      // 1b9: invokespecial java/lang/StringBuilder.<init> ()V
      // 1bc: aload 13
      // 1be: aload 10
      // 1c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c3: ldc_w "_fts"
      // 1c6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1cc: astore 13
      // 1ce: new android/content/ContentValues
      // 1d1: astore 14
      // 1d3: aload 14
      // 1d5: invokespecial android/content/ContentValues.<init> ()V
      // 1d8: aload 0
      // 1d9: aload 2
      // 1da: aload 14
      // 1dc: aload 11
      // 1de: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup.value_extracted_to_fts_column Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
      // 1e1: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
      // 1e4: aload 9
      // 1e6: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 1e9: astore 2
      // 1ea: new java/lang/StringBuilder
      // 1ed: astore 15
      // 1ef: aload 15
      // 1f1: invokespecial java/lang/StringBuilder.<init> ()V
      // 1f4: aload 2
      // 1f5: aload 9
      // 1f7: aload 13
      // 1f9: aload 14
      // 1fb: ldc_w "rowid =?"
      // 1fe: bipush 1
      // 1ff: anewarray 92
      // 202: dup
      // 203: bipush 0
      // 204: aload 15
      // 206: aload 12
      // 208: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 20b: ldc ""
      // 20d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 210: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 213: aastore
      // 214: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 217: pop
      // 218: aload 8
      // 21a: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 21f: istore 7
      // 221: iload 7
      // 223: ifne 12f
      // 226: iload 3
      // 227: ifeq 234
      // 22a: aload 9
      // 22c: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 22f: aload 9
      // 231: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 234: aload 0
      // 235: aload 8
      // 237: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 23a: aload 9
      // 23c: monitorexit
      // 23d: goto 0ec
      // 240: bipush 2
      // 241: anewarray 92
      // 244: astore 2
      // 245: aload 2
      // 246: bipush 0
      // 247: ldc "id"
      // 249: aastore
      // 24a: aload 2
      // 24b: bipush 1
      // 24c: ldc "soup"
      // 24e: aastore
      // 24f: goto 10f
      // 252: astore 1
      // 253: aconst_null
      // 254: astore 2
      // 255: aload 1
      // 256: astore 8
      // 258: iload 3
      // 259: ifeq 266
      // 25c: aload 9
      // 25e: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 261: aload 9
      // 263: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 266: aload 0
      // 267: aload 2
      // 268: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 26b: aload 8
      // 26d: athrow
      // 26e: new org/json/JSONObject
      // 271: dup
      // 272: aload 8
      // 274: bipush 1
      // 275: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 27a: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 27d: astore 2
      // 27e: goto 161
      // 281: astore 2
      // 282: new java/lang/StringBuilder
      // 285: astore 13
      // 287: aload 13
      // 289: invokespecial java/lang/StringBuilder.<init> ()V
      // 28c: ldc_w "SmartStore"
      // 28f: aload 13
      // 291: ldc_w "Could not parse soup element "
      // 294: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 297: aload 12
      // 299: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 29c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 29f: aload 2
      // 2a0: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.b (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 2a3: goto 218
      // 2a6: astore 2
      // 2a7: aload 8
      // 2a9: astore 1
      // 2aa: aload 2
      // 2ab: astore 8
      // 2ad: aload 1
      // 2ae: astore 2
      // 2af: goto 258
      // try (5 -> 11): 31 null
      // try (13 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 48): 31 null
      // try (57 -> 75): 31 null
      // try (77 -> 91): 31 null
      // try (92 -> 103): 31 null
      // try (104 -> 107): 31 null
      // try (109 -> 111): 31 null
      // try (111 -> 118): 271 null
      // try (122 -> 134): 271 null
      // try (134 -> 137): 310 null
      // try (137 -> 141): 310 null
      // try (141 -> 159): 295 org/json/JSONException
      // try (141 -> 159): 310 null
      // try (159 -> 194): 295 org/json/JSONException
      // try (159 -> 194): 310 null
      // try (196 -> 242): 295 org/json/JSONException
      // try (196 -> 242): 310 null
      // try (242 -> 245): 310 null
      // try (249 -> 253): 31 null
      // try (253 -> 258): 31 null
      // try (259 -> 262): 271 null
      // try (278 -> 282): 31 null
      // try (282 -> 287): 31 null
      // try (287 -> 294): 295 org/json/JSONException
      // try (287 -> 294): 310 null
      // try (296 -> 309): 310 null
   }

   public IndexSpec[] a(String param1) {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 2
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0b: aload 2
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 10: ifnonnull 41
      // 13: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 16: astore 3
      // 17: new java/lang/StringBuilder
      // 1a: astore 4
      // 1c: aload 4
      // 1e: invokespecial java/lang/StringBuilder.<init> ()V
      // 21: aload 3
      // 22: aload 4
      // 24: ldc_w "Soup: "
      // 27: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2a: aload 1
      // 2b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e: ldc_w " does not exist"
      // 31: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 34: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 37: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 3a: aload 3
      // 3b: athrow
      // 3c: astore 1
      // 3d: aload 2
      // 3e: monitorexit
      // 3f: aload 1
      // 40: athrow
      // 41: aload 2
      // 42: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 45: aload 2
      // 46: aload 1
      // 47: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.c (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 4a: astore 1
      // 4b: aload 2
      // 4c: monitorexit
      // 4d: aload 1
      // 4e: areturn
      // try (5 -> 29): 29 null
      // try (30 -> 32): 29 null
      // try (34 -> 42): 29 null
   }

   public void b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.c ()[Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
      // 0b: astore 4
      // 0d: aload 4
      // 0f: arraylength
      // 10: istore 2
      // 11: bipush 0
      // 12: istore 1
      // 13: iload 1
      // 14: iload 2
      // 15: if_icmpge 40
      // 18: aload 4
      // 1a: iload 1
      // 1b: aaload
      // 1c: astore 5
      // 1e: aload 5
      // 20: invokevirtual com/salesforce/androidsdk/smartstore/store/LongOperation.a ()V
      // 23: iinc 1 1
      // 26: goto 13
      // 29: astore 5
      // 2b: ldc_w "SmartStore"
      // 2e: ldc_w "Unexpected error"
      // 31: aload 5
      // 33: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 36: goto 23
      // 39: astore 4
      // 3b: aload 3
      // 3c: monitorexit
      // 3d: aload 4
      // 3f: athrow
      // 40: aload 3
      // 41: monitorexit
      // 42: return
      // try (5 -> 11): 30 null
      // try (20 -> 22): 24 java/lang/Exception
      // try (20 -> 22): 30 null
      // try (25 -> 29): 30 null
      // try (31 -> 33): 30 null
      // try (35 -> 37): 30 null
   }

   public void b(String param1) {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 2
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0b: aload 2
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 10: astore 3
      // 11: aload 3
      // 12: ifnonnull 43
      // 15: new com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException
      // 18: astore 3
      // 19: new java/lang/StringBuilder
      // 1c: astore 4
      // 1e: aload 4
      // 20: invokespecial java/lang/StringBuilder.<init> ()V
      // 23: aload 3
      // 24: aload 4
      // 26: ldc_w "Soup: "
      // 29: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2c: aload 1
      // 2d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 30: ldc_w " does not exist"
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 39: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException.<init> (Ljava/lang/String;)V
      // 3c: aload 3
      // 3d: athrow
      // 3e: astore 1
      // 3f: aload 2
      // 40: monitorexit
      // 41: aload 1
      // 42: athrow
      // 43: aload 2
      // 44: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 47: aload 2
      // 48: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 4b: aload 2
      // 4c: aload 3
      // 4d: aconst_null
      // 4e: bipush 0
      // 4f: anewarray 92
      // 52: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.b (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
      // 55: aload 0
      // 56: aload 1
      // 57: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.f (Ljava/lang/String;)Z
      // 5a: ifeq 85
      // 5d: aload 2
      // 5e: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 61: astore 1
      // 62: new java/lang/StringBuilder
      // 65: astore 4
      // 67: aload 4
      // 69: invokespecial java/lang/StringBuilder.<init> ()V
      // 6c: aload 1
      // 6d: aload 2
      // 6e: aload 4
      // 70: aload 3
      // 71: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 74: ldc_w "_fts"
      // 77: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 7d: aconst_null
      // 7e: bipush 0
      // 7f: anewarray 92
      // 82: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.b (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
      // 85: aload 0
      // 86: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 89: instanceof com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 8c: ifeq 9b
      // 8f: aload 0
      // 90: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 93: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 96: aload 3
      // 97: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.c (Ljava/lang/String;)Z
      // 9a: pop
      // 9b: aload 2
      // 9c: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 9f: aload 2
      // a0: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // a3: aload 2
      // a4: monitorexit
      // a5: return
      // a6: astore 1
      // a7: aload 2
      // a8: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // ab: aload 2
      // ac: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // af: aload 1
      // b0: athrow
      // try (5 -> 11): 31 null
      // try (13 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 38): 31 null
      // try (38 -> 69): 86 null
      // try (69 -> 79): 86 null
      // try (79 -> 85): 31 null
      // try (87 -> 93): 31 null
   }

   public boolean c(String param1) {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 3
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0b: aload 3
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.h (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 10: ifnull 19
      // 13: bipush 1
      // 14: istore 2
      // 15: aload 3
      // 16: monitorexit
      // 17: iload 2
      // 18: ireturn
      // 19: bipush 0
      // 1a: istore 2
      // 1b: goto 15
      // 1e: astore 1
      // 1f: aload 3
      // 20: monitorexit
      // 21: aload 1
      // 22: athrow
      // try (5 -> 11): 20 null
      // try (13 -> 15): 20 null
      // try (21 -> 23): 20 null
   }

   public LongOperation[] c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 6
      // 06: new java/util/ArrayList
      // 09: dup
      // 0a: invokespecial java/util/ArrayList.<init> ()V
      // 0d: astore 4
      // 0f: aload 6
      // 11: monitorenter
      // 12: aload 6
      // 14: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 17: aload 6
      // 19: ldc_w "long_operations_status"
      // 1c: bipush 4
      // 1d: anewarray 92
      // 20: dup
      // 21: bipush 0
      // 22: ldc "id"
      // 24: aastore
      // 25: dup
      // 26: bipush 1
      // 27: ldc_w "type"
      // 2a: aastore
      // 2b: dup
      // 2c: bipush 2
      // 2d: ldc_w "details"
      // 30: aastore
      // 31: dup
      // 32: bipush 3
      // 33: ldc_w "status"
      // 36: aastore
      // 37: aconst_null
      // 38: aconst_null
      // 39: aconst_null
      // 3a: bipush 0
      // 3b: anewarray 92
      // 3e: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 41: astore 5
      // 43: aload 5
      // 45: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 4a: istore 3
      // 4b: iload 3
      // 4c: ifeq 9c
      // 4f: aload 5
      // 51: bipush 0
      // 52: invokeinterface android/database/Cursor.getLong (I)J 2
      // 57: lstore 1
      // 58: aload 5
      // 5a: bipush 1
      // 5b: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 60: invokestatic com/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType.valueOf (Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;
      // 63: astore 8
      // 65: new org/json/JSONObject
      // 68: astore 7
      // 6a: aload 7
      // 6c: aload 5
      // 6e: bipush 2
      // 6f: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 74: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 77: aload 4
      // 79: aload 8
      // 7b: aload 0
      // 7c: lload 1
      // 7d: aload 7
      // 7f: aload 5
      // 81: bipush 3
      // 82: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 87: invokevirtual com/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType.getOperation (Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
      // 8a: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 8f: pop
      // 90: aload 5
      // 92: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 97: istore 3
      // 98: iload 3
      // 99: ifne 4f
      // 9c: aload 0
      // 9d: aload 5
      // 9f: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // a2: aload 6
      // a4: monitorexit
      // a5: aload 4
      // a7: bipush 0
      // a8: anewarray 703
      // ab: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // b0: checkcast [Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
      // b3: areturn
      // b4: astore 7
      // b6: ldc_w "SmartStore"
      // b9: ldc_w "Unexpected error"
      // bc: aload 7
      // be: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // c1: goto 90
      // c4: astore 4
      // c6: aload 0
      // c7: aload 5
      // c9: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // cc: aload 4
      // ce: athrow
      // cf: astore 4
      // d1: aload 6
      // d3: monitorexit
      // d4: aload 4
      // d6: athrow
      // d7: astore 4
      // d9: aconst_null
      // da: astore 5
      // dc: goto c6
      // try (9 -> 38): 103 null
      // try (38 -> 41): 92 null
      // try (43 -> 70): 86 java/lang/Exception
      // try (43 -> 70): 92 null
      // try (70 -> 73): 92 null
      // try (75 -> 80): 98 null
      // try (87 -> 91): 92 null
      // try (93 -> 98): 98 null
      // try (99 -> 101): 98 null
   }

   public String d(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 2
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;
      // 0b: aload 2
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartSqlHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
      // 10: astore 1
      // 11: aload 2
      // 12: monitorexit
      // 13: aload 1
      // 14: areturn
      // 15: astore 1
      // 16: aload 2
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   public List<String> d() {
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
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: new java/util/ArrayList
      // 0c: astore 3
      // 0d: aload 3
      // 0e: invokespecial java/util/ArrayList.<init> ()V
      // 11: aload 5
      // 13: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 16: aload 5
      // 18: ldc "soup_attrs"
      // 1a: bipush 1
      // 1b: anewarray 92
      // 1e: dup
      // 1f: bipush 0
      // 20: ldc "soupName"
      // 22: aastore
      // 23: ldc "soupName"
      // 25: aconst_null
      // 26: aconst_null
      // 27: bipush 0
      // 28: anewarray 92
      // 2b: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 2e: astore 2
      // 2f: aload 2
      // 30: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 35: ifeq 51
      // 38: aload 3
      // 39: aload 2
      // 3a: bipush 0
      // 3b: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 40: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 45: pop
      // 46: aload 2
      // 47: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 4c: istore 1
      // 4d: iload 1
      // 4e: ifne 38
      // 51: aload 0
      // 52: aload 2
      // 53: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 56: aload 5
      // 58: monitorexit
      // 59: aload 3
      // 5a: areturn
      // 5b: astore 2
      // 5c: aconst_null
      // 5d: astore 4
      // 5f: aload 2
      // 60: astore 3
      // 61: aload 0
      // 62: aload 4
      // 64: invokespecial com/salesforce/androidsdk/smartstore/store/SmartStore.b (Landroid/database/Cursor;)V
      // 67: aload 3
      // 68: athrow
      // 69: astore 2
      // 6a: aload 5
      // 6c: monitorexit
      // 6d: aload 2
      // 6e: athrow
      // 6f: astore 3
      // 70: aload 2
      // 71: astore 4
      // 73: goto 61
      // try (5 -> 9): 57 null
      // try (9 -> 26): 47 null
      // try (26 -> 29): 62 null
      // try (29 -> 38): 62 null
      // try (40 -> 45): 57 null
      // try (52 -> 57): 57 null
      // try (58 -> 60): 57 null
   }

   public boolean e(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a ()Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 3
      // 08: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 0b: aload 3
      // 0c: aload 1
      // 0d: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.f (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;
      // 10: ldc "externalStorage"
      // 12: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 17: istore 2
      // 18: aload 3
      // 19: monitorexit
      // 1a: iload 2
      // 1b: ireturn
      // 1c: astore 1
      // 1d: aload 3
      // 1e: monitorexit
      // 1f: aload 1
      // 20: athrow
      // try (5 -> 15): 17 null
      // try (18 -> 20): 17 null
   }

   public enum FtsExtension {
      fts4,
      fts5;

      private static final SmartStore.FtsExtension[] $VALUES = new SmartStore.FtsExtension[]{SmartStore.FtsExtension.fts4, SmartStore.FtsExtension.fts5};
   }

   public static class SmartStoreException extends RuntimeException {
      public SmartStoreException(String var1) {
         super(var1);
      }
   }

   public enum Type {
      floating("REAL"),
      full_text("TEXT"),
      integer("INTEGER"),
      json1(null),
      string("TEXT");

      private static final SmartStore.Type[] $VALUES = new SmartStore.Type[]{
         SmartStore.Type.string, SmartStore.Type.integer, SmartStore.Type.floating, SmartStore.Type.full_text, SmartStore.Type.json1
      };
      private String columnType;

      Type(String var3) {
         this.columnType = var3;
      }

      public String getColumnType() {
         return this.columnType;
      }
   }

   public enum TypeGroup {
      value_extracted_to_column {
         @Override
         public boolean isMember(SmartStore.Type var1) {
            boolean var2;
            if (var1 != SmartStore.Type.string && var1 != SmartStore.Type.integer && var1 != SmartStore.Type.floating && var1 != SmartStore.Type.full_text) {
               var2 = false;
            } else {
               var2 = true;
            }

            return var2;
         }
      },
      value_extracted_to_fts_column {
         @Override
         public boolean isMember(SmartStore.Type var1) {
            boolean var2;
            if (var1 == SmartStore.Type.full_text) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      },
      value_indexed_with_json_extract {
         @Override
         public boolean isMember(SmartStore.Type var1) {
            boolean var2;
            if (var1 == SmartStore.Type.json1) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      };

      private static final SmartStore.TypeGroup[] $VALUES = new SmartStore.TypeGroup[]{
         SmartStore.TypeGroup.value_extracted_to_column,
         SmartStore.TypeGroup.value_extracted_to_fts_column,
         SmartStore.TypeGroup.value_indexed_with_json_extract
      };

      TypeGroup() {
      }

      public abstract boolean isMember(SmartStore.Type var1);
   }
}
