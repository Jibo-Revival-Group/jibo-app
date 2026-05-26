.class public Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;
.super Ljava/lang/Object;
.source "LiveAgentSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

.field protected b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
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

.field protected c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

.field protected d:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

.field protected e:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

.field protected f:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

.field protected g:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

.field private h:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 217
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 225
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/request/InternalLiveAgentRequestFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/request/InternalLiveAgentRequestFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->g:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->h:Landroid/content/Context;

    .line 229
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 234
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
    .locals 6

    .prologue
    .line 263
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->h:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 266
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->h:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/service/common/liveagentclient/R$integer;->salesforce_live_agent_message_retry_timeout_ms:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 268
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    if-nez v1, :cond_0

    .line 269
    new-instance v1, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;-><init>()V

    const-class v2, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    const-class v3, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->a(Ljava/lang/Class;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 272
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    if-nez v1, :cond_1

    .line 273
    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;-><init>()V

    iput-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 276
    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

    if-nez v1, :cond_2

    .line 277
    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->g:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    iget-object v5, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V

    iput-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/handler/CreateSessionHandler;

    .line 281
    :cond_2
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    if-nez v1, :cond_3

    .line 282
    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;-><init>()V

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 283
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->g:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    .line 284
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 285
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 286
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    move-result-object v1

    .line 287
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a(I)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;

    move-result-object v0

    .line 288
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a()Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    .line 291
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    if-nez v0, :cond_4

    .line 292
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->g:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/handler/DeleteSessionHandler;

    .line 295
    :cond_4
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;)V

    return-object v0
.end method
