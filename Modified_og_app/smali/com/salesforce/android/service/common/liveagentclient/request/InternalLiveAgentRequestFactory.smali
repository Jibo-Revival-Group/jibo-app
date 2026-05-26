.class public Lcom/salesforce/android/service/common/liveagentclient/request/InternalLiveAgentRequestFactory;
.super Ljava/lang/Object;
.source "InternalLiveAgentRequestFactory.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;-><init>()V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;
    .locals 3

    .prologue
    .line 41
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public b(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;
    .locals 3

    .prologue
    .line 45
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
