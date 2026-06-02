package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzbq;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzcgo extends zzcjl {

    /* JADX INFO: renamed from: a */
    private static final String[] f7115a = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};

    /* JADX INFO: renamed from: b */
    private static final String[] f7116b = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: c */
    private static final String[] f7117c = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;"};

    /* JADX INFO: renamed from: d */
    private static final String[] f7118d = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: e */
    private static final String[] f7119e = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;"};

    /* JADX INFO: renamed from: f */
    private static final String[] f7120f = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: g */
    private final zzcgr f7121g;

    /* JADX INFO: renamed from: h */
    private final zzclk f7122h;

    zzcgo(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7122h = new zzclk(mo7863k());
        this.f7121g = new zzcgr(this, mo7864l(), "google_app_measurement.db");
    }

    /* JADX INFO: renamed from: T */
    private final boolean m7954T() {
        return mo7864l().getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: renamed from: a */
    private final long m7955a(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m7968A().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final Object m7957a(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                mo7872t().m8106y().m8108a("Loaded invalid null value from database");
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                mo7872t().m8106y().m8108a("Loaded invalid blob type value, ignoring it");
                break;
            default:
                mo7872t().m8106y().m8109a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                break;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static Set<String> m7958a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7959a(ContentValues contentValues, String str, Object obj) {
        zzbq.m7375a(str);
        zzbq.m7373a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m7960a(zzchm zzchmVar, SQLiteDatabase sQLiteDatabase) {
        if (zzchmVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzchmVar.m8097A().m8108a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzchmVar.m8097A().m8108a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzchmVar.m8097A().m8108a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzchmVar.m8097A().m8108a("Failed to turn on database write permission for owner");
    }

    /* JADX INFO: renamed from: a */
    static void m7961a(zzchm zzchmVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzchmVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m7963a(zzchmVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            m7962a(zzchmVar, sQLiteDatabase, str, str3, strArr);
        } catch (SQLiteException e) {
            zzchmVar.m8106y().m8109a("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7962a(zzchm zzchmVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) throws SQLiteException {
        if (zzchmVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Set<String> setM7958a = m7958a(sQLiteDatabase, str);
        for (String str3 : str2.split(",")) {
            if (!setM7958a.remove(str3)) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
            }
        }
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i += 2) {
                if (!setM7958a.remove(strArr[i])) {
                    sQLiteDatabase.execSQL(strArr[i + 1]);
                }
            }
        }
        if (setM7958a.isEmpty()) {
            return;
        }
        zzchmVar.m8097A().m8110a("Table has extra columns. table, columns", str, TextUtils.join(", ", setM7958a));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7963a(zzchm zzchmVar, SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursorQuery;
        boolean zMoveToFirst;
        Cursor cursor = null;
        try {
            if (zzchmVar == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzchmVar.m8097A().m8110a("Error querying for table", str, e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    zMoveToFirst = false;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
            }
            return zMoveToFirst;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m7964a(String str, int i, zzcls zzclsVar) {
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        zzbq.m7373a(zzclsVar);
        if (TextUtils.isEmpty(zzclsVar.f7621b)) {
            mo7872t().m8097A().m8111a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzchm.m8093a(str), Integer.valueOf(i), String.valueOf(zzclsVar.f7620a));
            return false;
        }
        try {
            byte[] bArr = new byte[zzclsVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzclsVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzclsVar.f7620a);
            contentValues.put("event_name", zzclsVar.f7621b);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m7968A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo7872t().m8106y().m8109a("Failed to insert event filter (got -1). appId", zzchm.m8093a(str));
                }
                return true;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Error storing event filter. appId", zzchm.m8093a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo7872t().m8106y().m8110a("Configuration loss. Failed to serialize event filter. appId", zzchm.m8093a(str), e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m7965a(String str, int i, zzclv zzclvVar) {
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        zzbq.m7373a(zzclvVar);
        if (TextUtils.isEmpty(zzclvVar.f7637b)) {
            mo7872t().m8097A().m8111a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzchm.m8093a(str), Integer.valueOf(i), String.valueOf(zzclvVar.f7636a));
            return false;
        }
        try {
            byte[] bArr = new byte[zzclvVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzclvVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzclvVar.f7636a);
            contentValues.put("property_name", zzclvVar.f7637b);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m7968A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo7872t().m8106y().m8109a("Failed to insert property filter (got -1). appId", zzchm.m8093a(str));
                return false;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Error storing property filter. appId", zzchm.m8093a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo7872t().m8106y().m8110a("Configuration loss. Failed to serialize property filter. appId", zzchm.m8093a(str), e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m7966a(String str, List<Integer> list) {
        zzbq.m7375a(str);
        m8259Q();
        mo7855c();
        SQLiteDatabase sQLiteDatabaseM7968A = m7968A();
        try {
            long jM7967b = m7967b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, mo7874v().m7943b(str, zzchc.f7167H)));
            if (jM7967b <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            String string = new StringBuilder(String.valueOf(strJoin).length() + 2).append("(").append(strJoin).append(")").toString();
            return sQLiteDatabaseM7968A.delete("audience_filter_values", new StringBuilder(String.valueOf(string).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(string).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Database error querying filters. appId", zzchm.m8093a(str), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private final long m7967b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = m7968A().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: A */
    final SQLiteDatabase m7968A() {
        mo7855c();
        try {
            return this.f7121g.getWritableDatabase();
        } catch (SQLiteException e) {
            mo7872t().m8097A().m8109a("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m7969B() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.m7968A()
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L23 java.lang.Throwable -> L38
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            if (r1 == 0) goto L1d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            if (r2 == 0) goto L1c
            r2.close()
        L1c:
            return r0
        L1d:
            if (r2 == 0) goto L1c
            r2.close()
            goto L1c
        L23:
            r1 = move-exception
            r2 = r0
        L25:
            com.google.android.gms.internal.zzchm r3 = r5.mo7872t()     // Catch: java.lang.Throwable -> L41
            com.google.android.gms.internal.zzcho r3 = r3.m8106y()     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.m8109a(r4, r1)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L1c
            r2.close()
            goto L1c
        L38:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L3b:
            if (r2 == 0) goto L40
            r2.close()
        L40:
            throw r0
        L41:
            r0 = move-exception
            goto L3b
        L43:
            r1 = move-exception
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7969B():java.lang.String");
    }

    /* JADX INFO: renamed from: C */
    public final boolean m7970C() {
        return m7967b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX INFO: renamed from: D */
    final void m7971D() {
        int iDelete;
        mo7855c();
        m8259Q();
        if (m7954T()) {
            long jM8136a = mo7873u().f7261f.m8136a();
            long jMo7497b = mo7863k().mo7497b();
            if (Math.abs(jMo7497b - jM8136a) > zzchc.f7160A.m8041b().longValue()) {
                mo7873u().f7261f.m8137a(jMo7497b);
                mo7855c();
                m8259Q();
                if (!m7954T() || (iDelete = m7968A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo7863k().mo7496a()), String.valueOf(zzcgn.m7938y())})) <= 0) {
                    return;
                }
                mo7872t().m8101E().m8109a("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public final long m7972E() {
        return m7955a("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX INFO: renamed from: F */
    public final long m7973F() {
        return m7955a("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    /* JADX INFO: renamed from: G */
    public final boolean m7974G() {
        return m7967b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    /* JADX INFO: renamed from: H */
    public final boolean m7975H() {
        return m7967b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* JADX INFO: renamed from: I */
    public final long m7976I() {
        long j = -1;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m7968A().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8109a("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
            return j;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final long m7977a(zzcme zzcmeVar) throws IOException {
        long jM8406c;
        mo7855c();
        m8259Q();
        zzbq.m7373a(zzcmeVar);
        zzbq.m7375a(zzcmeVar.f7699o);
        try {
            byte[] bArr = new byte[zzcmeVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzcmeVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            zzclq zzclqVarMo7868p = mo7868p();
            zzbq.m7373a(bArr);
            zzclqVarMo7868p.mo7855c();
            MessageDigest messageDigestM8409g = zzclq.m8409g("MD5");
            if (messageDigestM8409g == null) {
                zzclqVarMo7868p.mo7872t().m8106y().m8108a("Failed to get MD5");
                jM8406c = 0;
            } else {
                jM8406c = zzclq.m8406c(messageDigestM8409g.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcmeVar.f7699o);
            contentValues.put("metadata_fingerprint", Long.valueOf(jM8406c));
            contentValues.put("metadata", bArr);
            try {
                m7968A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return jM8406c;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Error storing raw event metadata. appId", zzchm.m8093a(zzcmeVar.f7699o), e);
                throw e;
            }
        } catch (IOException e2) {
            mo7872t().m8106y().m8110a("Data loss. Failed to serialize event metadata. appId", zzchm.m8093a(zzcmeVar.f7699o), e2);
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzcgp m7978a(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7978a(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.zzcgp");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzcgw m7979a(java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7979a(java.lang.String, java.lang.String):com.google.android.gms.internal.zzcgw");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m7980a(long r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            r7.mo7855c()
            r7.m8259Q()
            android.database.sqlite.SQLiteDatabase r1 = r7.m7968A()     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            r3[r4] = r5     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r1 != 0) goto L34
            com.google.android.gms.internal.zzchm r1 = r7.mo7872t()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            com.google.android.gms.internal.zzcho r1 = r1.m8101E()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.m8108a(r3)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 == 0) goto L33
            r2.close()
        L33:
            return r0
        L34:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 == 0) goto L33
            r2.close()
            goto L33
        L3f:
            r1 = move-exception
            r2 = r0
        L41:
            com.google.android.gms.internal.zzchm r3 = r7.mo7872t()     // Catch: java.lang.Throwable -> L5d
            com.google.android.gms.internal.zzcho r3 = r3.m8106y()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = "Error selecting expired configs"
            r3.m8109a(r4, r1)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L33
            r2.close()
            goto L33
        L54:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L57:
            if (r2 == 0) goto L5c
            r2.close()
        L5c:
            throw r0
        L5d:
            r0 = move-exception
            goto L57
        L5f:
            r1 = move-exception
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7980a(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.zzclp> m7981a(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzbq.m7375a(r12)
            r11.mo7855c()
            r11.m8259Q()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.m7968A()     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r1 = "user_attributes"
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r3 = 1
            java.lang.String r4 = "origin"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r3 = 2
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r3 = 3
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "1000"
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7 android.database.sqlite.SQLiteException -> Lb4
            boolean r0 = r7.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            if (r0 != 0) goto L4b
            if (r7 == 0) goto L49
            r7.close()
        L49:
            r0 = r9
        L4a:
            return r0
        L4b:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            r0 = 1
            java.lang.String r2 = r7.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            if (r2 != 0) goto L59
            java.lang.String r2 = ""
        L59:
            r0 = 2
            long r4 = r7.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            r0 = 3
            java.lang.Object r6 = r11.m7957a(r7, r0)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            if (r6 != 0) goto L83
            com.google.android.gms.internal.zzchm r0 = r11.mo7872t()     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            com.google.android.gms.internal.zzcho r0 = r0.m8106y()     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            java.lang.String r1 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r2 = com.google.android.gms.internal.zzchm.m8093a(r12)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            r0.m8109a(r1, r2)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
        L76:
            boolean r0 = r7.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            if (r0 != 0) goto L4b
            if (r7 == 0) goto L81
            r7.close()
        L81:
            r0 = r9
            goto L4a
        L83:
            com.google.android.gms.internal.zzclp r0 = new com.google.android.gms.internal.zzclp     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r6)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            r9.add(r0)     // Catch: android.database.sqlite.SQLiteException -> L8d java.lang.Throwable -> Lae
            goto L76
        L8d:
            r0 = move-exception
            r1 = r7
        L8f:
            com.google.android.gms.internal.zzchm r2 = r11.mo7872t()     // Catch: java.lang.Throwable -> Lb1
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r3 = "Error querying user properties. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r12)     // Catch: java.lang.Throwable -> Lb1
            r2.m8110a(r3, r4, r0)     // Catch: java.lang.Throwable -> Lb1
            if (r1 == 0) goto La5
            r1.close()
        La5:
            r0 = r10
            goto L4a
        La7:
            r0 = move-exception
        La8:
            if (r10 == 0) goto Lad
            r10.close()
        Lad:
            throw r0
        Lae:
            r0 = move-exception
            r10 = r7
            goto La8
        Lb1:
            r0 = move-exception
            r10 = r1
            goto La8
        Lb4:
            r0 = move-exception
            r1 = r10
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7981a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.zzcme, java.lang.Long>> m7982a(java.lang.String r12, int r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7982a(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        mo7872t().m8106y().m8109a("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.zzclp> m7983a(java.lang.String r12, java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7983a(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0080, code lost:
    
        mo7872t().m8106y().m8109a("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0165  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.zzcgl> m7984a(java.lang.String r24, java.lang.String[] r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7984a(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX INFO: renamed from: a */
    public final void m7985a(zzcgh zzcghVar) {
        zzbq.m7373a(zzcghVar);
        mo7855c();
        m8259Q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcghVar.m7881b());
        contentValues.put("app_instance_id", zzcghVar.m7885c());
        contentValues.put("gmp_app_id", zzcghVar.m7888d());
        contentValues.put("resettable_device_id_hash", zzcghVar.m7891e());
        contentValues.put("last_bundle_index", Long.valueOf(zzcghVar.m7914o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzcghVar.m7897g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzcghVar.m7900h()));
        contentValues.put("app_version", zzcghVar.m7902i());
        contentValues.put("app_store", zzcghVar.m7906k());
        contentValues.put("gmp_version", Long.valueOf(zzcghVar.m7908l()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzcghVar.m7910m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzcghVar.m7913n()));
        contentValues.put("day", Long.valueOf(zzcghVar.m7919s()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzcghVar.m7920t()));
        contentValues.put("daily_events_count", Long.valueOf(zzcghVar.m7921u()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzcghVar.m7922v()));
        contentValues.put("config_fetched_time", Long.valueOf(zzcghVar.m7916p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzcghVar.m7917q()));
        contentValues.put("app_version_int", Long.valueOf(zzcghVar.m7904j()));
        contentValues.put("firebase_instance_id", zzcghVar.m7894f());
        contentValues.put("daily_error_events_count", Long.valueOf(zzcghVar.m7924x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzcghVar.m7923w()));
        contentValues.put("health_monitor_sample", zzcghVar.m7925y());
        contentValues.put("android_id", Long.valueOf(zzcghVar.m7875A()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzcghVar.m7876B()));
        try {
            SQLiteDatabase sQLiteDatabaseM7968A = m7968A();
            if (sQLiteDatabaseM7968A.update("apps", contentValues, "app_id = ?", new String[]{zzcghVar.m7881b()}) == 0 && sQLiteDatabaseM7968A.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo7872t().m8106y().m8109a("Failed to insert/update app (got -1). appId", zzchm.m8093a(zzcghVar.m7881b()));
            }
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Error storing app. appId", zzchm.m8093a(zzcghVar.m7881b()), e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7986a(zzcgw zzcgwVar) {
        Long l = null;
        zzbq.m7373a(zzcgwVar);
        mo7855c();
        m8259Q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcgwVar.f7144a);
        contentValues.put("name", zzcgwVar.f7145b);
        contentValues.put("lifetime_count", Long.valueOf(zzcgwVar.f7146c));
        contentValues.put("current_bundle_count", Long.valueOf(zzcgwVar.f7147d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzcgwVar.f7148e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzcgwVar.f7149f));
        contentValues.put("last_sampled_complex_event_id", zzcgwVar.f7150g);
        contentValues.put("last_sampling_rate", zzcgwVar.f7151h);
        if (zzcgwVar.f7152i != null && zzcgwVar.f7152i.booleanValue()) {
            l = 1L;
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (m7968A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo7872t().m8106y().m8109a("Failed to insert/update event aggregates (got -1). appId", zzchm.m8093a(zzcgwVar.f7144a));
            }
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Error storing event aggregates. appId", zzchm.m8093a(zzcgwVar.f7144a), e);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m7987a(String str, zzclr[] zzclrVarArr) {
        boolean z;
        m8259Q();
        mo7855c();
        zzbq.m7375a(str);
        zzbq.m7373a(zzclrVarArr);
        SQLiteDatabase sQLiteDatabaseM7968A = m7968A();
        sQLiteDatabaseM7968A.beginTransaction();
        try {
            m8259Q();
            mo7855c();
            zzbq.m7375a(str);
            SQLiteDatabase sQLiteDatabaseM7968A2 = m7968A();
            sQLiteDatabaseM7968A2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseM7968A2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzclr zzclrVar : zzclrVarArr) {
                m8259Q();
                mo7855c();
                zzbq.m7375a(str);
                zzbq.m7373a(zzclrVar);
                zzbq.m7373a(zzclrVar.f7618c);
                zzbq.m7373a(zzclrVar.f7617b);
                if (zzclrVar.f7616a == null) {
                    mo7872t().m8097A().m8109a("Audience with no ID. appId", zzchm.m8093a(str));
                } else {
                    int iIntValue = zzclrVar.f7616a.intValue();
                    zzcls[] zzclsVarArr = zzclrVar.f7618c;
                    int length = zzclsVarArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzclv[] zzclvVarArr = zzclrVar.f7617b;
                            int length2 = zzclvVarArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    zzcls[] zzclsVarArr2 = zzclrVar.f7618c;
                                    int length3 = zzclsVarArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            z = true;
                                            break;
                                        } else {
                                            if (!m7964a(str, iIntValue, zzclsVarArr2[i3])) {
                                                z = false;
                                                break;
                                            }
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        zzclv[] zzclvVarArr2 = zzclrVar.f7617b;
                                        int length4 = zzclvVarArr2.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length4) {
                                                break;
                                            }
                                            if (!m7965a(str, iIntValue, zzclvVarArr2[i4])) {
                                                z = false;
                                                break;
                                            }
                                            i4++;
                                        }
                                    }
                                    if (!z) {
                                        m8259Q();
                                        mo7855c();
                                        zzbq.m7375a(str);
                                        SQLiteDatabase sQLiteDatabaseM7968A3 = m7968A();
                                        sQLiteDatabaseM7968A3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iIntValue)});
                                        sQLiteDatabaseM7968A3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iIntValue)});
                                    }
                                } else {
                                    if (zzclvVarArr[i2].f7636a == null) {
                                        mo7872t().m8097A().m8110a("Property filter with no ID. Audience definition ignored. appId, audienceId", zzchm.m8093a(str), zzclrVar.f7616a);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        } else {
                            if (zzclsVarArr[i].f7620a == null) {
                                mo7872t().m8097A().m8110a("Event filter with no ID. Audience definition ignored. appId, audienceId", zzchm.m8093a(str), zzclrVar.f7616a);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzclr zzclrVar2 : zzclrVarArr) {
                arrayList.add(zzclrVar2.f7616a);
            }
            m7966a(str, arrayList);
            sQLiteDatabaseM7968A.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseM7968A.endTransaction();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7988a(List<Long> list) {
        zzbq.m7373a(list);
        mo7855c();
        m8259Q();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(list.get(i2).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int iDelete = m7968A().delete("raw_events", sb.toString(), null);
        if (iDelete != list.size()) {
            mo7872t().m8106y().m8110a("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7989a(zzcgl zzcglVar) {
        zzbq.m7373a(zzcglVar);
        mo7855c();
        m8259Q();
        if (m7997c(zzcglVar.f7102a, zzcglVar.f7104c.f7598a) == null && m7967b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzcglVar.f7102a}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcglVar.f7102a);
        contentValues.put("origin", zzcglVar.f7103b);
        contentValues.put("name", zzcglVar.f7104c.f7598a);
        m7959a(contentValues, "value", zzcglVar.f7104c.m8383a());
        contentValues.put("active", Boolean.valueOf(zzcglVar.f7106e));
        contentValues.put("trigger_event_name", zzcglVar.f7107f);
        contentValues.put("trigger_timeout", Long.valueOf(zzcglVar.f7109h));
        mo7868p();
        contentValues.put("timed_out_event", zzclq.m8400a((Parcelable) zzcglVar.f7108g));
        contentValues.put("creation_timestamp", Long.valueOf(zzcglVar.f7105d));
        mo7868p();
        contentValues.put("triggered_event", zzclq.m8400a((Parcelable) zzcglVar.f7110i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzcglVar.f7104c.f7599b));
        contentValues.put("time_to_live", Long.valueOf(zzcglVar.f7111j));
        mo7868p();
        contentValues.put("expired_event", zzclq.m8400a((Parcelable) zzcglVar.f7112k));
        try {
            if (m7968A().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo7872t().m8106y().m8109a("Failed to insert/update conditional user property (got -1)", zzchm.m8093a(zzcglVar.f7102a));
            }
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Error storing conditional user property", zzchm.m8093a(zzcglVar.f7102a), e);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7990a(zzcgv zzcgvVar, long j, boolean z) {
        mo7855c();
        m8259Q();
        zzbq.m7373a(zzcgvVar);
        zzbq.m7375a(zzcgvVar.f7138a);
        zzcmb zzcmbVar = new zzcmb();
        zzcmbVar.f7666d = Long.valueOf(zzcgvVar.f7141d);
        zzcmbVar.f7663a = new zzcmc[zzcgvVar.f7142e.m8029a()];
        int i = 0;
        for (String str : zzcgvVar.f7142e) {
            zzcmc zzcmcVar = new zzcmc();
            zzcmbVar.f7663a[i] = zzcmcVar;
            zzcmcVar.f7669a = str;
            mo7868p().m8424a(zzcmcVar, zzcgvVar.f7142e.m8030a(str));
            i++;
        }
        try {
            byte[] bArr = new byte[zzcmbVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzcmbVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            mo7872t().m8101E().m8110a("Saving event, name, data size", mo7867o().m8090a(zzcgvVar.f7139b), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcgvVar.f7138a);
            contentValues.put("name", zzcgvVar.f7139b);
            contentValues.put("timestamp", Long.valueOf(zzcgvVar.f7140c));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (m7968A().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                mo7872t().m8106y().m8109a("Failed to insert raw event (got -1). appId", zzchm.m8093a(zzcgvVar.f7138a));
                return false;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Error storing raw event. appId", zzchm.m8093a(zzcgvVar.f7138a), e);
                return false;
            }
        } catch (IOException e2) {
            mo7872t().m8106y().m8110a("Data loss. Failed to serialize event params/data. appId", zzchm.m8093a(zzcgvVar.f7138a), e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7991a(zzclp zzclpVar) {
        zzbq.m7373a(zzclpVar);
        mo7855c();
        m8259Q();
        if (m7997c(zzclpVar.f7606a, zzclpVar.f7608c) == null) {
            if (zzclq.m8394a(zzclpVar.f7608c)) {
                if (m7967b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzclpVar.f7606a}) >= 25) {
                    return false;
                }
            } else if (m7967b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzclpVar.f7606a, zzclpVar.f7607b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzclpVar.f7606a);
        contentValues.put("origin", zzclpVar.f7607b);
        contentValues.put("name", zzclpVar.f7608c);
        contentValues.put("set_timestamp", Long.valueOf(zzclpVar.f7609d));
        m7959a(contentValues, "value", zzclpVar.f7610e);
        try {
            if (m7968A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo7872t().m8106y().m8109a("Failed to insert/update user property (got -1). appId", zzchm.m8093a(zzclpVar.f7606a));
            }
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Error storing user property. appId", zzchm.m8093a(zzclpVar.f7606a), e);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7992a(zzcme zzcmeVar, boolean z) {
        mo7855c();
        m8259Q();
        zzbq.m7373a(zzcmeVar);
        zzbq.m7375a(zzcmeVar.f7699o);
        zzbq.m7373a(zzcmeVar.f7690f);
        m7971D();
        long jMo7496a = mo7863k().mo7496a();
        if (zzcmeVar.f7690f.longValue() < jMo7496a - zzcgn.m7938y() || zzcmeVar.f7690f.longValue() > zzcgn.m7938y() + jMo7496a) {
            mo7872t().m8097A().m8111a("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzchm.m8093a(zzcmeVar.f7699o), Long.valueOf(jMo7496a), zzcmeVar.f7690f);
        }
        try {
            byte[] bArr = new byte[zzcmeVar.m8713f()];
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzcmeVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            byte[] bArrM8429a = mo7868p().m8429a(bArr);
            mo7872t().m8101E().m8109a("Saving bundle, size", Integer.valueOf(bArrM8429a.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcmeVar.f7699o);
            contentValues.put("bundle_end_timestamp", zzcmeVar.f7690f);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArrM8429a);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (m7968A().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo7872t().m8106y().m8109a("Failed to insert bundle (got -1). appId", zzchm.m8093a(zzcmeVar.f7699o));
                return false;
            } catch (SQLiteException e) {
                mo7872t().m8106y().m8110a("Error storing bundle. appId", zzchm.m8093a(zzcmeVar.f7699o), e);
                return false;
            }
        } catch (IOException e2) {
            mo7872t().m8106y().m8110a("Data loss. Failed to serialize bundle. appId", zzchm.m8093a(zzcmeVar.f7699o), e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final zzcgh m7993b(String str) {
        Cursor cursorQuery;
        zzbq.m7375a(str);
        mo7855c();
        m8259Q();
        try {
            cursorQuery = m7968A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    zzcgh zzcghVar = new zzcgh(this.f7441p, str);
                    zzcghVar.m7879a(cursorQuery.getString(0));
                    zzcghVar.m7883b(cursorQuery.getString(1));
                    zzcghVar.m7887c(cursorQuery.getString(2));
                    zzcghVar.m7895f(cursorQuery.getLong(3));
                    zzcghVar.m7878a(cursorQuery.getLong(4));
                    zzcghVar.m7882b(cursorQuery.getLong(5));
                    zzcghVar.m7893e(cursorQuery.getString(6));
                    zzcghVar.m7896f(cursorQuery.getString(7));
                    zzcghVar.m7889d(cursorQuery.getLong(8));
                    zzcghVar.m7892e(cursorQuery.getLong(9));
                    zzcghVar.m7880a(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    zzcghVar.m7903i(cursorQuery.getLong(11));
                    zzcghVar.m7905j(cursorQuery.getLong(12));
                    zzcghVar.m7907k(cursorQuery.getLong(13));
                    zzcghVar.m7909l(cursorQuery.getLong(14));
                    zzcghVar.m7898g(cursorQuery.getLong(15));
                    zzcghVar.m7901h(cursorQuery.getLong(16));
                    zzcghVar.m7886c(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    zzcghVar.m7890d(cursorQuery.getString(18));
                    zzcghVar.m7912n(cursorQuery.getLong(19));
                    zzcghVar.m7911m(cursorQuery.getLong(20));
                    zzcghVar.m7899g(cursorQuery.getString(21));
                    zzcghVar.m7915o(cursorQuery.isNull(22) ? 0L : cursorQuery.getLong(22));
                    zzcghVar.m7884b(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    zzcghVar.m7877a();
                    if (cursorQuery.moveToNext()) {
                        mo7872t().m8106y().m8109a("Got multiple records for app, expected one. appId", zzchm.m8093a(str));
                    }
                    if (cursorQuery == null) {
                        return zzcghVar;
                    }
                    cursorQuery.close();
                    return zzcghVar;
                } catch (SQLiteException e) {
                    e = e;
                    mo7872t().m8106y().m8110a("Error querying app. appId", zzchm.m8093a(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
            }
            th = th;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw th;
    }

    /* JADX INFO: renamed from: b */
    public final List<zzcgl> m7994b(String str, String str2, String str3) {
        zzbq.m7375a(str);
        mo7855c();
        m8259Q();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return m7984a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX INFO: renamed from: b */
    public final void m7995b(String str, String str2) {
        zzbq.m7375a(str);
        zzbq.m7375a(str2);
        mo7855c();
        m8259Q();
        try {
            mo7872t().m8101E().m8109a("Deleted user attribute rows", Integer.valueOf(m7968A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8111a("Error deleting user attribute. appId", zzchm.m8093a(str), mo7867o().m8092c(str2), e);
        }
    }

    /* JADX INFO: renamed from: c */
    public final long m7996c(String str) {
        zzbq.m7375a(str);
        mo7855c();
        m8259Q();
        try {
            return m7968A().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, mo7874v().m7943b(str, zzchc.f7192r))))});
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8110a("Error deleting over the limit events. appId", zzchm.m8093a(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzclp m7997c(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzbq.m7375a(r10)
            com.google.android.gms.common.internal.zzbq.m7375a(r11)
            r9.mo7855c()
            r9.m8259Q()
            android.database.sqlite.SQLiteDatabase r0 = r9.m7968A()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r3 = 2
            java.lang.String r4 = "origin"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r5 = 0
            r4[r5] = r10     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r5 = 1
            r4[r5] = r11     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L99
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            if (r0 != 0) goto L44
            if (r7 == 0) goto L42
            r7.close()
        L42:
            r0 = r8
        L43:
            return r0
        L44:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            r0 = 1
            java.lang.Object r6 = r9.m7957a(r7, r0)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            r0 = 2
            java.lang.String r2 = r7.getString(r0)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            com.google.android.gms.internal.zzclp r0 = new com.google.android.gms.internal.zzclp     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            r1 = r10
            r3 = r11
            r0.<init>(r1, r2, r3, r4, r6)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            boolean r1 = r7.moveToNext()     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            if (r1 == 0) goto L71
            com.google.android.gms.internal.zzchm r1 = r9.mo7872t()     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            com.google.android.gms.internal.zzcho r1 = r1.m8106y()     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.internal.zzchm.m8093a(r10)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
            r1.m8109a(r2, r3)     // Catch: java.lang.Throwable -> La0 android.database.sqlite.SQLiteException -> La6
        L71:
            if (r7 == 0) goto L43
            r7.close()
            goto L43
        L77:
            r0 = move-exception
            r1 = r8
        L79:
            com.google.android.gms.internal.zzchm r2 = r9.mo7872t()     // Catch: java.lang.Throwable -> La3
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r10)     // Catch: java.lang.Throwable -> La3
            com.google.android.gms.internal.zzchk r5 = r9.mo7867o()     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = r5.m8092c(r11)     // Catch: java.lang.Throwable -> La3
            r2.m8111a(r3, r4, r5, r0)     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L97
            r1.close()
        L97:
            r0 = r8
            goto L43
        L99:
            r0 = move-exception
        L9a:
            if (r8 == 0) goto L9f
            r8.close()
        L9f:
            throw r0
        La0:
            r0 = move-exception
            r8 = r7
            goto L9a
        La3:
            r0 = move-exception
            r8 = r1
            goto L9a
        La6:
            r0 = move-exception
            r1 = r7
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7997c(java.lang.String, java.lang.String):com.google.android.gms.internal.zzclp");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x014d  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzcgl m7998d(java.lang.String r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m7998d(java.lang.String, java.lang.String):com.google.android.gms.internal.zzcgl");
    }

    /* JADX INFO: renamed from: d */
    public final byte[] m7999d(String str) throws Throwable {
        Cursor cursorQuery;
        zzbq.m7375a(str);
        mo7855c();
        m8259Q();
        try {
            cursorQuery = m7968A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        mo7872t().m8106y().m8109a("Got multiple records for app config, expected one. appId", zzchm.m8093a(str));
                    }
                    if (cursorQuery == null) {
                        return blob;
                    }
                    cursorQuery.close();
                    return blob;
                } catch (SQLiteException e) {
                    e = e;
                    mo7872t().m8106y().m8110a("Error querying remote config. appId", zzchm.m8093a(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
            }
            th = th;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw th;
    }

    /* JADX INFO: renamed from: e */
    public final int m8000e(String str, String str2) {
        zzbq.m7375a(str);
        zzbq.m7375a(str2);
        mo7855c();
        m8259Q();
        try {
            return m7968A().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8111a("Error deleting conditional property", zzchm.m8093a(str), mo7867o().m8092c(str2), e);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcmf> m8001e(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            r9.m8259Q()
            r9.mo7855c()
            com.google.android.gms.common.internal.zzbq.m7375a(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.m7968A()
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            r3 = 1
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L99 android.database.sqlite.SQLiteException -> La3
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            if (r0 != 0) goto L39
            if (r1 == 0) goto L37
            r1.close()
        L37:
            r0 = r8
        L38:
            return r0
        L39:
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
        L3e:
            r2 = 0
            int r2 = r1.getInt(r2)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r3 = 1
            byte[] r3 = r1.getBlob(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r4 = 0
            int r5 = r3.length     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            com.google.android.gms.internal.zzfjj r3 = com.google.android.gms.internal.zzfjj.m8617a(r3, r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            com.google.android.gms.internal.zzcmf r4 = new com.google.android.gms.internal.zzcmf     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r4.mo8446a(r3)     // Catch: java.io.IOException -> L69 android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r0.put(r2, r4)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
        L5d:
            boolean r2 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            if (r2 != 0) goto L3e
            if (r1 == 0) goto L38
            r1.close()
            goto L38
        L69:
            r3 = move-exception
            com.google.android.gms.internal.zzchm r4 = r9.mo7872t()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            com.google.android.gms.internal.zzcho r4 = r4.m8106y()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.internal.zzchm.m8093a(r10)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            r4.m8111a(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> La1
            goto L5d
        L80:
            r0 = move-exception
        L81:
            com.google.android.gms.internal.zzchm r2 = r9.mo7872t()     // Catch: java.lang.Throwable -> La1
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r10)     // Catch: java.lang.Throwable -> La1
            r2.m8110a(r3, r4, r0)     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L97
            r1.close()
        L97:
            r0 = r8
            goto L38
        L99:
            r0 = move-exception
            r1 = r8
        L9b:
            if (r1 == 0) goto La0
            r1.close()
        La0:
            throw r0
        La1:
            r0 = move-exception
            goto L9b
        La3:
            r0 = move-exception
            r1 = r8
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m8001e(java.lang.String):java.util.Map");
    }

    /* JADX INFO: renamed from: f */
    public final long m8002f(String str) {
        zzbq.m7375a(str);
        return m7955a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcls>> m8003f(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.m8259Q()
            r10.mo7855c()
            com.google.android.gms.common.internal.zzbq.m7375a(r11)
            com.google.android.gms.common.internal.zzbq.m7375a(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.m7968A()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 0
            r4[r5] = r11     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 1
            r4[r5] = r12     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L47
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r1 == 0) goto L46
            r1.close()
        L46:
            return r0
        L47:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2 = 0
            int r3 = r0.length     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzfjj r0 = com.google.android.gms.internal.zzfjj.m8617a(r0, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzcls r2 = new com.google.android.gms.internal.zzcls     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.mo8446a(r0)     // Catch: java.io.IOException -> L87 android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Object r0 = r8.get(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.util.List r0 = (java.util.List) r0     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L77
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r8.put(r3, r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
        L77:
            r0.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
        L7a:
            boolean r0 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L47
            if (r1 == 0) goto L85
            r1.close()
        L85:
            r0 = r8
            goto L46
        L87:
            r0 = move-exception
            com.google.android.gms.internal.zzchm r2 = r10.mo7872t()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r11)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.m8110a(r3, r4, r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            goto L7a
        L9a:
            r0 = move-exception
        L9b:
            com.google.android.gms.internal.zzchm r2 = r10.mo7872t()     // Catch: java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r11)     // Catch: java.lang.Throwable -> Lbb
            r2.m8110a(r3, r4, r0)     // Catch: java.lang.Throwable -> Lbb
            if (r1 == 0) goto Lb1
            r1.close()
        Lb1:
            r0 = r9
            goto L46
        Lb3:
            r0 = move-exception
            r1 = r9
        Lb5:
            if (r1 == 0) goto Lba
            r1.close()
        Lba:
            throw r0
        Lbb:
            r0 = move-exception
            goto Lb5
        Lbd:
            r0 = move-exception
            r1 = r9
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m8003f(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzclv>> m8004g(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.m8259Q()
            r10.mo7855c()
            com.google.android.gms.common.internal.zzbq.m7375a(r11)
            com.google.android.gms.common.internal.zzbq.m7375a(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.m7968A()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 0
            r4[r5] = r11     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 1
            r4[r5] = r12     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lbd
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L47
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r1 == 0) goto L46
            r1.close()
        L46:
            return r0
        L47:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2 = 0
            int r3 = r0.length     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzfjj r0 = com.google.android.gms.internal.zzfjj.m8617a(r0, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzclv r2 = new com.google.android.gms.internal.zzclv     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.mo8446a(r0)     // Catch: java.io.IOException -> L87 android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Object r0 = r8.get(r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.util.List r0 = (java.util.List) r0     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L77
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r8.put(r3, r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
        L77:
            r0.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
        L7a:
            boolean r0 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            if (r0 != 0) goto L47
            if (r1 == 0) goto L85
            r1.close()
        L85:
            r0 = r8
            goto L46
        L87:
            r0 = move-exception
            com.google.android.gms.internal.zzchm r2 = r10.mo7872t()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r11)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            r2.m8110a(r3, r4, r0)     // Catch: android.database.sqlite.SQLiteException -> L9a java.lang.Throwable -> Lbb
            goto L7a
        L9a:
            r0 = move-exception
        L9b:
            com.google.android.gms.internal.zzchm r2 = r10.mo7872t()     // Catch: java.lang.Throwable -> Lbb
            com.google.android.gms.internal.zzcho r2 = r2.m8106y()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzchm.m8093a(r11)     // Catch: java.lang.Throwable -> Lbb
            r2.m8110a(r3, r4, r0)     // Catch: java.lang.Throwable -> Lbb
            if (r1 == 0) goto Lb1
            r1.close()
        Lb1:
            r0 = r9
            goto L46
        Lb3:
            r0 = move-exception
            r1 = r9
        Lb5:
            if (r1 == 0) goto Lba
            r1.close()
        Lba:
            throw r0
        Lbb:
            r0 = move-exception
            goto Lb5
        Lbd:
            r0 = move-exception
            r1 = r9
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m8004g(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b2 A[Catch: all -> 0x00e7, SQLiteException -> 0x00ec, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:3:0x0017, B:5:0x004a, B:7:0x0074, B:11:0x008b, B:13:0x00b2, B:15:0x00c8, B:19:0x00d2), top: B:27:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c8 A[Catch: all -> 0x00e7, SQLiteException -> 0x00ec, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:3:0x0017, B:5:0x004a, B:7:0x0074, B:11:0x008b, B:13:0x00b2, B:15:0x00c8, B:19:0x00d2), top: B:27:0x0017 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e3 -> B:26:0x0089). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final long m8005h(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.m8005h(java.lang.String, java.lang.String):long");
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }

    /* JADX INFO: renamed from: x */
    public final void m8006x() {
        m8259Q();
        m7968A().beginTransaction();
    }

    /* JADX INFO: renamed from: y */
    public final void m8007y() {
        m8259Q();
        m7968A().setTransactionSuccessful();
    }

    /* JADX INFO: renamed from: z */
    public final void m8008z() {
        m8259Q();
        m7968A().endTransaction();
    }
}
