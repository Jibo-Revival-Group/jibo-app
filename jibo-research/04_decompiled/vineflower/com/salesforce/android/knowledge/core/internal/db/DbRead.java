package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

class DbRead<T> implements Job<T> {
   private final SQLiteDatabase a;
   private final List<DbRead.Operation<T>> b;

   DbRead(DbRead.Builder<T> var1) {
      this.a = var1.a;
      this.b = new LinkedList<>(var1.b);
   }

   static <T> DbRead.Builder<T> a(SQLiteDatabase var0, Class<T> var1) {
      return new DbRead.Builder<>(var0);
   }

   @Override
   public void a(ResultReceiver<T> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 0
      // 03: getfield com/salesforce/android/knowledge/core/internal/db/DbRead.a Lnet/sqlcipher/database/SQLiteDatabase;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/salesforce/android/knowledge/core/internal/db/DbRead.b Ljava/util/List;
      // 0d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 12: astore 4
      // 14: aload 4
      // 16: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1b: ifeq 35
      // 1e: aload 4
      // 20: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 25: checkcast com/salesforce/android/knowledge/core/internal/db/DbRead$Operation
      // 28: aload 0
      // 29: getfield com/salesforce/android/knowledge/core/internal/db/DbRead.a Lnet/sqlcipher/database/SQLiteDatabase;
      // 2c: invokeinterface com/salesforce/android/knowledge/core/internal/db/DbRead$Operation.b (Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object; 2
      // 31: astore 2
      // 32: goto 14
      // 35: aload 3
      // 36: monitorexit
      // 37: aload 2
      // 38: ifnull 43
      // 3b: aload 1
      // 3c: aload 2
      // 3d: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 42: pop
      // 43: aload 1
      // 44: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b ()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 1
      // 49: pop
      // 4a: return
      // 4b: astore 2
      // 4c: aload 3
      // 4d: monitorexit
      // 4e: aload 2
      // 4f: athrow
      // 50: astore 2
      // 51: aload 1
      // 52: aload 2
      // 53: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 58: pop
      // 59: goto 4a
      // try (2 -> 7): 39 java/lang/Throwable
      // try (7 -> 11): 34 null
      // try (11 -> 21): 34 null
      // try (22 -> 24): 34 null
      // try (35 -> 37): 34 null
      // try (37 -> 39): 39 java/lang/Throwable
   }

   static class Builder<T> {
      final SQLiteDatabase a;
      final List<DbRead.Operation<T>> b = new LinkedList<>();

      Builder(SQLiteDatabase var1) {
         this.a = var1;
      }

      DbRead.Builder<T> a(DbRead.Operation<T> var1) {
         this.b.add(var1);
         return this;
      }

      DbRead<T> a() {
         return new DbRead<>(this);
      }
   }

   interface Operation<T> {
      T b(SQLiteDatabase var1) throws Exception;
   }
}
