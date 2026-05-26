.class Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;
.super Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.source "CategoryDetailListController.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/ui/internal/util/ListController",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Z

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

.field private final c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)V
    .locals 1

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c:Ljava/util/List;

    .line 69
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    .line 70
    return-void
.end method

.method static a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;
    .locals 1

    .prologue
    .line 60
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)V

    return-object v0
.end method

.method private b()I
    .locals 1

    .prologue
    .line 180
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x2

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public a()I
    .locals 2

    .prologue
    .line 167
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    .line 169
    iget-boolean v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-eqz v1, :cond_0

    .line 170
    add-int/lit8 v0, v0, 0x1

    .line 173
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 174
    add-int/lit8 v0, v0, 0x1

    .line 176
    :cond_1
    return v0
.end method

.method public a(I)I
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 141
    const/4 v0, 0x0

    .line 149
    :goto_0
    return v0

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne p1, v0, :cond_1

    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-eqz v0, :cond_1

    .line 144
    const/4 v0, 0x1

    goto :goto_0

    .line 146
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-eq p1, v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-ne p1, v0, :cond_3

    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-eqz v0, :cond_3

    .line 147
    :cond_2
    const/4 v0, 0x2

    goto :goto_0

    .line 149
    :cond_3
    const/4 v0, 0x3

    goto :goto_0
.end method

.method public a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 121
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 124
    packed-switch p2, :pswitch_data_0

    .line 136
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown viewType"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 126
    :pswitch_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-static {v1, v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;

    move-result-object v0

    .line 134
    :goto_0
    return-object v0

    .line 128
    :pswitch_1
    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_cd_showmore_item:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 129
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$MoreArticles;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-direct {v0, v2, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$MoreArticles;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/View;)V

    goto :goto_0

    .line 131
    :pswitch_2
    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_cd_category_header:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 132
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$SubCategories;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-direct {v0, v2, v1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$SubCategories;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/View;)V

    goto :goto_0

    .line 134
    :pswitch_3
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->d:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    invoke-static {v1, v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->b(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;

    move-result-object v0

    goto :goto_0

    .line 124
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 2

    .prologue
    .line 153
    invoke-virtual {p0, p2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 163
    :goto_0
    :pswitch_0
    return-void

    .line 155
    :pswitch_1
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 159
    :pswitch_2
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;

    .line 160
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c:Ljava/util/List;

    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b()I

    move-result v1

    sub-int v1, p2, v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 153
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method a(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 83
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v2, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeRemoved(II)V

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 85
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 86
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v2, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    .line 87
    return-void
.end method

.method a(Z)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 90
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-eqz v0, :cond_1

    if-nez p1, :cond_1

    .line 91
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    .line 92
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeRemoved(II)V

    .line 97
    :cond_0
    :goto_0
    return-void

    .line 93
    :cond_1
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    .line 94
    iput-boolean v2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->a:Z

    .line 95
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    goto :goto_0
.end method

.method b(Ljava/util/List;)V
    .locals 3
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
    .line 100
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 109
    :goto_0
    return-void

    .line 104
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 107
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->b()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .line 108
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeInserted(II)V

    goto :goto_0
.end method
