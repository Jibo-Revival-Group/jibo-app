.class Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;
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
    name = "RemoteRepositoryHandler"
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
    .line 95
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;Lcom/salesforce/android/cases/core/internal/operations/SaveOp$1;)V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)V

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
    .line 106
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 107
    return-void
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
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 103
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
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 99
    return-void
.end method
