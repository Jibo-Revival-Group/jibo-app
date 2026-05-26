.class public Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;
.super Ljava/lang/Object;
.source "CreateSessionResponse.java"


# instance fields
.field private mAffinityToken:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "affinityToken"
    .end annotation
.end field

.field private mClientPollingTimeoutSeconds:J
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "clientPollTimeout"
    .end annotation
.end field

.field private mSessionId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "id"
    .end annotation
.end field

.field private mSessionKey:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "key"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->mSessionId:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->mAffinityToken:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->mSessionKey:Ljava/lang/String;

    return-object v0
.end method

.method public d()J
    .locals 4

    .prologue
    .line 61
    iget-wide v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->mClientPollingTimeoutSeconds:J

    const-wide/16 v2, 0x3e8

    mul-long/2addr v0, v2

    return-wide v0
.end method
