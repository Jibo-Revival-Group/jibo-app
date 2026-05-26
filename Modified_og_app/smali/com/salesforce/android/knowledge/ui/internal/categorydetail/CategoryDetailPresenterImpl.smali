.class public Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;
.super Ljava/lang/Object;
.source "CategoryDetailPresenterImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;,
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;
    }
.end annotation


# static fields
.field static final synthetic h:Z


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field final b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

.field final d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

.field e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation
.end field

.field f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;"
        }
    .end annotation
.end field

.field g:Z

.field private i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->h:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$1;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    .line 62
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$1;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    .line 69
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->e:Ljava/util/List;

    .line 70
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f:Ljava/util/List;

    .line 71
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->g:Z

    .line 82
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 83
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 84
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;
    .locals 1

    .prologue
    .line 78
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    return-object v0
.end method

.method private c(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V
    .locals 2

    .prologue
    .line 149
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b()Z

    move-result v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(Z)V

    .line 152
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 153
    if-eqz v0, :cond_0

    .line 154
    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(Landroid/graphics/drawable/Drawable;)V

    .line 156
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 119
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->h:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 120
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 121
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 1

    .prologue
    .line 114
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->h:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 116
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V
    .locals 1

    .prologue
    .line 97
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V

    .line 99
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f()V

    .line 100
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 1

    .prologue
    .line 124
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->c()I

    move-result v0

    if-lez v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 129
    :goto_0
    return-void

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    goto :goto_0
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 46
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V

    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 132
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->h:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 133
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->l(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;->a()V

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a()V

    .line 94
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    if-ne p1, v0, :cond_0

    .line 104
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    .line 106
    :cond_0
    return-void
.end method

.method public synthetic b(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 46
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;)V

    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;->b()V

    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->b()V

    .line 111
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a()V

    .line 138
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d()V

    .line 142
    return-void
.end method

.method f()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 159
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    if-nez v0, :cond_1

    .line 175
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;->e()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->e()Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_2
    move v0, v2

    .line 164
    :goto_1
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$ArticleListHandler;->d()Z

    move-result v3

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->d()Z

    move-result v3

    if-eqz v3, :cond_5

    move v3, v2

    .line 165
    :goto_2
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->e:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_3

    move v1, v2

    .line 167
    :cond_3
    if-eqz v0, :cond_6

    .line 168
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(I)V

    goto :goto_0

    :cond_4
    move v0, v1

    .line 163
    goto :goto_1

    :cond_5
    move v3, v1

    .line 164
    goto :goto_2

    .line 169
    :cond_6
    if-eqz v1, :cond_7

    if-eqz v3, :cond_7

    .line 170
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(I)V

    goto :goto_0

    .line 171
    :cond_7
    if-eqz v3, :cond_0

    .line 172
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->e:Ljava/util/List;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f:Ljava/util/List;

    iget-boolean v4, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->g:Z

    invoke-interface {v0, v1, v3, v4}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(Ljava/util/List;Ljava/util/List;Z)V

    .line 173
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;

    invoke-interface {v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;->a(I)V

    goto :goto_0
.end method
