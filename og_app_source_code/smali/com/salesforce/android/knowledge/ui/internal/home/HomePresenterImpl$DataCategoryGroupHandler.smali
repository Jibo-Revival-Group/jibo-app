.class Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;
.super Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;
.source "HomePresenterImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DataCategoryGroupHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;-><init>()V

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
    .line 232
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryHandler;->a()V

    .line 233
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ")V"
        }
    .end annotation

    .prologue
    .line 229
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 215
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V

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
    .line 224
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->e()V

    .line 225
    return-void
.end method

.method protected c()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 218
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 219
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;->a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl$DataCategoryGroupHandler;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenterImpl;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 220
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 218
    return-object v0
.end method
