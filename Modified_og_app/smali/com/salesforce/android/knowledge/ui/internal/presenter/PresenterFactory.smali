.class public Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;
.super Ljava/lang/Object;
.source "PresenterFactory.java"


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 61
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;
    .locals 1

    .prologue
    .line 56
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;->a()Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenter;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/content/Context;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;

    move-result-object v0

    .line 69
    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;

    move-result-object v0

    .line 70
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$Builder;->a()Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    move-result-object v0

    .line 68
    return-object v0
.end method

.method public a()Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    move-result-object v0

    return-object v0
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenter;

    move-result-object v0

    return-object v0
.end method
