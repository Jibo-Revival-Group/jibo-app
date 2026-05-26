.class Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;
.super Ljava/lang/Object;
.source "ArticleDetailsOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;->a:Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ")V"
        }
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;->a:Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a(Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 67
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 63
    check-cast p2, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V

    return-void
.end method
