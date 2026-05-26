.class final Lcom/google/firebase/perf/network/zze;
.super Ljava/lang/Object;


# instance fields
.field private final a:Ljava/net/HttpURLConnection;

.field private final b:Lcom/google/android/gms/internal/zzevv;

.field private c:J

.field private d:J

.field private final e:Lcom/google/android/gms/internal/zzewn;


# direct methods
.method public constructor <init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V
    .locals 2

    const-wide/16 v0, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->c:J

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->d:J

    iput-object p1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    iput-object p3, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iput-object p2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    return-void
.end method

.method private final E()V
    .locals 4

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zze;->c:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->a()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->c:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zze;->c:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    const-string v1, "POST"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    const-string v1, "GET"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    goto :goto_0
.end method


# virtual methods
.method public final A()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final B()Ljava/net/URL;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public final C()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public final D()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method

.method public final a(Ljava/lang/String;I)I
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public final a(Ljava/lang/String;J)J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Ljava/net/HttpURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a([Ljava/lang/Class;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    instance-of v1, v0, Ljava/io/InputStream;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    new-instance v1, Lcom/google/firebase/perf/network/zza;

    check-cast v0, Ljava/io/InputStream;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v3, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v1, v0, v2, v3}, Lcom/google/firebase/perf/network/zza;-><init>(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0

    :cond_0
    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    goto :goto_0
.end method

.method public final a(I)Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final a()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zze;->c:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->a()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->c:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zze;->c:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final a(J)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(J)V

    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final a(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    return-void
.end method

.method public final b(Ljava/lang/String;J)J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Ljava/net/HttpURLConnection;->getHeaderFieldLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final b(I)Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final b()V
    .locals 4

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    return-void
.end method

.method public final b(J)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    return-void
.end method

.method public final b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final b(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    return-void
.end method

.method public final c()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContent()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    instance-of v1, v0, Ljava/io/InputStream;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    new-instance v1, Lcom/google/firebase/perf/network/zza;

    check-cast v0, Ljava/io/InputStream;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v3, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v1, v0, v2, v3}, Lcom/google/firebase/perf/network/zza;-><init>(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0

    :cond_0
    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    goto :goto_0
.end method

.method public final c(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setChunkedStreamingMode(I)V

    return-void
.end method

.method public final c(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    return-void
.end method

.method public final c(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    return-void
.end method

.method public final d()Ljava/io/InputStream;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    new-instance v1, Lcom/google/firebase/perf/network/zza;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v3, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v1, v0, v2, v3}, Lcom/google/firebase/perf/network/zza;-><init>(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final d(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    return-void
.end method

.method public final d(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    return-void
.end method

.method public final e()J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public final e(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    return-void
.end method

.method public final e(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    return-void
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final f()Ljava/io/OutputStream;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    new-instance v0, Lcom/google/firebase/perf/network/zzb;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v1

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v3, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0, v1, v2, v3}, Lcom/google/firebase/perf/network/zzb;-><init>(Ljava/io/OutputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final f(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    return-void
.end method

.method public final f(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    return-void
.end method

.method public final g()Ljava/security/Permission;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getPermission()Ljava/security/Permission;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final h()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zze;->d:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->d:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zze;->d:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->e(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final hashCode()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public final i()Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zze;->d:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zze;->d:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zze;->d:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->e(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final j()J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public final k()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final l()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final m()I
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v0

    return v0
.end method

.method public final n()J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentLengthLong()J

    move-result-wide v0

    return-wide v0
.end method

.method public final o()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final p()J
    .locals 2

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public final q()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public final r()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public final s()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public final t()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final u()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public final v()Ljava/io/InputStream;
    .locals 4

    invoke-direct {p0}, Lcom/google/firebase/perf/network/zze;->E()V

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v1

    if-eqz v1, :cond_0

    new-instance v0, Lcom/google/firebase/perf/network/zza;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zze;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v3, p0, Lcom/google/firebase/perf/network/zze;->e:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0, v1, v2, v3}, Lcom/google/firebase/perf/network/zza;-><init>(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V

    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, "FirebasePerformance"

    const-string v1, "IOException thrown trying to obtain the response code"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :cond_0
    move-object v0, v1

    goto :goto_1
.end method

.method public final w()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public final x()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public final y()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public final z()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zze;->a:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
