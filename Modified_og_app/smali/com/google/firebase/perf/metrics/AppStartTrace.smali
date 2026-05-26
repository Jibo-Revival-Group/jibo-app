.class public Lcom/google/firebase/perf/metrics/AppStartTrace;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/perf/metrics/AppStartTrace$zza;
    }
.end annotation


# static fields
.field private static final a:J

.field private static volatile b:Lcom/google/firebase/perf/metrics/AppStartTrace;


# instance fields
.field private c:Z

.field private d:Lcom/google/android/gms/internal/zzevz;

.field private final e:Lcom/google/android/gms/internal/zzewk;

.field private f:Landroid/content/Context;

.field private g:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private i:Z

.field private j:Lcom/google/android/gms/internal/zzewn;

.field private k:Lcom/google/android/gms/internal/zzewn;

.field private l:Lcom/google/android/gms/internal/zzewn;

.field private m:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    sget-object v0, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x1

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMicros(J)J

    move-result-wide v0

    sput-wide v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->a:J

    return-void
.end method

.method private constructor <init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z

    iput-boolean v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->i:Z

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    iput-boolean v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->m:Z

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->d:Lcom/google/android/gms/internal/zzevz;

    iput-object p2, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->e:Lcom/google/android/gms/internal/zzewk;

    return-void
.end method

.method static synthetic a(Lcom/google/firebase/perf/metrics/AppStartTrace;)Lcom/google/android/gms/internal/zzewn;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    return-object v0
.end method

.method public static a()Lcom/google/firebase/perf/metrics/AppStartTrace;
    .locals 2

    sget-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    new-instance v1, Lcom/google/android/gms/internal/zzewk;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewk;-><init>()V

    invoke-static {v0, v1}, Lcom/google/firebase/perf/metrics/AppStartTrace;->a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)Lcom/google/firebase/perf/metrics/AppStartTrace;

    move-result-object v0

    goto :goto_0
.end method

.method private static a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)Lcom/google/firebase/perf/metrics/AppStartTrace;
    .locals 3

    sget-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    if-nez v0, :cond_1

    const-class v1, Lcom/google/firebase/perf/metrics/AppStartTrace;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/firebase/perf/metrics/AppStartTrace;

    const/4 v2, 0x0

    invoke-direct {v0, v2, p1}, Lcom/google/firebase/perf/metrics/AppStartTrace;-><init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V

    sput-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/google/firebase/perf/metrics/AppStartTrace;->b:Lcom/google/firebase/perf/metrics/AppStartTrace;

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method static synthetic a(Lcom/google/firebase/perf/metrics/AppStartTrace;Z)Z
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->m:Z

    return v0
.end method

.method private final declared-synchronized b()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->f:Landroid/content/Context;

    check-cast v0, Landroid/app/Application;

    invoke-virtual {v0, p0}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static setLauncherActivityOnCreateTime(Ljava/lang/String;)V
    .locals 0
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    return-void
.end method

.method public static setLauncherActivityOnResumeTime(Ljava/lang/String;)V
    .locals 0
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    return-void
.end method

.method public static setLauncherActivityOnStartTime(Ljava/lang/String;)V
    .locals 0
    .annotation build Landroid/support/annotation/Keep;
    .end annotation

    return-void
.end method


# virtual methods
.method public final declared-synchronized a(Landroid/content/Context;)V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    instance-of v1, v2, Landroid/app/Application;

    if-eqz v1, :cond_0

    move-object v0, v2

    check-cast v0, Landroid/app/Application;

    move-object v1, v0

    invoke-virtual {v1, p0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z

    iput-object v2, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->f:Landroid/content/Context;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 4

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->m:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->g:Ljava/lang/ref/WeakReference;

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    invoke-static {}, Lcom/google/firebase/perf/provider/FirebasePerfProvider;->zzckv()Lcom/google/android/gms/internal/zzewn;

    move-result-object v0

    iget-object v1, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v0

    sget-wide v2, Lcom/google/firebase/perf/metrics/AppStartTrace;->a:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->i:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public declared-synchronized onActivityResumed(Landroid/app/Activity;)V
    .locals 7

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->m:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->i:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->h:Ljava/lang/ref/WeakReference;

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    invoke-static {}, Lcom/google/firebase/perf/provider/FirebasePerfProvider;->zzckv()Lcom/google/android/gms/internal/zzewn;

    move-result-object v0

    const-string v1, "FirebasePerformance"

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x1e

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "onResume "

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v1, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    sget-object v2, Lcom/google/android/gms/internal/zzewm;->zzoer:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v1, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    iget-object v2, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    const/4 v2, 0x3

    new-array v2, v2, [Lcom/google/android/gms/internal/zzewy;

    new-instance v3, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    sget-object v4, Lcom/google/android/gms/internal/zzewm;->zzoes:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v3, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    iget-object v4, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v0, v4}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    const/4 v0, 0x0

    aput-object v3, v2, v0

    new-instance v0, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    sget-object v3, Lcom/google/android/gms/internal/zzewm;->zzoet:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    iget-object v3, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->j:Lcom/google/android/gms/internal/zzewn;

    iget-object v4, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    const/4 v3, 0x1

    aput-object v0, v2, v3

    new-instance v0, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    sget-object v3, Lcom/google/android/gms/internal/zzewm;->zzoeu:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    iget-object v3, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;

    iget-object v4, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->l:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v0, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    const/4 v3, 0x2

    aput-object v0, v2, v3

    iput-object v2, v1, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->d:Lcom/google/android/gms/internal/zzevz;

    if-nez v0, :cond_2

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v0

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->d:Lcom/google/android/gms/internal/zzevz;

    :cond_2
    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->d:Lcom/google/android/gms/internal/zzevz;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->d:Lcom/google/android/gms/internal/zzevz;

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzewy;I)V

    :cond_3
    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->c:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->b()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    return-void
.end method

.method public declared-synchronized onActivityStarted(Landroid/app/Activity;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->m:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->i:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v0, p0, Lcom/google/firebase/perf/metrics/AppStartTrace;->k:Lcom/google/android/gms/internal/zzewn;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onActivityStopped(Landroid/app/Activity;)V
    .locals 0

    monitor-enter p0

    monitor-exit p0

    return-void
.end method
