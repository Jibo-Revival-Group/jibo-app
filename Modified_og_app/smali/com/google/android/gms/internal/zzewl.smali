.class public final enum Lcom/google/android/gms/internal/zzewl;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/android/gms/internal/zzewl;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum zzoen:Lcom/google/android/gms/internal/zzewl;

.field public static final enum zzoeo:Lcom/google/android/gms/internal/zzewl;

.field public static final enum zzoep:Lcom/google/android/gms/internal/zzewl;

.field private static final synthetic zzoeq:[Lcom/google/android/gms/internal/zzewl;


# instance fields
.field private mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/google/android/gms/internal/zzewl;

    const-string v1, "TRACE_EVENT_RATE_LIMITED"

    const-string v2, "_fstec"

    invoke-direct {v0, v1, v3, v2}, Lcom/google/android/gms/internal/zzewl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewl;->zzoen:Lcom/google/android/gms/internal/zzewl;

    new-instance v0, Lcom/google/android/gms/internal/zzewl;

    const-string v1, "NETWORK_TRACE_EVENT_RATE_LIMITED"

    const-string v2, "_fsntc"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/android/gms/internal/zzewl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewl;->zzoeo:Lcom/google/android/gms/internal/zzewl;

    new-instance v0, Lcom/google/android/gms/internal/zzewl;

    const-string v1, "TRACE_STARTED_NOT_STOPPED"

    const-string v2, "_tsns"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/android/gms/internal/zzewl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewl;->zzoep:Lcom/google/android/gms/internal/zzewl;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/google/android/gms/internal/zzewl;

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoen:Lcom/google/android/gms/internal/zzewl;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoeo:Lcom/google/android/gms/internal/zzewl;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/android/gms/internal/zzewl;->zzoep:Lcom/google/android/gms/internal/zzewl;

    aput-object v1, v0, v5

    sput-object v0, Lcom/google/android/gms/internal/zzewl;->zzoeq:[Lcom/google/android/gms/internal/zzewl;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/google/android/gms/internal/zzewl;->mName:Ljava/lang/String;

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/zzewl;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/zzewl;->zzoeq:[Lcom/google/android/gms/internal/zzewl;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/zzewl;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/zzewl;

    return-object v0
.end method


# virtual methods
.method public final toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewl;->mName:Ljava/lang/String;

    return-object v0
.end method
