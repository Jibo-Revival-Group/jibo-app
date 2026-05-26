.class public Lcom/google/android/gms/internal/zzevw;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzevw$zza;
    }
.end annotation


# static fields
.field private static volatile a:Lcom/google/android/gms/internal/zzevw;


# instance fields
.field private b:Z

.field private c:Lcom/google/android/gms/internal/zzevz;

.field private final d:Lcom/google/android/gms/internal/zzewk;

.field private e:Z

.field private final f:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private g:Lcom/google/android/gms/internal/zzewn;

.field private h:Lcom/google/android/gms/internal/zzewn;

.field private final i:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/util/concurrent/atomic/AtomicInteger;

.field private k:I

.field private l:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/zzevw$zza;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzevw;->b:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevw;->e:Z

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->j:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/zzevw;->k:I

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzevw;->d:Lcom/google/android/gms/internal/zzewk;

    return-void
.end method

.method public static a()Lcom/google/android/gms/internal/zzevw;
    .locals 2

    sget-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    new-instance v1, Lcom/google/android/gms/internal/zzewk;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewk;-><init>()V

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzevw;->a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)Lcom/google/android/gms/internal/zzevw;

    move-result-object v0

    goto :goto_0
.end method

.method private static a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)Lcom/google/android/gms/internal/zzevw;
    .locals 3

    sget-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    if-nez v0, :cond_1

    const-class v1, Lcom/google/android/gms/internal/zzevw;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/zzevw;

    const/4 v2, 0x0

    invoke-direct {v0, v2, p1}, Lcom/google/android/gms/internal/zzevw;-><init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V

    sput-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/google/android/gms/internal/zzevw;->a:Lcom/google/android/gms/internal/zzevw;

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private final a(Ljava/lang/String;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzewn;)V
    .locals 10

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    if-nez v1, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    :cond_0
    new-instance v3, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    iput-object p1, v3, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzewn;->b()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, v3, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    invoke-virtual {p2, p3}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, v3, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->j:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndSet(I)I

    move-result v4

    iget-object v5, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    monitor-enter v5

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    if-eqz v4, :cond_4

    :cond_1
    if-eqz v4, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    :goto_0
    new-array v1, v1, [Lcom/google/android/gms/internal/zzewz;

    iput-object v1, v3, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v2, v0

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    new-instance v1, Lcom/google/android/gms/internal/zzewz;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewz;-><init>()V

    iput-object v0, v1, Lcom/google/android/gms/internal/zzewz;->a:Ljava/lang/String;

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, v1, Lcom/google/android/gms/internal/zzewz;->b:Ljava/lang/Long;

    iget-object v7, v3, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    add-int/lit8 v0, v2, 0x1

    aput-object v1, v7, v2

    move v2, v0

    goto :goto_1

    :cond_2
    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    goto :goto_0

    :cond_3
    if-eqz v4, :cond_4

    new-instance v0, Lcom/google/android/gms/internal/zzewz;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewz;-><init>()V

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoep:Lcom/google/android/gms/internal/zzewl;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewl;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewz;->a:Ljava/lang/String;

    int-to-long v6, v4

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewz;->b:Ljava/lang/Long;

    iget-object v1, v3, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    aput-object v0, v1, v2

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    const/4 v1, 0x3

    invoke-virtual {v0, v3, v1}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzewy;I)V

    :cond_5
    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private final a(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/zzevz;->a()Lcom/google/android/gms/internal/zzevz;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->c:Lcom/google/android/gms/internal/zzevz;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzevz;->a(Z)V

    :cond_1
    return-void
.end method

.method private final b(I)V
    .locals 4

    iput p1, p0, Lcom/google/android/gms/internal/zzevw;->k:I

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzevw$zza;

    if-eqz v0, :cond_0

    iget v3, p0, Lcom/google/android/gms/internal/zzevw;->k:I

    invoke-interface {v0, v3}, Lcom/google/android/gms/internal/zzevw$zza;->b(I)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    :cond_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->j:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    return-void
.end method

.method public final declared-synchronized a(Landroid/content/Context;)V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevw;->b:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    instance-of v1, v0, Landroid/app/Application;

    if-eqz v1, :cond_0

    check-cast v0, Landroid/app/Application;

    invoke-virtual {v0, p0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevw;->b:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final a(Ljava/lang/String;J)V
    .locals 8

    const-wide/16 v6, 0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    const-wide/16 v2, 0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v0, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_0
    monitor-exit v1

    return-void

    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevw;->i:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    add-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final a(Ljava/lang/ref/WeakReference;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/zzevw$zza;",
            ">;)V"
        }
    .end annotation

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final b()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzevw;->k:I

    return v0
.end method

.method public final b(Ljava/lang/ref/WeakReference;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/zzevw$zza;",
            ">;)V"
        }
    .end annotation

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->l:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    return-void
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
    .locals 6

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->h:Lcom/google/android/gms/internal/zzewn;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevw;->e:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevw;->e:Z

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->b(I)V

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->a(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewq;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "FirebasePerformance"

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoew:Lcom/google/android/gms/internal/zzewm;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevw;->g:Lcom/google/android/gms/internal/zzewn;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzevw;->h:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v2

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x27

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v4, "onActivityResumed "

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ":"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->b(I)V

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->a(Z)V

    sget-object v0, Lcom/google/android/gms/internal/zzewm;->zzoew:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->g:Lcom/google/android/gms/internal/zzewn;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevw;->h:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/gms/internal/zzevw;->a(Ljava/lang/String;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzewn;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public declared-synchronized onActivityStopped(Landroid/app/Activity;)V
    .locals 6

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevw;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/zzewn;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewn;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevw;->g:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewq;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "FirebasePerformance"

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoev:Lcom/google/android/gms/internal/zzewm;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevw;->h:Lcom/google/android/gms/internal/zzewn;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzevw;->g:Lcom/google/android/gms/internal/zzewn;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzewn;->a(Lcom/google/android/gms/internal/zzewn;)J

    move-result-wide v2

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x27

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v4, "onActivityStopped "

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ":"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->b(I)V

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevw;->a(Z)V

    sget-object v0, Lcom/google/android/gms/internal/zzewm;->zzoev:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevw;->h:Lcom/google/android/gms/internal/zzewn;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevw;->g:Lcom/google/android/gms/internal/zzewn;

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/gms/internal/zzevw;->a(Ljava/lang/String;Lcom/google/android/gms/internal/zzewn;Lcom/google/android/gms/internal/zzewn;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
