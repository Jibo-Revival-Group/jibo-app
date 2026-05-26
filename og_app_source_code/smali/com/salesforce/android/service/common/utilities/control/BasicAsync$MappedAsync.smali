.class Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;
.super Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.source "BasicAsync.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MappedAsync"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "S:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
        "<TS;>;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
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

.field private final b:Lcom/salesforce/android/service/common/utilities/functional/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+TS;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/control/BasicAsync;Lcom/salesforce/android/service/common/utilities/functional/Function;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;",
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+TS;>;)V"
        }
    .end annotation

    .prologue
    .line 294
    invoke-direct {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    .line 295
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 296
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->b:Lcom/salesforce/android/service/common/utilities/functional/Function;

    .line 297
    invoke-virtual {p1, p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 298
    return-void
.end method


# virtual methods
.method public synthetic a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
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
    .line 322
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 323
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
    .line 313
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->b:Lcom/salesforce/android/service/common/utilities/functional/Function;

    invoke-interface {v0, p2}, Lcom/salesforce/android/service/common/utilities/functional/Function;->a(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 318
    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 319
    :goto_0
    return-void

    .line 314
    :catch_0
    move-exception v0

    .line 315
    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 0
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
    .line 306
    invoke-virtual {p0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 307
    return-void
.end method

.method public synthetic b(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 301
    invoke-super {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c()V

    .line 302
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c()V

    .line 303
    return-void
.end method
