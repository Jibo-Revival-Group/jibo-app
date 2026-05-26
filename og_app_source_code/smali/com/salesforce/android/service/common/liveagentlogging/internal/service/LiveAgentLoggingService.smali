.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;
.super Landroid/app/Service;
.source "LiveAgentLoggingService.java"


# instance fields
.field private a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 40
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;

    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->a(Landroid/content/Intent;)Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingService;->a:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceDelegate;->a()V

    .line 48
    return-void
.end method
