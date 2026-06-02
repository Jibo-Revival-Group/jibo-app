package com.salesforce.android.knowledge.p022ui.internal.home;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter;

/* JADX INFO: loaded from: classes.dex */
public interface HomePresenter extends Presenter<HomeView> {
    /* JADX INFO: renamed from: a */
    void mo13562a();

    /* JADX INFO: renamed from: a */
    void mo13563a(ArticleSummary articleSummary);

    /* JADX INFO: renamed from: a */
    void mo13564a(DataCategoryInfo dataCategoryInfo);

    /* JADX INFO: renamed from: b */
    Drawable mo13565b(ArticleSummary articleSummary);

    /* JADX INFO: renamed from: b */
    void mo13566b(DataCategoryInfo dataCategoryInfo);

    /* JADX INFO: renamed from: c */
    boolean mo13567c(DataCategoryInfo dataCategoryInfo);

    /* JADX INFO: renamed from: d */
    void mo13568d();
}
