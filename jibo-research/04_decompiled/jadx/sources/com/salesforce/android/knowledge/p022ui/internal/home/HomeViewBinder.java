package com.salesforce.android.knowledge.p022ui.internal.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HomeViewBinder extends ViewBinder implements HomeView {

    /* JADX INFO: renamed from: a */
    final HomePresenter f13276a;

    /* JADX INFO: renamed from: b */
    final HomeListController f13277b;

    /* JADX INFO: renamed from: c */
    View f13278c;

    /* JADX INFO: renamed from: d */
    View f13279d;

    /* JADX INFO: renamed from: e */
    View f13280e;

    /* JADX INFO: renamed from: f */
    View f13281f;

    /* JADX INFO: renamed from: g */
    RecyclerView f13282g;

    /* JADX INFO: renamed from: a */
    static HomeViewBinder m13582a(HomePresenter homePresenter, HomeListController homeListController) {
        return new HomeViewBinder(homePresenter, homeListController);
    }

    /* JADX INFO: renamed from: a */
    public static HomeViewBinder m13581a(Context context, HomePresenter homePresenter) {
        return m13582a(homePresenter, HomeListController.m13556a(LayoutInflater.from(context), homePresenter));
    }

    private HomeViewBinder(HomePresenter homePresenter, HomeListController homeListController) {
        this.f13276a = homePresenter;
        this.f13277b = homeListController;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13278c = layoutInflater.inflate(R.layout.knowledge_fragment_home, viewGroup, false);
        m13584a(this.f13278c);
        this.f13276a.mo13443b(this);
        return this.f13278c;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13417b() {
        this.f13282g.stopScroll();
        this.f13276a.mo13440a(this);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13414a(Bundle bundle) {
        super.mo13414a(bundle);
        bundle.putParcelable("layout_manager_state", this.f13282g.getLayoutManager().mo4310d());
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13418b(Bundle bundle) {
        super.mo13418b(bundle);
        if (!bundle.isEmpty()) {
            this.f13282g.getLayoutManager().mo4293a(bundle.getParcelable("layout_manager_state"));
        }
    }

    /* JADX INFO: renamed from: a */
    void m13584a(View view) {
        this.f13279d = view.findViewById(R.id.knowledge_indeterminate_progress);
        this.f13282g = (RecyclerView) view.findViewById(R.id.knowledge_category_list);
        this.f13280e = view.findViewById(R.id.knowledge_error);
        this.f13281f = view.findViewById(R.id.knowledge_network_error);
        view.findViewById(R.id.knowledge_home_close).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeViewBinder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                HomeViewBinder.this.f13276a.mo13562a();
            }
        });
        view.findViewById(R.id.knowledge_home_search).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeViewBinder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                HomeViewBinder.this.f13276a.mo13568d();
            }
        });
        this.f13282g.setLayoutManager(new ScrollToTopLayoutManager(view.getContext()));
        this.f13282g.setAdapter(this.f13277b.m13706c());
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: e */
    public int mo13420e() {
        return android.R.color.transparent;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomeView
    /* JADX INFO: renamed from: a */
    public void mo13577a(int i) {
        this.f13279d.setVisibility(i == 0 ? 0 : 8);
        this.f13282g.setVisibility(i == 1 ? 0 : 4);
        this.f13280e.setVisibility(i == 3 ? 0 : 8);
        this.f13281f.setVisibility(i != 4 ? 8 : 0);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomeView
    /* JADX INFO: renamed from: a */
    public void mo13580a(List<DataCategoryInfo> list) {
        this.f13277b.m13559a(list);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomeView
    /* JADX INFO: renamed from: a */
    public void mo13579a(final DataCategoryInfo dataCategoryInfo, final ArticleList articleList) {
        this.f13277b.m13557a(dataCategoryInfo).m14096a(new Consumer<Integer>() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeViewBinder.3
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(Integer num) {
                HomeViewBinder.this.m13583a(num.intValue(), true);
                HomeViewBinder.this.f13277b.m13558a(dataCategoryInfo, articleList);
                HomeViewBinder.this.f13282g.scrollToPosition(num.intValue());
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.home.HomeView
    /* JADX INFO: renamed from: a */
    public void mo13578a(final DataCategoryInfo dataCategoryInfo) {
        this.f13277b.m13557a(dataCategoryInfo).m14096a(new Consumer<Integer>() { // from class: com.salesforce.android.knowledge.ui.internal.home.HomeViewBinder.4
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(Integer num) {
                HomeViewBinder.this.m13583a(num.intValue(), false);
                HomeViewBinder.this.f13277b.m13561b(dataCategoryInfo);
            }
        });
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractView
    /* JADX INFO: renamed from: a */
    public Context mo13409a() {
        return this.f13278c.getContext();
    }

    /* JADX INFO: renamed from: a */
    void m13583a(int i, boolean z) {
        CategoryHeaderViewHolder categoryHeaderViewHolder = (CategoryHeaderViewHolder) this.f13282g.findViewHolderForAdapterPosition(i);
        if (categoryHeaderViewHolder != null) {
            categoryHeaderViewHolder.m13552a(z);
        }
    }
}
