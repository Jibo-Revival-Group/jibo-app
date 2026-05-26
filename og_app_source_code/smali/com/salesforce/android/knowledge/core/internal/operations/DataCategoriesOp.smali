.class Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;
.super Ljava/lang/Object;
.source "DataCategoriesOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

.field private final b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

.field private c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 42
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    .line 43
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    .line 44
    return-void
.end method


# virtual methods
.method public e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 48
    return-object p0
.end method

.method public f()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
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
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method
