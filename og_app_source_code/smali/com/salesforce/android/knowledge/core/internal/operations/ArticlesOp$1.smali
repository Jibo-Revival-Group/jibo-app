.class Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp$1;
.super Ljava/lang/Object;
.source "ArticlesOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;->a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;",
        "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

.field final synthetic b:Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp$1;->b:Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp$1;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;)Lcom/salesforce/android/knowledge/core/model/ArticleList;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp$1;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 58
    check-cast p1, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp$1;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;)Lcom/salesforce/android/knowledge/core/model/ArticleList;

    move-result-object v0

    return-object v0
.end method
