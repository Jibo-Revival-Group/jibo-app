package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.views.ArticleItemView;

/* JADX INFO: loaded from: classes.dex */
public abstract class CategoryDetailViewHolder<T> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a */
    T f13209a;

    /* JADX INFO: renamed from: b */
    private final CategoryDetailPresenter f13210b;

    /* JADX INFO: renamed from: a */
    static Article m13520a(CategoryDetailPresenter categoryDetailPresenter, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new Article(categoryDetailPresenter, (ArticleItemView) layoutInflater.inflate(R.layout.knowledge_article_item, viewGroup, false));
    }

    /* JADX INFO: renamed from: b */
    static Category m13521b(CategoryDetailPresenter categoryDetailPresenter, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new Category(categoryDetailPresenter, layoutInflater.inflate(R.layout.knowledge_cd_category_item, viewGroup, false));
    }

    CategoryDetailViewHolder(CategoryDetailPresenter categoryDetailPresenter, View view) {
        super(view);
        this.f13210b = categoryDetailPresenter;
    }

    /* JADX INFO: renamed from: a */
    CategoryDetailPresenter m13522a() {
        return this.f13210b;
    }

    /* JADX INFO: renamed from: a */
    void m13523a(T t) {
        this.f13209a = t;
        mo13525c();
    }

    /* JADX INFO: renamed from: b */
    T m13524b() {
        return this.f13209a;
    }

    /* JADX INFO: renamed from: c */
    void mo13525c() {
    }

    static class Article extends CategoryDetailViewHolder<ArticleSummary> implements View.OnClickListener {

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ boolean f13211b;

        static {
            f13211b = !CategoryDetailViewHolder.class.desiredAssertionStatus();
        }

        Article(CategoryDetailPresenter categoryDetailPresenter, ArticleItemView articleItemView) {
            super(categoryDetailPresenter, articleItemView);
            articleItemView.setOnClickListener(this);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailViewHolder
        /* JADX INFO: renamed from: c */
        void mo13525c() {
            ArticleSummary articleSummaryB = m13524b();
            if (!f13211b && articleSummaryB == null) {
                throw new AssertionError();
            }
            ((ArticleItemView) this.itemView).m13711a(articleSummaryB, m13522a().mo13505b(articleSummaryB));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m13522a().mo13503a(m13524b());
        }
    }

    static class MoreArticles extends CategoryDetailViewHolder<Void> implements View.OnClickListener {
        public MoreArticles(CategoryDetailPresenter categoryDetailPresenter, View view) {
            super(categoryDetailPresenter, view);
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m13522a().mo13502a();
        }
    }

    static class SubCategories extends CategoryDetailViewHolder<Void> {
        public SubCategories(CategoryDetailPresenter categoryDetailPresenter, View view) {
            super(categoryDetailPresenter, view);
        }
    }

    static class Category extends CategoryDetailViewHolder<DataCategoryInfo> implements View.OnClickListener {

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ boolean f13212b;

        static {
            f13212b = !CategoryDetailViewHolder.class.desiredAssertionStatus();
        }

        public Category(CategoryDetailPresenter categoryDetailPresenter, View view) {
            super(categoryDetailPresenter, view);
            view.setOnClickListener(this);
        }

        @Override // com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailViewHolder
        /* JADX INFO: renamed from: c */
        void mo13525c() {
            DataCategoryInfo dataCategoryInfoB = m13524b();
            if (!f13212b && dataCategoryInfoB == null) {
                throw new AssertionError();
            }
            ((TextView) this.itemView.findViewById(R.id.knowledge_category_category_label)).setText(dataCategoryInfoB.mo13246b());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m13522a().mo13504a(m13524b());
        }
    }
}
