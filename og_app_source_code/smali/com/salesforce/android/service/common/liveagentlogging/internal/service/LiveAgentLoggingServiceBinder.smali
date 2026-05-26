.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder;
.super Landroid/os/Binder;
.source "LiveAgentLoggingServiceBinder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;)V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 52
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder$Builder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    .line 53
    return-void
.end method


# virtual methods
.method a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceBinder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    return-object v0
.end method
