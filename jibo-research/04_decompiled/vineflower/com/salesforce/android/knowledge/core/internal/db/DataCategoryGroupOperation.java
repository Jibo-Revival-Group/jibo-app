package com.salesforce.android.knowledge.core.internal.db;

import android.content.ContentValues;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;

class DataCategoryGroupOperation {
   static List<DataCategoryTree> a(String param0, SQLiteDatabase param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ldc "SELECT a.name, a.label, a.parent, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.data_category_group=? GROUP BY a.ROWID"
      // 03: bipush 1
      // 04: anewarray 17
      // 07: dup
      // 08: bipush 0
      // 09: aload 0
      // 0a: aastore
      // 0b: invokevirtual net/sqlcipher/database/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 0e: astore 1
      // 0f: new java/util/HashMap
      // 12: dup
      // 13: aload 1
      // 14: invokeinterface android/database/Cursor.getCount ()I 1
      // 19: fconst_1
      // 1a: invokespecial java/util/HashMap.<init> (IF)V
      // 1d: astore 0
      // 1e: aload 1
      // 1f: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 24: istore 2
      // 25: iload 2
      // 26: ifeq 70
      // 29: aload 1
      // 2a: ldc "label"
      // 2c: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.a (Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
      // 2f: astore 4
      // 31: aload 1
      // 32: ldc "name"
      // 34: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.a (Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
      // 37: astore 3
      // 38: aload 1
      // 39: ldc "parent"
      // 3b: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.a (Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
      // 3e: astore 5
      // 40: aload 3
      // 41: aload 4
      // 43: aload 1
      // 44: ldc "subCategories"
      // 46: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.b (Landroid/database/Cursor;Ljava/lang/String;)I
      // 49: aload 5
      // 4b: invokestatic com/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel.a (Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;
      // 4e: astore 4
      // 50: new com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel
      // 53: astore 5
      // 55: aload 5
      // 57: aload 4
      // 59: invokespecial com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel.<init> (Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;)V
      // 5c: aload 0
      // 5d: aload 3
      // 5e: aload 5
      // 60: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 65: pop
      // 66: aload 1
      // 67: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 6c: istore 2
      // 6d: goto 25
      // 70: aload 1
      // 71: invokeinterface android/database/Cursor.close ()V 1
      // 76: new java/util/ArrayList
      // 79: dup
      // 7a: invokespecial java/util/ArrayList.<init> ()V
      // 7d: astore 4
      // 7f: aload 0
      // 80: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 85: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 8a: astore 5
      // 8c: aload 5
      // 8e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 93: ifeq de
      // 96: aload 5
      // 98: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 9d: checkcast com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel
      // a0: astore 1
      // a1: aload 1
      // a2: invokevirtual com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel.c ()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;
      // a5: checkcast com/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel
      // a8: astore 3
      // a9: aload 3
      // aa: invokevirtual com/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel.d ()Ljava/lang/String;
      // ad: astore 6
      // af: aload 3
      // b0: invokevirtual com/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel.d ()Ljava/lang/String;
      // b3: ifnonnull cb
      // b6: aload 4
      // b8: aload 1
      // b9: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // be: pop
      // bf: goto 8c
      // c2: astore 0
      // c3: aload 1
      // c4: invokeinterface android/database/Cursor.close ()V 1
      // c9: aload 0
      // ca: athrow
      // cb: aload 1
      // cc: aload 0
      // cd: aload 6
      // cf: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // d4: checkcast com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel
      // d7: invokevirtual com/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel.a (Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;
      // da: pop
      // db: goto 8c
      // de: aload 4
      // e0: areturn
      // try (17 -> 20): 88 null
      // try (22 -> 55): 88 null
   }

   public static void a(SQLiteDatabase var0) {
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS DataCategoryGroup (name TEXT NOT NULL PRIMARY KEY, label TEXT NOT NULL,cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"
      );
   }

   public static void b(SQLiteDatabase var0) {
      DbUtil.a(var0, "DataCategoryGroup");
   }

