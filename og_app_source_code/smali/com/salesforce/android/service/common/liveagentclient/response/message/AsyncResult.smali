.class public Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;
.super Ljava/lang/Object;
.source "AsyncResult.java"


# instance fields
.field private mErrorMessage:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "error"
    .end annotation
.end field

.field private mIsSuccess:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "isSuccess"
    .end annotation
.end field


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;->mErrorMessage:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;->mErrorMessage:Ljava/lang/String;

    return-object v0
.end method
