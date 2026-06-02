package com.salesforce.android.knowledge.p022ui.internal.search;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchPresenterImpl implements SearchPresenter, Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<ArticleList> {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f13390a;

    /* JADX INFO: renamed from: b */
    private final KnowledgeUIClientImpl f13391b;

    /* JADX INFO: renamed from: c */
    private final KnowledgeClient f13392c;

    /* JADX INFO: renamed from: d */
    private SearchView f13393d;

    /* JADX INFO: renamed from: e */
    private Async<ArticleList> f13394e;

    /* JADX INFO: renamed from: i */
    private boolean f13398i;

    /* JADX INFO: renamed from: f */
    private List<ArticleSummary> f13395f = new ArrayList();

    /* JADX INFO: renamed from: g */
    private CharSequence f13396g = "";

    /* JADX INFO: renamed from: h */
    private int f13397h = 1;

    /* JADX INFO: renamed from: j */
    private boolean f13399j = true;

    static {
        f13390a = !SearchPresenterImpl.class.desiredAssertionStatus();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, ArticleList articleList) {
        a2((Async<?>) async, articleList);
    }

    /* JADX INFO: renamed from: a */
    public static SearchPresenter m13674a(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return new SearchPresenterImpl(knowledgeUIClientImpl);
    }

    SearchPresenterImpl(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        this.f13391b = knowledgeUIClientImpl;
        this.f13392c = knowledgeUIClientImpl.mo13393c();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b */
    public void mo13441b() {
        KnowledgeUIAnalyticsEmit.m13386l();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo13443b(SearchView searchView) {
        this.f13393d = searchView;
        this.f13393d.mo13680a(this.f13395f, this.f13398i);
        this.f13393d.mo13679a(this.f13396g);
        m13677f();
        if (this.f13399j) {
            KnowledgeUIAnalyticsEmit.m13372e();
            this.f13399j = false;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo13440a(SearchView searchView) {
        if (this.f13393d == searchView) {
            this.f13393d = null;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter
    /* JADX INFO: renamed from: c */
    public void mo13444c() {
        if (this.f13394e != null) {
            this.f13394e.mo14080c();
            this.f13394e = null;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter
    /* JADX INFO: renamed from: a */
    public void mo13672a(CharSequence charSequence) {
        if (!f13390a && this.f13393d == null) {
            throw new AssertionError();
        }
        if (!charSequence.equals(this.f13396g)) {
            if (this.f13394e != null) {
                this.f13394e.mo14080c();
            }
            this.f13396g = charSequence;
            if (charSequence.length() == 0) {
                KnowledgeUIAnalyticsEmit.m13378h();
            } else if (charSequence.length() > 1) {
                KnowledgeUIAnalyticsEmit.m13363a(charSequence);
                m13675d();
                m13676e();
            }
            m13677f();
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter
    /* JADX INFO: renamed from: a */
    public void mo13671a(ArticleSummary articleSummary) {
        if (!f13390a && this.f13393d == null) {
            throw new AssertionError();
        }
        this.f13391b.m13534i().m13640a(articleSummary);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter
    /* JADX INFO: renamed from: a */
    public void mo13670a() {
        this.f13397h++;
        m13676e();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchPresenter
    /* JADX INFO: renamed from: b */
    public Drawable mo13673b(ArticleSummary articleSummary) {
        if (f13390a || this.f13393d != null) {
            return this.f13391b.m13532g().mo13354a(this.f13393d.mo13409a(), articleSummary);
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: d */
    private void m13675d() {
        this.f13395f.clear();
        this.f13397h = 1;
        if (this.f13393d != null) {
            this.f13393d.mo13682c();
        }
    }

    /* JADX INFO: renamed from: e */
    private void m13676e() {
        this.f13394e = ArticleListRequest.m13309a().m13325b(20).m13320a(this.f13397h).m13321a(this.f13396g).m13324a(this.f13392c).mo14077b(this);
    }

    /* JADX INFO: renamed from: f */
    private void m13677f() {
        if (this.f13393d != null) {
            boolean z = this.f13394e != null && this.f13394e.mo14083f();
            boolean z2 = this.f13394e != null && this.f13394e.mo14082e();
            if (z) {
                this.f13393d.mo13678a(4);
                return;
            }
            if (this.f13396g.length() <= 1) {
                this.f13393d.mo13678a(0);
                return;
            }
            if (z2) {
                this.f13393d.mo13678a(3);
            } else if (this.f13395f.size() == 0) {
                this.f13393d.mo13678a(1);
            } else {
                this.f13393d.mo13678a(2);
            }
        }
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public void mo12581a(Async<?> async, Throwable th) {
        m13677f();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Async<?> async, ArticleList articleList) {
        this.f13395f.addAll(articleList.mo13212a());
        this.f13398i = articleList.mo13214c();
        if (this.f13393d != null) {
            if (articleList.mo13213b() == 1) {
                this.f13393d.mo13680a(articleList.mo13212a(), this.f13398i);
            } else {
                this.f13393d.mo13681b(articleList.mo13212a(), this.f13398i);
            }
            KnowledgeUIAnalyticsEmit.m13370d();
        }
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
        m13677f();
    }
}
