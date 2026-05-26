.class final Lcom/google/android/gms/internal/zzewj;
.super Ljava/lang/Object;


# static fields
.field private static final a:J


# instance fields
.field private b:J

.field private c:J

.field private d:Lcom/google/android/gms/internal/zzewn;

.field private e:J

.field private final f:Lcom/google/android/gms/internal/zzewk;

.field private g:J

.field private h:J

.field private i:J

.field private j:J

.field private final k:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    sget-object v0, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x1

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMicros(J)J

    move-result-wide v0

    sput-wide v0, Lcom/google/android/gms/internal/zzewj;->a:J

    return-void
.end method

.method constructor <init>(JJLcom/google/android/gms/internal/zzewk;Ljava/util/Map;Lcom/google/android/gms/internal/zzewi;Z)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Lcom/google/android/gms/internal/zzewk;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gms/internal/zzewi;",
            "Z)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    move-object/from16 v0, p5

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewj;->f:Lcom/google/android/gms/internal/zzewk;

    move-wide/from16 v0, p3

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->b:J

    iput-wide p1, p0, Lcom/google/android/gms/internal/zzewj;->c:J

    move-wide/from16 v0, p3

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    new-instance v2, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v2}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v2, p0, Lcom/google/android/gms/internal/zzewj;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckf()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckg()I

    move-result v4

    int-to-long v6, v4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckh()I

    move-result v4

    int-to-long v8, v4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzcki()I

    move-result v4

    int-to-long v10, v4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckj()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p6

    invoke-interface {v0, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckj()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-nez v4, :cond_8

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckf()I

    move-result v2

    int-to-long v2, v2

    move-wide v4, v2

    :goto_0
    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckk()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckk()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    :goto_1
    div-long v4, v2, v4

    iput-wide v4, p0, Lcom/google/android/gms/internal/zzewj;->g:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->h:J

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->h:J

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckg()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->g:J

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckg()I

    move-result v4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckf()I

    move-result v5

    div-int/2addr v4, v5

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_1

    :cond_0
    const-string v2, "FirebasePerformance"

    const-string v3, "Foreground %s logging rate:%d, burst capacity:%d"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-wide v6, p0, Lcom/google/android/gms/internal/zzewj;->g:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget-wide v6, p0, Lcom/google/android/gms/internal/zzewj;->h:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckl()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckl()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-nez v4, :cond_5

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckh()I

    move-result v2

    int-to-long v2, v2

    move-wide v4, v2

    :goto_2
    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckm()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckm()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    :goto_3
    div-long v4, v2, v4

    iput-wide v4, p0, Lcom/google/android/gms/internal/zzewj;->i:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->j:J

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->j:J

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzcki()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->i:J

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzcki()I

    move-result v4

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->zzckh()I

    move-result v5

    div-int/2addr v4, v5

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_3

    :cond_2
    const-string v2, "FirebasePerformance"

    const-string v3, "Background %s logging rate:%d, capacity:%d"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewi;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-wide v6, p0, Lcom/google/android/gms/internal/zzewj;->i:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget-wide v6, p0, Lcom/google/android/gms/internal/zzewj;->j:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3
    move/from16 v0, p8

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzewj;->k:Z

    return-void

    :cond_4
    move-wide v2, v10

    goto :goto_3

    :cond_5
    move-wide v4, v2

    goto :goto_2

    :cond_6
    move-wide v4, v8

    goto :goto_2

    :cond_7
    move-wide v2, v6

    goto/16 :goto_1

    :cond_8
    move-wide v4, v2

    goto/16 :goto_0
.end method


# virtual methods
.method final declared-synchronized a(Z)V
    .locals 2

    monitor-enter p0

    if-eqz p1, :cond_0

    :try_start_0
    iget-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->g:J

    :goto_0
    iput-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->c:J

    if-eqz p1, :cond_1

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->h:J

    :goto_1
    iput-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->b:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->i:J

    goto :goto_0

    :cond_1
    iget-wide v0, p0, Lcom/google/android/gms/internal/zzewj;->j:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method final declared-synchronized a(Lcom/google/android/gms/internal/zzewx;)Z
    .locals 10

    const-wide/16 v8, 0x0

    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    const-wide/16 v2, 0x0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewj;->d:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    iget-wide v6, p0, Lcom/google/android/gms/internal/zzewj;->c:J

    mul-long/2addr v4, v6

    sget-wide v6, Lcom/google/android/gms/internal/zzewj;->a:J

    div-long/2addr v4, v6

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    add-long/2addr v2, v4

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzewj;->b:J

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    cmp-long v1, v2, v8

    if-lez v1, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzewj;->e:J

    iput-object v0, p0, Lcom/google/android/gms/internal/zzewj;->d:Lcom/google/android/gms/internal/zzewn;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    :try_start_1
    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzewj;->k:Z

    if-eqz v0, :cond_1

    const-string v0, "FirebasePerformance"

    const-string v1, "Exceeded log rate limit, dropping the log."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
