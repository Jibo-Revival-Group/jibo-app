.class public Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;
.source "CategoryDetailViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailView;


# instance fields
.field protected a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

.field private final c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

.field private final d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

.field private e:Landroid/support/design/widget/AppBarLayout;

.field private f:Landroid/widget/ImageView;

.field private g:Landroid/view/View;

.field private h:Landroid/support/v7/widget/RecyclerView;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;)V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;)V

    .line 85
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    .line 86
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    .line 87
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    .line 88
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;
    .locals 3

    .prologue
    .line 76
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;

    .line 77
    invoke-static {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    invoke-direct {v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;-><init>()V

    invoke-direct {v0, p0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;)V

    .line 76
    return-object v0
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 110
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_fragment_category_detail:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->g:Landroid/view/View;

    .line 111
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->g:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->a(Landroid/view/View;)V

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;->b(Ljava/lang/Object;)V

    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->g:Landroid/view/View;

    return-object v0
.end method

.method public a(I)V
    .locals 4

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 189
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->i:Landroid/view/View;

    if-nez p1, :cond_2

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 190
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    const/4 v0, 0x1

    if-ne p1, v0, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 191
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->j:Landroid/view/View;

    const/4 v0, 0x2

    if-ne p1, v0, :cond_4

    move v0, v1

    :goto_2
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 192
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->k:Landroid/view/View;

    const/4 v3, 0x3

    if-ne p1, v3, :cond_0

    move v2, v1

    :cond_0
    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 194
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    .line 196
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->e:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->setExpanded(Z)V

    .line 198
    :cond_1
    return-void

    :cond_2
    move v0, v2

    .line 189
    goto :goto_0

    .line 190
    :cond_3
    const/4 v0, 0x4

    goto :goto_1

    :cond_4
    move v0, v2

    .line 191
    goto :goto_2
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->f:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 209
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 156
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a(Landroid/os/Bundle;)V

    .line 157
    const-string v0, "layout_manager_state"

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->d()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 158
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a(Landroid/os/Bundle;)V

    .line 159
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 122
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_detail_app_bar_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->e:Landroid/support/design/widget/AppBarLayout;

    .line 123
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_detail_collapse_toolbar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    .line 124
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_detail_header_image:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->f:Landroid/widget/ImageView;

    .line 126
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_detail_body:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    .line 127
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_indeterminate_progress:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->i:Landroid/view/View;

    .line 128
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_empty_category:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->j:Landroid/view/View;

    .line 129
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->k:Landroid/view/View;

    .line 131
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$drawable;->knowledge_background_border:I

    invoke-static {v0, v1}, Landroid/support/v4/content/ContextCompat;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 132
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/util/DividerDecoration;

    invoke-direct {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/DividerDecoration;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 134
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->post(Ljava/lang/Runnable;)Z

    .line 149
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setTitle(Ljava/lang/CharSequence;)V

    .line 213
    return-void
.end method

.method public a(Ljava/util/List;Ljava/util/List;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a(Ljava/util/List;)V

    .line 203
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b(Ljava/util/List;)V

    .line 204
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    invoke-virtual {v0, p3}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a(Z)V

    .line 205
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->stopScroll()V

    .line 118
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;->a(Ljava/lang/Object;)V

    .line 119
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 162
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->b(Landroid/os/Bundle;)V

    .line 163
    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 164
    const-string v0, "layout_manager_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 166
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    invoke-virtual {v1, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->b(Landroid/os/Bundle;)V

    .line 169
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->d:Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->b()I

    move-result v1

    if-lez v1, :cond_0

    .line 170
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->e:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v1, v2, v2}, Landroid/support/design/widget/AppBarLayout;->a(ZZ)V

    .line 175
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->h:Landroid/support/v7/widget/RecyclerView;

    .line 176
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder$2;

    invoke-direct {v2, p0, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;Landroid/support/v7/widget/RecyclerView;Landroid/os/Parcelable;)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    .line 182
    :cond_1
    return-void
.end method

.method public d()Landroid/support/v7/widget/Toolbar;
    .locals 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->g:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_detail_toolbar:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    return-object v0
.end method
