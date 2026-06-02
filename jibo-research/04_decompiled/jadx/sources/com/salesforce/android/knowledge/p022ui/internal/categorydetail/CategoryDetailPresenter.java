package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter;

/* JADX INFO: loaded from: classes.dex */
public interface CategoryDetailPresenter extends ToolbarPresenter<CategoryDetailView> {
    /* JADX INFO: renamed from: a */
    void mo13502a();

    /* JADX INFO: renamed from: a */
    void mo13503a(ArticleSummary articleSummary);

    /* JADX INFO: renamed from: a */
    void mo13504a(DataCategoryInfo dataCategoryInfo);

    /* JADX INFO: renamed from: b */
    Drawable mo13505b(ArticleSummary articleSummary);
}
