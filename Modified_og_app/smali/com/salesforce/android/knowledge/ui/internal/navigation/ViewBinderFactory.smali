.class public Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;
.super Ljava/lang/Object;
.source "ViewBinderFactory.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
            "<*>;)",
            "Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;"
        }
    .end annotation

    .prologue
    .line 46
    instance-of v0, p2, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    if-eqz v0, :cond_0

    .line 47
    check-cast p2, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    .line 48
    invoke-static {p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    move-result-object v0

    .line 69
    :goto_0
    return-object v0

    .line 51
    :cond_0
    instance-of v0, p2, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    if-eqz v0, :cond_1

    .line 52
    check-cast p2, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    .line 53
    invoke-static {p2}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;

    move-result-object v0

    goto :goto_0

    .line 56
    :cond_1
    instance-of v0, p2, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    if-eqz v0, :cond_2

    .line 57
    check-cast p2, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    .line 58
    invoke-static {p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListViewBinder;

    move-result-object v0

    goto :goto_0

    .line 61
    :cond_2
    instance-of v0, p2, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    if-eqz v0, :cond_3

    .line 62
    check-cast p2, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    .line 63
    invoke-static {p2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailViewBinder;

    move-result-object v0

    goto :goto_0

    .line 66
    :cond_3
    instance-of v0, p2, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    if-eqz v0, :cond_4

    .line 67
    check-cast p2, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    .line 68
    const-string v0, "input_method"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 69
    invoke-static {p2, v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;Landroid/view/inputmethod/InputMethodManager;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;

    move-result-object v0

    goto :goto_0

    .line 72
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unknown Presenter type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
