package com.salesforce.android.knowledge.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class ArticleDetailsResponse {
   @SerializedName(a = "allViewCount")
   private int mAllViewCount;
   @SerializedName(a = "allViewScore")
   private double mAllViewScore;
   @SerializedName(a = "appDownVoteCount")
   private int mAppDownVoteCount;
   @SerializedName(a = "appUpVoteCount")
   private int mAppUpVoteCount;
   @SerializedName(a = "appViewCount")
   private int mAppViewCount;
   @SerializedName(a = "appViewScore")
   private double mAppViewScore;
   @SerializedName(a = "articleNumber")
   private String mArticleNumber;
   @SerializedName(a = "createdBy")
   private ArticleDetailsResponse.User mCreatedBy;
   @SerializedName(a = "createdDate")
   private Date mCreatedDate;
   @SerializedName(a = "cspDownVoteCount")
   private int mCspDownVoteCount;
   @SerializedName(a = "cspUpVoteCount")
   private int mCspUpVoteCount;
   @SerializedName(a = "cspViewCount")
   private int mCspViewCount;
   @SerializedName(a = "cspViewScore")
   private double mCspViewScore;
   @SerializedName(a = "id")
   private String mId;
   @SerializedName(a = "lastModifiedBy")
   private ArticleDetailsResponse.User mLastModifiedBy;
   @SerializedName(a = "lastModifiedDate")
   private Date mLastModifiedDate;
   @SerializedName(a = "lastPublishedDate")
   private Date mLastPublishedDate;
   @SerializedName(a = "layoutItems")
   private List<ArticleDetailsResponse.LayoutItem> mLayoutItems;
   @SerializedName(a = "pkbDownVoteCount")
   private int mPkbDownVoteCount;
   @SerializedName(a = "pkbUpVoteCount")
   private int mPkbUpVoteCount;
   @SerializedName(a = "pkbViewCount")
   private int mPkbViewCount;
   @SerializedName(a = "pkbViewScore")
   private double mPkbViewScore;
   @SerializedName(a = "summary")
   private String mSummary;
   @SerializedName(a = "title")
   private String mTitle;
   @SerializedName(a = "url")
   private String mUrl;
   @SerializedName(a = "versionNumber")
   private int mVersionNumber;

   public int a() {
      return this.mAllViewCount;
   }

   public double b() {
      return this.mAllViewScore;
   }

   public String c() {
      return this.mArticleNumber;
   }

   public ArticleDetailsResponse.User d() {
      return this.mCreatedBy;
   }

   public Date e() {
      return this.mCreatedDate;
   }

   public String f() {
      return this.mId;
   }

   public ArticleDetailsResponse.User g() {
      return this.mLastModifiedBy;
   }

   public Date h() {
      return this.mLastModifiedDate;
   }

   public Date i() {
      return this.mLastPublishedDate;
   }

   public List<ArticleDetailsResponse.LayoutItem> j() {
      return this.mLayoutItems;
   }

   public String k() {
      return this.mSummary;
   }

   public String l() {
      return this.mTitle;
   }

   public String m() {
      return this.mUrl;
   }

   public int n() {
      return this.mVersionNumber;
   }

   public static class LayoutItem {
      @SerializedName(a = "label")
      private String mLabel;
      @SerializedName(a = "name")
      private String mName;
      @SerializedName(a = "type")
      private String mType;
      @SerializedName(a = "value")
      private String mValue;

      public String a() {
         return this.mLabel;
      }

      public String b() {
         return this.mName;
      }

      public String c() {
         return this.mType;
      }

      public String d() {
         return this.mValue;
      }
   }

   public static class User {
      @SerializedName(a = "isActive")
      private boolean mActive;
      @SerializedName(a = "email")
      private String mEmail;
      @SerializedName(a = "firstName")
      private String mFirstName;
      @SerializedName(a = "id")
      private String mId;
      @SerializedName(a = "lastName")
      private String mLastName;
      @SerializedName(a = "url")
      private String mUrl;
      @SerializedName(a = "userName")
      private String mUsername;

      public String a() {
         return this.mEmail;
      }

      public String b() {
         return this.mFirstName;
      }

      public String c() {
         return this.mId;
      }

      public String d() {
         return this.mLastName;
      }

      public String e() {
         return this.mUsername;
      }
   }
}
