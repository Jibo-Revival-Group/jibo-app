.class public final Lcom/google/android/gms/internal/zzcup;
.super Ljava/lang/Object;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Landroid/net/Uri;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final e:Z

.field private final f:Z


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 7

    const/4 v5, 0x0

    const/4 v1, 0x0

    const-string v3, ""

    const-string v4, ""

    move-object v0, p0

    move-object v2, p1

    move v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzcup;-><init>(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZ)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzcup;->a:Ljava/lang/String;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzcup;->b:Landroid/net/Uri;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzcup;->c:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzcup;->d:Ljava/lang/String;

    iput-boolean p5, p0, Lcom/google/android/gms/internal/zzcup;->e:Z

    iput-boolean p6, p0, Lcom/google/android/gms/internal/zzcup;->f:Z

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/zzcup;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcup;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/google/android/gms/internal/zzcup;)Landroid/net/Uri;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcup;->b:Landroid/net/Uri;

    return-object v0
.end method

.method static synthetic c(Lcom/google/android/gms/internal/zzcup;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcup;->c:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/google/android/gms/internal/zzcup;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcup;->d:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lcom/google/android/gms/internal/zzcup;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcup;->f:Z

    return v0
.end method

.method static synthetic f(Lcom/google/android/gms/internal/zzcup;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcup;->e:Z

    return v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcui;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/internal/zzcui",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/google/android/gms/internal/zzcui;->a(Lcom/google/android/gms/internal/zzcup;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/zzcui;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcup;
    .locals 7

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzcup;->e:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot set GServices prefix and skip GServices"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/zzcup;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcup;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcup;->b:Landroid/net/Uri;

    iget-object v4, p0, Lcom/google/android/gms/internal/zzcup;->d:Ljava/lang/String;

    iget-boolean v5, p0, Lcom/google/android/gms/internal/zzcup;->e:Z

    iget-boolean v6, p0, Lcom/google/android/gms/internal/zzcup;->f:Z

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzcup;-><init>(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZ)V

    return-object v0
.end method

.method public final b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzcup;
    .locals 7

    new-instance v0, Lcom/google/android/gms/internal/zzcup;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzcup;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzcup;->b:Landroid/net/Uri;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzcup;->c:Ljava/lang/String;

    iget-boolean v5, p0, Lcom/google/android/gms/internal/zzcup;->e:Z

    iget-boolean v6, p0, Lcom/google/android/gms/internal/zzcup;->f:Z

    move-object v4, p1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzcup;-><init>(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZ)V

    return-object v0
.end method
