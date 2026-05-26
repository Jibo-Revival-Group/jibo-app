.class public abstract Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;
.super Ljava/lang/Object;
.source "AbstractHandler.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field c:Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end field

.field d:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field e:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private b(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 116
    instance-of v0, p1, Ljava/io/IOException;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;

    if-eqz v0, :cond_1

    .line 117
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c()V

    .line 121
    :goto_0
    return-void

    .line 119
    :cond_1
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected abstract a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 87
    return-void
.end method

.method public final a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;TT;)V"
        }
    .end annotation

    .prologue
    .line 95
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->d:Ljava/lang/Object;

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->d:Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->a(Ljava/lang/Object;)V

    .line 97
    return-void
.end method

.method public final a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
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
    .line 90
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->e:Ljava/lang/Throwable;

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->e:Ljava/lang/Throwable;

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->b(Ljava/lang/Throwable;)V

    .line 92
    return-void
.end method

.method protected abstract a(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected abstract a(Ljava/lang/Throwable;)V
.end method

.method protected abstract b()V
.end method

.method protected abstract c()V
.end method

.method public d()V
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_2

    .line 47
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->e:Ljava/lang/Throwable;

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->b(Ljava/lang/Throwable;)V

    .line 66
    :goto_0
    return-void

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->d:Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 52
    :cond_1
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->b()V

    goto :goto_0

    .line 57
    :cond_2
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->b()V

    .line 60
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public e()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->c(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 72
    :cond_0
    iput-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->e:Ljava/lang/Throwable;

    .line 73
    iput-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->d:Ljava/lang/Object;

    .line 74
    iput-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 75
    return-void
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public g()Z
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->c:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public i()Z
    .locals 1

    .prologue
    .line 112
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->h()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->g()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
