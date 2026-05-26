.class public Lcom/google/android/gms/internal/zzevz;
.super Ljava/lang/Object;


# static fields
.field private static volatile a:Lcom/google/android/gms/internal/zzevz;


# instance fields
.field private final b:Ljava/util/concurrent/ThreadPoolExecutor;

.field private c:Lcom/google/firebase/FirebaseApp;

.field private d:Lcom/google/firebase/perf/FirebasePerformance;

.field private e:Landroid/content/Context;

.field private f:Lcom/google/android/gms/internal/zzbdy;

.field private g:Ljava/lang/String;

.field private h:Lcom/google/android/gms/internal/zzews;

.field private i:Lcom/google/android/gms/internal/zzewh;

.field private j:Lcom/google/android/gms/internal/zzevw;

.field private k:Z


# direct methods
.method private constructor <init>(Ljava/util/concurrent/ThreadPoolExecutor;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzevz;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v1, Lcom/google/android/gms/internal/zzewa;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzewa;-><init>(Lcom/google/android/gms/internal/zzevz;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static a()Lcom/google/android/gms/internal/zzevz;
    .locals 9

    sget-object v0, Lcom/google/android/gms/internal/zzevz;->a:Lcom/google/android/gms/internal/zzevz;

    if-nez v0, :cond_1

    const-class v8, Lcom/google/android/gms/internal/zzevz;

    monitor-enter v8

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/zzevz;->a:Lcom/google/android/gms/internal/zzevz;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    :try_start_1
    invoke-static {}, Lcom/google/firebase/FirebaseApp;->d()Lcom/google/firebase/FirebaseApp;
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v2, 0x1

    const/4 v3, 0x1

    const-wide/16 v4, 0xa

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    new-instance v0, Lcom/google/android/gms/internal/zzevz;

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzevz;-><init>(Ljava/util/concurrent/ThreadPoolExecutor;)V

    sput-object v0, Lcom/google/android/gms/internal/zzevz;->a:Lcom/google/android/gms/internal/zzevz;

    :cond_0
    monitor-exit v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_1
    sget-object v0, Lcom/google/android/gms/internal/zzevz;->a:Lcom/google/android/gms/internal/zzevz;

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_3
    monitor-exit v8

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0
.end method

.method private static a(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, ""

    goto :goto_0
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzevz;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzevz;->b()V

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewv;I)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzevz;->b(Lcom/google/android/gms/internal/zzewv;I)V

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewy;I)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzevz;->b(Lcom/google/android/gms/internal/zzewy;I)V

    return-void
.end method

.method private final a(Lcom/google/android/gms/internal/zzewx;)V
    .locals 8

    const-wide/16 v6, 0x1

    const/4 v3, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->f:Lcom/google/android/gms/internal/zzbdy;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzews;->b:Ljava/lang/String;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    invoke-static {}, Lcom/google/firebase/iid/FirebaseInstanceId;->a()Lcom/google/firebase/iid/FirebaseInstanceId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/firebase/iid/FirebaseInstanceId;->c()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->b:Ljava/lang/String;

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzews;->b:Ljava/lang/String;

    if-nez v0, :cond_3

    move v0, v3

    :goto_1
    if-eqz v0, :cond_4

    const-string v0, "FirebasePerformance"

    const-string v1, "App Instance ID is null, dropping the log."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->d:Lcom/google/firebase/perf/FirebasePerformance;

    invoke-virtual {v0}, Lcom/google/firebase/perf/FirebasePerformance;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v1, :cond_5

    new-instance v1, Lcom/google/android/gms/internal/zzewf;

    iget-object v4, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v1, v4}, Lcom/google/android/gms/internal/zzewf;-><init>(Lcom/google/android/gms/internal/zzewy;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_5
    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v1, :cond_6

    new-instance v1, Lcom/google/android/gms/internal/zzewe;

    iget-object v4, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-direct {v1, v4}, Lcom/google/android/gms/internal/zzewe;-><init>(Lcom/google/android/gms/internal/zzewv;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_6
    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    if-eqz v1, :cond_7

    new-instance v1, Lcom/google/android/gms/internal/zzevy;

    iget-object v4, p1, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-direct {v1, v4}, Lcom/google/android/gms/internal/zzevy;-><init>(Lcom/google/android/gms/internal/zzews;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_7
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_8

    const-string v0, "FirebasePerformance"

    const-string v1, "No validators found for PerfMetric."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v2

    :goto_2
    if-nez v0, :cond_b

    const-string v0, "FirebasePerformance"

    const-string v1, "Unable to process an HTTP request/response due to missing or invalid values. See earlier log statements for additional information on the specific invalid/missing values."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :cond_8
    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v5

    move v4, v2

    :cond_9
    if-ge v4, v5, :cond_a

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v4, v4, 0x1

    check-cast v1, Lcom/google/android/gms/internal/zzewg;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewg;->a()Z

    move-result v1

    if-nez v1, :cond_9

    move v0, v2

    goto :goto_2

    :cond_a
    move v0, v3

    goto :goto_2

    :cond_b
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->i:Lcom/google/android/gms/internal/zzewh;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewh;->a(Lcom/google/android/gms/internal/zzewx;)Z

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->j:Lcom/google/android/gms/internal/zzevw;

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoeo:Lcom/google/android/gms/internal/zzewl;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewl;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v6, v7}, Lcom/google/android/gms/internal/zzevw;->a(Ljava/lang/String;J)V

    goto/16 :goto_0

    :cond_c
    iget-object v0, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->j:Lcom/google/android/gms/internal/zzevw;

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoen:Lcom/google/android/gms/internal/zzewl;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzewl;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v6, v7}, Lcom/google/android/gms/internal/zzevw;->a(Ljava/lang/String;J)V

    goto/16 :goto_0

    :cond_d
    invoke-static {p1}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjs;)[B

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->f:Lcom/google/android/gms/internal/zzbdy;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzbdy;->a([B)Lcom/google/android/gms/internal/zzbea;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzbea;->a()V

    goto/16 :goto_0
.end method

.method private final b()V
    .locals 12

    const/4 v11, 0x0

    invoke-static {}, Lcom/google/firebase/FirebaseApp;->d()Lcom/google/firebase/FirebaseApp;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->c:Lcom/google/firebase/FirebaseApp;

    invoke-static {}, Lcom/google/firebase/perf/FirebasePerformance;->a()Lcom/google/firebase/perf/FirebasePerformance;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->d:Lcom/google/firebase/perf/FirebasePerformance;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->c:Lcom/google/firebase/FirebaseApp;

    invoke-virtual {v0}, Lcom/google/firebase/FirebaseApp;->a()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->c:Lcom/google/firebase/FirebaseApp;

    invoke-virtual {v0}, Lcom/google/firebase/FirebaseApp;->c()Lcom/google/firebase/FirebaseOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/firebase/FirebaseOptions;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->g:Ljava/lang/String;

    new-instance v0, Lcom/google/android/gms/internal/zzews;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzews;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->g:Ljava/lang/String;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->a:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    invoke-static {}, Lcom/google/firebase/iid/FirebaseInstanceId;->a()Lcom/google/firebase/iid/FirebaseInstanceId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/firebase/iid/FirebaseInstanceId;->c()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->b:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    new-instance v1, Lcom/google/android/gms/internal/zzewr;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewr;-><init>()V

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewr;->a:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    const-string v1, "1.0.0.178131943"

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewr;->b:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzevz;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewr;->c:Ljava/lang/String;

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    const-string v3, "FIREPERF"

    new-instance v0, Lcom/google/android/gms/internal/zzbdy;

    const/4 v2, -0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static {v1}, Lcom/google/android/gms/internal/zzbej;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbee;

    move-result-object v7

    invoke-static {}, Lcom/google/android/gms/common/util/zzh;->d()Lcom/google/android/gms/common/util/zzd;

    move-result-object v8

    const/4 v9, 0x0

    new-instance v10, Lcom/google/android/gms/internal/zzbeu;

    invoke-direct {v10, v1}, Lcom/google/android/gms/internal/zzbeu;-><init>(Landroid/content/Context;)V

    invoke-direct/range {v0 .. v10}, Lcom/google/android/gms/internal/zzbdy;-><init>(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/google/android/gms/internal/zzbee;Lcom/google/android/gms/common/util/zzd;Lcom/google/android/gms/internal/zzbed;Lcom/google/android/gms/internal/zzbeb;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->f:Lcom/google/android/gms/internal/zzbdy;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    new-instance v1, Lcom/google/android/gms/internal/zzewh;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzevz;->g:Ljava/lang/String;

    const-wide/16 v4, 0x64

    const-wide/16 v6, 0x1f4

    invoke-direct/range {v1 .. v7}, Lcom/google/android/gms/internal/zzewh;-><init>(Landroid/content/Context;Ljava/lang/String;JJ)V

    iput-object v1, p0, Lcom/google/android/gms/internal/zzevz;->i:Lcom/google/android/gms/internal/zzewh;

    invoke-static {}, Lcom/google/android/gms/internal/zzevw;->a()Lcom/google/android/gms/internal/zzevw;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevz;->j:Lcom/google/android/gms/internal/zzevw;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->e:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewq;->a(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevz;->k:Z

    return-void

    :catch_0
    move-exception v0

    const-string v0, "FirebasePerformance"

    const-string v1, "Caught SecurityException while init ClearcutLogger."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iput-object v11, p0, Lcom/google/android/gms/internal/zzevz;->f:Lcom/google/android/gms/internal/zzbdy;

    goto :goto_0
.end method

.method private final b(Lcom/google/android/gms/internal/zzewv;I)V
    .locals 10

    const-wide/16 v2, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->d:Lcom/google/firebase/perf/FirebasePerformance;

    invoke-virtual {v0}, Lcom/google/firebase/perf/FirebasePerformance;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevz;->k:Z

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    if-nez v0, :cond_2

    move-wide v0, v2

    :goto_0
    iget-object v4, p1, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    if-nez v4, :cond_3

    :goto_1
    const-string v4, "FirebasePerformance"

    const-string v5, "Logging NetworkRequestMetric - %s %db %dms,"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p1, Lcom/google/android/gms/internal/zzewv;->a:Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v6, v7

    const/4 v2, 0x2

    const-wide/16 v8, 0x3e8

    div-long/2addr v0, v8

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, v6, v2

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/zzewx;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewx;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v1, v0, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, v1, Lcom/google/android/gms/internal/zzews;->d:Ljava/lang/Integer;

    iput-object p1, v0, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzewx;)V

    :cond_1
    return-void

    :cond_2
    iget-object v0, p1, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto :goto_0

    :cond_3
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    goto :goto_1
.end method

.method private final b(Lcom/google/android/gms/internal/zzewy;I)V
    .locals 10

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->d:Lcom/google/firebase/perf/FirebasePerformance;

    invoke-virtual {v0}, Lcom/google/firebase/perf/FirebasePerformance;->b()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevz;->k:Z

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    if-nez v0, :cond_1

    const-wide/16 v0, 0x0

    :goto_0
    const-string v3, "FirebasePerformance"

    const-string v4, "Logging TraceMetric - %s %dms"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p1, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    aput-object v6, v5, v2

    const/4 v6, 0x1

    const-wide/16 v8, 0x3e8

    div-long/2addr v0, v8

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    new-instance v3, Lcom/google/android/gms/internal/zzewx;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzewx;-><init>()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->h:Lcom/google/android/gms/internal/zzews;

    iput-object v0, v3, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v0, v3, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->d:Ljava/lang/Integer;

    iput-object p1, v3, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    invoke-static {}, Lcom/google/firebase/perf/FirebasePerformance;->a()Lcom/google/firebase/perf/FirebasePerformance;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/firebase/perf/FirebasePerformance;->c()Ljava/util/Map;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, v3, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v1

    new-array v1, v1, [Lcom/google/android/gms/internal/zzewt;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzews;->e:[Lcom/google/android/gms/internal/zzewt;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    new-instance v6, Lcom/google/android/gms/internal/zzewt;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzewt;-><init>()V

    iput-object v0, v6, Lcom/google/android/gms/internal/zzewt;->a:Ljava/lang/String;

    iput-object v1, v6, Lcom/google/android/gms/internal/zzewt;->b:Ljava/lang/String;

    iget-object v0, v3, Lcom/google/android/gms/internal/zzewx;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v1, v0, Lcom/google/android/gms/internal/zzews;->e:[Lcom/google/android/gms/internal/zzewt;

    add-int/lit8 v0, v2, 0x1

    aput-object v6, v1, v2

    move v2, v0

    goto :goto_1

    :cond_1
    iget-object v0, p1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto :goto_0

    :cond_2
    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzewx;)V

    :cond_3
    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/internal/zzewv;I)V
    .locals 3

    :try_start_0
    invoke-static {p1}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjs;)[B

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzewv;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewv;-><init>()V

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjs;[B)Lcom/google/android/gms/internal/zzfjs;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v2, Lcom/google/android/gms/internal/zzewc;

    invoke-direct {v2, p0, v1, p2}, Lcom/google/android/gms/internal/zzewc;-><init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewv;I)V

    invoke-virtual {v0, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lcom/google/android/gms/internal/zzfjr; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "FirebasePerformance"

    const-string v2, "Clone NetworkRequestMetric throws exception"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public final a(Lcom/google/android/gms/internal/zzewy;I)V
    .locals 4

    :try_start_0
    invoke-static {p1}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjs;)[B

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzewy;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzewy;-><init>()V

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjs;[B)Lcom/google/android/gms/internal/zzfjs;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v2, Lcom/google/android/gms/internal/zzewb;

    invoke-direct {v2, p0, v1, p2}, Lcom/google/android/gms/internal/zzewb;-><init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewy;I)V

    invoke-virtual {v0, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lcom/google/android/gms/internal/zzfjr; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "FirebasePerformance"

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, 0x23

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v2, "Clone TraceMetric throws exception "

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public final a(Z)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v1, Lcom/google/android/gms/internal/zzewd;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/internal/zzewd;-><init>(Lcom/google/android/gms/internal/zzevz;Z)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public final b(Z)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevz;->i:Lcom/google/android/gms/internal/zzewh;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewh;->a(Z)V

    return-void
.end method
