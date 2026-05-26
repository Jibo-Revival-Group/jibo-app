.class public Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CommunitiesListRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;
    }
.end annotation


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 41
    return-void
.end method
