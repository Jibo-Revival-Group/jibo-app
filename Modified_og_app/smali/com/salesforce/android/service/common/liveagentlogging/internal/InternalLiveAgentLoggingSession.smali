.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;
.super Ljava/lang/Object;
.source "InternalLiveAgentLoggingSession.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
.implements Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;
    }
.end annotation


# static fields
.field private static final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected final a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

.field private final c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

.field private final d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

.field private final e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

.field private final f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

.field private final g:I

.field private h:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;",
            ">;"
        }
    .end annotation
.end field

.field private i:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;"
        }
    .end annotation
.end field

.field private j:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

.field private k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 84
    const-class v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;)V
    .locals 2

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->h:Ljava/util/Set;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    .line 111
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    .line 112
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

    .line 113
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a()Lcom/salesforce/android/service/common/utilities/threading/Timer;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    .line 114
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 115
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->c()I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->g:I

    .line 116
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a(Z)Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a()Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    .line 117
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->h:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 180
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;",
            ">;"
        }
    .end annotation

    .prologue
    .line 147
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->j:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-nez v0, :cond_1

    .line 148
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Unable to send logging events without an active LiveAgent session."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 149
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 174
    :goto_0
    return-object v0

    .line 150
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 151
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "There are no queued logging events to send."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 152
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0

    .line 156
    :cond_2
    monitor-enter p0

    .line 157
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 158
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 159
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b()V

    .line 160
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 162
    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Sending {} queued events [LiveAgent Session ID - {}]"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 163
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    invoke-virtual {v5}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->a()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 162
    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 164
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    invoke-interface {v1, v2, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;Ljava/util/List;)Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    move-result-object v1

    .line 166
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    const-class v2, Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 167
    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;

    invoke-direct {v2, p0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;)V

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 173
    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    goto :goto_0

    .line 160
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 5

    .prologue
    .line 234
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Connected to a new Live Agent session {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->a()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 235
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->j:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    .line 236
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 238
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->j:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->b()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a(I)V

    .line 239
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->j:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;)V

    .line 241
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->h:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;

    .line 242
    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;->c()V

    goto :goto_0

    .line 244
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 124
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Queuing a Logging Event: {}"

    new-array v2, v5, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v5, :cond_1

    .line 128
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a()V

    .line 132
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->g:I

    if-lt v0, v1, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 211
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->h:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;

    .line 212
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    goto :goto_0

    .line 214
    :cond_0
    return-void
.end method

.method public a(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 135
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Batch queueing {} events"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 139
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a()V

    .line 144
    :cond_0
    :goto_0
    return-void

    .line 141
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->g:I

    if-lt v0, v1, :cond_0

    .line 142
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 221
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->k:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-eqz v0, :cond_0

    .line 222
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 226
    :goto_0
    return-void

    .line 224
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Unable to flush via timer. LiveAgent session is not active."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 198
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Tearing down the Live Agent Logging session."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 199
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a()V

    .line 200
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->b(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    .line 201
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->c()V

    .line 202
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b()V

    .line 203
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 204
    return-void
.end method

.method public d()V
    .locals 2

    .prologue
    .line 248
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;->a()V

    .line 249
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->h:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;

    .line 250
    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;->d()V

    goto :goto_0

    .line 252
    :cond_0
    return-void
.end method
