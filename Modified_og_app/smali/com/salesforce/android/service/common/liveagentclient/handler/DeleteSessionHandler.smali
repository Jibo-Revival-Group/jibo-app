.class public Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;
.super Ljava/lang/Object;
.source "DeleteSessionHandler.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/SessionListener;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


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

.field private f:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

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
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 79
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    .line 80
    invoke-virtual {p3, p0}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 81
    iput-object p4, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 82
    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->f:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-nez v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 99
    :goto_0
    return-void

    .line 96
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->f:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;->b(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;

    move-result-object v1

    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/response/LiveAgentStringResponse;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 97
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 98
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->f:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 107
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 2

    .prologue
    .line 111
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler$1;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 119
    :goto_0
    return-void

    .line 113
    :pswitch_0
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->a()V

    goto :goto_0

    .line 116
    :pswitch_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->f:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    goto :goto_0

    .line 111
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
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 131
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
    .line 135
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent session has encountered an error while attempting to delete the session. Ending the session anyway. - {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Ljava/lang/Throwable;)V

    .line 139
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 123
    return-void
.end method
