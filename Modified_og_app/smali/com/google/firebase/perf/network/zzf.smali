.class public final Lcom/google/firebase/perf/network/zzf;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/apache/http/client/ResponseHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/apache/http/client/ResponseHandler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lorg/apache/http/client/ResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;"
        }
    .end annotation
.end field

.field private final b:Lcom/google/android/gms/internal/zzewn;

.field private final c:Lcom/google/android/gms/internal/zzevv;


# direct methods
.method public constructor <init>(Lorg/apache/http/client/ResponseHandler;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzevv;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lcom/google/android/gms/internal/zzewn;",
            "Lcom/google/android/gms/internal/zzevv;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/perf/network/zzf;->a:Lorg/apache/http/client/ResponseHandler;

    iput-object p2, p0, Lcom/google/firebase/perf/network/zzf;->b:Lcom/google/android/gms/internal/zzewn;

    iput-object p3, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    return-void
.end method


# virtual methods
.method public final handleResponse(Lorg/apache/http/HttpResponse;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/http/HttpResponse;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzf;->b:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewn;->c()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzevv;->f(J)Lcom/google/android/gms/internal/zzevv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevv;->a(I)Lcom/google/android/gms/internal/zzevv;

    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpMessage;)Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzevv;->b(J)Lcom/google/android/gms/internal/zzevv;

    :cond_0
    invoke-static {p1}, Lcom/google/firebase/perf/network/zzh;->a(Lorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzevv;->c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;

    :cond_1
    iget-object v0, p0, Lcom/google/firebase/perf/network/zzf;->c:Lcom/google/android/gms/internal/zzevv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzevv;->d()Lcom/google/android/gms/internal/zzewv;

    iget-object v0, p0, Lcom/google/firebase/perf/network/zzf;->a:Lorg/apache/http/client/ResponseHandler;

    invoke-interface {v0, p1}, Lorg/apache/http/client/ResponseHandler;->handleResponse(Lorg/apache/http/HttpResponse;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
