.class Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;
.super Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;
.source "ArticleListPresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ArticleListHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

.field private final b:I


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;I)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;-><init>()V

    .line 166
    iput p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->b:I

    .line 167
    return-void
.end method

.method private g()V
    .locals 2

    .prologue
    .line 199
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->b:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 200
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    :goto_0
    return-void

    .line 202
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->f(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
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
    .line 193
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f()V

    .line 194
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->g()V

    .line 195
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ")V"
        }
    .end annotation

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->c:Ljava/util/List;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 185
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->c()Z

    move-result v1

    iput-boolean v1, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->d:Z

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->c()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;->a(Ljava/util/List;Z)V

    .line 190
    :cond_0
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 162
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

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
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->f()V

    .line 180
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->g()V

    .line 181
    return-void
.end method

.method protected c()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 170
    invoke-static {}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->a()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 171
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v2, v2, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->b:Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    const/4 v1, 0x1

    .line 172
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->c(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    const/16 v1, 0xa

    .line 173
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->b(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->b:I

    .line 174
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl$ArticleListHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListPresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 175
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 170
    return-object v0
.end method
