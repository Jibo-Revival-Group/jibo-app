package com.salesforce.android.knowledge.core.internal.p021db;

import android.content.ContentValues;
import com.salesforce.android.knowledge.core.internal.p021db.DbWrite;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class ArticleMappingOperation {

    /* JADX INFO: renamed from: a */
    static final ServiceLogger f12899a = ServiceLogging.m14203a((Class<?>) ArticleMappingOperation.class);

    ArticleMappingOperation() {
    }

    /* JADX INFO: renamed from: a */
    public static void m13088a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ArticleCategories (category_name TEXT NOT NULL, article_id TEXT NOT NULL, UNIQUE(article_id, category_name)FOREIGN KEY(category_name) REFERENCES DataCategorySummary(name), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id))");
    }

    /* JADX INFO: renamed from: b */
    public static void m13089b(SQLiteDatabase sQLiteDatabase) {
        DbUtil.m13140a(sQLiteDatabase, "ArticleCategories");
    }

    public static class WriteList implements DbWrite.Operation {

        /* JADX INFO: renamed from: a */
        private final String f12900a;

        /* JADX INFO: renamed from: b */
        private final ArticleList f12901b;

        public WriteList(String str, ArticleList articleList) {
            this.f12900a = str;
            this.f12901b = articleList;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbWrite.Operation
        /* JADX INFO: renamed from: a */
        public void mo13091a(SQLiteDatabase sQLiteDatabase) {
            for (String str : ArticleMappingOperation.m13087a(sQLiteDatabase, this.f12900a)) {
                Iterator<ArticleSummary> it = this.f12901b.mo13212a().iterator();
                while (it.hasNext()) {
                    m13090a(sQLiteDatabase, str, it.next());
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m13090a(SQLiteDatabase sQLiteDatabase, String str, ArticleSummary articleSummary) {
            ArticleMappingOperation.f12899a.mo14187a("Mapping {} to {} in database", articleSummary, str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("article_id", articleSummary.mo13217g());
            contentValues.put("category_name", str);
            sQLiteDatabase.insertWithOnConflict("ArticleCategories", null, contentValues, 4);
        }
    }

    /* JADX INFO: renamed from: a */
    static List<String> m13087a(SQLiteDatabase sQLiteDatabase, String str) {
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(str);
            Cursor cursorQuery = sQLiteDatabase.query("DataCategorySummary", null, "name=?", new String[]{str}, null, null, null, null);
            str = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("parent")) : null;
            cursorQuery.close();
        } while (str != null);
        return arrayList;
    }
}
