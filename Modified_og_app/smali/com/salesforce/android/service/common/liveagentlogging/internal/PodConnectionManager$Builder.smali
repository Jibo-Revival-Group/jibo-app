.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;
.super Ljava/lang/Object;
.source "PodConnectionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

.field protected c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

.field protected d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

.field protected e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

.field protected f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

.field protected g:Lcom/google/gson/GsonBuilder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 239
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a:Landroid/content/Context;

    .line 251
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;
    .locals 0

    .prologue
    .line 255
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 256
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
    .locals 3

    .prologue
    .line 285
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    if-nez v0, :cond_0

    .line 289
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 290
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->a()[Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;->a([Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;

    move-result-object v0

    .line 291
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    .line 294
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    if-nez v0, :cond_1

    .line 295
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    .line 298
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    if-nez v0, :cond_2

    .line 299
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    .line 302
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    if-nez v0, :cond_3

    .line 303
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    .line 306
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->g:Lcom/google/gson/GsonBuilder;

    if-nez v0, :cond_4

    .line 307
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;-><init>()V

    .line 309
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v2, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    .line 310
    invoke-virtual {v1, v2, v0}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;

    invoke-direct {v2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;-><init>()V

    .line 311
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    .line 312
    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->g:Lcom/google/gson/GsonBuilder;

    .line 315
    :cond_4
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    .line 316
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;)V

    return-object v0
.end method
