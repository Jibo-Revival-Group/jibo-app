.class public Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;
.super Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Lcom/google/android/gms/internal/zzewp;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-static {p1}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->a()Ljava/net/URLConnection;

    move-result-object v0

    instance-of v4, v0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v4, :cond_0

    new-instance v4, Lcom/google/firebase/perf/network/zzd;

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    invoke-direct {v4, v0, p2, v1}, Lcom/google/firebase/perf/network/zzd;-><init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4}, Lcom/google/firebase/perf/network/zzd;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    instance-of v4, v0, Ljava/net/HttpURLConnection;

    if-eqz v4, :cond_1

    new-instance v4, Lcom/google/firebase/perf/network/zzc;

    check-cast v0, Ljava/net/HttpURLConnection;

    invoke-direct {v4, v0, p2, v1}, Lcom/google/firebase/perf/network/zzc;-><init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4}, Lcom/google/firebase/perf/network/zzc;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static a(Lcom/google/android/gms/internal/zzewp;[Ljava/lang/Class;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-static {p2}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->a()Ljava/net/URLConnection;

    move-result-object v0

    instance-of v4, v0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v4, :cond_0

    new-instance v4, Lcom/google/firebase/perf/network/zzd;

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    invoke-direct {v4, v0, p3, v1}, Lcom/google/firebase/perf/network/zzd;-><init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4, p1}, Lcom/google/firebase/perf/network/zzd;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    instance-of v4, v0, Ljava/net/HttpURLConnection;

    if-eqz v4, :cond_1

    new-instance v4, Lcom/google/firebase/perf/network/zzc;

    check-cast v0, Ljava/net/HttpURLConnection;

    invoke-direct {v4, v0, p3, v1}, Lcom/google/firebase/perf/network/zzc;-><init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4, p1}, Lcom/google/firebase/perf/network/zzc;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v0, p1}, Ljava/net/URLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p3}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method private static b(Lcom/google/android/gms/internal/zzewp;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->a()V

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-static {p1}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v1

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->a()Ljava/net/URLConnection;

    move-result-object v0

    instance-of v4, v0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v4, :cond_0

    new-instance v4, Lcom/google/firebase/perf/network/zzd;

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    invoke-direct {v4, v0, p2, v1}, Lcom/google/firebase/perf/network/zzd;-><init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4}, Lcom/google/firebase/perf/network/zzd;->getContent()Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    instance-of v4, v0, Ljava/net/HttpURLConnection;

    if-eqz v4, :cond_1

    new-instance v4, Lcom/google/firebase/perf/network/zzc;

    check-cast v0, Ljava/net/HttpURLConnection;

    invoke-direct {v4, v0, p2, v1}, Lcom/google/firebase/perf/network/zzc;-><init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    invoke-virtual {v4}, Lcom/google/firebase/perf/network/zzc;->getContent()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Ljava/net/URLConnection;->getContent()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewp;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public static getContent(Ljava/net/URL;)Ljava/lang/Object;
    .locals 3
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewp;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzewp;-><init>(Ljava/net/URL;)V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v2}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {v0, v1, v2}, Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;->b(Lcom/google/android/gms/internal/zzewp;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static getContent(Ljava/net/URL;[Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewp;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzewp;-><init>(Ljava/net/URL;)V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v2}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {v0, p1, v1, v2}, Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;->a(Lcom/google/android/gms/internal/zzewp;[Ljava/lang/Class;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static instrument(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    instance-of v0, p0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v0, :cond_1

    new-instance v0, Lcom/google/firebase/perf/network/zzd;

    check-cast p0, Ljavax/net/ssl/HttpsURLConnection;

    new-instance v1, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2}, Lcom/google/firebase/perf/network/zzd;-><init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    move-object p0, v0

    :cond_0
    :goto_0
    return-object p0

    :cond_1
    instance-of v0, p0, Ljava/net/HttpURLConnection;

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/firebase/perf/network/zzc;

    check-cast p0, Ljava/net/HttpURLConnection;

    new-instance v1, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2}, Lcom/google/firebase/perf/network/zzc;-><init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public static openStream(Ljava/net/URL;)Ljava/io/InputStream;
    .locals 3
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzewp;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzewp;-><init>(Ljava/net/URL;)V

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v2}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    invoke-static {v0, v1, v2}, Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;->a(Lcom/google/android/gms/internal/zzewp;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method
