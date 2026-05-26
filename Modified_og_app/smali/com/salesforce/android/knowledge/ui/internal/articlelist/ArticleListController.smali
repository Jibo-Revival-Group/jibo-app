.class public Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;
.super Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.source "ArticleListController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/ui/internal/util/ListController",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

.field private final b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Landroid/content/Context;

.field private d:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;-><init>()V

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    .line 74
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c:Landroid/content/Context;

    .line 75
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    .line 76
    return-void
.end method


# virtual methods
.method public a()I
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->d:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    add-int/2addr v0, v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(I)I
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 119
    if-nez p2, :cond_0

    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_article_item:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 121
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$ViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$ViewHolder;-><init>(Landroid/view/View;)V

    .line 124
    :goto_0
    return-object v0

    .line 122
    :cond_0
    const/4 v0, 0x1

    if-ne p2, v0, :cond_1

    .line 123
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_loading_more_items:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 124
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$ViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$ViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 127
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown item type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 3

    .prologue
    .line 131
    invoke-virtual {p0, p2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->a(I)I

    move-result v0

    .line 132
    if-nez v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 134
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    invoke-interface {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;->b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 136
    iget-object v1, p1, Landroid/support/v7/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    check-cast v1, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;

    .line 137
    invoke-virtual {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Landroid/graphics/drawable/Drawable;)V

    .line 138
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    :cond_0
    return-void
.end method

.method a(Ljava/util/List;Z)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 93
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    .line 94
    if-eqz p2, :cond_1

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->d:Z

    if-nez v2, :cond_1

    .line 95
    add-int/lit8 v0, v0, 0x1

    .line 96
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->d:Z

    .line 102
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    .line 103
    return-void

    .line 97
    :cond_1
    if-nez p2, :cond_0

    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->d:Z

    if-eqz v2, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRemoved(I)V

    .line 99
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->d:Z

    goto :goto_0
.end method
