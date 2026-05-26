.class Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;
.super Ljava/lang/Object;
.source "CategoryHeaderViewHolder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

.field final synthetic b:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;->b:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-interface {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 103
    return-void
.end method
