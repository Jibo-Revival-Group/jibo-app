package com.salesforce.android.knowledge.p022ui.internal.articledetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.exceptions.KnowledgeOfflineException;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.minimize.MinimizeContext;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailPresenterImpl implements ArticleDetailPresenter {

    /* JADX INFO: renamed from: a */
    static final ServiceLogger f13109a;

    /* JADX INFO: renamed from: i */
    static final /* synthetic */ boolean f13110i;

    /* JADX INFO: renamed from: b */
    final KnowledgeUIClientImpl f13111b;

    /* JADX INFO: renamed from: c */
    final ArticleSummary f13112c;

    /* JADX INFO: renamed from: d */
    final ArticleDetailsHandler f13113d = new ArticleDetailsHandler();

    /* JADX INFO: renamed from: e */
    ArticleDetailView f13114e;

    /* JADX INFO: renamed from: f */
    ArticleDetails f13115f;

    /* JADX INFO: renamed from: g */
    Drawable f13116g;

    /* JADX INFO: renamed from: h */
    boolean f13117h;

    static {
        f13110i = !ArticleDetailPresenterImpl.class.desiredAssertionStatus();
        f13109a = ServiceLogging.m14203a((Class<?>) ArticleDetailPresenterImpl.class);
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13437a(KnowledgeUIClientImpl knowledgeUIClientImpl, ArticleSummary articleSummary) {
        return new Builder(knowledgeUIClientImpl, articleSummary);
    }

    ArticleDetailPresenterImpl(Builder builder) {
        this.f13111b = builder.f13121a;
        this.f13112c = builder.f13122b;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b */
    public void mo13441b() {
        KnowledgeUIAnalyticsEmit.m13383j(this.f13112c.mo13217g(), this.f13112c.mo13219i());
        this.f13113d.m13403a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo13443b(ArticleDetailView articleDetailView) {
        this.f13114e = articleDetailView;
        this.f13116g = this.f13111b.m13532g().mo13354a(articleDetailView.mo13409a(), this.f13112c);
        m13438c(this.f13114e);
        m13447f();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo13440a(ArticleDetailView articleDetailView) {
        if (articleDetailView == this.f13114e) {
            this.f13114e = null;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: c */
    public void mo13444c() {
        this.f13113d.m13404b();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: d */
    public void mo13445d() {
        this.f13111b.m13534i().m13638a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailPresenter
    /* JADX INFO: renamed from: a */
    public void mo13436a() {
        if (!f13110i && this.f13114e == null) {
            throw new AssertionError();
        }
        this.f13111b.m13535j().m13613a(MinimizeContext.m13607a(this.f13116g, this.f13112c));
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: e */
    public void mo13446e() {
        this.f13111b.m13534i().m13646d();
    }

    /* JADX INFO: renamed from: c */
    private void m13438c(ArticleDetailView articleDetailView) {
        articleDetailView.mo13454a(this.f13112c.mo13219i());
        articleDetailView.mo13686a(this.f13111b.m13534i().m13644b());
        if (this.f13116g != null) {
            articleDetailView.mo13453a(this.f13116g);
        }
    }

    /* JADX INFO: renamed from: f */
    void m13447f() {
        if (this.f13114e != null) {
            boolean z = this.f13113d.m13406d() && (this.f13115f == null || this.f13115f.mo13203f().isEmpty());
            if (this.f13113d.m13407e() && this.f13117h) {
                this.f13114e.mo13452a(4);
                return;
            }
            if (this.f13113d.m13407e()) {
                this.f13114e.mo13452a(3);
            } else if (z) {
                this.f13114e.mo13452a(2);
            } else if (this.f13115f != null) {
                this.f13114e.mo13451a(this.f13111b, this.f13115f).mo14072a(new Async.CompletionHandler() { // from class: com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenterImpl.2
                    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
                    /* JADX INFO: renamed from: a */
                    public void mo12580a(Async<?> async) {
                        if (ArticleDetailPresenterImpl.this.f13114e != null) {
                            ArticleDetailPresenterImpl.this.f13114e.mo13452a(1);
                        }
                    }
                }).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailPresenterImpl.1
                    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
                    /* JADX INFO: renamed from: a */
                    public void mo12581a(Async<?> async, Throwable th) {
                        ArticleDetailPresenterImpl.f13109a.mo14189b("Error encountered loading WebView. {}", th.getLocalizedMessage());
                    }
                });
            }
        }
    }

    class ArticleDetailsHandler extends AbstractHandler<ArticleDetails> {
        ArticleDetailsHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13449a((Async<?>) async, (ArticleDetails) obj);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<ArticleDetails> mo13405c() {
            return ArticleDetailRequest.m13303a(ArticleDetailPresenterImpl.this.f13112c).m13307a(ArticleDetailPresenterImpl.this.f13111b.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            ArticleDetailPresenterImpl.f13109a.mo14193d("Error fetching article details: {}", th.getMessage());
            ArticleDetailPresenterImpl.this.f13117h = th instanceof KnowledgeOfflineException;
            ArticleDetailPresenterImpl.this.m13447f();
            m13448g();
        }

        /* JADX INFO: renamed from: a */
        public void m13449a(Async<?> async, ArticleDetails articleDetails) {
            ArticleDetailPresenterImpl.this.f13115f = articleDetails;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            ArticleDetailPresenterImpl.this.m13447f();
            m13448g();
        }

        /* JADX INFO: renamed from: g */
        private void m13448g() {
            KnowledgeUIAnalyticsEmit.m13369c(ArticleDetailPresenterImpl.this.f13112c.mo13217g(), ArticleDetailPresenterImpl.this.f13112c.mo13219i());
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        final KnowledgeUIClientImpl f13121a;

        /* JADX INFO: renamed from: b */
        final ArticleSummary f13122b;

        Builder(KnowledgeUIClientImpl knowledgeUIClientImpl, ArticleSummary articleSummary) {
            this.f13121a = knowledgeUIClientImpl;
            this.f13122b = articleSummary;
        }

        /* JADX INFO: renamed from: a */
        public ArticleDetailPresenter m13450a() {
            return new ArticleDetailPresenterImpl(this);
        }
    }
}
