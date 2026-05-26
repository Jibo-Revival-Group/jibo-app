.class public final Lcom/google/android/gms/common/api/internal/zzt;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# instance fields
.field public final a:Lcom/google/android/gms/common/api/Api;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/Api",
            "<*>;"
        }
    .end annotation
.end field

.field private final b:Z

.field private c:Lcom/google/android/gms/common/api/internal/zzu;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/api/Api;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/Api",
            "<*>;Z)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zzt;->a:Lcom/google/android/gms/common/api/Api;

    iput-boolean p2, p0, Lcom/google/android/gms/common/api/internal/zzt;->b:Z

    return-void
.end method

.method private final a()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zzt;->c:Lcom/google/android/gms/common/api/internal/zzu;

    const-string v1, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client."

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zzt;->a()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zzt;->c:Lcom/google/android/gms/common/api/internal/zzu;

    invoke-interface {v0, p1}, Lcom/google/android/gms/common/api/internal/zzu;->a(I)V

    return-void
.end method

.method public final a(Landroid/os/Bundle;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zzt;->a()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zzt;->c:Lcom/google/android/gms/common/api/internal/zzu;

    invoke-interface {v0, p1}, Lcom/google/android/gms/common/api/internal/zzu;->a(Landroid/os/Bundle;)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 3

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zzt;->a()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zzt;->c:Lcom/google/android/gms/common/api/internal/zzu;

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zzt;->a:Lcom/google/android/gms/common/api/Api;

    iget-boolean v2, p0, Lcom/google/android/gms/common/api/internal/zzt;->b:Z

    invoke-interface {v0, p1, v1, v2}, Lcom/google/android/gms/common/api/internal/zzu;->a(Lcom/google/android/gms/common/ConnectionResult;Lcom/google/android/gms/common/api/Api;Z)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/common/api/internal/zzu;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zzt;->c:Lcom/google/android/gms/common/api/internal/zzu;

    return-void
.end method
