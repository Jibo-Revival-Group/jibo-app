.class public Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;
.super Ljava/lang/Object;
.source "OfflineResourceCacher.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/LogoutListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private final b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

.field private final c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

.field private final d:Lcom/salesforce/android/knowledge/core/offline/ArticleParser;

.field private final e:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/core/offline/ArticleParser;Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V
    .locals 1

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 80
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    .line 81
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    .line 82
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->d:Lcom/salesforce/android/knowledge/core/offline/ArticleParser;

    .line 83
    iput-object p5, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->e:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    invoke-interface {p6, p0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V

    .line 88
    :cond_0
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;
    .locals 8

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    move-result-object v2

    .line 95
    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->e()I

    move-result v0

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v3

    invoke-static {v0, v3}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    .line 96
    invoke-static {v2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    move-result-object v3

    .line 97
    new-instance v4, Lcom/salesforce/android/knowledge/core/offline/ArticleParser;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0}, Lcom/salesforce/android/knowledge/core/offline/ArticleParser;-><init>(Ljava/lang/String;)V

    .line 100
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a()Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestClient;->d()Lokhttp3/OkHttpClient;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a(Lokhttp3/OkHttpClient;)Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClient;->a()Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    const-wide/16 v6, 0x5

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 101
    invoke-interface {v0, v6, v7, v5}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    const-wide/16 v6, 0xa

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 102
    invoke-interface {v0, v6, v7, v5}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->b(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 103
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    .line 104
    new-instance v5, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;

    invoke-direct {v5, v0}, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;-><init>(Lcom/salesforce/android/service/common/http/HttpClient;)V

    .line 106
    new-instance v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;-><init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/core/offline/ArticleParser;Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 139
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 148
    :goto_0
    return-object v0

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->d:Lcom/salesforce/android/knowledge/core/offline/ArticleParser;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/core/offline/ArticleParser;->a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 144
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    new-instance v3, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    iget-object v5, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->e:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;

    invoke-direct {v3, v0, v4, v5}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;-><init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;)V

    invoke-virtual {v2, v3}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_1

    .line 148
    :cond_1
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b()Z

    move-result v0

    if-nez v0, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b()Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    return-object v0
.end method
