.class public Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;
.super Ljava/lang/Object;
.source "ArticleListPresenterImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;
    }
.end annotation


# static fields
.field static final synthetic g:Z


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation
.end field

.field d:Z

.field e:I

.field f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

.field private h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->g:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    .line 64
    const/4 v0, 0x1

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->e:I

    .line 66
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->e:I

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;I)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    .line 78
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 79
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 80
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;
    .locals 1

    .prologue
    .line 74
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->f()Z

    move-result v0

    if-nez v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->n(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->e:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->e:I

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;I)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a()V

    .line 123
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 114
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;)V
    .locals 3

    .prologue
    .line 92
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(Landroid/graphics/drawable/Drawable;)V

    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(Ljava/lang/String;)V

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->d:Z

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(Ljava/util/List;Z)V

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b()Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(Z)V

    .line 98
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f()V

    .line 99
    return-void
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;)V

    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 126
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->g:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->k(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a()V

    .line 89
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;)V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    if-ne p1, v0, :cond_0

    .line 103
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    .line 105
    :cond_0
    return-void
.end method

.method public synthetic b(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;)V

    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->b()V

    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 110
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a()V

    .line 133
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d()V

    .line 137
    return-void
.end method

.method f()V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    if-nez v0, :cond_0

    .line 156
    :goto_0
    return-void

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    const/4 v1, 0x4

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(I)V

    goto :goto_0

    .line 149
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(I)V

    goto :goto_0

    .line 151
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 152
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(I)V

    goto :goto_0

    .line 154
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(I)V

    goto :goto_0
.end method
