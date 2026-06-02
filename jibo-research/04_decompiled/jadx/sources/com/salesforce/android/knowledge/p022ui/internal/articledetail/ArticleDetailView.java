package com.salesforce.android.knowledge.p022ui.internal.articledetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.p022ui.internal.AbstractView;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarView;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
interface ArticleDetailView extends AbstractView, ToolbarView {
    /* JADX INFO: renamed from: a */
    Async<Void> mo13451a(KnowledgeUIClient knowledgeUIClient, ArticleDetails articleDetails);

    /* JADX INFO: renamed from: a */
    void mo13452a(int i);

    /* JADX INFO: renamed from: a */
    void mo13453a(Drawable drawable);

    /* JADX INFO: renamed from: a */
    void mo13454a(String str);
}
