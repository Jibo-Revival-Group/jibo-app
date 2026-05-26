.class public final Lcom/google/firebase/perf/network/zzb;
.super Ljava/io/OutputStream;


# instance fields
.field private a:Ljava/io/OutputStream;

.field private b:J

.field private c:Lcom/google/android/gms/internal/zzevv;

.field private final d:Lcom/google/android/gms/internal/zzewn;


# direct methods
.method public constructor <init>(Ljava/io/OutputStream;Lcom/google/android/gms/internal/zzevv;Lcom/google/android/gms/internal/zzewn;)V
    .locals 2

    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    iput-object p1, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    iput-object p2, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iput-object p3, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->d(J)Lcom/google/android/gms/internal/zzevv;

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final flush()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final write(I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write(I)V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final write([B)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    array-length v2, p1

    int-to-long v2, v2

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method

.method public final write([BII)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->a:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    iget-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    int-to-long v2, p3

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzb;->b:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->a(J)Lcom/google/android/gms/internal/zzevv;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzb;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzb;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v1}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    throw v0
.end method
