.class public Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;
.super Ljava/lang/Object;
.source "CreateSessionHandler.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/SessionListener;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$Handler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/liveagentclient/SessionListener;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$Handler",
        "<",
        "Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

.field private final c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

.field private final d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

.field private final e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
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

.field private f:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;",
            "Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 80
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    .line 81
    invoke-virtual {p3, p0}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 82
    iput-object p4, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 83
    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 90
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->f:Z

    if-nez v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    invoke-interface {v1}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;->a()Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;

    move-result-object v1

    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 92
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 94
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->f:Z

    .line 102
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 2

    .prologue
    .line 106
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler$1;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 114
    :goto_0
    return-void

    .line 108
    :pswitch_0
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->a()V

    goto :goto_0

    .line 111
    :pswitch_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->f:Z

    goto :goto_0

    .line 106
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

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
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->ConnectionEstablished:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 136
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;",
            ")V"
        }
    .end annotation

    .prologue
    .line 125
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 126
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->a()Ljava/lang/String;

    move-result-object v1

    .line 127
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->c()Ljava/lang/String;

    move-result-object v2

    .line 128
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->b()Ljava/lang/String;

    move-result-object v3

    .line 129
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;->d()J

    move-result-wide v4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 130
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V

    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->SessionInfoReceived:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 132
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 49
    check-cast p2, Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentclient/response/CreateSessionResponse;)V

    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 4
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
    .line 139
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent session has encountered an error while creating a session - {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 141
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Ljava/lang/Throwable;)V

    .line 142
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 118
    return-void
.end method
