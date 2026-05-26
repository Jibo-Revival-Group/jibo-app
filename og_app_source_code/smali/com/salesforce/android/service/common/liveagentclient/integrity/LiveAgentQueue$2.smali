.class Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;
.super Ljava/lang/Object;
.source "LiveAgentQueue.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

.field final synthetic b:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;->b:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;->b:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a(Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V

    .line 138
    return-void
.end method
