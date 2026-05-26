.class public Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;
.super Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static a(Lokhttp3/Response;Lcom/google/android/gms/internal/zzevv;JJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v4, -0x1

    invoke-virtual {p0}, Lokhttp3/Response;->a()Lokhttp3/Request;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-virtual {v0}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v1

    invoke-virtual {v1}, Lokhttp3/HttpUrl;->a()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lokhttp3/Request;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lokhttp3/Request;->d()Lokhttp3/RequestBody;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lokhttp3/Request;->d()Lokhttp3/RequestBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/RequestBody;->b()J

    move-result-wide v0

    cmp-long v2, v0, v4

    if-eqz v2, :cond_1

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-virtual {p0}, Lokhttp3/Response;->h()Lokhttp3/ResponseBody;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->b()J

    move-result-wide v2

    cmp-long v1, v2, v4

    if-eqz v1, :cond_2

    invoke-virtual {p1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    invoke-virtual {v0}, Lokhttp3/ResponseBody;->a()Lokhttp3/MediaType;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lokhttp3/MediaType;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_3
    invoke-virtual {p0}, Lokhttp3/Response;->c()I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p1, p2, p3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p1, p4, p5}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    goto :goto_0
.end method

.method public static enqueue(Lokhttp3/Call;Lokhttp3/Callback;)V
    .locals 6
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    new-instance v3, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v4

    new-instance v0, Lcom/google/firebase/perf/network/zzg;

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v2

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/google/firebase/perf/network/zzg;-><init>(Lokhttp3/Callback;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;J)V

    invoke-interface {p0, v0}, Lokhttp3/Call;->a(Lokhttp3/Callback;)V

    return-void
.end method

.method public static execute(Lokhttp3/Call;)Lokhttp3/Response;
    .locals 7
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    new-instance v6, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-virtual {v6}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    :try_start_0
    invoke-interface {p0}, Lokhttp3/Call;->b()Lokhttp3/Response;

    move-result-object v0

    invoke-virtual {v6}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v4

    invoke-static/range {v0 .. v5}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->a(Lokhttp3/Response;Lcom/google/android/gms/internal/zzevv;JJ)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    invoke-interface {p0}, Lokhttp3/Call;->a()Lokhttp3/Request;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {v4}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v5}, Lokhttp3/HttpUrl;->a()Ljava/net/URL;

    move-result-object v5

    invoke-virtual {v5}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {v4}, Lokhttp3/Request;->b()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {v4}, Lokhttp3/Request;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method
