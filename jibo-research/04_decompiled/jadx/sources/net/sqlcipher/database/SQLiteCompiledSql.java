package net.sqlcipher.database;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    SQLiteDatabase mDatabase;
    private String mSqlStmt;
    private Throwable mStackTrace;
    long nHandle;
    long nStatement = 0;
    private boolean mInUse = false;

    private final native void native_compile(String str);

    private final native void native_finalize();

    SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.mSqlStmt = null;
        this.mStackTrace = null;
        if (!sQLiteDatabase.isOpen()) {
            throw new IllegalStateException("database " + sQLiteDatabase.getPath() + " already closed");
        }
        this.mDatabase = sQLiteDatabase;
        this.mSqlStmt = str;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.nHandle = sQLiteDatabase.mNativeHandle;
        compile(str, true);
    }

    private void compile(String str, boolean z) {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        if (z) {
            this.mDatabase.lock();
            try {
                native_compile(str);
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    void releaseSqlStatement() {
        if (this.nStatement != 0) {
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "closed and deallocated DbObj (id#" + this.nStatement + ")");
            }
            try {
                this.mDatabase.lock();
                native_finalize();
                this.nStatement = 0L;
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    synchronized boolean acquire() {
        boolean z = true;
        synchronized (this) {
            if (this.mInUse) {
                z = false;
            } else {
                this.mInUse = true;
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    Log.v(TAG, "Acquired DbObj (id#" + this.nStatement + ") from DB cache");
                }
            }
        }
        return z;
    }

    synchronized void release() {
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            Log.v(TAG, "Released DbObj (id#" + this.nStatement + ") back to DB cache");
        }
        this.mInUse = false;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.nStatement != 0) {
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    Log.v(TAG, "** warning ** Finalized DbObj (id#" + this.nStatement + ")");
                }
                int length = this.mSqlStmt.length();
                Log.w(TAG, "Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: " + this.mSqlStmt.substring(0, length <= 100 ? length : 100), this.mStackTrace);
                releaseSqlStatement();
            }
        } finally {
            super.finalize();
        }
    }
}
