.class public abstract Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;
.super Ljava/lang/Object;
.source "FetchSaveOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;,
        Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$HttpHandler;,
        Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$DbHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private b:Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private d:Z

.field private final e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)V"
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 57
    iput-object p1, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    .line 59
    return-void
.end method


# virtual methods
.method protected abstract a()Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;
.end method

.method protected abstract a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected abstract a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end method

.method a(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 105
    return-void
.end method

.method a(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 109
    return-void
.end method

.method protected abstract b(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method b(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 124
    new-instance v0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;-><init>(Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;)V

    .line 125
    iget-object v1, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {p0, v1, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->b:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 126
    return-void
.end method

.method b(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d:Z

    if-eqz v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->i()V

    .line 134
    :goto_0
    return-void

    .line 132
    :cond_0
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected abstract c()Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;
.end method

.method c(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 137
    iput-object p1, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->c:Ljava/lang/Object;

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->n()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d:Z

    if-nez v0, :cond_1

    .line 139
    :cond_0
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Object;)V

    .line 141
    :cond_1
    return-void
.end method

.method c(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->c:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 155
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->n()Z

    move-result v0

    if-nez v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->c:Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Object;)V

    .line 158
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->g()V

    .line 162
    :goto_0
    return-void

    .line 160
    :cond_1
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public d()Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp",
            "<TS;TT;>;"
        }
    .end annotation

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->c()Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;->c()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d:Z

    .line 72
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->m()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->h()V

    .line 78
    :goto_0
    return-object p0

    .line 75
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->i()V

    goto :goto_0
.end method

.method d(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 165
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Object;)V

    .line 166
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->b(Ljava/lang/Object;)V

    .line 169
    :cond_0
    return-void
.end method

.method d(Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 178
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Throwable;)V

    .line 179
    return-void
.end method

.method public synthetic e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1

    .prologue
    .line 42
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d()Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;

    move-result-object v0

    return-object v0
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
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method g()V
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->e:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 113
    return-void
.end method

.method h()V
    .locals 2

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$DbHandler;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$DbHandler;-><init>(Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 117
    return-void
.end method

.method i()V
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a:Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->b(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$HttpHandler;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$HttpHandler;-><init>(Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 121
    return-void
.end method

.method j()V
    .locals 1

    .prologue
    .line 144
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d:Z

    if-eqz v0, :cond_0

    .line 145
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->i()V

    .line 151
    :goto_0
    return-void

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->c:Ljava/lang/Object;

    if-nez v0, :cond_1

    .line 147
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a()Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 149
    :cond_1
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->g()V

    goto :goto_0
.end method

.method k()V
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->b:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-nez v0, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->g()V

    .line 175
    :cond_0
    return-void
.end method

.method l()V
    .locals 0

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->g()V

    .line 183
    return-void
.end method
