.class public Lcom/google/maps/OkHttpRequestHandler$Builder;
.super Ljava/lang/Object;
.source "OkHttpRequestHandler.java"

# interfaces
.implements Lcom/google/maps/GeoApiContext$RequestHandler$Builder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/OkHttpRequestHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final builder:Lokhttp3/OkHttpClient$Builder;

.field private final dispatcher:Lokhttp3/Dispatcher;

.field private final rateLimitExecutorService:Lcom/google/maps/internal/RateLimitExecutorService;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 102
    new-instance v0, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v0}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    iput-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    .line 103
    new-instance v0, Lcom/google/maps/internal/RateLimitExecutorService;

    invoke-direct {v0}, Lcom/google/maps/internal/RateLimitExecutorService;-><init>()V

    iput-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->rateLimitExecutorService:Lcom/google/maps/internal/RateLimitExecutorService;

    .line 104
    new-instance v0, Lokhttp3/Dispatcher;

    iget-object v1, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->rateLimitExecutorService:Lcom/google/maps/internal/RateLimitExecutorService;

    invoke-direct {v0, v1}, Lokhttp3/Dispatcher;-><init>(Ljava/util/concurrent/ExecutorService;)V

    iput-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->dispatcher:Lokhttp3/Dispatcher;

    .line 105
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    iget-object v1, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->dispatcher:Lokhttp3/Dispatcher;

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;

    .line 106
    return-void
.end method


# virtual methods
.method public build()Lcom/google/maps/GeoApiContext$RequestHandler;
    .locals 2

    .prologue
    .line 156
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->a()Lokhttp3/OkHttpClient;

    move-result-object v0

    .line 157
    new-instance v1, Lcom/google/maps/OkHttpRequestHandler;

    invoke-direct {v1, v0}, Lcom/google/maps/OkHttpRequestHandler;-><init>(Lokhttp3/OkHttpClient;)V

    return-object v1
.end method

.method public connectTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2, p3}, Lokhttp3/OkHttpClient$Builder;->a(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 111
    return-void
.end method

.method public proxy(Ljava/net/Proxy;)V
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->a(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;

    .line 133
    return-void
.end method

.method public proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 137
    .line 140
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    new-instance v1, Lcom/google/maps/OkHttpRequestHandler$Builder$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/google/maps/OkHttpRequestHandler$Builder$1;-><init>(Lcom/google/maps/OkHttpRequestHandler$Builder;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;

    .line 152
    return-void
.end method

.method public queriesPerSecond(I)V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->dispatcher:Lokhttp3/Dispatcher;

    invoke-virtual {v0, p1}, Lokhttp3/Dispatcher;->a(I)V

    .line 126
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->dispatcher:Lokhttp3/Dispatcher;

    invoke-virtual {v0, p1}, Lokhttp3/Dispatcher;->b(I)V

    .line 127
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->rateLimitExecutorService:Lcom/google/maps/internal/RateLimitExecutorService;

    invoke-virtual {v0, p1}, Lcom/google/maps/internal/RateLimitExecutorService;->setQueriesPerSecond(I)V

    .line 128
    return-void
.end method

.method public readTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2, p3}, Lokhttp3/OkHttpClient$Builder;->b(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 116
    return-void
.end method

.method public writeTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder;->builder:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2, p3}, Lokhttp3/OkHttpClient$Builder;->c(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 121
    return-void
.end method
