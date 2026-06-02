package com.salesforce.android.knowledge.core.internal.p021db;

import com.salesforce.android.knowledge.core.internal.model.DataCategoryListModel;
import com.salesforce.android.knowledge.core.internal.model.DataCategorySummaryModel;
import com.salesforce.android.knowledge.core.internal.p021db.DbRead;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import java.util.LinkedList;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class DataCategoryOperation {
    /* JADX INFO: renamed from: a */
    public static void m13118a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DataCategorySummary (name TEXT PRIMARY KEY, label TEXT NOT NULL, parent TEXT, data_category_group TEXT NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY(parent) REFERENCES DataCategorySummary(name), FOREIGN KEY(data_category_group) REFERENCES DataCategoryGroup(name))");
    }

    /* JADX INFO: renamed from: b */
    public static void m13119b(SQLiteDatabase sQLiteDatabase) {
        DbUtil.m13140a(sQLiteDatabase, "DataCategorySummary");
    }

    public static class ReadList implements DbRead.Operation<DataCategoryList> {

        /* JADX INFO: renamed from: a */
        private final DataCategoriesRequest f12909a;

        public ReadList(DataCategoriesRequest dataCategoriesRequest) {
            this.f12909a = dataCategoriesRequest;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbRead.Operation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataCategoryList mo13107b(SQLiteDatabase sQLiteDatabase) {
            LinkedList linkedList = new LinkedList();
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT a.name, a.label, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.parent=? AND a.data_category_group=? GROUP BY a.ROWID", new String[]{this.f12909a.m13329a(), this.f12909a.m13330b()});
            for (boolean zMoveToFirst = cursorRawQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorRawQuery.moveToNext()) {
                linkedList.add(DataCategorySummaryModel.m13244a(DbUtil.m13139a(cursorRawQuery, "name"), DbUtil.m13139a(cursorRawQuery, "label"), DbUtil.m13141b(cursorRawQuery, "subCategories"), this.f12909a.m13329a()));
            }
            cursorRawQuery.close();
            return DataCategoryListModel.m13241a(linkedList);
        }
    }
}
