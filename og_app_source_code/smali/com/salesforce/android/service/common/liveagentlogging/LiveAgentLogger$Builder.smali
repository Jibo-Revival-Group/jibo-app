.class public Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;
.super Ljava/lang/Object;
.source "LiveAgentLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

.field protected b:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    .line 99
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;

    if-nez v0, :cond_0

    .line 111
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/service/LiveAgentLoggingServiceConnection$Builder;

    .line 114
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;)V

    return-object v0
.end method
