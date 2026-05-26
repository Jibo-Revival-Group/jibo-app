.class final enum Lcom/google/android/gms/internal/zzewi;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/android/gms/internal/zzewi;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum zzoco:Lcom/google/android/gms/internal/zzewi;

.field public static final enum zzocp:Lcom/google/android/gms/internal/zzewi;

.field private static final synthetic zzocu:[Lcom/google/android/gms/internal/zzewi;


# instance fields
.field private final prefix:Ljava/lang/String;

.field private final zzocq:I

.field private final zzocr:I

.field private final zzocs:I

.field private final zzoct:I


# direct methods
.method static constructor <clinit>()V
    .locals 14

    const/4 v13, 0x1

    const/4 v2, 0x0

    const/16 v4, 0xa

    new-instance v0, Lcom/google/android/gms/internal/zzewi;

    const-string v1, "NETWORK"

    const-string v3, "network"

    const/16 v5, 0x2bc

    const/16 v7, 0x46

    move v6, v4

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/internal/zzewi;-><init>(Ljava/lang/String;ILjava/lang/String;IIII)V

    sput-object v0, Lcom/google/android/gms/internal/zzewi;->zzoco:Lcom/google/android/gms/internal/zzewi;

    new-instance v5, Lcom/google/android/gms/internal/zzewi;

    const-string v6, "TRACE"

    const-string v8, "trace"

    const/16 v10, 0x12c

    const/16 v12, 0x1e

    move v7, v13

    move v9, v4

    move v11, v4

    invoke-direct/range {v5 .. v12}, Lcom/google/android/gms/internal/zzewi;-><init>(Ljava/lang/String;ILjava/lang/String;IIII)V

    sput-object v5, Lcom/google/android/gms/internal/zzewi;->zzocp:Lcom/google/android/gms/internal/zzewi;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/google/android/gms/internal/zzewi;

    sget-object v1, Lcom/google/android/gms/internal/zzewi;->zzoco:Lcom/google/android/gms/internal/zzewi;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/android/gms/internal/zzewi;->zzocp:Lcom/google/android/gms/internal/zzewi;

    aput-object v1, v0, v13

    sput-object v0, Lcom/google/android/gms/internal/zzewi;->zzocu:[Lcom/google/android/gms/internal/zzewi;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;IIII)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "IIII)V"
        }
    .end annotation

    const/16 v0, 0xa

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/google/android/gms/internal/zzewi;->prefix:Ljava/lang/String;

    iput v0, p0, Lcom/google/android/gms/internal/zzewi;->zzocq:I

    iput p5, p0, Lcom/google/android/gms/internal/zzewi;->zzocr:I

    iput v0, p0, Lcom/google/android/gms/internal/zzewi;->zzocs:I

    iput p7, p0, Lcom/google/android/gms/internal/zzewi;->zzoct:I

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/zzewi;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/zzewi;->zzocu:[Lcom/google/android/gms/internal/zzewi;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/zzewi;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/zzewi;

    return-object v0
.end method


# virtual methods
.method public final toString()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzewi;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final zzckf()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzewi;->zzocq:I

    return v0
.end method

.method public final zzckg()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzewi;->zzocr:I

    return v0
.end method

.method public final zzckh()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzewi;->zzocs:I

    return v0
.end method

.method public final zzcki()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzewi;->zzoct:I

    return v0
.end method

.method public final zzckj()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewi;->prefix:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_flimit_time"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final zzckk()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewi;->prefix:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_flimit_events"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final zzckl()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewi;->prefix:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_blimit_time"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final zzckm()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewi;->prefix:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_blimit_events"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
