.class public final Lcom/google/android/gms/internal/zzclf;
.super Lcom/google/android/gms/internal/zzcjl;


# instance fields
.field private a:Landroid/os/Handler;

.field private b:J

.field private final c:Lcom/google/android/gms/internal/zzcgs;

.field private final d:Lcom/google/android/gms/internal/zzcgs;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzcim;)V
    .locals 2

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzcjl;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    new-instance v0, Lcom/google/android/gms/internal/zzclg;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzclf;->p:Lcom/google/android/gms/internal/zzcim;

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/zzclg;-><init>(Lcom/google/android/gms/internal/zzclf;Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzclf;->c:Lcom/google/android/gms/internal/zzcgs;

    new-instance v0, Lcom/google/android/gms/internal/zzclh;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzclf;->p:Lcom/google/android/gms/internal/zzcim;

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/zzclh;-><init>(Lcom/google/android/gms/internal/zzclf;Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    return-void
.end method

.method private final a(J)V
    .locals 9

    const-wide/16 v6, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzclf;->y()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->c:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgs;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgs;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Activity resumed, time"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    iput-wide p1, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->k:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v2

    sub-long/2addr v0, v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->m:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->l:Lcom/google/android/gms/internal/zzchz;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzchz;->a(Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v0, v6, v7}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->l:Lcom/google/android/gms/internal/zzchz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchz;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->c:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->j:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v4

    sub-long/2addr v2, v4

    invoke-static {v6, v7, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcgs;->a(J)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    const-wide/32 v2, 0x36ee80

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v4

    sub-long/2addr v2, v4

    invoke-static {v6, v7, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcgs;->a(J)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzclf;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzclf;->z()V

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzclf;J)V
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzclf;->a(J)V

    return-void
.end method

.method private final b(J)V
    .locals 7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzclf;->y()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->c:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgs;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgs;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Activity paused, time"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    sub-long v4, p1, v4

    add-long/2addr v2, v4

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_0
    return-void
.end method

.method static synthetic b(Lcom/google/android/gms/internal/zzclf;J)V
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzclf;->b(J)V

    return-void
.end method

.method private final y()V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->a:Landroid/os/Handler;

    if-nez v0, :cond_0

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzclf;->a:Landroid/os/Handler;

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private final z()V
    .locals 4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzclf;->a(Z)Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->d()Lcom/google/android/gms/internal/zzcgd;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcgd;->a(J)V

    return-void
.end method


# virtual methods
.method public final bridge synthetic a()V
    .locals 0

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->a()V

    return-void
.end method

.method public final a(Z)Z
    .locals 8

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->m:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v3

    invoke-interface {v3}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    sub-long v2, v0, v2

    if-nez p1, :cond_0

    const-wide/16 v4, 0x3e8

    cmp-long v4, v2, v4

    if-gez v4, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Screen exposed for less than 1000 ms. Event not sent. time"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v4

    iget-object v4, v4, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v4, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Recording user engagement, ms"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    const-string v5, "_et"

    invoke-virtual {v4, v5, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->j()Lcom/google/android/gms/internal/zzckc;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzckc;->y()Lcom/google/android/gms/internal/zzckf;

    move-result-object v2

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/zzckc;->a(Lcom/google/android/gms/measurement/AppMeasurement$zzb;Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->f()Lcom/google/android/gms/internal/zzcjn;

    move-result-object v2

    const-string v3, "auto"

    const-string v5, "_e"

    invoke-virtual {v2, v3, v5, v4}, Lcom/google/android/gms/internal/zzcjn;->a(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzclf;->b:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgs;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclf;->d:Lcom/google/android/gms/internal/zzcgs;

    const-wide/16 v2, 0x0

    const-wide/32 v4, 0x36ee80

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->n:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcgs;->a(J)V

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final bridge synthetic b()V
    .locals 0

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->b()V

    return-void
.end method

.method public final bridge synthetic c()V
    .locals 0

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->c()V

    return-void
.end method

.method public final bridge synthetic d()Lcom/google/android/gms/internal/zzcgd;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->d()Lcom/google/android/gms/internal/zzcgd;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic e()Lcom/google/android/gms/internal/zzcgk;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->e()Lcom/google/android/gms/internal/zzcgk;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic f()Lcom/google/android/gms/internal/zzcjn;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->f()Lcom/google/android/gms/internal/zzcjn;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic g()Lcom/google/android/gms/internal/zzchh;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->g()Lcom/google/android/gms/internal/zzchh;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic h()Lcom/google/android/gms/internal/zzcgu;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->h()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic i()Lcom/google/android/gms/internal/zzckg;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->i()Lcom/google/android/gms/internal/zzckg;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic j()Lcom/google/android/gms/internal/zzckc;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->j()Lcom/google/android/gms/internal/zzckc;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic k()Lcom/google/android/gms/common/util/zzd;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->k()Lcom/google/android/gms/common/util/zzd;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic l()Landroid/content/Context;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->l()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic m()Lcom/google/android/gms/internal/zzchi;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->m()Lcom/google/android/gms/internal/zzchi;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic n()Lcom/google/android/gms/internal/zzcgo;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->n()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic o()Lcom/google/android/gms/internal/zzchk;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->o()Lcom/google/android/gms/internal/zzchk;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic p()Lcom/google/android/gms/internal/zzclq;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->p()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic q()Lcom/google/android/gms/internal/zzcig;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->q()Lcom/google/android/gms/internal/zzcig;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic r()Lcom/google/android/gms/internal/zzclf;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->r()Lcom/google/android/gms/internal/zzclf;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic s()Lcom/google/android/gms/internal/zzcih;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->s()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic t()Lcom/google/android/gms/internal/zzchm;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic u()Lcom/google/android/gms/internal/zzchx;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic v()Lcom/google/android/gms/internal/zzcgn;
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/zzcjl;->v()Lcom/google/android/gms/internal/zzcgn;

    move-result-object v0

    return-object v0
.end method

.method protected final w()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method
