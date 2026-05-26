.class public Lcom/salesforce/android/knowledge/ui/internal/client/RuntimeModuleProvider;
.super Ljava/lang/Object;
.source "RuntimeModuleProvider.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;[Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;
    .locals 4

    .prologue
    .line 55
    invoke-static {p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;

    move-result-object v1

    .line 57
    array-length v2, p2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, p2, v0

    .line 58
    invoke-virtual {v1, v3}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->a(Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;

    .line 57
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 61
    :cond_0
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->a()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;
    .locals 1

    .prologue
    .line 46
    invoke-static {p1}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    return-object v0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;-><init>()V

    return-object v0
.end method

.method public b()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;
    .locals 1

    .prologue
    .line 42
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;->a()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    move-result-object v0

    return-object v0
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;
    .locals 1

    .prologue
    .line 50
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    invoke-direct {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    return-object v0
.end method

.method public c(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;
    .locals 4

    .prologue
    .line 66
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a()Ljava/lang/String;

    move-result-object v0

    .line 67
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v1

    .line 68
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->b()Ljava/lang/String;

    move-result-object v2

    .line 69
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k()Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v3

    .line 70
    invoke-static {v0, v1, v2, v3}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    move-result-object v0

    return-object v0
.end method
