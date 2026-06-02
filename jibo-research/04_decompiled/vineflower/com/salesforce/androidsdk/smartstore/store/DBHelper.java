package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDoneException;
import net.sqlcipher.database.SQLiteStatement;
import org.json.JSONObject;

public class DBHelper {
   private static Map<SQLiteDatabase, DBHelper> a;
   private Map<String, String> b = new HashMap<>();
   private Map<String, IndexSpec[]> c = new HashMap<>();
   private Map<String, Boolean> d = new HashMap<>();
   private Map<String, List<String>> e = new HashMap<>();
   private Map<String, SQLiteStatement> f = new HashMap<>();
   private Map<String, DatabaseUtils.InsertHelper> g = new HashMap<>();
   private Map<String, SQLiteStatement> h = new HashMap<>();
   private boolean i;
   private JSONObject j;

   public static DBHelper a(SQLiteDatabase param0) {
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
      // 00: ldc com/salesforce/androidsdk/smartstore/store/DBHelper
      // 02: monitorenter
      // 03: getstatic com/salesforce/androidsdk/smartstore/store/DBHelper.a Ljava/util/Map;
      // 06: ifnonnull 15
      // 09: new java/util/HashMap
      // 0c: astore 1
      // 0d: aload 1
      // 0e: invokespecial java/util/HashMap.<init> ()V
      // 11: aload 1
      // 12: putstatic com/salesforce/androidsdk/smartstore/store/DBHelper.a Ljava/util/Map;
      // 15: getstatic com/salesforce/androidsdk/smartstore/store/DBHelper.a Ljava/util/Map;
      // 18: aload 0
      // 19: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1e: checkcast com/salesforce/androidsdk/smartstore/store/DBHelper
      // 21: astore 2
      // 22: aload 2
      // 23: astore 1
      // 24: aload 2
      // 25: ifnonnull 3b
      // 28: new com/salesforce/androidsdk/smartstore/store/DBHelper
      // 2b: astore 1
      // 2c: aload 1
      // 2d: invokespecial com/salesforce/androidsdk/smartstore/store/DBHelper.<init> ()V
      // 30: getstatic com/salesforce/androidsdk/smartstore/store/DBHelper.a Ljava/util/Map;
      // 33: aload 0
      // 34: aload 1
      // 35: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 3a: pop
      // 3b: ldc com/salesforce/androidsdk/smartstore/store/DBHelper
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 0
      // 41: ldc com/salesforce/androidsdk/smartstore/store/DBHelper
      // 43: monitorexit
      // 44: aload 0
      // 45: athrow
      // try (2 -> 10): 32 null
      // try (10 -> 15): 32 null
      // try (19 -> 28): 32 null
   }

