.class final Lcom/google/firebase/perf/metrics/zze;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lcom/google/firebase/perf/metrics/Trace;


# direct methods
.method constructor <init>(Lcom/google/firebase/perf/metrics/Trace;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    return-void
.end method


# virtual methods
.method final a()Lcom/google/android/gms/internal/zzewy;
    .locals 8

    const/4 v3, 0x0

    new-instance v4, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->c()Lcom/google/android/gms/internal/zzewn;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v4, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->c()Lcom/google/android/gms/internal/zzewn;

    move-result-object v0

    iget-object v1, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v1}, Lcom/google/firebase/perf/metrics/Trace;->d()Lcom/google/android/gms/internal/zzewn;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v4, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->b()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {v5}, Ljava/util/Map;->size()I

    move-result v0

    new-array v0, v0, [Lcom/google/android/gms/internal/zzewz;

    iput-object v0, v4, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v2, v3

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/firebase/perf/metrics/zza;

    new-instance v7, Lcom/google/android/gms/internal/zzewz;

    invoke-direct {v7}, Lcom/google/android/gms/internal/zzewz;-><init>()V

    iput-object v0, v7, Lcom/google/android/gms/internal/zzewz;->a:Ljava/lang/String;

    invoke-virtual {v1}, Lcom/google/firebase/perf/metrics/zza;->a()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v7, Lcom/google/android/gms/internal/zzewz;->b:Ljava/lang/Long;

    iget-object v1, v4, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    add-int/lit8 v0, v2, 0x1

    aput-object v7, v1, v2

    move v2, v0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->h()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Lcom/google/android/gms/internal/zzewy;

    iput-object v1, v4, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v1, v3

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/perf/metrics/Trace;

    iget-object v6, v4, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    add-int/lit8 v2, v1, 0x1

    new-instance v7, Lcom/google/firebase/perf/metrics/zze;

    invoke-direct {v7, v0}, Lcom/google/firebase/perf/metrics/zze;-><init>(Lcom/google/firebase/perf/metrics/Trace;)V

    invoke-virtual {v7}, Lcom/google/firebase/perf/metrics/zze;->a()Lcom/google/android/gms/internal/zzewy;

    move-result-object v0

    aput-object v0, v6, v1

    move v1, v2

    goto :goto_1

    :cond_1
    iget-object v0, p0, Lcom/google/firebase/perf/metrics/zze;->a:Lcom/google/firebase/perf/metrics/Trace;

    invoke-virtual {v0}, Lcom/google/firebase/perf/metrics/Trace;->getAttributes()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v0

    new-array v0, v0, [Lcom/google/android/gms/internal/zzexa;

    iput-object v0, v4, Lcom/google/android/gms/internal/zzewy;->f:[Lcom/google/android/gms/internal/zzexa;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    new-instance v6, Lcom/google/android/gms/internal/zzexa;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzexa;-><init>()V

    iput-object v0, v6, Lcom/google/android/gms/internal/zzexa;->a:Ljava/lang/String;

    iput-object v1, v6, Lcom/google/android/gms/internal/zzexa;->b:Ljava/lang/String;

    iget-object v1, v4, Lcom/google/android/gms/internal/zzewy;->f:[Lcom/google/android/gms/internal/zzexa;

    add-int/lit8 v0, v3, 0x1

    aput-object v6, v1, v3

    move v3, v0

    goto :goto_2

    :cond_2
    return-object v4
.end method
