package com.salesforce.android.knowledge.p022ui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider;

/* JADX INFO: loaded from: classes.dex */
public class ImageProviderWrapper implements KnowledgeImageProvider {

    /* JADX INFO: renamed from: a */
    private final KnowledgeImageProvider f13099a;

    private ImageProviderWrapper(KnowledgeImageProvider knowledgeImageProvider) {
        this.f13099a = knowledgeImageProvider;
    }

    /* JADX INFO: renamed from: a */
    public static ImageProviderWrapper m13411a(KnowledgeImageProvider knowledgeImageProvider) {
        return new ImageProviderWrapper(knowledgeImageProvider);
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider
    /* JADX INFO: renamed from: a */
    public Drawable mo13354a(Context context, ArticleSummary articleSummary) {
        Drawable drawableMo13354a = null;
        if (this.f13099a != null) {
            drawableMo13354a = this.f13099a.mo13354a(context, articleSummary);
        }
        if (drawableMo13354a != null) {
            return drawableMo13354a.getConstantState().newDrawable().mutate();
        }
        return drawableMo13354a;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider
    /* JADX INFO: renamed from: a */
    public Drawable mo13355a(Context context, DataCategorySummary dataCategorySummary) {
        Drawable drawableMo13355a = null;
        if (this.f13099a != null) {
            drawableMo13355a = this.f13099a.mo13355a(context, dataCategorySummary);
        }
        if (drawableMo13355a != null) {
            return drawableMo13355a.getConstantState().newDrawable().mutate();
        }
        return drawableMo13355a;
    }
}
