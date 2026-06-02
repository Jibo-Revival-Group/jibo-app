package net.sqlcipher.database;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, objArr);
        try {
            sQLiteQuery.bindArguments(objArr);
            if (cursorFactory == null) {
                this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            } else {
                this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            }
            this.mQuery = sQLiteQuery;
            sQLiteQuery = null;
            return this.mCursor;
        } finally {
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    @Override // net.sqlcipher.database.SQLiteCursorDriver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public net.sqlcipher.Cursor query(net.sqlcipher.database.SQLiteDatabase.CursorFactory r6, java.lang.String[] r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            net.sqlcipher.database.SQLiteQuery r2 = new net.sqlcipher.database.SQLiteQuery
            net.sqlcipher.database.SQLiteDatabase r0 = r5.mDatabase
            java.lang.String r3 = r5.mSql
            r2.<init>(r0, r3, r1, r7)
            if (r7 != 0) goto L19
            r0 = r1
        Ld:
            if (r1 >= r0) goto L1b
            int r3 = r1 + 1
            r4 = r7[r1]     // Catch: java.lang.Throwable -> L3e
            r2.bindString(r3, r4)     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 + 1
            goto Ld
        L19:
            int r0 = r7.length     // Catch: java.lang.Throwable -> L3e
            goto Ld
        L1b:
            if (r6 != 0) goto L33
            net.sqlcipher.database.SQLiteCursor r0 = new net.sqlcipher.database.SQLiteCursor     // Catch: java.lang.Throwable -> L3e
            net.sqlcipher.database.SQLiteDatabase r1 = r5.mDatabase     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = r5.mEditTable     // Catch: java.lang.Throwable -> L3e
            r0.<init>(r1, r5, r3, r2)     // Catch: java.lang.Throwable -> L3e
            r5.mCursor = r0     // Catch: java.lang.Throwable -> L3e
        L28:
            r5.mQuery = r2     // Catch: java.lang.Throwable -> L3e
            r1 = 0
            net.sqlcipher.Cursor r0 = r5.mCursor     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        L33:
            net.sqlcipher.database.SQLiteDatabase r0 = r5.mDatabase     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r5.mEditTable     // Catch: java.lang.Throwable -> L3e
            net.sqlcipher.Cursor r0 = r6.newCursor(r0, r5, r1, r2)     // Catch: java.lang.Throwable -> L3e
            r5.mCursor = r0     // Catch: java.lang.Throwable -> L3e
            goto L28
        L3e:
            r0 = move-exception
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r0
        L46:
            r0 = move-exception
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDirectCursorDriver.query(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String[]):net.sqlcipher.Cursor");
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorClosed() {
        this.mCursor = null;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void setBindArguments(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            this.mQuery.bindString(i + 1, strArr[i]);
        }
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorRequeried(android.database.Cursor cursor) {
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
