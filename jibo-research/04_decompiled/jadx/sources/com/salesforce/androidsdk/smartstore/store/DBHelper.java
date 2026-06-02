package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDoneException;
import net.sqlcipher.database.SQLiteStatement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DBHelper {

    /* JADX INFO: renamed from: a */
    private static Map<SQLiteDatabase, DBHelper> f14293a;

    /* JADX INFO: renamed from: b */
    private Map<String, String> f14294b = new HashMap();

    /* JADX INFO: renamed from: c */
    private Map<String, IndexSpec[]> f14295c = new HashMap();

    /* JADX INFO: renamed from: d */
    private Map<String, Boolean> f14296d = new HashMap();

    /* JADX INFO: renamed from: e */
    private Map<String, List<String>> f14297e = new HashMap();

    /* JADX INFO: renamed from: f */
    private Map<String, SQLiteStatement> f14298f = new HashMap();

    /* JADX INFO: renamed from: g */
    private Map<String, DatabaseUtils.InsertHelper> f14299g = new HashMap();

    /* JADX INFO: renamed from: h */
    private Map<String, SQLiteStatement> f14300h = new HashMap();

    /* JADX INFO: renamed from: i */
    private boolean f14301i;

    /* JADX INFO: renamed from: j */
    private JSONObject f14302j;

    /* JADX INFO: renamed from: a */
    public static synchronized DBHelper m14689a(SQLiteDatabase sQLiteDatabase) {
        DBHelper dBHelper;
        if (f14293a == null) {
            f14293a = new HashMap();
        }
        dBHelper = f14293a.get(sQLiteDatabase);
        if (dBHelper == null) {
            dBHelper = new DBHelper();
            f14293a.put(sQLiteDatabase, dBHelper);
        }
        return dBHelper;
    }

    /* JADX INFO: renamed from: a */
    public void m14700a(String str, String str2) {
        this.f14294b.put(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public String m14697a(String str) {
        return this.f14294b.get(str);
    }

    /* JADX INFO: renamed from: a */
    public void m14702a(String str, IndexSpec[] indexSpecArr) {
        this.f14295c.put(str, (IndexSpec[]) indexSpecArr.clone());
        this.f14296d.put(str, Boolean.valueOf(IndexSpec.m14741b(indexSpecArr)));
    }

    /* JADX INFO: renamed from: b */
    public IndexSpec[] m14705b(String str) {
        return this.f14295c.get(str);
    }

    /* JADX INFO: renamed from: a */
    public void m14701a(String str, List<String> list) {
        this.f14297e.put(str, list);
    }

    /* JADX INFO: renamed from: c */
    public List<String> m14706c(String str) {
        return this.f14297e.get(str);
    }

    /* JADX INFO: renamed from: d */
    public Boolean m14708d(String str) {
        return this.f14296d.get(str);
    }

    /* JADX INFO: renamed from: e */
    public void m14710e(String str) {
        String str2 = this.f14294b.get(str);
        if (str2 != null) {
            DatabaseUtils.InsertHelper insertHelperRemove = this.f14299g.remove(str2);
            if (insertHelperRemove != null) {
                insertHelperRemove.close();
            }
            SQLiteStatement sQLiteStatementRemove = this.f14298f.remove(str2);
            if (sQLiteStatementRemove != null) {
                sQLiteStatementRemove.close();
            }
            m14691f(str2);
        }
        this.f14294b.remove(str);
        this.f14295c.remove(str);
        this.f14296d.remove(str);
        this.f14297e.remove(str);
    }

    /* JADX INFO: renamed from: f */
    private void m14691f(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SQLiteStatement> entry : this.f14300h.entrySet()) {
            String key = entry.getKey();
            if (key.contains(str)) {
                SQLiteStatement value = entry.getValue();
                if (value != null) {
                    value.close();
                }
                arrayList.add(key);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f14300h.remove((String) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public long m14693a(SQLiteDatabase sQLiteDatabase, String str) {
        SQLiteStatement sQLiteStatementCompileStatement = this.f14298f.get(str);
        if (sQLiteStatementCompileStatement == null) {
            sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("SELECT seq FROM SQLITE_SEQUENCE WHERE name = ?");
            sQLiteStatementCompileStatement.bindString(1, str);
            this.f14298f.put(str, sQLiteStatementCompileStatement);
        }
        try {
            return sQLiteStatementCompileStatement.simpleQueryForLong() + 1;
        } catch (SQLiteDoneException e) {
            return 1L;
        }
    }

    /* JADX INFO: renamed from: b */
    public DatabaseUtils.InsertHelper m14703b(SQLiteDatabase sQLiteDatabase, String str) {
        DatabaseUtils.InsertHelper insertHelper = this.f14299g.get(str);
        if (insertHelper == null) {
            DatabaseUtils.InsertHelper insertHelper2 = new DatabaseUtils.InsertHelper(sQLiteDatabase, str);
            this.f14299g.put(str, insertHelper2);
            return insertHelper2;
        }
        return insertHelper;
    }

    /* JADX INFO: renamed from: a */
    public Cursor m14695a(SQLiteDatabase sQLiteDatabase, String str, String str2, String... strArr) {
        String str3 = String.format("SELECT * FROM (%s) LIMIT %s", str, str2);
        if (this.f14301i) {
            m14690a(sQLiteDatabase, str3, strArr);
        }
        return sQLiteDatabase.rawQuery(str3, strArr);
    }

    /* JADX INFO: renamed from: a */
    private void m14690a(SQLiteDatabase sQLiteDatabase, String str, String... strArr) {
        JSONObject jSONObject = new JSONObject();
        net.sqlcipher.Cursor cursorRawQuery = null;
        try {
            jSONObject.put("sql", str);
            if (strArr != null && strArr.length > 0) {
                jSONObject.put("args", new JSONArray((Collection) Arrays.asList(strArr)));
            }
            JSONArray jSONArray = new JSONArray();
            cursorRawQuery = sQLiteDatabase.rawQuery("EXPLAIN QUERY PLAN " + str, strArr);
            while (cursorRawQuery.moveToNext()) {
                JSONObject jSONObject2 = new JSONObject();
                new StringBuilder();
                for (int i = 0; i < cursorRawQuery.getColumnCount(); i++) {
                    jSONObject2.put(cursorRawQuery.getColumnName(i), cursorRawQuery.getString(i));
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("rows", jSONArray);
            SmartStoreLogger.m14828c("EXPLAIN", jSONObject.toString(2));
        } catch (JSONException e) {
            SmartStoreLogger.m14829c("EXPLAIN", "Exception", e);
        } finally {
            m14699a(cursorRawQuery);
        }
        this.f14302j = jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public Cursor m14696a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String str3, String str4, String... strArr2) {
        return sQLiteDatabase.query(str, strArr, str4, strArr2, null, null, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public long m14694a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        return m14703b(sQLiteDatabase, str).insert(contentValues);
    }

    /* JADX INFO: renamed from: a */
    public int m14692a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String... strArr) {
        return sQLiteDatabase.update(str, contentValues, str2, strArr);
    }

    /* JADX INFO: renamed from: b */
    public void m14704b(SQLiteDatabase sQLiteDatabase, String str, String str2, String... strArr) {
        sQLiteDatabase.delete(str, str2, strArr);
    }

    /* JADX INFO: renamed from: a */
    public String m14698a(SQLiteDatabase sQLiteDatabase, String str, String str2) throws Throwable {
        for (IndexSpec indexSpec : m14707c(sQLiteDatabase, str)) {
            if (indexSpec.f14308a.equals(str2)) {
                return indexSpec.f14310c;
            }
        }
        throw new SmartStore.SmartStoreException(String.format("%s does not have an index on %s", str, str2));
    }

    /* JADX INFO: renamed from: c */
    public IndexSpec[] m14707c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        IndexSpec[] indexSpecArrM14705b = m14705b(str);
        if (indexSpecArrM14705b == null) {
            IndexSpec[] indexSpecArrM14709d = m14709d(sQLiteDatabase, str);
            m14702a(str, indexSpecArrM14709d);
            return indexSpecArrM14709d;
        }
        return indexSpecArrM14705b;
    }

    /* JADX INFO: renamed from: d */
    protected IndexSpec[] m14709d(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursorM14696a;
        try {
            cursorM14696a = m14696a(sQLiteDatabase, "soup_index_map", new String[]{"path", "columnName", "columnType"}, null, null, "soupName = ?", str);
        } catch (Throwable th) {
            th = th;
            cursorM14696a = null;
        }
        try {
            if (!cursorM14696a.moveToFirst()) {
                throw new SmartStore.SmartStoreException(String.format("%s does not have any indices", str));
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(new IndexSpec(cursorM14696a.getString(cursorM14696a.getColumnIndex("path")), SmartStore.Type.valueOf(cursorM14696a.getString(cursorM14696a.getColumnIndex("columnType"))), cursorM14696a.getString(cursorM14696a.getColumnIndex("columnName"))));
            } while (cursorM14696a.moveToNext());
            IndexSpec[] indexSpecArr = (IndexSpec[]) arrayList.toArray(new IndexSpec[0]);
            m14699a(cursorM14696a);
            return indexSpecArr;
        } catch (Throwable th2) {
            th = th2;
            m14699a(cursorM14696a);
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m14711e(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        m14707c(sQLiteDatabase, str);
        return m14708d(str).booleanValue();
    }

    /* JADX INFO: renamed from: f */
    public List<String> m14712f(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        List<String> listM14706c = m14706c(str);
        if (listM14706c == null) {
            List<String> listM14713g = m14713g(sQLiteDatabase, str);
            m14701a(str, listM14713g);
            return listM14713g;
        }
        return listM14706c;
    }

    /* JADX INFO: renamed from: g */
    protected List<String> m14713g(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursorM14696a;
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursorM14696a = m14696a(sQLiteDatabase, "soup_attrs", SoupSpec.f14337a, null, null, "soupName = ?", str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorM14696a.moveToFirst()) {
                for (String str2 : SoupSpec.f14337a) {
                    if (cursorM14696a.getInt(cursorM14696a.getColumnIndex(str2)) > 0) {
                        arrayList.add(str2);
                    }
                }
                m14699a(cursorM14696a);
                return arrayList;
            }
            m14699a(cursorM14696a);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorM14696a;
            m14699a(cursor);
            throw th;
        }
    }

    /* JADX INFO: renamed from: h */
    public String m14714h(SQLiteDatabase sQLiteDatabase, String str) {
        String strM14697a = m14697a(str);
        if (strM14697a == null && (strM14697a = m14715i(sQLiteDatabase, str)) != null) {
            m14700a(str, strM14697a);
        }
        return strM14697a;
    }

    /* JADX INFO: renamed from: i */
    protected String m14715i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursorM14696a;
        Cursor cursor = null;
        try {
            cursorM14696a = m14696a(sQLiteDatabase, "soup_attrs", new String[]{ShareConstants.WEB_DIALOG_PARAM_ID}, null, null, "soupName = ?", str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!cursorM14696a.moveToFirst()) {
                m14699a(cursorM14696a);
                return null;
            }
            String strM14770a = SmartStore.m14770a(cursorM14696a.getLong(cursorM14696a.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_ID)));
            m14699a(cursorM14696a);
            return strM14770a;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorM14696a;
            m14699a(cursor);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m14699a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }
}
