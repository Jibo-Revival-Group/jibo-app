.class public Lcom/google/android/gms/internal/zzcim;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzcim$zza;
    }
.end annotation


# static fields
.field private static volatile a:Lcom/google/android/gms/internal/zzcim;


# instance fields
.field private A:Z

.field private B:Ljava/lang/Boolean;

.field private C:J

.field private D:Ljava/nio/channels/FileLock;

.field private E:Ljava/nio/channels/FileChannel;

.field private F:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private G:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private H:I

.field private I:I

.field private J:J

.field private K:J

.field private L:Z

.field private M:Z

.field private N:Z

.field private final O:J

.field private final b:Landroid/content/Context;

.field private final c:Lcom/google/android/gms/internal/zzcgn;

.field private final d:Lcom/google/android/gms/internal/zzchx;

.field private final e:Lcom/google/android/gms/internal/zzchm;

.field private final f:Lcom/google/android/gms/internal/zzcih;

.field private final g:Lcom/google/android/gms/internal/zzclf;

.field private final h:Lcom/google/android/gms/internal/zzcig;

.field private final i:Lcom/google/android/gms/measurement/AppMeasurement;

.field private final j:Lcom/google/firebase/analytics/FirebaseAnalytics;

.field private final k:Lcom/google/android/gms/internal/zzclq;

.field private final l:Lcom/google/android/gms/internal/zzchk;

.field private final m:Lcom/google/android/gms/internal/zzcgo;

.field private final n:Lcom/google/android/gms/internal/zzchi;

.field private final o:Lcom/google/android/gms/internal/zzchq;

.field private final p:Lcom/google/android/gms/common/util/zzd;

.field private final q:Lcom/google/android/gms/internal/zzckc;

.field private final r:Lcom/google/android/gms/internal/zzckg;

.field private final s:Lcom/google/android/gms/internal/zzcgu;

.field private final t:Lcom/google/android/gms/internal/zzcjn;

.field private final u:Lcom/google/android/gms/internal/zzchh;

.field private final v:Lcom/google/android/gms/internal/zzchv;

.field private final w:Lcom/google/android/gms/internal/zzcll;

.field private final x:Lcom/google/android/gms/internal/zzcgk;

.field private final y:Lcom/google/android/gms/internal/zzcgd;

.field private z:Z


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzcjm;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->z:Z

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcjm;->a:Landroid/content/Context;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzcim;->J:J

    invoke-static {}, Lcom/google/android/gms/common/util/zzh;->d()Lcom/google/android/gms/common/util/zzd;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    new-instance v0, Lcom/google/android/gms/internal/zzcgn;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcgn;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    new-instance v0, Lcom/google/android/gms/internal/zzchx;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchx;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->d:Lcom/google/android/gms/internal/zzchx;

    new-instance v0, Lcom/google/android/gms/internal/zzchm;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchm;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    new-instance v0, Lcom/google/android/gms/internal/zzclq;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzclq;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->k:Lcom/google/android/gms/internal/zzclq;

    new-instance v0, Lcom/google/android/gms/internal/zzchk;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchk;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->l:Lcom/google/android/gms/internal/zzchk;

    new-instance v0, Lcom/google/android/gms/internal/zzcgu;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcgu;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->s:Lcom/google/android/gms/internal/zzcgu;

    new-instance v0, Lcom/google/android/gms/internal/zzchh;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchh;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->u:Lcom/google/android/gms/internal/zzchh;

    new-instance v0, Lcom/google/android/gms/internal/zzcgo;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcgo;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->m:Lcom/google/android/gms/internal/zzcgo;

    new-instance v0, Lcom/google/android/gms/internal/zzchi;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchi;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->n:Lcom/google/android/gms/internal/zzchi;

    new-instance v0, Lcom/google/android/gms/internal/zzcgk;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcgk;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->x:Lcom/google/android/gms/internal/zzcgk;

    new-instance v0, Lcom/google/android/gms/internal/zzcgd;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcgd;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->y:Lcom/google/android/gms/internal/zzcgd;

    new-instance v0, Lcom/google/android/gms/internal/zzchq;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchq;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->o:Lcom/google/android/gms/internal/zzchq;

    new-instance v0, Lcom/google/android/gms/internal/zzckc;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzckc;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->q:Lcom/google/android/gms/internal/zzckc;

    new-instance v0, Lcom/google/android/gms/internal/zzckg;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzckg;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->r:Lcom/google/android/gms/internal/zzckg;

    new-instance v0, Lcom/google/android/gms/internal/zzcjn;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcjn;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->t:Lcom/google/android/gms/internal/zzcjn;

    new-instance v0, Lcom/google/android/gms/internal/zzcll;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcll;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->w:Lcom/google/android/gms/internal/zzcll;

    new-instance v0, Lcom/google/android/gms/internal/zzchv;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzchv;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->v:Lcom/google/android/gms/internal/zzchv;

    new-instance v0, Lcom/google/android/gms/measurement/AppMeasurement;

    invoke-direct {v0, p0}, Lcom/google/android/gms/measurement/AppMeasurement;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->i:Lcom/google/android/gms/measurement/AppMeasurement;

    new-instance v0, Lcom/google/firebase/analytics/FirebaseAnalytics;

    invoke-direct {v0, p0}, Lcom/google/firebase/analytics/FirebaseAnalytics;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->j:Lcom/google/firebase/analytics/FirebaseAnalytics;

    new-instance v0, Lcom/google/android/gms/internal/zzclf;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzclf;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->g:Lcom/google/android/gms/internal/zzclf;

    new-instance v0, Lcom/google/android/gms/internal/zzcig;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcig;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->h:Lcom/google/android/gms/internal/zzcig;

    new-instance v0, Lcom/google/android/gms/internal/zzcih;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcih;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->R()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->f:Lcom/google/android/gms/internal/zzcih;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Landroid/app/Application;

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->l()Lcom/google/android/gms/internal/zzcjn;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->l()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Landroid/app/Application;

    if-eqz v0, :cond_1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->l()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    iget-object v2, v1, Lcom/google/android/gms/internal/zzcjn;->a:Lcom/google/android/gms/internal/zzckb;

    if-nez v2, :cond_0

    new-instance v2, Lcom/google/android/gms/internal/zzckb;

    const/4 v3, 0x0

    invoke-direct {v2, v1, v3}, Lcom/google/android/gms/internal/zzckb;-><init>(Lcom/google/android/gms/internal/zzcjn;Lcom/google/android/gms/internal/zzcjo;)V

    iput-object v2, v1, Lcom/google/android/gms/internal/zzcjn;->a:Lcom/google/android/gms/internal/zzckb;

    :cond_0
    iget-object v2, v1, Lcom/google/android/gms/internal/zzcjn;->a:Lcom/google/android/gms/internal/zzckb;

    invoke-virtual {v0, v2}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    iget-object v2, v1, Lcom/google/android/gms/internal/zzcjn;->a:Lcom/google/android/gms/internal/zzckb;

    invoke-virtual {v0, v2}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Registered activity lifecycle callback"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->f:Lcom/google/android/gms/internal/zzcih;

    new-instance v1, Lcom/google/android/gms/internal/zzcin;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzcin;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcih;->a(Ljava/lang/Runnable;)V

    return-void

    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Application context is not an Application"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static D()V
    .locals 2

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected call on client side"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final H()V
    .locals 4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->k:Lcom/google/android/gms/internal/zzclq;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->S()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->d:Lcom/google/android/gms/internal/zzchx;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->S()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->u:Lcom/google/android/gms/internal/zzchh;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->S()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "App measurement is starting up, version"

    const-wide/16 v2, 0x2e86

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "To enable debug logging run: adb shell setprop log.tag.FA VERBOSE"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->u:Lcom/google/android/gms/internal/zzchh;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchh;->z()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzclq;->j(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v0, "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none."

    :goto_0
    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Debug-level message logging enabled"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    iget v0, p0, Lcom/google/android/gms/internal/zzcim;->H:I

    iget v1, p0, Lcom/google/android/gms/internal/zzcim;->I:I

    if-eq v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Not all components initialized"

    iget v2, p0, Lcom/google/android/gms/internal/zzcim;->H:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, p0, Lcom/google/android/gms/internal/zzcim;->I:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->z:Z

    return-void

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_2

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private final I()Lcom/google/android/gms/internal/zzchv;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->v:Lcom/google/android/gms/internal/zzchv;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Network broadcast receiver not created"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->v:Lcom/google/android/gms/internal/zzchv;

    return-object v0
.end method

.method private final J()Lcom/google/android/gms/internal/zzcll;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->w:Lcom/google/android/gms/internal/zzcll;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->w:Lcom/google/android/gms/internal/zzcll;

    return-object v0
.end method

.method private final K()Z
    .locals 3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    const-string v0, "google_app_measurement.db"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    :try_start_0
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v1, "rw"

    invoke-direct {v0, v2, v1}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->E:Ljava/nio/channels/FileChannel;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->E:Ljava/nio/channels/FileChannel;

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->tryLock()Ljava/nio/channels/FileLock;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->D:Ljava/nio/channels/FileLock;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->D:Ljava/nio/channels/FileLock;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Storage concurrent access okay"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Storage concurrent data access panic"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Failed to acquire storage lock"

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    :catch_1
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Failed to access storage lock file"

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private final L()J
    .locals 10

    const-wide/16 v8, 0x3c

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-object v0, v4, Lcom/google/android/gms/internal/zzchx;->g:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v0

    const-wide/16 v6, 0x0

    cmp-long v5, v0, v6

    if-nez v5, :cond_0

    const-wide/16 v0, 0x1

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjk;->p()Lcom/google/android/gms/internal/zzclq;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzclq;->z()Ljava/security/SecureRandom;

    move-result-object v5

    const v6, 0x5265c00

    invoke-virtual {v5, v6}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v5

    int-to-long v6, v5

    add-long/2addr v0, v6

    iget-object v4, v4, Lcom/google/android/gms/internal/zzchx;->g:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v4, v0, v1}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_0
    add-long/2addr v0, v2

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    div-long/2addr v0, v8

    div-long/2addr v0, v8

    const-wide/16 v2, 0x18

    div-long/2addr v0, v2

    return-wide v0
.end method

.method private final M()Z
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->G()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->B()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private final N()V
    .locals 18

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->O()Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    return-void

    :cond_0
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcim;->K:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    const-wide/32 v4, 0x36ee80

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcim;->K:J

    sub-long/2addr v2, v6

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    sub-long v2, v4, v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-lez v4, :cond_1

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Upload has been suspended. Will update scheduling later in approximately ms"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->I()Lcom/google/android/gms/internal/zzchv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchv;->b()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->J()Lcom/google/android/gms/internal/zzcll;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcll;->y()V

    goto :goto_0

    :cond_1
    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/google/android/gms/internal/zzcim;->K:J

    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->b()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->M()Z

    move-result v2

    if-nez v2, :cond_4

    :cond_3
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Nothing to upload or uploading impossible"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->I()Lcom/google/android/gms/internal/zzchv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchv;->b()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->J()Lcom/google/android/gms/internal/zzcll;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcll;->y()V

    goto :goto_0

    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->C:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v6, v7, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v8

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->H()Z

    move-result v2

    if-nez v2, :cond_5

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->C()Z

    move-result v2

    if-eqz v2, :cond_7

    :cond_5
    const/4 v2, 0x1

    move v6, v2

    :goto_1
    if-eqz v6, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgn;->A()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_8

    const-string v3, ".none."

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_8

    const-wide/16 v10, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->x:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v10, v11, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v7

    iget-object v7, v7, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v10

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v7

    iget-object v7, v7, Lcom/google/android/gms/internal/zzchx;->d:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v12

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgo;->E()J

    move-result-wide v14

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgo;->F()J

    move-result-wide v16

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v14

    const-wide/16 v16, 0x0

    cmp-long v7, v14, v16

    if-nez v7, :cond_a

    const-wide/16 v4, 0x0

    :cond_6
    :goto_3
    const-wide/16 v2, 0x0

    cmp-long v2, v4, v2

    if-nez v2, :cond_e

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Next upload time is 0"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->I()Lcom/google/android/gms/internal/zzchv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchv;->b()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->J()Lcom/google/android/gms/internal/zzcll;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcll;->y()V

    goto/16 :goto_0

    :cond_7
    const/4 v2, 0x0

    move v6, v2

    goto :goto_1

    :cond_8
    const-wide/16 v10, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->w:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v10, v11, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    goto :goto_2

    :cond_9
    const-wide/16 v10, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->v:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v10, v11, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    goto :goto_2

    :cond_a
    sub-long/2addr v14, v4

    invoke-static {v14, v15}, Ljava/lang/Math;->abs(J)J

    move-result-wide v14

    sub-long v14, v4, v14

    sub-long/2addr v10, v4

    invoke-static {v10, v11}, Ljava/lang/Math;->abs(J)J

    move-result-wide v10

    sub-long v10, v4, v10

    sub-long/2addr v12, v4

    invoke-static {v12, v13}, Ljava/lang/Math;->abs(J)J

    move-result-wide v12

    sub-long v12, v4, v12

    invoke-static {v10, v11, v12, v13}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v10

    add-long v4, v14, v8

    if-eqz v6, :cond_b

    const-wide/16 v6, 0x0

    cmp-long v6, v10, v6

    if-lez v6, :cond_b

    invoke-static {v14, v15, v10, v11}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v4

    add-long/2addr v4, v2

    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v6

    invoke-virtual {v6, v10, v11, v2, v3}, Lcom/google/android/gms/internal/zzclq;->a(JJ)Z

    move-result v6

    if-nez v6, :cond_c

    add-long v4, v10, v2

    :cond_c
    const-wide/16 v2, 0x0

    cmp-long v2, v12, v2

    if-eqz v2, :cond_6

    cmp-long v2, v12, v14

    if-ltz v2, :cond_6

    const/4 v2, 0x0

    move v3, v2

    :goto_4
    const/16 v6, 0x14

    const/4 v7, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->E:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v7, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    invoke-static {v6, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    if-ge v3, v2, :cond_d

    const-wide/16 v6, 0x1

    shl-long/2addr v6, v3

    const-wide/16 v8, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->D:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    invoke-static {v8, v9, v10, v11}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v8

    mul-long/2addr v6, v8

    add-long/2addr v4, v6

    cmp-long v2, v4, v12

    if-gtz v2, :cond_6

    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_4

    :cond_d
    const-wide/16 v4, 0x0

    goto/16 :goto_3

    :cond_e
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchq;->y()Z

    move-result v2

    if-nez v2, :cond_f

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "No network"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->I()Lcom/google/android/gms/internal/zzchv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchv;->a()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->J()Lcom/google/android/gms/internal/zzcll;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcll;->y()V

    goto/16 :goto_0

    :cond_f
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->e:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->t:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v8, v9, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v8

    invoke-virtual {v8, v6, v7, v2, v3}, Lcom/google/android/gms/internal/zzclq;->a(JJ)Z

    move-result v8

    if-nez v8, :cond_11

    add-long/2addr v2, v6

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    :goto_5
    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->I()Lcom/google/android/gms/internal/zzchv;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchv;->b()V

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v4}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-gtz v4, :cond_10

    const-wide/16 v4, 0x0

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->y:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v4

    iget-object v4, v4, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v5}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_10
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Upload scheduled in approximately ms"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->J()Lcom/google/android/gms/internal/zzcll;

    move-result-object v4

    invoke-virtual {v4, v2, v3}, Lcom/google/android/gms/internal/zzcll;->a(J)V

    goto/16 :goto_0

    :cond_11
    move-wide v2, v4

    goto :goto_5
.end method

