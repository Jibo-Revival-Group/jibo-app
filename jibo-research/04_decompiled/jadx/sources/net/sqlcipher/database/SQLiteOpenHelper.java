package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        if (databaseErrorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
        this.mContext = context;
        this.mName = str;
        this.mFactory = cursorFactory;
        this.mNewVersion = i;
        this.mHook = sQLiteDatabaseHook;
        this.mErrorHandler = databaseErrorHandler;
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                sQLiteDatabaseOpenOrCreateDatabase = this.mDatabase;
            } else {
                if (this.mIsInitializing) {
                    throw new IllegalStateException("getWritableDatabase called recursively");
                }
                if (this.mDatabase != null) {
                    this.mDatabase.lock();
                }
                try {
                    this.mIsInitializing = true;
                    if (this.mName == null) {
                        sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, cArr);
                    } else {
                        String path = this.mContext.getDatabasePath(this.mName).getPath();
                        File file = new File(path);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, cArr, this.mFactory, this.mHook, this.mErrorHandler);
                    }
                    try {
                        int version = sQLiteDatabaseOpenOrCreateDatabase.getVersion();
                        if (version != this.mNewVersion) {
                            sQLiteDatabaseOpenOrCreateDatabase.beginTransaction();
                            try {
                                if (version == 0) {
                                    onCreate(sQLiteDatabaseOpenOrCreateDatabase);
                                } else {
                                    onUpgrade(sQLiteDatabaseOpenOrCreateDatabase, version, this.mNewVersion);
                                }
                                sQLiteDatabaseOpenOrCreateDatabase.setVersion(this.mNewVersion);
                                sQLiteDatabaseOpenOrCreateDatabase.setTransactionSuccessful();
                            } finally {
                                sQLiteDatabaseOpenOrCreateDatabase.endTransaction();
                            }
                        }
                        onOpen(sQLiteDatabaseOpenOrCreateDatabase);
                        this.mIsInitializing = false;
                        if (this.mDatabase != null) {
                            try {
                                this.mDatabase.close();
                            } catch (Exception e) {
                            }
                            this.mDatabase.unlock();
                        }
                        this.mDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                    } catch (Throwable th) {
                        sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                        th = th;
                        this.mIsInitializing = false;
                        if (this.mDatabase != null) {
                            this.mDatabase.unlock();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return sQLiteDatabaseOpenOrCreateDatabase;
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        SQLiteDatabase writableDatabase;
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            writableDatabase = this.mDatabase;
        } else {
            if (this.mIsInitializing) {
                throw new IllegalStateException("getReadableDatabase called recursively");
            }
            try {
                writableDatabase = getWritableDatabase(cArr);
            } catch (SQLiteException e) {
                if (this.mName == null) {
                    throw e;
                }
                Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    this.mIsInitializing = true;
                    String path = this.mContext.getDatabasePath(this.mName).getPath();
                    File file = new File(path);
                    File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        this.mIsInitializing = false;
                        SQLiteDatabase writableDatabase2 = getWritableDatabase(cArr);
                        this.mIsInitializing = true;
                        writableDatabase2.close();
                    }
                    SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(path, cArr, this.mFactory, 1);
                    if (sQLiteDatabaseOpenDatabase.getVersion() != this.mNewVersion) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabaseOpenDatabase.getVersion() + " to " + this.mNewVersion + ": " + path);
                    }
                    onOpen(sQLiteDatabaseOpenDatabase);
                    Log.w(TAG, "Opened " + this.mName + " in read-only mode");
                    this.mDatabase = sQLiteDatabaseOpenDatabase;
                    writableDatabase = this.mDatabase;
                    this.mIsInitializing = false;
                    if (sQLiteDatabaseOpenDatabase != null && sQLiteDatabaseOpenDatabase != this.mDatabase) {
                        sQLiteDatabaseOpenDatabase.close();
                    }
                } catch (Throwable th) {
                    this.mIsInitializing = false;
                    if (0 != 0 && null != this.mDatabase) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
        }
        return writableDatabase;
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }
}
