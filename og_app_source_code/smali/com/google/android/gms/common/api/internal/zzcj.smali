.class final Lcom/google/android/gms/common/api/internal/zzcj;
.super Landroid/os/Handler;


# instance fields
.field private synthetic a:Lcom/google/android/gms/common/api/internal/zzci;


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 2

    const/4 v0, 0x1

    iget v1, p1, Landroid/os/Message;->what:I

    if-ne v1, v0, :cond_0

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->b(Z)V

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zzcj;->a:Lcom/google/android/gms/common/api/internal/zzci;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/common/api/internal/zzcl;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/common/api/internal/zzci;->b(Lcom/google/android/gms/common/api/internal/zzcl;)V

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
