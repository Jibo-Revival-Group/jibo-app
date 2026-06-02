package com.jibo.p018db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private static DatabaseHelper f9700a = null;

    private DatabaseHelper(Context context) {
        super(context, m10085a(), (SQLiteDatabase.CursorFactory) null, 22);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized DatabaseHelper m10084a(Context context) {
        if (f9700a == null) {
            f9700a = new DatabaseHelper(context);
        }
        return f9700a;
    }

    /* JADX INFO: renamed from: a */
    private static String m10085a() {
        return "jiboapp.db";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS entity");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS jot");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_entry");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media");
        sQLiteDatabase.execSQL("CREATE TABLE entity (_id TEXT NOT NULL, name TEXT NOT NULL DEFAULT '', type INTEGER NOT NULL DEFAULT 0, retrieved INTEGER NOT NULL DEFAULT -1, modified  INTEGER NOT NULL DEFAULT -1, data TEXT NULL DEFAULT NULL );");
        sQLiteDatabase.execSQL("CREATE TABLE jot (_id TEXT NOT NULL PRIMARY KEY, loopId  TEXT NOT NULL DEFAULT '', content  TEXT NULL DEFAULT NULL, sender  TEXT NULL DEFAULT NULL, parts TEXT NULL DEFAULT NULL,hasPhotoVideo INTEGER DEFAULT 0, tags TEXT NULL DEFAULT NULL,created INTEGER DEFAULT -1, is_read INTEGER DEFAULT 0  ); CREATE INDEX jot_index_created on jot(created);CREATE INDEX jot_index_loop_created on jot(created,loopId);");
        sQLiteDatabase.execSQL("CREATE TABLE log_entry (_id INTEGER PRIMARY KEY,data TEXT NULL DEFAULT NULL );");
        sQLiteDatabase.execSQL("CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media");
            sQLiteDatabase.execSQL("CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);");
        } else {
            onCreate(sQLiteDatabase);
        }
    }
}
