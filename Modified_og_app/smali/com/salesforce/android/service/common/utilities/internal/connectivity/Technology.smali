.class public final enum Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;
.super Ljava/lang/Enum;
.source "Technology.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

.field public static final enum RADIO:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

.field public static final enum WIFI:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;


# instance fields
.field private final mType:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 37
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    const-string v1, "WIFI"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->WIFI:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    .line 38
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    const-string v1, "RADIO"

    invoke-direct {v0, v1, v3, v2}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->RADIO:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    .line 35
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->WIFI:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->RADIO:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    aput-object v1, v0, v3

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput p3, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->mType:I

    .line 44
    return-void
.end method

.method static fromType(I)Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;
    .locals 5

    .prologue
    .line 47
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->values()[Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 48
    iget v4, v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->mType:I

    if-ne v4, p0, :cond_0

    .line 52
    :goto_1
    return-object v0

    .line 47
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 52
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->WIFI:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    invoke-virtual {v0}, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    return-object v0
.end method
