.class Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;
.super Ljava/lang/Object;
.source "LiveAgentCasesLogger.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Consumer",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 0

    .prologue
    .line 206
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;->b:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;->a:Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 206
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;->a(Ljava/lang/String;)V

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;->a:Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->a(Ljava/lang/String;)V

    .line 209
    return-void
.end method
