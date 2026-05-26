.class final Lcom/google/android/gms/internal/zzckx;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/google/android/gms/internal/zzche;

.field private synthetic b:Lcom/google/android/gms/internal/zzcku;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzcku;Lcom/google/android/gms/internal/zzche;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzckx;->a:Lcom/google/android/gms/internal/zzche;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzcku;->a(Lcom/google/android/gms/internal/zzcku;Z)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcku;->a:Lcom/google/android/gms/internal/zzckg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzckg;->y()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcku;->a:Lcom/google/android/gms/internal/zzckg;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcjk;->t()Lcom/google/android/gms/internal/zzchm;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzchm;->D()Lcom/google/android/gms/internal/zzcho;

    move-result-object v0

    const-string v2, "Connected to remote service"

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzcho;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzckx;->b:Lcom/google/android/gms/internal/zzcku;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzcku;->a:Lcom/google/android/gms/internal/zzckg;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzckx;->a:Lcom/google/android/gms/internal/zzche;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzckg;->a(Lcom/google/android/gms/internal/zzche;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
