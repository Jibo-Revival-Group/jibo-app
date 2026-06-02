package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.store.LongOperation;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmartStore {

    /* JADX INFO: renamed from: a */
    protected SQLiteDatabase f14328a;

    /* JADX INFO: renamed from: b */
    protected SQLiteOpenHelper f14329b;

    /* JADX INFO: renamed from: c */
    protected String f14330c;

    /* JADX INFO: renamed from: d */
    protected FtsExtension f14331d = FtsExtension.fts5;

    /* JADX INFO: renamed from: e */
    private final ExecutorService f14332e = Executors.newFixedThreadPool(1);

    public enum FtsExtension {
        fts4,
        fts5
    }

    public enum TypeGroup {
        value_extracted_to_column { // from class: com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup.1
            @Override // com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup
            public boolean isMember(Type type) {
                return type == Type.string || type == Type.integer || type == Type.floating || type == Type.full_text;
            }
        },
        value_extracted_to_fts_column { // from class: com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup.2
            @Override // com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup
            public boolean isMember(Type type) {
                return type == Type.full_text;
            }
        },
        value_indexed_with_json_extract { // from class: com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup.3
            @Override // com.salesforce.androidsdk.smartstore.store.SmartStore.TypeGroup
            public boolean isMember(Type type) {
                return type == Type.json1;
            }
        };

        public abstract boolean isMember(Type type);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14776a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        synchronized (sQLiteDatabase) {
            if (str2 != null) {
                if (!str2.trim().equals("")) {
                    sQLiteDatabase.execSQL("PRAGMA rekey = '" + str2 + "'");
                    DBOpenHelper.m14721a(sQLiteDatabase, str, str2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m14775a(SQLiteDatabase sQLiteDatabase) {
        synchronized (sQLiteDatabase) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append("soup_index_map").append(" (").append("soupName").append(" TEXT").append(",").append("path").append(" TEXT").append(",").append("columnName").append(" TEXT").append(",").append("columnType").append(" TEXT").append(")");
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.execSQL(String.format("CREATE INDEX %s on %s ( %s )", "soup_index_map_0", "soup_index_map", "soupName"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ").append("soup_attrs").append(" (").append(ShareConstants.WEB_DIALOG_PARAM_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT").append(",").append("soupName").append(" TEXT");
            for (String str : SoupSpec.f14337a) {
                sb2.append(",").append(str).append(" INTEGER DEFAULT 0");
            }
            sb2.append(")");
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL(String.format("CREATE INDEX %s on %s ( %s )", "soup_attrs_0", "soup_attrs", "soupName"));
            m14782b(sQLiteDatabase);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m14782b(SQLiteDatabase sQLiteDatabase) {
        synchronized (sQLiteDatabase) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS ").append("long_operations_status").append(" (").append(ShareConstants.WEB_DIALOG_PARAM_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT").append(",").append(ShareConstants.MEDIA_TYPE).append(" TEXT").append(",").append("details").append(" TEXT").append(",").append(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).append(" TEXT").append(", ").append("created").append(" INTEGER").append(", ").append("lastModified").append(" INTEGER").append(")");
            sQLiteDatabase.execSQL(sb.toString());
        }
    }

    @Deprecated
    public SmartStore(SQLiteDatabase sQLiteDatabase) {
        this.f14328a = sQLiteDatabase;
    }

    public SmartStore(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        this.f14329b = sQLiteOpenHelper;
        this.f14330c = str;
    }

    /* JADX INFO: renamed from: a */
    public SQLiteDatabase m14785a() {
        return this.f14328a != null ? this.f14328a : this.f14329b.getWritableDatabase(this.f14330c);
    }

    /* JADX INFO: renamed from: a */
    public void m14795a(String str, IndexSpec[] indexSpecArr) {
        m14793a(new SoupSpec(str), indexSpecArr);
    }

    /* JADX INFO: renamed from: a */
    public void m14793a(final SoupSpec soupSpec, final IndexSpec[] indexSpecArr) {
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            String strM14806a = soupSpec.m14806a();
            if (strM14806a == null) {
                throw new SmartStoreException("Bogus soup name:" + strM14806a);
            }
            if (indexSpecArr.length == 0) {
                throw new SmartStoreException("No indexSpecs specified for soup: " + strM14806a);
            }
            if (IndexSpec.m14742c(indexSpecArr) && soupSpec.m14807b().contains("externalStorage")) {
                throw new SmartStoreException("Can't have JSON1 index specs in externally stored soup:" + strM14806a);
            }
            if (!m14800c(strM14806a)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("soupName", strM14806a);
                Iterator<String> it = soupSpec.m14807b().iterator();
                while (it.hasNext()) {
                    contentValues.put(it.next(), (Integer) 1);
                }
                try {
                    sQLiteDatabaseM14785a.beginTransaction();
                    m14794a(soupSpec, indexSpecArr, m14770a(DBHelper.m14689a(sQLiteDatabaseM14785a).m14694a(sQLiteDatabaseM14785a, "soup_attrs", contentValues)));
                    sQLiteDatabaseM14785a.setTransactionSuccessful();
                    sQLiteDatabaseM14785a.endTransaction();
                    if (SalesforceSDKManager.m14403a().m14421C()) {
                        m14781b(soupSpec, indexSpecArr);
                    } else {
                        this.f14332e.execute(new Runnable() { // from class: com.salesforce.androidsdk.smartstore.store.SmartStore.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SmartStore.this.m14781b(soupSpec, indexSpecArr);
                            }
                        });
                    }
                } catch (Throwable th) {
                    sQLiteDatabaseM14785a.endTransaction();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m14781b(SoupSpec soupSpec, IndexSpec[] indexSpecArr) {
        JSONArray jSONArray = new JSONArray();
        if (IndexSpec.m14742c(indexSpecArr)) {
            jSONArray.put("JSON1");
        }
        if (IndexSpec.m14741b(indexSpecArr)) {
            jSONArray.put("FTS");
        }
        if (soupSpec.m14807b().contains("externalStorage")) {
            jSONArray.put("ExternalStorage");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("features", jSONArray);
        } catch (JSONException e) {
            SmartStoreLogger.m14825a("SmartStore", "Exception thrown while building page object", e);
        }
        EventBuilderHelper.m14289b("registerSoup", null, "SmartStore", jSONObject);
    }

    /* JADX INFO: renamed from: a */
    protected void m14794a(SoupSpec soupSpec, IndexSpec[] indexSpecArr, String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        IndexSpec[] indexSpecArr2 = new IndexSpec[indexSpecArr.length];
        ArrayList arrayList3 = new ArrayList();
        String strM14806a = soupSpec.m14806a();
        sb.append("CREATE TABLE ").append(str).append(" (").append(ShareConstants.WEB_DIALOG_PARAM_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT");
        if (!m14804e(strM14806a)) {
            sb.append(", ").append("soup").append(" TEXT");
        }
        sb.append(", ").append("created").append(" INTEGER").append(", ").append("lastModified").append(" INTEGER");
        for (String str2 : new String[]{"created", "lastModified"}) {
            arrayList.add(String.format("CREATE INDEX %s_%s_idx on %s ( %s )", str, str2, str, str2));
        }
        int i = 0;
        for (IndexSpec indexSpec : indexSpecArr) {
            String str3 = str + "_" + i;
            if (TypeGroup.value_indexed_with_json_extract.isMember(indexSpec.f14309b)) {
                str3 = "json_extract(soup, '$." + indexSpec.f14308a + "')";
            }
            if (TypeGroup.value_extracted_to_column.isMember(indexSpec.f14309b)) {
                sb.append(", ").append(str3).append(" ").append(indexSpec.f14309b.getColumnType());
            }
            if (indexSpec.f14309b == Type.full_text) {
                arrayList3.add(str3);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("soupName", strM14806a);
            contentValues.put("path", indexSpec.f14308a);
            contentValues.put("columnName", str3);
            contentValues.put("columnType", indexSpec.f14309b.toString());
            arrayList2.add(contentValues);
            arrayList.add(String.format("CREATE INDEX %s_%s_idx on %s ( %s )", str, "" + i, str, str3));
            indexSpecArr2[i] = new IndexSpec(indexSpec.f14308a, indexSpec.f14309b, str3);
            i++;
        }
        sb.append(")");
        if (arrayList3.size() > 0) {
            sb2.append(String.format("CREATE VIRTUAL TABLE %s%s USING %s(%s)", str, "_fts", this.f14331d, TextUtils.join(",", arrayList3)));
        }
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        sQLiteDatabaseM14785a.execSQL(sb.toString());
        if (arrayList3.size() > 0) {
            sQLiteDatabaseM14785a.execSQL(sb2.toString());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sQLiteDatabaseM14785a.execSQL(((String) it.next()).toString());
        }
        try {
            sQLiteDatabaseM14785a.beginTransaction();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                DBHelper.m14689a(sQLiteDatabaseM14785a).m14694a(sQLiteDatabaseM14785a, "soup_index_map", (ContentValues) it2.next());
            }
            if (m14804e(strM14806a) && (this.f14329b instanceof DBOpenHelper)) {
                ((DBOpenHelper) this.f14329b).m14735b(str);
            }
            sQLiteDatabaseM14785a.setTransactionSuccessful();
            DBHelper.m14689a(sQLiteDatabaseM14785a).m14700a(strM14806a, str);
            DBHelper.m14689a(sQLiteDatabaseM14785a).m14702a(strM14806a, indexSpecArr2);
        } finally {
            sQLiteDatabaseM14785a.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m14798b() {
        synchronized (m14785a()) {
            for (LongOperation longOperation : m14801c()) {
                try {
                    longOperation.mo14679a();
                } catch (Exception e) {
                    SmartStoreLogger.m14825a("SmartStore", "Unexpected error", e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public LongOperation[] m14801c() {
        Cursor cursor;
        Cursor cursorM14696a;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        ArrayList arrayList = new ArrayList();
        synchronized (sQLiteDatabaseM14785a) {
            try {
                cursorM14696a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14696a(sQLiteDatabaseM14785a, "long_operations_status", new String[]{ShareConstants.WEB_DIALOG_PARAM_ID, ShareConstants.MEDIA_TYPE, "details", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS}, null, null, null, new String[0]);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursorM14696a.moveToFirst()) {
                    do {
                        try {
                            arrayList.add(LongOperation.LongOperationType.valueOf(cursorM14696a.getString(1)).getOperation(this, cursorM14696a.getLong(0), new JSONObject(cursorM14696a.getString(2)), cursorM14696a.getString(3)));
                        } catch (Exception e) {
                            SmartStoreLogger.m14825a("SmartStore", "Unexpected error", e);
                        }
                    } while (cursorM14696a.moveToNext());
                }
                m14780b(cursorM14696a);
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorM14696a;
                m14780b(cursor);
                throw th;
            }
        }
        return (LongOperation[]) arrayList.toArray(new LongOperation[0]);
    }

    /* JADX INFO: renamed from: a */
    public void m14796a(String str, String[] strArr, boolean z) {
        Cursor cursor;
        String[] strArr2;
        Cursor cursorM14696a;
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            String strM14714h = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str);
            if (strM14714h == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            Map<String, IndexSpec> mapM14739a = IndexSpec.m14739a(m14797a(str));
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArr) {
                if (mapM14739a.containsKey(str2)) {
                    IndexSpec indexSpec = mapM14739a.get(str2);
                    if (TypeGroup.value_extracted_to_column.isMember(indexSpec.f14309b)) {
                        arrayList.add(indexSpec);
                    }
                } else {
                    SmartStoreLogger.m14824a("SmartStore", "Can not re-index " + str2 + " - it does not have an index");
                }
            }
            IndexSpec[] indexSpecArr = (IndexSpec[]) arrayList.toArray(new IndexSpec[0]);
            if (indexSpecArr.length != 0) {
                boolean zM14741b = IndexSpec.m14741b(indexSpecArr);
                if (z) {
                    sQLiteDatabaseM14785a.beginTransaction();
                }
                try {
                    if (m14804e(str)) {
                        strArr2 = new String[]{ShareConstants.WEB_DIALOG_PARAM_ID};
                    } else {
                        strArr2 = new String[]{ShareConstants.WEB_DIALOG_PARAM_ID, "soup"};
                    }
                    cursorM14696a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14696a(sQLiteDatabaseM14785a, strM14714h, strArr2, null, null, null, new String[0]);
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                }
                try {
                    if (cursorM14696a.moveToFirst()) {
                        do {
                            String string = cursorM14696a.getString(0);
                            try {
                                if (m14804e(str) && (this.f14329b instanceof DBOpenHelper)) {
                                    jSONObject = ((DBOpenHelper) this.f14329b).m14729a(strM14714h, Long.parseLong(string), this.f14330c);
                                } else {
                                    jSONObject = new JSONObject(cursorM14696a.getString(1));
                                }
                                ContentValues contentValues = new ContentValues();
                                m14779a(jSONObject, contentValues, indexSpecArr, TypeGroup.value_extracted_to_column);
                                DBHelper.m14689a(sQLiteDatabaseM14785a).m14692a(sQLiteDatabaseM14785a, strM14714h, contentValues, "id = ?", string + "");
                                if (zM14741b) {
                                    ContentValues contentValues2 = new ContentValues();
                                    m14779a(jSONObject, contentValues2, indexSpecArr, TypeGroup.value_extracted_to_fts_column);
                                    DBHelper.m14689a(sQLiteDatabaseM14785a).m14692a(sQLiteDatabaseM14785a, strM14714h + "_fts", contentValues2, "rowid =?", string + "");
                                }
                            } catch (JSONException e) {
                                SmartStoreLogger.m14827b("SmartStore", "Could not parse soup element " + string, e);
                            }
                        } while (cursorM14696a.moveToNext());
                    }
                    if (z) {
                        sQLiteDatabaseM14785a.setTransactionSuccessful();
                        sQLiteDatabaseM14785a.endTransaction();
                    }
                    m14780b(cursorM14696a);
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorM14696a;
                    if (z) {
                        sQLiteDatabaseM14785a.setTransactionSuccessful();
                        sQLiteDatabaseM14785a.endTransaction();
                    }
                    m14780b(cursor);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public IndexSpec[] m14797a(String str) {
        IndexSpec[] indexSpecArrM14707c;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            if (DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str) == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            indexSpecArrM14707c = DBHelper.m14689a(sQLiteDatabaseM14785a).m14707c(sQLiteDatabaseM14785a, str);
        }
        return indexSpecArrM14707c;
    }

    /* JADX INFO: renamed from: b */
    public void m14799b(String str) {
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            String strM14714h = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str);
            if (strM14714h == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            sQLiteDatabaseM14785a.beginTransaction();
            try {
                DBHelper.m14689a(sQLiteDatabaseM14785a).m14704b(sQLiteDatabaseM14785a, strM14714h, null, new String[0]);
                if (m14783f(str)) {
                    DBHelper.m14689a(sQLiteDatabaseM14785a).m14704b(sQLiteDatabaseM14785a, strM14714h + "_fts", null, new String[0]);
                }
                if (this.f14329b instanceof DBOpenHelper) {
                    ((DBOpenHelper) this.f14329b).m14736c(strM14714h);
                }
            } finally {
                sQLiteDatabaseM14785a.setTransactionSuccessful();
                sQLiteDatabaseM14785a.endTransaction();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m14800c(String str) {
        boolean z;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            z = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str) != null;
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    public List<String> m14803d() {
        ArrayList arrayList;
        Cursor cursorM14696a;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            arrayList = new ArrayList();
            try {
                cursorM14696a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14696a(sQLiteDatabaseM14785a, "soup_attrs", new String[]{"soupName"}, "soupName", null, null, new String[0]);
                try {
                    if (cursorM14696a.moveToFirst()) {
                        do {
                            arrayList.add(cursorM14696a.getString(0));
                        } while (cursorM14696a.moveToNext());
                    }
                    m14780b(cursorM14696a);
                } catch (Throwable th) {
                    th = th;
                    m14780b(cursorM14696a);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursorM14696a = null;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m14786a(QuerySpec querySpec, int i) throws JSONException {
        JSONArray jSONArray;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            QuerySpec.QueryType queryType = querySpec.f14311a;
            Cursor cursorM14695a = null;
            try {
                cursorM14695a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14695a(sQLiteDatabaseM14785a, m14802d(querySpec.f14313c), (querySpec.f14312b * i) + "," + querySpec.f14312b, querySpec.m14762a());
                jSONArray = new JSONArray();
                if (cursorM14695a.moveToFirst()) {
                    do {
                        if (queryType == QuerySpec.QueryType.smart || querySpec.f14317g != null) {
                            jSONArray.put(m14773a(cursorM14695a));
                        } else if (cursorM14695a.getColumnIndex("externalStorage") >= 0) {
                            jSONArray.put(((DBOpenHelper) this.f14329b).m14729a(cursorM14695a.getString(cursorM14695a.getColumnIndex("externalStorage")), Long.valueOf(cursorM14695a.getLong(cursorM14695a.getColumnIndex("_soupEntryId"))).longValue(), this.f14330c));
                        } else {
                            jSONArray.put(new JSONObject(cursorM14695a.getString(0)));
                        }
                    } while (cursorM14695a.moveToNext());
                }
            } finally {
                m14780b(cursorM14695a);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    private JSONArray m14773a(Cursor cursor) throws JSONException {
        int i;
        JSONArray jSONArray = new JSONArray();
        int columnCount = cursor.getColumnCount();
        int i2 = 0;
        while (i2 < columnCount) {
            int type = cursor.getType(i2);
            if (type == 0) {
                jSONArray.put((Object) null);
            } else if (type == 3) {
                String string = cursor.getString(i2);
                if (cursor.getColumnName(i2).equals("externalStorage")) {
                    jSONArray.put(((DBOpenHelper) this.f14329b).m14729a(cursor.getString(i2), Long.valueOf(cursor.getLong(i2 + 1)).longValue(), this.f14330c));
                    i = i2 + 1;
                } else if (cursor.getColumnName(i2).endsWith("soup")) {
                    jSONArray.put(new JSONObject(string));
                    i = i2;
                } else {
                    jSONArray.put(string);
                    i = i2;
                }
                i2 = i;
            } else if (type == 1) {
                jSONArray.put(cursor.getLong(i2));
            } else if (type == 2) {
                jSONArray.put(cursor.getDouble(i2));
            }
            i2++;
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: d */
    public String m14802d(String str) {
        String strM14767a;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            strM14767a = SmartSqlHelper.m14763a(sQLiteDatabaseM14785a).m14767a(sQLiteDatabaseM14785a, str);
        }
        return strM14767a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007b A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:13:0x003c, B:14:0x003f, B:16:0x007b, B:17:0x0084, B:21:0x0098, B:23:0x009e, B:25:0x00ca, B:27:0x00d0, B:29:0x00d6, B:32:0x00e5), top: B:46:0x003c, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject m14792a(java.lang.String r12, org.json.JSONObject r13, boolean r14) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.SmartStore.m14792a(java.lang.String, org.json.JSONObject, boolean):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: f */
    private boolean m14783f(String str) {
        boolean zM14711e;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            zM14711e = DBHelper.m14689a(sQLiteDatabaseM14785a).m14711e(sQLiteDatabaseM14785a, str);
        }
        return zM14711e;
    }

    /* JADX INFO: renamed from: a */
    private void m14779a(JSONObject jSONObject, ContentValues contentValues, IndexSpec[] indexSpecArr, TypeGroup typeGroup) {
        for (IndexSpec indexSpec : indexSpecArr) {
            if (typeGroup.isMember(indexSpec.f14309b)) {
                m14778a(jSONObject, contentValues, indexSpec);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14778a(JSONObject jSONObject, ContentValues contentValues, IndexSpec indexSpec) {
        Long lValueOf;
        Double dValueOf = null;
        Object objM14769a = m14769a(jSONObject, indexSpec.f14308a);
        switch (indexSpec.f14309b) {
            case integer:
                try {
                    lValueOf = Long.valueOf(((Number) objM14769a).longValue());
                } catch (Exception e) {
                    SmartStoreLogger.m14825a("SmartStore", "Unexpected error", e);
                    lValueOf = null;
                }
                contentValues.put(indexSpec.f14310c, lValueOf);
                break;
            case string:
            case full_text:
                contentValues.put(indexSpec.f14310c, objM14769a != null ? objM14769a.toString() : null);
                break;
            case floating:
                try {
                    dValueOf = Double.valueOf(((Number) objM14769a).doubleValue());
                } catch (Exception e2) {
                    SmartStoreLogger.m14825a("SmartStore", "Unexpected error", e2);
                }
                contentValues.put(indexSpec.f14310c, dValueOf);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m14787a(String str, Long... lArr) throws JSONException {
        Cursor cursorM14696a;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            String strM14714h = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str);
            if (strM14714h == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            JSONArray jSONArray = new JSONArray();
            if (m14804e(str) && (this.f14329b instanceof DBOpenHelper)) {
                for (Long l : lArr) {
                    JSONObject jSONObjectM14729a = ((DBOpenHelper) this.f14329b).m14729a(strM14714h, l.longValue(), this.f14330c);
                    if (jSONObjectM14729a != null) {
                        jSONArray.put(jSONObjectM14729a);
                    }
                }
            } else {
                try {
                    cursorM14696a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14696a(sQLiteDatabaseM14785a, strM14714h, new String[]{"soup"}, null, null, m14772a(lArr), (String[]) null);
                } catch (Throwable th) {
                    th = th;
                    cursorM14696a = null;
                }
                try {
                    if (cursorM14696a.moveToFirst()) {
                        do {
                            jSONArray.put(new JSONObject(cursorM14696a.getString(cursorM14696a.getColumnIndex("soup"))));
                        } while (cursorM14696a.moveToNext());
                        m14780b(cursorM14696a);
                    } else {
                        m14780b(cursorM14696a);
                        return jSONArray;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    m14780b(cursorM14696a);
                    throw th;
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m14789a(String str, JSONObject jSONObject, long j, boolean z) throws JSONException {
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            if (z) {
                try {
                    sQLiteDatabaseM14785a.beginTransaction();
                } catch (Throwable th) {
                    if (z) {
                        sQLiteDatabaseM14785a.endTransaction();
                    }
                    throw th;
                }
            }
            String strM14714h = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str);
            if (strM14714h == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            IndexSpec[] indexSpecArrM14707c = DBHelper.m14689a(sQLiteDatabaseM14785a).m14707c(sQLiteDatabaseM14785a, str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("_soupEntryId", j);
            jSONObject.put("_soupLastModifiedDate", jCurrentTimeMillis);
            ContentValues contentValues = new ContentValues();
            contentValues.put("lastModified", Long.valueOf(jCurrentTimeMillis));
            m14779a(jSONObject, contentValues, indexSpecArrM14707c, TypeGroup.value_extracted_to_column);
            if (!m14804e(str)) {
                contentValues.put("soup", jSONObject.toString());
            }
            boolean zM14732a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14692a(sQLiteDatabaseM14785a, strM14714h, contentValues, "id = ?", new StringBuilder().append(j).append("").toString()) == 1;
            if (zM14732a && m14783f(str)) {
                String str2 = strM14714h + "_fts";
                ContentValues contentValues2 = new ContentValues();
                m14779a(jSONObject, contentValues2, indexSpecArrM14707c, TypeGroup.value_extracted_to_fts_column);
                zM14732a = DBHelper.m14689a(sQLiteDatabaseM14785a).m14692a(sQLiteDatabaseM14785a, str2, contentValues2, "rowid =?", new StringBuilder().append(j).append("").toString()) == 1;
            }
            if (zM14732a && m14804e(str) && (this.f14329b instanceof DBOpenHelper)) {
                zM14732a = ((DBOpenHelper) this.f14329b).m14732a(strM14714h, j, jSONObject, this.f14330c);
            }
            if (zM14732a) {
                if (z) {
                    sQLiteDatabaseM14785a.setTransactionSuccessful();
                }
                if (z) {
                    sQLiteDatabaseM14785a.endTransaction();
                }
            } else {
                jSONObject = null;
                if (z) {
                    sQLiteDatabaseM14785a.endTransaction();
                }
            }
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m14790a(String str, JSONObject jSONObject, String str2) throws JSONException {
        JSONObject jSONObjectM14791a;
        synchronized (m14785a()) {
            jSONObjectM14791a = m14791a(str, jSONObject, str2, true);
        }
        return jSONObjectM14791a;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m14788a(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectM14790a;
        synchronized (m14785a()) {
            jSONObjectM14790a = m14790a(str, jSONObject, "_soupEntryId");
        }
        return jSONObjectM14790a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject m14791a(java.lang.String r9, org.json.JSONObject r10, java.lang.String r11, boolean r12) throws org.json.JSONException {
        /*
            r8 = this;
            r0 = -1
            net.sqlcipher.database.SQLiteDatabase r7 = r8.m14785a()
            monitor-enter(r7)
            java.lang.String r2 = "_soupEntryId"
            boolean r2 = r11.equals(r2)     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L2b
            java.lang.String r2 = "_soupEntryId"
            boolean r2 = r10.has(r2)     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L52
            java.lang.String r2 = "_soupEntryId"
            long r4 = r10.getLong(r2)     // Catch: java.lang.Throwable -> L4f
        L1d:
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L49
            r1 = r8
            r2 = r9
            r3 = r10
            r6 = r12
            org.json.JSONObject r0 = r1.m14789a(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4f
        L2a:
            return r0
        L2b:
            java.lang.Object r2 = m14769a(r10, r11)     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = ""
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4f
            long r4 = r8.m14784a(r9, r11, r2)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L49:
            org.json.JSONObject r0 = r8.m14792a(r9, r10, r12)     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4f
            goto L2a
        L4f:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4f
            throw r0
        L52:
            r4 = r0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.SmartStore.m14791a(java.lang.String, org.json.JSONObject, java.lang.String, boolean):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: a */
    public long m14784a(String str, String str2, String str3) {
        net.sqlcipher.Cursor cursor;
        net.sqlcipher.Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            String strM14714h = DBHelper.m14689a(sQLiteDatabaseM14785a).m14714h(sQLiteDatabaseM14785a, str);
            if (strM14714h == null) {
                throw new SmartStoreException("Soup: " + str + " does not exist");
            }
            try {
                cursorQuery = sQLiteDatabaseM14785a.query(strM14714h, new String[]{ShareConstants.WEB_DIALOG_PARAM_ID}, DBHelper.m14689a(sQLiteDatabaseM14785a).m14698a(sQLiteDatabaseM14785a, str, str2) + " = ?", new String[]{str3}, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursorQuery.getCount() > 1) {
                    throw new SmartStoreException(String.format("There are more than one soup elements where %s is %s", str2, str3));
                }
                if (!cursorQuery.moveToFirst()) {
                    m14780b(cursorQuery);
                    return -1L;
                }
                long j = cursorQuery.getLong(0);
                m14780b(cursorQuery);
                return j;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                m14780b(cursor);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private String m14772a(Long[] lArr) {
        return m14771a(ShareConstants.WEB_DIALOG_PARAM_ID, TextUtils.join(",", lArr));
    }

    /* JADX INFO: renamed from: a */
    private String m14771a(String str, String str2) {
        return String.format("%s IN (%s)", str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static String m14770a(long j) {
        return "TABLE_" + j;
    }

    /* JADX INFO: renamed from: b */
    private void m14780b(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m14769a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return (str == null || str.equals("")) ? jSONObject : m14768a(jSONObject, str.split("[.]"), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object m14768a(java.lang.Object r5, java.lang.String[] r6, int r7) {
        /*
            r3 = 0
            int r0 = r6.length
            if (r7 != r0) goto L5
        L4:
            return r5
        L5:
            if (r5 == 0) goto L4d
            r0 = r6[r7]
            boolean r1 = r5 instanceof org.json.JSONObject
            if (r1 == 0) goto L1b
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            java.lang.Object r0 = com.salesforce.androidsdk.util.JSONObjectHelper.m15011a(r5, r0)
            int r1 = r7 + 1
            java.lang.Object r1 = m14768a(r0, r6, r1)
        L19:
            r5 = r1
            goto L4
        L1b:
            boolean r0 = r5 instanceof org.json.JSONArray
            if (r0 == 0) goto L4d
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r0 = 0
            r2 = r0
        L28:
            int r0 = r5.length()
            if (r2 >= r0) goto L42
            java.lang.Object r0 = com.salesforce.androidsdk.util.JSONObjectHelper.m15010a(r5, r2)
            java.lang.Object r4 = m14768a(r0, r6, r7)
            if (r4 == 0) goto L3e
            r0 = r1
            org.json.JSONArray r0 = (org.json.JSONArray) r0
            r0.put(r4)
        L3e:
            int r0 = r2 + 1
            r2 = r0
            goto L28
        L42:
            r0 = r1
            org.json.JSONArray r0 = (org.json.JSONArray) r0
            int r0 = r0.length()
            if (r0 != 0) goto L19
            r1 = r3
            goto L19
        L4d:
            r1 = r3
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.SmartStore.m14768a(java.lang.Object, java.lang.String[], int):java.lang.Object");
    }

    public enum Type {
        string("TEXT"),
        integer("INTEGER"),
        floating("REAL"),
        full_text("TEXT"),
        json1(null);

        private String columnType;

        Type(String str) {
            this.columnType = str;
        }

        public String getColumnType() {
            return this.columnType;
        }
    }

    public static class SmartStoreException extends RuntimeException {
        public SmartStoreException(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m14777a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        synchronized (SmartStore.class) {
            StringBuilder sb = new StringBuilder();
            if (strArr != null && strArr.length > 0) {
                for (String str3 : strArr) {
                    sb.append("ALTER TABLE ").append(str).append(" ADD COLUMN ").append(str3).append(" INTEGER DEFAULT 0;");
                }
                sQLiteDatabase.execSQL(sb.toString());
            }
            if (str != null && str2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ALTER TABLE ").append(str).append(" RENAME TO ").append(str2).append(';');
                sQLiteDatabase.execSQL(sb2.toString());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m14804e(String str) {
        boolean zContains;
        SQLiteDatabase sQLiteDatabaseM14785a = m14785a();
        synchronized (sQLiteDatabaseM14785a) {
            zContains = DBHelper.m14689a(sQLiteDatabaseM14785a).m14712f(sQLiteDatabaseM14785a, str).contains("externalStorage");
        }
        return zContains;
    }
}
