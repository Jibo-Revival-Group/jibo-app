.class abstract Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;
.super Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;
.source "CaseFetchSaveOperation.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp",
        "<TS;TT;>;"
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private final b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private final c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V
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
    .line 50
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)V

    .line 46
    const-class v0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 51
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 52
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 53
    return-void
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;
    .locals 2

    .prologue
    .line 95
    new-instance v0, Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;

    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->b()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
    .line 59
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "TS;TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 64
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method protected abstract a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            "TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    if-nez v0, :cond_0

    .line 76
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Operations that support caching must provide a LocalRepository."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    invoke-virtual {p0, v0, p1}, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    if-nez v0, :cond_0

    .line 88
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Operations that support caching must provide a LocalRepository."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a(Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected b(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {p0, v0, p1}, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected abstract b()Ljava/lang/String;
.end method

.method protected c()Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/CaseFetchSaveOperation;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    return-object v0
.end method
