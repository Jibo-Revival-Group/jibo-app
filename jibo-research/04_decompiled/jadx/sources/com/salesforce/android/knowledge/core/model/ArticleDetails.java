package com.salesforce.android.knowledge.core.model;

import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ArticleDetails extends ArticleSummary {

    public interface Field {
        /* JADX INFO: renamed from: a */
        String mo13206a();

        /* JADX INFO: renamed from: b */
        String mo13207b();

        /* JADX INFO: renamed from: c */
        String mo13208c();

        /* JADX INFO: renamed from: d */
        int mo13209d();
    }

    /* JADX INFO: renamed from: a */
    int mo13198a();

    /* JADX INFO: renamed from: b */
    Date mo13199b();

    /* JADX INFO: renamed from: c */
    Date mo13200c();

    /* JADX INFO: renamed from: d */
    ChatterUser mo13201d();

    /* JADX INFO: renamed from: e */
    ChatterUser mo13202e();

    /* JADX INFO: renamed from: f */
    List<Field> mo13203f();
}
