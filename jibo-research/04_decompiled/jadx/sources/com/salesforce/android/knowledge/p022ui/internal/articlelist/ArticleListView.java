package com.salesforce.android.knowledge.p022ui.internal.articlelist;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.AbstractView;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ArticleListView extends AbstractView, ToolbarView {
    /* JADX INFO: renamed from: a */
    void mo13471a(int i);

    /* JADX INFO: renamed from: a */
    void mo13472a(Drawable drawable);

    /* JADX INFO: renamed from: a */
    void mo13473a(String str);

    /* JADX INFO: renamed from: a */
    void mo13474a(List<ArticleSummary> list, boolean z);
}
