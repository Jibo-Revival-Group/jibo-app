package com.salesforce.android.knowledge.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

abstract class LoggingEvent extends BaseEvent {
   @SerializedName(a = "kbBasicInfo")
   final KbBasicInfo mKbBasicInfo;

   LoggingEvent(KbBasicInfo var1, String var2) {
      super("KB", var2);
      this.mKbBasicInfo = var1;
   }

   @BatchedEvent(a = "articleEvents")
   static class ArticleEvent extends LoggingEvent.EventTypeEvent {
      @SerializedName(a = "articleId")
      final String mArticleId;
      @SerializedName(a = "articleName")
      final String mArticleName;
      @SerializedName(a = "parentCategory")
      final String mParentCategory;

      ArticleEvent(KbBasicInfo var1, String var2, String var3, String var4, String var5, String var6) {
         super(var1, var2, var3);
         this.mParentCategory = var4;
         this.mArticleId = var5;
         this.mArticleName = var6;
      }
   }

   @BatchedEvent(a = "articleListEvents")
   static class ArticleListEvent extends LoggingEvent.EventTypeEvent {
      @SerializedName(a = "currentView")
      final String mCurrentView;
      @SerializedName(a = "dataCategory")
      final String mDataCategory;
      @SerializedName(a = "previousView")
      final String mPreviousView;

      ArticleListEvent(KbBasicInfo var1, String var2, String var3, String var4, String var5, String var6) {
         super(var1, var2, var3);
         this.mCurrentView = var4;
         this.mPreviousView = var5;
         this.mDataCategory = var6;
      }
   }

   @BatchedEvent(a = "categoryEvents")
   static class CategoryEvent extends LoggingEvent.EventTypeEvent {
      @SerializedName(a = "categoryName")
      final String mCategoryName;
      @SerializedName(a = "parentCategory")
      final String mParentCategory;

      CategoryEvent(KbBasicInfo var1, String var2, String var3, String var4, String var5) {
         super(var1, var2, var3);
         this.mCategoryName = var4;
         this.mParentCategory = var5;
      }
   }

   @BatchedEvent(a = "dataCategoryEvents")
   static class DataCategoryEvent extends LoggingEvent.EventTypeEvent {
      @SerializedName(a = "dataCategoryName")
      final String mCategoryName;

      DataCategoryEvent(KbBasicInfo var1, String var2, String var3, String var4) {
         super(var1, var2, var3);
         this.mCategoryName = var4;
      }
   }

   abstract static class EventTypeEvent extends LoggingEvent {
      @SerializedName(a = "eventType")
      final String mEventType;

      EventTypeEvent(KbBasicInfo var1, String var2, String var3) {
         super(var1, var2);
         this.mEventType = var3;
      }
   }

   @BatchedEvent(a = "knowledgeEvents")
   static class KnowledgeEvent extends LoggingEvent.EventTypeEvent {
      KnowledgeEvent(KbBasicInfo var1, String var2, String var3) {
         super(var1, var2, var3);
      }
   }

   @BatchedEvent(a = "searchEvents")
   static class SearchEvent extends LoggingEvent {
      SearchEvent(KbBasicInfo var1, String var2) {
         super(var1, var2);
      }
   }

   @BatchedEvent(a = "viewStateEvents")
   static class ViewStateEvent extends LoggingEvent {
      @SerializedName(a = "articleId")
      final String mArticleId;
      @SerializedName(a = "articleName")
      final String mArticleName;
      @SerializedName(a = "state")
      final String mState;

      ViewStateEvent(KbBasicInfo var1, String var2, String var3, String var4, String var5) {
         super(var1, var2);
         this.mState = var3;
         this.mArticleId = var4;
         this.mArticleName = var5;
      }
   }
}
