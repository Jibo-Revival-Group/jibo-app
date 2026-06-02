package com.salesforce.android.knowledge.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailsResponse {

    @SerializedName(m9428a = "allViewCount")
    private int mAllViewCount;

    @SerializedName(m9428a = "allViewScore")
    private double mAllViewScore;

    @SerializedName(m9428a = "appDownVoteCount")
    private int mAppDownVoteCount;

    @SerializedName(m9428a = "appUpVoteCount")
    private int mAppUpVoteCount;

    @SerializedName(m9428a = "appViewCount")
    private int mAppViewCount;

    @SerializedName(m9428a = "appViewScore")
    private double mAppViewScore;

    @SerializedName(m9428a = "articleNumber")
    private String mArticleNumber;

    @SerializedName(m9428a = "createdBy")
    private User mCreatedBy;

    @SerializedName(m9428a = "createdDate")
    private Date mCreatedDate;

    @SerializedName(m9428a = "cspDownVoteCount")
    private int mCspDownVoteCount;

    @SerializedName(m9428a = "cspUpVoteCount")
    private int mCspUpVoteCount;

    @SerializedName(m9428a = "cspViewCount")
    private int mCspViewCount;

    @SerializedName(m9428a = "cspViewScore")
    private double mCspViewScore;

    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
    private String mId;

    @SerializedName(m9428a = "lastModifiedBy")
    private User mLastModifiedBy;

    @SerializedName(m9428a = "lastModifiedDate")
    private Date mLastModifiedDate;

    @SerializedName(m9428a = "lastPublishedDate")
    private Date mLastPublishedDate;

    @SerializedName(m9428a = "layoutItems")
    private List<LayoutItem> mLayoutItems;

    @SerializedName(m9428a = "pkbDownVoteCount")
    private int mPkbDownVoteCount;

    @SerializedName(m9428a = "pkbUpVoteCount")
    private int mPkbUpVoteCount;

    @SerializedName(m9428a = "pkbViewCount")
    private int mPkbViewCount;

    @SerializedName(m9428a = "pkbViewScore")
    private double mPkbViewScore;

    @SerializedName(m9428a = "summary")
    private String mSummary;

    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_TITLE)
    private String mTitle;

    @SerializedName(m9428a = "url")
    private String mUrl;

    @SerializedName(m9428a = "versionNumber")
    private int mVersionNumber;

    /* JADX INFO: renamed from: a */
    public int m13155a() {
        return this.mAllViewCount;
    }

    /* JADX INFO: renamed from: b */
    public double m13156b() {
        return this.mAllViewScore;
    }

    /* JADX INFO: renamed from: c */
    public String m13157c() {
        return this.mArticleNumber;
    }

    /* JADX INFO: renamed from: d */
    public User m13158d() {
        return this.mCreatedBy;
    }

    /* JADX INFO: renamed from: e */
    public Date m13159e() {
        return this.mCreatedDate;
    }

    /* JADX INFO: renamed from: f */
    public String m13160f() {
        return this.mId;
    }

    /* JADX INFO: renamed from: g */
    public User m13161g() {
        return this.mLastModifiedBy;
    }

    /* JADX INFO: renamed from: h */
    public Date m13162h() {
        return this.mLastModifiedDate;
    }

    /* JADX INFO: renamed from: i */
    public Date m13163i() {
        return this.mLastPublishedDate;
    }

    /* JADX INFO: renamed from: j */
    public List<LayoutItem> m13164j() {
        return this.mLayoutItems;
    }

    /* JADX INFO: renamed from: k */
    public String m13165k() {
        return this.mSummary;
    }

    /* JADX INFO: renamed from: l */
    public String m13166l() {
        return this.mTitle;
    }

    /* JADX INFO: renamed from: m */
    public String m13167m() {
        return this.mUrl;
    }

    /* JADX INFO: renamed from: n */
    public int m13168n() {
        return this.mVersionNumber;
    }

    public static class User {

        @SerializedName(m9428a = "isActive")
        private boolean mActive;

        @SerializedName(m9428a = "email")
        private String mEmail;

        @SerializedName(m9428a = "firstName")
        private String mFirstName;

        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
        private String mId;

        @SerializedName(m9428a = "lastName")
        private String mLastName;

        @SerializedName(m9428a = "url")
        private String mUrl;

        @SerializedName(m9428a = "userName")
        private String mUsername;

        /* JADX INFO: renamed from: a */
        public String m13173a() {
            return this.mEmail;
        }

        /* JADX INFO: renamed from: b */
        public String m13174b() {
            return this.mFirstName;
        }

        /* JADX INFO: renamed from: c */
        public String m13175c() {
            return this.mId;
        }

        /* JADX INFO: renamed from: d */
        public String m13176d() {
            return this.mLastName;
        }

        /* JADX INFO: renamed from: e */
        public String m13177e() {
            return this.mUsername;
        }
    }

    public static class LayoutItem {

        @SerializedName(m9428a = "label")
        private String mLabel;

        @SerializedName(m9428a = "name")
        private String mName;

        @SerializedName(m9428a = ShareConstants.MEDIA_TYPE)
        private String mType;

        @SerializedName(m9428a = "value")
        private String mValue;

        /* JADX INFO: renamed from: a */
        public String m13169a() {
            return this.mLabel;
        }

        /* JADX INFO: renamed from: b */
        public String m13170b() {
            return this.mName;
        }

        /* JADX INFO: renamed from: c */
        public String m13171c() {
            return this.mType;
        }

        /* JADX INFO: renamed from: d */
        public String m13172d() {
            return this.mValue;
        }
    }
}