   private void a(SQLiteDatabase param1, String param2, String... param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new org/json/JSONObject
      // 003: dup
      // 004: invokespecial org/json/JSONObject.<init> ()V
      // 007: astore 9
      // 009: aconst_null
      // 00a: astore 7
      // 00c: aconst_null
      // 00d: astore 8
      // 00f: aload 8
      // 011: astore 6
      // 013: aload 7
      // 015: astore 5
      // 017: aload 9
      // 019: ldc "sql"
      // 01b: aload 2
      // 01c: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 01f: pop
      // 020: aload 3
      // 021: ifnull 061
      // 024: aload 8
      // 026: astore 6
      // 028: aload 7
      // 02a: astore 5
      // 02c: aload 3
      // 02d: arraylength
      // 02e: ifle 061
      // 031: aload 8
      // 033: astore 6
      // 035: aload 7
      // 037: astore 5
      // 039: new org/json/JSONArray
      // 03c: astore 10
      // 03e: aload 8
      // 040: astore 6
      // 042: aload 7
      // 044: astore 5
      // 046: aload 10
      // 048: aload 3
      // 049: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 04c: invokespecial org/json/JSONArray.<init> (Ljava/util/Collection;)V
      // 04f: aload 8
      // 051: astore 6
      // 053: aload 7
      // 055: astore 5
      // 057: aload 9
      // 059: ldc "args"
      // 05b: aload 10
      // 05d: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 060: pop
      // 061: aload 8
      // 063: astore 6
      // 065: aload 7
      // 067: astore 5
      // 069: new org/json/JSONArray
      // 06c: astore 10
      // 06e: aload 8
      // 070: astore 6
      // 072: aload 7
      // 074: astore 5
      // 076: aload 10
      // 078: invokespecial org/json/JSONArray.<init> ()V
      // 07b: aload 8
      // 07d: astore 6
      // 07f: aload 7
      // 081: astore 5
      // 083: new java/lang/StringBuilder
      // 086: astore 11
      // 088: aload 8
      // 08a: astore 6
      // 08c: aload 7
      // 08e: astore 5
      // 090: aload 11
      // 092: invokespecial java/lang/StringBuilder.<init> ()V
      // 095: aload 8
      // 097: astore 6
      // 099: aload 7
      // 09b: astore 5
      // 09d: aload 1
      // 09e: aload 11
      // 0a0: ldc "EXPLAIN QUERY PLAN "
      // 0a2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a5: aload 2
      // 0a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ac: aload 3
      // 0ad: invokevirtual net/sqlcipher/database/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 0b0: astore 1
      // 0b1: aload 1
      // 0b2: astore 6
      // 0b4: aload 1
      // 0b5: astore 5
      // 0b7: aload 1
      // 0b8: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0bd: ifeq 13f
      // 0c0: aload 1
      // 0c1: astore 6
      // 0c3: aload 1
      // 0c4: astore 5
      // 0c6: new org/json/JSONObject
      // 0c9: astore 2
      // 0ca: aload 1
      // 0cb: astore 6
      // 0cd: aload 1
      // 0ce: astore 5
      // 0d0: aload 2
      // 0d1: invokespecial org/json/JSONObject.<init> ()V
      // 0d4: aload 1
      // 0d5: astore 6
      // 0d7: aload 1
      // 0d8: astore 5
      // 0da: new java/lang/StringBuilder
      // 0dd: invokespecial java/lang/StringBuilder.<init> ()V
      // 0e0: bipush 0
      // 0e1: istore 4
      // 0e3: aload 1
      // 0e4: astore 6
      // 0e6: aload 1
      // 0e7: astore 5
      // 0e9: iload 4
      // 0eb: aload 1
      // 0ec: invokeinterface android/database/Cursor.getColumnCount ()I 1
      // 0f1: if_icmpge 115
      // 0f4: aload 1
      // 0f5: astore 6
      // 0f7: aload 1
      // 0f8: astore 5
      // 0fa: aload 2
      // 0fb: aload 1
      // 0fc: iload 4
      // 0fe: invokeinterface android/database/Cursor.getColumnName (I)Ljava/lang/String; 2
      // 103: aload 1
      // 104: iload 4
      // 106: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 10b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 10e: pop
      // 10f: iinc 4 1
      // 112: goto 0e3
      // 115: aload 1
      // 116: astore 6
      // 118: aload 1
      // 119: astore 5
      // 11b: aload 10
      // 11d: aload 2
      // 11e: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 121: pop
      // 122: goto 0b1
      // 125: astore 1
      // 126: aload 6
      // 128: astore 5
      // 12a: ldc "EXPLAIN"
      // 12c: ldc "Exception"
      // 12e: aload 1
      // 12f: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 132: aload 0
      // 133: aload 6
      // 135: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 138: aload 0
      // 139: aload 9
      // 13b: putfield com/salesforce/androidsdk/smartstore/store/DBHelper.j Lorg/json/JSONObject;
      // 13e: return
      // 13f: aload 1
      // 140: astore 6
      // 142: aload 1
      // 143: astore 5
      // 145: aload 9
      // 147: ldc "rows"
      // 149: aload 10
      // 14b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 14e: pop
      // 14f: aload 1
      // 150: astore 6
      // 152: aload 1
      // 153: astore 5
      // 155: ldc "EXPLAIN"
      // 157: aload 9
      // 159: bipush 2
      // 15a: invokevirtual org/json/JSONObject.toString (I)Ljava/lang/String;
      // 15d: invokestatic com/salesforce/androidsdk/smartstore/util/SmartStoreLogger.c (Ljava/lang/String;Ljava/lang/String;)V
      // 160: aload 0
      // 161: aload 1
      // 162: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 165: goto 138
      // 168: astore 1
      // 169: aload 0
      // 16a: aload 5
      // 16c: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 16f: aload 1
      // 170: athrow
      // try (12 -> 17): 146 org/json/JSONException
      // try (12 -> 17): 182 null
      // try (23 -> 26): 146 org/json/JSONException
      // try (23 -> 26): 182 null
      // try (30 -> 32): 146 org/json/JSONException
      // try (30 -> 32): 182 null
      // try (36 -> 40): 146 org/json/JSONException
      // try (36 -> 40): 182 null
      // try (44 -> 49): 146 org/json/JSONException
      // try (44 -> 49): 182 null
      // try (53 -> 55): 146 org/json/JSONException
      // try (53 -> 55): 182 null
      // try (59 -> 61): 146 org/json/JSONException
      // try (59 -> 61): 182 null
      // try (65 -> 67): 146 org/json/JSONException
      // try (65 -> 67): 182 null
      // try (71 -> 73): 146 org/json/JSONException
      // try (71 -> 73): 182 null
      // try (77 -> 87): 146 org/json/JSONException
      // try (77 -> 87): 182 null
      // try (91 -> 94): 146 org/json/JSONException
      // try (91 -> 94): 182 null
      // try (98 -> 100): 146 org/json/JSONException
      // try (98 -> 100): 182 null
      // try (104 -> 106): 146 org/json/JSONException
      // try (104 -> 106): 182 null
      // try (110 -> 112): 146 org/json/JSONException
      // try (110 -> 112): 182 null
      // try (118 -> 122): 146 org/json/JSONException
      // try (118 -> 122): 182 null
      // try (126 -> 135): 146 org/json/JSONException
      // try (126 -> 135): 182 null
      // try (141 -> 145): 146 org/json/JSONException
      // try (141 -> 145): 182 null
      // try (149 -> 153): 182 null
      // try (164 -> 169): 146 org/json/JSONException
      // try (164 -> 169): 182 null
      // try (173 -> 178): 146 org/json/JSONException
      // try (173 -> 178): 182 null
   }

