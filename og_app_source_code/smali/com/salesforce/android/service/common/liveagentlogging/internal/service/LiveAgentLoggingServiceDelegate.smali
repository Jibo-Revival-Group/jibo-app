.class Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;
.super Ljava/lang/Object;
.source "LiveAgentLoggingServiceDelegate.java"


# static fields
.field protected static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;",
            ">;"
        }
    .end annotation
.end field

.field protected c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;

.field private final e:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;

.field private final f:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

.field private final g:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;)V
    .locals 3

    .prologue
    .line 79
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;-><init>()V

    new-instance v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;-><init>()V

    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    invoke-direct {v2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;-><init>()V

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;)V

    .line 83
    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;)V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->b:Ljava/util/Set;

    .line 72
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->c:Ljava/util/Set;

    .line 89
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;

    .line 90
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->e:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;

    .line 91
    iput-object p3, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->f:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

    .line 92
    iput-object p4, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->g:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    .line 93
    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->b:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    .line 101
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->b()V

    goto :goto_0

    .line 103
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 4

    .prologue
    .line 110
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgentLoggingService is starting"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 112
    const-string v0, "com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration"

    .line 113
    invoke-virtual {p1, v0}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 114
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->f:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;

    .line 117
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

    move-result-object v1

    .line 118
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;

    move-result-object v1

    .line 119
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    move-result-object v1

    .line 121
    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->g:Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->d:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;

    .line 122
    invoke-virtual {v2, v3}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    move-result-object v2

    .line 123
    invoke-virtual {v2, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    move-result-object v0

    .line 124
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;)Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;

    move-result-object v0

    .line 125
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    move-result-object v0

    .line 127
    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->b:Ljava/util/Set;

    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 128
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->c:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 129
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->e:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;

    .line 130
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;

    move-result-object v0

    .line 131
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder;

    move-result-object v0

    .line 129
    return-object v0
.end method

.method public a()V
    .locals 4

    .prologue
    .line 135
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->b()V

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->c:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;

    .line 139
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v2

    new-instance v3, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate$2;

    invoke-direct {v3, p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate$2;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;)V

    invoke-interface {v2, v3}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v2

    new-instance v3, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate$1;

    invoke-direct {v3, p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate$1;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;)V

    .line 143
    invoke-interface {v2, v3}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0

    .line 151
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "LiveAgentLoggingService has been destroyed"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 152
    return-void
.end method
