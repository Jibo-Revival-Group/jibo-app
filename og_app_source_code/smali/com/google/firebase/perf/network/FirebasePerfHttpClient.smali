.class public Lcom/google/firebase/perf/network/FirebasePerfHttpClient;
.super Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lcom/google/android/gms/internal/zzewn;",
            "Lcom/google/android/gms/internal/zzevz;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p5}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p2}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    new-instance v0, Lcom/google/firebase/perf/network/zzf;

    invoke-direct {v0, p3, p4, v1}, Lcom/google/firebase/perf/network/zzf;-><init>(Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-interface {p0, p1, p2, v0}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            "Lcom/google/android/gms/internal/zzewn;",
            "Lcom/google/android/gms/internal/zzevz;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p6}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p2}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p5}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p5}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    new-instance v0, Lcom/google/firebase/perf/network/zzf;

    invoke-direct {v0, p3, p5, v1}, Lcom/google/firebase/perf/network/zzf;-><init>(Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-interface {p0, p1, p2, v0, p4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p5}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<TT;>;",
            "Lcom/google/android/gms/internal/zzewn;",
            "Lcom/google/android/gms/internal/zzevz;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p4}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    new-instance v0, Lcom/google/firebase/perf/network/zzf;

    invoke-direct {v0, p2, p3, v1}, Lcom/google/firebase/perf/network/zzf;-><init>(Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-interface {p0, p1, v0}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            "Lcom/google/android/gms/internal/zzewn;",
            "Lcom/google/android/gms/internal/zzevz;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p5}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    new-instance v0, Lcom/google/firebase/perf/network/zzf;

    invoke-direct {v0, p2, p4, v1}, Lcom/google/firebase/perf/network/zzf;-><init>(Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-interface {p0, p1, v0, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p4}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p2}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {p0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    return-object v0

    :cond_3
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p5}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p2}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p2}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {p0, p1, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    return-object v0

    :cond_3
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p4}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p3}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {p0, p1}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p4}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {p0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 6
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v4, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 7
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v5, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v5}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v6

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v6}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 2
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    invoke-static {p0, p1, p2, v0, v1}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 6
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/HttpClient;",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v4, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    .locals 2
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    invoke-static {p0, p1, p2, v0, v1}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 6
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v4, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 2
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    invoke-static {p0, p1, v0, v1}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public static execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 2
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    invoke-static {p0, p1, p2, v0, v1}, Lcom/google/firebase/perf/network/FirebasePerfHttpClient;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevz;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method