   private void f(String var1) {
      ArrayList var4 = new ArrayList();

      for (Entry var5 : this.h.entrySet()) {
         String var2 = (String)var5.getKey();
         if (var2.contains(var1)) {
            SQLiteStatement var8 = (SQLiteStatement)var5.getValue();
            if (var8 != null) {
               var8.close();
            }

            var4.add(var2);
         }
      }

      for (String var7 : var4) {
         this.h.remove(var7);
      }
   }

   public int a(SQLiteDatabase var1, String var2, ContentValues var3, String var4, String... var5) {
      return var1.update(var2, var3, var4, var5);
   }

   public long a(SQLiteDatabase var1, String var2) {
      SQLiteStatement var6 = this.f.get(var2);
      SQLiteStatement var5 = var6;
      if (var6 == null) {
         var5 = var1.compileStatement("SELECT seq FROM SQLITE_SEQUENCE WHERE name = ?");
         var5.bindString(1, var2);
         this.f.put(var2, var5);
      }

      long var8;
      try {
         var8 = var5.simpleQueryForLong();
      } catch (SQLiteDoneException var7) {
         return 1L;
      }

      var8++;
      return var8;
   }

   public long a(SQLiteDatabase var1, String var2, ContentValues var3) {
      return this.b(var1, var2).insert(var3);
   }

   public Cursor a(SQLiteDatabase var1, String var2, String var3, String... var4) {
      var2 = String.format("SELECT * FROM (%s) LIMIT %s", var2, var3);
      if (this.i) {
         this.a(var1, var2, var4);
      }

      return var1.rawQuery(var2, var4);
   }

   public Cursor a(SQLiteDatabase var1, String var2, String[] var3, String var4, String var5, String var6, String... var7) {
      return var1.query(var2, var3, var6, var7, null, null, var4, var5);
   }

   public String a(String var1) {
      return this.b.get(var1);
   }

