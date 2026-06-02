package com.salesforce.android.knowledge.p022ui;

import com.salesforce.android.knowledge.core.KnowledgeConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeUIConfiguration {

    /* JADX INFO: renamed from: a */
    private final KnowledgeConfiguration f13090a;

    /* JADX INFO: renamed from: b */
    private final String f13091b;

    /* JADX INFO: renamed from: c */
    private KnowledgeImageProvider f13092c;

    /* JADX INFO: renamed from: d */
    private KnowledgeCssProvider f13093d;

    /* JADX INFO: renamed from: e */
    private KnowledgeJsProvider f13094e;

    /* JADX INFO: renamed from: f */
    private String f13095f;

    /* JADX INFO: renamed from: a */
    public static KnowledgeUIConfiguration m13396a(KnowledgeConfiguration knowledgeConfiguration, String str, String str2) {
        return new KnowledgeUIConfiguration(knowledgeConfiguration, str, str2);
    }

    private KnowledgeUIConfiguration(KnowledgeConfiguration knowledgeConfiguration, String str, String str2) {
        this.f13090a = knowledgeConfiguration;
        this.f13095f = str;
        this.f13091b = str2;
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public KnowledgeConfiguration m13397a() {
        return this.f13090a;
    }

    /* JADX INFO: renamed from: b */
    public String m13398b() {
        return this.f13091b;
    }

    /* JADX INFO: renamed from: c */
    public KnowledgeImageProvider m13399c() {
        return this.f13092c;
    }

    /* JADX INFO: renamed from: d */
    public KnowledgeCssProvider m13400d() {
        return this.f13093d;
    }

    /* JADX INFO: renamed from: e */
    public KnowledgeJsProvider m13401e() {
        return this.f13094e;
    }

    /* JADX INFO: renamed from: f */
    public String m13402f() {
        return this.f13095f;
    }
}
