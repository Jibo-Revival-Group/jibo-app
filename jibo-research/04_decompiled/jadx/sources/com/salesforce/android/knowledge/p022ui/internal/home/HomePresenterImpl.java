package com.salesforce.android.knowledge.p022ui.internal.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.AbstractHandler;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.models.EmptyArticleList;
import com.salesforce.android.knowledge.p022ui.internal.models.Models;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class HomePresenterImpl implements HomePresenter {

    /* JADX INFO: renamed from: k */
    static final /* synthetic */ boolean f13258k;

    /* JADX INFO: renamed from: a */
    final KnowledgeUIClientImpl f13259a;

    /* JADX INFO: renamed from: b */
    final String f13260b;

    /* JADX INFO: renamed from: c */
    final ColorCalculator f13261c;

    /* JADX INFO: renamed from: h */
    HomeView f13266h;

    /* JADX INFO: renamed from: i */
    DataCategoryInfo f13267i;

    /* JADX INFO: renamed from: d */
    DataCategoryGroupHandler f13262d = new DataCategoryGroupHandler();

    /* JADX INFO: renamed from: e */
    DataCategoryHandler f13263e = new DataCategoryHandler();

    /* JADX INFO: renamed from: f */
    final Set<ArticleListHandler> f13264f = new HashSet();

    /* JADX INFO: renamed from: g */
    final Map<DataCategoryInfo, ArticleList> f13265g = new HashMap();

    /* JADX INFO: renamed from: j */
    List<DataCategoryInfo> f13268j = new ArrayList();

    static {
        f13258k = !HomePresenterImpl.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13569a(KnowledgeUIClientImpl knowledgeUIClientImpl, String str) {
        return new Builder(knowledgeUIClientImpl, str);
    }

    HomePresenterImpl(Builder builder) {
        this.f13259a = builder.f13271a;
        this.f13260b = builder.f13272b;
        this.f13261c = builder.f13273c;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b */
    public void mo13441b() {
        KnowledgeUIAnalyticsEmit.m13382j();
        this.f13262d.m13403a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo13443b(HomeView homeView) {
        this.f13266h = homeView;
        m13570e();
        KnowledgeUIAnalyticsEmit.m13377g(this.f13259a.m13531f().m13402f(), this.f13260b);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo13440a(HomeView homeView) {
        this.f13266h = null;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: c */
    public void mo13444c() {
        this.f13263e.m13404b();
        Iterator<ArticleListHandler> it = this.f13264f.iterator();
        while (it.hasNext()) {
            it.next().m13404b();
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: a */
    public void mo13563a(ArticleSummary articleSummary) {
        this.f13259a.m13534i().m13640a(articleSummary);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: a */
    public void mo13562a() {
        this.f13259a.m13539n();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: d */
    public void mo13568d() {
        this.f13259a.m13534i().m13638a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: a */
    public void mo13564a(DataCategoryInfo dataCategoryInfo) {
        if (!f13258k && this.f13266h == null) {
            throw new AssertionError();
        }
        KnowledgeUIAnalyticsEmit.m13388m(dataCategoryInfo.mo13246b(), dataCategoryInfo.mo13245a());
        if (dataCategoryInfo == this.f13267i) {
            this.f13266h.mo13578a(dataCategoryInfo);
            this.f13267i = null;
            KnowledgeUIAnalyticsEmit.m13364a(dataCategoryInfo.mo13246b(), dataCategoryInfo.mo13245a());
            return;
        }
        if (this.f13267i != null) {
            this.f13266h.mo13578a(this.f13267i);
            KnowledgeUIAnalyticsEmit.m13364a(this.f13267i.mo13246b(), this.f13267i.mo13245a());
        }
        this.f13266h.mo13579a(dataCategoryInfo, this.f13265g.get(dataCategoryInfo));
        this.f13267i = dataCategoryInfo;
        KnowledgeUIAnalyticsEmit.m13367b(dataCategoryInfo.mo13246b(), dataCategoryInfo.mo13245a());
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: b */
    public void mo13566b(DataCategoryInfo dataCategoryInfo) {
        if (!f13258k && this.f13266h == null) {
            throw new AssertionError();
        }
        if (dataCategoryInfo.mo13247c() > 0) {
            this.f13259a.m13534i().m13643b(dataCategoryInfo);
        } else {
            this.f13259a.m13534i().m13641a(dataCategoryInfo);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: c */
    public boolean mo13567c(DataCategoryInfo dataCategoryInfo) {
        return dataCategoryInfo == this.f13267i;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomePresenter
    /* JADX INFO: renamed from: b */
    public Drawable mo13565b(ArticleSummary articleSummary) {
        if (f13258k || this.f13266h != null) {
            return this.f13259a.m13532g().mo13354a(this.f13266h.mo13409a(), articleSummary);
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: e */
    void m13570e() {
        if (this.f13266h != null) {
            boolean z = !this.f13259a.m13528b(this.f13266h.mo13409a());
            boolean z2 = this.f13262d.m13407e() || this.f13263e.m13407e();
            if (this.f13262d.m13408f() || this.f13263e.m13408f()) {
                this.f13266h.mo13577a(0);
                return;
            }
            if (z && z2) {
                this.f13266h.mo13577a(4);
                return;
            }
            if (z2) {
                this.f13266h.mo13577a(3);
                return;
            }
            if (!this.f13268j.isEmpty()) {
                this.f13266h.mo13580a(this.f13268j);
                this.f13266h.mo13577a(1);
                if (this.f13267i != null) {
                    this.f13266h.mo13579a(this.f13267i, this.f13265g.get(this.f13267i));
                }
            }
        }
    }

    class DataCategoryGroupHandler extends AbstractHandler<DataCategoryGroup> {
        DataCategoryGroupHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13574a((Async<?>) async, (DataCategoryGroup) obj);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<DataCategoryGroup> mo13405c() {
            return DataCategoryGroupRequest.m13334a(HomePresenterImpl.this.f13259a.m13531f().m13402f()).m13337a(HomePresenterImpl.this.f13259a.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            HomePresenterImpl.this.m13570e();
        }

        /* JADX INFO: renamed from: a */
        public void m13574a(Async<?> async, DataCategoryGroup dataCategoryGroup) {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            HomePresenterImpl.this.f13263e.m13403a();
        }
    }

    class DataCategoryHandler extends AbstractHandler<DataCategoryList> {
        DataCategoryHandler() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13576a((Async<?>) async, (DataCategoryList) obj);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<DataCategoryList> mo13405c() {
            return DataCategoriesRequest.m13328a(HomePresenterImpl.this.f13259a.m13531f().m13402f(), HomePresenterImpl.this.f13260b).m13332a(HomePresenterImpl.this.f13259a.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            HomePresenterImpl.this.m13570e();
            m13575g();
        }

        /* JADX INFO: renamed from: a */
        public void m13576a(Async<?> async, DataCategoryList dataCategoryList) {
            List<DataCategorySummary> listMo13242a = dataCategoryList.mo13242a();
            HomePresenterImpl.this.f13268j = Models.m13624a(listMo13242a, HomePresenterImpl.this.f13261c, HomePresenterImpl.this.f13259a.m13532g());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            HomePresenterImpl.this.m13570e();
            m13575g();
            Iterator<DataCategoryInfo> it = HomePresenterImpl.this.f13268j.iterator();
            while (it.hasNext()) {
                ArticleListHandler articleListHandler = HomePresenterImpl.this.new ArticleListHandler(it.next());
                articleListHandler.m13403a();
                HomePresenterImpl.this.f13264f.add(articleListHandler);
            }
        }

        /* JADX INFO: renamed from: g */
        private void m13575g() {
            KnowledgeUIAnalyticsEmit.m13368c();
        }
    }

    class ArticleListHandler extends AbstractHandler<ArticleList> {

        /* JADX INFO: renamed from: b */
        private final DataCategoryInfo f13270b;

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
            m13571a((Async<?>) async, (ArticleList) obj);
        }

        ArticleListHandler(DataCategoryInfo dataCategoryInfo) {
            this.f13270b = dataCategoryInfo;
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected Async<ArticleList> mo13405c() {
            return ArticleListRequest.m13309a().m13322a(HomePresenterImpl.this.f13259a.m13531f().m13402f(), this.f13270b.mo13245a()).m13326c(1).m13325b(3).m13324a(HomePresenterImpl.this.f13259a.mo13393c());
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            HomePresenterImpl.this.f13265g.put(this.f13270b, new EmptyArticleList());
        }

        /* JADX INFO: renamed from: a */
        public void m13571a(Async<?> async, ArticleList articleList) {
            HomePresenterImpl.this.f13265g.put(this.f13270b, articleList);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        final KnowledgeUIClientImpl f13271a;

        /* JADX INFO: renamed from: b */
        final String f13272b;

        /* JADX INFO: renamed from: c */
        ColorCalculator f13273c;

        Builder(KnowledgeUIClientImpl knowledgeUIClientImpl, String str) {
            this.f13271a = knowledgeUIClientImpl;
            this.f13272b = str;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13573a(Context context) {
            this.f13273c = new ColorCalculator(ContextCompat.m1840c(context, R.color.salesforce_brand_primary), 10, 8);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public HomePresenter m13572a() {
            if (this.f13273c == null) {
                throw new IllegalStateException("Must supply a color calculator");
            }
            return new HomePresenterImpl(this);
        }
    }
}
