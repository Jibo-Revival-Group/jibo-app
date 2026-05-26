.class public Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;
.super Ljava/lang/Object;
.source "Navigator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;,
        Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

.field private final c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

.field private final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;)V
    .locals 2

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 72
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    .line 73
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    .line 74
    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p1, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->d:Ljava/util/Set;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d:Ljava/util/Set;

    .line 75
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    return-object v0
.end method

.method private a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;

    .line 158
    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    goto :goto_0

    .line 160
    :cond_0
    return-void
.end method

.method private a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeScene;",
            "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 152
    :goto_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    invoke-direct {v2, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->a(Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;)V

    .line 153
    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 154
    return-void

    .line 151
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v0

    goto :goto_0
.end method

.method private b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 2

    .prologue
    .line 163
    invoke-static {p1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 164
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;

    .line 165
    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;->b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    goto :goto_0

    .line 167
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;
    .locals 3

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    .line 79
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a()Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    move-result-object v1

    .line 80
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->c()Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {v2, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;-><init>(Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;Landroid/os/Bundle;)V

    return-object v2
.end method

.method public a()V
    .locals 2

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_SEARCH:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 118
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a()Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    move-result-object v0

    .line 119
    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_SEARCH:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    .line 120
    return-void
.end method

.method public a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 91
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 2

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    move-result-object v0

    .line 100
    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    .line 101
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    move-result-object v0

    .line 105
    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_LIST:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    .line 106
    return-void
.end method

.method public b(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a(Landroid/content/Context;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    move-result-object v0

    .line 95
    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_HOME:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    .line 96
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    move-result-object v0

    .line 110
    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_CATEGORY_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V

    .line 111
    return-void
.end method

.method public b()Z
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->b()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    move-result-object v0

    .line 124
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_HOME:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public d()V
    .locals 2

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->c()Z

    move-result v0

    if-nez v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->c()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    move-result-object v0

    .line 138
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->a()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 140
    :cond_0
    return-void
.end method

.method public e()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->a()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v0

    return-object v0
.end method

.method public f()V
    .locals 1

    .prologue
    .line 170
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->c()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    goto :goto_0

    .line 173
    :cond_0
    return-void
.end method
