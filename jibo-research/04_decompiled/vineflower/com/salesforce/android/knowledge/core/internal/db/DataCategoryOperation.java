package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.android.knowledge.core.internal.model.DataCategoryListModel;
import com.salesforce.android.knowledge.core.internal.model.DataCategorySummaryModel;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import java.util.LinkedList;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

class DataCategoryOperation {
   public static void a(SQLiteDatabase var0) {
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS DataCategorySummary (name TEXT PRIMARY KEY, label TEXT NOT NULL, parent TEXT, data_category_group TEXT NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY(parent) REFERENCES DataCategorySummary(name), FOREIGN KEY(data_category_group) REFERENCES DataCategoryGroup(name))"
      );
   }

   public static void b(SQLiteDatabase var0) {
      DbUtil.a(var0, "DataCategorySummary");
   }

   public static class ReadList implements DbRead.Operation<DataCategoryList> {
      private final DataCategoriesRequest a;

      public ReadList(DataCategoriesRequest var1) {
         this.a = var1;
      }

      public DataCategoryList a(SQLiteDatabase var1) {
         LinkedList var3 = new LinkedList();
         Cursor var4 = var1.rawQuery(
            "SELECT a.name, a.label, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.parent=? AND a.data_category_group=? GROUP BY a.ROWID",
            new String[]{this.a.a(), this.a.b()}
         );

         for (boolean var2 = var4.moveToFirst(); var2; var2 = var4.moveToNext()) {
            var3.add(DataCategorySummaryModel.a(DbUtil.a(var4, "name"), DbUtil.a(var4, "label"), DbUtil.b(var4, "subCategories"), this.a.a()));
         }

         var4.close();
         return DataCategoryListModel.a(var3);
      }
   }
}
