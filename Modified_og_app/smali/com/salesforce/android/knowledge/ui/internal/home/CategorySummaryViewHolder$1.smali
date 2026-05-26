.class Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;
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
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field final synthetic b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategorySummaryViewHolder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 88
    return-void
.end method
