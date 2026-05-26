.class Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;
.super Ljava/lang/Object;
.source "InternalLiveAgentLoggingSession.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

.field final synthetic b:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    iget-object v0, v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    const-class v2, Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 170
    return-void
.end method
