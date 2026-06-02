package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ArticleSummaryModel implements ArticleSummary {

    /* JADX INFO: renamed from: a */
    String f12964a;

    /* JADX INFO: renamed from: b */
    String f12965b;

    /* JADX INFO: renamed from: c */
    String f12966c;

    /* JADX INFO: renamed from: d */
    String f12967d;

    /* JADX INFO: renamed from: e */
    String f12968e;

    /* JADX INFO: renamed from: f */
    int f12969f;

    /* JADX INFO: renamed from: g */
    double f12970g;

    /* JADX INFO: renamed from: h */
    Date f12971h;

    ArticleSummaryModel(String str, String str2, String str3, String str4, String str5, int i, double d, Date date) {
        this.f12964a = str;
        this.f12965b = str2;
        this.f12966c = str3;
        this.f12967d = str4;
        this.f12968e = str5;
        this.f12969f = i;
        this.f12970g = d;
        this.f12971h = date;
    }

    /* JADX INFO: renamed from: a */
    static ArticleSummaryModel m13215a(ArticlesResponse.Article article) {
        return new ArticleSummaryModel(article.m13180a(), article.m13181b(), article.m13182c(), article.m13183d(), article.m13184e(), article.m13185f(), article.m13186g(), article.m13187h());
    }

    /* JADX INFO: renamed from: a */
    public static ArticleSummaryModel m13216a(String str, String str2, String str3, String str4, String str5, int i, double d, Date date) {
        return new ArticleSummaryModel(str, str2, str3, str4, str5, i, d, date);
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleSummary
    /* JADX INFO: renamed from: g */
    public String mo13217g() {
        return this.f12964a;
    }

    /* JADX INFO: renamed from: h */
    public String m13218h() {
        return this.f12965b;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleSummary
    /* JADX INFO: renamed from: i */
    public String mo13219i() {
        return this.f12966c;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleSummary
    /* JADX INFO: renamed from: j */
    public String mo13220j() {
        return this.f12967d;
    }

    /* JADX INFO: renamed from: k */
    public String m13221k() {
        return this.f12968e;
    }

    /* JADX INFO: renamed from: l */
    public int m13222l() {
        return this.f12969f;
    }

    /* JADX INFO: renamed from: m */
    public double m13223m() {
        return this.f12970g;
    }

    /* JADX INFO: renamed from: n */
    public Date m13224n() {
        return this.f12971h;
    }

    public String toString() {
        return "ArticleSummary[" + this.f12966c + "]";
    }
}
