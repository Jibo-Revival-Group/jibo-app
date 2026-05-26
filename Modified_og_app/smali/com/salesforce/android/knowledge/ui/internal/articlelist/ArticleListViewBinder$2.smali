.class Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$2;
.super Ljava/lang/Object;
.source "ArticleListViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;


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
    .line 164
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public s_()V
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;->a()V

    .line 167
    return-void
.end method
