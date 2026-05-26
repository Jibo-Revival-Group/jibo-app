.class public Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;
.super Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;
.source "DefaultValuesHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler",
        "<",
        "Lcom/salesforce/android/cases/core/model/DefaultValues;",
        ">;"
    }
.end annotation


# instance fields
.field private final b:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;)V

    .line 35
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;->b:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    .line 36
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/model/DefaultValues;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ")V"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;->b:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->g()V

    .line 41
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p2, Lcom/salesforce/android/cases/core/model/DefaultValues;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/model/DefaultValues;)V

    return-void
.end method
