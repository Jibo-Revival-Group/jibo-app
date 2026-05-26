.class Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;
.super Ljava/lang/Object;
.source "SearchListController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

.field final synthetic b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;->a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$1;->a:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 174
    :cond_0
    return-void
.end method
