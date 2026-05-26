.class public Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
.super Ljava/lang/Object;
.source "MessagesHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

.field protected b:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

.field protected c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

.field protected d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
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

.field protected e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

.field protected f:I

.field protected g:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 228
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 235
    const/16 v0, 0x14

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->f:I

    .line 236
    const/16 v0, 0x7d0

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->g:I

    return-void
.end method


# virtual methods
.method public a(I)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    .locals 0

    .prologue
    .line 269
    iput p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->g:I

    .line 270
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    .locals 0

    .prologue
    .line 239
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->a:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    .line 240
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->c:Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;

    .line 250
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    .locals 0

    .prologue
    .line 244
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->b:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequestFactory;

    .line 245
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;",
            "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;",
            ">;)",
            "Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;"
        }
    .end annotation

    .prologue
    .line 254
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->d:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    .line 255
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    if-nez v0, :cond_0

    .line 276
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    .line 279
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler;-><init>(Lcom/salesforce/android/service/common/liveagentclient/handler/MessagesHandler$Builder;)V

    return-object v0
.end method
