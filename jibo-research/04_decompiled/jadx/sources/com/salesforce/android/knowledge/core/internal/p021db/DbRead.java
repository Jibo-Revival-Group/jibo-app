package com.salesforce.android.knowledge.core.internal.p021db;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class DbRead<T> implements Job<T> {

    /* JADX INFO: renamed from: a */
    private final SQLiteDatabase f12914a;

    /* JADX INFO: renamed from: b */
    private final List<Operation<T>> f12915b;

    interface Operation<T> {
        /* JADX INFO: renamed from: b */
        T mo13107b(SQLiteDatabase sQLiteDatabase) throws Exception;
    }

    /* JADX INFO: renamed from: a */
    static <T> Builder<T> m13127a(SQLiteDatabase sQLiteDatabase, Class<T> cls) {
        return new Builder<>(sQLiteDatabase);
    }

    DbRead(Builder<T> builder) {
        this.f12914a = builder.f12916a;
        this.f12915b = new LinkedList(builder.f12917b);
    }

    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<T> resultReceiver) {
        T tMo13107b = null;
        try {
            synchronized (this.f12914a) {
                Iterator<Operation<T>> it = this.f12915b.iterator();
                while (it.hasNext()) {
                    tMo13107b = it.next().mo13107b(this.f12914a);
                }
            }
            if (tMo13107b != null) {
                resultReceiver.mo12614b(tMo13107b);
            }
            resultReceiver.mo12613b();
        } catch (Throwable th) {
            resultReceiver.mo12615b(th);
        }
    }

    static class Builder<T> {

        /* JADX INFO: renamed from: a */
        final SQLiteDatabase f12916a;

        /* JADX INFO: renamed from: b */
        final List<Operation<T>> f12917b = new LinkedList();

        Builder(SQLiteDatabase sQLiteDatabase) {
            this.f12916a = sQLiteDatabase;
        }

        /* JADX INFO: renamed from: a */
        Builder<T> m13128a(Operation<T> operation) {
            this.f12917b.add(operation);
            return this;
        }

        /* JADX INFO: renamed from: a */
        DbRead<T> m13129a() {
            return new DbRead<>(this);
        }
    }
}
