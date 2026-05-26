.class public Lcom/salesforce/android/cases/core/internal/operations/SetCaseHiddenOp;
.super Lcom/salesforce/android/cases/core/internal/operations/SaveOp;
.source "SetCaseHiddenOp.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/internal/operations/SaveOp",
        "<",
        "Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;-><init>(Lcom/salesforce/android/cases/core/requests/SaveRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    .line 37
    return-void
.end method


# virtual methods
.method public bridge synthetic a()Lcom/salesforce/android/cases/core/internal/operations/SaveOp;
    .locals 1

    .prologue
    .line 32
    invoke-super {p0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a()Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 32
    check-cast p2, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/SetCaseHiddenOp;->a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->d()Z

    move-result v1

    invoke-interface {p1, v0, v1}, Lcom/salesforce/android/cases/core/internal/local/LocalRepository;->a(Ljava/lang/String;Z)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic f()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 32
    invoke-super {p0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
