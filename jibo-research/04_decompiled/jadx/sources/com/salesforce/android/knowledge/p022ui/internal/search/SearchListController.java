package com.salesforce.android.knowledge.p022ui.internal.search;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.util.ListController;
import com.salesforce.android.knowledge.p022ui.internal.views.ArticleItemView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SearchListController extends ListController<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    final SearchPresenter f13384a;

    /* JADX INFO: renamed from: b */
    OnArticleSelectedListener f13385b;

    /* JADX INFO: renamed from: c */
    List<ArticleSummary> f13386c = Collections.emptyList();

    /* JADX INFO: renamed from: d */
    boolean f13387d;

    interface OnArticleSelectedListener {
        /* JADX INFO: renamed from: a */
        void mo13669a(ArticleSummary articleSummary);
    }

    /* JADX INFO: renamed from: a */
    static SearchListController m13661a(SearchPresenter searchPresenter) {
        return new SearchListController(searchPresenter);
    }

    private SearchListController(SearchPresenter searchPresenter) {
        this.f13384a = searchPresenter;
        m13662d();
    }

    /* JADX INFO: renamed from: d */
    private void m13662d() {
        m13706c().setHasStableIds(true);
    }

    /* JADX INFO: renamed from: a */
    void m13663a(OnArticleSelectedListener onArticleSelectedListener) {
        this.f13385b = onArticleSelectedListener;
    }

    /* JADX INFO: renamed from: b */
    void m13667b(OnArticleSelectedListener onArticleSelectedListener) {
        if (this.f13385b == onArticleSelectedListener) {
            this.f13385b = null;
        }
    }

    /* JADX INFO: renamed from: a */
    void m13664a(List<ArticleSummary> list, boolean z) {
        this.f13386c = new ArrayList(list);
        this.f13387d = z;
        m13706c().notifyItemRangeInserted(0, list.size());
    }

    /* JADX INFO: renamed from: b */
    void m13668b(List<ArticleSummary> list, boolean z) {
        int size = this.f13386c.size();
        if (this.f13387d && !z) {
            this.f13387d = false;
            m13706c().notifyItemRemoved(size);
        }
        this.f13386c.addAll(list);
        m13706c().notifyItemRangeInserted(size, list.size());
    }

    /* JADX INFO: renamed from: b */
    void m13666b() {
        int iMo13457a = mo13457a();
        this.f13386c = Collections.emptyList();
        this.f13387d = false;
        m13706c().notifyItemRangeRemoved(0, iMo13457a);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13458a(int i) {
        return i >= this.f13386c.size() ? 1 : 0;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public RecyclerView.ViewHolder mo13459a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.knowledge_article_item, viewGroup, false));
        }
        if (i == 1) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.knowledge_loading_more_items, viewGroup, false));
        }
        throw new IllegalArgumentException("Unknown item type");
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public void mo13460a(RecyclerView.ViewHolder viewHolder, int i) {
        if (mo13458a(i) == 0) {
            final ArticleSummary articleSummary = this.f13386c.get(i);
            Drawable drawableMo13673b = this.f13384a.mo13673b(articleSummary);
            ArticleItemView articleItemView = (ArticleItemView) viewHolder.itemView;
            articleItemView.m13711a(articleSummary, drawableMo13673b);
            articleItemView.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.search.SearchListController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SearchListController.this.f13385b != null) {
                        SearchListController.this.f13385b.mo13669a(articleSummary);
                    }
                }
            });
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: b */
    public long mo13665b(int i) {
        if (mo13458a(i) == 0) {
            return this.f13386c.get(i).mo13217g().hashCode();
        }
        return 0L;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13457a() {
        return (this.f13387d ? 1 : 0) + this.f13386c.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
