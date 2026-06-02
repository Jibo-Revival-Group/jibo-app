package com.salesforce.android.knowledge.p022ui.internal.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.search.SearchListController;
import com.salesforce.android.knowledge.p022ui.internal.util.InfiniteScrollListener;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceTextWatcher;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchViewBinder extends ViewBinder implements SearchListController.OnArticleSelectedListener, SearchView, InfiniteScrollListener.BehaviorListener, SalesforceTextWatcher.OnAfterTextChangedListener {

    /* JADX INFO: renamed from: a */
    private final InputMethodManager f13400a;

    /* JADX INFO: renamed from: b */
    private final SearchPresenter f13401b;

    /* JADX INFO: renamed from: c */
    private final SearchListController f13402c;

    /* JADX INFO: renamed from: d */
    private final SalesforceTextWatcher f13403d = new SalesforceTextWatcher();

    /* JADX INFO: renamed from: e */
    private InfiniteScrollListener f13404e;

    /* JADX INFO: renamed from: f */
    private View f13405f;

    /* JADX INFO: renamed from: g */
    private EditText f13406g;

    /* JADX INFO: renamed from: h */
    private View f13407h;

    /* JADX INFO: renamed from: i */
    private View f13408i;

    /* JADX INFO: renamed from: j */
    private View f13409j;

    /* JADX INFO: renamed from: k */
    private View f13410k;

    /* JADX INFO: renamed from: l */
    private RecyclerView f13411l;

    /* JADX INFO: renamed from: a */
    public static SearchViewBinder m13683a(SearchPresenter searchPresenter, InputMethodManager inputMethodManager) {
        return new SearchViewBinder(searchPresenter, SearchListController.m13661a(searchPresenter), inputMethodManager);
    }

    private SearchViewBinder(SearchPresenter searchPresenter, SearchListController searchListController, InputMethodManager inputMethodManager) {
        this.f13401b = searchPresenter;
        this.f13402c = searchListController;
        this.f13400a = inputMethodManager;
        this.f13403d.m14008a(this);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13405f = layoutInflater.inflate(R.layout.knowledge_fragment_search, viewGroup, false);
        m13685a(this.f13405f);
        this.f13402c.m13663a(this);
        this.f13401b.mo13443b(this);
        if (bundle == null) {
            this.f13406g.requestFocus();
            this.f13400a.toggleSoftInput(2, 0);
        }
        return this.f13405f;
    }

    /* JADX INFO: renamed from: a */
    void m13685a(View view) {
        this.f13406g = (EditText) view.findViewById(R.id.knowledge_search_input);
        this.f13407h = view.findViewById(R.id.knowledge_search_help);
        this.f13408i = view.findViewById(R.id.knowledge_search_empty);
        this.f13409j = view.findViewById(R.id.knowledge_error);
        this.f13410k = view.findViewById(R.id.knowledge_indeterminate_progress);
        this.f13411l = (RecyclerView) view.findViewById(R.id.knowledge_search_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mo13409a());
        this.f13404e = InfiniteScrollListener.m13699a(linearLayoutManager).m13702a(2).m13703a(this);
        this.f13411l.setLayoutManager(linearLayoutManager);
        this.f13411l.setAdapter(this.f13402c.m13706c());
        this.f13411l.addOnScrollListener(this.f13404e);
        this.f13406g.addTextChangedListener(this.f13403d);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13414a(Bundle bundle) {
        super.mo13414a(bundle);
        bundle.putParcelable("layout_manager_state", this.f13411l.getLayoutManager().mo4310d());
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13418b(Bundle bundle) {
        super.mo13418b(bundle);
        if (!bundle.isEmpty()) {
            this.f13411l.getLayoutManager().mo4293a(bundle.getParcelable("layout_manager_state"));
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: b */
    public void mo13417b() {
        this.f13411l.stopScroll();
        this.f13401b.mo13440a(this);
        this.f13402c.m13667b(this);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchView
    /* JADX INFO: renamed from: a */
    public void mo13680a(List<ArticleSummary> list, boolean z) {
        this.f13402c.m13664a(list, z);
        this.f13404e.m13704a(z);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchView
    /* JADX INFO: renamed from: b */
    public void mo13681b(List<ArticleSummary> list, boolean z) {
        this.f13402c.m13668b(list, z);
        this.f13404e.m13704a(z);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchView
    /* JADX INFO: renamed from: c */
    public void mo13682c() {
        this.f13402c.m13666b();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchView
    /* JADX INFO: renamed from: a */
    public void mo13678a(int i) {
        this.f13411l.setVisibility(i == 2 ? 0 : 4);
        this.f13407h.setVisibility(i == 0 ? 0 : 8);
        this.f13408i.setVisibility(i == 1 ? 0 : 8);
        this.f13409j.setVisibility(i == 3 ? 0 : 8);
        this.f13410k.setVisibility(i != 4 ? 8 : 0);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.search.SearchView
    /* JADX INFO: renamed from: a */
    public void mo13679a(CharSequence charSequence) {
        this.f13406g.setText(charSequence);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.AbstractView
    /* JADX INFO: renamed from: a */
    public Context mo13409a() {
        return this.f13405f.getContext();
    }

    @Override // com.salesforce.android.knowledge.ui.internal.util.InfiniteScrollListener.BehaviorListener
    /* JADX INFO: renamed from: s_ */
    public void mo13478s_() {
        this.f13401b.mo13670a();
    }

    @Override // com.salesforce.android.knowledge.ui.internal.search.SearchListController.OnArticleSelectedListener
    /* JADX INFO: renamed from: a */
    public void mo13669a(ArticleSummary articleSummary) {
        m13684f();
        this.f13401b.mo13671a(articleSummary);
    }

    @Override // com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher.OnAfterTextChangedListener
    /* JADX INFO: renamed from: a */
    public void mo12805a(Editable editable) {
        this.f13401b.mo13672a((CharSequence) editable);
    }

    /* JADX INFO: renamed from: f */
    private void m13684f() {
        this.f13400a.hideSoftInputFromWindow(this.f13406g.getWindowToken(), 0);
    }
}
