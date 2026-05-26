.class Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;
.super Ljava/lang/Object;
.source "LiveAgentCasesLogger.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;",
            ")V"
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v0, p2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    .line 120
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    .line 122
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a(Ljava/util/Collection;)V

    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 124
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 116
    check-cast p2, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V

    return-void
.end method
