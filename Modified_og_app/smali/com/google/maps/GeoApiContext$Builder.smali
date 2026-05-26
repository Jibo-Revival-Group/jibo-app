.class public Lcom/google/maps/GeoApiContext$Builder;
.super Ljava/lang/Object;
.source "GeoApiContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/GeoApiContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private apiKey:Ljava/lang/String;

.field private baseUrlOverride:Ljava/lang/String;

.field private builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

.field private channel:Ljava/lang/String;

.field private clientId:Ljava/lang/String;

.field private errorTimeout:J

.field private exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

.field private maxRetries:Ljava/lang/Integer;

.field private urlSigner:Lcom/google/maps/internal/UrlSigner;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 294
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 288
    const-wide/32 v0, 0xea60

    iput-wide v0, p0, Lcom/google/maps/GeoApiContext$Builder;->errorTimeout:J

    .line 289
    new-instance v0, Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-direct {v0}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;-><init>()V

    iput-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    .line 295
    new-instance v0, Lcom/google/maps/OkHttpRequestHandler$Builder;

    invoke-direct {v0}, Lcom/google/maps/OkHttpRequestHandler$Builder;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/maps/GeoApiContext$Builder;->requestHandlerBuilder(Lcom/google/maps/GeoApiContext$RequestHandler$Builder;)Lcom/google/maps/GeoApiContext$Builder;

    .line 296
    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext$RequestHandler$Builder;)V
    .locals 2

    .prologue
    .line 298
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 288
    const-wide/32 v0, 0xea60

    iput-wide v0, p0, Lcom/google/maps/GeoApiContext$Builder;->errorTimeout:J

    .line 289
    new-instance v0, Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-direct {v0}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;-><init>()V

    iput-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    .line 299
    invoke-virtual {p0, p1}, Lcom/google/maps/GeoApiContext$Builder;->requestHandlerBuilder(Lcom/google/maps/GeoApiContext$RequestHandler$Builder;)Lcom/google/maps/GeoApiContext$Builder;

    .line 300
    return-void
.end method


# virtual methods
.method public apiKey(Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->apiKey:Ljava/lang/String;

    .line 336
    return-object p0
.end method

.method baseUrlForTesting(Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->baseUrlOverride:Ljava/lang/String;

    .line 325
    return-object p0
.end method

.method public build()Lcom/google/maps/GeoApiContext;
    .locals 11

    .prologue
    .line 505
    new-instance v0, Lcom/google/maps/GeoApiContext;

    iget-object v1, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    .line 506
    invoke-interface {v1}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->build()Lcom/google/maps/GeoApiContext$RequestHandler;

    move-result-object v1

    iget-object v2, p0, Lcom/google/maps/GeoApiContext$Builder;->apiKey:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/maps/GeoApiContext$Builder;->baseUrlOverride:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/maps/GeoApiContext$Builder;->channel:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/maps/GeoApiContext$Builder;->clientId:Ljava/lang/String;

    iget-wide v6, p0, Lcom/google/maps/GeoApiContext$Builder;->errorTimeout:J

    iget-object v8, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    iget-object v9, p0, Lcom/google/maps/GeoApiContext$Builder;->maxRetries:Ljava/lang/Integer;

    iget-object v10, p0, Lcom/google/maps/GeoApiContext$Builder;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    invoke-direct/range {v0 .. v10}, Lcom/google/maps/GeoApiContext;-><init>(Lcom/google/maps/GeoApiContext$RequestHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/google/maps/internal/ExceptionsAllowedToRetry;Ljava/lang/Integer;Lcom/google/maps/internal/UrlSigner;)V

    .line 505
    return-object v0
.end method

.method public channel(Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->channel:Ljava/lang/String;

    .line 365
    return-object p0
.end method

.method public connectTimeout(JLjava/util/concurrent/TimeUnit;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    invoke-interface {v0, p1, p2, p3}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->connectTimeout(JLjava/util/concurrent/TimeUnit;)V

    .line 378
    return-object p0
.end method

.method public disableRetries()Lcom/google/maps/GeoApiContext$Builder;
    .locals 3

    .prologue
    .line 441
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/maps/GeoApiContext$Builder;->maxRetries(Ljava/lang/Integer;)Lcom/google/maps/GeoApiContext$Builder;

    .line 442
    const-wide/16 v0, 0x0

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext$Builder;->retryTimeout(JLjava/util/concurrent/TimeUnit;)Lcom/google/maps/GeoApiContext$Builder;

    .line 443
    return-object p0
.end method

.method public enterpriseCredentials(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 2

    .prologue
    .line 347
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->clientId:Ljava/lang/String;

    .line 349
    :try_start_0
    new-instance v0, Lcom/google/maps/internal/UrlSigner;

    invoke-direct {v0, p2}, Lcom/google/maps/internal/UrlSigner;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->urlSigner:Lcom/google/maps/internal/UrlSigner;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1

    .line 353
    return-object p0

    .line 350
    :catch_0
    move-exception v0

    .line 351
    :goto_0
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 350
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method public maxRetries(Ljava/lang/Integer;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->maxRetries:Ljava/lang/Integer;

    .line 432
    return-object p0
.end method

.method public proxy(Ljava/net/Proxy;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    if-nez p1, :cond_0

    sget-object p1, Ljava/net/Proxy;->NO_PROXY:Ljava/net/Proxy;

    :cond_0
    invoke-interface {v0, p1}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->proxy(Ljava/net/Proxy;)V

    .line 484
    return-object p0
.end method

.method public proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    invoke-interface {v0, p1, p2}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)V

    .line 496
    return-object p0
.end method

.method public queryRateLimit(I)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    invoke-interface {v0, p1}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->queriesPerSecond(I)V

    .line 456
    return-object p0
.end method

.method public readTimeout(JLjava/util/concurrent/TimeUnit;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    invoke-interface {v0, p1, p2, p3}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->readTimeout(JLjava/util/concurrent/TimeUnit;)V

    .line 391
    return-object p0
.end method

.method public requestHandlerBuilder(Lcom/google/maps/GeoApiContext$RequestHandler$Builder;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 2

    .prologue
    .line 312
    iput-object p1, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    .line 313
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    const-class v1, Lcom/google/maps/errors/OverQueryLimitException;

    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;->add(Ljava/lang/Object;)Z

    .line 314
    return-object p0
.end method

.method public retryTimeout(JLjava/util/concurrent/TimeUnit;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 3

    .prologue
    .line 417
    invoke-virtual {p3, p1, p2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/maps/GeoApiContext$Builder;->errorTimeout:J

    .line 418
    return-object p0
.end method

.method public setIfExceptionIsAllowedToRetry(Ljava/lang/Class;Z)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/google/maps/errors/ApiException;",
            ">;Z)",
            "Lcom/google/maps/GeoApiContext$Builder;"
        }
    .end annotation

    .prologue
    .line 468
    if-eqz p2, :cond_0

    .line 469
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-virtual {v0, p1}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;->add(Ljava/lang/Object;)Z

    .line 473
    :goto_0
    return-object p0

    .line 471
    :cond_0
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-virtual {v0, p1}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public writeTimeout(JLjava/util/concurrent/TimeUnit;)Lcom/google/maps/GeoApiContext$Builder;
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/google/maps/GeoApiContext$Builder;->builder:Lcom/google/maps/GeoApiContext$RequestHandler$Builder;

    invoke-interface {v0, p1, p2, p3}, Lcom/google/maps/GeoApiContext$RequestHandler$Builder;->writeTimeout(JLjava/util/concurrent/TimeUnit;)V

    .line 403
    return-object p0
.end method
