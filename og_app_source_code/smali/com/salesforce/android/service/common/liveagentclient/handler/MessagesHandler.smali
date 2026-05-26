.class public Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;
.super Ljava/lang/Object;
.source "MessagesHandler.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/SessionListener;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$Handler;
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/liveagentclient/SessionListener;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$Handler",
        "<",
        "Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;",
        ">;",
        "Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;"
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

.field private final f:I

.field private final g:Lcom/salesforce/android/service/common/utilities/threading/Timer;

.field private h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

.field private i:Z

.field private j:I

.field private k:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;)V
    .locals 4

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 88
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->b:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    .line 89
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 90
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 91
    iget v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->g:I

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->f:I

    .line 92
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    iget v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->f:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(J)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a()Lcom/salesforce/android/service/common/utilities/threading/Timer;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->g:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    .line 93
    iget v0, p1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->f:I

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->j:I

    .line 94
    return-void
.end method


# virtual methods
.method a()V
    .locals 6

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->c:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 111
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;

    move-result-object v1

    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 113
    invoke-virtual {v3}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->d()J

    move-result-wide v4

    .line 110
    invoke-virtual {v0, v1, v2, v4, v5}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;J)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 114
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 116
    :cond_0
    return-void
.end method

.method public a(I)V
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->f:I

    div-int v0, p1, v0

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->j:I

    .line 106
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 124
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 2

    .prologue
    .line 128
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$1;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 136
    :goto_0
    return-void

    .line 130
    :pswitch_0
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a()V

    goto :goto_0

    .line 133
    :pswitch_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->h:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    goto :goto_0

    .line 128
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method a(Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;)V
    .locals 5

    .prologue
    .line 217
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->i:Z

    if-eqz v0, :cond_0

    .line 218
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent session has encountered an error while creating a session - {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;->b()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 219
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 220
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    new-instance v1, Ljava/lang/Exception;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;->b()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Ljava/lang/Throwable;)V

    .line 222
    :cond_0
    return-void
.end method

.method a(Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;)V
    .locals 4

    .prologue
    .line 201
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;->b()Ljava/lang/String;

    move-result-object v0

    .line 203
    if-nez v0, :cond_0

    .line 204
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Failed to switch to a different LiveAgent Server: Address is null."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 205
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 214
    :goto_0
    return-void

    .line 209
    :cond_0
    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Switching to a different LiveAgent Server: {}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 210
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->ConnectionEstablished:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 165
    const/4 v0, 0x0

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->k:I

    .line 166
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a()V

    .line 167
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;",
            ")V"
        }
    .end annotation

    .prologue
    .line 148
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent heartbeat response (MessagesResponse) has been received"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 150
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;

    .line 151
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a()Ljava/lang/String;

    move-result-object v2

    const-string v3, "SwitchServer"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 153
    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;

    invoke-virtual {v0, v2}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a(Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;)V

    goto :goto_0

    .line 154
    :cond_1
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a()Ljava/lang/String;

    move-result-object v2

    const-string v3, "AsyncResult"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 156
    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;

    invoke-virtual {v0, v2}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a(Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;)V

    goto :goto_0

    .line 160
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;)V

    .line 161
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 54
    check-cast p2, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;)V

    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 6
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
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 170
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e()Ljava/lang/Enum;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->LongPolling:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-eq v0, v1, :cond_0

    .line 185
    :goto_0
    return-void

    .line 175
    :cond_0
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->k:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->k:I

    .line 177
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->k:I

    iget v1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->j:I

    if-le v0, v1, :cond_1

    .line 178
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent session has encountered an unrecoverable error while retrieving messages - {}"

    new-array v2, v5, [Ljava/lang/Object;

    aput-object p2, v2, v4

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 179
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->e:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a()V

    .line 180
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->d:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 182
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgent session is attempting to reconnect. Retry #{} of {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    iget v3, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->k:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    iget v3, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->j:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 183
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->g:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a()V

    goto :goto_0
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 140
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 193
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;->a()V

    .line 194
    return-void
.end method
