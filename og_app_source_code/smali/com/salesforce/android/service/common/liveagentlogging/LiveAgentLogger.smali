.class public Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;
.super Ljava/lang/Object;
.source "LiveAgentLogger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

.field private final b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;)V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 61
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

    .line 62
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->b:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;->a(Landroid/content/Context;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Landroid/content/Intent;

    move-result-object v0

    .line 78
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

    invoke-virtual {v1, p1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;->a(Landroid/content/Context;Landroid/content/Intent;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a()V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection;->a()V

    .line 87
    return-void
.end method
