package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.categorydetail.CategoryDetailViewHolder;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.util.ListController;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class CategoryDetailListController extends ListController<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    private boolean f13179a = false;

    /* JADX INFO: renamed from: b */
    private final List<ArticleSummary> f13180b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private final List<DataCategoryInfo> f13181c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private final CategoryDetailPresenter f13182d;

    /* JADX INFO: renamed from: a */
    static CategoryDetailListController m13497a(CategoryDetailPresenter categoryDetailPresenter) {
        return new CategoryDetailListController(categoryDetailPresenter);
    }

    private CategoryDetailListController(CategoryDetailPresenter categoryDetailPresenter) {
        this.f13182d = categoryDetailPresenter;
    }

    /* JADX INFO: renamed from: a */
    void m13499a(List<ArticleSummary> list) {
        m13706c().notifyItemRangeRemoved(0, this.f13180b.size());
        this.f13180b.clear();
        this.f13180b.addAll(list);
        m13706c().notifyItemRangeInserted(0, list.size());
    }

    /* JADX INFO: renamed from: a */
    void m13500a(boolean z) {
        if (this.f13179a && !z) {
            this.f13179a = false;
            m13706c().notifyItemRangeRemoved(this.f13180b.size(), 1);
        } else if (!this.f13179a && z) {
            this.f13179a = true;
            m13706c().notifyItemRangeInserted(this.f13180b.size(), 1);
        }
    }

    /* JADX INFO: renamed from: b */
    void m13501b(List<DataCategoryInfo> list) {
        if (list.size() != 0) {
            this.f13181c.addAll(list);
            m13706c().notifyItemRangeInserted(m13498b() - 1, list.size() + 1);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public RecyclerView.ViewHolder mo13459a(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 0:
                return CategoryDetailViewHolder.m13520a(this.f13182d, layoutInflaterFrom, viewGroup);
            case 1:
                return new CategoryDetailViewHolder.MoreArticles(this.f13182d, layoutInflaterFrom.inflate(R.layout.knowledge_cd_showmore_item, viewGroup, false));
            case 2:
                return new CategoryDetailViewHolder.SubCategories(this.f13182d, layoutInflaterFrom.inflate(R.layout.knowledge_cd_category_header, viewGroup, false));
            case 3:
                return CategoryDetailViewHolder.m13521b(this.f13182d, layoutInflaterFrom, viewGroup);
            default:
                throw new IllegalArgumentException("Unknown viewType");
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13458a(int i) {
        if (i < this.f13180b.size()) {
            return 0;
        }
        if (i == this.f13180b.size() && this.f13179a) {
            return 1;
        }
        if (i == this.f13180b.size() || (i == this.f13180b.size() + 1 && this.f13179a)) {
            return 2;
        }
        return 3;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public void mo13460a(RecyclerView.ViewHolder viewHolder, int i) {
        switch (mo13458a(i)) {
            case 0:
                ((CategoryDetailViewHolder.Article) viewHolder).m13523a(this.f13180b.get(i));
                break;
            case 3:
                ((CategoryDetailViewHolder.Category) viewHolder).m13523a(this.f13181c.get(i - m13498b()));
                break;
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13457a() {
        int size = this.f13180b.size() + this.f13181c.size();
        if (this.f13179a) {
            size++;
        }
        if (this.f13181c.size() > 0) {
            return size + 1;
        }
        return size;
    }

    /* JADX INFO: renamed from: b */
    private int m13498b() {
        return this.f13179a ? this.f13180b.size() + 2 : this.f13180b.size() + 1;
    }
}
