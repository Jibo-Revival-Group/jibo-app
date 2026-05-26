.class Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;
.super Ljava/lang/Object;
.source "CategorySummaryViewHolder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

.field final synthetic b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;->a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$2;->a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 101
    return-void
.end method
