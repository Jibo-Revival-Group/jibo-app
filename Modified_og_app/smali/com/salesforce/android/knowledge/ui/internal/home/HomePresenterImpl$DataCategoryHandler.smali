.class Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;
.super Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;
.source "HomePresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DataCategoryHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;)V
    .locals 0

    .prologue
    .line 240
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;-><init>()V

    return-void
.end method

.method private g()V
    .locals 0

    .prologue
    .line 270
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->c()V

    .line 271
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 258
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e()V

    .line 259
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->g()V

    .line 262
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 263
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-direct {v2, v3, v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V

    .line 264
    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$ArticleListHandler;->a()V

    .line 265
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->f:Ljava/util/Set;

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 267
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/DataCategoryList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ")V"
        }
    .end annotation

    .prologue
    .line 253
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/DataCategoryList;->a()Ljava/util/List;

    move-result-object v0

    .line 254
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v2, v2, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->c:Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v3, v3, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/salesforce/android/knowledge/ui/internal/models/Models;->a(Ljava/util/Collection;Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Ljava/util/List;

    move-result-object v0

    iput-object v0, v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->j:Ljava/util/List;

    .line 255
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 240
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/DataCategoryList;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/DataCategoryList;)V

    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 248
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e()V

    .line 249
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->g()V

    .line 250
    return-void
.end method

.method protected c()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 242
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 243
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->b:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 244
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 242
    return-object v0
.end method
