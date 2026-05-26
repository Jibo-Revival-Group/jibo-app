.class Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;
.super Ljava/lang/Object;
.source "SaveOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/operations/SaveOp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LocalRepositoryHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$Handler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;Lcom/salesforce/android/cases/core/internal/operations/SaveOp$1;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)V

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
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->b(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/cases/core/requests/SaveRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/SaveRequest;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->c(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v2}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->b(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/cases/core/requests/SaveRequest;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;Lcom/salesforce/android/cases/core/internal/operations/SaveOp$1;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 92
    :goto_0
    return-void

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;TT;)V"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 84
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
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 80
    return-void
.end method
