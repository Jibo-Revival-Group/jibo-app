.class Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/http/HttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LanguageErrorHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

.field private final b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final c:Lokhttp3/HttpUrl;

.field private final d:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lokhttp3/HttpUrl;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lokhttp3/HttpUrl;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 282
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 283
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 284
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->c:Lokhttp3/HttpUrl;

    .line 285
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->d:Ljava/lang/Class;

    .line 286
    return-void
.end method

.method private a(ILjava/lang/String;)Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 316
    const/16 v0, 0x190

    if-ne p1, v0, :cond_0

    if-nez p2, :cond_1

    :cond_0
    move v0, v1

    .line 332
    :goto_0
    return v0

    .line 320
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    const-class v2, [Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;

    invoke-virtual {v0, p2, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;

    .line 321
    if-nez v0, :cond_2

    move v0, v1

    .line 322
    goto :goto_0

    .line 324
    :cond_2
    array-length v3, v0

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_4

    aget-object v4, v0, v2

    .line 325
    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->a()Z
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-eqz v4, :cond_3

    .line 326
    const/4 v0, 0x1

    goto :goto_0

    .line 324
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 329
    :catch_0
    move-exception v0

    move v0, v1

    .line 330
    goto :goto_0

    :cond_4
    move v0, v1

    .line 332
    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 312
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 308
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 309
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;TT;)V"
        }
    .end annotation

    .prologue
    .line 304
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 305
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 289
    instance-of v0, p2, Lcom/salesforce/android/service/common/http/ResponseException;

    if-eqz v0, :cond_0

    move-object v0, p2

    .line 290
    check-cast v0, Lcom/salesforce/android/service/common/http/ResponseException;

    .line 291
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/http/ResponseException;->a()I

    move-result v1

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/http/ResponseException;->b()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v1, v0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a(ILjava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 293
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a:Z

    .line 294
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->c:Lokhttp3/HttpUrl;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 295
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v3, v3, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v3}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->b()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v3

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->d:Ljava/lang/Class;

    iget-object v5, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    iget-object v5, v5, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->b:Lcom/google/gson/Gson;

    invoke-virtual {v2, v3, v0, v4, v5}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/utilities/threading/Job;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 300
    :goto_0
    return-void

    .line 299
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$LanguageErrorHandler;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    goto :goto_0
.end method
