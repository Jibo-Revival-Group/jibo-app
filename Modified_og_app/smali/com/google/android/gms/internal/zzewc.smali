.class final Lcom/google/android/gms/internal/zzewc;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/google/android/gms/internal/zzewv;

.field private synthetic b:I

.field private synthetic c:Lcom/google/android/gms/internal/zzevz;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewv;I)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzewc;->c:Lcom/google/android/gms/internal/zzevz;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzewc;->a:Lcom/google/android/gms/internal/zzewv;

    iput p3, p0, Lcom/google/android/gms/internal/zzewc;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewc;->c:Lcom/google/android/gms/internal/zzevz;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzewc;->a:Lcom/google/android/gms/internal/zzewv;

    iget v2, p0, Lcom/google/android/gms/internal/zzewc;->b:I

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewv;I)V

    return-void
.end method
