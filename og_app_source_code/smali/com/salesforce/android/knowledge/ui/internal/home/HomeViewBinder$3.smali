.class Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;
.super Ljava/lang/Object;
.source "HomeViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Consumer",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field final synthetic b:Lcom/salesforce/android/knowledge/core/model/ArticleList;

.field final synthetic c:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->b:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Integer;)V
    .locals 3

    .prologue
    .line 162
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(IZ)V

    .line 163
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->b:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    .line 164
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->c:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->g:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->scrollToPosition(I)V

    .line 165
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 160
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$3;->a(Ljava/lang/Integer;)V

    return-void
.end method
