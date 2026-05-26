.class public Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;
.source "HomeViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

.field final b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

.field c:Landroid/view/View;

.field d:Landroid/view/View;

.field e:Landroid/view/View;

.field f:Landroid/view/View;

.field g:Landroid/support/v7/widget/RecyclerView;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;-><init>()V

    .line 63
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    .line 64
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    .line 65
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;
    .locals 1

    .prologue
    .line 58
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 59
    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    move-result-object v0

    return-object v0
.end method

.method static a(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)V

    return-object v0
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 90
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_fragment_home:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->c:Landroid/view/View;

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->c:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(Landroid/view/View;)V

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->b(Ljava/lang/Object;)V

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->c:Landroid/view/View;

    return-object v0
.end method

.method public a(I)V
    .locals 5

    .prologue
    const/4 v3, 0x4

    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 148
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->d:Landroid/view/View;

    if-nez p1, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 149
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v4, v0}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 150
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->e:Landroid/view/View;

    const/4 v0, 0x3

    if-ne p1, v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 151
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->f:Landroid/view/View;

    if-ne p1, v3, :cond_3

    :goto_3
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 153
    return-void

    :cond_0
    move v0, v2

    .line 148
    goto :goto_0

    :cond_1
    move v0, v3

    .line 149
    goto :goto_1

    :cond_2
    move v0, v2

    .line 150
    goto :goto_2

    :cond_3
    move v1, v2

    .line 151
    goto :goto_3
.end method

.method a(IZ)V
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    .line 188
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    .line 189
    if-eqz v0, :cond_0

    .line 190
    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a(Z)V

    .line 192
    :cond_0
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/os/Bundle;)V

    .line 104
    const-string v0, "layout_manager_state"

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->d()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 105
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 116
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_indeterminate_progress:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->d:Landroid/view/View;

    .line 117
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_list:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    .line 118
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->e:Landroid/view/View;

    .line 119
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_network_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->f:Landroid/view/View;

    .line 121
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_home_close:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 122
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_home_search:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 129
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/ScrollToTopLayoutManager;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/ScrollToTopLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 137
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$4;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$4;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 176
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 2

    .prologue
    .line 160
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 167
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Ljava/util/List;)V

    .line 157
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->stopScroll()V

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->a(Ljava/lang/Object;)V

    .line 99
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 108
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->b(Landroid/os/Bundle;)V

    .line 109
    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 110
    const-string v0, "layout_manager_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 111
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->a(Landroid/os/Parcelable;)V

    .line 113
    :cond_0
    return-void
.end method

.method public e()I
    .locals 1

    .prologue
    .line 140
    const v0, 0x106000d

    return v0
.end method
