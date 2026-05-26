.class public final Lcom/google/firebase/perf/network/zzg;
.super Ljava/lang/Object;

# interfaces
.implements Lokhttp3/Callback;


# instance fields
.field private final a:Lokhttp3/Callback;

.field private final b:Lcom/google/android/gms/internal/zzevv;

.field private final c:J

.field private final d:Lcom/google/android/gms/internal/zzewn;


# direct methods
.method public constructor <init>(Lokhttp3/Callback;Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewn;J)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/perf/network/zzg;->a:Lokhttp3/Callback;

    invoke-static {p2}, Lcom/google/android/gms/internal/zzevv;->a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;

    move-result-object v0

    iput-object v0, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    iput-wide p4, p0, Lcom/google/firebase/perf/network/zzg;->c:J

    iput-object p3, p0, Lcom/google/firebase/perf/network/zzg;->d:Lcom/google/android/gms/internal/zzewn;

    return-void
.end method


# virtual methods
.method public final onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 4

    invoke-interface {p1}, Lokhttp3/Call;->a()Lokhttp3/Request;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v2, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1}, Lokhttp3/HttpUrl;->a()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/zzevv;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-virtual {v0}, Lokhttp3/Request;->b()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lokhttp3/Request;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzg;->c:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->c(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzg;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    invoke-static {v0}, Lcom/google/firebase/perf/network/zzh;->a(Lcom/google/android/gms/internal/zzevv;)V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->a:Lokhttp3/Callback;

    invoke-interface {v0, p1, p2}, Lokhttp3/Callback;->onFailure(Lokhttp3/Call;Ljava/io/IOException;)V

    return-void
.end method

.method public final onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v4

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzg;->b:Lcom/google/android/gms/internal/zzevv;

    iget-wide v2, p0, Lcom/google/firebase/perf/network/zzg;->c:J

    move-object v0, p2

    invoke-static/range {v0 .. v5}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->a(Lokhttp3/Response;Lcom/google/android/gms/internal/zzevv;JJ)V

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzg;->a:Lokhttp3/Callback;

    invoke-interface {v0, p1, p2}, Lokhttp3/Callback;->onResponse(Lokhttp3/Call;Lokhttp3/Response;)V

    return-void
.end method
