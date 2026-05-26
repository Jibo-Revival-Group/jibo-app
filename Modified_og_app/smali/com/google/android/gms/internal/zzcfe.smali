.class final Lcom/google/android/gms/internal/zzcfe;
.super Lcom/google/android/gms/location/zzq;


# instance fields
.field private final a:Lcom/google/android/gms/common/api/internal/zzci;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/internal/zzci",
            "<",
            "Lcom/google/android/gms/location/LocationCallback;",
            ">;"
        }
    .end annotation
.end field


# virtual methods
.method public final a(Lcom/google/android/gms/location/LocationAvailability;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfe;->a:Lcom/google/android/gms/common/api/internal/zzci;

    new-instance v1, Lcom/google/android/gms/internal/zzcfg;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/internal/zzcfg;-><init>(Lcom/google/android/gms/internal/zzcfe;Lcom/google/android/gms/location/LocationAvailability;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zzci;->a(Lcom/google/android/gms/common/api/internal/zzcl;)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/location/LocationResult;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcfe;->a:Lcom/google/android/gms/common/api/internal/zzci;

    new-instance v1, Lcom/google/android/gms/internal/zzcff;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/internal/zzcff;-><init>(Lcom/google/android/gms/internal/zzcfe;Lcom/google/android/gms/location/LocationResult;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zzci;->a(Lcom/google/android/gms/common/api/internal/zzcl;)V

    return-void
.end method
