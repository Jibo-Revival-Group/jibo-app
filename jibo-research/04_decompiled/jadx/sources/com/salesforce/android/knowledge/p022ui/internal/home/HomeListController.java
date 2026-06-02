package com.salesforce.android.knowledge.p022ui.internal.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.util.ListController;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class HomeListController extends ListController<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    List<Object> f13252a = new LinkedList();

    /* JADX INFO: renamed from: b */
    private final LayoutInflater f13253b;

    /* JADX INFO: renamed from: c */
    private final HomePresenter f13254c;

    /* JADX INFO: renamed from: a */
    static HomeListController m13556a(LayoutInflater layoutInflater, HomePresenter homePresenter) {
        return new HomeListController(layoutInflater, homePresenter);
    }

    private HomeListController(LayoutInflater layoutInflater, HomePresenter homePresenter) {
        this.f13253b = layoutInflater;
        this.f13254c = homePresenter;
    }

    /* JADX INFO: renamed from: a */
    public void m13559a(List<DataCategoryInfo> list) {
        this.f13252a.clear();
        this.f13252a.addAll(list);
        m13706c().notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public Optional<Integer> m13557a(DataCategoryInfo dataCategoryInfo) {
        int iIndexOf = this.f13252a.indexOf(dataCategoryInfo);
        return iIndexOf == -1 ? Optional.m14094a() : Optional.m14095a(Integer.valueOf(iIndexOf));
    }

    /* JADX INFO: renamed from: a_ */
    public boolean m13560a_(int i) {
        return i < this.f13252a.size();
    }

    /* JADX INFO: renamed from: a */
    public void m13558a(DataCategoryInfo dataCategoryInfo, final ArticleList articleList) {
        if (articleList != null) {
            m13557a(dataCategoryInfo).m14096a(new Consumer<Integer>() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeListController.1
                @Override // com.salesforce.android.service.common.utilities.functional.Consumer
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo13033a(Integer num) {
                    int iIntValue = num.intValue() + 1;
                    HomeListController.this.f13252a.add(iIntValue, articleList);
                    HomeListController.this.m13706c().notifyItemRangeInserted(iIntValue, 1);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public void m13561b(DataCategoryInfo dataCategoryInfo) {
        m13557a(dataCategoryInfo).m14096a(new Consumer<Integer>() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeListController.2
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(Integer num) {
                int iIntValue = num.intValue() + 1;
                if (HomeListController.this.m13560a_(iIntValue) && HomeListController.this.mo13458a(iIntValue) == 2) {
                    HomeListController.this.f13252a.remove(iIntValue);
                    HomeListController.this.m13706c().notifyItemRangeRemoved(iIntValue, 1);
                }
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public RecyclerView.ViewHolder mo13459a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return CategoryHeaderViewHolder.m13549a(this.f13253b.inflate(R.layout.knowledge_home_category_item, viewGroup, false), this.f13254c);
            case 2:
                return CategorySummaryViewHolder.m13553a(this.f13253b.inflate(R.layout.knowledge_home_category_summary, viewGroup, false), this.f13253b, this.f13254c);
            default:
                throw new IllegalArgumentException("Unknown viewType");
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public void mo13460a(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 1) {
            CategoryHeaderViewHolder categoryHeaderViewHolder = (CategoryHeaderViewHolder) viewHolder;
            categoryHeaderViewHolder.m13551a(categoryHeaderViewHolder.m13550a(), (DataCategoryInfo) this.f13252a.get(i));
        } else if (viewHolder.getItemViewType() == 2) {
            ((CategorySummaryViewHolder) viewHolder).m13554a((DataCategoryInfo) this.f13252a.get(i - 1), (ArticleList) this.f13252a.get(i));
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13458a(int i) {
        Object obj = this.f13252a.get(i);
        if (obj instanceof DataCategoryInfo) {
            return 1;
        }
        if (obj instanceof ArticleList) {
            return 2;
        }
        throw new IllegalStateException("Item does not exist at position " + i);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ListController
    /* JADX INFO: renamed from: a */
    public int mo13457a() {
        return this.f13252a.size();
    }
}
