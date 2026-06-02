package com.salesforce.android.knowledge.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class ArticlesResponse {
   @SerializedName(a = "articles")
   List<ArticlesResponse.Article> mArticles;
   @SerializedName(a = "currentPageUrl")
   String mCurrentPageUrl;
   @SerializedName(a = "nextPageUrl")
   String mNextPageUrl;
   @SerializedName(a = "pageNumber")
   int mPageNumber;

   public String a() {
      return this.mNextPageUrl;
   }

   public List<ArticlesResponse.Article> b() {
      return this.mArticles;
   }

   public static class Article {
      @SerializedName(a = "articleNumber")
      String mArticleNumber;
      @SerializedName(a = "id")
      String mId;
      @SerializedName(a = "lastPublishedDate")
      Date mLastPublishedDate;
      @SerializedName(a = "summary")
      String mSummary;
      @SerializedName(a = "title")
      String mTitle;
      @SerializedName(a = "url")
      String mUrl;
      @SerializedName(a = "viewCount")
      int mViewCount;
      @SerializedName(a = "viewScore")
      double mViewScore;

      public String a() {
         return this.mId;
      }

      public String b() {
         return this.mArticleNumber;
      }

      public String c() {
         return this.mTitle;
      }

      public String d() {
         return this.mSummary;
      }

      public String e() {
         return this.mUrl;
      }

      public int f() {
         return this.mViewCount;
      }

      public double g() {
         return this.mViewScore;
      }

      public Date h() {
         return this.mLastPublishedDate;
      }
   }
}
