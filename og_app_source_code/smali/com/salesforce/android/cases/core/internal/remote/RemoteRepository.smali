.class public Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;
.super Ljava/lang/Object;
.source "RemoteRepository.java"

# interfaces
.implements Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

.field private final b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;)V
    .locals 2

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->a()Lcom/salesforce/android/cases/core/internal/http/HttpService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    if-nez v0, :cond_0

    .line 68
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "HttpService cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 71
    :cond_0
    invoke-static {p1}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;)Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->b:Landroid/content/Context;

    .line 72
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;-><init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseDetailRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseFeed;",
            ">;"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CommentPostRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CommentPost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ">;"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListView;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public c()Z
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->b:Landroid/content/Context;

    const-string v1, "connectivity"

    .line 124
    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 125
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 127
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
