package com.salesforce.android.knowledge.core.internal.p021db;

import android.database.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class DbUtil {
    /* JADX INFO: renamed from: a */
    public static void m13140a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    /* JADX INFO: renamed from: a */
    public static String m13139a(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndex(str));
    }

    /* JADX INFO: renamed from: b */
    public static int m13141b(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndex(str));
    }
}
