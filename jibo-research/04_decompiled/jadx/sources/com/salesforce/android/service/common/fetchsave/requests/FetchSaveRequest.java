package com.salesforce.android.service.common.fetchsave.requests;

/* JADX INFO: loaded from: classes.dex */
public abstract class FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final boolean f13451a;

    /* JADX INFO: renamed from: b */
    private final boolean f13452b;

    /* JADX INFO: renamed from: c */
    private final boolean f13453c;

    protected FetchSaveRequest(FetchSaveRequestBuilder fetchSaveRequestBuilder) {
        this.f13451a = fetchSaveRequestBuilder.mo12682d();
        this.f13452b = fetchSaveRequestBuilder.mo12684f_();
        this.f13453c = fetchSaveRequestBuilder.m13743f();
    }

    /* JADX INFO: renamed from: l */
    public boolean m13739l() {
        return this.f13451a;
    }

    /* JADX INFO: renamed from: m */
    public boolean m13740m() {
        return this.f13452b;
    }

    /* JADX INFO: renamed from: n */
    public boolean m13741n() {
        return this.f13453c;
    }

    public static abstract class FetchSaveRequestBuilder<T extends FetchSaveRequestBuilder<T>> {

        /* JADX INFO: renamed from: a */
        private boolean f13454a = true;

        /* JADX INFO: renamed from: b */
        private boolean f13455b = false;

        /* JADX INFO: renamed from: c */
        private boolean f13456c = true;

        /* JADX INFO: renamed from: c */
        protected abstract T mo12627c();

        /* JADX INFO: renamed from: d */
        public T mo12688d(boolean z) {
            this.f13454a = z;
            return (T) mo12627c();
        }

        /* JADX INFO: renamed from: e */
        public T m13742e(boolean z) {
            this.f13455b = z;
            return (T) mo12627c();
        }

        /* JADX INFO: renamed from: c */
        public T mo12687c(boolean z) {
            this.f13456c = z;
            return (T) mo12627c();
        }

        /* JADX INFO: renamed from: d */
        public boolean mo12682d() {
            return this.f13456c;
        }

        /* JADX INFO: renamed from: f_ */
        public boolean mo12684f_() {
            return this.f13454a;
        }

        /* JADX INFO: renamed from: f */
        public boolean m13743f() {
            return this.f13455b;
        }
    }
}
