.class public final enum Lcom/google/android/gms/internal/zzewm;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/android/gms/internal/zzewm;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum zzoer:Lcom/google/android/gms/internal/zzewm;

.field public static final enum zzoes:Lcom/google/android/gms/internal/zzewm;

.field public static final enum zzoet:Lcom/google/android/gms/internal/zzewm;

.field public static final enum zzoeu:Lcom/google/android/gms/internal/zzewm;

.field public static final enum zzoev:Lcom/google/android/gms/internal/zzewm;

.field public static final enum zzoew:Lcom/google/android/gms/internal/zzewm;

.field private static final synthetic zzoex:[Lcom/google/android/gms/internal/zzewm;


# instance fields
.field private mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "APP_START_TRACE_NAME"

    const-string v2, "_as"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoer:Lcom/google/android/gms/internal/zzewm;

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "ON_CREATE_TRACE_NAME"

    const-string v2, "_astui"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoes:Lcom/google/android/gms/internal/zzewm;

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "ON_START_TRACE_NAME"

    const-string v2, "_astfd"

    invoke-direct {v0, v1, v6, v2}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoet:Lcom/google/android/gms/internal/zzewm;

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "ON_RESUME_TRACE_NAME"

    const-string v2, "_asti"

    invoke-direct {v0, v1, v7, v2}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoeu:Lcom/google/android/gms/internal/zzewm;

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "FOREGROUND_TRACE_NAME"

    const-string v2, "_fs"

    invoke-direct {v0, v1, v8, v2}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoev:Lcom/google/android/gms/internal/zzewm;

    new-instance v0, Lcom/google/android/gms/internal/zzewm;

    const-string v1, "BACKGROUND_TRACE_NAME"

    const/4 v2, 0x5

    const-string v3, "_bs"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzewm;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoew:Lcom/google/android/gms/internal/zzewm;

    const/4 v0, 0x6

    new-array v0, v0, [Lcom/google/android/gms/internal/zzewm;

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoer:Lcom/google/android/gms/internal/zzewm;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoes:Lcom/google/android/gms/internal/zzewm;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoet:Lcom/google/android/gms/internal/zzewm;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoeu:Lcom/google/android/gms/internal/zzewm;

    aput-object v1, v0, v7

    sget-object v1, Lcom/google/android/gms/internal/zzewm;->zzoev:Lcom/google/android/gms/internal/zzewm;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/google/android/gms/internal/zzewm;->zzoew:Lcom/google/android/gms/internal/zzewm;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gms/internal/zzewm;->zzoex:[Lcom/google/android/gms/internal/zzewm;

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

    iput-object p3, p0, Lcom/google/android/gms/internal/zzewm;->mName:Ljava/lang/String;

    return-void
.end method

.method public static values()[Lcom/google/android/gms/internal/zzewm;
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/zzewm;->zzoex:[Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v0}, [Lcom/google/android/gms/internal/zzewm;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/internal/zzewm;

    return-object v0
.end method


# virtual methods
.method public final toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewm;->mName:Ljava/lang/String;

    return-object v0
.end method
