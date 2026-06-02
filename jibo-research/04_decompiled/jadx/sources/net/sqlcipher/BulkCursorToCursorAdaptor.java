package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import net.sqlcipher.AbstractCursor;

/* JADX INFO: loaded from: classes2.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    public void set(IBulkCursor iBulkCursor) {
        this.mBulkCursor = iBulkCursor;
        try {
            this.mCount = this.mBulkCursor.count();
            this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
            this.mColumns = this.mBulkCursor.getColumnNames();
            this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
        } catch (RemoteException e) {
            Log.e(TAG, "Setup failed because the remote process is dead");
        }
    }

    public void set(IBulkCursor iBulkCursor, int i, int i2) {
        this.mBulkCursor = iBulkCursor;
        this.mColumns = null;
        this.mCount = i;
        this.mRowIdColumnIndex = i2;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    public synchronized IContentObserver getObserver() {
        if (this.mObserverBridge == null) {
            this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
        }
        return null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mCount;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        try {
            if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                this.mWindow = this.mBulkCursor.getWindow(i2);
            } else if (this.mWantsAllOnMoveCalls) {
                this.mBulkCursor.onMove(i2);
            }
            return this.mWindow != null;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to get window because the remote process is dead");
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        try {
            this.mBulkCursor.deactivate();
        } catch (RemoteException e) {
            Log.w(TAG, "Remote process exception when deactivating");
        }
        this.mWindow = null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        try {
            this.mBulkCursor.close();
        } catch (RemoteException e) {
            Log.w(TAG, "Remote process exception when closing");
        }
        this.mWindow = null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        boolean z = false;
        try {
            int i = this.mCount;
            this.mCount = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));
            if (this.mCount != -1) {
                this.mPos = -1;
                this.mWindow = null;
                super.requery();
                z = true;
            } else {
                deactivate();
            }
        } catch (Exception e) {
            Log.e(TAG, "Unable to requery because the remote process exception " + e.getMessage());
            deactivate();
        }
        return z;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        try {
            boolean zDeleteRow = this.mBulkCursor.deleteRow(this.mPos);
            if (zDeleteRow) {
                this.mWindow = null;
                this.mCount = this.mBulkCursor.count();
                if (this.mPos < this.mCount) {
                    int i = this.mPos;
                    this.mPos = -1;
                    moveToPosition(i);
                } else {
                    this.mPos = this.mCount;
                }
                onChange(true);
                return zDeleteRow;
            }
            return zDeleteRow;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to delete row because the remote process is dead");
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.mColumns == null) {
            try {
                this.mColumns = this.mBulkCursor.getColumnNames();
            } catch (RemoteException e) {
                Log.e(TAG, "Unable to fetch column names because the remote process is dead");
                return null;
            }
        }
        return this.mColumns;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: all -> 0x0024, DONT_GENERATE, TryCatch #1 {, blocks: (B:9:0x0015, B:10:0x001a, B:12:0x0022, B:17:0x0027, B:19:0x0031, B:20:0x003a, B:23:0x003e, B:24:0x0045), top: B:28:0x0015, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // net.sqlcipher.AbstractCursor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean commitUpdates(java.util.Map<? extends java.lang.Long, ? extends java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r5 = this;
            r4 = 1
            r0 = 0
            boolean r1 = r5.supportsUpdates()
            if (r1 != 0) goto L10
            java.lang.String r1 = "BulkCursor"
            java.lang.String r2 = "commitUpdates not supported on this cursor, did you include the _id column?"
            android.util.Log.e(r1, r2)
        Lf:
            return r0
        L10:
            java.util.HashMap<java.lang.Long, java.util.Map<java.lang.String, java.lang.Object>> r2 = r5.mUpdatedRows
            monitor-enter(r2)
            if (r6 == 0) goto L1a
            java.util.HashMap<java.lang.Long, java.util.Map<java.lang.String, java.lang.Object>> r1 = r5.mUpdatedRows     // Catch: java.lang.Throwable -> L24
            r1.putAll(r6)     // Catch: java.lang.Throwable -> L24
        L1a:
            java.util.HashMap<java.lang.Long, java.util.Map<java.lang.String, java.lang.Object>> r1 = r5.mUpdatedRows     // Catch: java.lang.Throwable -> L24
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L24
            if (r1 > 0) goto L27
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            goto Lf
        L24:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            throw r0
        L27:
            net.sqlcipher.IBulkCursor r1 = r5.mBulkCursor     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
            java.util.HashMap<java.lang.Long, java.util.Map<java.lang.String, java.lang.Object>> r3 = r5.mUpdatedRows     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
            boolean r1 = r1.updateRows(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
            if (r1 != r4) goto L3a
            java.util.HashMap<java.lang.Long, java.util.Map<java.lang.String, java.lang.Object>> r3 = r5.mUpdatedRows     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
            r3.clear()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
            r3 = 1
            r5.onChange(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L3d
        L3a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            r0 = r1
            goto Lf
        L3d:
            r1 = move-exception
            java.lang.String r1 = "BulkCursor"
            java.lang.String r3 = "Unable to commit updates because the remote process is dead"
            android.util.Log.e(r1, r3)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.BulkCursorToCursorAdaptor.commitUpdates(java.util.Map):boolean");
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        try {
            return this.mBulkCursor.getExtras();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle respond(Bundle bundle) {
        try {
            return this.mBulkCursor.respond(bundle);
        } catch (RemoteException e) {
            Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            return Bundle.EMPTY;
        }
    }

    @Override // net.sqlcipher.AbstractWindowedCursor, net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
