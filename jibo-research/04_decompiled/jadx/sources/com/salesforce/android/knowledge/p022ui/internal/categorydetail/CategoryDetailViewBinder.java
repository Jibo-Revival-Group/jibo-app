package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

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
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.util.DividerDecoration;
import com.salesforce.android.knowledge.p022ui.internal.util.ScrollPositionListener;
import com.salesforce.android.knowledge.p022ui.internal.views.TintedCollapsingToolbarLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CategoryDetailViewBinder extends ToolbarViewBinder implements CategoryDetailView {

    /* JADX INFO: renamed from: a */
    protected TintedCollapsingToolbarLayout f13194a;

    /* JADX INFO: renamed from: b */
    private final CategoryDetailPresenter f13195b;

    /* JADX INFO: renamed from: c */
    private final CategoryDetailListController f13196c;

    /* JADX INFO: renamed from: d */
    private final ScrollPositionListener f13197d;

    /* JADX INFO: renamed from: e */
    private AppBarLayout f13198e;

    /* JADX INFO: renamed from: f */
    private ImageView f13199f;

    /* JADX INFO: renamed from: g */
    private View f13200g;

    /* JADX INFO: renamed from: h */
    private RecyclerView f13201h;

    /* JADX INFO: renamed from: i */
    private View f13202i;

    /* JADX INFO: renamed from: j */
    private View f13203j;

    /* JADX INFO: renamed from: k */
    private View f13204k;

    /* JADX INFO: renamed from: a */
    public static CategoryDetailViewBinder m13518a(CategoryDetailPresenter categoryDetailPresenter) {
        return new CategoryDetailViewBinder(categoryDetailPresenter, CategoryDetailListController.m13497a(categoryDetailPresenter), new ScrollPositionListener());
    }

    private CategoryDetailViewBinder(CategoryDetailPresenter categoryDetailPresenter, CategoryDetailListController categoryDetailListController, ScrollPositionListener scrollPositionListener) {
        super(categoryDetailPresenter);
        this.f13195b = categoryDetailPresenter;
        this.f13196c = categoryDetailListController;
        this.f13197d = scrollPositionListener;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13200g = layoutInflater.inflate(R.layout.knowledge_fragment_category_detail, viewGroup, false);
        m13519a(this.f13200g);
        this.f13195b.mo13443b(this);
        return this.f13200g;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13417b() {
        this.f13201h.stopScroll();
        this.f13195b.mo13440a(this);
    }

    /* JADX INFO: renamed from: a */
    void m13519a(View view) {
        this.f13198e = (AppBarLayout) view.findViewById(R.id.knowledge_category_detail_app_bar_layout);
        this.f13194a = (TintedCollapsingToolbarLayout) view.findViewById(R.id.knowledge_category_detail_collapse_toolbar);
        this.f13199f = (ImageView) view.findViewById(R.id.knowledge_category_detail_header_image);
        this.f13201h = (RecyclerView) view.findViewById(R.id.knowledge_category_detail_body);
        this.f13202i = view.findViewById(R.id.knowledge_indeterminate_progress);
        this.f13203j = view.findViewById(R.id.knowledge_empty_category);
        this.f13204k = view.findViewById(R.id.knowledge_error);
        this.f13201h.addItemDecoration(new DividerDecoration(ContextCompat.m1832a(view.getContext(), R.drawable.knowledge_background_border)));
        this.f13201h.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f13201h.setAdapter(this.f13196c.m13706c());
        this.f13201h.addOnScrollListener(this.f13197d);
        this.f13194a.post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailViewBinder.1
            @Override // java.lang.Runnable
            public void run() {
                CategoryDetailViewBinder.this.f13194a.requestLayout();
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarViewBinder, com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: d */
    public Toolbar mo13419d() {
        return (Toolbar) this.f13200g.findViewById(R.id.knowledge_category_detail_toolbar);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13414a(Bundle bundle) {
        super.mo13414a(bundle);
        bundle.putParcelable("layout_manager_state", this.f13201h.getLayoutManager().mo4310d());
        this.f13197d.m13708a(bundle);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13418b(Bundle bundle) {
        super.mo13418b(bundle);
        if (!bundle.isEmpty()) {
            final Parcelable parcelable = bundle.getParcelable("layout_manager_state");
            this.f13197d.m13710b(bundle);
            if (this.f13197d.m13709b() > 0) {
                this.f13198e.m420a(false, false);
            }
            final RecyclerView recyclerView = this.f13201h;
            recyclerView.post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.categorydetail.CategoryDetailViewBinder.2
                @Override // java.lang.Runnable
                public void run() {
                    recyclerView.getLayoutManager().mo4293a(parcelable);
                }
            });
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailView
    /* JADX INFO: renamed from: a */
    public void mo13514a(int i) {
        this.f13202i.setVisibility(i == 0 ? 0 : 8);
        this.f13201h.setVisibility(i == 1 ? 0 : 4);
        this.f13203j.setVisibility(i == 2 ? 0 : 8);
        this.f13204k.setVisibility(i == 3 ? 0 : 8);
        if (this.f13201h.getVisibility() != 0) {
            this.f13198e.setExpanded(false);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailView
    /* JADX INFO: renamed from: a */
    public void mo13517a(List<ArticleSummary> list, List<DataCategoryInfo> list2, boolean z) {
        this.f13196c.m13499a(list);
        this.f13196c.m13501b(list2);
        this.f13196c.m13500a(z);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailView
    /* JADX INFO: renamed from: a */
    public void mo13515a(Drawable drawable) {
        this.f13199f.setImageDrawable(drawable);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailView
    /* JADX INFO: renamed from: a */
    public void mo13516a(String str) {
        this.f13194a.setTitle(str);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractView
    /* JADX INFO: renamed from: a */
    public Context mo13409a() {
        return this.f13200g.getContext();
    }
}
