package net.sqlcipher.database;

/* JADX INFO: loaded from: classes2.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
