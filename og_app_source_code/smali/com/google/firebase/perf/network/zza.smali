.class public final Lcom/google/firebase/perf/network/zza;
.super Ljava/io/InputStream;


# instance fields
.field private final a:Ljava/io/InputStream;

.field private final b:Lcom/google/android/gms/internal/zzevv;

.field private final c:Lcom/google/android/gms/internal/zzewn;

.field private d:J

.field private e:J

.field private f:J


# direct methods
.method public constructor <init>(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V
    .locals 2

    const-wide/16 v0, -0x1

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zza;->d:J

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zza;->f:J

    iput-object p3, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    iput-object p1, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    iput-object p2, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzevv;->c()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zza;->e:J

    return-void
.end method


# virtual methods
.method public final available()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final close()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v4, -0x1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zza;->f:J

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zza;->d:J

    cmp-long v0, v0, v4

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    iget-wide v0, p0, Lcom/google/firebase/perf/network/zza;->e:J

    cmp-long v0, v0, v4

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->e:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->e(J)Lcom/google/android/gms/internal/zzevv;

    :cond_2
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final mark(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1}, Ljava/io/InputStream;->mark(I)V

    return-void
.end method

.method public final markSupported()Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->markSupported()Z

    move-result v0

    return v0
.end method

.method public final read()I
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v6, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->e:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_0

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->e:J

    :cond_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->f:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_1

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    :goto_0
    return v0

    :cond_1
    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final read([B)I
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v6, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1}, Ljava/io/InputStream;->read([B)I

    move-result v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->e:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_0

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->e:J

    :cond_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->f:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_1

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    :goto_0
    return v0

    :cond_1
    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    int-to-long v4, v0

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final read([BII)I
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v6, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/InputStream;->read([BII)I

    move-result v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->e:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_0

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->e:J

    :cond_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->f:J

    cmp-long v1, v4, v6

    if-nez v1, :cond_1

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    :goto_0
    return v0

    :cond_1
    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    int-to-long v4, v0

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final reset()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final skip(J)J
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v6, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zza;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1, p2}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v0

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->e:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->e:J

    :cond_0
    cmp-long v4, v0, v6

    if-nez v4, :cond_1

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->f:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_1

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->f:J

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->f:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    :goto_0
    return-wide v0

    :cond_1
    iget-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    add-long/2addr v2, v0

    iput-wide v2, p0, Lcom/google/firebase/perf/network/zza;->d:J

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v4, p0, Lcom/google/firebase/perf/network/zza;->d:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zza;->c:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zza;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method
