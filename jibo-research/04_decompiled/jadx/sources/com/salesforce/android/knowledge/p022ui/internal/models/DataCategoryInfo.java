package com.salesforce.android.knowledge.p022ui.internal.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryInfo implements DataCategorySummary {

    /* JADX INFO: renamed from: a */
    private final String f13363a;

    /* JADX INFO: renamed from: b */
    private final String f13364b;

    /* JADX INFO: renamed from: c */
    private final int f13365c;

    /* JADX INFO: renamed from: d */
    private final int f13366d;

    /* JADX INFO: renamed from: e */
    private final KnowledgeImageProvider f13367e;

    /* JADX INFO: renamed from: a */
    public static DataCategoryInfo m13620a(DataCategorySummary dataCategorySummary, int i, KnowledgeImageProvider knowledgeImageProvider) {
        return new DataCategoryInfo(dataCategorySummary, i, knowledgeImageProvider);
    }

    protected DataCategoryInfo(DataCategorySummary dataCategorySummary, int i, KnowledgeImageProvider knowledgeImageProvider) {
        this.f13363a = dataCategorySummary.mo13245a();
        this.f13364b = dataCategorySummary.mo13246b();
        this.f13365c = dataCategorySummary.mo13247c();
        this.f13366d = i;
        this.f13367e = knowledgeImageProvider;
    }

    protected DataCategoryInfo() {
        this.f13363a = null;
        this.f13364b = null;
        this.f13365c = 0;
        this.f13366d = 0;
        this.f13367e = null;
    }

    /* JADX INFO: renamed from: d */
    public int m13622d() {
        return this.f13366d;
    }

    /* JADX INFO: renamed from: a */
    public Drawable m13621a(Context context) {
        return this.f13367e.mo13355a(context, this);
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: b */
    public String mo13246b() {
        return this.f13364b;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: a */
    public String mo13245a() {
        return this.f13363a;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: c */
    public int mo13247c() {
        return this.f13365c;
    }
}
