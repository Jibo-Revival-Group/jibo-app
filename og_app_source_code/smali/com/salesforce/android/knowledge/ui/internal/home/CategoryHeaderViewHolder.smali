.class Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "CategoryHeaderViewHolder.java"


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

.field final b:Landroid/widget/TextView;

.field final c:Landroid/widget/ImageView;

.field final d:Landroid/widget/ImageView;


# direct methods
.method private constructor <init>(Landroid/view/View;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V
    .locals 2

    .prologue
    .line 67
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 68
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    .line 70
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_name:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->b:Landroid/widget/TextView;

    .line 71
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_category_image:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->c:Landroid/widget/ImageView;

    .line 72
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_icon_dropdown:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 85
    return-void
.end method

.method public static a(Landroid/view/View;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;
    .locals 1

    .prologue
    .line 63
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;-><init>(Landroid/view/View;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V

    return-object v0
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->b:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->c:Landroid/widget/ImageView;

    invoke-virtual {p2, p1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-interface {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->c(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Z

    move-result v0

    .line 96
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    const/high16 v0, 0x43340000    # 180.0f

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setRotation(F)V

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->itemView:Landroid/view/View;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;

    invoke-direct {v1, p0, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    return-void

    .line 96
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 108
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    if-eqz p1, :cond_0

    const/high16 v0, 0x43340000    # 180.0f

    :goto_0
    invoke-static {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/RotateAnimation;->a(Landroid/view/View;F)V

    .line 109
    return-void

    .line 108
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
