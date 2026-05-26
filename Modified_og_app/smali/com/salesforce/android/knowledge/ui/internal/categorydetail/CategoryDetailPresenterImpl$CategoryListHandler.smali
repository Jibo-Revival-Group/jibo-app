.class Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;
.super Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;
.source "CategoryDetailPresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CategoryListHandler"
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
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$1;)V
    .locals 0

    .prologue
    .line 208
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;-><init>(Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;)V

    return-void
.end method

.method private g()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f()V

    .line 230
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->g()V

    .line 231
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
    .line 222
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    .line 223
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/DataCategoryList;->a()Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v2, v2, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    .line 224
    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->d()I

    move-result v2

    invoke-static {v2}, Lcom/salesforce/android/knowledge/ui/internal/models/Models;->a(I)Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v3, v3, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 225
    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v3

    .line 222
    invoke-static {v1, v2, v3}, Lcom/salesforce/android/knowledge/ui/internal/models/Models;->a(Ljava/util/Collection;Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f:Ljava/util/List;

    .line 226
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 208
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/DataCategoryList;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/DataCategoryList;)V

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
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->f()V

    .line 217
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->g()V

    .line 218
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
    .line 210
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 211
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl$CategoryListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/categorydetail/CategoryDetailPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 212
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 210
    return-object v0
.end method
