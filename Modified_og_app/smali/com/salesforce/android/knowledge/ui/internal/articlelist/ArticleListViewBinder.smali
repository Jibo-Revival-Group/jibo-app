.class public Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;
.source "ArticleListViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

.field final b:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;

.field private final c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

.field private d:Landroid/view/View;

.field private e:Landroid/widget/ImageView;

.field private f:Landroid/support/design/widget/AppBarLayout;

.field private g:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

.field private h:Landroid/support/v7/widget/RecyclerView;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;)V

    .line 77
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    .line 78
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;

    .line 79
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    .line 80
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;
    .locals 3

    .prologue
    .line 68
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;-><init>(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;)V

    new-instance v2, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 70
    invoke-static {v2}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Landroid/support/v7/widget/LinearLayoutManager;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;)V

    .line 68
    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;)Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->g:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    return-object v0
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->d:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 109
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_fragment_article_list:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->d:Landroid/view/View;

    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->d:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a(Landroid/view/View;)V

    .line 111
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;->b(Ljava/lang/Object;)V

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->d:Landroid/view/View;

    return-object v0
.end method

.method public a(I)V
    .locals 7

    .prologue
    const/4 v2, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/16 v3, 0x8

    const/4 v1, 0x0

    .line 212
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    const/4 v0, 0x1

    if-ne p1, v0, :cond_3

    move v0, v1

    :goto_0
    invoke-virtual {v4, v0}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 213
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->i:Landroid/view/View;

    if-ne p1, v5, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 214
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->j:Landroid/view/View;

    if-ne p1, v6, :cond_5

    move v0, v1

    :goto_2
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 215
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->k:Landroid/view/View;

    if-ne p1, v2, :cond_0

    move v3, v1

    :cond_0
    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 217
    if-eq p1, v5, :cond_1

    if-ne p1, v6, :cond_2

    .line 218
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->f:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->setExpanded(Z)V

    .line 220
    :cond_2
    return-void

    :cond_3
    move v0, v2

    .line 212
    goto :goto_0

    :cond_4
    move v0, v3

    .line 213
    goto :goto_1

    :cond_5
    move v0, v3

    .line 214
    goto :goto_2
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->e:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 200
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a(Landroid/os/Bundle;)V

    .line 126
    const-string v0, "layout_manager_state"

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->d()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Landroid/os/Bundle;)V

    .line 128
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 154
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_list_body:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    .line 155
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_empty_category:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->i:Landroid/view/View;

    .line 156
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_list_header_image:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->e:Landroid/widget/ImageView;

    .line 157
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_list_app_bar_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->f:Landroid/support/design/widget/AppBarLayout;

    .line 158
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_list_collapse_toolbar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->g:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    .line 159
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->j:Landroid/view/View;

    .line 160
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_indeterminate_progress:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->k:Landroid/view/View;

    .line 162
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    const/4 v1, 0x2

    .line 163
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(I)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;)V

    .line 164
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    .line 170
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$drawable;->knowledge_background_border:I

    invoke-static {v0, v1}, Landroid/support/v4/content/ContextCompat;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 171
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/util/DividerDecoration;

    invoke-direct {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/DividerDecoration;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 173
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 174
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a()Landroid/support/v7/widget/LinearLayoutManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 178
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->i:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 180
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->j:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->g:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$3;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$3;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->post(Ljava/lang/Runnable;)Z

    .line 192
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->g:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setTitle(Ljava/lang/CharSequence;)V

    .line 204
    return-void
.end method

.method public a(Ljava/util/List;Z)V
    .locals 1
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
    .line 207
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListController;->a(Ljava/util/List;Z)V

    .line 208
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Z)V

    .line 209
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->stopScroll()V

    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;->a(Ljava/lang/Object;)V

    .line 118
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 131
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->b(Landroid/os/Bundle;)V

    .line 132
    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 133
    const-string v0, "layout_manager_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 135
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v1, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->b(Landroid/os/Bundle;)V

    .line 138
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->b()I

    move-result v1

    if-lez v1, :cond_0

    .line 139
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->f:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v1, v2, v2}, Landroid/support/design/widget/AppBarLayout;->a(ZZ)V

    .line 144
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    .line 145
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;

    invoke-direct {v2, p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;Landroid/support/v7/widget/RecyclerView;Landroid/os/Parcelable;)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    .line 151
    :cond_1
    return-void
.end method

.method public d()Landroid/support/v7/widget/Toolbar;
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->d:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_list_toolbar:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    return-object v0
.end method