   public String a(SQLiteDatabase var1, String var2, String var3) {
      for (IndexSpec var7 : this.c(var1, var2)) {
         if (var7.a.equals(var3)) {
            return var7.c;
         }
      }

      throw new SmartStore.SmartStoreException(String.format("%s does not have an index on %s", var2, var3));
   }

   protected void a(Cursor var1) {
      if (var1 != null) {
         var1.close();
      }
   }

   public void a(String var1, String var2) {
      this.b.put(var1, var2);
   }

   public void a(String var1, List<String> var2) {
      this.e.put(var1, var2);
   }

   public void a(String var1, IndexSpec[] var2) {
      this.c.put(var1, (IndexSpec[])var2.clone());
      this.d.put(var1, IndexSpec.b(var2));
   }

   public DatabaseUtils.InsertHelper b(SQLiteDatabase var1, String var2) {
      DatabaseUtils.InsertHelper var4 = this.g.get(var2);
      DatabaseUtils.InsertHelper var3 = var4;
      if (var4 == null) {
         var3 = new DatabaseUtils.InsertHelper(var1, var2);
         this.g.put(var2, var3);
      }

      return var3;
   }

   public void b(SQLiteDatabase var1, String var2, String var3, String... var4) {
      var1.delete(var2, var3, var4);
   }

   public IndexSpec[] b(String var1) {
      return this.c.get(var1);
   }

   public List<String> c(String var1) {
      return this.e.get(var1);
   }

   public IndexSpec[] c(SQLiteDatabase var1, String var2) {
      IndexSpec[] var4 = this.b(var2);
      IndexSpec[] var3 = var4;
      if (var4 == null) {
         var3 = this.d(var1, var2);
         this.a(var2, var3);
      }

      return var3;
   }

   public Boolean d(String var1) {
      return this.d.get(var1);
   }

   protected IndexSpec[] d(SQLiteDatabase var1, String var2) {
      try {
         var13 = this.a(var1, "soup_index_map", new String[]{"path", "columnName", "columnType"}, null, null, "soupName = ?", (String)var2);
      } finally {
         ;
      }

      try {
         if (!var13.moveToFirst()) {
            SmartStore.SmartStoreException var14 = new SmartStore.SmartStoreException(String.format("%s does not have any indices", var2));
            throw var14;
         }

         ArrayList var4 = new ArrayList();

         do {
            String var5 = var13.getString(var13.getColumnIndex("path"));
            String var3 = var13.getString(var13.getColumnIndex("columnName"));
            SmartStore.Type var6 = SmartStore.Type.valueOf(var13.getString(var13.getColumnIndex("columnType")));
            var2 = new IndexSpec(var5, var6, var3);
            var4.add(var2);
         } while (var13.moveToNext());

         var2 = var4.toArray(new IndexSpec[0]);
      } finally {
         this.a(var13);
         throw var2;
      }

      this.a(var13);
      return (IndexSpec[])var2;
   }

   public void e(String var1) {
      String var2 = this.b.get(var1);
      if (var2 != null) {
         DatabaseUtils.InsertHelper var3 = this.g.remove(var2);
         if (var3 != null) {
            var3.close();
         }

         SQLiteStatement var4 = this.f.remove(var2);
         if (var4 != null) {
            var4.close();
         }

         this.f(var2);
      }

      this.b.remove(var1);
      this.c.remove(var1);
      this.d.remove(var1);
      this.e.remove(var1);
   }

   public boolean e(SQLiteDatabase var1, String var2) {
      this.c(var1, var2);
      return this.d(var2);
   }

   public List<String> f(SQLiteDatabase var1, String var2) {
      List var4 = this.c(var2);
      List var3 = var4;
      if (var4 == null) {
         var3 = this.g(var1, var2);
         this.a(var2, var3);
      }

      return var3;
   }

