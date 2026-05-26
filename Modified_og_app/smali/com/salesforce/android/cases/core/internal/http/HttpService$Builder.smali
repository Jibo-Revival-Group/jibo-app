.class public Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;
.super Ljava/lang/Object;
.source "HttpService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/http/HttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lokhttp3/HttpUrl;

.field private final c:J

.field private final d:Z

.field private e:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private f:Lcom/salesforce/android/service/common/http/HttpClient;

.field private g:Lcom/salesforce/androidsdk/rest/ClientManager;

.field private final h:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)V
    .locals 2

    .prologue
    .line 439
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 440
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->a:Landroid/content/Context;

    .line 441
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/CaseConfiguration;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lokhttp3/HttpUrl;->e(Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->b:Lokhttp3/HttpUrl;

    .line 442
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/CaseConfiguration;->e()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->c:J

    .line 443
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/CaseConfiguration;->d()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->d:Z

    .line 444
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/CaseConfiguration;->i()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->h:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 445
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/http/HttpService;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 448
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_0

    .line 449
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newCachedThreadPool(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 452
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->f:Lcom/salesforce/android/service/common/http/HttpClient;

    if-nez v0, :cond_2

    .line 454
    new-instance v0, Lokhttp3/ConnectionSpec$Builder;

    sget-object v1, Lokhttp3/ConnectionSpec;->a:Lokhttp3/ConnectionSpec;

    invoke-direct {v0, v1}, Lokhttp3/ConnectionSpec$Builder;-><init>(Lokhttp3/ConnectionSpec;)V

    new-array v1, v4, [Lokhttp3/TlsVersion;

    sget-object v2, Lokhttp3/TlsVersion;->TLS_1_2:Lokhttp3/TlsVersion;

    aput-object v2, v1, v3

    .line 455
    invoke-virtual {v0, v1}, Lokhttp3/ConnectionSpec$Builder;->a([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;

    move-result-object v0

    .line 456
    invoke-virtual {v0}, Lokhttp3/ConnectionSpec$Builder;->a()Lokhttp3/ConnectionSpec;

    move-result-object v0

    .line 458
    invoke-static {}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->b()Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v1

    .line 460
    iget-boolean v2, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->d:Z

    if-eqz v2, :cond_1

    .line 462
    const/4 v2, 0x2

    new-array v2, v2, [Lokhttp3/ConnectionSpec;

    aput-object v0, v2, v3

    sget-object v0, Lokhttp3/ConnectionSpec;->c:Lokhttp3/ConnectionSpec;

    aput-object v0, v2, v4

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Ljava/util/List;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    .line 466
    :cond_1
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v2

    const-string v3, "service_case_response_cache"

    invoke-direct {v0, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 467
    const/high16 v2, 0xa00000

    .line 468
    new-instance v3, Lokhttp3/Cache;

    int-to-long v4, v2

    invoke-direct {v3, v0, v4, v5}, Lokhttp3/Cache;-><init>(Ljava/io/File;J)V

    .line 471
    new-instance v2, Lokhttp3/logging/HttpLoggingInterceptor;

    invoke-direct {v2}, Lokhttp3/logging/HttpLoggingInterceptor;-><init>()V

    .line 472
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->d:Z

    if-eqz v0, :cond_4

    sget-object v0, Lokhttp3/logging/HttpLoggingInterceptor$Level;->BODY:Lokhttp3/logging/HttpLoggingInterceptor$Level;

    :goto_0
    invoke-virtual {v2, v0}, Lokhttp3/logging/HttpLoggingInterceptor;->a(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;

    .line 475
    new-instance v0, Lcom/salesforce/android/service/common/http/TlsSocketFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/http/TlsSocketFactory;-><init>()V

    .line 476
    invoke-static {}, Lcom/salesforce/android/service/common/http/TlsSocketFactory;->a()Ljavax/net/ssl/X509TrustManager;

    move-result-object v4

    .line 475
    invoke-interface {v1, v0, v4}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/http/ServiceCaseInterceptor;

    iget-wide v4, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->c:J

    invoke-direct {v1, v4, v5}, Lcom/salesforce/android/cases/core/internal/http/ServiceCaseInterceptor;-><init>(J)V

    .line 477
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->b(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 478
    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 479
    invoke-interface {v0, v3}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Lokhttp3/Cache;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 480
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->f:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 483
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->g:Lcom/salesforce/androidsdk/rest/ClientManager;

    if-nez v0, :cond_3

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 484
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->g:Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 487
    :cond_3
    new-instance v0, Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/http/HttpService;-><init>(Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;)V

    return-object v0

    .line 472
    :cond_4
    sget-object v0, Lokhttp3/logging/HttpLoggingInterceptor$Level;->NONE:Lokhttp3/logging/HttpLoggingInterceptor$Level;

    goto :goto_0
.end method

.method b()Lokhttp3/HttpUrl;
    .locals 1

    .prologue
    .line 491
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->b:Lokhttp3/HttpUrl;

    return-object v0
.end method

.method c()Lcom/salesforce/android/service/common/utilities/threading/JobQueue;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->e:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    return-object v0
.end method

.method d()Lcom/salesforce/android/service/common/http/HttpClient;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->f:Lcom/salesforce/android/service/common/http/HttpClient;

    return-object v0
.end method

.method e()Lcom/salesforce/androidsdk/rest/ClientManager;
    .locals 1

    .prologue
    .line 503
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->g:Lcom/salesforce/androidsdk/rest/ClientManager;

    return-object v0
.end method

.method f()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 507
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->h:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method