.method private final O()Z
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->A:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private final P()V
    .locals 5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->M:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    if-eqz v0, :cond_2

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Not stopping services. fetch, network, upload"

    iget-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iget-boolean v3, p0, Lcom/google/android/gms/internal/zzcim;->M:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iget-boolean v4, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Stopping uploading service(s)"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method private final a(Ljava/nio/channels/FileChannel;)I
    .locals 5

    const/4 v4, 0x4

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Bad chanel to read from"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_1
    :goto_0
    return v0

    :cond_2
    invoke-static {v4}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    const-wide/16 v2, 0x0

    :try_start_0
    invoke-virtual {p1, v2, v3}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    invoke-virtual {p1, v1}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result v2

    if-eq v2, v4, :cond_3

    const/4 v1, -0x1

    if-eq v2, v1, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v3, "Unexpected data length. Bytes read"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Failed to read from channel"

    invoke-virtual {v2, v3, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    :cond_3
    :try_start_1
    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->getInt()I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v0

    goto :goto_0
.end method

.method private final a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/google/android/gms/internal/zzcgi;
    .locals 24

    const-string v9, "Unknown"

    const-string v6, "Unknown"

    const/high16 v2, -0x80000000

    const-string v3, "Unknown"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    if-nez v4, :cond_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "PackageManager is null, can not log app install information"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    const/4 v3, 0x0

    :goto_0
    return-object v3

    :cond_0
    :try_start_0
    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Landroid/content/pm/PackageManager;->getInstallerPackageName(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    :goto_1
    if-nez v9, :cond_3

    const-string v9, "manual_install"

    :cond_1
    :goto_2
    :try_start_1
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v4

    const/4 v5, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v4, v0, v5}, Lcom/google/android/gms/internal/zzbhe;->b(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v2

    move-object/from16 v0, p2

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzbhe;->b(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_4

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    :goto_3
    :try_start_2
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iget v2, v4, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_2

    :cond_2
    new-instance v3, Lcom/google/android/gms/internal/zzcgi;

    int-to-long v7, v2

    const-wide/16 v10, 0x2e86

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v2, v0, v1}, Lcom/google/android/gms/internal/zzclq;->b(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v12

    const/4 v14, 0x0

    const/16 v16, 0x0

    const-string v17, ""

    const-wide/16 v18, 0x0

    const-wide/16 v20, 0x0

    const/16 v22, 0x0

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v15, p4

    move/from16 v23, p5

    invoke-direct/range {v3 .. v23}, Lcom/google/android/gms/internal/zzcgi;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;ZZLjava/lang/String;JJIZ)V

    goto :goto_0

    :catch_0
    move-exception v4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Error retrieving installer package name. appId"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v4, v5, v7}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    :cond_3
    const-string v4, "com.android.vending"

    invoke-virtual {v4, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    const-string v9, ""

    goto :goto_2

    :catch_1
    move-exception v2

    move-object v2, v3

    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Error retrieving newly installed package info. appId, appName"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v3, 0x0

    goto/16 :goto_0

    :catch_2
    move-exception v3

    goto :goto_4

    :cond_4
    move-object v2, v3

    goto :goto_3
.end method

.method public static a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzcim;
    .locals 3

    invoke-static {p0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/google/android/gms/internal/zzcim;->a:Lcom/google/android/gms/internal/zzcim;

    if-nez v0, :cond_1

    const-class v1, Lcom/google/android/gms/internal/zzcim;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/zzcim;->a:Lcom/google/android/gms/internal/zzcim;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/zzcjm;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzcjm;-><init>(Landroid/content/Context;)V

    new-instance v2, Lcom/google/android/gms/internal/zzcim;

    invoke-direct {v2, v0}, Lcom/google/android/gms/internal/zzcim;-><init>(Lcom/google/android/gms/internal/zzcjm;)V

    sput-object v2, Lcom/google/android/gms/internal/zzcim;->a:Lcom/google/android/gms/internal/zzcim;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/google/android/gms/internal/zzcim;->a:Lcom/google/android/gms/internal/zzcim;

    return-object v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private final a(Lcom/google/android/gms/internal/zzcgh;)V
    .locals 10

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xcc

    move-object v0, p0

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;ILjava/lang/Throwable;[BLjava/util/Map;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->c()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Landroid/net/Uri$Builder;

    invoke-direct {v4}, Landroid/net/Uri$Builder;-><init>()V

    sget-object v0, Lcom/google/android/gms/internal/zzchc;->g:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v4, v0}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v5

    sget-object v0, Lcom/google/android/gms/internal/zzchc;->h:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v5, v0}, Landroid/net/Uri$Builder;->encodedAuthority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v5

    const-string v6, "config/app/"

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v6, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-virtual {v5, v0}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "app_instance_id"

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "platform"

    const-string v2, "android"

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "gmp_version"

    const-string v2, "11910"

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    invoke-virtual {v4}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v7

    :try_start_0
    new-instance v8, Ljava/net/URL;

    invoke-direct {v8, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Fetching remote configuration"

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcly;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzcig;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v0, :cond_2

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v3, Landroid/support/v4/util/ArrayMap;

    invoke-direct {v3}, Landroid/support/v4/util/ArrayMap;-><init>()V

    const-string v0, "If-Modified-Since"

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v5, v3

    :goto_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v2

    new-instance v6, Lcom/google/android/gms/internal/zzciq;

    invoke-direct {v6, p0}, Lcom/google/android/gms/internal/zzciq;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-static {v8}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {v6}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->s()Lcom/google/android/gms/internal/zzcih;

    move-result-object v9

    new-instance v0, Lcom/google/android/gms/internal/zzchu;

    const/4 v4, 0x0

    move-object v3, v8

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzchu;-><init>(Lcom/google/android/gms/internal/zzchq;Ljava/lang/String;Ljava/net/URL;[BLjava/util/Map;Lcom/google/android/gms/internal/zzchs;)V

    invoke-virtual {v9, v0}, Lcom/google/android/gms/internal/zzcih;->b(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Failed to parse config URL. Not fetching. appId"

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2, v7}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_0

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v6}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_2
    move-object v5, v3

    goto :goto_2
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzcim;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->H()V

    return-void
.end method

.method private static a(Lcom/google/android/gms/internal/zzcjk;)V
    .locals 2

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Component not created"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method private final a(ILjava/nio/channels/FileChannel;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-nez v2, :cond_2

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "Bad chanel to read from"

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    move v0, v1

    :cond_1
    :goto_0
    return v0

    :cond_2
    const/4 v2, 0x4

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    const-wide/16 v4, 0x0

    :try_start_0
    invoke-virtual {p2, v4, v5}, Ljava/nio/channels/FileChannel;->truncate(J)Ljava/nio/channels/FileChannel;

    invoke-virtual {p2, v2}, Ljava/nio/channels/FileChannel;->write(Ljava/nio/ByteBuffer;)I

    const/4 v2, 0x1

    invoke-virtual {p2, v2}, Ljava/nio/channels/FileChannel;->force(Z)V

    invoke-virtual {p2}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v2

    const-wide/16 v4, 0x4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Error writing to channel. Bytes written"

    invoke-virtual {p2}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Failed to write to channel"

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    move v0, v1

    goto :goto_0
.end method

.method private static a(Lcom/google/android/gms/internal/zzcmb;Ljava/lang/String;Ljava/lang/Object;)Z
    .locals 6

    const/4 v0, 0x0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v2, p0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v3, v2

    move v1, v0

    :goto_1
    if-ge v1, v3, :cond_0

    aget-object v4, v2, v1

    iget-object v5, v4, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    instance-of v1, p2, Ljava/lang/Long;

    if-eqz v1, :cond_2

    iget-object v1, v4, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    invoke-virtual {p2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    :cond_2
    instance-of v1, p2, Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, v4, Lcom/google/android/gms/internal/zzcmc;->b:Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    :cond_3
    instance-of v1, p2, Ljava/lang/Double;

    if-eqz v1, :cond_0

    iget-object v1, v4, Lcom/google/android/gms/internal/zzcmc;->d:Ljava/lang/Double;

    invoke-virtual {p2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_4
    const/4 v0, 0x1

    goto :goto_0

    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private final a(Ljava/lang/String;J)Z
    .locals 30

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    new-instance v21, Lcom/google/android/gms/internal/zzcim$zza;

    const/4 v2, 0x0

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/zzcim$zza;-><init>(Lcom/google/android/gms/internal/zzcim;Lcom/google/android/gms/internal/zzcin;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v14

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/google/android/gms/internal/zzcim;->J:J

    move-wide/from16 v16, v0

    invoke-static/range {v21 .. v21}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjl;->Q()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const/4 v5, 0x0

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_6

    const-wide/16 v6, -0x1

    cmp-long v5, v16, v6

    if-eqz v5, :cond_3

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    move-object v6, v5

    :goto_0
    const-wide/16 v8, -0x1

    cmp-long v5, v16, v8

    if-eqz v5, :cond_4

    const-string v5, "rowid <= ? and "

    :goto_1
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    add-int/lit16 v7, v7, 0x94

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v7}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v7, "select app_id, metadata_fingerprint from raw_events where "

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v5

    if-nez v5, :cond_5

    if-eqz v3, :cond_0

    :try_start_2
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_0
    :goto_2
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    if-eqz v2, :cond_1

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_10

    :cond_1
    const/4 v2, 0x1

    :goto_3
    if-nez v2, :cond_41

    const/16 v17, 0x0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    move-object/from16 v22, v0

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    const/4 v12, 0x0

    const/4 v2, 0x0

    move v13, v2

    :goto_4
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v13, v2, :cond_22

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v3

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v3, v4, v2}, Lcom/google/android/gms/internal/zzcig;->b(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_12

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Dropping blacklisted raw event. appId"

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v6

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v6, v2}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzclq;->l(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzclq;->m(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_11

    :cond_2
    const/4 v2, 0x1

    :goto_5
    if-nez v2, :cond_48

    const-string v3, "_err"

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_48

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    const/16 v4, 0xb

    const-string v5, "_ev"

    move-object/from16 v0, v21

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v6, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gms/internal/zzcmb;

    iget-object v6, v6, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move v2, v12

    move/from16 v3, v17

    :goto_6
    add-int/lit8 v4, v13, 0x1

    move v13, v4

    move v12, v2

    move/from16 v17, v3

    goto/16 :goto_4

    :cond_3
    const/4 v5, 0x1

    :try_start_3
    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    move-object v6, v5

    goto/16 :goto_0

    :cond_4
    const-string v5, ""

    goto/16 :goto_1

    :cond_5
    const/4 v5, 0x0

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-object v13, v5

    move-object v11, v3

    move-object v12, v4

    :goto_7
    :try_start_4
    const-string v3, "raw_events_metadata"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "metadata"

    aput-object v6, v4, v5

    const-string v5, "app_id = ? and metadata_fingerprint = ?"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v12, v6, v7

    const/4 v7, 0x1

    aput-object v13, v6, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "rowid"

    const-string v10, "2"

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-nez v3, :cond_a

    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Raw event metadata record is missing. appId"

    invoke-static {v12}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_4
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    if-eqz v11, :cond_0

    :try_start_5
    invoke-interface {v11}, Landroid/database/Cursor;->close()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_2

    :catchall_0
    move-exception v2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v2

    :cond_6
    const-wide/16 v6, -0x1

    cmp-long v5, v16, v6

    if-eqz v5, :cond_7

    const/4 v5, 0x2

    :try_start_6
    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v7, 0x0

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    move-object v6, v5

    :goto_8
    const-wide/16 v8, -0x1

    cmp-long v5, v16, v8

    if-eqz v5, :cond_8

    const-string v5, " and rowid <= ?"

    :goto_9
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    add-int/lit8 v7, v7, 0x54

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v7}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v7, "select metadata_fingerprint from raw_events where app_id = ?"

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, " order by rowid limit 1;"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_6
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result v5

    if-nez v5, :cond_9

    if-eqz v3, :cond_0

    :try_start_7
    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    :cond_7
    const/4 v5, 0x1

    :try_start_8
    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v7, 0x0

    aput-object v7, v5, v6

    move-object v6, v5

    goto :goto_8

    :cond_8
    const-string v5, ""

    goto :goto_9

    :cond_9
    const/4 v5, 0x0

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_8
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_8 .. :try_end_8} :catch_4
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    move-object v13, v5

    move-object v11, v3

    move-object v12, v4

    goto/16 :goto_7

    :cond_a
    const/4 v3, 0x0

    :try_start_9
    invoke-interface {v11, v3}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v3

    const/4 v4, 0x0

    array-length v5, v3

    invoke-static {v3, v4, v5}, Lcom/google/android/gms/internal/zzfjj;->a([BII)Lcom/google/android/gms/internal/zzfjj;

    move-result-object v3

    new-instance v4, Lcom/google/android/gms/internal/zzcme;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzcme;-><init>()V
    :try_end_9
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    :try_start_a
    invoke-virtual {v4, v3}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_a .. :try_end_a} :catch_1
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    :try_start_b
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v5, "Get multiple raw event metadata records, expected one. appId"

    invoke-static {v12}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_b
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    move-object/from16 v0, v21

    invoke-interface {v0, v4}, Lcom/google/android/gms/internal/zzcgq;->a(Lcom/google/android/gms/internal/zzcme;)V

    const-wide/16 v4, -0x1

    cmp-long v3, v16, v4

    if-eqz v3, :cond_c

    const-string v5, "app_id = ? and metadata_fingerprint = ? and rowid <= ?"

    const/4 v3, 0x3

    new-array v6, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v12, v6, v3

    const/4 v3, 0x1

    aput-object v13, v6, v3

    const/4 v3, 0x2

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v3

    :goto_a
    const-string v3, "raw_events"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/String;

    const/4 v7, 0x0

    const-string v8, "rowid"

    aput-object v8, v4, v7

    const/4 v7, 0x1

    const-string v8, "name"

    aput-object v8, v4, v7

    const/4 v7, 0x2

    const-string v8, "timestamp"

    aput-object v8, v4, v7

    const/4 v7, 0x3

    const-string v8, "data"

    aput-object v8, v4, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "rowid"

    const/4 v10, 0x0

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_b
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    move-result-object v3

    :try_start_c
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-nez v2, :cond_d

    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v4, "Raw event data disappeared while in transaction. appId"

    invoke-static {v12}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_c
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_c .. :try_end_c} :catch_5
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    if-eqz v3, :cond_0

    :try_start_d
    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    goto/16 :goto_2

    :catch_0
    move-exception v2

    :try_start_e
    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Data loss. Failed to merge raw event metadata. appId"

    invoke-static {v12}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_e
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_e .. :try_end_e} :catch_1
    .catchall {:try_start_e .. :try_end_e} :catchall_2

    if-eqz v11, :cond_0

    :try_start_f
    invoke-interface {v11}, Landroid/database/Cursor;->close()V
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    goto/16 :goto_2

    :cond_c
    :try_start_10
    const-string v5, "app_id = ? and metadata_fingerprint = ?"

    const/4 v3, 0x2

    new-array v6, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v12, v6, v3

    const/4 v3, 0x1

    aput-object v13, v6, v3
    :try_end_10
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_10 .. :try_end_10} :catch_1
    .catchall {:try_start_10 .. :try_end_10} :catchall_2

    goto :goto_a

    :catch_1
    move-exception v2

    move-object v3, v11

    move-object v4, v12

    :goto_b
    :try_start_11
    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v5

    const-string v6, "Data loss. Error selecting raw event. appId"

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v5, v6, v4, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    if-eqz v3, :cond_0

    :try_start_12
    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_0

    goto/16 :goto_2

    :cond_d
    const/4 v2, 0x0

    :try_start_13
    invoke-interface {v3, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    const/4 v2, 0x3

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v2

    const/4 v6, 0x0

    array-length v7, v2

    invoke-static {v2, v6, v7}, Lcom/google/android/gms/internal/zzfjj;->a([BII)Lcom/google/android/gms/internal/zzfjj;

    move-result-object v2

    new-instance v6, Lcom/google/android/gms/internal/zzcmb;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzcmb;-><init>()V
    :try_end_13
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_13 .. :try_end_13} :catch_5
    .catchall {:try_start_13 .. :try_end_13} :catchall_1

    :try_start_14
    invoke-virtual {v6, v2}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_14} :catch_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_14 .. :try_end_14} :catch_5
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    const/4 v2, 0x1

    :try_start_15
    invoke-interface {v3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    const/4 v2, 0x2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v6, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    move-object/from16 v0, v21

    invoke-interface {v0, v4, v5, v6}, Lcom/google/android/gms/internal/zzcgq;->a(JLcom/google/android/gms/internal/zzcmb;)Z
    :try_end_15
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_15 .. :try_end_15} :catch_5
    .catchall {:try_start_15 .. :try_end_15} :catchall_1

    move-result v2

    if-nez v2, :cond_e

    if-eqz v3, :cond_0

    :try_start_16
    invoke-interface {v3}, Landroid/database/Cursor;->close()V
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_0

    goto/16 :goto_2

    :catch_2
    move-exception v2

    :try_start_17
    invoke-virtual {v14}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Data loss. Failed to merge raw event. appId"

    invoke-static {v12}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v4, v5, v6, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_e
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_17
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_17 .. :try_end_17} :catch_5
    .catchall {:try_start_17 .. :try_end_17} :catchall_1

    move-result v2

    if-nez v2, :cond_d

    if-eqz v3, :cond_0

    :try_start_18
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    :catchall_1
    move-exception v2

    :goto_c
    if-eqz v3, :cond_f

    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_f
    throw v2

    :cond_10
    const/4 v2, 0x0

    goto/16 :goto_3

    :cond_11
    const/4 v2, 0x0

    goto/16 :goto_5

    :cond_12
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v3

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v3, v4, v2}, Lcom/google/android/gms/internal/zzcig;->c(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_13

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzclq;->n(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_21

    :cond_13
    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    if-nez v2, :cond_14

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    const/4 v5, 0x0

    new-array v5, v5, [Lcom/google/android/gms/internal/zzcmc;

    iput-object v5, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_14
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v6, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v7, v6

    const/4 v2, 0x0

    move v5, v2

    :goto_d
    if-ge v5, v7, :cond_16

    aget-object v2, v6, v5

    const-string v8, "_c"

    iget-object v9, v2, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_15

    const-wide/16 v8, 0x1

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v2, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    const/4 v2, 0x1

    move v3, v2

    move v2, v4

    :goto_e
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    move v4, v2

    goto :goto_d

    :cond_15
    const-string v8, "_r"

    iget-object v9, v2, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_47

    const-wide/16 v8, 0x1

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v2, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    const/4 v2, 0x1

    goto :goto_e

    :cond_16
    if-nez v3, :cond_17

    if-eqz v14, :cond_17

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v5, "Marking event as conversion"

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v6

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v6, v2}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v3, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v2, v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/google/android/gms/internal/zzcmc;

    new-instance v3, Lcom/google/android/gms/internal/zzcmc;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzcmc;-><init>()V

    const-string v5, "_c"

    iput-object v5, v3, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    const-wide/16 v6, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    iput-object v5, v3, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    array-length v5, v2

    add-int/lit8 v5, v5, -0x1

    aput-object v3, v2, v5

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v3, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/zzcmb;

    iput-object v2, v3, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_17
    if-nez v4, :cond_18

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Marking event as real-time"

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v5

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v5, v2}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v4, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v3, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v2, v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/google/android/gms/internal/zzcmc;

    new-instance v3, Lcom/google/android/gms/internal/zzcmc;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzcmc;-><init>()V

    const-string v4, "_r"

    iput-object v4, v3, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    const-wide/16 v4, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v3, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    aput-object v3, v2, v4

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v3, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/zzcmb;

    iput-object v2, v3, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_18
    const/4 v2, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->L()J

    move-result-wide v4

    move-object/from16 v0, v21

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v6, v6, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x1

    invoke-virtual/range {v3 .. v11}, Lcom/google/android/gms/internal/zzcgo;->a(JLjava/lang/String;ZZZZZ)Lcom/google/android/gms/internal/zzcgp;

    move-result-object v3

    iget-wide v4, v3, Lcom/google/android/gms/internal/zzcgp;->e:J

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    move-object/from16 v0, v21

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v6, v6, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v3, v6}, Lcom/google/android/gms/internal/zzcgn;->a(Ljava/lang/String;)I

    move-result v3

    int-to-long v6, v3

    cmp-long v3, v4, v6

    if-lez v3, :cond_46

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    const/4 v3, 0x0

    :goto_f
    iget-object v4, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v4, v4

    if-ge v3, v4, :cond_1b

    const-string v4, "_r"

    iget-object v5, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    aget-object v5, v5, v3

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1c

    iget-object v4, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v4, v4

    add-int/lit8 v4, v4, -0x1

    new-array v4, v4, [Lcom/google/android/gms/internal/zzcmc;

    if-lez v3, :cond_19

    iget-object v5, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v5, v6, v4, v7, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_19
    array-length v5, v4

    if-ge v3, v5, :cond_1a

    iget-object v5, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    add-int/lit8 v6, v3, 0x1

    array-length v7, v4

    sub-int/2addr v7, v3

    invoke-static {v5, v6, v4, v3, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_1a
    iput-object v4, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_1b
    :goto_10
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_21

    if-eqz v14, :cond_21

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->L()J

    move-result-wide v4

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v6, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x1

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v3 .. v11}, Lcom/google/android/gms/internal/zzcgo;->a(JLjava/lang/String;ZZZZZ)Lcom/google/android/gms/internal/zzcgp;

    move-result-object v2

    iget-wide v2, v2, Lcom/google/android/gms/internal/zzcgp;->c:J

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    move-object/from16 v0, v21

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    sget-object v6, Lcom/google/android/gms/internal/zzchc;->p:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v4, v5, v6}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;Lcom/google/android/gms/internal/zzchd;)I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_21

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Too many conversions. Not logging as conversion. appId"

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    const/4 v5, 0x0

    const/4 v4, 0x0

    iget-object v7, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    array-length v8, v7

    const/4 v3, 0x0

    move v6, v3

    :goto_11
    if-ge v6, v8, :cond_1e

    aget-object v3, v7, v6

    const-string v9, "_c"

    iget-object v10, v3, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1d

    move v4, v5

    :goto_12
    add-int/lit8 v5, v6, 0x1

    move v6, v5

    move v5, v4

    move-object v4, v3

    goto :goto_11

    :cond_1c
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_f

    :cond_1d
    const-string v9, "_err"

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    invoke-virtual {v9, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_45

    const/4 v3, 0x1

    move-object/from16 v29, v4

    move v4, v3

    move-object/from16 v3, v29

    goto :goto_12

    :cond_1e
    if-eqz v5, :cond_1f

    if-eqz v4, :cond_1f

    iget-object v3, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const/4 v5, 0x1

    new-array v5, v5, [Lcom/google/android/gms/internal/zzcmc;

    const/4 v6, 0x0

    aput-object v4, v5, v6

    invoke-static {v3, v5}, Lcom/google/android/gms/common/util/zza;->a([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Lcom/google/android/gms/internal/zzcmc;

    iput-object v3, v2, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    move/from16 v4, v17

    :goto_13
    move-object/from16 v0, v22

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    add-int/lit8 v3, v12, 0x1

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcmb;

    aput-object v2, v5, v12

    move v2, v3

    move v3, v4

    goto/16 :goto_6

    :cond_1f
    if-eqz v4, :cond_20

    const-string v2, "_err"

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    const-wide/16 v2, 0xa

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcmc;->c:Ljava/lang/Long;

    move/from16 v4, v17

    goto :goto_13

    :cond_20
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Did not find conversion parameter. appId"

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_21
    move/from16 v4, v17

    goto :goto_13

    :cond_22
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->c:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v12, v2, :cond_23

    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    invoke-static {v2, v12}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    :cond_23
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    move-object/from16 v0, v22

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v3, v4}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;[Lcom/google/android/gms/internal/zzcmg;[Lcom/google/android/gms/internal/zzcmb;)[Lcom/google/android/gms/internal/zzcma;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->A:[Lcom/google/android/gms/internal/zzcma;

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->b:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_35

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    const-string v4, "1"

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->q()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    const-string v5, "measurement.event_sampling_enabled"

    invoke-virtual {v2, v3, v5}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_35

    new-instance v23, Ljava/util/HashMap;

    invoke-direct/range {v23 .. v23}, Ljava/util/HashMap;-><init>()V

    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    array-length v2, v2

    new-array v0, v2, [Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v24, v0

    const/16 v18, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzclq;->z()Ljava/security/SecureRandom;

    move-result-object v25

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    array-length v0, v0

    move/from16 v27, v0

    const/4 v2, 0x0

    move/from16 v20, v2

    :goto_14
    move/from16 v0, v20

    move/from16 v1, v27

    if-ge v0, v1, :cond_33

    aget-object v28, v26, v20

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    const-string v3, "_ep"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_28

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    const-string v2, "_en"

    move-object/from16 v0, v28

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmb;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/zzcgw;

    if-nez v3, :cond_24

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v3, v4, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    move-object/from16 v0, v23

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_24
    iget-object v2, v3, Lcom/google/android/gms/internal/zzcgw;->g:Ljava/lang/Long;

    if-nez v2, :cond_32

    iget-object v2, v3, Lcom/google/android/gms/internal/zzcgw;->h:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v6, 0x1

    cmp-long v2, v4, v6

    if-lez v2, :cond_25

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const-string v4, "_sr"

    iget-object v5, v3, Lcom/google/android/gms/internal/zzcgw;->h:Ljava/lang/Long;

    invoke-static {v2, v4, v5}, Lcom/google/android/gms/internal/zzclq;->a([Lcom/google/android/gms/internal/zzcmc;Ljava/lang/String;Ljava/lang/Object;)[Lcom/google/android/gms/internal/zzcmc;

    move-result-object v2

    move-object/from16 v0, v28

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_25
    iget-object v2, v3, Lcom/google/android/gms/internal/zzcgw;->i:Ljava/lang/Boolean;

    if-eqz v2, :cond_26

    iget-object v2, v3, Lcom/google/android/gms/internal/zzcgw;->i:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_26

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const-string v3, "_efs"

    const-wide/16 v4, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/google/android/gms/internal/zzclq;->a([Lcom/google/android/gms/internal/zzcmc;Ljava/lang/String;Ljava/lang/Object;)[Lcom/google/android/gms/internal/zzcmc;

    move-result-object v2

    move-object/from16 v0, v28

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    :cond_26
    add-int/lit8 v2, v18, 0x1

    aput-object v28, v24, v18

    :cond_27
    :goto_15
    add-int/lit8 v3, v20, 0x1

    move/from16 v20, v3

    move/from16 v18, v2

    goto/16 :goto_14

    :cond_28
    const/4 v2, 0x1

    const-string v3, "_dbg"

    const-wide/16 v4, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v28

    invoke-static {v0, v3, v4}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcmb;Ljava/lang/String;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_44

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcig;->d(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    move/from16 v19, v2

    :goto_16
    if-gtz v19, :cond_29

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Sample rate must be positive. event, rate"

    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    add-int/lit8 v2, v18, 0x1

    aput-object v28, v24, v18

    goto :goto_15

    :cond_29
    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcgw;

    if-nez v2, :cond_43

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    if-nez v3, :cond_2a

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Event being bundled has no eventAggregate. appId, eventName"

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    new-instance v3, Lcom/google/android/gms/internal/zzcgw;

    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    const-wide/16 v6, 0x1

    const-wide/16 v8, 0x1

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    const-wide/16 v12, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    invoke-direct/range {v3 .. v16}, Lcom/google/android/gms/internal/zzcgw;-><init>(Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V

    :cond_2a
    :goto_17
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    const-string v2, "_eid"

    move-object/from16 v0, v28

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmb;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    if-eqz v2, :cond_2c

    const/4 v4, 0x1

    :goto_18
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    const/4 v5, 0x1

    move/from16 v0, v19

    if-ne v0, v5, :cond_2d

    add-int/lit8 v2, v18, 0x1

    aput-object v28, v24, v18

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_27

    iget-object v4, v3, Lcom/google/android/gms/internal/zzcgw;->g:Ljava/lang/Long;

    if-nez v4, :cond_2b

    iget-object v4, v3, Lcom/google/android/gms/internal/zzcgw;->h:Ljava/lang/Long;

    if-nez v4, :cond_2b

    iget-object v4, v3, Lcom/google/android/gms/internal/zzcgw;->i:Ljava/lang/Boolean;

    if-eqz v4, :cond_27

    :cond_2b
    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Lcom/google/android/gms/internal/zzcgw;->a(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-interface {v0, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_15

    :cond_2c
    const/4 v4, 0x0

    goto :goto_18

    :cond_2d
    move-object/from16 v0, v25

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v5

    if-nez v5, :cond_2f

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const-string v5, "_sr"

    move/from16 v0, v19

    int-to-long v6, v0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v2, v5, v6}, Lcom/google/android/gms/internal/zzclq;->a([Lcom/google/android/gms/internal/zzcmc;Ljava/lang/String;Ljava/lang/Object;)[Lcom/google/android/gms/internal/zzcmc;

    move-result-object v2

    move-object/from16 v0, v28

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    add-int/lit8 v2, v18, 0x1

    aput-object v28, v24, v18

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_2e

    const/4 v4, 0x0

    move/from16 v0, v19

    int-to-long v6, v0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Lcom/google/android/gms/internal/zzcgw;->a(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    :cond_2e
    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v3, v6, v7}, Lcom/google/android/gms/internal/zzcgw;->b(J)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    move-object/from16 v0, v23

    invoke-interface {v0, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_15

    :cond_2f
    iget-wide v6, v3, Lcom/google/android/gms/internal/zzcgw;->f:J

    move-object/from16 v0, v28

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    sub-long v6, v8, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(J)J

    move-result-wide v6

    const-wide/32 v8, 0x5265c00

    cmp-long v5, v6, v8

    if-ltz v5, :cond_31

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const-string v5, "_efs"

    const-wide/16 v6, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v2, v5, v6}, Lcom/google/android/gms/internal/zzclq;->a([Lcom/google/android/gms/internal/zzcmc;Ljava/lang/String;Ljava/lang/Object;)[Lcom/google/android/gms/internal/zzcmc;

    move-result-object v2

    move-object/from16 v0, v28

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-object/from16 v0, v28

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const-string v5, "_sr"

    move/from16 v0, v19

    int-to-long v6, v0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v2, v5, v6}, Lcom/google/android/gms/internal/zzclq;->a([Lcom/google/android/gms/internal/zzcmc;Ljava/lang/String;Ljava/lang/Object;)[Lcom/google/android/gms/internal/zzcmc;

    move-result-object v2

    move-object/from16 v0, v28

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    add-int/lit8 v2, v18, 0x1

    aput-object v28, v24, v18

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_30

    const/4 v4, 0x0

    move/from16 v0, v19

    int-to-long v6, v0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v3, v4, v5, v6}, Lcom/google/android/gms/internal/zzcgw;->a(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    :cond_30
    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v3, v6, v7}, Lcom/google/android/gms/internal/zzcgw;->b(J)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v3

    move-object/from16 v0, v23

    invoke-interface {v0, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_15

    :cond_31
    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_32

    move-object/from16 v0, v28

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v3, v2, v5, v6}, Lcom/google/android/gms/internal/zzcgw;->a(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v2

    move-object/from16 v0, v23

    invoke-interface {v0, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_32
    move/from16 v2, v18

    goto/16 :goto_15

    :cond_33
    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    array-length v2, v2

    move/from16 v0, v18

    if-ge v0, v2, :cond_34

    move-object/from16 v0, v24

    move/from16 v1, v18

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    :cond_34
    invoke-interface/range {v23 .. v23}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_19
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_35

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcgw;

    invoke-virtual {v4, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgw;)V

    goto :goto_19

    :cond_35
    const-wide v2, 0x7fffffffffffffffL

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    const-wide/high16 v2, -0x8000000000000000L

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    const/4 v2, 0x0

    :goto_1a
    move-object/from16 v0, v22

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    array-length v3, v3

    if-ge v2, v3, :cond_38

    move-object/from16 v0, v22

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    aget-object v3, v3, v2

    iget-object v4, v3, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    move-object/from16 v0, v22

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-gez v4, :cond_36

    iget-object v4, v3, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    move-object/from16 v0, v22

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    :cond_36
    iget-object v4, v3, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    move-object/from16 v0, v22

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-lez v4, :cond_37

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    move-object/from16 v0, v22

    iput-object v3, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    :cond_37
    add-int/lit8 v2, v2, 0x1

    goto :goto_1a

    :cond_38
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v6, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v6}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v7

    if-nez v7, :cond_3c

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Bundling raw events w/o app info. appId"

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_39
    :goto_1b
    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    array-length v2, v2

    if-lez v2, :cond_3b

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcly;

    move-result-object v2

    if-eqz v2, :cond_3a

    iget-object v3, v2, Lcom/google/android/gms/internal/zzcly;->a:Ljava/lang/Long;

    if-nez v3, :cond_40

    :cond_3a
    move-object/from16 v0, v21

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->y:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3f

    const-wide/16 v2, -0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->E:Ljava/lang/Long;

    :goto_1c
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, v22

    move/from16 v1, v17

    invoke-virtual {v2, v0, v1}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcme;Z)Z

    :cond_3b
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, v21

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim$zza;->b:Ljava/util/List;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/util/List;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_0

    move-result-object v2

    :try_start_19
    const-string v4, "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v6, v5, v7

    const/4 v7, 0x1

    aput-object v6, v5, v7

    invoke-virtual {v2, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_19
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_19 .. :try_end_19} :catch_3
    .catchall {:try_start_19 .. :try_end_19} :catchall_0

    :goto_1d
    :try_start_1a
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    const/4 v2, 0x1

    :goto_1e
    return v2

    :cond_3c
    :try_start_1b
    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    array-length v2, v2

    if-lez v2, :cond_39

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgh;->h()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_3d

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    :goto_1f
    move-object/from16 v0, v22

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->h:Ljava/lang/Long;

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgh;->g()J

    move-result-wide v4

    const-wide/16 v8, 0x0

    cmp-long v8, v4, v8

    if-nez v8, :cond_42

    :goto_20
    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_3e

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    :goto_21
    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->g:Ljava/lang/Long;

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgh;->r()V

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgh;->o()J

    move-result-wide v2

    long-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->w:Ljava/lang/Integer;

    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v7, v2, v3}, Lcom/google/android/gms/internal/zzcgh;->a(J)V

    move-object/from16 v0, v22

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v7, v2, v3}, Lcom/google/android/gms/internal/zzcgh;->b(J)V

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzcgh;->z()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->x:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v7}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    goto/16 :goto_1b

    :cond_3d
    const/4 v4, 0x0

    goto :goto_1f

    :cond_3e
    const/4 v2, 0x0

    goto :goto_21

    :cond_3f
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Did not find measurement config or missing version info. appId"

    move-object/from16 v0, v21

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim$zza;->a:Lcom/google/android/gms/internal/zzcme;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_1c

    :cond_40
    iget-object v2, v2, Lcom/google/android/gms/internal/zzcly;->a:Ljava/lang/Long;

    move-object/from16 v0, v22

    iput-object v2, v0, Lcom/google/android/gms/internal/zzcme;->E:Ljava/lang/Long;

    goto/16 :goto_1c

    :catch_3
    move-exception v2

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Failed to remove unused event metadata. appId"

    invoke-static {v6}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_1d

    :cond_41
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_1b
    .catchall {:try_start_1b .. :try_end_1b} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    const/4 v2, 0x0

    goto/16 :goto_1e

    :catchall_2
    move-exception v2

    move-object v3, v11

    goto/16 :goto_c

    :catch_4
    move-exception v2

    goto/16 :goto_b

    :catch_5
    move-exception v2

    move-object v4, v12

    goto/16 :goto_b

    :cond_42
    move-wide v2, v4

    goto/16 :goto_20

    :cond_43
    move-object v3, v2

    goto/16 :goto_17

    :cond_44
    move/from16 v19, v2

    goto/16 :goto_16

    :cond_45
    move-object v3, v4

    move v4, v5

    goto/16 :goto_12

    :cond_46
    move/from16 v17, v2

    goto/16 :goto_10

    :cond_47
    move v2, v4

    goto/16 :goto_e

    :cond_48
    move v2, v12

    move/from16 v3, v17

    goto/16 :goto_6
.end method

.method private final a(Ljava/lang/String;Lcom/google/android/gms/internal/zzcha;)Z
    .locals 13

    const/4 v12, 0x0

    const/4 v9, 0x1

    const-wide v6, 0x412e848000000000L    # 1000000.0

    const/4 v8, 0x0

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    const-string v1, "currency"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgx;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v0, "ecommerce_purchase"

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    const-string v1, "value"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgx;->c(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    mul-double/2addr v0, v6

    const-wide/16 v4, 0x0

    cmpl-double v3, v0, v4

    if-nez v3, :cond_0

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    const-string v1, "value"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgx;->b(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    long-to-double v0, v0

    mul-double/2addr v0, v6

    :cond_0
    const-wide/high16 v4, 0x43e0000000000000L    # 9.223372036854776E18

    cmpg-double v3, v0, v4

    if-gtz v3, :cond_3

    const-wide/high16 v4, -0x3c20000000000000L    # -9.223372036854776E18

    cmpl-double v3, v0, v4

    if-ltz v3, :cond_3

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    move-wide v6, v0

    :goto_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "[A-Z]{3}"

    invoke-virtual {v0, v1}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "_ltv_"

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_5

    invoke-virtual {v1, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0, p1, v3}, Lcom/google/android/gms/internal/zzcgo;->c(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzclp;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    instance-of v1, v1, Ljava/lang/Long;

    if-nez v1, :cond_6

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->G:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v0, p1, v2}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;Lcom/google/android/gms/internal/zzchd;)I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    :try_start_0
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v4, "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like \'_ltv_%\' order by set_timestamp desc limit ?,10);"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v10, 0x0

    aput-object p1, v5, v10

    const/4 v10, 0x1

    aput-object p1, v5, v10

    const/4 v10, 0x2

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v10

    invoke-virtual {v2, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_2
    new-instance v0, Lcom/google/android/gms/internal/zzclp;

    iget-object v2, p2, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzclp;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V

    :goto_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzclp;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Too many unique user properties are set. Ignoring user property. appId"

    invoke-static {p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v4

    iget-object v5, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    const/16 v2, 0x9

    move-object v1, p1

    move-object v3, v12

    move-object v4, v12

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V

    :cond_2
    move v0, v9

    :goto_4
    return v0

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Data lost. Currency value is too big. appId"

    invoke-static {p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {v2, v3, v4, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    move v0, v8

    goto :goto_4

    :cond_4
    iget-object v0, p2, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    const-string v1, "value"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgx;->b(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    move-wide v6, v0

    goto/16 :goto_0

    :cond_5
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto/16 :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Error pruning currencies. appId"

    invoke-static {p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v1, v2, v4, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_2

    :cond_6
    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    new-instance v0, Lcom/google/android/gms/internal/zzclp;

    iget-object v2, p2, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    add-long/2addr v6, v10

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzclp;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V

    goto/16 :goto_3
.end method

.method private final a(Ljava/lang/String;[Lcom/google/android/gms/internal/zzcmg;[Lcom/google/android/gms/internal/zzcmb;)[Lcom/google/android/gms/internal/zzcma;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->z()Lcom/google/android/gms/internal/zzcgk;

    move-result-object v0

    invoke-virtual {v0, p1, p3, p2}, Lcom/google/android/gms/internal/zzcgk;->a(Ljava/lang/String;[Lcom/google/android/gms/internal/zzcmb;[Lcom/google/android/gms/internal/zzcmg;)[Lcom/google/android/gms/internal/zzcma;

    move-result-object v0

    return-object v0
.end method

.method private final b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgi;
    .locals 24

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "No app data available; dropping"

    move-object/from16 v0, p1

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    const/4 v3, 0x0

    :goto_0
    return-object v3

    :cond_1
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v3

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v3, v0, v4}, Lcom/google/android/gms/internal/zzbhe;->b(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "App version does not match; dropping. appId"

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v3, 0x0

    goto :goto_0

    :catch_0
    move-exception v3

    :cond_2
    new-instance v3, Lcom/google/android/gms/internal/zzcgi;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->j()J

    move-result-wide v7

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->k()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->l()J

    move-result-wide v10

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->m()J

    move-result-wide v12

    const/4 v14, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->n()Z

    move-result v15

    const/16 v16, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->f()Ljava/lang/String;

    move-result-object v17

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->A()J

    move-result-wide v18

    const-wide/16 v20, 0x0

    const/16 v22, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->B()Z

    move-result v23

    move-object/from16 v4, p1

    invoke-direct/range {v3 .. v23}, Lcom/google/android/gms/internal/zzcgi;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;ZZLjava/lang/String;JJIZ)V

    goto :goto_0
.end method

.method private final b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 30

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p2

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v28

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    invoke-static/range {p1 .. p2}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    move-object/from16 v0, p2

    iget-boolean v2, v0, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v2, :cond_2

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcig;->b(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v4, "Dropping blacklisted event. appId"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v6

    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v4, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzclq;->l(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzclq;->m(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    :cond_3
    const/4 v2, 0x1

    move v8, v2

    :goto_1
    if-nez v8, :cond_4

    const-string v2, "_err"

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const/16 v4, 0xb

    const-string v5, "_ev"

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V

    :cond_4
    if-eqz v8, :cond_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgh;->q()J

    move-result-wide v4

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgh;->p()J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v6

    sub-long v4, v6, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(J)J

    move-result-wide v4

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->B:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v2, v4, v6

    if-lez v2, :cond_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v4, "Fetching config for blacklisted app"

    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcgh;)V

    goto/16 :goto_0

    :cond_5
    const/4 v2, 0x0

    move v8, v2

    goto :goto_1

    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    const/4 v4, 0x2

    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/zzchm;->a(I)Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v4, "Logging event"

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/zzchk;->a(Lcom/google/android/gms/internal/zzcha;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    const-string v2, "_iap"

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_8

    const-string v2, "ecommerce_purchase"

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    :cond_8
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v3, v1}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;Lcom/google/android/gms/internal/zzcha;)Z

    move-result v2

    if-nez v2, :cond_9

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_9
    :try_start_1
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;)Z

    move-result v10

    const-string v2, "_err"

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->L()J

    move-result-wide v6

    const/4 v9, 0x1

    const/4 v11, 0x0

    const/4 v13, 0x0

    move-object v8, v3

    invoke-virtual/range {v5 .. v13}, Lcom/google/android/gms/internal/zzcgo;->a(JLjava/lang/String;ZZZZZ)Lcom/google/android/gms/internal/zzcgp;

    move-result-object v4

    iget-wide v6, v4, Lcom/google/android/gms/internal/zzcgp;->b:J

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->m:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    int-to-long v8, v2

    sub-long/2addr v6, v8

    const-wide/16 v8, 0x0

    cmp-long v2, v6, v8

    if-lez v2, :cond_b

    const-wide/16 v8, 0x3e8

    rem-long/2addr v6, v8

    const-wide/16 v8, 0x1

    cmp-long v2, v6, v8

    if-nez v2, :cond_a

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v5, "Data loss. Too many events logged. appId, count"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    iget-wide v6, v4, Lcom/google/android/gms/internal/zzcgp;->b:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v5, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_b
    if-eqz v10, :cond_d

    :try_start_2
    iget-wide v6, v4, Lcom/google/android/gms/internal/zzcgp;->a:J

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->o:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    int-to-long v8, v2

    sub-long/2addr v6, v8

    const-wide/16 v8, 0x0

    cmp-long v2, v6, v8

    if-lez v2, :cond_d

    const-wide/16 v8, 0x3e8

    rem-long/2addr v6, v8

    const-wide/16 v8, 0x1

    cmp-long v2, v6, v8

    if-nez v2, :cond_c

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v5, "Data loss. Too many public events logged. appId, count"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    iget-wide v8, v4, Lcom/google/android/gms/internal/zzcgp;->a:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v5, v6, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_c
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const/16 v4, 0x10

    const-string v5, "_ev"

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_d
    if-eqz v12, :cond_f

    :try_start_3
    iget-wide v6, v4, Lcom/google/android/gms/internal/zzcgp;->d:J

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    move-object/from16 v0, p2

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    sget-object v8, Lcom/google/android/gms/internal/zzchc;->n:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2, v5, v8}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;Lcom/google/android/gms/internal/zzchd;)I

    move-result v2

    const v5, 0xf4240

    invoke-static {v5, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    const/4 v5, 0x0

    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    int-to-long v8, v2

    sub-long/2addr v6, v8

    const-wide/16 v8, 0x0

    cmp-long v2, v6, v8

    if-lez v2, :cond_f

    const-wide/16 v8, 0x1

    cmp-long v2, v6, v8

    if-nez v2, :cond_e

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v5, "Too many error events logged. appId, count"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    iget-wide v6, v4, Lcom/google/android/gms/internal/zzcgp;->d:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v5, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_e
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_f
    :try_start_4
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgx;->b()Landroid/os/Bundle;

    move-result-object v20

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const-string v4, "_o"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    move-object/from16 v0, v20

    invoke-virtual {v2, v0, v4, v5}, Lcom/google/android/gms/internal/zzclq;->a(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzclq;->j(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_10

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const-string v4, "_dbg"

    const-wide/16 v6, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v20

    invoke-virtual {v2, v0, v4, v5}, Lcom/google/android/gms/internal/zzclq;->a(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const-string v4, "_r"

    const-wide/16 v6, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v20

    invoke-virtual {v2, v0, v4, v5}, Lcom/google/android/gms/internal/zzclq;->a(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    :cond_10
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->c(Ljava/lang/String;)J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v2, v4, v6

    if-lez v2, :cond_11

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v6, "Data lost. Too many events stored on disk, deleted. appId"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v6, v7, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_11
    new-instance v11, Lcom/google/android/gms/internal/zzcgv;

    move-object/from16 v0, p1

    iget-object v13, v0, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v15, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-wide v0, v0, Lcom/google/android/gms/internal/zzcha;->d:J

    move-wide/from16 v16, v0

    const-wide/16 v18, 0x0

    move-object/from16 v12, p0

    move-object v14, v3

    invoke-direct/range {v11 .. v20}, Lcom/google/android/gms/internal/zzcgv;-><init>(Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLandroid/os/Bundle;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    iget-object v4, v11, Lcom/google/android/gms/internal/zzcgv;->b:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v2

    if-nez v2, :cond_16

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->f(Ljava/lang/String;)J

    move-result-wide v4

    const-wide/16 v6, 0x1f4

    cmp-long v2, v4, v6

    if-ltz v2, :cond_12

    if-eqz v10, :cond_12

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v4, "Too many event names used, ignoring event. appId, name, supported count"

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v6

    iget-object v7, v11, Lcom/google/android/gms/internal/zzcgv;->b:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x1f4

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    const/16 v4, 0x8

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_12
    :try_start_5
    new-instance v13, Lcom/google/android/gms/internal/zzcgw;

    iget-object v15, v11, Lcom/google/android/gms/internal/zzcgv;->b:Ljava/lang/String;

    const-wide/16 v16, 0x0

    const-wide/16 v18, 0x0

    iget-wide v0, v11, Lcom/google/android/gms/internal/zzcgv;->c:J

    move-wide/from16 v20, v0

    const-wide/16 v22, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    move-object v14, v3

    invoke-direct/range {v13 .. v26}, Lcom/google/android/gms/internal/zzcgw;-><init>(Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V

    move-object v12, v11

    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v13}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgw;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-static {v12}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, v12, Lcom/google/android/gms/internal/zzcgv;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    iget-object v2, v12, Lcom/google/android/gms/internal/zzcgv;->a:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->b(Z)V

    new-instance v4, Lcom/google/android/gms/internal/zzcme;

    invoke-direct {v4}, Lcom/google/android/gms/internal/zzcme;-><init>()V

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->a:Ljava/lang/Integer;

    const-string v2, "android"

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->i:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcgi;->d:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->n:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->p:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->j:J

    const-wide/32 v6, -0x80000000

    cmp-long v2, v2, v6

    if-nez v2, :cond_17

    const/4 v2, 0x0

    :goto_3
    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->C:Ljava/lang/Integer;

    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->e:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->q:Ljava/lang/Long;

    move-object/from16 v0, p2

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->y:Ljava/lang/String;

    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->f:J

    const-wide/16 v6, 0x0

    cmp-long v2, v2, v6

    if-nez v2, :cond_18

    const/4 v2, 0x0

    :goto_4
    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->v:Ljava/lang/Long;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchx;->a(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v3

    if-eqz v3, :cond_19

    iget-object v2, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/CharSequence;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_19

    move-object/from16 v0, p2

    iget-boolean v2, v0, Lcom/google/android/gms/internal/zzcgi;->o:Z

    if-eqz v2, :cond_13

    iget-object v2, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    iget-object v2, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Boolean;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->t:Ljava/lang/Boolean;

    :cond_13
    :goto_5
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->k:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->j:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgu;->x()J

    move-result-wide v2

    long-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->m:Ljava/lang/Integer;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgu;->y()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->l:Ljava/lang/String;

    const/4 v2, 0x0

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->r:Ljava/lang/Long;

    const/4 v2, 0x0

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->d:Ljava/lang/Long;

    const/4 v2, 0x0

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    const/4 v2, 0x0

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->l:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->F:Ljava/lang/Long;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->B()Z

    move-result v2

    if-eqz v2, :cond_14

    invoke-static {}, Lcom/google/android/gms/internal/zzcgn;->B()Z

    move-result v2

    if-eqz v2, :cond_14

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    const/4 v2, 0x0

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->G:Ljava/lang/String;

    :cond_14
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v2

    if-nez v2, :cond_15

    new-instance v2, Lcom/google/android/gms/internal/zzcgh;

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-direct {v2, v0, v3}, Lcom/google/android/gms/internal/zzcgh;-><init>(Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchh;->y()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->a(Ljava/lang/String;)V

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->k:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->d(Ljava/lang/String;)V

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->b(Ljava/lang/String;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v3

    move-object/from16 v0, p2

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v3, v5}, Lcom/google/android/gms/internal/zzchx;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->c(Ljava/lang/String;)V

    const-wide/16 v6, 0x0

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->f(J)V

    const-wide/16 v6, 0x0

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->a(J)V

    const-wide/16 v6, 0x0

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->b(J)V

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->e(Ljava/lang/String;)V

    move-object/from16 v0, p2

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcgi;->j:J

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->c(J)V

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->d:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->f(Ljava/lang/String;)V

    move-object/from16 v0, p2

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcgi;->e:J

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->d(J)V

    move-object/from16 v0, p2

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcgi;->f:J

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->e(J)V

    move-object/from16 v0, p2

    iget-boolean v3, v0, Lcom/google/android/gms/internal/zzcgi;->h:Z

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->a(Z)V

    move-object/from16 v0, p2

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcgi;->l:J

    invoke-virtual {v2, v6, v7}, Lcom/google/android/gms/internal/zzcgh;->o(J)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    :cond_15
    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->c()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/google/android/gms/internal/zzcme;->u:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->f()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->B:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, p2

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/google/android/gms/internal/zzcmg;

    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    const/4 v2, 0x0

    move v3, v2

    :goto_6
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v2

    if-ge v3, v2, :cond_1c

    new-instance v6, Lcom/google/android/gms/internal/zzcmg;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzcmg;-><init>()V

    iget-object v2, v4, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    aput-object v6, v2, v3

    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzclp;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    iput-object v2, v6, Lcom/google/android/gms/internal/zzcmg;->b:Ljava/lang/String;

    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzclp;

    iget-wide v8, v2, Lcom/google/android/gms/internal/zzclp;->d:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v6, Lcom/google/android/gms/internal/zzcmg;->a:Ljava/lang/Long;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v7

    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzclp;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v7, v6, v2}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmg;Ljava/lang/Object;)V

    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_6

    :cond_16
    iget-wide v4, v2, Lcom/google/android/gms/internal/zzcgw;->e:J

    move-object/from16 v0, p0

    invoke-virtual {v11, v0, v4, v5}, Lcom/google/android/gms/internal/zzcgv;->a(Lcom/google/android/gms/internal/zzcim;J)Lcom/google/android/gms/internal/zzcgv;

    move-result-object v11

    iget-wide v4, v11, Lcom/google/android/gms/internal/zzcgv;->c:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgw;->a(J)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v13

    move-object v12, v11

    goto/16 :goto_2

    :cond_17
    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->j:J

    long-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto/16 :goto_3

    :cond_18
    move-object/from16 v0, p2

    iget-wide v2, v0, Lcom/google/android/gms/internal/zzcgi;->f:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    goto/16 :goto_4

    :cond_19
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgu;->a(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_13

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string v3, "android_id"

    invoke-static {v2, v3}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1b

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "null secure ID. appId"

    iget-object v5, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v5}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v2, v3, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    const-string v2, "null"

    :cond_1a
    :goto_7
    iput-object v2, v4, Lcom/google/android/gms/internal/zzcme;->D:Ljava/lang/String;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_5

    :catchall_0
    move-exception v2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v2

    :cond_1b
    :try_start_6
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1a

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v5, "empty secure ID. appId"

    iget-object v6, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v6}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_7

    :cond_1c
    :try_start_7
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcme;)J
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-result-wide v14

    :try_start_8
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v13

    iget-object v2, v12, Lcom/google/android/gms/internal/zzcgv;->e:Lcom/google/android/gms/internal/zzcgx;

    if-eqz v2, :cond_21

    iget-object v2, v12, Lcom/google/android/gms/internal/zzcgv;->e:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgx;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1d
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v4, "_r"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1d

    const/4 v2, 0x1

    :goto_8
    invoke-virtual {v13, v12, v14, v15, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgv;JZ)Z

    move-result v2

    if-eqz v2, :cond_1e

    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/google/android/gms/internal/zzcim;->K:J

    :cond_1e
    :goto_9
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchm;->a(I)Z

    move-result v2

    if-eqz v2, :cond_1f

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Event recorded"

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v4

    invoke-virtual {v4, v12}, Lcom/google/android/gms/internal/zzchk;->a(Lcom/google/android/gms/internal/zzcgv;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    :cond_1f
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Background event processing time, ms"

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    sub-long v4, v4, v28

    const-wide/32 v6, 0x7a120

    add-long/2addr v4, v6

    const-wide/32 v6, 0xf4240

    div-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_0

    :catch_0
    move-exception v2

    :try_start_9
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v5, "Data loss. Failed to insert raw event metadata. appId"

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v5, v4, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_9

    :cond_20
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    iget-object v3, v12, Lcom/google/android/gms/internal/zzcgv;->a:Ljava/lang/String;

    iget-object v4, v12, Lcom/google/android/gms/internal/zzcgv;->b:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcig;->c(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-direct/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->L()J

    move-result-wide v4

    iget-object v6, v12, Lcom/google/android/gms/internal/zzcgv;->a:Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v3 .. v11}, Lcom/google/android/gms/internal/zzcgo;->a(JLjava/lang/String;ZZZZZ)Lcom/google/android/gms/internal/zzcgp;

    move-result-object v3

    if-eqz v2, :cond_21

    iget-wide v2, v3, Lcom/google/android/gms/internal/zzcgp;->e:J

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    iget-object v5, v12, Lcom/google/android/gms/internal/zzcgv;->a:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzcgn;->a(Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-gez v2, :cond_21

    const/4 v2, 0x1

    goto/16 :goto_8

    :cond_21
    const/4 v2, 0x0

    goto/16 :goto_8
.end method

.method private static b(Lcom/google/android/gms/internal/zzcjl;)V
    .locals 2

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Component not created"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcjl;->P()Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Component not initialized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    return-void
.end method

.method private final d(Lcom/google/android/gms/internal/zzcgi;)V
    .locals 8

    const/4 v1, 0x1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/zzchx;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x0

    if-nez v2, :cond_c

    new-instance v0, Lcom/google/android/gms/internal/zzcgh;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-direct {v0, p0, v2}, Lcom/google/android/gms/internal/zzcgh;-><init>(Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchh;->y()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzcgh;->a(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/zzcgh;->c(Ljava/lang/String;)V

    move-object v2, v0

    move v0, v1

    :cond_0
    :goto_0
    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->b(Ljava/lang/String;)V

    move v0, v1

    :cond_1
    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->k:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->k:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->f()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->k:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->d(Ljava/lang/String;)V

    move v0, v1

    :cond_2
    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->e:J

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-eqz v3, :cond_3

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->e:J

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->l()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-eqz v3, :cond_3

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->e:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->d(J)V

    move v0, v1

    :cond_3
    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->e(Ljava/lang/String;)V

    move v0, v1

    :cond_4
    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->j:J

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->j()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-eqz v3, :cond_5

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->j:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->c(J)V

    move v0, v1

    :cond_5
    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->d:Ljava/lang/String;

    if-eqz v3, :cond_6

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->d:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->k()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->d:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->f(Ljava/lang/String;)V

    move v0, v1

    :cond_6
    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->f:J

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->m()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-eqz v3, :cond_7

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->f:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->e(J)V

    move v0, v1

    :cond_7
    iget-boolean v3, p1, Lcom/google/android/gms/internal/zzcgi;->h:Z

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->n()Z

    move-result v4

    if-eq v3, v4, :cond_8

    iget-boolean v0, p1, Lcom/google/android/gms/internal/zzcgi;->h:Z

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->a(Z)V

    move v0, v1

    :cond_8
    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->g:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_9

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->g:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->y()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->g:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->g(Ljava/lang/String;)V

    move v0, v1

    :cond_9
    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->l:J

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->A()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-eqz v3, :cond_a

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->l:J

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->o(J)V

    move v0, v1

    :cond_a
    iget-boolean v3, p1, Lcom/google/android/gms/internal/zzcgi;->o:Z

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->B()Z

    move-result v4

    if-eq v3, v4, :cond_d

    iget-boolean v0, p1, Lcom/google/android/gms/internal/zzcgi;->o:Z

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->b(Z)V

    :goto_1
    if-eqz v1, :cond_b

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    :cond_b
    return-void

    :cond_c
    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->e()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcgh;->c(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchh;->y()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgh;->a(Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_d
    move v1, v0

    goto :goto_1
.end method


# virtual methods
.method public final A()Lcom/google/android/gms/internal/zzcgd;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->y:Lcom/google/android/gms/internal/zzcgd;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcjk;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->y:Lcom/google/android/gms/internal/zzcgd;

    return-object v0
.end method

.method public final B()Z
    .locals 3

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgn;->x()Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    const-string v2, "firebase_analytics_collection_enabled"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :cond_1
    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzchx;->c(Z)Z

    move-result v0

    goto :goto_0

    :cond_2
    invoke-static {}, Lcom/google/android/gms/common/api/internal/zzbz;->b()Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v0, 0x1

    goto :goto_1
.end method

.method final C()J
    .locals 6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->h:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    goto :goto_0
.end method

.method public final E()V
    .locals 14

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->w()Lcom/google/android/gms/internal/zzckg;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzckg;->D()Ljava/lang/Boolean;

    move-result-object v2

    if-nez v2, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Upload data called on the client side before use of service was decided"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    :goto_0
    return-void

    :cond_0
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Upload called in the client side when service should be used"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_0

    :cond_1
    :try_start_2
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->K:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_2

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_0

    :cond_2
    :try_start_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->F:Ljava/util/List;

    if-eqz v2, :cond_3

    const/4 v2, 0x1

    :goto_1
    if-eqz v2, :cond_4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Uploading requested multiple times"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_0

    :cond_3
    const/4 v2, 0x0

    goto :goto_1

    :cond_4
    :try_start_4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchq;->y()Z

    move-result v2

    if-nez v2, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Network not connected, ignoring upload request"

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_0

    :cond_5
    :try_start_5
    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v10

    invoke-static {}, Lcom/google/android/gms/internal/zzcgn;->z()J

    move-result-wide v2

    sub-long v2, v10, v2

    const/4 v4, 0x0

    invoke-direct {p0, v4, v2, v3}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;J)Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Uploading events. Elapsed time since last upload attempt (ms)"

    sub-long v2, v10, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v4, v5, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->B()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_11

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->J:J

    const-wide/16 v6, -0x1

    cmp-long v2, v2, v6

    if-nez v2, :cond_7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->I()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->J:J

    :cond_7
    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    sget-object v3, Lcom/google/android/gms/internal/zzchc;->i:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2, v4, v3}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;Lcom/google/android/gms/internal/zzchd;)I

    move-result v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    const/4 v5, 0x0

    sget-object v6, Lcom/google/android/gms/internal/zzchc;->j:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v3, v4, v6}, Lcom/google/android/gms/internal/zzcgn;->b(Ljava/lang/String;Lcom/google/android/gms/internal/zzchd;)I

    move-result v3

    invoke-static {v5, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    invoke-virtual {v5, v4, v2, v3}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;II)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_e

    const/4 v5, 0x0

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_8
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_14

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    iget-object v2, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Lcom/google/android/gms/internal/zzcme;

    iget-object v7, v2, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_8

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    move-object v6, v2

    :goto_2
    if-eqz v6, :cond_13

    const/4 v2, 0x0

    move v5, v2

    :goto_3
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    if-ge v5, v2, :cond_13

    invoke-interface {v3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    iget-object v2, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Lcom/google/android/gms/internal/zzcme;

    iget-object v7, v2, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_a

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_a

    const/4 v2, 0x0

    invoke-interface {v3, v2, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v2

    move-object v6, v2

    :goto_4
    new-instance v7, Lcom/google/android/gms/internal/zzcmd;

    invoke-direct {v7}, Lcom/google/android/gms/internal/zzcmd;-><init>()V

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/google/android/gms/internal/zzcme;

    iput-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    new-instance v8, Ljava/util/ArrayList;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v2

    invoke-direct {v8, v2}, Ljava/util/ArrayList;-><init>(I)V

    invoke-static {}, Lcom/google/android/gms/internal/zzcgn;->B()Z

    move-result v2

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/zzcgn;->c(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    const/4 v2, 0x1

    move v3, v2

    :goto_5
    const/4 v2, 0x0

    move v5, v2

    :goto_6
    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    array-length v2, v2

    if-ge v5, v2, :cond_c

    iget-object v9, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    iget-object v2, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Lcom/google/android/gms/internal/zzcme;

    aput-object v2, v9, v5

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    iget-object v2, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Long;

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    aget-object v2, v2, v5

    const-wide/16 v12, 0x2e86

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    iput-object v9, v2, Lcom/google/android/gms/internal/zzcme;->r:Ljava/lang/Long;

    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    aget-object v2, v2, v5

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    iput-object v9, v2, Lcom/google/android/gms/internal/zzcme;->d:Ljava/lang/Long;

    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    aget-object v2, v2, v5

    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    iput-object v9, v2, Lcom/google/android/gms/internal/zzcme;->z:Ljava/lang/Boolean;

    if-nez v3, :cond_9

    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    aget-object v2, v2, v5

    const/4 v9, 0x0

    iput-object v9, v2, Lcom/google/android/gms/internal/zzcme;->G:Ljava/lang/String;

    :cond_9
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto :goto_6

    :cond_a
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto/16 :goto_3

    :cond_b
    const/4 v2, 0x0

    move v3, v2

    goto :goto_5

    :cond_c
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    const/4 v5, 0x2

    invoke-virtual {v3, v5}, Lcom/google/android/gms/internal/zzchm;->a(I)Z

    move-result v3

    if-eqz v3, :cond_12

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v2

    invoke-virtual {v2, v7}, Lcom/google/android/gms/internal/zzchk;->a(Lcom/google/android/gms/internal/zzcmd;)Ljava/lang/String;

    move-result-object v2

    move-object v3, v2

    :goto_7
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v2

    invoke-virtual {v2, v7}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmd;)[B

    move-result-object v6

    sget-object v2, Lcom/google/android/gms/internal/zzchc;->s:Lcom/google/android/gms/internal/zzchd;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchd;->b()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljava/lang/String;

    move-object v9, v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, v9}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-interface {v8}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_f

    const/4 v2, 0x1

    :goto_8
    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->b(Z)V

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->F:Ljava/util/List;

    if-eqz v2, :cond_10

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v8, "Set uploading progress before finishing the previous upload"

    invoke-virtual {v2, v8}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :goto_9
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->d:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v2, v10, v11}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    const-string v2, "?"

    iget-object v8, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    array-length v8, v8

    if-lez v8, :cond_d

    iget-object v2, v7, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    const/4 v7, 0x0

    aget-object v2, v2, v7

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    :cond_d
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v7

    const-string v8, "Uploading data. app, uncompressed size, data"

    array-length v10, v6

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v7, v8, v2, v10, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->M:Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v3

    new-instance v8, Lcom/google/android/gms/internal/zzcip;

    invoke-direct {v8, p0}, Lcom/google/android/gms/internal/zzcip;-><init>(Lcom/google/android/gms/internal/zzcim;)V

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-static {v5}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {v6}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {v8}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcjk;->s()Lcom/google/android/gms/internal/zzcih;

    move-result-object v10

    new-instance v2, Lcom/google/android/gms/internal/zzchu;

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v8}, Lcom/google/android/gms/internal/zzchu;-><init>(Lcom/google/android/gms/internal/zzchq;Ljava/lang/String;Ljava/net/URL;[BLjava/util/Map;Lcom/google/android/gms/internal/zzchs;)V

    invoke-virtual {v10, v2}, Lcom/google/android/gms/internal/zzcih;->b(Ljava/lang/Runnable;)V
    :try_end_6
    .catch Ljava/net/MalformedURLException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :cond_e
    :goto_a
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto/16 :goto_0

    :cond_f
    const/4 v2, 0x0

    goto :goto_8

    :cond_10
    :try_start_7
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v8}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, p0, Lcom/google/android/gms/internal/zzcim;->F:Ljava/util/List;
    :try_end_7
    .catch Ljava/net/MalformedURLException; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_9

    :catch_0
    move-exception v2

    :try_start_8
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Failed to parse upload URL. Not uploading. appId"

    invoke-static {v4}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v9}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_a

    :catchall_0
    move-exception v2

    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/google/android/gms/internal/zzcim;->N:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    throw v2

    :cond_11
    const-wide/16 v2, -0x1

    :try_start_9
    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->J:J

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-static {}, Lcom/google/android/gms/internal/zzcgn;->z()J

    move-result-wide v4

    sub-long v4, v10, v4

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcgo;->a(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_e

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v2

    if-eqz v2, :cond_e

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcgh;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto :goto_a

    :cond_12
    move-object v3, v2

    goto/16 :goto_7

    :cond_13
    move-object v6, v3

    goto/16 :goto_4

    :cond_14
    move-object v6, v5

    goto/16 :goto_2
.end method

.method final F()V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzcim;->I:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzcim;->I:I

    return-void
.end method

.method final G()V
    .locals 4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->A:Z

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "This instance being marked as an uploader"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->O()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->K()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->E:Ljava/nio/channels/FileChannel;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/nio/channels/FileChannel;)I

    move-result v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchh;->B()I

    move-result v1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    if-le v0, v1, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Panic: can\'t downgrade version. Previous, current version"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v2, v3, v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_0
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->A:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    :cond_1
    return-void

    :cond_2
    if-ge v0, v1, :cond_0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->E:Ljava/nio/channels/FileChannel;

    invoke-direct {p0, v1, v2}, Lcom/google/android/gms/internal/zzcim;->a(ILjava/nio/channels/FileChannel;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Storage version upgraded. Previous, current version"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v2, v3, v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Storage version upgrade failed. Previous, current version"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v2, v3, v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzcio;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/internal/zzcio;-><init>(Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcih;->a(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    const-wide/16 v2, 0x7530

    :try_start_0
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v2, v3, v1}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Failed to get app instance id. appId"

    invoke-static {p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v0, 0x0

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_1
.end method

.method final a()V
    .locals 2

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcim;->z:Z

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "AppMeasurement is not initialized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method protected final a(ILjava/lang/Throwable;[B)V
    .locals 9

    const/4 v2, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    if-nez p3, :cond_0

    const/4 v0, 0x0

    :try_start_0
    new-array p3, v0, [B

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->F:Ljava/util/List;

    const/4 v3, 0x0

    iput-object v3, p0, Lcom/google/android/gms/internal/zzcim;->F:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    const/16 v3, 0xc8

    if-eq p1, v3, :cond_1

    const/16 v3, 0xcc

    if-ne p1, v3, :cond_5

    :cond_1
    if-nez p2, :cond_5

    :try_start_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v3

    iget-object v3, v3, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    iget-object v4, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v4}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v3

    iget-object v3, v3, Lcom/google/android/gms/internal/zzchx;->d:Lcom/google/android/gms/internal/zzcia;

    const-wide/16 v4, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Successful upload. Got network response. code, size"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    array-length v6, p3

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v4, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->x()V
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    const-string v6, "queue"

    const-string v7, "rowid=?"

    invoke-virtual {v0, v6, v7, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    if-eq v0, v2, :cond_2

    new-instance v0, Landroid/database/sqlite/SQLiteException;

    const-string v2, "Deleted fewer rows from queue than expected"

    invoke-direct {v0, v2}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :catch_0
    move-exception v0

    :try_start_4
    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Failed to delete a bundle in a queue table"

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :catchall_0
    move-exception v0

    :try_start_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0
    :try_end_5
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :catch_1
    move-exception v0

    :try_start_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Database error while trying to delete uploaded bundles"

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->K:J

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "Disable upload, time"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzcim;->K:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :goto_0
    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->M:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    return-void

    :cond_3
    :try_start_7
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :try_start_8
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchq;->y()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->M()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->E()V

    :goto_1
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->K:J
    :try_end_8
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_8 .. :try_end_8} :catch_1
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v0

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->M:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    throw v0

    :cond_4
    const-wide/16 v2, -0x1

    :try_start_9
    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->J:J

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V
    :try_end_9
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    goto :goto_1

    :cond_5
    :try_start_a
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v3, "Network upload failed. Will retry later. code, error"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4, p2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->d:Lcom/google/android/gms/internal/zzcia;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v3}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    const/16 v0, 0x1f7

    if-eq p1, v0, :cond_6

    const/16 v0, 0x1ad

    if-ne p1, v0, :cond_8

    :cond_6
    move v0, v2

    :goto_2
    if-eqz v0, :cond_7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->e:Lcom/google/android/gms/internal/zzcia;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_7
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    goto :goto_0

    :cond_8
    move v0, v1

    goto :goto_2
.end method

.method final a(Lcom/google/android/gms/internal/zzcgi;)V
    .locals 7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    :try_start_0
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    const-string v4, "apps"

    const-string v5, "app_id=?"

    invoke-virtual {v0, v4, v5, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    add-int/lit8 v4, v4, 0x0

    const-string v5, "events"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "user_attributes"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "conditional_properties"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "raw_events"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "raw_events_metadata"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "queue"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v4, v5

    const-string v5, "audience_filter_values"

    const-string v6, "app_id=?"

    invoke-virtual {v0, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    add-int/2addr v0, v4

    if-lez v0, :cond_0

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Reset analytics data. app, records"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    iget-boolean v4, p1, Lcom/google/android/gms/internal/zzcgi;->h:Z

    iget-boolean v5, p1, Lcom/google/android/gms/internal/zzcgi;->o:Z

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcim;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/google/android/gms/internal/zzcgi;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzcim;->c(Lcom/google/android/gms/internal/zzcgi;)V

    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v3, "Error resetting analytics data. appId, error"

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v3, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method final a(Lcom/google/android/gms/internal/zzcgl;)V
    .locals 1

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzcim;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgi;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcgl;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_0
    return-void
.end method

.method final a(Lcom/google/android/gms/internal/zzcgl;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 9

    const/4 v7, 0x1

    const/4 v6, 0x0

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-boolean v0, p2, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v0, :cond_1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_1
    new-instance v8, Lcom/google/android/gms/internal/zzcgl;

    invoke-direct {v8, p1}, Lcom/google/android/gms/internal/zzcgl;-><init>(Lcom/google/android/gms/internal/zzcgl;)V

    iput-boolean v6, v8, Lcom/google/android/gms/internal/zzcgl;->e:Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v2, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->d(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgl;

    move-result-object v5

    if-eqz v5, :cond_2

    iget-object v0, v5, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Updating a conditional user property with different origin. name, origin, origin (from DB)"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v2

    iget-object v3, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, v8, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-object v4, v5, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2
    if-eqz v5, :cond_4

    iget-boolean v0, v5, Lcom/google/android/gms/internal/zzcgl;->e:Z

    if-eqz v0, :cond_4

    iget-object v0, v5, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iput-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-wide v0, v5, Lcom/google/android/gms/internal/zzcgl;->d:J

    iput-wide v0, v8, Lcom/google/android/gms/internal/zzcgl;->d:J

    iget-wide v0, v5, Lcom/google/android/gms/internal/zzcgl;->h:J

    iput-wide v0, v8, Lcom/google/android/gms/internal/zzcgl;->h:J

    iget-object v0, v5, Lcom/google/android/gms/internal/zzcgl;->f:Ljava/lang/String;

    iput-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->f:Ljava/lang/String;

    iget-object v0, v5, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    iput-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    iget-boolean v0, v5, Lcom/google/android/gms/internal/zzcgl;->e:Z

    iput-boolean v0, v8, Lcom/google/android/gms/internal/zzcgl;->e:Z

    new-instance v0, Lcom/google/android/gms/internal/zzcln;

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    iget-object v2, v5, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-wide v2, v2, Lcom/google/android/gms/internal/zzcln;->b:J

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcln;->c:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcln;-><init>(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V

    iput-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    move v7, v6

    :goto_1
    iget-boolean v0, v8, Lcom/google/android/gms/internal/zzcgl;->e:Z

    if-eqz v0, :cond_3

    iget-object v6, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    new-instance v0, Lcom/google/android/gms/internal/zzclp;

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v2, v8, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-object v3, v6, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    iget-wide v4, v6, Lcom/google/android/gms/internal/zzcln;->b:J

    invoke-virtual {v6}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzclp;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzclp;)Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "User property updated immediately"

    iget-object v3, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v4

    iget-object v5, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    :goto_2
    if-eqz v7, :cond_3

    iget-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    if-eqz v0, :cond_3

    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    iget-wide v2, v8, Lcom/google/android/gms/internal/zzcgl;->d:J

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzcha;-><init>(Lcom/google/android/gms/internal/zzcha;J)V

    invoke-direct {p0, v0, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgl;)Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Conditional property added"

    iget-object v2, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    :goto_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_4
    :try_start_1
    iget-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->f:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    new-instance v0, Lcom/google/android/gms/internal/zzcln;

    iget-object v1, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    iget-wide v2, v8, Lcom/google/android/gms/internal/zzcgl;->d:J

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcln;->c:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcln;-><init>(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V

    iput-object v0, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    const/4 v0, 0x1

    iput-boolean v0, v8, Lcom/google/android/gms/internal/zzcgl;->e:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0

    :cond_5
    :try_start_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "(2)Too many active user properties, ignoring"

    iget-object v3, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v4

    iget-object v5, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_2

    :cond_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Too many conditional properties, ignoring"

    iget-object v2, v8, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_3

    :cond_7
    move v7, v6

    goto/16 :goto_1
.end method

.method final a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 13

    invoke-static {p2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v5, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    iget-wide v6, p1, Lcom/google/android/gms/internal/zzcha;->d:J

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-boolean v2, p2, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v2, :cond_1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-static {v5}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    const-wide/16 v8, 0x0

    cmp-long v3, v6, v8

    if-gez v3, :cond_4

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Invalid time querying timed out conditional properties"

    invoke-static {v5}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v3, v4, v8}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcgl;

    if-eqz v2, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v8, "User property timed out"

    iget-object v9, v2, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v10

    iget-object v11, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v11, v11, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v10, v11}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    iget-object v11, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v11}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v4, v8, v9, v10, v11}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    iget-object v4, v2, Lcom/google/android/gms/internal/zzcgl;->g:Lcom/google/android/gms/internal/zzcha;

    if-eqz v4, :cond_3

    new-instance v4, Lcom/google/android/gms/internal/zzcha;

    iget-object v8, v2, Lcom/google/android/gms/internal/zzcgl;->g:Lcom/google/android/gms/internal/zzcha;

    invoke-direct {v4, v8, v6, v7}, Lcom/google/android/gms/internal/zzcha;-><init>(Lcom/google/android/gms/internal/zzcha;J)V

    invoke-direct {p0, v4, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v4, v5, v2}, Lcom/google/android/gms/internal/zzcgo;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v2

    :cond_4
    :try_start_1
    const-string v3, "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v8, 0x0

    aput-object v5, v4, v8

    const/4 v8, 0x1

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v8

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    goto :goto_1

    :cond_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-static {v5}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    const-wide/16 v8, 0x0

    cmp-long v3, v6, v8

    if-gez v3, :cond_8

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Invalid time querying expired conditional properties"

    invoke-static {v5}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v3, v4, v8}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    :goto_3
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/zzcgl;

    if-eqz v2, :cond_6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v8

    invoke-virtual {v8}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v8

    const-string v9, "User property expired"

    iget-object v10, v2, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v11

    iget-object v12, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v12, v12, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v11, v12}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    iget-object v12, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-virtual {v12}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v8

    iget-object v9, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v9, v9, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v8, v5, v9}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v8, v2, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    if-eqz v8, :cond_7

    iget-object v8, v2, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    invoke-interface {v3, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_7
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v8

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v8, v5, v2}, Lcom/google/android/gms/internal/zzcgo;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    :cond_8
    const-string v3, "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v8, 0x0

    aput-object v5, v4, v8

    const/4 v8, 0x1

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v8

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    goto :goto_3

    :cond_9
    move-object v0, v3

    check-cast v0, Ljava/util/ArrayList;

    move-object v2, v0

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v8

    const/4 v3, 0x0

    move v4, v3

    :goto_5
    if-ge v4, v8, :cond_a

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    add-int/lit8 v4, v4, 0x1

    check-cast v3, Lcom/google/android/gms/internal/zzcha;

    new-instance v9, Lcom/google/android/gms/internal/zzcha;

    invoke-direct {v9, v3, v6, v7}, Lcom/google/android/gms/internal/zzcha;-><init>(Lcom/google/android/gms/internal/zzcha;J)V

    invoke-direct {p0, v9, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_5

    :cond_a
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-static {v5}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-static {v3}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    const-wide/16 v8, 0x0

    cmp-long v4, v6, v8

    if-gez v4, :cond_d

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v8, "Invalid time querying triggered conditional properties"

    invoke-static {v5}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjk;->o()Lcom/google/android/gms/internal/zzchk;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v4, v8, v5, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    :goto_6
    new-instance v10, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    invoke-direct {v10, v3}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_b
    :goto_7
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_f

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/google/android/gms/internal/zzcgl;

    move-object v9, v0

    if-eqz v9, :cond_b

    iget-object v8, v9, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    new-instance v2, Lcom/google/android/gms/internal/zzclp;

    iget-object v3, v9, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v4, v9, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-object v5, v8, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v8}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v8

    invoke-direct/range {v2 .. v8}, Lcom/google/android/gms/internal/zzclp;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzclp;)Z

    move-result v3

    if-eqz v3, :cond_e

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "User property triggered"

    iget-object v5, v9, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v8

    iget-object v12, v2, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v8, v12}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iget-object v12, v2, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v8, v12}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    :goto_8
    iget-object v3, v9, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    if-eqz v3, :cond_c

    iget-object v3, v9, Lcom/google/android/gms/internal/zzcgl;->i:Lcom/google/android/gms/internal/zzcha;

    invoke-interface {v10, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_c
    new-instance v3, Lcom/google/android/gms/internal/zzcln;

    invoke-direct {v3, v2}, Lcom/google/android/gms/internal/zzcln;-><init>(Lcom/google/android/gms/internal/zzclp;)V

    iput-object v3, v9, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    const/4 v2, 0x1

    iput-boolean v2, v9, Lcom/google/android/gms/internal/zzcgl;->e:Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v9}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgl;)Z

    goto :goto_7

    :cond_d
    const-string v4, "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v5, v8, v9

    const/4 v5, 0x1

    aput-object v3, v8, v5

    const/4 v3, 0x2

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v8, v3

    invoke-virtual {v2, v4, v8}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_6

    :cond_e
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Too many active user properties, ignoring"

    iget-object v5, v9, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v5}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v8

    iget-object v12, v2, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v8, v12}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iget-object v12, v2, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v8, v12}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_8

    :cond_f
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    move-object v0, v10

    check-cast v0, Ljava/util/ArrayList;

    move-object v2, v0

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v5

    const/4 v3, 0x0

    move v4, v3

    :goto_9
    if-ge v4, v5, :cond_10

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    add-int/lit8 v4, v4, 0x1

    check-cast v3, Lcom/google/android/gms/internal/zzcha;

    new-instance v8, Lcom/google/android/gms/internal/zzcha;

    invoke-direct {v8, v3, v6, v7}, Lcom/google/android/gms/internal/zzcha;-><init>(Lcom/google/android/gms/internal/zzcha;J)V

    invoke-direct {p0, v8, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_9

    :cond_10
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0
.end method

.method final a(Lcom/google/android/gms/internal/zzcha;Ljava/lang/String;)V
    .locals 24

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    move-object/from16 v0, p2

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "No app data available; dropping event"

    move-object/from16 v0, p2

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :goto_0
    return-void

    :cond_1
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v3

    const/4 v4, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v3, v0, v4}, Lcom/google/android/gms/internal/zzbhe;->b(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "App version does not match; dropping event. appId"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v3

    const-string v3, "_ui"

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "Could not find package. appId"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_2
    new-instance v3, Lcom/google/android/gms/internal/zzcgi;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->j()J

    move-result-wide v7

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->k()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->l()J

    move-result-wide v10

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->m()J

    move-result-wide v12

    const/4 v14, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->n()Z

    move-result v15

    const/16 v16, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->f()Ljava/lang/String;

    move-result-object v17

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->A()J

    move-result-wide v18

    const-wide/16 v20, 0x0

    const/16 v22, 0x0

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgh;->B()Z

    move-result v23

    move-object/from16 v4, p2

    invoke-direct/range {v3 .. v23}, Lcom/google/android/gms/internal/zzcgi;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;ZZLjava/lang/String;JJIZ)V

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v3}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    goto/16 :goto_0
.end method

.method final a(Lcom/google/android/gms/internal/zzcjl;)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzcim;->H:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzcim;->H:I

    return-void
.end method

.method final a(Lcom/google/android/gms/internal/zzcln;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 7

    const/16 v4, 0x18

    const/4 v3, 0x1

    const/4 v5, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-boolean v0, p2, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v0, :cond_2

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzclq;->e(Ljava/lang/String;)I

    move-result v2

    if-eqz v2, :cond_4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-static {v0, v4, v3}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;IZ)Ljava/lang/String;

    move-result-object v4

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const-string v3, "_ev"

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    :cond_4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzclq;->b(Ljava/lang/String;Ljava/lang/Object;)I

    move-result v2

    if-eqz v2, :cond_7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-static {v0, v4, v3}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;IZ)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_6

    instance-of v1, v0, Ljava/lang/String;

    if-nez v1, :cond_5

    instance-of v1, v0, Ljava/lang/CharSequence;

    if-eqz v1, :cond_6

    :cond_5
    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    :cond_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const-string v3, "_ev"

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    :cond_7
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzcln;->a()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzclq;->c(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/zzclp;

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcln;->c:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcln;->b:J

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzclp;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Setting user property"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzclp;)Z

    move-result v1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->y()V

    if-eqz v1, :cond_8

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "User property set"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_8
    :try_start_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Too many unique user properties are set. Ignoring user property"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, v0, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v0, v0, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const/16 v2, 0x9

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0
.end method

.method final a(Ljava/lang/Runnable;)V
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->G:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method final a(Ljava/lang/String;ILjava/lang/Throwable;[BLjava/util/Map;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/Throwable;",
            "[B",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    const/16 v7, 0x130

    const/4 v0, 0x1

    const/16 v6, 0x194

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    if-nez p4, :cond_0

    const/4 v3, 0x0

    :try_start_0
    new-array p4, v3, [B

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v4, "onConfigFetched. Response size"

    array-length v5, p4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzcgo;->x()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v4

    const/16 v3, 0xc8

    if-eq p2, v3, :cond_1

    const/16 v3, 0xcc

    if-eq p2, v3, :cond_1

    if-ne p2, v7, :cond_2

    :cond_1
    if-nez p3, :cond_2

    move v3, v0

    :goto_0
    if-nez v4, :cond_3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "App does not exist in onConfigFetched. appId"

    invoke-static {p1}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    :goto_2
    return-void

    :cond_2
    move v3, v1

    goto :goto_0

    :cond_3
    if-nez v3, :cond_4

    if-ne p2, v6, :cond_c

    :cond_4
    if-eqz p5, :cond_6

    :try_start_3
    const-string v0, "Last-Modified"

    invoke-interface {p5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    :goto_3
    if-eqz v0, :cond_7

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_7

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :goto_4
    if-eq p2, v6, :cond_5

    if-ne p2, v7, :cond_8

    :cond_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcly;

    move-result-object v0

    if-nez v0, :cond_9

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, p1, v2, v3}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;[BLjava/lang/String;)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v0

    if-nez v0, :cond_9

    :try_start_4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_2

    :cond_6
    move-object v0, v2

    goto :goto_3

    :cond_7
    move-object v0, v2

    goto :goto_4

    :cond_8
    :try_start_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    invoke-virtual {v2, p1, p4, v0}, Lcom/google/android/gms/internal/zzcig;->a(Ljava/lang/String;[BLjava/lang/String;)Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result v0

    if-nez v0, :cond_9

    :try_start_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    goto :goto_2

    :cond_9
    :try_start_7
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {v4, v2, v3}, Lcom/google/android/gms/internal/zzcgh;->g(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    if-ne p2, v6, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->B()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "Config not found. Using empty config. appId"

    invoke-virtual {v0, v2, p1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :goto_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->s()Lcom/google/android/gms/internal/zzchq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchq;->y()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->M()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->E()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_1

    :catchall_0
    move-exception v0

    :try_start_8
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    :catchall_1
    move-exception v0

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzcim;->L:Z

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->P()V

    throw v0

    :cond_a
    :try_start_9
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "Successfully fetched config. Got network response. code, size"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    array-length v4, p4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v2, v3, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_5

    :cond_b
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    goto/16 :goto_1

    :cond_c
    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {v4, v2, v3}, Lcom/google/android/gms/internal/zzcgh;->h(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Fetching config failed. code, error"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4, p3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/google/android/gms/internal/zzcig;->c(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/zzchx;->d:Lcom/google/android/gms/internal/zzcia;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v3}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    const/16 v2, 0x1f7

    if-eq p2, v2, :cond_d

    const/16 v2, 0x1ad

    if-ne p2, v2, :cond_f

    :cond_d
    :goto_6
    if-eqz v0, :cond_e

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->e:Lcom/google/android/gms/internal/zzcia;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v2}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_e
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_1

    :cond_f
    move v0, v1

    goto :goto_6
.end method

.method public final a(Z)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    return-void
.end method

.method final b(Lcom/google/android/gms/internal/zzcgi;)V
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    return-void
.end method

.method final b(Lcom/google/android/gms/internal/zzcgl;)V
    .locals 1

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzcim;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgi;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcgl;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_0
    return-void
.end method

.method final b(Lcom/google/android/gms/internal/zzcgl;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 8

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-boolean v0, p2, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v0, :cond_1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->d(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgl;

    move-result-object v3

    if-eqz v3, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Removing conditional user property"

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v4

    iget-object v5, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v5, v5, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-boolean v0, v3, Lcom/google/android/gms/internal/zzcgl;->e:Z

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    if-eqz v0, :cond_4

    const/4 v2, 0x0

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    if-eqz v0, :cond_3

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgx;->b()Landroid/os/Bundle;

    move-result-object v2

    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzcgl;->b:Ljava/lang/String;

    iget-object v4, p1, Lcom/google/android/gms/internal/zzcgl;->k:Lcom/google/android/gms/internal/zzcha;

    iget-wide v4, v4, Lcom/google/android/gms/internal/zzcha;->d:J

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Lcom/google/android/gms/internal/zzclq;->a(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;JZZ)Lcom/google/android/gms/internal/zzcha;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_4
    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :cond_5
    :try_start_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Conditional user property doesn\'t exist"

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgl;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v3

    iget-object v4, p1, Lcom/google/android/gms/internal/zzcgl;->c:Lcom/google/android/gms/internal/zzcln;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0
.end method

.method final b(Lcom/google/android/gms/internal/zzcln;Lcom/google/android/gms/internal/zzcgi;)V
    .locals 4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    iget-object v0, p2, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-boolean v0, p2, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v0, :cond_1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Removing user property"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v2

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p2, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "User property removed"

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->p()Lcom/google/android/gms/internal/zzchk;

    move-result-object v2

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcln;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gms/internal/zzchk;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0
.end method

.method protected final b()Z
    .locals 6

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    if-eqz v1, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->C:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzcim;->C:J

    sub-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    cmp-long v1, v2, v4

    if-lez v1, :cond_3

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->C:J

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v1

    const-string v2, "android.permission.INTERNET"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzclq;->h(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v1

    const-string v2, "android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzclq;->h(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzbhe;->a()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzcid;->a(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/zzcla;->a(Landroid/content/Context;Z)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    const/4 v0, 0x1

    :cond_2
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzclq;->f(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->B:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public final b(Lcom/google/android/gms/internal/zzcha;Ljava/lang/String;)[B
    .locals 24

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-static {}, Lcom/google/android/gms/internal/zzcim;->D()V

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    new-instance v19, Lcom/google/android/gms/internal/zzcmd;

    invoke-direct/range {v19 .. v19}, Lcom/google/android/gms/internal/zzcmd;-><init>()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v22

    if-nez v22, :cond_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Log and bundle not available. package_name"

    move-object/from16 v0, p2

    invoke-virtual {v4, v5, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    const/4 v4, 0x0

    new-array v4, v4, [B
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzcgo;->z()V

    :goto_0
    return-object v4

    :cond_0
    :try_start_1
    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->n()Z

    move-result v4

    if-nez v4, :cond_1

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Log and bundle disabled. package_name"

    move-object/from16 v0, p2

    invoke-virtual {v4, v5, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    const/4 v4, 0x0

    new-array v4, v4, [B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto :goto_0

    :cond_1
    :try_start_2
    const-string v4, "_iap"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    const-string v4, "ecommerce_purchase"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;Lcom/google/android/gms/internal/zzcha;)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v4

    const-string v5, "Failed to handle purchase event at single event bundle creation. appId"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_3
    new-instance v23, Lcom/google/android/gms/internal/zzcme;

    invoke-direct/range {v23 .. v23}, Lcom/google/android/gms/internal/zzcme;-><init>()V

    const/4 v4, 0x1

    new-array v4, v4, [Lcom/google/android/gms/internal/zzcme;

    const/4 v5, 0x0

    aput-object v23, v4, v5

    move-object/from16 v0, v19

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcmd;->a:[Lcom/google/android/gms/internal/zzcme;

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->a:Ljava/lang/Integer;

    const-string v4, "android"

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->i:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->k()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->n:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->p:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->j()J

    move-result-wide v4

    const-wide/32 v6, -0x80000000

    cmp-long v6, v4, v6

    if-nez v6, :cond_6

    const/4 v4, 0x0

    :goto_1
    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->C:Ljava/lang/Integer;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->l()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->q:Ljava/lang/Long;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->y:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->m()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->v:Ljava/lang/Long;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->B()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-static {}, Lcom/google/android/gms/internal/zzcgn;->B()Z

    move-result v4

    if-eqz v4, :cond_4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    move-object/from16 v0, v23

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzcgn;->c(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    const/4 v4, 0x0

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->G:Ljava/lang/String;

    :cond_4
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v4

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzchx;->a(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v5

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->B()Z

    move-result v4

    if-eqz v4, :cond_5

    if-eqz v5, :cond_5

    iget-object v4, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/CharSequence;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_5

    iget-object v4, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/String;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->s:Ljava/lang/String;

    iget-object v4, v5, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Boolean;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->t:Ljava/lang/Boolean;

    :cond_5
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->k:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    sget-object v4, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->j:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgu;->x()J

    move-result-wide v4

    long-to-int v4, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->m:Ljava/lang/Integer;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->x()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgu;->y()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->l:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->c()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->u:Ljava/lang/String;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->f()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->B:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v4

    new-array v4, v4, [Lcom/google/android/gms/internal/zzcmg;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    const/4 v4, 0x0

    move v5, v4

    :goto_2
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v4

    if-ge v5, v4, :cond_7

    new-instance v7, Lcom/google/android/gms/internal/zzcmg;

    invoke-direct {v7}, Lcom/google/android/gms/internal/zzcmg;-><init>()V

    move-object/from16 v0, v23

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    aput-object v7, v4, v5

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/zzclp;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzclp;->c:Ljava/lang/String;

    iput-object v4, v7, Lcom/google/android/gms/internal/zzcmg;->b:Ljava/lang/String;

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/zzclp;

    iget-wide v8, v4, Lcom/google/android/gms/internal/zzclp;->d:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v7, Lcom/google/android/gms/internal/zzcmg;->a:Ljava/lang/Long;

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v8

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/zzclp;

    iget-object v4, v4, Lcom/google/android/gms/internal/zzclp;->e:Ljava/lang/Object;

    invoke-virtual {v8, v7, v4}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmg;Ljava/lang/Object;)V

    add-int/lit8 v4, v5, 0x1

    move v5, v4

    goto :goto_2

    :cond_6
    long-to-int v4, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    goto/16 :goto_1

    :cond_7
    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcha;->b:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgx;->b()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "_iap"

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    const-string v5, "_c"

    const-wide/16 v6, 0x1

    invoke-virtual {v4, v5, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v5

    const-string v6, "Marking in-app purchase as real-time"

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    const-string v5, "_r"

    const-wide/16 v6, 0x1

    invoke-virtual {v4, v5, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    :cond_8
    const-string v5, "_o"

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v5

    move-object/from16 v0, v23

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcme;->o:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/zzclq;->j(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v5

    const-string v6, "_dbg"

    const-wide/16 v8, 0x1

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v5, v4, v6, v7}, Lcom/google/android/gms/internal/zzclq;->a(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v5

    const-string v6, "_r"

    const-wide/16 v8, 0x1

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v5, v4, v6, v7}, Lcom/google/android/gms/internal/zzclq;->a(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0, v6}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v5

    if-nez v5, :cond_a

    const-wide/16 v20, 0x0

    new-instance v5, Lcom/google/android/gms/internal/zzcgw;

    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    const-wide/16 v8, 0x1

    const-wide/16 v10, 0x0

    move-object/from16 v0, p1

    iget-wide v12, v0, Lcom/google/android/gms/internal/zzcha;->d:J

    const-wide/16 v14, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v6, p2

    invoke-direct/range {v5 .. v18}, Lcom/google/android/gms/internal/zzcgw;-><init>(Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v6

    invoke-virtual {v6, v5}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgw;)V

    move-wide/from16 v12, v20

    :goto_3
    new-instance v5, Lcom/google/android/gms/internal/zzcgv;

    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/google/android/gms/internal/zzcha;->c:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v9, v0, Lcom/google/android/gms/internal/zzcha;->a:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-wide v10, v0, Lcom/google/android/gms/internal/zzcha;->d:J

    move-object/from16 v6, p0

    move-object/from16 v8, p2

    move-object v14, v4

    invoke-direct/range {v5 .. v14}, Lcom/google/android/gms/internal/zzcgv;-><init>(Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLandroid/os/Bundle;)V

    new-instance v8, Lcom/google/android/gms/internal/zzcmb;

    invoke-direct {v8}, Lcom/google/android/gms/internal/zzcmb;-><init>()V

    const/4 v4, 0x1

    new-array v4, v4, [Lcom/google/android/gms/internal/zzcmb;

    const/4 v6, 0x0

    aput-object v8, v4, v6

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    iget-wide v6, v5, Lcom/google/android/gms/internal/zzcgv;->c:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    iget-object v4, v5, Lcom/google/android/gms/internal/zzcgv;->b:Ljava/lang/String;

    iput-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->b:Ljava/lang/String;

    iget-wide v6, v5, Lcom/google/android/gms/internal/zzcgv;->d:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->d:Ljava/lang/Long;

    iget-object v4, v5, Lcom/google/android/gms/internal/zzcgv;->e:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgx;->a()I

    move-result v4

    new-array v4, v4, [Lcom/google/android/gms/internal/zzcmc;

    iput-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    const/4 v4, 0x0

    iget-object v6, v5, Lcom/google/android/gms/internal/zzcgv;->e:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/zzcgx;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v6, v4

    :goto_4
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_b

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    new-instance v10, Lcom/google/android/gms/internal/zzcmc;

    invoke-direct {v10}, Lcom/google/android/gms/internal/zzcmc;-><init>()V

    iget-object v11, v8, Lcom/google/android/gms/internal/zzcmb;->a:[Lcom/google/android/gms/internal/zzcmc;

    add-int/lit8 v7, v6, 0x1

    aput-object v10, v11, v6

    iput-object v4, v10, Lcom/google/android/gms/internal/zzcmc;->a:Ljava/lang/String;

    iget-object v6, v5, Lcom/google/android/gms/internal/zzcgv;->e:Lcom/google/android/gms/internal/zzcgx;

    invoke-virtual {v6, v4}, Lcom/google/android/gms/internal/zzcgx;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v6

    invoke-virtual {v6, v10, v4}, Lcom/google/android/gms/internal/zzclq;->a(Lcom/google/android/gms/internal/zzcmc;Ljava/lang/Object;)V

    move v6, v7

    goto :goto_4

    :cond_a
    iget-wide v12, v5, Lcom/google/android/gms/internal/zzcgw;->e:J

    move-object/from16 v0, p1

    iget-wide v6, v0, Lcom/google/android/gms/internal/zzcha;->d:J

    invoke-virtual {v5, v6, v7}, Lcom/google/android/gms/internal/zzcgw;->a(J)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzcgw;->a()Lcom/google/android/gms/internal/zzcgw;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v6

    invoke-virtual {v6, v5}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgw;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_3

    :catchall_0
    move-exception v4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v4

    :cond_b
    :try_start_3
    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v23

    iget-object v5, v0, Lcom/google/android/gms/internal/zzcme;->c:[Lcom/google/android/gms/internal/zzcmg;

    move-object/from16 v0, v23

    iget-object v6, v0, Lcom/google/android/gms/internal/zzcme;->b:[Lcom/google/android/gms/internal/zzcmb;

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v5, v6}, Lcom/google/android/gms/internal/zzcim;->a(Ljava/lang/String;[Lcom/google/android/gms/internal/zzcmg;[Lcom/google/android/gms/internal/zzcmb;)[Lcom/google/android/gms/internal/zzcma;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->A:[Lcom/google/android/gms/internal/zzcma;

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    iget-object v4, v8, Lcom/google/android/gms/internal/zzcmb;->c:Ljava/lang/Long;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->h()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v6, v4, v6

    if-eqz v6, :cond_c

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    :goto_5
    move-object/from16 v0, v23

    iput-object v6, v0, Lcom/google/android/gms/internal/zzcme;->h:Ljava/lang/Long;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->g()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v8, v6, v8

    if-nez v8, :cond_e

    :goto_6
    const-wide/16 v6, 0x0

    cmp-long v6, v4, v6

    if-eqz v6, :cond_d

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    :goto_7
    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->g:Ljava/lang/Long;

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->r()V

    invoke-virtual/range {v22 .. v22}, Lcom/google/android/gms/internal/zzcgh;->o()J

    move-result-wide v4

    long-to-int v4, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->w:Ljava/lang/Integer;

    const-wide/16 v4, 0x2e86

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->r:Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v4}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->d:Ljava/lang/Long;

    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    move-object/from16 v0, v23

    iput-object v4, v0, Lcom/google/android/gms/internal/zzcme;->z:Ljava/lang/Boolean;

    move-object/from16 v0, v23

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcme;->e:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    move-object/from16 v0, v22

    invoke-virtual {v0, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->a(J)V

    move-object/from16 v0, v23

    iget-object v4, v0, Lcom/google/android/gms/internal/zzcme;->f:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    move-object/from16 v0, v22

    invoke-virtual {v0, v4, v5}, Lcom/google/android/gms/internal/zzcgh;->b(J)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzcgo;->z()V

    :try_start_4
    invoke-virtual/range {v19 .. v19}, Lcom/google/android/gms/internal/zzfjs;->f()I

    move-result v4

    new-array v4, v4, [B

    const/4 v5, 0x0

    array-length v6, v4

    invoke-static {v4, v5, v6}, Lcom/google/android/gms/internal/zzfjk;->a([BII)Lcom/google/android/gms/internal/zzfjk;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Lcom/google/android/gms/internal/zzfjs;->a(Lcom/google/android/gms/internal/zzfjk;)V

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzfjk;->a()V

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/google/android/gms/internal/zzclq;->a([B)[B
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    move-result-object v4

    goto/16 :goto_0

    :cond_c
    const/4 v6, 0x0

    goto/16 :goto_5

    :cond_d
    const/4 v4, 0x0

    goto/16 :goto_7

    :catch_0
    move-exception v4

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v5

    const-string v6, "Data loss. Failed to bundle and serialize. appId"

    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v5, v6, v7, v4}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v4, 0x0

    goto/16 :goto_0

    :cond_e
    move-wide v4, v6

    goto/16 :goto_6
.end method

.method protected final c()V
    .locals 6

    const-wide/16 v4, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->D()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v0

    cmp-long v0, v0, v4

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->c:Lcom/google/android/gms/internal/zzcia;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->h:Lcom/google/android/gms/internal/zzcia;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcia;->a()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    cmp-long v0, v0, v4

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Persisting first open"

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->h:Lcom/google/android/gms/internal/zzcia;

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->b()Z

    move-result v0

    if-nez v0, :cond_7

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->B()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    const-string v1, "android.permission.INTERNET"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzclq;->h(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "App is missing INTERNET permission"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->o()Lcom/google/android/gms/internal/zzclq;

    move-result-object v0

    const-string v1, "android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzclq;->h(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "App is missing ACCESS_NETWORK_STATE permission"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzbhe;->a()Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcid;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_4

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "AppMeasurementReceiver not registered/enabled"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzcla;->a(Landroid/content/Context;Z)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "AppMeasurementService not registered/enabled"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_5
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Uploading is not possible. App measurement disabled"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    :cond_6
    :goto_0
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzcim;->N()V

    return-void

    :cond_7
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_8

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchx;->y()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzchx;->c(Ljava/lang/String;)V

    :cond_8
    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->l()Lcom/google/android/gms/internal/zzcjn;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/zzchx;->i:Lcom/google/android/gms/internal/zzcic;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcic;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcjn;->a(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->l()Lcom/google/android/gms/internal/zzcjn;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    iget-object v1, v0, Lcom/google/android/gms/internal/zzcjn;->p:Lcom/google/android/gms/internal/zzcim;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcim;->b()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->i()Lcom/google/android/gms/internal/zzckg;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzckg;->B()V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->u()Lcom/google/android/gms/internal/zzchx;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchx;->C()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_9

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->h()Lcom/google/android/gms/internal/zzcgu;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_9

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string v3, "_po"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "auto"

    const-string v3, "_ou"

    invoke-virtual {v0, v1, v3, v2}, Lcom/google/android/gms/internal/zzcjn;->a(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    :cond_9
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->w()Lcom/google/android/gms/internal/zzckg;

    move-result-object v0

    new-instance v1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzckg;->a(Ljava/util/concurrent/atomic/AtomicReference;)V

    goto/16 :goto_0

    :cond_a
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->C()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "Rechecking which service to use due to a GMP App Id change"

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchx;->B()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->r:Lcom/google/android/gms/internal/zzckg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzckg;->E()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->r:Lcom/google/android/gms/internal/zzckg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzckg;->C()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->y()Lcom/google/android/gms/internal/zzchh;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchh;->A()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzchx;->c(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->h:Lcom/google/android/gms/internal/zzcia;

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzcim;->O:J

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcia;->a(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->e()Lcom/google/android/gms/internal/zzchx;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzchx;->i:Lcom/google/android/gms/internal/zzcic;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcic;->a(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public final c(Lcom/google/android/gms/internal/zzcgi;)V
    .locals 10

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzcgh;->g(J)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzcgo;->a(Lcom/google/android/gms/internal/zzcgh;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->j()Lcom/google/android/gms/internal/zzcig;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcig;->d(Ljava/lang/String;)V

    :cond_1
    iget-boolean v0, p1, Lcom/google/android/gms/internal/zzcgi;->h:Z

    if-nez v0, :cond_2

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    goto :goto_0

    :cond_2
    iget-wide v4, p1, Lcom/google/android/gms/internal/zzcgi;->m:J

    const-wide/16 v0, 0x0

    cmp-long v0, v4, v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v4

    :cond_3
    iget v0, p1, Lcom/google/android/gms/internal/zzcgi;->n:I

    if-eqz v0, :cond_14

    const/4 v1, 0x1

    if-eq v0, v1, :cond_14

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "Incorrect app type, assuming installed app. appId, appType"

    iget-object v3, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v2, v3, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v0, 0x0

    move v6, v0

    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->x()V

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcgo;->b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgh;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->A()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v2, "New GMP App Id passed in. Removing cached database data. appId"

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-static {v2}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->A()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v2, v3, v7

    const-string v7, "events"

    const-string v8, "app_id=?"

    invoke-virtual {v0, v7, v8, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v7

    add-int/lit8 v7, v7, 0x0

    const-string v8, "user_attributes"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "conditional_properties"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "apps"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "raw_events"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "raw_events_metadata"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "event_filters"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "property_filters"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    add-int/2addr v7, v8

    const-string v8, "audience_filter_values"

    const-string v9, "app_id=?"

    invoke-virtual {v0, v8, v9, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    add-int/2addr v0, v7

    if-lez v0, :cond_4

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzchm;->E()Lcom/google/android/gms/internal/zzcho;

    move-result-object v3

    const-string v7, "Deleted application data. app, records"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v7, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_4
    :goto_2
    const/4 v0, 0x0

    :cond_5
    if-eqz v0, :cond_6

    :try_start_2
    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_6

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const-string v1, "_pv"

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgh;->i()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    const-string v1, "_au"

    new-instance v2, Lcom/google/android/gms/internal/zzcgx;

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/zzcgx;-><init>(Landroid/os/Bundle;)V

    const-string v3, "auto"

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcha;-><init>(Ljava/lang/String;Lcom/google/android/gms/internal/zzcgx;Ljava/lang/String;J)V

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_6
    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzcim;->d(Lcom/google/android/gms/internal/zzcgi;)V

    const/4 v0, 0x0

    if-nez v6, :cond_c

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const-string v2, "_f"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;

    move-result-object v0

    :cond_7
    :goto_3
    if-nez v0, :cond_13

    const-wide/16 v0, 0x1

    const-wide/32 v2, 0x36ee80

    div-long v2, v4, v2

    add-long/2addr v0, v2

    const-wide/32 v2, 0x36ee80

    mul-long/2addr v0, v2

    if-nez v6, :cond_12

    new-instance v2, Lcom/google/android/gms/internal/zzcln;

    const-string v3, "_fot"

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    const-string v7, "auto"

    invoke-direct/range {v2 .. v7}, Lcom/google/android/gms/internal/zzcln;-><init>(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, v2, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcln;Lcom/google/android/gms/internal/zzcgi;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    const-string v0, "_c"

    const-wide/16 v2, 0x1

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_r"

    const-wide/16 v2, 0x1

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_uwa"

    const-wide/16 v2, 0x0

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_pfo"

    const-wide/16 v2, 0x0

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_sys"

    const-wide/16 v2, 0x0

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_sysu"

    const-wide/16 v2, 0x0

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    if-nez v0, :cond_d

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v1, "PackageManager is null, first open report might be inaccurate. appId"

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_8
    :goto_4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->Q()V

    const-string v2, "first_open_count"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->h(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-ltz v2, :cond_9

    const-string v2, "_pfo"

    invoke-virtual {v8, v2, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    :cond_9
    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    const-string v1, "_f"

    new-instance v2, Lcom/google/android/gms/internal/zzcgx;

    invoke-direct {v2, v8}, Lcom/google/android/gms/internal/zzcgx;-><init>(Landroid/os/Bundle;)V

    const-string v3, "auto"

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcha;-><init>(Ljava/lang/String;Lcom/google/android/gms/internal/zzcgx;Ljava/lang/String;J)V

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_a
    :goto_5
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const-string v0, "_et"

    const-wide/16 v6, 0x1

    invoke-virtual {v3, v0, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    const-string v1, "_e"

    new-instance v2, Lcom/google/android/gms/internal/zzcgx;

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/zzcgx;-><init>(Landroid/os/Bundle;)V

    const-string v3, "auto"

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcha;-><init>(Ljava/lang/String;Lcom/google/android/gms/internal/zzcgx;Ljava/lang/String;J)V

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    :cond_b
    :goto_6
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->y()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcgo;->z()V

    goto/16 :goto_0

    :catch_0
    move-exception v0

    :try_start_3
    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v1

    const-string v3, "Error deleting application data. appId, error"

    invoke-static {v2}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v3, v2, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcgo;->z()V

    throw v0

    :cond_c
    const/4 v1, 0x1

    if-ne v6, v1, :cond_7

    :try_start_4
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->q()Lcom/google/android/gms/internal/zzcgo;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const-string v2, "_v"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzcgo;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcgw;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v0

    goto/16 :goto_3

    :cond_d
    const/4 v1, 0x0

    :try_start_5
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v0

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzbhe;->b(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_5
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v0

    move-object v1, v0

    :goto_7
    if-eqz v1, :cond_e

    :try_start_6
    iget-wide v2, v1, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    const-wide/16 v6, 0x0

    cmp-long v0, v2, v6

    if-eqz v0, :cond_e

    const/4 v0, 0x0

    iget-wide v2, v1, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    iget-wide v6, v1, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    cmp-long v1, v2, v6

    if-eqz v1, :cond_10

    const-string v1, "_uwa"

    const-wide/16 v2, 0x1

    invoke-virtual {v8, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    :goto_8
    new-instance v2, Lcom/google/android/gms/internal/zzcln;

    const-string v3, "_fi"

    if-eqz v0, :cond_11

    const-wide/16 v0, 0x1

    :goto_9
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    const-string v7, "auto"

    invoke-direct/range {v2 .. v7}, Lcom/google/android/gms/internal/zzcln;-><init>(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, v2, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcln;Lcom/google/android/gms/internal/zzcgi;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :cond_e
    const/4 v1, 0x0

    :try_start_7
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbhf;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;

    move-result-object v0

    iget-object v2, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzbhe;->a(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_2
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-result-object v0

    :goto_a
    if-eqz v0, :cond_8

    :try_start_8
    iget v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_f

    const-string v1, "_sys"

    const-wide/16 v2, 0x1

    invoke-virtual {v8, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    :cond_f
    iget v0, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit16 v0, v0, 0x80

    if-eqz v0, :cond_8

    const-string v0, "_sysu"

    const-wide/16 v2, 0x1

    invoke-virtual {v8, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_4

    :catch_1
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Package info is null, first open report might be inaccurate. appId"

    iget-object v6, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v6}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v2, v3, v6, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_7

    :cond_10
    const/4 v0, 0x1

    goto :goto_8

    :cond_11
    const-wide/16 v0, 0x0

    goto :goto_9

    :catch_2
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->f()Lcom/google/android/gms/internal/zzchm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzchm;->y()Lcom/google/android/gms/internal/zzcho;

    move-result-object v2

    const-string v3, "Application info is null, first open report might be inaccurate. appId"

    iget-object v6, p1, Lcom/google/android/gms/internal/zzcgi;->a:Ljava/lang/String;

    invoke-static {v6}, Lcom/google/android/gms/internal/zzchm;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v2, v3, v6, v0}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    move-object v0, v1

    goto :goto_a

    :cond_12
    const/4 v2, 0x1

    if-ne v6, v2, :cond_a

    new-instance v2, Lcom/google/android/gms/internal/zzcln;

    const-string v3, "_fvt"

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    const-string v7, "auto"

    invoke-direct/range {v2 .. v7}, Lcom/google/android/gms/internal/zzcln;-><init>(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, v2, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcln;Lcom/google/android/gms/internal/zzcgi;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->h()Lcom/google/android/gms/internal/zzcih;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->c()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzcim;->a()V

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const-string v0, "_c"

    const-wide/16 v6, 0x1

    invoke-virtual {v3, v0, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "_r"

    const-wide/16 v6, 0x1

    invoke-virtual {v3, v0, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    const-string v1, "_v"

    new-instance v2, Lcom/google/android/gms/internal/zzcgx;

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/zzcgx;-><init>(Landroid/os/Bundle;)V

    const-string v3, "auto"

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcha;-><init>(Ljava/lang/String;Lcom/google/android/gms/internal/zzcgx;Ljava/lang/String;J)V

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V

    goto/16 :goto_5

    :cond_13
    iget-boolean v0, p1, Lcom/google/android/gms/internal/zzcgi;->i:Z

    if-eqz v0, :cond_b

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/zzcha;

    const-string v1, "_cd"

    new-instance v2, Lcom/google/android/gms/internal/zzcgx;

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/zzcgx;-><init>(Landroid/os/Bundle;)V

    const-string v3, "auto"

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzcha;-><init>(Ljava/lang/String;Lcom/google/android/gms/internal/zzcgx;Ljava/lang/String;J)V

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcha;Lcom/google/android/gms/internal/zzcgi;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto/16 :goto_6

    :cond_14
    move v6, v0

    goto/16 :goto_1
.end method

.method public final d()Lcom/google/android/gms/internal/zzcgn;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->c:Lcom/google/android/gms/internal/zzcgn;

    return-object v0
.end method

.method public final e()Lcom/google/android/gms/internal/zzchx;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->d:Lcom/google/android/gms/internal/zzchx;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcjk;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->d:Lcom/google/android/gms/internal/zzchx;

    return-object v0
.end method

.method public final f()Lcom/google/android/gms/internal/zzchm;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    return-object v0
.end method

.method public final g()Lcom/google/android/gms/internal/zzchm;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjl;->P()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->e:Lcom/google/android/gms/internal/zzchm;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final h()Lcom/google/android/gms/internal/zzcih;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->f:Lcom/google/android/gms/internal/zzcih;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->f:Lcom/google/android/gms/internal/zzcih;

    return-object v0
.end method

.method public final i()Lcom/google/android/gms/internal/zzclf;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->g:Lcom/google/android/gms/internal/zzclf;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->g:Lcom/google/android/gms/internal/zzclf;

    return-object v0
.end method

.method public final j()Lcom/google/android/gms/internal/zzcig;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->h:Lcom/google/android/gms/internal/zzcig;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->h:Lcom/google/android/gms/internal/zzcig;

    return-object v0
.end method

.method final k()Lcom/google/android/gms/internal/zzcih;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->f:Lcom/google/android/gms/internal/zzcih;

    return-object v0
.end method

.method public final l()Lcom/google/android/gms/internal/zzcjn;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->t:Lcom/google/android/gms/internal/zzcjn;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->t:Lcom/google/android/gms/internal/zzcjn;

    return-object v0
.end method

.method public final m()Lcom/google/android/gms/measurement/AppMeasurement;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->i:Lcom/google/android/gms/measurement/AppMeasurement;

    return-object v0
.end method

.method public final n()Lcom/google/firebase/analytics/FirebaseAnalytics;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->j:Lcom/google/firebase/analytics/FirebaseAnalytics;

    return-object v0
.end method

.method public final o()Lcom/google/android/gms/internal/zzclq;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->k:Lcom/google/android/gms/internal/zzclq;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcjk;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->k:Lcom/google/android/gms/internal/zzclq;

    return-object v0
.end method

.method public final p()Lcom/google/android/gms/internal/zzchk;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->l:Lcom/google/android/gms/internal/zzchk;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->a(Lcom/google/android/gms/internal/zzcjk;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->l:Lcom/google/android/gms/internal/zzchk;

    return-object v0
.end method

.method public final q()Lcom/google/android/gms/internal/zzcgo;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->m:Lcom/google/android/gms/internal/zzcgo;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->m:Lcom/google/android/gms/internal/zzcgo;

    return-object v0
.end method

.method public final r()Lcom/google/android/gms/internal/zzchi;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->n:Lcom/google/android/gms/internal/zzchi;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->n:Lcom/google/android/gms/internal/zzchi;

    return-object v0
.end method

.method public final s()Lcom/google/android/gms/internal/zzchq;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->o:Lcom/google/android/gms/internal/zzchq;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->o:Lcom/google/android/gms/internal/zzchq;

    return-object v0
.end method

.method public final t()Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->b:Landroid/content/Context;

    return-object v0
.end method

.method public final u()Lcom/google/android/gms/common/util/zzd;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->p:Lcom/google/android/gms/common/util/zzd;

    return-object v0
.end method

.method public final v()Lcom/google/android/gms/internal/zzckc;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->q:Lcom/google/android/gms/internal/zzckc;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->q:Lcom/google/android/gms/internal/zzckc;

    return-object v0
.end method

.method public final w()Lcom/google/android/gms/internal/zzckg;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->r:Lcom/google/android/gms/internal/zzckg;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->r:Lcom/google/android/gms/internal/zzckg;

    return-object v0
.end method

.method public final x()Lcom/google/android/gms/internal/zzcgu;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->s:Lcom/google/android/gms/internal/zzcgu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->s:Lcom/google/android/gms/internal/zzcgu;

    return-object v0
.end method

.method public final y()Lcom/google/android/gms/internal/zzchh;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->u:Lcom/google/android/gms/internal/zzchh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->u:Lcom/google/android/gms/internal/zzchh;

    return-object v0
.end method

.method public final z()Lcom/google/android/gms/internal/zzcgk;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->x:Lcom/google/android/gms/internal/zzcgk;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzcim;->b(Lcom/google/android/gms/internal/zzcjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcim;->x:Lcom/google/android/gms/internal/zzcgk;

    return-object v0
.end method
