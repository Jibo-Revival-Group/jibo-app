package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

class DbWrite implements Job<Void> {
   private final List<DbWrite.Operation> a;
   private final SQLiteDatabase b;

   DbWrite(DbWrite.Builder var1) {
      this.a = new LinkedList<>(var1.a);
      this.b = var1.b;
   }

   static DbWrite.Builder a(SQLiteDatabase var0) {
      return new DbWrite.Builder(var0);
   }

   @Override
   public void a(ResultReceiver<Void> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/salesforce/android/knowledge/core/internal/db/DbWrite.a Ljava/util/List;
      // 04: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 09: astore 3
      // 0a: aload 3
      // 0b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 10: ifeq 44
      // 13: aload 3
      // 14: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 19: checkcast com/salesforce/android/knowledge/core/internal/db/DbWrite$Operation
      // 1c: astore 4
      // 1e: aload 0
      // 1f: getfield com/salesforce/android/knowledge/core/internal/db/DbWrite.b Lnet/sqlcipher/database/SQLiteDatabase;
      // 22: astore 2
      // 23: aload 2
      // 24: monitorenter
      // 25: aload 4
      // 27: aload 0
      // 28: getfield com/salesforce/android/knowledge/core/internal/db/DbWrite.b Lnet/sqlcipher/database/SQLiteDatabase;
      // 2b: invokeinterface com/salesforce/android/knowledge/core/internal/db/DbWrite$Operation.a (Lnet/sqlcipher/database/SQLiteDatabase;)V 2
      // 30: aload 2
      // 31: monitorexit
      // 32: goto 0a
      // 35: astore 3
      // 36: aload 2
      // 37: monitorexit
      // 38: aload 3
      // 39: athrow
      // 3a: astore 2
      // 3b: aload 1
      // 3c: aload 2
      // 3d: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 42: pop
      // 43: return
      // 44: aload 1
      // 45: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b ()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 1
      // 4a: pop
      // 4b: goto 43
      // try (0 -> 4): 28 java/lang/Throwable
      // try (4 -> 16): 28 java/lang/Throwable
      // try (16 -> 22): 23 null
      // try (24 -> 26): 23 null
      // try (26 -> 28): 28 java/lang/Throwable
   }

   static class Builder {
      final List<DbWrite.Operation> a = new LinkedList<>();
      final SQLiteDatabase b;

      Builder(SQLiteDatabase var1) {
         this.b = var1;
      }

      DbWrite.Builder a(DbWrite.Operation var1) {
         this.a.add(var1);
         return this;
      }

      DbWrite a() {
         return new DbWrite(this);
      }
   }

   interface Operation {
      void a(SQLiteDatabase var1);
   }
}
