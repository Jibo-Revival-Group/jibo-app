package com.salesforce.android.knowledge.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticlesResponse {

    @SerializedName(m9428a = "articles")
    List<Article> mArticles;

    @SerializedName(m9428a = "currentPageUrl")
    String mCurrentPageUrl;

    @SerializedName(m9428a = "nextPageUrl")
    String mNextPageUrl;

    @SerializedName(m9428a = "pageNumber")
    int mPageNumber;

    /* JADX INFO: renamed from: a */
    public String m13178a() {
        return this.mNextPageUrl;
    }

    /* JADX INFO: renamed from: b */
    public List<Article> m13179b() {
        return this.mArticles;
    }

    public static class Article {

        @SerializedName(m9428a = "articleNumber")
        String mArticleNumber;

        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
        String mId;

        @SerializedName(m9428a = "lastPublishedDate")
        Date mLastPublishedDate;

        @SerializedName(m9428a = "summary")
        String mSummary;

        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_TITLE)
        String mTitle;

        @SerializedName(m9428a = "url")
        String mUrl;

        @SerializedName(m9428a = "viewCount")
        int mViewCount;

        @SerializedName(m9428a = "viewScore")
        double mViewScore;

        /* JADX INFO: renamed from: a */
        public String m13180a() {
            return this.mId;
        }

        /* JADX INFO: renamed from: b */
        public String m13181b() {
            return this.mArticleNumber;
        }

        /* JADX INFO: renamed from: c */
        public String m13182c() {
            return this.mTitle;
        }

        /* JADX INFO: renamed from: d */
        public String m13183d() {
            return this.mSummary;
        }

        /* JADX INFO: renamed from: e */
        public String m13184e() {
            return this.mUrl;
        }

        /* JADX INFO: renamed from: f */
        public int m13185f() {
            return this.mViewCount;
        }

        /* JADX INFO: renamed from: g */
        public double m13186g() {
            return this.mViewScore;
        }

        /* JADX INFO: renamed from: h */
        public Date m13187h() {
            return this.mLastPublishedDate;
        }
    }
}
