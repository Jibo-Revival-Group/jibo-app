.class Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;
.super Ljava/lang/Object;
.source "ArticleListViewBinder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->b(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/RecyclerView;

.field final synthetic b:Landroid/os/Parcelable;

.field final synthetic c:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;Landroid/support/v7/widget/RecyclerView;Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;->c:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;->a:Landroid/support/v7/widget/RecyclerView;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;->b:Landroid/os/Parcelable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;->a:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$1;->b:Landroid/os/Parcelable;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->a(Landroid/os/Parcelable;)V

    .line 148
    return-void
.end method
