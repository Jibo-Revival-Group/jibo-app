.class Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;
.super Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.source "HomeListController.java"


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
.field a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/view/LayoutInflater;

.field private final c:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;


# direct methods
.method private constructor <init>(Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V
    .locals 1

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;-><init>()V

    .line 66
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    .line 82
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->b:Landroid/view/LayoutInflater;

    .line 83
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    .line 84
    return-void
.end method

.method static a(Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;
    .locals 1

    .prologue
    .line 73
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;-><init>(Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V

    return-object v0
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public a(I)I
    .locals 3

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 181
    instance-of v1, v0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    if-eqz v1, :cond_0

    .line 182
    const/4 v0, 0x1

    .line 184
    :goto_0
    return v0

    .line 183
    :cond_0
    instance-of v0, v0, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    if-eqz v0, :cond_1

    .line 184
    const/4 v0, 0x2

    goto :goto_0

    .line 187
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Item does not exist at position "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 153
    packed-switch p2, :pswitch_data_0

    .line 162
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown viewType"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 155
    :pswitch_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->b:Landroid/view/LayoutInflater;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_home_category_item:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 156
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a(Landroid/view/View;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    move-result-object v0

    .line 159
    :goto_0
    return-object v0

    .line 158
    :pswitch_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->b:Landroid/view/LayoutInflater;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_home_category_summary:I

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 159
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->b:Landroid/view/LayoutInflater;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-static {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->a(Landroid/view/View;Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    move-result-object v0

    goto :goto_0

    .line 153
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/service/common/utilities/functional/Optional;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/functional/Optional",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 104
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 105
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a()Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    .line 108
    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 2

    .prologue
    .line 166
    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;->getItemViewType()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 167
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 168
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    .line 169
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1, v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 170
    :cond_1
    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;->getItemViewType()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    add-int/lit8 v1, p2, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 172
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    .line 173
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    .line 174
    invoke-virtual {p1, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 2

    .prologue
    .line 120
    if-nez p2, :cond_0

    .line 131
    :goto_0
    return-void

    .line 124
    :cond_0
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$1;

    invoke-direct {v1, p0, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    goto :goto_0
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
    .line 97
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 99
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyDataSetChanged()V

    .line 100
    return-void
.end method

.method public a_(I)Z
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 134
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 146
    return-void
.end method
