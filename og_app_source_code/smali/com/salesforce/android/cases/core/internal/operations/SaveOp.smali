.class abstract Lcom/salesforce/android/cases/core/internal/operations/SaveOp;
.super Ljava/lang/Object;
.source "SaveOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;,
        Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Lcom/salesforce/android/cases/core/requests/SaveRequest;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/cases/core/requests/SaveRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private final b:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private final c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private final d:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/requests/SaveRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->d:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 43
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    .line 44
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->b:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 45
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 46
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->d:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/cases/core/requests/SaveRequest;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;)Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/operations/SaveOp;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/cases/core/internal/operations/SaveOp",
            "<TS;TT;>;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/SaveRequest;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->b:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$LocalRepositoryHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;Lcom/salesforce/android/cases/core/internal/operations/SaveOp$1;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 61
    :cond_0
    :goto_0
    return-object p0

    .line 57
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/SaveRequest;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a:Lcom/salesforce/android/cases/core/requests/SaveRequest;

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp$RemoteRepositoryHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/SaveOp;Lcom/salesforce/android/cases/core/internal/operations/SaveOp$1;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method protected a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 69
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/requests/SaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            "TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 73
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->a()Lcom/salesforce/android/cases/core/internal/operations/SaveOp;

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
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/SaveOp;->d:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method
