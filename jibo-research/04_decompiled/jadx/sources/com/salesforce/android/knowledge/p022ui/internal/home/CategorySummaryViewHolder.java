package com.salesforce.android.knowledge.p022ui.internal.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.views.ArticleItemView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class CategorySummaryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a */
    final LayoutInflater f13240a;

    /* JADX INFO: renamed from: b */
    final HomePresenter f13241b;

    /* JADX INFO: renamed from: c */
    final LinearLayout f13242c;

    /* JADX INFO: renamed from: d */
    final View f13243d;

    /* JADX INFO: renamed from: e */
    final View f13244e;

    /* JADX INFO: renamed from: a */
    public static CategorySummaryViewHolder m13553a(View view, LayoutInflater layoutInflater, HomePresenter homePresenter) {
        return new CategorySummaryViewHolder(view, layoutInflater, homePresenter);
    }

    private CategorySummaryViewHolder(View view, LayoutInflater layoutInflater, HomePresenter homePresenter) {
        super(view);
        this.f13243d = view.findViewById(R.id.knowledge_empty_category);
        this.f13242c = (LinearLayout) view.findViewById(R.id.knowledge_category_article_summary_list);
        this.f13244e = view.findViewById(R.id.knowledge_category_show_more_container);
        this.f13240a = layoutInflater;
        this.f13241b = homePresenter;
    }

    /* JADX INFO: renamed from: a */
    public void m13554a(final DataCategoryInfo dataCategoryInfo, ArticleList articleList) {
        List<ArticleSummary> listMo13212a = articleList.mo13212a();
        boolean zIsEmpty = listMo13212a.isEmpty();
        boolean zMo13214c = articleList.mo13214c();
        this.f13243d.setVisibility(zIsEmpty ? 0 : 8);
        this.f13242c.setVisibility(zIsEmpty ? 8 : 0);
        this.f13244e.setVisibility(zMo13214c ? 0 : 8);
        this.f13244e.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.CategorySummaryViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CategorySummaryViewHolder.this.f13241b.mo13566b(dataCategoryInfo);
            }
        });
        this.f13242c.removeAllViews();
        for (final ArticleSummary articleSummary : listMo13212a) {
            ArticleItemView articleItemView = (ArticleItemView) this.f13240a.inflate(R.layout.knowledge_article_item, (ViewGroup) this.f13242c, false);
            articleItemView.m13711a(articleSummary, this.f13241b.mo13565b(articleSummary));
            articleItemView.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.CategorySummaryViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CategorySummaryViewHolder.this.f13241b.mo13563a(articleSummary);
                }
            });
            this.f13242c.addView(articleItemView);
        }
    }
}
