.class public Lcom/salesforce/android/cases/core/internal/http/HttpService;
.super Ljava/lang/Object;
.source "HttpService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;
    }
.end annotation


# instance fields
.field private final a:Lokhttp3/HttpUrl;

.field private final b:Lcom/google/gson/Gson;

.field private final c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private final d:Lcom/salesforce/android/service/common/http/HttpClient;

.field private final e:Lcom/salesforce/androidsdk/rest/ClientManager;

.field private final f:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;)V
    .locals 3

    .prologue
    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 147
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->b()Lokhttp3/HttpUrl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a:Lokhttp3/HttpUrl;

    .line 148
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    .line 149
    invoke-static {}, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a()Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    .line 150
    invoke-static {}, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a()Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 151
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    .line 152
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->c()Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 153
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->d()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 154
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->e()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->e:Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 155
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->f()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->f:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 157
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a:Lokhttp3/HttpUrl;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->a()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 158
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "HttpUrl cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_2

    .line 162
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "JobQueue cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 165
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    if-nez v0, :cond_3

    .line 166
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "OkHttpClient cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 168
    :cond_3
    return-void
.end method

.method private a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lokhttp3/Request;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 413
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 414
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->e:Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->f:Lcom/salesforce/androidsdk/accounts/UserAccount;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-static {v0, v1, p1, p2, v2}, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->a(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/accounts/UserAccount;Lokhttp3/Request;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;

    move-result-object v0

    .line 420
    :goto_0
    return-object v0

    .line 416
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 417
    invoke-static {p1}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a(Lokhttp3/Request;)Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-static {v0, v1, p2, v2}, Lcom/salesforce/android/service/common/http/HttpJob;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob;

    move-result-object v0

    goto :goto_0
.end method

.method private c(Ljava/lang/String;)Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 397
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->h()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "quickActions"

    .line 398
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 399
    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "defaultValues"

    .line 400
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 401
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 397
    return-object v0
.end method

.method private h()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 337
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "services/data"

    .line 338
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->f(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "v37.0"

    .line 339
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 340
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 337
    return-object v0
.end method

.method private i()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 344
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->h()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "support"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method private j()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 348
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->h()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "sobjects"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method private k()Lokhttp3/Request$Builder;
    .locals 3

    .prologue
    .line 405
    new-instance v0, Lokhttp3/Request$Builder;

    invoke-direct {v0}, Lokhttp3/Request$Builder;-><init>()V

    const-string v1, "Accept"

    const-string v2, "application/json; charset=utf-8"

    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v0

    const-string v1, "Accept-Language"

    const-string v2, "en, en-US"

    .line 406
    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v0

    .line 405
    return-object v0
.end method

.method private l()Z
    .locals 1

    .prologue
    .line 424
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->f:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
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
    .line 202
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 203
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 204
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CommunitiesListResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 206
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$3;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$3;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
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
    .line 279
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->e()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 280
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 281
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 283
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$8;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$8;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
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
    .line 265
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "filterGroup"

    const-string v2, "Small"

    .line 266
    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 267
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 268
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 269
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 271
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$7;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$7;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
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
    .line 246
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->f()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "q"

    const-string v2, "Select Case.Id, Case.CaseNumber, Case.Subject, Case.LastModifiedDate, Case.CreatedDate, (Select CaseFeed.Body, CaseFeed.CreatedById, CaseFeed.LastModifiedDate, CaseFeed.IsRichText from Case.Feeds where Type=\'TextPost\' Order By CaseFeed.LastModifiedDate DESC limit 1) from Case %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 247
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseListRequest;->a()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 248
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 249
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 250
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 252
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$6;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$6;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
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
    .line 291
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 292
    const-string v1, "feedElementType"

    const-string v2, "feeditem"

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v1

    const-string v2, "subjectId"

    .line 294
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v1

    const-string v2, "text"

    .line 295
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v1

    const-string v2, "visibility"

    const-string v3, "allusers"

    .line 296
    invoke-virtual {v1, v2, v3}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 299
    const/4 v1, 0x0

    const/4 v2, 0x0

    new-array v2, v2, [B

    invoke-static {v1, v2}, Lokhttp3/RequestBody;->a(Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;

    move-result-object v1

    .line 300
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v2

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v2, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    .line 301
    invoke-virtual {v0, v1}, Lokhttp3/Request$Builder;->a(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    move-result-object v0

    const-string v1, "X-Chatter-Entity-Encoding"

    const-string v2, "false"

    .line 302
    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v0

    .line 303
    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 305
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 307
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$9;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$9;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
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
    .line 175
    .line 176
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->f(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 177
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    const-string v1, "force_caching"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 178
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 180
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$1;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
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
    .line 188
    .line 189
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->f(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 190
    sget-object v1, Lcom/salesforce/android/cases/core/internal/http/util/HttpConstants;->a:Lokhttp3/MediaType;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->b()Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lokhttp3/RequestBody;->a(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v1

    .line 191
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v2

    invoke-virtual {v2, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lokhttp3/Request$Builder;->a(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 192
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 194
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$2;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
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
    .line 315
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;->a()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c(Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 316
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 317
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 319
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$10;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$10;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
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
    .line 234
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->b(Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    .line 235
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 236
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 238
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$5;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$5;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method a(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    .locals 2

    .prologue
    .line 379
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 380
    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "chatter"

    .line 381
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "feed-elements"

    .line 382
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 379
    return-object v0
.end method

.method a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 364
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->d()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 365
    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "chatter"

    .line 366
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "feeds"

    .line 367
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "record"

    .line 368
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 369
    invoke-virtual {v0, p2}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "feed-elements"

    .line 370
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 371
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 364
    return-object v0
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
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
    .line 218
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->e()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "listviews"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 219
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->k()Lokhttp3/Request$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 220
    const-class v1, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lokhttp3/Request;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    .line 222
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/HttpService$4;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$4;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method b(Ljava/lang/String;)Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 390
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->g()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 391
    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "describe"

    .line 392
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 393
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 390
    return-object v0
.end method

.method c()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 352
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->i()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "quickActions"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method d()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 356
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->h()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "connect"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "communities"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method e()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 360
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->j()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "Case"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method f()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 375
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->h()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "query"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method

.method g()Lokhttp3/HttpUrl;
    .locals 2

    .prologue
    .line 386
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;->e()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "listviews"

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    return-object v0
.end method
