.class public Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;
.super Ljava/lang/Object;
.source "ArticleDetailPresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field final b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 0

    .prologue
    .line 198
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 200
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;->b:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 201
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;
    .locals 1

    .prologue
    .line 204
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenterImpl$Builder;)V

    return-object v0
.end method
