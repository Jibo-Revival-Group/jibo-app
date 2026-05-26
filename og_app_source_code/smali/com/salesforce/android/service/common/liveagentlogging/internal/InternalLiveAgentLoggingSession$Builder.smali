.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;
.super Ljava/lang/Object;
.source "InternalLiveAgentLoggingSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

.field protected c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

.field protected d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

.field protected e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

.field protected f:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 258
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a:Landroid/content/Context;

    .line 269
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 274
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;
    .locals 0

    .prologue
    .line 278
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    .line 279
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;
    .locals 4

    .prologue
    .line 298
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 300
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

    if-nez v0, :cond_0

    .line 303
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/InternalLiveAgentLoggingRequestFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/InternalLiveAgentLoggingRequestFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;

    .line 306
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    if-nez v0, :cond_1

    .line 307
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    .line 310
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    if-nez v0, :cond_2

    .line 311
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->f:Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue$Builder;

    .line 314
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->d()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(J)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    .line 315
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;)V

    return-object v0
.end method
