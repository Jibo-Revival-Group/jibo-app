.class Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$3;
.super Ljava/lang/Object;
.source "ArticleListViewBinder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$3;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$3;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;)Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->requestLayout()V

    .line 190
    return-void
.end method
