.class public Lcom/salesforce/android/knowledge/ui/KnowledgeUI;
.super Ljava/lang/Object;
.source "KnowledgeUI.java"


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

.field b:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field final c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;)V
    .locals 1

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->c:Ljava/util/Set;

    .line 71
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    .line 72
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;)Lcom/salesforce/android/knowledge/ui/KnowledgeUI;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;)Lcom/salesforce/android/knowledge/ui/KnowledgeUI;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->c:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 98
    return-object p0
.end method

.method a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->c:Ljava/util/Set;

    invoke-static {v0, p1, v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;Lcom/salesforce/android/knowledge/core/KnowledgeClient;Ljava/util/Set;)Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->a()Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    .line 113
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    .line 114
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->b()Ljava/lang/String;

    move-result-object v5

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->b:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    if-eqz v0, :cond_0

    move v0, v1

    .line 115
    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iget-object v6, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    .line 116
    invoke-virtual {v6}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->c()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v6

    if-eqz v6, :cond_1

    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 112
    invoke-static {v3, v4, v5, v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V

    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->b:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    if-eqz v0, :cond_2

    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->b:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 134
    :goto_2
    new-instance v1, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$2;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUI;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 140
    return-object v0

    :cond_0
    move v0, v2

    .line 114
    goto :goto_0

    :cond_1
    move v1, v2

    .line 116
    goto :goto_1

    .line 123
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->a()Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)Lcom/salesforce/android/knowledge/core/KnowledgeCore;

    move-result-object v0

    .line 124
    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUI;)V

    .line 125
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    goto :goto_2
.end method
