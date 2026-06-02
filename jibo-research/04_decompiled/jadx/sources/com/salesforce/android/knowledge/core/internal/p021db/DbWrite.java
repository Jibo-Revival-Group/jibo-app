package com.salesforce.android.knowledge.core.internal.p021db;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class DbWrite implements Job<Void> {

    /* JADX INFO: renamed from: a */
    private final List<Operation> f12924a;

    /* JADX INFO: renamed from: b */
    private final SQLiteDatabase f12925b;

    interface Operation {
        /* JADX INFO: renamed from: a */
        void mo13091a(SQLiteDatabase sQLiteDatabase);
    }

    /* JADX INFO: renamed from: a */
    static Builder m13142a(SQLiteDatabase sQLiteDatabase) {
        return new Builder(sQLiteDatabase);
    }

    DbWrite(Builder builder) {
        this.f12924a = new LinkedList(builder.f12926a);
        this.f12925b = builder.f12927b;
    }

    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<Void> resultReceiver) {
        try {
            for (Operation operation : this.f12924a) {
                synchronized (this.f12925b) {
                    operation.mo13091a(this.f12925b);
                }
            }
            resultReceiver.mo12613b();
        } catch (Throwable th) {
            resultReceiver.mo12615b(th);
        }
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        final List<Operation> f12926a = new LinkedList();

        /* JADX INFO: renamed from: b */
        final SQLiteDatabase f12927b;

        Builder(SQLiteDatabase sQLiteDatabase) {
            this.f12927b = sQLiteDatabase;
        }

        /* JADX INFO: renamed from: a */
        Builder m13143a(Operation operation) {
            this.f12926a.add(operation);
            return this;
        }

        /* JADX INFO: renamed from: a */
        DbWrite m13144a() {
            return new DbWrite(this);
        }
    }
}
