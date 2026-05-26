.class public abstract Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;
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
.field private a:Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->c()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 42
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 43
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async;->c(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 49
    :cond_0
    return-void
.end method

.method protected abstract c()Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

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

.method public e()Z
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

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

.method public f()Z
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/AbstractHandler;->a:Lcom/salesforce/android/service/common/utilities/control/Async;

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
