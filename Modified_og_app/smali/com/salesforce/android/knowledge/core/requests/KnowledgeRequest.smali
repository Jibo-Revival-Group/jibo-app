.class public abstract Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;
.source "KnowledgeRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;
    }
.end annotation


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 42
    return-void
.end method
