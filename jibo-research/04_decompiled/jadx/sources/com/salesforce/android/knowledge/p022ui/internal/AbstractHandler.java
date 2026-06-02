package com.salesforce.android.knowledge.p022ui.internal;

import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {

    /* JADX INFO: renamed from: a */
    private Async<T> f13097a;

    /* JADX INFO: renamed from: c */
    protected abstract Async<T> mo13405c();

    /* JADX INFO: renamed from: a */
    public void m13403a() {
        this.f13097a = mo13405c();
        this.f13097a.mo14077b(this);
    }

    /* JADX INFO: renamed from: b */
    public void m13404b() {
        if (this.f13097a != null) {
            this.f13097a.mo14079c(this);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m13406d() {
        return this.f13097a != null && this.f13097a.mo14081d();
    }

    /* JADX INFO: renamed from: e */
    public boolean m13407e() {
        return this.f13097a != null && this.f13097a.mo14082e();
    }

    /* JADX INFO: renamed from: f */
    public boolean m13408f() {
        return this.f13097a != null && this.f13097a.mo14083f();
    }
}
