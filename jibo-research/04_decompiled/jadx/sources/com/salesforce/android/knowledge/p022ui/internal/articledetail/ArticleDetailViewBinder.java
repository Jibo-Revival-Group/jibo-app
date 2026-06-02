package com.salesforce.android.knowledge.p022ui.internal.articledetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.p022ui.ArticleWebView;
import com.salesforce.android.knowledge.p022ui.ArticleWebViewConfiguration;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.views.TintedCollapsingToolbarLayout;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailViewBinder extends ToolbarViewBinder implements ArticleDetailView {

    /* JADX INFO: renamed from: a */
    protected TintedCollapsingToolbarLayout f13123a;

    /* JADX INFO: renamed from: b */
    private final ArticleDetailPresenter f13124b;

    /* JADX INFO: renamed from: c */
    private AppBarLayout f13125c;

    /* JADX INFO: renamed from: d */
    private ImageView f13126d;

    /* JADX INFO: renamed from: e */
    private View f13127e;

    /* JADX INFO: renamed from: f */
    private ArticleWebView f13128f;

    /* JADX INFO: renamed from: g */
    private View f13129g;

    /* JADX INFO: renamed from: h */
    private View f13130h;

    /* JADX INFO: renamed from: i */
    private View f13131i;

    /* JADX INFO: renamed from: j */
    private View f13132j;

    /* JADX INFO: renamed from: k */
    private View f13133k;

    /* JADX INFO: renamed from: a */
    public static ArticleDetailViewBinder m13455a(ArticleDetailPresenter articleDetailPresenter) {
        return new ArticleDetailViewBinder(articleDetailPresenter);
    }

    private ArticleDetailViewBinder(ArticleDetailPresenter articleDetailPresenter) {
        super(articleDetailPresenter);
        this.f13124b = articleDetailPresenter;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13129g = layoutInflater.inflate(R.layout.knowledge_fragment_article_detail, viewGroup, false);
        m13456a(this.f13129g);
        this.f13124b.mo13443b(this);
        return this.f13129g;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13417b() {
        this.f13124b.mo13440a(this);
        this.f13128f.m13342a();
    }

    /* JADX INFO: renamed from: a */
    void m13456a(View view) {
        this.f13125c = (AppBarLayout) view.findViewById(R.id.knowledge_article_detail_app_bar_layout);
        this.f13123a = (TintedCollapsingToolbarLayout) view.findViewById(R.id.knowledge_article_collapsing_toolbar);
        this.f13127e = view.findViewById(R.id.knowledge_article_header_gradient);
        this.f13126d = (ImageView) view.findViewById(R.id.knowledge_article_header_image);
        this.f13130h = view.findViewById(R.id.knowledge_indeterminate_progress);
        this.f13131i = view.findViewById(R.id.knowledge_empty_article);
        this.f13132j = view.findViewById(R.id.knowledge_error);
        this.f13133k = view.findViewById(R.id.knowledge_network_error);
        this.f13128f = (ArticleWebView) view.findViewById(R.id.knowledge_article_webview);
        this.f13123a.post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.articledetail.ArticleDetailViewBinder.1
            @Override // java.lang.Runnable
            public void run() {
                ArticleDetailViewBinder.this.f13123a.requestLayout();
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder, com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: d */
    public Toolbar mo13419d() {
        return (Toolbar) this.f13129g.findViewById(R.id.knowledge_article_toolbar);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder, com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13415a(Menu menu, MenuInflater menuInflater) {
        super.mo13415a(menu, menuInflater);
        menuInflater.inflate(R.menu.knowledge_article_menu, menu);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder, com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public boolean mo13416a(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.knowledge_action_minimize) {
            return super.mo13416a(menuItem);
        }
        this.f13124b.mo13436a();
        return true;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailView
    /* JADX INFO: renamed from: a */
    public void mo13452a(int i) {
        this.f13128f.setVisibility(i == 1 ? 0 : 8);
        this.f13130h.setVisibility(i == 0 ? 0 : 8);
        this.f13131i.setVisibility(i == 2 ? 0 : 8);
        this.f13132j.setVisibility(i == 3 ? 0 : 8);
        this.f13133k.setVisibility(i == 4 ? 0 : 8);
        if (this.f13128f.getVisibility() != 0) {
            this.f13125c.setExpanded(false);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailView
    /* JADX INFO: renamed from: a */
    public void mo13454a(String str) {
        this.f13123a.setTitle(str);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailView
    /* JADX INFO: renamed from: a */
    public void mo13453a(Drawable drawable) {
        this.f13126d.setImageDrawable(drawable);
        this.f13127e.setBackgroundResource(R.drawable.knowledge_header_gradient);
        this.f13125c.setExpanded(true);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articledetail.ArticleDetailView
    /* JADX INFO: renamed from: a */
    public Async<Void> mo13451a(KnowledgeUIClient knowledgeUIClient, ArticleDetails articleDetails) {
        return this.f13128f.m13341a(articleDetails, new ArticleWebViewConfiguration.Builder(knowledgeUIClient.mo13393c()).m13350a(knowledgeUIClient.mo13394d()).m13351a(knowledgeUIClient.mo13395e()).m13352a());
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractView
    /* JADX INFO: renamed from: a */
    public Context mo13409a() {
        return this.f13129g.getContext();
    }
}
