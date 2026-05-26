.class Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;
.super Ljava/lang/Object;
.source "HomeListController.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
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
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Integer;)V
    .locals 3

    .prologue
    .line 136
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .line 137
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a_(I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    .line 138
    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a(I)I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 140
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->a:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 141
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->notifyItemRangeRemoved(II)V

    .line 143
    :cond_0
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 134
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeListController$2;->a(Ljava/lang/Integer;)V

    return-void
.end method
