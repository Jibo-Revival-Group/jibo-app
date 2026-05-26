.class Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$1;
.super Ljava/lang/Object;
.source "LiveAgentSession.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$1;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 1
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
    .line 183
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$1;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    iget-object v0, v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 184
    return-void
.end method
