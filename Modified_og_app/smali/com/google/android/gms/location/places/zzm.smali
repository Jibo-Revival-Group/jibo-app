.class public Lcom/google/android/gms/location/places/zzm;
.super Lcom/google/android/gms/location/places/internal/zzx;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/location/places/zzm$zzf;,
        Lcom/google/android/gms/location/places/zzm$zza;,
        Lcom/google/android/gms/location/places/zzm$zze;,
        Lcom/google/android/gms/location/places/zzm$zzc;,
        Lcom/google/android/gms/location/places/zzm$zzd;,
        Lcom/google/android/gms/location/places/zzm$zzb;
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private final b:Lcom/google/android/gms/location/places/zzm$zzd;

.field private final c:Lcom/google/android/gms/location/places/zzm$zza;

.field private final d:Lcom/google/android/gms/location/places/zzm$zze;

.field private final e:Lcom/google/android/gms/location/places/zzm$zzf;

.field private final f:Lcom/google/android/gms/location/places/zzm$zzc;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/google/android/gms/location/places/zzm;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/location/places/zzm$zza;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/location/places/internal/zzx;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->b:Lcom/google/android/gms/location/places/zzm$zzd;

    iput-object p1, p0, Lcom/google/android/gms/location/places/zzm;->c:Lcom/google/android/gms/location/places/zzm$zza;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->d:Lcom/google/android/gms/location/places/zzm$zze;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->e:Lcom/google/android/gms/location/places/zzm$zzf;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->f:Lcom/google/android/gms/location/places/zzm$zzc;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/location/places/zzm$zzc;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/location/places/internal/zzx;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->b:Lcom/google/android/gms/location/places/zzm$zzd;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->c:Lcom/google/android/gms/location/places/zzm$zza;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->d:Lcom/google/android/gms/location/places/zzm$zze;

    iput-object v0, p0, Lcom/google/android/gms/location/places/zzm;->e:Lcom/google/android/gms/location/places/zzm$zzf;

    iput-object p1, p0, Lcom/google/android/gms/location/places/zzm;->f:Lcom/google/android/gms/location/places/zzm$zzc;

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/common/api/Status;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->e:Lcom/google/android/gms/location/places/zzm$zzf;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->b:Lcom/google/android/gms/location/places/zzm$zzd;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    const-string v1, "placeEstimator cannot be null"

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/zzbq;->a(ZLjava/lang/Object;)V

    if-nez p1, :cond_2

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const/4 v1, 0x6

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const-string v1, "onPlaceEstimated received null DataHolder"

    new-instance v2, Ljava/lang/Throwable;

    invoke-direct {v2}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->b:Lcom/google/android/gms/location/places/zzm$zzd;

    sget-object v1, Lcom/google/android/gms/common/api/Status;->c:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zzm;->c(Lcom/google/android/gms/common/api/Status;)V

    :goto_1
    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Lcom/google/android/gms/common/data/DataHolder;->c()Landroid/os/Bundle;

    move-result-object v0

    if-nez v0, :cond_3

    const/16 v0, 0x64

    :goto_2
    new-instance v1, Lcom/google/android/gms/location/places/PlaceLikelihoodBuffer;

    invoke-direct {v1, p1, v0}, Lcom/google/android/gms/location/places/PlaceLikelihoodBuffer;-><init>(Lcom/google/android/gms/common/data/DataHolder;I)V

    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->b:Lcom/google/android/gms/location/places/zzm$zzd;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    goto :goto_1

    :cond_3
    invoke-static {v0}, Lcom/google/android/gms/location/places/PlaceLikelihoodBuffer;->a(Landroid/os/Bundle;)I

    move-result v0

    goto :goto_2
.end method

.method public final b(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    if-nez p1, :cond_1

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const/4 v1, 0x6

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const-string v1, "onAutocompletePrediction received null DataHolder"

    new-instance v2, Ljava/lang/Throwable;

    invoke-direct {v2}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->c:Lcom/google/android/gms/location/places/zzm$zza;

    sget-object v1, Lcom/google/android/gms/common/api/Status;->c:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zzm;->c(Lcom/google/android/gms/common/api/Status;)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/location/places/zzm;->c:Lcom/google/android/gms/location/places/zzm$zza;

    new-instance v1, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;

    invoke-direct {v1, p1}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    goto :goto_0
.end method

.method public final c(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    const/4 v3, 0x0

    if-nez p1, :cond_1

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const/4 v1, 0x6

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/location/places/zzm;->a:Ljava/lang/String;

    const-string v1, "onPlaceUserDataFetched received null DataHolder"

    new-instance v2, Ljava/lang/Throwable;

    invoke-direct {v2}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    sget-object v0, Lcom/google/android/gms/common/api/Status;->c:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {v3, v0}, Lcom/google/android/gms/common/api/internal/zzm;->c(Lcom/google/android/gms/common/api/Status;)V

    :goto_0
    return-void

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/zzcga;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/zzcga;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    invoke-virtual {v3, v0}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    goto :goto_0
.end method

.method public final d(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/location/places/PlaceBuffer;

    invoke-direct {v0, p1}, Lcom/google/android/gms/location/places/PlaceBuffer;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    iget-object v1, p0, Lcom/google/android/gms/location/places/zzm;->f:Lcom/google/android/gms/location/places/zzm$zzc;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    return-void
.end method
