package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DbHelper implements LogoutListener {
   private static final ServiceLogger a = ServiceLogging.a(DbHelper.class);
   private final MobileSdkUserManager b;
   private final String c;

   DbHelper(String var1, MobileSdkUserManager var2) {
      this.b = var2;
      this.b.a(this);
      this.c = var1;
      this.a(this.b.a(), var1);
   }

   private void a(int var1, String var2, SmartStore var3) {
      var3.b("DbVersionInfo");
      JSONObject var4 = new JSONObject();

      try {
         var4.put("Locale", var2);
         var4.put("InstalledVersion", var1);
         var3.a("DbVersionInfo", var4, "InstalledVersion");
      } catch (JSONException var5) {
         a.d("Error writing DB meta data. Upgrade/Downgrade of DB will not be supported, {}", var5.getMessage());
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(SmartStore var1, String var2) {
      try {
         var1.a("DbVersionInfo", DbContract.DbMeta.a);
      } catch (Exception var8) {
         a.e("Error setting up db, deleting any cached data. {}", var8.getMessage());
         this.b.c();
         var1.a("DbVersionInfo", DbContract.DbMeta.a);
      }

      JSONArray var4;
      try {
         var4 = var1.a(QuerySpec.a("DbVersionInfo", "InstalledVersion", QuerySpec.Order.ascending, 1), 0);
         this.a(9, var2, var1);
         if (var4.length() == 0) {
            this.a(var1.a());
            return;
         }
      } catch (JSONException var11) {
         this.a(var1.a(), 0, 9);
         return;
      }

      int var3;
      try {
         JSONObject var12 = var4.getJSONObject(0);
         var3 = var12.getInt("InstalledVersion");
         var13 = var12.getString("Locale");
      } catch (JSONException var10) {
         this.a(var1.a(), 0, 9);
         return;
      }

      label69: {
         if (var3 >= 9) {
            try {
               if (var13.equals(var2)) {
                  break label69;
               }
            } catch (JSONException var9) {
               this.a(var1.a(), 0, 9);
               return;
            }
         }

         try {
            this.a(var1.a(), var3, 9);
         } catch (JSONException var7) {
            this.a(var1.a(), 0, 9);
         }

         return;
      }

      if (var3 > 9) {
         try {
            this.b(var1.a(), var3, 9);
         } catch (JSONException var6) {
            this.a(var1.a(), 0, 9);
         }
      } else {
         try {
            this.a(var1.a());
         } catch (JSONException var5) {
            this.a(var1.a(), 0, 9);
         }
      }
   }

   @Override
   public void a() {
      this.a(this.b.a(), this.c);
   }

   public void a(SQLiteDatabase param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 1
      // 01: monitorenter
      // 02: aload 1
      // 03: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 06: aload 1
      // 07: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryOperation.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0a: aload 1
      // 0b: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleOperation.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0e: aload 1
      // 0f: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 12: aload 1
      // 13: monitorexit
      // 14: return
      // 15: astore 2
      // 16: aload 1
      // 17: monitorexit
      // 18: aload 2
      // 19: athrow
      // try (2 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   public void a(SQLiteDatabase param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 1
      // 01: monitorenter
      // 02: aload 1
      // 03: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 06: aload 1
      // 07: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0a: aload 1
      // 0b: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0e: aload 1
      // 0f: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 0
      // 15: aload 1
      // 16: invokevirtual com/salesforce/android/knowledge/core/internal/db/DbHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 19: return
      // 1a: astore 4
      // 1c: aload 1
      // 1d: monitorexit
      // 1e: aload 4
      // 20: athrow
      // try (2 -> 12): 16 null
      // try (17 -> 19): 16 null
   }

   public SQLiteDatabase b() {
      return this.b.a().a();
   }

   public void b(SQLiteDatabase param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 1
      // 01: monitorenter
      // 02: aload 1
      // 03: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 06: aload 1
      // 07: invokestatic com/salesforce/android/knowledge/core/internal/db/ArticleOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0a: aload 1
      // 0b: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 0e: aload 1
      // 0f: invokestatic com/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation.b (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 0
      // 15: aload 1
      // 16: invokevirtual com/salesforce/android/knowledge/core/internal/db/DbHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 19: return
      // 1a: astore 4
      // 1c: aload 1
      // 1d: monitorexit
      // 1e: aload 4
      // 20: athrow
      // try (2 -> 12): 16 null
      // try (17 -> 19): 16 null
   }
}
