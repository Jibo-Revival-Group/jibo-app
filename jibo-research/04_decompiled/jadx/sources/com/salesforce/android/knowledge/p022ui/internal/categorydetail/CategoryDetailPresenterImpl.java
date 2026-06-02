package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.models.Models;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CategoryDetailPresenterImpl implements CategoryDetailPresenter {

    /* JADX INFO: renamed from: h */
    static final /* synthetic */ boolean f13183h;

    /* JADX INFO: renamed from: a */
    final DataCategoryInfo f13184a;

    /* JADX INFO: renamed from: b */
    final KnowledgeUIClientImpl f13185b;

    /* JADX INFO: renamed from: c */
    final ArticleListHandler f13186c;

    /* JADX INFO: renamed from: d */
    final CategoryListHandler f13187d;

    /* JADX INFO: renamed from: e */
    List<ArticleSummary> f13188e = new LinkedList();

    /* JADX INFO: renamed from: f */
    List<DataCategoryInfo> f13189f = new LinkedList();

    /* JADX INFO: renamed from: g */
    boolean f13190g = false;

    /* JADX INFO: renamed from: i */
    private CategoryDetailView f13191i;

    static {
        f13183h = !CategoryDetailPresenterImpl.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static CategoryDetailPresenter m13506a(KnowledgeUIClientImpl knowledgeUIClientImpl, DataCategoryInfo dataCategoryInfo) {
        return new CategoryDetailPresenterImpl(knowledgeUIClientImpl, dataCategoryInfo);
    }

    private CategoryDetailPresenterImpl(KnowledgeUIClientImpl knowledgeUIClientImpl, DataCategoryInfo dataCategoryInfo) {
        this.f13186c = new ArticleListHandler();
        this.f13187d = new CategoryListHandler();
        this.f13185b = knowledgeUIClientImpl;
        this.f13184a = dataCategoryInfo;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b */
    public void mo13441b() {
        KnowledgeUIAnalyticsEmit.m13387l(this.f13184a.mo13246b(), this.f13184a.mo13245a());
        this.f13186c.m13403a();
        this.f13187d.m13403a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo13443b(CategoryDetailView categoryDetailView) {
        this.f13191i = categoryDetailView;
        m13507c(this.f13191i);
        m13510f();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo13440a(CategoryDetailView categoryDetailView) {
        if (categoryDetailView == this.f13191i) {
            this.f13191i = null;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: c */
    public void mo13444c() {
        this.f13186c.m13404b();
        this.f13187d.m13404b();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter
    /* JADX INFO: renamed from: a */
    public void mo13503a(ArticleSummary articleSummary) {
        if (!f13183h && this.f13191i == null) {
            throw new AssertionError();
        }
        this.f13185b.m13534i().m13640a(articleSummary);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter
    /* JADX INFO: renamed from: a */
    public void mo13502a() {
        if (!f13183h && this.f13191i == null) {
            throw new AssertionError();
        }
        this.f13185b.m13534i().m13641a(this.f13184a);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter
    /* JADX INFO: renamed from: a */
    public void mo13504a(DataCategoryInfo dataCategoryInfo) {
        if (dataCategoryInfo.mo13247c() > 0) {
            this.f13185b.m13534i().m13643b(dataCategoryInfo);
        } else {
            this.f13185b.m13534i().m13641a(dataCategoryInfo);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailPresenter
    /* JADX INFO: renamed from: b */
    public Drawable mo13505b(ArticleSummary articleSummary) {
        if (f13183h || this.f13191i != null) {
            return this.f13185b.m13532g().mo13354a(this.f13191i.mo13409a(), articleSummary);
        }
        throw new AssertionError();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: d */
    public void mo13445d() {
        this.f13185b.m13534i().m13638a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter
    /* JADX INFO: renamed from: e */
    public void mo13446e() {
        this.f13185b.m13534i().m13646d();
    }

    /* JADX INFO: renamed from: c */
    private void m13507c(CategoryDetailView categoryDetailView) {
        categoryDetailView.mo13516a(this.f13184a.mo13246b());
        categoryDetailView.mo13686a(this.f13185b.m13534i().m13644b());
        Drawable drawableM13621a = this.f13184a.m13621a(categoryDetailView.mo13409a());
        if (drawableM13621a != null) {
            categoryDetailView.mo13515a(drawableM13621a);
        }
    }

    /* JADX INFO: renamed from: f */
    void m13510f() {
        boolean z = false;
        if (this.f13191i != null) {
            boolean z2 = this.f13186c.m13407e() || this.f13187d.m13407e();
            boolean z3 = this.f13186c.m13406d() && this.f13187d.m13406d();
            if (this.f13188e.isEmpty() && this.f13189f.isEmpty()) {
                z = true;
            }
            if (z2) {
                this.f13191i.mo13514a(3);
                return;
            }
            if (z && z3) {
                this.f13191i.mo13514a(2);
            } else if (z3) {
                this.f13191i.mo13517a(this.f13188e, this.f13189f, this.f13190g);
                this.f13191i.mo13514a(1);
            }
        }
    }

    private class ArticleListHandler extends AbstractHandler<ArticleList> {
        private ArticleListHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13511a((Async<?>) async, (ArticleList) obj);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<ArticleList> mo13405c() {
            return ArticleListRequest.m13309a().m13322a(CategoryDetailPresenterImpl.this.f13185b.m13531f().m13402f(), CategoryDetailPresenterImpl.this.f13184a.mo13245a()).m13326c(1).m13325b(3).m13324a(CategoryDetailPresenterImpl.this.f13185b.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CategoryDetailPresenterImpl.this.m13510f();
        }

        /* JADX INFO: renamed from: a */
        public void m13511a(Async<?> async, ArticleList articleList) {
            CategoryDetailPresenterImpl.this.f13188e = articleList.mo13212a();
            CategoryDetailPresenterImpl.this.f13190g = articleList.mo13214c();
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CategoryDetailPresenterImpl.this.m13510f();
        }
    }

    private class CategoryListHandler extends AbstractHandler<DataCategoryList> {
        private CategoryListHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13513a((Async<?>) async, (DataCategoryList) obj);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<DataCategoryList> mo13405c() {
            return DataCategoriesRequest.m13328a(CategoryDetailPresenterImpl.this.f13185b.m13531f().m13402f(), CategoryDetailPresenterImpl.this.f13184a.mo13245a()).m13332a(CategoryDetailPresenterImpl.this.f13185b.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CategoryDetailPresenterImpl.this.m13510f();
            m13512g();
        }

        /* JADX INFO: renamed from: a */
        public void m13513a(Async<?> async, DataCategoryList dataCategoryList) {
            CategoryDetailPresenterImpl.this.f13189f = Models.m13624a(dataCategoryList.mo13242a(), Models.m13623a(CategoryDetailPresenterImpl.this.f13184a.m13622d()), CategoryDetailPresenterImpl.this.f13185b.m13532g());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CategoryDetailPresenterImpl.this.m13510f();
            m13512g();
        }

        /* JADX INFO: renamed from: g */
        private void m13512g() {
            KnowledgeUIAnalyticsEmit.m13373e(CategoryDetailPresenterImpl.this.f13184a.mo13246b(), CategoryDetailPresenterImpl.this.f13184a.mo13245a());
        }
    }
}
