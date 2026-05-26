.class public Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.super Ljava/lang/Object;
.source "BasicAsync.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async;
.implements Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/control/BasicAsync$ChainedAsync;,
        Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<TT;>;",
        "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private a:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/Throwable;

.field private c:Z

.field private d:Z

.field private e:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;>;"
        }
    .end annotation
.end field

.field private f:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    .line 51
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    .line 52
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    return-void
.end method

.method public static c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 76
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public static c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Throwable;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 69
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public static g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 62
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    return-object v0
.end method

.method public static h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 83
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

    if-eqz v0, :cond_1

    .line 131
    :cond_0
    :goto_0
    return-object p0

    .line 125
    :cond_1
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c:Z

    if-eqz v0, :cond_2

    .line 126
    invoke-interface {p1, p0}, Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    goto :goto_0

    .line 128
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c:Z

    if-eqz v0, :cond_1

    .line 117
    :cond_0
    :goto_0
    return-object p0

    .line 111
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

    if-eqz v0, :cond_2

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

    invoke-interface {p1, p0, v0}, Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 114
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

    if-eqz v0, :cond_1

    .line 103
    :cond_0
    :goto_0
    return-object p0

    .line 95
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a:Ljava/lang/Object;

    if-eqz v0, :cond_2

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a:Ljava/lang/Object;

    invoke-interface {p1, p0, v0}, Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V

    .line 99
    :cond_2
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c:Z

    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<-TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 209
    if-ne p1, p0, :cond_0

    .line 227
    :goto_0
    return-object p0

    .line 213
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;-><init>(Lcom/salesforce/android/service/common/utilities/control/BasicAsync;Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public synthetic a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 268
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f()Z

    move-result v0

    if-nez v0, :cond_0

    .line 282
    :goto_0
    return-object p0

    .line 272
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c:Z

    .line 274
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;

    .line 275
    invoke-interface {v0, p0}, Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    goto :goto_1

    .line 278
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 279
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 280
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    goto :goto_0
.end method

.method public a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 236
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    .line 246
    :cond_0
    return-object p0

    .line 240
    :cond_1
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a:Ljava/lang/Object;

    .line 242
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;

    .line 243
    invoke-interface {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 250
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f()Z

    move-result v0

    if-nez v0, :cond_0

    .line 264
    :goto_0
    return-object p0

    .line 254
    :cond_0
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

    .line 256
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;

    .line 257
    invoke-interface {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 260
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 261
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 262
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 165
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 160
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S::",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;:",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ":",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ">(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-object v0, p1

    .line 137
    check-cast v0, Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 138
    check-cast p1, Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 139
    return-object p0
.end method

.method public synthetic b(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public c(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S::",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;:",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ":",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ">(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 170
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-object v0, p1

    .line 171
    check-cast v0, Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 172
    check-cast p1, Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 173
    return-object p0
.end method

.method public c(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+TS;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TS;>;"
        }
    .end annotation

    .prologue
    .line 198
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$MappedAsync;-><init>(Lcom/salesforce/android/service/common/utilities/control/BasicAsync;Lcom/salesforce/android/service/common/utilities/functional/Function;)V

    return-object v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f()Z

    move-result v0

    if-nez v0, :cond_0

    .line 150
    :goto_0
    return-void

    .line 147
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d:Z

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 149
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    goto :goto_0
.end method

.method public d(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 155
    return-object p0
.end method

.method public d(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<+TS;>;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TS;>;"
        }
    .end annotation

    .prologue
    .line 203
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$ChainedAsync;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$ChainedAsync;-><init>(Lcom/salesforce/android/service/common/utilities/control/BasicAsync;Lcom/salesforce/android/service/common/utilities/functional/Function;)V

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 181
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c:Z

    return v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->b:Ljava/lang/Throwable;

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
    .line 189
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->i()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->e()Z

    move-result v0

    if-nez v0, :cond_0

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
    .line 177
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d:Z

    return v0
.end method
