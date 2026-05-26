.class public final Lcom/google/firebase/perf/network/zzc;
.super Ljava/net/HttpURLConnection;


# instance fields
.field private final a:Lcom/google/firebase/perf/network/zze;


# direct methods
.method constructor <init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V
    .locals 1

    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    new-instance v0, Lcom/google/firebase/perf/network/zze;

    invoke-direct {v0, p1, p2, p3}, Lcom/google/firebase/perf/network/zze;-><init>(Ljava/net/HttpURLConnection;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V

    iput-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    return-void
.end method


# virtual methods
.method public final addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2}, Lcom/google/firebase/perf/network/zze;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final connect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->a()V

    return-void
.end method

.method public final disconnect()V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->b()V

    return-void
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final getAllowUserInteraction()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->q()Z

    move-result v0

    return v0
.end method

.method public final getConnectTimeout()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->r()I

    move-result v0

    return v0
.end method

.method public final getContent()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->c()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getContent([Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->a([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getContentEncoding()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->l()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getContentLength()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->m()I

    move-result v0

    return v0
.end method

.method public final getContentLengthLong()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->n()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getContentType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->o()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getDate()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->p()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getDefaultUseCaches()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->s()Z

    move-result v0

    return v0
.end method

.method public final getDoInput()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->t()Z

    move-result v0

    return v0
.end method

.method public final getDoOutput()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->u()Z

    move-result v0

    return v0
.end method

.method public final getErrorStream()Ljava/io/InputStream;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->v()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getExpiration()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->j()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getHeaderField(I)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->a(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/firebase/perf/network/zze;->a(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2}, Lcom/google/firebase/perf/network/zze;->a(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public final getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->b(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderFieldLong(Ljava/lang/String;J)J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/firebase/perf/network/zze;->b(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final getHeaderFields()Ljava/util/Map;
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

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->k()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getIfModifiedSince()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->w()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getInputStream()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->d()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getInstanceFollowRedirects()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->x()Z

    move-result v0

    return v0
.end method

.method public final getLastModified()J
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->e()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->f()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getPermission()Ljava/security/Permission;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->g()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public final getReadTimeout()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->y()I

    move-result v0

    return v0
.end method

.method public final getRequestMethod()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->z()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperties()Ljava/util/Map;
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

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->A()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getResponseCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->h()I

    move-result v0

    return v0
.end method

.method public final getResponseMessage()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->i()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getURL()Ljava/net/URL;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->B()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public final getUseCaches()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->C()Z

    move-result v0

    return v0
.end method

.method public final hashCode()I
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->hashCode()I

    move-result v0

    return v0
.end method

.method public final setAllowUserInteraction(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->a(Z)V

    return-void
.end method

.method public final setChunkedStreamingMode(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->c(I)V

    return-void
.end method

.method public final setConnectTimeout(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->d(I)V

    return-void
.end method

.method public final setDefaultUseCaches(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->b(Z)V

    return-void
.end method

.method public final setDoInput(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->c(Z)V

    return-void
.end method

.method public final setDoOutput(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->d(Z)V

    return-void
.end method

.method public final setFixedLengthStreamingMode(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->e(I)V

    return-void
.end method

.method public final setFixedLengthStreamingMode(J)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2}, Lcom/google/firebase/perf/network/zze;->a(J)V

    return-void
.end method

.method public final setIfModifiedSince(J)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2}, Lcom/google/firebase/perf/network/zze;->b(J)V

    return-void
.end method

.method public final setInstanceFollowRedirects(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->e(Z)V

    return-void
.end method

.method public final setReadTimeout(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->f(I)V

    return-void
.end method

.method public final setRequestMethod(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->c(Ljava/lang/String;)V

    return-void
.end method

.method public final setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1, p2}, Lcom/google/firebase/perf/network/zze;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final setUseCaches(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0, p1}, Lcom/google/firebase/perf/network/zze;->f(Z)V

    return-void
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final usingProxy()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzc;->a:Lcom/google/firebase/perf/network/zze;

    invoke-virtual {v0}, Lcom/google/firebase/perf/network/zze;->D()Z

    move-result v0

    return v0
.end method
