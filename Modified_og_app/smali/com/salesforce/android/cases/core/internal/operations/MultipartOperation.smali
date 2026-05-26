.class public abstract Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;
.super Ljava/lang/Object;
.source "MultipartOperation.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;
.implements Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;",
        "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/control/Async;",
            ">;"
        }
    .end annotation
.end field

.field private c:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    .line 48
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 49
    return-void
.end method


# virtual methods
.method abstract a()V
.end method

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
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->c:Z

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 94
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 105
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 106
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 107
    return-void
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 110
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/Async;->c()V

    .line 111
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 112
    return-void
.end method

.method abstract b()Z
.end method

.method public c(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 116
    return-void
.end method

.method abstract d()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public final e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a()V

    .line 58
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->c:Z

    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 63
    :cond_0
    return-object p0
.end method

.method public f()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method public g()V
    .locals 2

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->d()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;->d()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 100
    :cond_0
    return-void
.end method
