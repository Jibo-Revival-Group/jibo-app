.class public final Lcom/google/android/gms/internal/zzcfk;
.super Lcom/google/android/gms/internal/zzcdt;


# instance fields
.field private final e:Lcom/google/android/gms/internal/zzcfd;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;Ljava/lang/String;Lcom/google/android/gms/common/internal/zzr;)V
    .locals 2

    invoke-direct/range {p0 .. p6}, Lcom/google/android/gms/internal/zzcdt;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;Ljava/lang/String;Lcom/google/android/gms/common/internal/zzr;)V

    new-instance v0, Lcom/google/android/gms/internal/zzcfd;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcfk;->d:Lcom/google/android/gms/internal/zzcfu;

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/internal/zzcfd;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/zzcfu;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    return-void
.end method


# virtual methods
.method public final e()Landroid/location/Location;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcfd;->a()Landroid/location/Location;

    move-result-object v0

    return-object v0
.end method

.method public final f()V
    .locals 4

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    monitor-enter v1

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/common/internal/zzd;->g()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcfd;->c()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcfd;->d()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_0
    :goto_0
    :try_start_2
    invoke-super {p0}, Lcom/google/android/gms/internal/zzcdt;->f()V

    monitor-exit v1

    return-void

    :catch_0
    move-exception v0

    const-string v2, "LocationClientImpl"

    const-string v3, "Client disconnected before listeners could be cleaned up"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method

.method public final x()Lcom/google/android/gms/location/LocationAvailability;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfk;->e:Lcom/google/android/gms/internal/zzcfd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcfd;->b()Lcom/google/android/gms/location/LocationAvailability;

    move-result-object v0

    return-object v0
.end method
