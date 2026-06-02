package com.salesforce.android.knowledge.core.internal.p021db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.knowledge.core.internal.model.ArticleDetailsModel;
import com.salesforce.android.knowledge.core.internal.model.ArticleListModel;
import com.salesforce.android.knowledge.core.internal.model.ArticleSummaryModel;
import com.salesforce.android.knowledge.core.internal.model.ChatterUserModel;
import com.salesforce.android.knowledge.core.internal.p021db.DbRead;
import com.salesforce.android.knowledge.core.internal.p021db.DbWrite;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.ChatterUser;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.yalantis.ucrop.util.FileUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class ArticleOperation {

    /* JADX INFO: renamed from: a */
    static final ServiceLogger f12902a = ServiceLogging.m14203a((Class<?>) ArticleOperation.class);

    /* JADX INFO: renamed from: b */
    @SuppressLint({"SimpleDateFormat"})
    static final SimpleDateFormat f12903b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    ArticleOperation() {
    }

    /* JADX INFO: renamed from: a */
    public static void m13098a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ArticleSummary (id TEXT PRIMARY KEY, article_number TEXT NOT NULL, title TEXT NOT NULL, url TEXT, summary TEXT, last_published TEXT, view_score REAL NOT NULL DEFAULT 0, view_count INTEGER NOT NULL DEFAULT 0, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ChatterUser (id TEXT PRIMARY KEY, first_name TEXT, last_name TEXT, email TEXT, username TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ArticleDetail (article_id TEXT NOT NULL, last_modified_date TEXT NOT NULL, last_modified_by TEXT NOT NULL, created_date TEXT NOT NULL, created_by TEXT NOT NULL, version_number INTEGER NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, UNIQUE(article_id), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id),FOREIGN KEY(last_modified_by) REFERENCES ChatterUser(id),FOREIGN KEY(created_by) REFERENCES ChatterUser(id))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ArticleField (article_id TEXT NOT NULL, name TEXT NOT NULL, label TEXT NOT NULL, value TEXT, type INTEGER NOT NULL, UNIQUE(article_id, name),FOREIGN KEY(article_id) REFERENCES ArticleDetail(article_id))");
    }

    /* JADX INFO: renamed from: b */
    public static void m13102b(SQLiteDatabase sQLiteDatabase) {
        DbUtil.m13140a(sQLiteDatabase, "ArticleField");
        DbUtil.m13140a(sQLiteDatabase, "ArticleDetail");
        DbUtil.m13140a(sQLiteDatabase, "ChatterUser");
        DbUtil.m13140a(sQLiteDatabase, "ArticleSummary");
    }

    public static class ReadList implements DbRead.Operation<ArticleList> {

        /* JADX INFO: renamed from: a */
        private final ArticleListRequest f12905a;

        public ReadList(ArticleListRequest articleListRequest) {
            this.f12905a = articleListRequest;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbRead.Operation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArticleList mo13107b(SQLiteDatabase sQLiteDatabase) {
            LinkedList linkedList = new LinkedList();
            boolean z = this.f12905a.m13317i() != null;
            boolean z2 = this.f12905a.m13319k() != null;
            ArrayList arrayList = new ArrayList(1);
            StringBuilder sb = new StringBuilder("SELECT * FROM ");
            sb.append("ArticleSummary");
            if (z) {
                ArticleOperation.m13097a(sb);
                sb.append(" WHERE");
                ArticleOperation.m13096a(this.f12905a.m13317i(), sb, (List<String>) arrayList);
            } else {
                sb.append(" WHERE");
            }
            if (z && z2) {
                sb.append(" AND");
            }
            if (z2) {
                ArticleOperation.m13094a(this.f12905a.m13319k(), sb, arrayList);
            }
            ArticleOperation.m13100b(this.f12905a.m13313e(), this.f12905a.m13315g(), sb);
            ArticleOperation.m13093a(this.f12905a.m13311c(), sb);
            ArticleOperation.m13092a(this.f12905a.m13310b(), this.f12905a.m13311c(), sb);
            ArticleOperation.f12902a.mo14187a("Executing query: {}", sb);
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
            boolean zMoveToFirst = cursorRawQuery.moveToFirst();
            int i = 0;
            ArticleOperation.f12902a.mo14187a("Found {} rows", Integer.valueOf(cursorRawQuery.getCount()));
            while (zMoveToFirst) {
                int i2 = i + 1;
                if (i >= this.f12905a.m13311c()) {
                    break;
                }
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_ID));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("article_number"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("last_published"));
                try {
                    linkedList.add(ArticleSummaryModel.m13216a(string, string2, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_TITLE)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("summary")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("url")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("view_count")), cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("view_score")), ArticleOperation.f12903b.parse(string3)));
                } catch (ParseException e) {
                    ArticleOperation.f12902a.mo14193d("Unable to parse last published date {} for article {}", string3, string);
                }
                zMoveToFirst = cursorRawQuery.moveToNext();
                i = i2;
            }
            cursorRawQuery.close();
            return ArticleListModel.m13211a(this.f12905a, linkedList, cursorRawQuery.getCount() > this.f12905a.m13311c());
        }
    }

    static class ReadDetails implements DbRead.Operation<ArticleDetails> {

        /* JADX INFO: renamed from: a */
        private final ArticleDetailRequest f12904a;

        ReadDetails(ArticleDetailRequest articleDetailRequest) {
            this.f12904a = articleDetailRequest;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbRead.Operation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArticleDetails mo13107b(SQLiteDatabase sQLiteDatabase) throws Exception {
            ArticleDetailsModel articleDetailsModelM13197a;
            String strM13304a = this.f12904a.m13304a();
            String[] strArr = {strM13304a};
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT ad.*, sum.*, cu.id AS cu__id, cu.first_name AS cu__first_name, cu.last_name AS cu__last_name, cu.email AS cu__email, cu.username AS cu__username, mu.id AS mu__id, mu.first_name AS mu__first_name, mu.last_name AS mu__last_name, mu.email AS mu__email, mu.username AS mu__username FROM ArticleDetail ad JOIN ChatterUser cu ON cu.id = ad.created_by JOIN ChatterUser mu ON mu.id = ad.last_modified_by JOIN ArticleSummary sum ON sum.id = ad.article_id WHERE ad.article_id = ?", strArr);
            try {
                if (!cursorRawQuery.moveToFirst()) {
                    articleDetailsModelM13197a = null;
                } else {
                    articleDetailsModelM13197a = ArticleDetailsModel.m13197a(strM13304a, DbUtil.m13139a(cursorRawQuery, "article_number"), DbUtil.m13139a(cursorRawQuery, ShareConstants.WEB_DIALOG_PARAM_TITLE), DbUtil.m13139a(cursorRawQuery, "summary"), DbUtil.m13139a(cursorRawQuery, "url"), DbUtil.m13141b(cursorRawQuery, "view_count"), cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("view_score")), ArticleOperation.f12903b.parse(DbUtil.m13139a(cursorRawQuery, "last_published")), DbUtil.m13141b(cursorRawQuery, "version_number"), ArticleOperation.f12903b.parse(DbUtil.m13139a(cursorRawQuery, "created_date")), ArticleOperation.f12903b.parse(DbUtil.m13139a(cursorRawQuery, "last_modified_date")), m13104a(cursorRawQuery, "cu"), m13104a(cursorRawQuery, "mu"), m13105a(sQLiteDatabase, strArr));
                }
                return articleDetailsModelM13197a;
            } finally {
                cursorRawQuery.close();
            }
        }

        /* JADX INFO: renamed from: a */
        private static ChatterUserModel m13104a(android.database.Cursor cursor, String str) {
            return ChatterUserModel.m13226a(DbUtil.m13139a(cursor, str + "__first_name"), DbUtil.m13139a(cursor, str + "__last_name"), DbUtil.m13139a(cursor, str + "__email"), DbUtil.m13139a(cursor, str + "__username"), DbUtil.m13139a(cursor, str + "__" + ShareConstants.WEB_DIALOG_PARAM_ID));
        }

        /* JADX INFO: renamed from: a */
        public static List<ArticleDetailsModel.FieldModel> m13105a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM ArticleField WHERE article_id = ?", strArr);
            ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(ArticleDetailsModel.FieldModel.m13205a(DbUtil.m13139a(cursorRawQuery, "label"), DbUtil.m13139a(cursorRawQuery, "name"), DbUtil.m13139a(cursorRawQuery, "value"), DbUtil.m13141b(cursorRawQuery, ShareConstants.MEDIA_TYPE)));
            }
            cursorRawQuery.close();
            return arrayList;
        }
    }

    public static class WriteList implements DbWrite.Operation {

        /* JADX INFO: renamed from: a */
        private final ArticleList f12907a;

        public WriteList(ArticleList articleList) {
            this.f12907a = articleList;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbWrite.Operation
        /* JADX INFO: renamed from: a */
        public void mo13091a(SQLiteDatabase sQLiteDatabase) {
            for (ArticleSummary articleSummary : this.f12907a.mo13212a()) {
                ArticleOperation.f12902a.mo14187a("Inserting {} to database", articleSummary.toString());
                ArticleOperation.m13099a(sQLiteDatabase, articleSummary);
            }
        }
    }

    public static class WriteDetails implements DbWrite.Operation {

        /* JADX INFO: renamed from: a */
        private final ArticleDetails f12906a;

        public WriteDetails(ArticleDetails articleDetails) {
            this.f12906a = articleDetails;
        }

        @Override // com.salesforce.android.knowledge.core.internal.db.DbWrite.Operation
        /* JADX INFO: renamed from: a */
        public void mo13091a(SQLiteDatabase sQLiteDatabase) {
            ChatterUser chatterUserMo13202e = this.f12906a.mo13202e();
            m13110a(sQLiteDatabase, chatterUserMo13202e);
            ChatterUser chatterUserMo13201d = this.f12906a.mo13201d();
            if (!chatterUserMo13201d.mo13229c().equals(chatterUserMo13202e.mo13229c())) {
                m13110a(sQLiteDatabase, chatterUserMo13201d);
            }
            ArticleOperation.m13099a(sQLiteDatabase, this.f12906a);
            m13109a(sQLiteDatabase, this.f12906a);
            m13111b(sQLiteDatabase, this.f12906a);
        }

        /* JADX INFO: renamed from: a */
        private static void m13110a(SQLiteDatabase sQLiteDatabase, ChatterUser chatterUser) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, chatterUser.mo13229c());
            contentValues.put("email", chatterUser.mo13227a());
            contentValues.put("first_name", chatterUser.mo13228b());
            contentValues.put("last_name", chatterUser.mo13230d());
            contentValues.put("username", chatterUser.mo13231e());
            sQLiteDatabase.insertWithOnConflict("ChatterUser", null, contentValues, 5);
        }

        /* JADX INFO: renamed from: a */
        private static void m13109a(SQLiteDatabase sQLiteDatabase, ArticleDetails articleDetails) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("article_id", articleDetails.mo13217g());
            contentValues.put("created_date", ArticleOperation.f12903b.format(articleDetails.mo13199b()));
            contentValues.put("created_by", articleDetails.mo13201d().mo13229c());
            contentValues.put("last_modified_date", ArticleOperation.f12903b.format(articleDetails.mo13200c()));
            contentValues.put("last_modified_by", articleDetails.mo13202e().mo13229c());
            contentValues.put("version_number", Integer.valueOf(articleDetails.mo13198a()));
            sQLiteDatabase.insertWithOnConflict("ArticleDetail", null, contentValues, 5);
        }

        /* JADX INFO: renamed from: b */
        private static void m13111b(SQLiteDatabase sQLiteDatabase, ArticleDetails articleDetails) {
            ContentValues contentValues = new ContentValues();
            for (ArticleDetails.Field field : articleDetails.mo13203f()) {
                contentValues.put("article_id", articleDetails.mo13217g());
                contentValues.put("label", field.mo13206a());
                contentValues.put("name", field.mo13207b());
                contentValues.put("value", field.mo13208c());
                contentValues.put(ShareConstants.MEDIA_TYPE, Integer.valueOf(field.mo13209d()));
                sQLiteDatabase.insertWithOnConflict("ArticleField", null, contentValues, 5);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m13099a(SQLiteDatabase sQLiteDatabase, ArticleSummary articleSummary) {
        ArticleSummaryModel articleSummaryModel = (ArticleSummaryModel) articleSummary;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, articleSummaryModel.mo13217g());
        contentValues.put("article_number", articleSummaryModel.m13218h());
        contentValues.put("last_published", f12903b.format(articleSummaryModel.m13224n()));
        contentValues.put("summary", articleSummaryModel.mo13220j());
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, articleSummaryModel.mo13219i());
        contentValues.put("url", articleSummaryModel.m13221k());
        contentValues.put("view_score", Double.valueOf(articleSummaryModel.m13223m()));
        contentValues.put("view_count", Integer.valueOf(articleSummaryModel.m13222l()));
        sQLiteDatabase.insertWithOnConflict("ArticleSummary", null, contentValues, 5);
    }

    /* JADX INFO: renamed from: a */
    static void m13097a(StringBuilder sb) {
        sb.append(" INNER JOIN ");
        sb.append("ArticleCategories");
        sb.append(" ON ");
        m13095a("ArticleCategories", "article_id", sb);
        sb.append(" = ");
        m13095a("ArticleSummary", ShareConstants.WEB_DIALOG_PARAM_ID, sb);
    }

    /* JADX INFO: renamed from: a */
    static void m13096a(String str, StringBuilder sb, List<String> list) {
        sb.append(" ");
        m13095a("ArticleCategories", "category_name", sb);
        m13101b(str, sb, list);
    }

    /* JADX INFO: renamed from: a */
    static void m13094a(CharSequence charSequence, StringBuilder sb, List<String> list) {
        sb.append(" (");
        m13095a("ArticleSummary", ShareConstants.WEB_DIALOG_PARAM_TITLE, sb);
        m13103c(charSequence.toString(), sb, list);
        sb.append(" OR ");
        m13095a("ArticleSummary", "summary", sb);
        m13103c(charSequence.toString(), sb, list);
        sb.append(")");
    }

    /* JADX INFO: renamed from: a */
    static void m13093a(int i, StringBuilder sb) {
        sb.append(" LIMIT ");
        sb.append(i + 1);
    }

    /* JADX INFO: renamed from: a */
    static void m13092a(int i, int i2, StringBuilder sb) {
        sb.append(" OFFSET ");
        sb.append((i - 1) * i2);
    }

    /* JADX INFO: renamed from: a */
    static void m13095a(String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(FileUtils.HIDDEN_PREFIX);
        sb.append(str2);
    }

    /* JADX INFO: renamed from: b */
    static void m13101b(String str, StringBuilder sb, List<String> list) {
        sb.append(" = ?");
        list.add(str);
    }

    /* JADX INFO: renamed from: c */
    static void m13103c(String str, StringBuilder sb, List<String> list) {
        sb.append(" LIKE ?");
        list.add('%' + str + '%');
    }

    /* JADX INFO: renamed from: b */
    static void m13100b(int i, int i2, StringBuilder sb) {
        sb.append(" ORDER BY ");
        switch (i) {
            case 1:
                sb.append("datetime(");
                m13095a("ArticleSummary", "last_published", sb);
                sb.append(")");
                break;
            case 2:
                m13095a("ArticleSummary", ShareConstants.WEB_DIALOG_PARAM_TITLE, sb);
                break;
            case 3:
                m13095a("ArticleSummary", "view_score", sb);
                break;
            default:
                throw new IllegalArgumentException("Unhandled sorting column");
        }
        if (i2 == 1) {
            sb.append(" ASC");
        } else {
            sb.append(" DESC");
        }
    }
}
