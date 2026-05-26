.class public final enum Lcom/google/maps/model/VehicleType;
.super Ljava/lang/Enum;
.source "VehicleType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/VehicleType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/VehicleType;

.field public static final enum BUS:Lcom/google/maps/model/VehicleType;

.field public static final enum CABLE_CAR:Lcom/google/maps/model/VehicleType;

.field public static final enum COMMUTER_TRAIN:Lcom/google/maps/model/VehicleType;

.field public static final enum FERRY:Lcom/google/maps/model/VehicleType;

.field public static final enum FUNICULAR:Lcom/google/maps/model/VehicleType;

.field public static final enum GONDOLA_LIFT:Lcom/google/maps/model/VehicleType;

.field public static final enum HEAVY_RAIL:Lcom/google/maps/model/VehicleType;

.field public static final enum HIGH_SPEED_TRAIN:Lcom/google/maps/model/VehicleType;

.field public static final enum INTERCITY_BUS:Lcom/google/maps/model/VehicleType;

.field public static final enum METRO_RAIL:Lcom/google/maps/model/VehicleType;

.field public static final enum MONORAIL:Lcom/google/maps/model/VehicleType;

.field public static final enum OTHER:Lcom/google/maps/model/VehicleType;

.field public static final enum RAIL:Lcom/google/maps/model/VehicleType;

.field public static final enum SHARE_TAXI:Lcom/google/maps/model/VehicleType;

.field public static final enum SUBWAY:Lcom/google/maps/model/VehicleType;

.field public static final enum TRAM:Lcom/google/maps/model/VehicleType;

.field public static final enum TROLLEYBUS:Lcom/google/maps/model/VehicleType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 27
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "RAIL"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->RAIL:Lcom/google/maps/model/VehicleType;

    .line 30
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "METRO_RAIL"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->METRO_RAIL:Lcom/google/maps/model/VehicleType;

    .line 33
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "SUBWAY"

    invoke-direct {v0, v1, v5}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->SUBWAY:Lcom/google/maps/model/VehicleType;

    .line 36
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "TRAM"

    invoke-direct {v0, v1, v6}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->TRAM:Lcom/google/maps/model/VehicleType;

    .line 39
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "MONORAIL"

    invoke-direct {v0, v1, v7}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->MONORAIL:Lcom/google/maps/model/VehicleType;

    .line 42
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "HEAVY_RAIL"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->HEAVY_RAIL:Lcom/google/maps/model/VehicleType;

    .line 45
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "COMMUTER_TRAIN"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->COMMUTER_TRAIN:Lcom/google/maps/model/VehicleType;

    .line 48
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "HIGH_SPEED_TRAIN"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->HIGH_SPEED_TRAIN:Lcom/google/maps/model/VehicleType;

    .line 51
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "BUS"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->BUS:Lcom/google/maps/model/VehicleType;

    .line 54
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "INTERCITY_BUS"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->INTERCITY_BUS:Lcom/google/maps/model/VehicleType;

    .line 57
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "TROLLEYBUS"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->TROLLEYBUS:Lcom/google/maps/model/VehicleType;

    .line 63
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "SHARE_TAXI"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->SHARE_TAXI:Lcom/google/maps/model/VehicleType;

    .line 66
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "FERRY"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->FERRY:Lcom/google/maps/model/VehicleType;

    .line 72
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "CABLE_CAR"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->CABLE_CAR:Lcom/google/maps/model/VehicleType;

    .line 75
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "GONDOLA_LIFT"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->GONDOLA_LIFT:Lcom/google/maps/model/VehicleType;

    .line 81
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "FUNICULAR"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->FUNICULAR:Lcom/google/maps/model/VehicleType;

    .line 84
    new-instance v0, Lcom/google/maps/model/VehicleType;

    const-string v1, "OTHER"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/VehicleType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/VehicleType;->OTHER:Lcom/google/maps/model/VehicleType;

    .line 24
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/google/maps/model/VehicleType;

    sget-object v1, Lcom/google/maps/model/VehicleType;->RAIL:Lcom/google/maps/model/VehicleType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/VehicleType;->METRO_RAIL:Lcom/google/maps/model/VehicleType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/VehicleType;->SUBWAY:Lcom/google/maps/model/VehicleType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/VehicleType;->TRAM:Lcom/google/maps/model/VehicleType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/VehicleType;->MONORAIL:Lcom/google/maps/model/VehicleType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/google/maps/model/VehicleType;->HEAVY_RAIL:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/google/maps/model/VehicleType;->COMMUTER_TRAIN:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/google/maps/model/VehicleType;->HIGH_SPEED_TRAIN:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/google/maps/model/VehicleType;->BUS:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/google/maps/model/VehicleType;->INTERCITY_BUS:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/google/maps/model/VehicleType;->TROLLEYBUS:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/google/maps/model/VehicleType;->SHARE_TAXI:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/google/maps/model/VehicleType;->FERRY:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/google/maps/model/VehicleType;->CABLE_CAR:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/google/maps/model/VehicleType;->GONDOLA_LIFT:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/google/maps/model/VehicleType;->FUNICULAR:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/google/maps/model/VehicleType;->OTHER:Lcom/google/maps/model/VehicleType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/maps/model/VehicleType;->$VALUES:[Lcom/google/maps/model/VehicleType;

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
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/VehicleType;
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/google/maps/model/VehicleType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/VehicleType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/VehicleType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/google/maps/model/VehicleType;->$VALUES:[Lcom/google/maps/model/VehicleType;

    invoke-virtual {v0}, [Lcom/google/maps/model/VehicleType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/VehicleType;

    return-object v0
.end method
