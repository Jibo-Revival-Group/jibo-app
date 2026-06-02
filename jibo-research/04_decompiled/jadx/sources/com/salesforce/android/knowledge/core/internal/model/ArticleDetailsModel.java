package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticleDetailsResponse;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ChatterUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailsModel extends ArticleSummaryModel implements ArticleDetails {

    /* JADX INFO: renamed from: i */
    private final List<ArticleDetails.Field> f12951i;

    /* JADX INFO: renamed from: j */
    private final int f12952j;

    /* JADX INFO: renamed from: k */
    private final Date f12953k;

    /* JADX INFO: renamed from: l */
    private final Date f12954l;

    /* JADX INFO: renamed from: m */
    private final ChatterUserModel f12955m;

    /* JADX INFO: renamed from: n */
    private final ChatterUserModel f12956n;

    ArticleDetailsModel(String str, String str2, String str3, String str4, String str5, int i, double d, Date date, int i2, Date date2, Date date3, ChatterUserModel chatterUserModel, ChatterUserModel chatterUserModel2, List<FieldModel> list) {
        super(str, str2, str3, str4, str5, i, d, date);
        this.f12952j = i2;
        this.f12953k = date2;
        this.f12954l = date3;
        this.f12955m = chatterUserModel;
        this.f12956n = chatterUserModel2;
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        this.f12951i = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public static ArticleDetailsModel m13196a(ArticleDetailsResponse articleDetailsResponse) {
        ArrayList arrayList = new ArrayList(articleDetailsResponse.m13164j().size());
        Iterator<ArticleDetailsResponse.LayoutItem> it = articleDetailsResponse.m13164j().iterator();
        while (it.hasNext()) {
            arrayList.add(FieldModel.m13204a(it.next()));
        }
        return new ArticleDetailsModel(articleDetailsResponse.m13160f(), articleDetailsResponse.m13157c(), articleDetailsResponse.m13166l(), articleDetailsResponse.m13165k(), articleDetailsResponse.m13167m(), articleDetailsResponse.m13155a(), articleDetailsResponse.m13156b(), articleDetailsResponse.m13163i(), articleDetailsResponse.m13168n(), articleDetailsResponse.m13159e(), articleDetailsResponse.m13162h(), ChatterUserModel.m13225a(articleDetailsResponse.m13158d()), ChatterUserModel.m13225a(articleDetailsResponse.m13161g()), arrayList);
    }

    /* JADX INFO: renamed from: a */
    public static ArticleDetailsModel m13197a(String str, String str2, String str3, String str4, String str5, int i, double d, Date date, int i2, Date date2, Date date3, ChatterUserModel chatterUserModel, ChatterUserModel chatterUserModel2, List<FieldModel> list) {
        return new ArticleDetailsModel(str, str2, str3, str4, str5, i, d, date, i2, date2, date3, chatterUserModel, chatterUserModel2, list);
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: a */
    public int mo13198a() {
        return this.f12952j;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: b */
    public Date mo13199b() {
        return this.f12953k;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: c */
    public Date mo13200c() {
        return this.f12954l;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: d */
    public ChatterUser mo13201d() {
        return this.f12955m;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: e */
    public ChatterUser mo13202e() {
        return this.f12956n;
    }

    @Override // com.salesforce.android.knowledge.core.model.ArticleDetails
    /* JADX INFO: renamed from: f */
    public List<ArticleDetails.Field> mo13203f() {
        return this.f12951i;
    }

    public static class FieldModel implements ArticleDetails.Field {

        /* JADX INFO: renamed from: a */
        private final String f12957a;

        /* JADX INFO: renamed from: b */
        private final String f12958b;

        /* JADX INFO: renamed from: c */
        private final String f12959c;

        /* JADX INFO: renamed from: d */
        private final int f12960d;

        FieldModel(String str, String str2, String str3, int i) {
            this.f12957a = str;
            this.f12958b = str2;
            this.f12959c = str3;
            this.f12960d = i;
        }

        /* JADX INFO: renamed from: a */
        public static FieldModel m13204a(ArticleDetailsResponse.LayoutItem layoutItem) {
            int i;
            i = 1;
            switch (layoutItem.m13171c()) {
                case "TEXT":
                    break;
                case "TEXT_AREA":
                    i = 2;
                    break;
                case "LONG_TEXT_AREA":
                    i = 3;
                    break;
                case "RICH_TEXT_AREA":
                    i = 4;
                    break;
                default:
                    i = 0;
                    break;
            }
            return new FieldModel(layoutItem.m13169a(), layoutItem.m13170b(), layoutItem.m13172d(), i);
        }

        /* JADX INFO: renamed from: a */
        public static FieldModel m13205a(String str, String str2, String str3, int i) {
            return new FieldModel(str, str2, str3, i);
        }

        @Override // com.salesforce.android.knowledge.core.model.ArticleDetails.Field
        /* JADX INFO: renamed from: a */
        public String mo13206a() {
            return this.f12957a;
        }

        @Override // com.salesforce.android.knowledge.core.model.ArticleDetails.Field
        /* JADX INFO: renamed from: b */
        public String mo13207b() {
            return this.f12958b;
        }

        @Override // com.salesforce.android.knowledge.core.model.ArticleDetails.Field
        /* JADX INFO: renamed from: c */
        public String mo13208c() {
            return this.f12959c;
        }

        @Override // com.salesforce.android.knowledge.core.model.ArticleDetails.Field
        /* JADX INFO: renamed from: d */
        public int mo13209d() {
            return this.f12960d;
        }
    }
}
