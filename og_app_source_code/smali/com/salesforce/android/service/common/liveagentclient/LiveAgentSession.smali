.class public Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
.super Ljava/lang/Object;
.source "LiveAgentSession.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;
.implements Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener",
        "<",
        "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;",
        "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;",
        ">;"
    }
.end annotation


# static fields
.field protected static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected b:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

.field private final d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;",
            ">;"
        }
    .end annotation
.end field

.field private final e:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

.field private final f:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

.field private final g:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

.field private final h:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 67
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;)V
    .locals 2

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 95
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 96
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->e:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 97
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->g:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

    .line 98
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->f:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    .line 99
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->h:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    .line 101
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->Deleting:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;)V

    .line 103
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->e:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 127
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
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
    .line 178
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v0

    .line 179
    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Handling pending request #{}, {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 180
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    invoke-virtual {v1, p1, p2, v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;I)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$1;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;)V

    .line 181
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 180
    return-object v0
.end method

.method public a()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Initiated:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 155
    return-void
.end method

.method public a(I)V
    .locals 1

    .prologue
    .line 166
    if-lez p1, :cond_0

    .line 168
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->f:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a(I)V

    .line 170
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;)V
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 211
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 2

    .prologue
    .line 194
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->Connecting:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-ne p1, v0, :cond_1

    .line 195
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Creating LiveAgent Session..."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 206
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->e:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V

    .line 207
    return-void

    .line 196
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->LongPolling:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-ne p1, v0, :cond_2

    .line 197
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting LiveAgent heartbeat (Long polling, MessagesRequest)"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    goto :goto_0

    .line 198
    :cond_2
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->Deleting:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-ne p1, v0, :cond_3

    .line 199
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending LiveAgent Session"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    goto :goto_0

    .line 200
    :cond_3
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->Ended:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-ne p1, v0, :cond_0

    .line 201
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent Session has ended"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic a(Ljava/lang/Enum;)V
    .locals 0

    .prologue
    .line 60
    check-cast p1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;)V

    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Enum;Ljava/lang/Enum;)V
    .locals 0

    .prologue
    .line 60
    check-cast p1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    check-cast p2, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V

    return-void
.end method

.method public b(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->e:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->b(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 132
    return-object p0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 163
    return-void
.end method
