.class public final enum Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;
.super Ljava/lang/Enum;
.source "RadioType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum CDMA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum EDGE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum EHRPD:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum EVDO_0:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum EVDO_A:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum EVDO_B:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum GPRS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum HSDPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum HSPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum HSPAP:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum HSUPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum IDEN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum LTE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum RTT:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum UMTS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field public static final enum UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;


# instance fields
.field private final mIsFastConnection:Z

.field private final mRadioName:Ljava/lang/String;

.field private final mType:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    .line 37
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "RTT"

    const/4 v2, 0x0

    const/4 v3, 0x7

    const-string v4, "1xRTT"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->RTT:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 38
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "CDMA"

    const/4 v2, 0x1

    const/4 v3, 0x4

    const-string v4, "CDMA"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->CDMA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 39
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "EDGE"

    const/4 v2, 0x2

    const/4 v3, 0x2

    const-string v4, "EDGE"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EDGE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 40
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "EHRPD"

    const/4 v2, 0x3

    const/16 v3, 0xe

    const-string v4, "EHRPD"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EHRPD:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 41
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "EVDO_0"

    const/4 v2, 0x4

    const/4 v3, 0x5

    const-string v4, "EVDO_0"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_0:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 42
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "EVDO_A"

    const/4 v2, 0x5

    const/4 v3, 0x6

    const-string v4, "EVDO_A"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_A:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 43
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "EVDO_B"

    const/4 v2, 0x6

    const/16 v3, 0xc

    const-string v4, "EVDO_B"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_B:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 44
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "GPRS"

    const/4 v2, 0x7

    const/4 v3, 0x1

    const-string v4, "GPRS"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->GPRS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 45
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "HSDPA"

    const/16 v2, 0x8

    const/16 v3, 0x8

    const-string v4, "HSDPA"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSDPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 46
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "HSPA"

    const/16 v2, 0x9

    const/16 v3, 0xa

    const-string v4, "HSPA"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 47
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "HSPAP"

    const/16 v2, 0xa

    const/16 v3, 0xf

    const-string v4, "HSPAP"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSPAP:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 48
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "HSUPA"

    const/16 v2, 0xb

    const/16 v3, 0x9

    const-string v4, "HSUPA"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSUPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 49
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "IDEN"

    const/16 v2, 0xc

    const/16 v3, 0xb

    const-string v4, "IDEN"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->IDEN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 50
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "LTE"

    const/16 v2, 0xd

    const/16 v3, 0xd

    const-string v4, "LTE"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->LTE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 51
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "UMTS"

    const/16 v2, 0xe

    const/4 v3, 0x3

    const-string v4, "UMTS"

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UMTS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 52
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const-string v1, "UNKNOWN"

    const/16 v2, 0xf

    const/4 v3, 0x0

    const-string v4, "UNKNOWN"

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;-><init>(Ljava/lang/String;IILjava/lang/String;Z)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 35
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    const/4 v1, 0x0

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->RTT:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->CDMA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EDGE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EHRPD:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_0:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_A:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->EVDO_B:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->GPRS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSDPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSPAP:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->HSUPA:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->IDEN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->LTE:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UMTS:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 59
    iput p3, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mType:I

    .line 60
    iput-object p4, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mRadioName:Ljava/lang/String;

    .line 61
    iput-boolean p5, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mIsFastConnection:Z

    .line 62
    return-void
.end method

.method static fromType(I)Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;
    .locals 5

    .prologue
    .line 77
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->values()[Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 78
    iget v4, v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mType:I

    if-ne v4, p0, :cond_0

    .line 82
    :goto_1
    return-object v0

    .line 77
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 82
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->$VALUES:[Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    invoke-virtual {v0}, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    return-object v0
.end method


# virtual methods
.method public getRadioName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mRadioName:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 65
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mType:I

    return v0
.end method

.method public isFastConnection()Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->mIsFastConnection:Z

    return v0
.end method
