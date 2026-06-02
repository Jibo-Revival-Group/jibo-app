package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.util.MPLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class MPDbAdapter {

    /* JADX INFO: renamed from: a */
    private static final Map<Context, MPDbAdapter> f11944a = new HashMap();

    /* JADX INFO: renamed from: b */
    private static final String f11945b = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* JADX INFO: renamed from: c */
    private static final String f11946c = "CREATE TABLE " + Table.PEOPLE.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* JADX INFO: renamed from: d */
    private static final String f11947d = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.EVENTS.getName() + " (created_at);";

    /* JADX INFO: renamed from: e */
    private static final String f11948e = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.PEOPLE.getName() + " (created_at);";

    /* JADX INFO: renamed from: f */
    private final MPDatabaseHelper f11949f;

    public enum Table {
        EVENTS("events"),
        PEOPLE("people");

        private final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    private static class MPDatabaseHelper extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a */
        private final File f11950a;

        /* JADX INFO: renamed from: b */
        private final MPConfig f11951b;

        MPDatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 5);
            this.f11950a = context.getDatabasePath(str);
            this.f11951b = MPConfig.m11762a(context);
        }

        /* JADX INFO: renamed from: a */
        public void m11807a() {
            close();
            this.f11950a.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MPLog.m12021a("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            sQLiteDatabase.execSQL(MPDbAdapter.f11945b);
            sQLiteDatabase.execSQL(MPDbAdapter.f11946c);
            sQLiteDatabase.execSQL(MPDbAdapter.f11947d);
            sQLiteDatabase.execSQL(MPDbAdapter.f11948e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            MPLog.m12021a("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            if (i2 == 5) {
                m11806a(sQLiteDatabase);
                return;
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.PEOPLE.getName());
            sQLiteDatabase.execSQL(MPDbAdapter.f11945b);
            sQLiteDatabase.execSQL(MPDbAdapter.f11946c);
            sQLiteDatabase.execSQL(MPDbAdapter.f11947d);
            sQLiteDatabase.execSQL(MPDbAdapter.f11948e);
        }

        /* JADX INFO: renamed from: b */
        public boolean m11808b() {
            return !this.f11950a.exists() || Math.max(this.f11950a.getUsableSpace(), (long) this.f11951b.m11768d()) >= this.f11950a.length();
        }

        /* JADX INFO: renamed from: a */
        private void m11806a(SQLiteDatabase sQLiteDatabase) {
            int i;
            String string;
            int i2;
            sQLiteDatabase.execSQL("ALTER TABLE " + Table.EVENTS.getName() + " ADD COLUMN automatic_data INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE " + Table.PEOPLE.getName() + " ADD COLUMN automatic_data INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE " + Table.EVENTS.getName() + " ADD COLUMN token STRING NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE " + Table.PEOPLE.getName() + " ADD COLUMN token STRING NOT NULL DEFAULT ''");
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + Table.EVENTS.getName(), null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    String string2 = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_DATA))).getJSONObject("properties").getString("token");
                    i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("_id"));
                    try {
                        sQLiteDatabase.execSQL("UPDATE " + Table.EVENTS.getName() + " SET token = '" + string2 + "' WHERE _id = " + i2);
                    } catch (JSONException e) {
                        sQLiteDatabase.delete(Table.EVENTS.getName(), "_id = " + i2, null);
                    }
                } catch (JSONException e2) {
                    i2 = 0;
                }
            }
            Cursor cursorRawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM " + Table.PEOPLE.getName(), null);
            while (cursorRawQuery2.moveToNext()) {
                try {
                    string = new JSONObject(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_DATA))).getString("$token");
                    i = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("_id"));
                } catch (JSONException e3) {
                    i = 0;
                }
                try {
                    sQLiteDatabase.execSQL("UPDATE " + Table.PEOPLE.getName() + " SET token = '" + string + "' WHERE _id = " + i);
                } catch (JSONException e4) {
                    sQLiteDatabase.delete(Table.PEOPLE.getName(), "_id = " + i, null);
                }
            }
        }
    }

    public MPDbAdapter(Context context) {
        this(context, "mixpanel");
    }

    public MPDbAdapter(Context context, String str) {
        this.f11949f = new MPDatabaseHelper(context, str);
    }

    /* JADX INFO: renamed from: a */
    public static MPDbAdapter m11791a(Context context) {
        MPDbAdapter mPDbAdapter;
        synchronized (f11944a) {
            Context applicationContext = context.getApplicationContext();
            if (!f11944a.containsKey(applicationContext)) {
                mPDbAdapter = new MPDbAdapter(applicationContext);
                f11944a.put(applicationContext, mPDbAdapter);
            } else {
                mPDbAdapter = f11944a.get(applicationContext);
            }
        }
        return mPDbAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m11797a(org.json.JSONObject r9, java.lang.String r10, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.m11797a(org.json.JSONObject, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, boolean):int");
    }

    /* JADX INFO: renamed from: a */
    public void m11801a(String str, Table table, String str2, boolean z) {
        String name = table.getName();
        try {
            SQLiteDatabase writableDatabase = this.f11949f.getWritableDatabase();
            StringBuffer stringBuffer = new StringBuffer("_id <= " + str + " AND token = '" + str2 + "'");
            if (!z) {
                stringBuffer.append(" AND automatic_data=0");
            }
            writableDatabase.delete(name, stringBuffer.toString(), null);
        } catch (SQLiteException e) {
            MPLog.m12031e("MixpanelAPI.Database", "Could not clean sent Mixpanel records from " + name + ". Re-initializing database.", e);
            this.f11949f.m11807a();
        } finally {
            this.f11949f.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11799a(long j, Table table) {
        String name = table.getName();
        try {
            this.f11949f.getWritableDatabase().delete(name, "created_at <= " + j, null);
        } catch (SQLiteException e) {
            MPLog.m12031e("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + name + ". Re-initializing database.", e);
            this.f11949f.m11807a();
        } finally {
            this.f11949f.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11800a(String str) {
        m11792a(Table.EVENTS, str);
        m11792a(Table.PEOPLE, str);
    }

    /* JADX INFO: renamed from: a */
    private void m11792a(Table table, String str) {
        String name = table.getName();
        try {
            this.f11949f.getWritableDatabase().delete(name, "automatic_data = 1 AND token = '" + str + "'", null);
        } catch (SQLiteException e) {
            MPLog.m12031e("MixpanelAPI.Database", "Could not clean automatic Mixpanel records from " + name + ". Re-initializing database.", e);
            this.f11949f.m11807a();
        } finally {
            this.f11949f.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11798a() {
        this.f11949f.m11807a();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0148: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:50:0x0148 */
    /* JADX INFO: renamed from: a */
    public String[] m11802a(Table table, String str, boolean z) throws Throwable {
        Cursor cursorRawQuery;
        String strValueOf;
        Cursor cursorRawQuery2;
        Cursor cursor;
        String str2;
        String str3;
        StringBuffer stringBuffer;
        Cursor cursor2 = null;
        String name = table.getName();
        SQLiteDatabase readableDatabase = this.f11949f.getReadableDatabase();
        try {
            try {
                StringBuffer stringBuffer2 = new StringBuffer("SELECT * FROM " + name + " WHERE token = '" + str + "' ");
                stringBuffer = new StringBuffer("SELECT COUNT(*) FROM " + name + " WHERE token = '" + str + "' ");
                if (!z) {
                    stringBuffer2.append("AND automatic_data = 0 ");
                    stringBuffer.append(" AND automatic_data = 0");
                }
                stringBuffer2.append("ORDER BY created_at ASC LIMIT 50");
                cursorRawQuery = readableDatabase.rawQuery(stringBuffer2.toString(), null);
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
            }
            try {
                cursorRawQuery2 = readableDatabase.rawQuery(stringBuffer.toString(), null);
                try {
                    cursorRawQuery2.moveToFirst();
                    strValueOf = String.valueOf(cursorRawQuery2.getInt(0));
                    try {
                        JSONArray jSONArray = new JSONArray();
                        String string = null;
                        while (cursorRawQuery.moveToNext()) {
                            if (cursorRawQuery.isLast()) {
                                string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("_id"));
                            }
                            try {
                                jSONArray.put(new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_DATA))));
                            } catch (JSONException e) {
                            }
                        }
                        String string2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
                        this.f11949f.close();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                            str3 = string2;
                            str2 = string;
                        } else {
                            str3 = string2;
                            str2 = string;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        MPLog.m12031e("MixpanelAPI.Database", "Could not pull records for Mixpanel out of database " + name + ". Waiting to send.", e);
                        this.f11949f.close();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                            str2 = null;
                            str3 = null;
                        } else {
                            str2 = null;
                            str3 = null;
                        }
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    strValueOf = null;
                }
            } catch (SQLiteException e4) {
                e = e4;
                strValueOf = null;
                cursorRawQuery2 = null;
            } catch (Throwable th2) {
                th = th2;
                this.f11949f.close();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            strValueOf = null;
            cursorRawQuery2 = null;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        if (str2 == null || str3 == null) {
            return null;
        }
        return new String[]{str2, str3, strValueOf};
    }

    /* JADX INFO: renamed from: b */
    public File m11803b() {
        return this.f11949f.f11950a;
    }

    /* JADX INFO: renamed from: c */
    protected boolean m11804c() {
        return this.f11949f.m11808b();
    }
}
