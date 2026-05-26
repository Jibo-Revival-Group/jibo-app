.class public Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;
.super Ljava/lang/Object;
.source "LiveAgentQueue.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;
    }
.end annotation


# static fields
.field protected static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected b:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;

.field private final d:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

.field private e:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

.field private f:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;)V
    .locals 1

    .prologue
    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v0}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    .line 75
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 82
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;->b(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;->b()Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->c:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;

    .line 83
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->b:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    .line 84
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

    .line 85
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 106
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Queuing: {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 107
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    move-result-object v0

    .line 108
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 109
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d()V

    .line 110
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->c()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public a()V
    .locals 5

    .prologue
    .line 97
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Clearing LiveAgentQueue and cancelling {} queued requests."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v4}, Ljava/util/Queue;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->c:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;->b()V

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    .line 100
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->e()V

    goto :goto_0

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 103
    return-void
.end method

.method a(Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V
    .locals 4

    .prologue
    .line 153
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    .line 154
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->c()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 155
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Success in sending {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 156
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e()V

    .line 157
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

    .line 93
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d()V

    .line 94
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 173
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e()V

    .line 174
    return-void
.end method

.method b(Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V
    .locals 4

    .prologue
    .line 161
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->d()V

    .line 162
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Error occurred while sending {}. Scheduling another attempt."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->c:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;->a()V

    .line 164
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method d()V
    .locals 4

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 145
    :cond_0
    :goto_0
    return-void

    .line 131
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 133
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->b:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->element()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    .line 134
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->e:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->a()Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;

    move-result-object v2

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->b()Ljava/lang/Class;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$2;-><init>(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V

    .line 135
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$1;-><init>(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;)V

    .line 140
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method e()V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 149
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->d()V

    .line 150
    return-void
.end method
