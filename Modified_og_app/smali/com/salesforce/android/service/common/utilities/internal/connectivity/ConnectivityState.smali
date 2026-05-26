.class public final enum Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;
.super Ljava/lang/Enum;
.source "ConnectivityState.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

.field public static final enum CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

.field public static final enum DISCONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

.field public static final enum SWITCHING:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

.field public static final enum UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 32
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 33
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    const-string v1, "CONNECTED"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 34
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    const-string v1, "SWITCHING"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->SWITCHING:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 35
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    const-string v1, "DISCONNECTED"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->DISCONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 31
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->SWITCHING:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->DISCONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    invoke-virtual {v0}, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    return-object v0
.end method
