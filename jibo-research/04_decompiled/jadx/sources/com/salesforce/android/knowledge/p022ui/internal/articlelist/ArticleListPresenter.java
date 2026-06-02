package com.salesforce.android.knowledge.p022ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarPresenter;

/* JADX INFO: loaded from: classes.dex */
public interface ArticleListPresenter extends ToolbarPresenter<ArticleListView> {
    /* JADX INFO: renamed from: a */
    void mo13462a();

    /* JADX INFO: renamed from: a */
    void mo13463a(ArticleSummary articleSummary);

    /* JADX INFO: renamed from: b */
    Drawable mo13464b(ArticleSummary articleSummary);
}