   protected List<String> g(SQLiteDatabase param1, String param2) {
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
      // 00: aconst_null
      // 01: astore 6
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 7
      // 0c: aload 0
      // 0d: aload 1
      // 0e: ldc_w "soup_attrs"
      // 11: getstatic com/salesforce/androidsdk/smartstore/store/SoupSpec.a [Ljava/lang/String;
      // 14: aconst_null
      // 15: aconst_null
      // 16: ldc_w "soupName = ?"
      // 19: bipush 1
      // 1a: anewarray 175
      // 1d: dup
      // 1e: bipush 0
      // 1f: aload 2
      // 20: aastore
      // 21: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 24: astore 2
      // 25: aload 2
      // 26: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 2b: istore 5
      // 2d: iload 5
      // 2f: ifne 3b
      // 32: aload 0
      // 33: aload 2
      // 34: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 37: aconst_null
      // 38: astore 1
      // 39: aload 1
      // 3a: areturn
      // 3b: getstatic com/salesforce/androidsdk/smartstore/store/SoupSpec.a [Ljava/lang/String;
      // 3e: astore 1
      // 3f: aload 1
      // 40: arraylength
      // 41: istore 4
      // 43: bipush 0
      // 44: istore 3
      // 45: iload 3
      // 46: iload 4
      // 48: if_icmpge 71
      // 4b: aload 1
      // 4c: iload 3
      // 4d: aaload
      // 4e: astore 6
      // 50: aload 2
      // 51: aload 2
      // 52: aload 6
      // 54: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 59: invokeinterface android/database/Cursor.getInt (I)I 2
      // 5e: ifle 6b
      // 61: aload 7
      // 63: aload 6
      // 65: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 6a: pop
      // 6b: iinc 3 1
      // 6e: goto 45
      // 71: aload 0
      // 72: aload 2
      // 73: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 76: aload 7
      // 78: astore 1
      // 79: goto 39
      // 7c: astore 1
      // 7d: aload 6
      // 7f: astore 2
      // 80: aload 0
      // 81: aload 2
      // 82: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 85: aload 1
      // 86: athrow
      // 87: astore 1
      // 88: goto 80
      // try (6 -> 21): 65 null
      // try (21 -> 24): 73 null
      // try (33 -> 38): 73 null
      // try (47 -> 57): 73 null
   }

   public String h(SQLiteDatabase var1, String var2) {
      String var4 = this.a(var2);
      String var3 = var4;
      if (var4 == null) {
         String var5 = this.i(var1, var2);
         var3 = var5;
         if (var5 != null) {
            this.a(var2, var5);
            var3 = var5;
         }
      }

      return var3;
   }

   protected String i(SQLiteDatabase param1, String param2) {
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
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 0
      // 04: aload 1
      // 05: ldc_w "soup_attrs"
      // 08: bipush 1
      // 09: anewarray 175
      // 0c: dup
      // 0d: bipush 0
      // 0e: ldc_w "id"
      // 11: aastore
      // 12: aconst_null
      // 13: aconst_null
      // 14: ldc_w "soupName = ?"
      // 17: bipush 1
      // 18: anewarray 175
      // 1b: dup
      // 1c: bipush 0
      // 1d: aload 2
      // 1e: aastore
      // 1f: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 22: astore 2
      // 23: aload 2
      // 24: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 29: istore 3
      // 2a: iload 3
      // 2b: ifne 37
      // 2e: aload 0
      // 2f: aload 2
      // 30: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 33: aconst_null
      // 34: astore 1
      // 35: aload 1
      // 36: areturn
      // 37: aload 2
      // 38: aload 2
      // 39: ldc_w "id"
      // 3c: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 41: invokeinterface android/database/Cursor.getLong (I)J 2
      // 46: invokestatic com/salesforce/androidsdk/smartstore/store/SmartStore.a (J)Ljava/lang/String;
      // 49: astore 1
      // 4a: aload 0
      // 4b: aload 2
      // 4c: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 4f: goto 35
      // 52: astore 1
      // 53: aload 4
      // 55: astore 2
      // 56: aload 0
      // 57: aload 2
      // 58: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Landroid/database/Cursor;)V
      // 5b: aload 1
      // 5c: athrow
      // 5d: astore 1
      // 5e: goto 56
      // try (2 -> 22): 45 null
      // try (22 -> 25): 53 null
      // try (34 -> 41): 53 null
   }
}
