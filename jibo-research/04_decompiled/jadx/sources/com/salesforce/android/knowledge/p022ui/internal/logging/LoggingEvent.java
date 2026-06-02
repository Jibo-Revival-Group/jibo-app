package com.salesforce.android.knowledge.p022ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

/* JADX INFO: loaded from: classes.dex */
abstract class LoggingEvent extends BaseEvent {

    @SerializedName(m9428a = "kbBasicInfo")
    final KbBasicInfo mKbBasicInfo;

    LoggingEvent(KbBasicInfo kbBasicInfo, String str) {
        super("KB", str);
        this.mKbBasicInfo = kbBasicInfo;
    }

    static abstract class EventTypeEvent extends LoggingEvent {

        @SerializedName(m9428a = "eventType")
        final String mEventType;

        EventTypeEvent(KbBasicInfo kbBasicInfo, String str, String str2) {
            super(kbBasicInfo, str);
            this.mEventType = str2;
        }
    }

    @BatchedEvent(m13878a = "knowledgeEvents")
    static class KnowledgeEvent extends EventTypeEvent {
        KnowledgeEvent(KbBasicInfo kbBasicInfo, String str, String str2) {
            super(kbBasicInfo, str, str2);
        }
    }

    @BatchedEvent(m13878a = "dataCategoryEvents")
    static class DataCategoryEvent extends EventTypeEvent {

        @SerializedName(m9428a = "dataCategoryName")
        final String mCategoryName;

        DataCategoryEvent(KbBasicInfo kbBasicInfo, String str, String str2, String str3) {
            super(kbBasicInfo, str, str2);
            this.mCategoryName = str3;
        }
    }

    @BatchedEvent(m13878a = "articleEvents")
    static class ArticleEvent extends EventTypeEvent {

        @SerializedName(m9428a = "articleId")
        final String mArticleId;

        @SerializedName(m9428a = "articleName")
        final String mArticleName;

        @SerializedName(m9428a = "parentCategory")
        final String mParentCategory;

        ArticleEvent(KbBasicInfo kbBasicInfo, String str, String str2, String str3, String str4, String str5) {
            super(kbBasicInfo, str, str2);
            this.mParentCategory = str3;
            this.mArticleId = str4;
            this.mArticleName = str5;
        }
    }

    @BatchedEvent(m13878a = "categoryEvents")
    static class CategoryEvent extends EventTypeEvent {

        @SerializedName(m9428a = "categoryName")
        final String mCategoryName;

        @SerializedName(m9428a = "parentCategory")
        final String mParentCategory;

        CategoryEvent(KbBasicInfo kbBasicInfo, String str, String str2, String str3, String str4) {
            super(kbBasicInfo, str, str2);
            this.mCategoryName = str3;
            this.mParentCategory = str4;
        }
    }

    @BatchedEvent(m13878a = "viewStateEvents")
    static class ViewStateEvent extends LoggingEvent {

        @SerializedName(m9428a = "articleId")
        final String mArticleId;

        @SerializedName(m9428a = "articleName")
        final String mArticleName;

        @SerializedName(m9428a = "state")
        final String mState;

        ViewStateEvent(KbBasicInfo kbBasicInfo, String str, String str2, String str3, String str4) {
            super(kbBasicInfo, str);
            this.mState = str2;
            this.mArticleId = str3;
            this.mArticleName = str4;
        }
    }

    @BatchedEvent(m13878a = "articleListEvents")
    static class ArticleListEvent extends EventTypeEvent {

        @SerializedName(m9428a = "currentView")
        final String mCurrentView;

        @SerializedName(m9428a = "dataCategory")
        final String mDataCategory;

        @SerializedName(m9428a = "previousView")
        final String mPreviousView;

        ArticleListEvent(KbBasicInfo kbBasicInfo, String str, String str2, String str3, String str4, String str5) {
            super(kbBasicInfo, str, str2);
            this.mCurrentView = str3;
            this.mPreviousView = str4;
            this.mDataCategory = str5;
        }
    }

    @BatchedEvent(m13878a = "searchEvents")
    static class SearchEvent extends LoggingEvent {
        SearchEvent(KbBasicInfo kbBasicInfo, String str) {
            super(kbBasicInfo, str);
        }
    }
}
