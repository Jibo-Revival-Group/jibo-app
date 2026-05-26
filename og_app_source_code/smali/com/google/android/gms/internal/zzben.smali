.class final Lcom/google/android/gms/internal/zzben;
.super Lcom/google/android/gms/internal/zzbel;


# instance fields
.field private synthetic a:Lcom/google/android/gms/internal/zzbem;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzbem;)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/internal/zzben;->a:Lcom/google/android/gms/internal/zzbem;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzbel;-><init>(Lcom/google/android/gms/internal/zzbek;)V

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/common/api/Status;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzben;->a:Lcom/google/android/gms/internal/zzbem;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->a(Lcom/google/android/gms/common/api/Result;)V

    return-void
.end method
