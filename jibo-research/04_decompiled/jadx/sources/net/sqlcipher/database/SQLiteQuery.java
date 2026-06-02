package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

/* JADX INFO: loaded from: classes2.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    private final native int native_column_count();

    private final native String native_column_name(int i);

    private final native int native_fill_window(CursorWindow cursorWindow, int i, int i2, int i3, int i4);

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mBindArgs = strArr;
    }

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[this.mObjectBindArgs != null ? this.mObjectBindArgs.length : 0];
    }

    int fillWindow(CursorWindow cursorWindow, int i, int i2) {
        int iNative_fill_window;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            acquireReference();
            try {
                try {
                    cursorWindow.acquireReference();
                    iNative_fill_window = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), this.mOffsetIndex, i, i2);
                    if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                        Log.d(TAG, "fillWindow(): " + this.mSql);
                    }
                    releaseReference();
                    this.mDatabase.unlock();
                } finally {
                    cursorWindow.releaseReference();
                }
            } catch (IllegalStateException e) {
                iNative_fill_window = 0;
                releaseReference();
                this.mDatabase.unlock();
            } catch (SQLiteDatabaseCorruptException e2) {
                this.mDatabase.onCorruption();
                throw e2;
            }
            return iNative_fill_window;
        } catch (Throwable th) {
            releaseReference();
            this.mDatabase.unlock();
            throw th;
        }
    }

    int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    String columnNameLocked(int i) {
        acquireReference();
        try {
            return native_column_name(i);
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    void requery() {
        if (this.mBindArgs != null) {
            int length = this.mBindArgs.length;
            try {
                if (this.mObjectBindArgs != null) {
                    bindArguments(this.mObjectBindArgs);
                    return;
                }
                for (int i = 0; i < length; i++) {
                    super.bindString(i + 1, this.mBindArgs[i]);
                }
            } catch (SQLiteMisuseException e) {
                StringBuilder sb = new StringBuilder("mSql " + this.mSql);
                for (int i2 = 0; i2 < length; i2++) {
                    sb.append(" ");
                    sb.append(this.mBindArgs[i2]);
                }
                sb.append(" ");
                throw new IllegalStateException(sb.toString(), e);
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindNull(int i) {
        this.mBindArgs[i - 1] = null;
        if (!this.mClosed) {
            super.bindNull(i);
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindLong(int i, long j) {
        this.mBindArgs[i - 1] = Long.toString(j);
        if (!this.mClosed) {
            super.bindLong(i, j);
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindDouble(int i, double d) {
        this.mBindArgs[i - 1] = Double.toString(d);
        if (!this.mClosed) {
            super.bindDouble(i, d);
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram
    public void bindString(int i, String str) {
        this.mBindArgs[i - 1] = str;
        if (!this.mClosed) {
            super.bindString(i, str);
        }
    }

    public void bindArguments(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < objArr.length) {
                    Object obj = objArr[i2];
                    if (obj == null) {
                        bindNull(i2 + 1);
                    } else if (obj instanceof Double) {
                        bindDouble(i2 + 1, ((Double) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bindDouble(i2 + 1, Double.valueOf(((Number) obj).floatValue()).doubleValue());
                    } else if (obj instanceof Long) {
                        bindLong(i2 + 1, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        bindLong(i2 + 1, Long.valueOf(((Number) obj).intValue()).longValue());
                    } else if (obj instanceof Boolean) {
                        bindLong(i2 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
                    } else if (obj instanceof byte[]) {
                        bindBlob(i2 + 1, (byte[]) obj);
                    } else {
                        bindString(i2 + 1, obj.toString());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
