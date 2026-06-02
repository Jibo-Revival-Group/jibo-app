package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlterSoupLongOperation extends LongOperation {

    /* JADX INFO: renamed from: a */
    protected String f14281a;

    /* JADX INFO: renamed from: b */
    private String f14282b;

    /* JADX INFO: renamed from: c */
    private AlterSoupStep f14283c;

    /* JADX INFO: renamed from: d */
    private SoupSpec f14284d;

    /* JADX INFO: renamed from: e */
    private SoupSpec f14285e;

    /* JADX INFO: renamed from: f */
    private IndexSpec[] f14286f;

    /* JADX INFO: renamed from: g */
    private IndexSpec[] f14287g;

    /* JADX INFO: renamed from: h */
    private boolean f14288h;

    /* JADX INFO: renamed from: i */
    private SmartStore f14289i;

    /* JADX INFO: renamed from: j */
    private SQLiteDatabase f14290j;

    /* JADX INFO: renamed from: k */
    private long f14291k;

    public enum AlterSoupStep {
        STARTING,
        RENAME_OLD_SOUP_TABLE,
        DROP_OLD_INDEXES,
        REGISTER_SOUP_USING_TABLE_NAME,
        COPY_TABLE,
        RE_INDEX_SOUP,
        DROP_OLD_TABLE;

        public static final AlterSoupStep LAST = DROP_OLD_TABLE;
    }

    @Override // com.salesforce.androidsdk.smartstore.store.LongOperation
    /* JADX INFO: renamed from: a */
    public void mo14679a() {
        m14680a(AlterSoupStep.LAST);
    }

    /* JADX INFO: renamed from: a */
    public void m14680a(AlterSoupStep alterSoupStep) {
        m14676c(alterSoupStep);
    }

    @Override // com.salesforce.androidsdk.smartstore.store.LongOperation
    /* JADX INFO: renamed from: a */
    protected void mo14681a(SmartStore smartStore, long j, JSONObject jSONObject, String str) throws JSONException {
        this.f14289i = smartStore;
        this.f14290j = smartStore.m14785a();
        this.f14291k = j;
        this.f14283c = AlterSoupStep.valueOf(str);
        this.f14281a = jSONObject.getString("soupName");
        this.f14284d = SoupSpec.m14805a(jSONObject.optJSONObject("newSoupFeatures"));
        this.f14285e = SoupSpec.m14805a(jSONObject.optJSONObject("oldSoupFeatures"));
        this.f14286f = IndexSpec.m14740a(jSONObject.getJSONArray("newIndexSpecs"));
        this.f14287g = IndexSpec.m14740a(jSONObject.getJSONArray("oldIndexSpecs"));
        this.f14288h = jSONObject.getBoolean("reIndexData");
        this.f14282b = jSONObject.getString("soupTableName");
    }

    /* JADX INFO: renamed from: c */
    private void m14676c(AlterSoupStep alterSoupStep) {
        switch (this.f14283c) {
            case STARTING:
                m14682b();
                if (alterSoupStep == AlterSoupStep.RENAME_OLD_SOUP_TABLE) {
                }
            case RENAME_OLD_SOUP_TABLE:
                m14684c();
                if (alterSoupStep == AlterSoupStep.DROP_OLD_INDEXES) {
                }
            case DROP_OLD_INDEXES:
                m14685d();
                if (alterSoupStep == AlterSoupStep.REGISTER_SOUP_USING_TABLE_NAME) {
                }
            case REGISTER_SOUP_USING_TABLE_NAME:
                m14686e();
                if (alterSoupStep == AlterSoupStep.COPY_TABLE) {
                }
            case COPY_TABLE:
                if (this.f14288h) {
                    m14687f();
                }
                if (alterSoupStep == AlterSoupStep.RE_INDEX_SOUP) {
                }
            case RE_INDEX_SOUP:
                m14688g();
                if (alterSoupStep == AlterSoupStep.DROP_OLD_TABLE) {
                }
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14682b() {
        try {
            this.f14290j.beginTransaction();
            this.f14290j.execSQL("ALTER TABLE " + this.f14282b + " RENAME TO " + m14678i());
            if (IndexSpec.m14741b(this.f14287g)) {
                this.f14290j.execSQL("ALTER TABLE " + this.f14282b + "_fts RENAME TO " + m14678i() + "_fts");
            }
            m14683b(AlterSoupStep.RENAME_OLD_SOUP_TABLE);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m14684c() {
        try {
            this.f14290j.beginTransaction();
            for (String str : new String[]{"created", "lastModified"}) {
                this.f14290j.execSQL(String.format("DROP INDEX IF EXISTS %s_%s_idx", this.f14282b, str));
            }
            for (int i = 0; i < this.f14287g.length; i++) {
                this.f14290j.execSQL(String.format("DROP INDEX IF EXISTS %s_%s_idx", this.f14282b, "" + i));
            }
            DBHelper.m14689a(this.f14290j).m14704b(this.f14290j, "soup_index_map", "soupName = ?", this.f14281a);
            DBHelper.m14689a(this.f14290j).m14710e(this.f14281a);
            m14683b(AlterSoupStep.DROP_OLD_INDEXES);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: d */
    protected void m14685d() {
        try {
            this.f14290j.beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (String str : SoupSpec.f14337a) {
                contentValues.put(str, Integer.valueOf(this.f14284d.m14807b().contains(str) ? 1 : 0));
            }
            DBHelper.m14689a(this.f14290j).m14692a(this.f14290j, "soup_attrs", contentValues, "soupName = ?", this.f14281a);
            this.f14289i.m14794a(this.f14284d, this.f14286f, this.f14282b);
            m14683b(AlterSoupStep.REGISTER_SOUP_USING_TABLE_NAME);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: e */
    protected void m14686e() {
        this.f14290j.beginTransaction();
        try {
            this.f14286f = this.f14289i.m14797a(this.f14281a);
            m14677h();
            m14683b(AlterSoupStep.COPY_TABLE);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: f */
    protected void m14687f() {
        HashSet hashSet = new HashSet();
        for (IndexSpec indexSpec : this.f14287g) {
            hashSet.add(indexSpec.m14743a());
        }
        ArrayList arrayList = new ArrayList();
        for (IndexSpec indexSpec2 : this.f14286f) {
            if (!hashSet.contains(indexSpec2.m14743a())) {
                arrayList.add(indexSpec2.f14308a);
            }
        }
        this.f14290j.beginTransaction();
        try {
            this.f14289i.m14796a(this.f14281a, (String[]) arrayList.toArray(new String[0]), false);
            m14683b(AlterSoupStep.RE_INDEX_SOUP);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: g */
    protected void m14688g() {
        this.f14290j.beginTransaction();
        try {
            this.f14290j.execSQL("DROP TABLE " + m14678i());
            if (IndexSpec.m14741b(this.f14287g)) {
                this.f14290j.execSQL("DROP TABLE IF EXISTS " + m14678i() + "_fts");
            }
            m14683b(AlterSoupStep.DROP_OLD_TABLE);
            this.f14290j.setTransactionSuccessful();
        } finally {
            this.f14290j.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14683b(AlterSoupStep alterSoupStep) {
        if (alterSoupStep == AlterSoupStep.LAST) {
            DBHelper.m14689a(this.f14290j).m14704b(this.f14290j, "long_operations_status", "id = ?", this.f14291k + "");
        } else {
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, alterSoupStep.toString());
            contentValues.put("lastModified", lValueOf);
            DBHelper.m14689a(this.f14290j).m14692a(this.f14290j, "long_operations_status", contentValues, "id = ?", this.f14291k + "");
        }
        SmartStoreLogger.m14826b("AlterSoup:Status", this.f14281a + " " + alterSoupStep);
    }

    /* JADX INFO: renamed from: h */
    private void m14677h() throws Throwable {
        String[] strArr;
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursorQuery2 = null;
        Map<String, IndexSpec> mapM14739a = IndexSpec.m14739a(this.f14287g);
        Map<String, IndexSpec> mapM14739a2 = IndexSpec.m14739a(this.f14286f);
        Set<String> setKeySet = mapM14739a.keySet();
        Set<String> setKeySet2 = mapM14739a2.keySet();
        setKeySet2.retainAll(setKeySet);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.f14284d.m14807b().contains("externalStorage") || this.f14285e.m14807b().contains("externalStorage")) {
            strArr = new String[]{ShareConstants.WEB_DIALOG_PARAM_ID, "created", "lastModified"};
        } else {
            strArr = new String[]{ShareConstants.WEB_DIALOG_PARAM_ID, "soup", "created", "lastModified"};
        }
        for (String str : strArr) {
            arrayList.add(str);
            arrayList2.add(str);
        }
        for (String str2 : setKeySet2) {
            IndexSpec indexSpec = mapM14739a.get(str2);
            IndexSpec indexSpec2 = mapM14739a2.get(str2);
            if (indexSpec2.f14309b.getColumnType() != null && (indexSpec.f14309b.getColumnType() == null || indexSpec.f14309b.getColumnType().equals(indexSpec2.f14309b.getColumnType()))) {
                arrayList.add(indexSpec.f14310c);
                arrayList2.add(indexSpec2.f14310c);
            }
        }
        this.f14290j.execSQL(String.format("INSERT INTO %s (%s) SELECT %s FROM %s", this.f14282b, TextUtils.join(",", arrayList2), TextUtils.join(",", arrayList), m14678i()));
        if (IndexSpec.m14741b(this.f14286f)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            arrayList3.add(ShareConstants.WEB_DIALOG_PARAM_ID);
            arrayList4.add("rowid");
            for (String str3 : setKeySet2) {
                IndexSpec indexSpec3 = mapM14739a.get(str3);
                IndexSpec indexSpec4 = mapM14739a2.get(str3);
                if (indexSpec3.f14309b.getColumnType() == null || indexSpec3.f14309b.getColumnType().equals(indexSpec4.f14309b.getColumnType())) {
                    if (indexSpec4.f14309b == SmartStore.Type.full_text) {
                        arrayList3.add(indexSpec3.f14310c);
                        arrayList4.add(indexSpec4.f14310c);
                    }
                }
            }
            this.f14290j.execSQL(String.format("INSERT INTO %s%s (%s) SELECT %s FROM %s", this.f14282b, "_fts", TextUtils.join(",", arrayList4), TextUtils.join(",", arrayList3), m14678i()));
        }
        if (this.f14285e.m14807b().contains("externalStorage") && !this.f14284d.m14807b().contains("externalStorage")) {
            try {
                cursorQuery = this.f14290j.query(m14678i(), new String[]{ShareConstants.WEB_DIALOG_PARAM_ID}, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    Long[] lArr = new Long[cursorQuery.getCount()];
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        lArr[i] = Long.valueOf(cursorQuery.getLong(0));
                        if (!cursorQuery.moveToNext()) {
                            break;
                        } else {
                            i = i2;
                        }
                    }
                    for (Long l : lArr) {
                        long jLongValue = l.longValue();
                        String strM14734b = ((DBOpenHelper) this.f14289i.f14329b).m14734b(this.f14282b, jLongValue, this.f14289i.f14330c);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("soup", strM14734b);
                        DBHelper.m14689a(this.f14290j).m14692a(this.f14290j, this.f14282b, contentValues, "id = ?", jLongValue + "");
                        ((DBOpenHelper) this.f14289i.f14329b).m14733a(this.f14282b, new Long[]{Long.valueOf(jLongValue)});
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                throw th;
            }
        }
        if (!this.f14285e.m14807b().contains("externalStorage") && this.f14284d.m14807b().contains("externalStorage")) {
            try {
                cursorQuery2 = this.f14290j.query(m14678i(), new String[]{ShareConstants.WEB_DIALOG_PARAM_ID, "soup"}, null, null, null, null, null);
                if (cursorQuery2.moveToFirst()) {
                    do {
                        ((DBOpenHelper) this.f14289i.f14329b).m14731a(this.f14282b, cursorQuery2.getLong(0), cursorQuery2.getString(1), this.f14289i.f14330c);
                    } while (cursorQuery2.moveToNext());
                }
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
            } finally {
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private String m14678i() {
        return this.f14282b + "_old";
    }
}
