package com.salesforce.android.knowledge.p022ui.internal.articlelist;

import android.content.Context;
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
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleListController extends ListController<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    final ArticleListPresenter f13135a;

    /* JADX INFO: renamed from: b */
    private final List<ArticleSummary> f13136b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private final Context f13137c;

    /* JADX INFO: renamed from: d */
    private boolean f13138d;

    ArticleListController(Context context, ArticleListPresenter articleListPresenter) {
        this.f13137c = context;
        this.f13135a = articleListPresenter;
    }

    /* JADX INFO: renamed from: a */
    void m13461a(List<ArticleSummary> list, boolean z) {
        int size = this.f13136b.size();
        this.f13136b.addAll(list);
        int size2 = list.size();
        if (z && !this.f13138d) {
            size2++;
            this.f13138d = true;
        } else if (!z && this.f13138d) {
            m13706c().notifyItemRemoved(size);
            this.f13138d = false;
        }
        m13706c().notifyItemRangeInserted(size, size2);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13458a(int i) {
        return i == this.f13136b.size() ? 1 : 0;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public RecyclerView.ViewHolder mo13459a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ViewHolder(LayoutInflater.from(this.f13137c).inflate(R.layout.knowledge_article_item, viewGroup, false));
        }
        if (i == 1) {
            return new ViewHolder(LayoutInflater.from(this.f13137c).inflate(R.layout.knowledge_loading_more_items, viewGroup, false));
        }
        throw new IllegalArgumentException("Unknown item type");
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public void mo13460a(RecyclerView.ViewHolder viewHolder, int i) {
        if (mo13458a(i) == 0) {
            final ArticleSummary articleSummary = this.f13136b.get(i);
            Drawable drawableMo13464b = this.f13135a.mo13464b(articleSummary);
            ArticleItemView articleItemView = (ArticleItemView) viewHolder.itemView;
            articleItemView.m13711a(articleSummary, drawableMo13464b);
            articleItemView.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.articlelist.ArticleListController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ArticleListController.this.f13135a.mo13463a(articleSummary);
                }
            });
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13457a() {
        return (this.f13138d ? 1 : 0) + this.f13136b.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
