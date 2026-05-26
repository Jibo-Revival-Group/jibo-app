.class public abstract Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;
.super Ljava/lang/Object;
.source "AbstractMultipartRequestHandler.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$Handler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$Handler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    .line 35
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
    .line 38
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 39
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
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    invoke-interface {v0, p2}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->a(Ljava/lang/Throwable;)V

    .line 43
    return-void
.end method
