.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/request/InternalLiveAgentLoggingRequestFactory;
.super Ljava/lang/Object;
.source "InternalLiveAgentLoggingRequestFactory.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;Ljava/util/List;)Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;)",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;"
        }
    .end annotation

    .prologue
    .line 44
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2, p2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    return-object v0
.end method
