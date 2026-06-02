package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.exceptions.KnowledgeOfflineException;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public abstract class KnowledgeFetchSaveOp<S extends FetchSaveRequest, T> extends FetchSaveOp<S, T> {

    /* JADX INFO: renamed from: b */
    final DbService f13000b;

    /* JADX INFO: renamed from: c */
    final HttpService f13001c;

    /* JADX INFO: renamed from: a */
    protected abstract Async<T> mo13258a(DbService dbService, S s);

    /* JADX INFO: renamed from: a */
    protected abstract Async<Void> mo13259a(DbService dbService, S s, T t);

    /* JADX INFO: renamed from: a */
    protected abstract Async<T> mo13261a(HttpService httpService, S s);

    /* JADX INFO: renamed from: b */
    protected abstract String mo13262b();

    public KnowledgeFetchSaveOp(S s, DbService dbService, HttpService httpService) {
        super(s);
        this.f13000b = dbService;
        this.f13001c = httpService;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected Async<T> mo12511a(S s) {
        return mo13258a(this.f13000b, s);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: b */
    protected Async<T> mo12513b(S s) {
        return mo13261a(this.f13001c, s);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected Async<Void> mo12512a(S s, T t) {
        return mo13259a(this.f13000b, s, t);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: a */
    protected OfflineException mo12507a() {
        return new KnowledgeOfflineException(mo13262b());
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp
    /* JADX INFO: renamed from: c */
    protected com.salesforce.android.service.common.fetchsave.internal.http.HttpService mo12515c() {
        return this.f13001c;
    }
}
