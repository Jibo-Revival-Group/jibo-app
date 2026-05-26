.class public Lcom/google/android/gms/internal/zzevx;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzevw$zza;


# instance fields
.field private a:Lcom/google/android/gms/internal/zzevw;

.field private b:I

.field private c:Z

.field private d:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/zzevw$zza;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/internal/zzevw;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v0, p0, Lcom/google/android/gms/internal/zzevx;->b:I

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevx;->c:Z

    iput-object p1, p0, Lcom/google/android/gms/internal/zzevx;->a:Lcom/google/android/gms/internal/zzevw;

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevx;->d:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public final b(I)V
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzevx;->b:I

    or-int/2addr v0, p1

    iput v0, p0, Lcom/google/android/gms/internal/zzevx;->b:I

    return-void
.end method

.method protected final c(I)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevx;->a:Lcom/google/android/gms/internal/zzevw;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevw;->a(I)V

    return-void
.end method

.method protected final e()V
    .locals 2

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevx;->c:Z

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevx;->a:Lcom/google/android/gms/internal/zzevw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzevw;->b()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzevx;->b:I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevx;->a:Lcom/google/android/gms/internal/zzevw;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevx;->d:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevw;->a(Ljava/lang/ref/WeakReference;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevx;->c:Z

    goto :goto_0
.end method

.method protected final f()V
    .locals 2

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzevx;->c:Z

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzevx;->a:Lcom/google/android/gms/internal/zzevw;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevx;->d:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzevw;->b(Ljava/lang/ref/WeakReference;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzevx;->c:Z

    goto :goto_0
.end method

.method public final g()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzevx;->b:I

    return v0
.end method
