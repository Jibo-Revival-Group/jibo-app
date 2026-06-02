package com.salesforce.android.knowledge.p022ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleListPresenterImpl implements ArticleListPresenter {

    /* JADX INFO: renamed from: g */
    static final /* synthetic */ boolean f13141g;

    /* JADX INFO: renamed from: a */
    final KnowledgeUIClientImpl f13142a;

    /* JADX INFO: renamed from: b */
    final DataCategoryInfo f13143b;

    /* JADX INFO: renamed from: d */
    boolean f13145d;

    /* JADX INFO: renamed from: f */
    ArticleListView f13147f;

    /* JADX INFO: renamed from: c */
    List<ArticleSummary> f13144c = new LinkedList();

    /* JADX INFO: renamed from: e */
    int f13146e = 1;

    /* JADX INFO: renamed from: h */
    private ArticleListHandler f13148h = new ArticleListHandler(this.f13146e);

    static {
        f13141g = !ArticleListPresenterImpl.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static ArticleListPresenter m13465a(KnowledgeUIClientImpl knowledgeUIClientImpl, DataCategoryInfo dataCategoryInfo) {
        return new ArticleListPresenterImpl(knowledgeUIClientImpl, dataCategoryInfo);
    }

    private ArticleListPresenterImpl(KnowledgeUIClientImpl knowledgeUIClientImpl, DataCategoryInfo dataCategoryInfo) {
        this.f13142a = knowledgeUIClientImpl;
        this.f13143b = dataCategoryInfo;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b */
    public void mo13441b() {
        KnowledgeUIAnalyticsEmit.m13385k(this.f13143b.mo13246b(), this.f13143b.mo13245a());
        this.f13148h.m13403a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo13443b(ArticleListView articleListView) {
        this.f13147f = articleListView;
        this.f13147f.mo13472a(this.f13143b.m13621a(articleListView.mo13409a()));
        this.f13147f.mo13473a(this.f13143b.mo13246b());
        this.f13147f.mo13474a(this.f13144c, this.f13145d);
        this.f13147f.mo13686a(this.f13142a.m13534i().m13644b());
        m13468f();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo13440a(ArticleListView articleListView) {
        if (articleListView == this.f13147f) {
            this.f13147f = null;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: c */
    public void mo13444c() {
        this.f13148h.m13404b();
        this.f13144c.clear();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenter
    /* JADX INFO: renamed from: a */
    public void mo13463a(ArticleSummary articleSummary) {
        this.f13142a.m13534i().m13640a(articleSummary);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenter
    /* JADX INFO: renamed from: a */
    public void mo13462a() {
        if (!this.f13148h.m13408f()) {
            KnowledgeUIAnalyticsEmit.m13389n(this.f13143b.mo13246b(), this.f13143b.mo13245a());
            int i = this.f13146e + 1;
            this.f13146e = i;
            this.f13148h = new ArticleListHandler(i);
            this.f13148h.m13403a();
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListPresenter
    /* JADX INFO: renamed from: b */
    public Drawable mo13464b(ArticleSummary articleSummary) {
        if (f13141g || this.f13147f != null) {
            return this.f13142a.m13532g().mo13354a(this.f13147f.mo13409a(), articleSummary);
        }
        throw new AssertionError();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: d */
    public void mo13445d() {
        this.f13142a.m13534i().m13638a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: e */
    public void mo13446e() {
        this.f13142a.m13534i().m13646d();
    }

    /* JADX INFO: renamed from: f */
    void m13468f() {
        if (this.f13147f != null) {
            if (this.f13148h.m13408f() && this.f13144c.isEmpty()) {
                this.f13147f.mo13471a(4);
                return;
            }
            if (this.f13148h.m13407e()) {
                this.f13147f.mo13471a(3);
            } else if (this.f13144c.isEmpty()) {
                this.f13147f.mo13471a(2);
            } else {
                this.f13147f.mo13471a(1);
            }
        }
    }

    private class ArticleListHandler extends AbstractHandler<ArticleList> {

        /* JADX INFO: renamed from: b */
        private final int f13150b;

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13470a((Async<?>) async, (ArticleList) obj);
        }

        ArticleListHandler(int i) {
            this.f13150b = i;
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<ArticleList> mo13405c() {
            return ArticleListRequest.m13309a().m13322a(ArticleListPresenterImpl.this.f13142a.m13531f().m13402f(), ArticleListPresenterImpl.this.f13143b.mo13245a()).m13326c(1).m13325b(10).m13320a(this.f13150b).m13324a(ArticleListPresenterImpl.this.f13142a.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            ArticleListPresenterImpl.this.m13468f();
            m13469g();
        }

        /* JADX INFO: renamed from: a */
        public void m13470a(Async<?> async, ArticleList articleList) {
            ArticleListPresenterImpl.this.f13144c.addAll(articleList.mo13212a());
            ArticleListPresenterImpl.this.f13145d = articleList.mo13214c();
            if (ArticleListPresenterImpl.this.f13147f != null) {
                ArticleListPresenterImpl.this.f13147f.mo13474a(articleList.mo13212a(), articleList.mo13214c());
            }
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            ArticleListPresenterImpl.this.m13468f();
            m13469g();
        }

        /* JADX INFO: renamed from: g */
        private void m13469g() {
            if (this.f13150b == 1) {
                KnowledgeUIAnalyticsEmit.m13371d(ArticleListPresenterImpl.this.f13143b.mo13246b(), ArticleListPresenterImpl.this.f13143b.mo13245a());
            } else {
                KnowledgeUIAnalyticsEmit.m13375f(ArticleListPresenterImpl.this.f13143b.mo13246b(), ArticleListPresenterImpl.this.f13143b.mo13245a());
            }
        }
    }
}
