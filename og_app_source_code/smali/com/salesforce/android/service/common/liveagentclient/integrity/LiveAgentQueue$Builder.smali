.class public Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;
.super Ljava/lang/Object;
.source "LiveAgentQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

.field protected b:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

.field protected c:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueueRequestListener;

.field private d:Landroid/content/Context;

.field private e:Z

.field private f:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 181
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 188
    const/4 v0, 0x5

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->f:I

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->d:Landroid/content/Context;

    .line 192
    return-object p0
.end method

.method public a(Z)Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;
    .locals 0

    .prologue
    .line 201
    iput-boolean p1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->e:Z

    .line 202
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;
    .locals 3

    .prologue
    .line 221
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->d:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->e:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    if-nez v0, :cond_2

    .line 224
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;-><init>()V

    iget v1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->f:I

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a(I)Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    .line 230
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->b:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    if-nez v0, :cond_1

    .line 231
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->b:Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;

    .line 234
    :cond_1
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;-><init>(Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;)V

    return-object v0

    .line 225
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    if-nez v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->d:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/service/common/liveagentclient/R$integer;->salesforce_live_agent_message_retry_timeout_ms:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    int-to-long v0, v0

    .line 227
    new-instance v2, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    invoke-direct {v2}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;-><init>()V

    invoke-virtual {v2, v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(J)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;

    goto :goto_0
.end method
