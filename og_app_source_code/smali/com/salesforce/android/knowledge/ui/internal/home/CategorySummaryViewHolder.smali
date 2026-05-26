.class Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "CategorySummaryViewHolder.java"


# instance fields
.field final a:Landroid/view/LayoutInflater;

.field final b:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

.field final c:Landroid/widget/LinearLayout;

.field final d:Landroid/view/View;

.field final e:Landroid/view/View;


# direct methods
.method private constructor <init>(Landroid/view/View;Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 66
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_empty_category:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->d:Landroid/view/View;

    .line 67
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_article_summary_list:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->c:Landroid/widget/LinearLayout;

    .line 68
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_show_more_container:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->e:Landroid/view/View;

    .line 69
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->a:Landroid/view/LayoutInflater;

    .line 70
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    .line 71
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;
    .locals 1

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    invoke-direct {v0, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;-><init>(Landroid/view/View;Landroid/view/LayoutInflater;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 7

    .prologue
    const/16 v1, 0x8

    const/4 v2, 0x0

    .line 78
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v3

    .line 79
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    .line 80
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->c()Z

    move-result v5

    .line 82
    iget-object v6, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->d:Landroid/view/View;

    if-eqz v4, :cond_1

    move v0, v2

    :goto_0
    invoke-virtual {v6, v0}, Landroid/view/View;->setVisibility(I)V

    .line 83
    iget-object v6, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->c:Landroid/widget/LinearLayout;

    if-eqz v4, :cond_2

    move v0, v1

    :goto_1
    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->e:Landroid/view/View;

    if-eqz v5, :cond_0

    move v1, v2

    :cond_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 85
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->e:Landroid/view/View;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 92
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 93
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->a:Landroid/view/LayoutInflater;

    sget v4, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_article_item:I

    iget-object v5, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4, v5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;

    .line 95
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-interface {v4, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    .line 96
    invoke-virtual {v1, v0, v4}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Landroid/graphics/drawable/Drawable;)V

    .line 98
    new-instance v4, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;

    invoke-direct {v4, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    invoke-virtual {v1, v4}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 104
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_2

    :cond_1
    move v0, v1

    .line 82
    goto :goto_0

    :cond_2
    move v0, v2

    .line 83
    goto :goto_1

    .line 106
    :cond_3
    return-void
.end method
