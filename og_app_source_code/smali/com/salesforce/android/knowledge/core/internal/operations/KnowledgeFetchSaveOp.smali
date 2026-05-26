.class public abstract Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;
.super Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;
.source "KnowledgeFetchSaveOp.java"


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
.field final b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

.field final c:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            ")V"
        }
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)V

    .line 40
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    .line 41
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->c:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    .line 42
    return-void
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/service/common/fetchsave/exceptions/OfflineException;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Lcom/salesforce/android/knowledge/core/exceptions/KnowledgeOfflineException;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->b()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/core/exceptions/KnowledgeOfflineException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method protected abstract a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected abstract a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "TS;TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end method

.method protected abstract a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            "TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 45
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    invoke-virtual {p0, v0, p1}, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
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
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->b:Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;

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
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->c:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    invoke-virtual {p0, v0, p1}, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected abstract b()Ljava/lang/String;
.end method

.method protected c()Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;->c:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    return-object v0
.end method
