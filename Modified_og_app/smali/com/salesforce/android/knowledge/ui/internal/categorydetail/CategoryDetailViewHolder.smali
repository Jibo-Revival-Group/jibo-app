.class public abstract Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "CategoryDetailViewHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;,
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$SubCategories;,
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$MoreArticles;,
        Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;"
    }
.end annotation


# instance fields
.field a:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 63
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    .line 64
    return-void
.end method

.method static a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;
    .locals 2

    .prologue
    .line 45
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_article_item:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;

    .line 46
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;

    invoke-direct {v1, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Article;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;)V

    return-object v1
.end method

.method static b(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;
    .locals 2

    .prologue
    .line 50
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_cd_category_item:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 51
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;

    invoke-direct {v1, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder$Category;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;Landroid/view/View;)V

    return-object v1
.end method


# virtual methods
.method a()Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    return-object v0
.end method

.method a(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 75
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->a:Ljava/lang/Object;

    .line 76
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->c()V

    .line 77
    return-void
.end method

.method b()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewHolder;->a:Ljava/lang/Object;

    return-object v0
.end method

.method c()V
    .locals 0

    .prologue
    .line 84
    return-void
.end method
