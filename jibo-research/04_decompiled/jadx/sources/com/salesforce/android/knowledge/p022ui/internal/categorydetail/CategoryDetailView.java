package com.salesforce.android.knowledge.p022ui.internal.categorydetail;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.internal.AbstractView;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CategoryDetailView extends AbstractView, ToolbarView {
    /* JADX INFO: renamed from: a */
    void mo13514a(int i);

    /* JADX INFO: renamed from: a */
    void mo13515a(Drawable drawable);

    /* JADX INFO: renamed from: a */
    void mo13516a(String str);

    /* JADX INFO: renamed from: a */
    void mo13517a(List<ArticleSummary> list, List<DataCategoryInfo> list2, boolean z);
}
