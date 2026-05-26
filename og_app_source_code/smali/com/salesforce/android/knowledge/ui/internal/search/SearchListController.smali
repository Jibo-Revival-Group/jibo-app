.class Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;
.super Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.source "SearchListController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;,
        Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$ViewHolder;
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
.field final a:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

.field b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

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


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;)V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;-><init>()V

    .line 73
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    .line 89
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    .line 90
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d()V

    .line 91
    return-void
.end method

.method static a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;
    .locals 1

    .prologue
    .line 81
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;-><init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;)V

    return-object v0
.end method

.method private d()V
    .locals 2

    .prologue
    .line 101
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->setHasStableIds(Z)V

    .line 102
    return-void
.end method


# virtual methods
.method public a()I
    .locals 2

    .prologue
    .line 190
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d:Z

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
    .line 147
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

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

    .line 151
    if-nez p2, :cond_0

    .line 152
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_article_item:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 153
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$ViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$ViewHolder;-><init>(Landroid/view/View;)V

    .line 156
    :goto_0
    return-object v0

    .line 154
    :cond_0
    const/4 v0, 0x1

    if-ne p2, v0, :cond_1

    .line 155
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_loading_more_items:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 156
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$ViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$ViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 159
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown item type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 3

    .prologue
    .line 163
    invoke-virtual {p0, p2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(I)I

    move-result v0

    .line 164
    if-nez v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 166
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 167
    iget-object v1, p1, Landroid/support/v7/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    check-cast v1, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;

    .line 168
    invoke-virtual {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Landroid/graphics/drawable/Drawable;)V

    .line 169
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 177
    :cond_0
    return-void
.end method

.method a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

    .line 110
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
    .line 119
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    .line 120
    iput-boolean p2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d:Z

    .line 121
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    .line 122
    return-void
.end method

.method public b(I)J
    .locals 2

    .prologue
    .line 180
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(I)I

    move-result v0

    .line 181
    if-nez v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->g()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    int-to-long v0, v0

    .line 185
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method b()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 136
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a()I

    move-result v0

    .line 137
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    .line 138
    iput-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d:Z

    .line 139
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v1, v2, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeRemoved(II)V

    .line 140
    return-void
.end method

.method b(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;)V
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

    if-ne v0, p1, :cond_0

    .line 114
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

    .line 116
    :cond_0
    return-void
.end method

.method b(Ljava/util/List;Z)V
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
    .line 125
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 126
    iget-boolean v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d:Z

    if-eqz v1, :cond_0

    if-nez p2, :cond_0

    .line 127
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->d:Z

    .line 128
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRemoved(I)V

    .line 131
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 132
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    .line 133
    return-void
.end method