   public static class ReadList implements DbRead.Operation<DataCategoryGroupList> {
      public DataCategoryGroupList a(SQLiteDatabase param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: new java/util/LinkedList
         // 03: dup
         // 04: invokespecial java/util/LinkedList.<init> ()V
         // 07: astore 5
         // 09: aload 1
         // 0a: ldc "DataCategoryGroup"
         // 0c: bipush 2
         // 0d: anewarray 24
         // 10: dup
         // 11: bipush 0
         // 12: ldc "name"
         // 14: aastore
         // 15: dup
         // 16: bipush 1
         // 17: ldc "label"
         // 19: aastore
         // 1a: aconst_null
         // 1b: aconst_null
         // 1c: aconst_null
         // 1d: aconst_null
         // 1e: aconst_null
         // 1f: aconst_null
         // 20: invokevirtual net/sqlcipher/database/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
         // 23: astore 3
         // 24: aload 3
         // 25: invokeinterface android/database/Cursor.moveToFirst ()Z 1
         // 2a: istore 2
         // 2b: iload 2
         // 2c: ifeq 5a
         // 2f: aload 3
         // 30: ldc "name"
         // 32: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.a (Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
         // 35: astore 4
         // 37: aload 5
         // 39: aload 4
         // 3b: aload 3
         // 3c: ldc "label"
         // 3e: invokestatic com/salesforce/android/knowledge/core/internal/db/DbUtil.a (Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
         // 41: aload 4
         // 43: aload 1
         // 44: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation.a (Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/util/List;
         // 47: invokestatic com/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel.a (Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;
         // 4a: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
         // 4f: pop
         // 50: aload 3
         // 51: invokeinterface android/database/Cursor.moveToNext ()Z 1
         // 56: istore 2
         // 57: goto 2b
         // 5a: aload 3
         // 5b: invokeinterface android/database/Cursor.close ()V 1
         // 60: aload 5
         // 62: invokestatic com/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel.a (Ljava/util/List;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;
         // 65: areturn
         // 66: astore 1
         // 67: aload 3
         // 68: invokeinterface android/database/Cursor.close ()V 1
         // 6d: aload 1
         // 6e: athrow
         // try (24 -> 27): 53 null
         // try (29 -> 47): 53 null
      }
   }

   public static class WriteList implements DbWrite.Operation {
      private DataCategoryGroupList a;

      public WriteList(DataCategoryGroupList var1) {
         this.a = var1;
      }

      private static void a(StringBuilder var0, DataCategoryTree var1, DataCategoryGroup var2) {
         DataCategorySummary var5 = var1.c();
         String var4;
         if (var1.a() == null) {
            var4 = null;
         } else {
            var4 = var1.a().c().a();
         }

         var0.append("('").append(var5.a()).append("', '").append(var5.b()).append("', ");
         if (var4 != null) {
            var0.append("'").append(var4).append("', '");
         } else {
            var0.append("null, '");
         }

         var0.append(var2.a()).append("')");
         Set var6 = var1.b();
         if (var6.size() > 0) {
            var0.append(", ");
         }

         Iterator var7 = var6.iterator();
         int var3 = 0;

         while (var7.hasNext()) {
            a(var0, (DataCategoryTree)var7.next(), var2);
            if (++var3 < var6.size()) {
               var0.append(", ");
            }
         }
      }

      private static void a(SQLiteDatabase var0, DataCategoryTree var1, DataCategoryGroup var2) {
         StringBuilder var3 = new StringBuilder("INSERT OR REPLACE INTO ")
            .append("DataCategorySummary")
            .append(" (")
            .append("name")
            .append(", ")
            .append("label")
            .append(", ")
            .append("parent")
            .append(", ")
            .append("data_category_group")
            .append(") VALUES ");
         a(var3, var1, var2);
         var0.execSQL(var3.toString());
      }

      @Override
      public void a(SQLiteDatabase var1) {
         ContentValues var5 = new ContentValues();

         for (DataCategoryGroup var3 : this.a.a()) {
            var5.put("name", var3.a());
            var5.put("label", var3.b());
            var1.insertWithOnConflict("DataCategoryGroup", null, var5, 5);
            Iterator var4 = var3.c().iterator();

            while (var4.hasNext()) {
               a(var1, (DataCategoryTree)var4.next(), var3);
            }
         }
      }
   }
}
