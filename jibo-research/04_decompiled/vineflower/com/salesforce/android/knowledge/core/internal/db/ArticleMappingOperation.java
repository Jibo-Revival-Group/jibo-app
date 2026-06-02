package com.salesforce.android.knowledge.core.internal.db;

import android.content.ContentValues;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

class ArticleMappingOperation {
   static final ServiceLogger a = ServiceLogging.a(ArticleMappingOperation.class);

   static List<String> a(SQLiteDatabase var0, String var1) {
      ArrayList var3 = new ArrayList();
      String var2 = var1;

      do {
         var3.add(var2);
         Cursor var5 = var0.query("DataCategorySummary", null, "name=?", new String[]{var2}, null, null, null, null);
         if (var5.moveToFirst()) {
            var1 = var5.getString(var5.getColumnIndex("parent"));
         } else {
            var1 = null;
         }

         var5.close();
         var2 = var1;
      } while (var1 != null);

      return var3;
   }

   public static void a(SQLiteDatabase var0) {
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS ArticleCategories (category_name TEXT NOT NULL, article_id TEXT NOT NULL, UNIQUE(article_id, category_name)FOREIGN KEY(category_name) REFERENCES DataCategorySummary(name), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id))"
      );
   }

   public static void b(SQLiteDatabase var0) {
      DbUtil.a(var0, "ArticleCategories");
   }

   public static class WriteList implements DbWrite.Operation {
      private final String a;
      private final ArticleList b;

      public WriteList(String var1, ArticleList var2) {
         this.a = var1;
         this.b = var2;
      }

      private void a(SQLiteDatabase var1, String var2, ArticleSummary var3) {
         ArticleMappingOperation.a.a("Mapping {} to {} in database", var3, var2);
         ContentValues var4 = new ContentValues();
         var4.put("article_id", var3.g());
         var4.put("category_name", var2);
         var1.insertWithOnConflict("ArticleCategories", null, var4, 4);
      }

      @Override
      public void a(SQLiteDatabase var1) {
         for (String var3 : ArticleMappingOperation.a(var1, this.a)) {
            Iterator var2 = this.b.a().iterator();

            while (var2.hasNext()) {
               this.a(var1, var3, (ArticleSummary)var2.next());
            }
         }
      }
   }
}
