package com.salesforce.android.knowledge.core.internal.p021db;

import android.content.ContentValues;
import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupListModel;
import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupModel;
import com.salesforce.android.knowledge.core.internal.model.DataCategorySummaryModel;
import com.salesforce.android.knowledge.core.internal.model.DataCategoryTreeModel;
import com.salesforce.android.knowledge.core.internal.p021db.DbRead;
import com.salesforce.android.knowledge.core.internal.p021db.DbWrite;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class DataCategoryGroupOperation {
    /* JADX INFO: renamed from: a */
    public static void m13113a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DataCategoryGroup (name TEXT NOT NULL PRIMARY KEY, label TEXT NOT NULL,cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }

    /* JADX INFO: renamed from: b */
    public static void m13114b(SQLiteDatabase sQLiteDatabase) {
        DbUtil.m13140a(sQLiteDatabase, "DataCategoryGroup");
    }

    public static class WriteList implements DbWrite.Operation {

        /* JADX INFO: renamed from: a */
        private DataCategoryGroupList f12908a;

        public WriteList(DataCategoryGroupList dataCategoryGroupList) {
            this.f12908a = dataCategoryGroupList;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbWrite.Operation
        /* JADX INFO: renamed from: a */
        public void mo13091a(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            for (DataCategoryGroup dataCategoryGroup : this.f12908a.mo13235a()) {
                contentValues.put("name", dataCategoryGroup.mo13238a());
                contentValues.put("label", dataCategoryGroup.mo13239b());
                sQLiteDatabase.insertWithOnConflict("DataCategoryGroup", null, contentValues, 5);
                Iterator<DataCategoryTree> it = dataCategoryGroup.mo13240c().iterator();
                while (it.hasNext()) {
                    m13117a(sQLiteDatabase, it.next(), dataCategoryGroup);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static void m13117a(SQLiteDatabase sQLiteDatabase, DataCategoryTree dataCategoryTree, DataCategoryGroup dataCategoryGroup) {
            StringBuilder sbAppend = new StringBuilder("INSERT OR REPLACE INTO ").append("DataCategorySummary").append(" (").append("name").append(", ").append("label").append(", ").append("parent").append(", ").append("data_category_group").append(") VALUES ");
            m13116a(sbAppend, dataCategoryTree, dataCategoryGroup);
            sQLiteDatabase.execSQL(sbAppend.toString());
        }

        /* JADX INFO: renamed from: a */
        private static void m13116a(StringBuilder sb, DataCategoryTree dataCategoryTree, DataCategoryGroup dataCategoryGroup) {
            DataCategorySummary dataCategorySummaryMo13254c = dataCategoryTree.mo13254c();
            String strMo13245a = dataCategoryTree.mo13252a() == null ? null : dataCategoryTree.mo13252a().mo13254c().mo13245a();
            sb.append("('").append(dataCategorySummaryMo13254c.mo13245a()).append("', '").append(dataCategorySummaryMo13254c.mo13246b()).append("', ");
            if (strMo13245a != null) {
                sb.append("'").append(strMo13245a).append("', '");
            } else {
                sb.append("null, '");
            }
            sb.append(dataCategoryGroup.mo13238a()).append("')");
            Set<DataCategoryTree> setMo13253b = dataCategoryTree.mo13253b();
            if (setMo13253b.size() > 0) {
                sb.append(", ");
            }
            int i = 0;
            Iterator<DataCategoryTree> it = setMo13253b.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    m13116a(sb, it.next(), dataCategoryGroup);
                    i = i2 + 1;
                    if (i < setMo13253b.size()) {
                        sb.append(", ");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static class ReadList implements DbRead.Operation<DataCategoryGroupList> {
        @Override // com.salesforce.android.knowledge.core.internal.db.DbRead.Operation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataCategoryGroupList mo13107b(SQLiteDatabase sQLiteDatabase) {
            LinkedList linkedList = new LinkedList();
            Cursor cursorQuery = sQLiteDatabase.query("DataCategoryGroup", new String[]{"name", "label"}, null, null, null, null, null, null);
            try {
                for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    String strM13139a = DbUtil.m13139a(cursorQuery, "name");
                    linkedList.add(DataCategoryGroupModel.m13237a(strM13139a, DbUtil.m13139a(cursorQuery, "label"), DataCategoryGroupOperation.m13112a(strM13139a, sQLiteDatabase)));
                }
                cursorQuery.close();
                return DataCategoryGroupListModel.m13233a(linkedList);
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static List<DataCategoryTree> m13112a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT a.name, a.label, a.parent, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.data_category_group=? GROUP BY a.ROWID", new String[]{str});
        HashMap map = new HashMap(cursorRawQuery.getCount(), 1.0f);
        try {
            for (boolean zMoveToFirst = cursorRawQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorRawQuery.moveToNext()) {
                String strM13139a = DbUtil.m13139a(cursorRawQuery, "label");
                String strM13139a2 = DbUtil.m13139a(cursorRawQuery, "name");
                map.put(strM13139a2, new DataCategoryTreeModel(DataCategorySummaryModel.m13244a(strM13139a2, strM13139a, DbUtil.m13141b(cursorRawQuery, "subCategories"), DbUtil.m13139a(cursorRawQuery, "parent"))));
            }
            cursorRawQuery.close();
            ArrayList arrayList = new ArrayList();
            for (DataCategoryTreeModel dataCategoryTreeModel : map.values()) {
                DataCategorySummaryModel dataCategorySummaryModel = (DataCategorySummaryModel) dataCategoryTreeModel.mo13254c();
                String strM13248d = dataCategorySummaryModel.m13248d();
                if (dataCategorySummaryModel.m13248d() == null) {
                    arrayList.add(dataCategoryTreeModel);
                } else {
                    dataCategoryTreeModel.m13251a((DataCategoryTreeModel) map.get(strM13248d));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }
}
