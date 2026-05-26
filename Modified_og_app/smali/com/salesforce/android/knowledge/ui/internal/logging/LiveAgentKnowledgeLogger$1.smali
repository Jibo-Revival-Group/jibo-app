.class Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;
.super Ljava/lang/Object;
.source "LiveAgentKnowledgeLogger.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a(Landroid/content/Context;)V
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
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V
    .locals 1
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
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V

    .line 118
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 114
    check-cast p2, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V

    return-void
.end method
