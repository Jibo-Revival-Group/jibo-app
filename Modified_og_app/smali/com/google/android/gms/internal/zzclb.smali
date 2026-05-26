.class final synthetic Lcom/google/android/gms/internal/zzclb;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Lcom/google/android/gms/internal/zzcla;

.field private final b:I

.field private final c:Lcom/google/android/gms/internal/zzchm;

.field private final d:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzcla;ILcom/google/android/gms/internal/zzchm;Landroid/content/Intent;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzclb;->a:Lcom/google/android/gms/internal/zzcla;

    iput p2, p0, Lcom/google/android/gms/internal/zzclb;->b:I

    iput-object p3, p0, Lcom/google/android/gms/internal/zzclb;->c:Lcom/google/android/gms/internal/zzchm;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzclb;->d:Landroid/content/Intent;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzclb;->a:Lcom/google/android/gms/internal/zzcla;

    iget v1, p0, Lcom/google/android/gms/internal/zzclb;->b:I

    iget-object v2, p0, Lcom/google/android/gms/internal/zzclb;->c:Lcom/google/android/gms/internal/zzchm;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzclb;->d:Landroid/content/Intent;

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzcla;->a(ILcom/google/android/gms/internal/zzchm;Landroid/content/Intent;)V

    return-void
.end method
