package com.salesforce.android.knowledge.p022ui.internal.articlelist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.util.DividerDecoration;
import com.salesforce.android.knowledge.p022ui.internal.util.InfiniteScrollListener;
import com.salesforce.android.knowledge.p022ui.internal.views.TintedCollapsingToolbarLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleListViewBinder extends ToolbarViewBinder implements ArticleListView {

    /* JADX INFO: renamed from: a */
    final ArticleListPresenter f13151a;

    /* JADX INFO: renamed from: b */
    final ArticleListController f13152b;

    /* JADX INFO: renamed from: c */
    private final InfiniteScrollListener f13153c;

    /* JADX INFO: renamed from: d */
    private View f13154d;

    /* JADX INFO: renamed from: e */
    private ImageView f13155e;

    /* JADX INFO: renamed from: f */
    private AppBarLayout f13156f;

    /* JADX INFO: renamed from: g */
    private TintedCollapsingToolbarLayout f13157g;

    /* JADX INFO: renamed from: h */
    private RecyclerView f13158h;

    /* JADX INFO: renamed from: i */
    private View f13159i;

    /* JADX INFO: renamed from: j */
    private View f13160j;

    /* JADX INFO: renamed from: k */
    private View f13161k;

    /* JADX INFO: renamed from: a */
    public static ArticleListViewBinder m13475a(Context context, ArticleListPresenter articleListPresenter) {
        return new ArticleListViewBinder(articleListPresenter, new ArticleListController(context, articleListPresenter), InfiniteScrollListener.m13699a(new LinearLayoutManager(context)));
    }

    private ArticleListViewBinder(ArticleListPresenter articleListPresenter, ArticleListController articleListController, InfiniteScrollListener infiniteScrollListener) {
        super(articleListPresenter);
        this.f13151a = articleListPresenter;
        this.f13152b = articleListController;
        this.f13153c = infiniteScrollListener;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13154d = layoutInflater.inflate(R.layout.knowledge_fragment_article_list, viewGroup, false);
        m13477a(this.f13154d);
        this.f13151a.mo13443b(this);
        return this.f13154d;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13417b() {
        this.f13158h.stopScroll();
        this.f13151a.mo13440a(this);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder, com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: d */
    public Toolbar mo13419d() {
        return (Toolbar) this.f13154d.findViewById(R.id.knowledge_article_list_toolbar);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13414a(Bundle bundle) {
        super.mo13414a(bundle);
        bundle.putParcelable("layout_manager_state", this.f13158h.getLayoutManager().mo4310d());
        this.f13153c.m13708a(bundle);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13418b(Bundle bundle) {
        super.mo13418b(bundle);
        if (!bundle.isEmpty()) {
            final Parcelable parcelable = bundle.getParcelable("layout_manager_state");
            this.f13153c.m13710b(bundle);
            if (this.f13153c.m13709b() > 0) {
                this.f13156f.m420a(false, false);
            }
            final RecyclerView recyclerView = this.f13158h;
            recyclerView.post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListViewBinder.1
                @Override // java.lang.Runnable
                public void run() {
                    recyclerView.getLayoutManager().mo4293a(parcelable);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    void m13477a(View view) {
        this.f13158h = (RecyclerView) view.findViewById(R.id.knowledge_article_list_body);
        this.f13159i = view.findViewById(R.id.knowledge_empty_category);
        this.f13155e = (ImageView) view.findViewById(R.id.knowledge_article_list_header_image);
        this.f13156f = (AppBarLayout) view.findViewById(R.id.knowledge_article_list_app_bar_layout);
        this.f13157g = (TintedCollapsingToolbarLayout) view.findViewById(R.id.knowledge_article_list_collapse_toolbar);
        this.f13160j = view.findViewById(R.id.knowledge_error);
        this.f13161k = view.findViewById(R.id.knowledge_indeterminate_progress);
        this.f13153c.m13702a(2).m13703a(new InfiniteScrollListener.BehaviorListener() { // from class: com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListViewBinder.2
            @Override // com.salesforce.android.knowledge.ui.internal.util.InfiniteScrollListener.BehaviorListener
            /* JADX INFO: renamed from: s_ */
            public void mo13478s_() {
                ArticleListViewBinder.this.f13151a.mo13462a();
            }
        });
        this.f13158h.addItemDecoration(new DividerDecoration(ContextCompat.m1832a(view.getContext(), R.drawable.knowledge_background_border)));
        this.f13158h.setLayoutManager(this.f13153c.m13701a());
        this.f13158h.setAdapter(this.f13152b.m13706c());
        this.f13158h.addOnScrollListener(this.f13153c);
        this.f13158h.setVisibility(8);
        this.f13159i.setVisibility(8);
        this.f13160j.setVisibility(8);
        this.f13157g.post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListViewBinder.3
            @Override // java.lang.Runnable
            public void run() {
                ArticleListViewBinder.this.f13157g.requestLayout();
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListView
    /* JADX INFO: renamed from: a */
    public void mo13472a(Drawable drawable) {
        this.f13155e.setImageDrawable(drawable);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListView
    /* JADX INFO: renamed from: a */
    public void mo13473a(String str) {
        this.f13157g.setTitle(str);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListView
    /* JADX INFO: renamed from: a */
    public void mo13474a(List<ArticleSummary> list, boolean z) {
        this.f13152b.m13461a(list, z);
        this.f13153c.m13704a(z);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.articlelist.ArticleListView
    /* JADX INFO: renamed from: a */
    public void mo13471a(int i) {
        this.f13158h.setVisibility(i == 1 ? 0 : 4);
        this.f13159i.setVisibility(i == 2 ? 0 : 8);
        this.f13160j.setVisibility(i == 3 ? 0 : 8);
        this.f13161k.setVisibility(i == 4 ? 0 : 8);
        if (i == 2 || i == 3) {
            this.f13156f.setExpanded(false);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractView
    /* JADX INFO: renamed from: a */
    public Context mo13409a() {
        return this.f13154d.getContext();
    }
}
