.class public final Lcom/google/android/gms/iid/zzf;
.super Landroid/os/Binder;


# instance fields
.field private final a:Lcom/google/android/gms/iid/zzb;


# direct methods
.method constructor <init>(Lcom/google/android/gms/iid/zzb;)V
    .locals 0

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/iid/zzf;->a:Lcom/google/android/gms/iid/zzb;

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/iid/zzf;)Lcom/google/android/gms/iid/zzb;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/iid/zzf;->a:Lcom/google/android/gms/iid/zzb;

    return-object v0
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/iid/zzd;)V
    .locals 3

    const/4 v2, 0x3

    invoke-static {}, Landroid/os/Binder;->getCallingUid()I

    move-result v0

    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/SecurityException;

    const-string v1, "Binding only allowed within app"

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const-string v0, "EnhancedIntentService"

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "EnhancedIntentService"

    const-string v1, "service received new intent via bind strategy"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    const-string v0, "EnhancedIntentService"

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "EnhancedIntentService"

    const-string v1, "intent being queued for bg execution"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/iid/zzf;->a:Lcom/google/android/gms/iid/zzb;

    iget-object v0, v0, Lcom/google/android/gms/iid/zzb;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/google/android/gms/iid/zzg;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/iid/zzg;-><init>(Lcom/google/android/gms/iid/zzf;Lcom/google/android/gms/iid/zzd;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    return-void
.end method
