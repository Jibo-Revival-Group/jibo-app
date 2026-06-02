package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {

    /* JADX INFO: renamed from: a */
    private Request f4964a;

    /* JADX INFO: renamed from: b */
    private Request f4965b;

    /* JADX INFO: renamed from: c */
    private RequestCoordinator f4966c;

    public ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.f4966c = requestCoordinator;
    }

    /* JADX INFO: renamed from: a */
    public void m5537a(Request request, Request request2) {
        this.f4964a = request;
        this.f4965b = request2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* JADX INFO: renamed from: a */
    public boolean mo5528a(Request request) {
        return m5534j() && (request.equals(this.f4964a) || !this.f4964a.mo5525h());
    }

    /* JADX INFO: renamed from: j */
    private boolean m5534j() {
        return this.f4966c == null || this.f4966c.mo5528a(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* JADX INFO: renamed from: b */
    public boolean mo5529b(Request request) {
        return m5535k() && request.equals(this.f4964a) && !mo5531c();
    }

    /* JADX INFO: renamed from: k */
    private boolean m5535k() {
        return this.f4966c == null || this.f4966c.mo5529b(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* JADX INFO: renamed from: c */
    public boolean mo5531c() {
        return m5536l() || mo5525h();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* JADX INFO: renamed from: c */
    public void mo5530c(Request request) {
        if (!request.equals(this.f4965b)) {
            if (this.f4966c != null) {
                this.f4966c.mo5530c(this);
            }
            if (!this.f4965b.mo5524g()) {
                this.f4965b.mo5521d();
            }
        }
    }

    /* JADX INFO: renamed from: l */
    private boolean m5536l() {
        return this.f4966c != null && this.f4966c.mo5531c();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: b */
    public void mo5519b() {
        if (!this.f4965b.mo5523f()) {
            this.f4965b.mo5519b();
        }
        if (!this.f4964a.mo5523f()) {
            this.f4964a.mo5519b();
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: e */
    public void mo5522e() {
        this.f4964a.mo5522e();
        this.f4965b.mo5522e();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: d */
    public void mo5521d() {
        this.f4965b.mo5521d();
        this.f4964a.mo5521d();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: f */
    public boolean mo5523f() {
        return this.f4964a.mo5523f();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: g */
    public boolean mo5524g() {
        return this.f4964a.mo5524g() || this.f4965b.mo5524g();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: h */
    public boolean mo5525h() {
        return this.f4964a.mo5525h() || this.f4965b.mo5525h();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: i */
    public boolean mo5526i() {
        return this.f4964a.mo5526i();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: a */
    public void mo5517a() {
        this.f4964a.mo5517a();
        this.f4965b.mo5517a();
    }
}
