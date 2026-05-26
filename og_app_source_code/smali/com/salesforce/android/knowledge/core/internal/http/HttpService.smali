.class public Lcom/salesforce/android/knowledge/core/internal/http/HttpService;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/fetchsave/internal/http/HttpService;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;,
        Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;,
        Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;
    }
.end annotation


# static fields
.field private static final e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field a:Z

.field final b:Lcom/google/gson/Gson;

.field final c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field final d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

.field private final f:Lokhttp3/HttpUrl;

.field private final g:Landroid/content/Context;

.field private final h:Ljava/lang/String;

.field private final i:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    .line 74
    new-instance v2, Lcom/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-string v3, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-virtual {v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v2

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    .line 88
    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Initializing HttpService with community URL {}"

    new-array v4, v0, [Ljava/lang/Object;

    iget-object v5, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->c:Lokhttp3/HttpUrl;

    aput-object v5, v4, v1

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 90
    iget-object v2, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->c:Lokhttp3/HttpUrl;

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->f:Lokhttp3/HttpUrl;

    .line 91
    iget-object v2, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->a:Landroid/content/Context;

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->g:Landroid/content/Context;

    .line 92
    iget-object v2, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 93
    iget-object v2, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->f:Ljava/lang/String;

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->i:Ljava/lang/String;

    .line 94
    iget-object v2, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->e:Ljava/lang/String;

    iput-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->h:Ljava/lang/String;

    .line 95
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->i:Ljava/lang/String;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->h:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    .line 96
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    .line 97
    return-void

    :cond_0
    move v0, v1

    .line 95
    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;
    .locals 6

    .prologue
    .line 100
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V

    return-object v0
.end method

.method private a(Lokhttp3/HttpUrl;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 3

    .prologue
    .line 201
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept"

    const-string v2, "application/json"

    .line 202
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept-Language"

    .line 203
    invoke-interface {v0, v1, p2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 204
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 201
    return-object v0
.end method


# virtual methods
.method protected a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 208
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->i:Ljava/lang/String;

    .line 209
    :goto_0
    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lokhttp3/HttpUrl;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    return-object v0

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->h:Ljava/lang/String;

    goto :goto_0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse;",
            ">;"
        }
    .end annotation

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->f:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "dataCategoryGroups"

    .line 122
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "sObjectName"

    const-string v2, "KnowledgeArticleVersion"

    .line 123
    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "topCategoriesOnly"

    const-string v2, "false"

    .line 124
    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 125
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v1

    .line 127
    invoke-virtual {p0, v1}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 128
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    sget-object v3, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v4}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->b()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v4

    const-class v5, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse;

    iget-object v6, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-virtual {v3, v4, v0, v5, v6}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 131
    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    if-eqz v2, :cond_0

    .line 132
    new-instance v2, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;

    const-class v3, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse;

    invoke-direct {v2, p0, v1, v3}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;-><init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lokhttp3/HttpUrl;Ljava/lang/Class;)V

    .line 133
    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 134
    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 136
    :cond_0
    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 175
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->f:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "knowledgeArticles"

    .line 176
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 177
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 178
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    .line 180
    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v1

    .line 181
    new-instance v2, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$1;-><init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V

    .line 187
    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    sget-object v4, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    iget-object v5, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v5}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->b()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v5

    const-class v6, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;

    iget-object v7, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-virtual {v4, v5, v1, v6, v7}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v1

    invoke-virtual {v3, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    .line 188
    iget-boolean v3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    if-eqz v3, :cond_0

    .line 189
    new-instance v3, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;

    const-class v4, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;

    invoke-direct {v3, p0, v0, v4}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;-><init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lokhttp3/HttpUrl;Ljava/lang/Class;)V

    .line 190
    invoke-interface {v1, v3}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 191
    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 193
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->f:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "knowledgeArticles"

    .line 144
    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl$Builder;->e(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "pageNumber"

    .line 145
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->b()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "pageSize"

    .line 146
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "queryMethod"

    .line 147
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "sort"

    .line 148
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->f()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    const-string v1, "order"

    .line 149
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->h()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 151
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 152
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "{\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->j()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\":\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\"}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 153
    const-string v2, "categories"

    invoke-virtual {v0, v2, v1}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 156
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->k()Ljava/lang/CharSequence;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 157
    const-string v1, "q"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->k()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/HttpUrl$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 159
    :cond_1
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v1

    .line 160
    invoke-virtual {p0, v1}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 161
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    sget-object v3, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v4}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->b()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v4

    const-class v5, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;

    iget-object v6, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-virtual {v3, v4, v0, v5, v6}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 163
    iget-boolean v2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    if-eqz v2, :cond_2

    .line 164
    new-instance v2, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;

    const-class v3, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;

    invoke-direct {v2, p0, v1, v3}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;-><init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lokhttp3/HttpUrl;Ljava/lang/Class;)V

    .line 165
    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 166
    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 168
    :cond_2
    return-object v0
.end method

.method public c()Z
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->g:Landroid/content/Context;

    const-string v1, "connectivity"

    .line 112
    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 113
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 114
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
