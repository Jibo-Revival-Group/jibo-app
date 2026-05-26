.class public Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;
.super Ljava/lang/Object;
.source "HomePresenterImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;,
        Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;,
        Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;,
        Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;
    }
.end annotation


# static fields
.field static final synthetic k:Z


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final b:Ljava/lang/String;

.field final c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

.field d:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

.field e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

.field final f:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;",
            ">;"
        }
    .end annotation
.end field

.field final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation
.end field

.field h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

.field i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->k:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;)V
    .locals 1

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

    .line 83
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    .line 85
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->f:Ljava/util/Set;

    .line 86
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->g:Ljava/util/Map;

    .line 90
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->j:Ljava/util/List;

    .line 101
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 102
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->b:Ljava/lang/String;

    .line 103
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    .line 104
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;
    .locals 1

    .prologue
    .line 97
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n()V

    .line 139
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 135
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;)V
    .locals 2

    .prologue
    .line 116
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    .line 117
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e()V

    .line 118
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 119
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->b:Ljava/lang/String;

    .line 118
    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->g(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 146
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->k:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 147
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->m(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    if-ne p1, v0, :cond_1

    .line 149
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 150
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 151
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    :goto_0
    return-void

    .line 153
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    if-eqz v0, :cond_2

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 155
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    .line 158
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v1, p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    .line 159
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 160
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 55
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->b(Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;)V

    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 178
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->k:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 179
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 111
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->j()V

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a()V

    .line 113
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;)V
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    .line 124
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 1

    .prologue
    .line 165
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->k:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 166
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->c()I

    move-result v0

    if-lez v0, :cond_1

    .line 167
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 171
    :goto_0
    return-void

    .line 169
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    goto :goto_0
.end method

.method public synthetic b(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 55
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;)V

    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->b()V

    .line 128
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;

    .line 129
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;->b()V

    goto :goto_0

    .line 131
    :cond_0
    return-void
.end method

.method public c(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Z
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a()V

    .line 143
    return-void
.end method

.method e()V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    if-nez v0, :cond_1

    .line 209
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v3}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_4

    move v0, v1

    .line 192
    :goto_1
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->e()Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->e()Z

    move-result v3

    if-eqz v3, :cond_5

    :cond_2
    move v3, v1

    .line 194
    :goto_2
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;

    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->f()Z

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->f()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 195
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(I)V

    goto :goto_0

    :cond_4
    move v0, v2

    .line 191
    goto :goto_1

    :cond_5
    move v3, v2

    .line 192
    goto :goto_2

    .line 196
    :cond_6
    if-eqz v0, :cond_7

    if-eqz v3, :cond_7

    .line 197
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    const/4 v1, 0x4

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(I)V

    goto :goto_0

    .line 198
    :cond_7
    if-eqz v3, :cond_8

    .line 199
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(I)V

    goto :goto_0

    .line 200
    :cond_8
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->j:Ljava/util/List;

    invoke-interface {v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(Ljava/util/List;)V

    .line 202
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(I)V

    .line 204
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->g:Ljava/util/Map;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    .line 206
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {v1, v2, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    goto :goto_0
.end method
