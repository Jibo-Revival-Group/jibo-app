.class public final enum Lcom/google/maps/model/GeocodedWaypointStatus;
.super Ljava/lang/Enum;
.source "GeocodedWaypointStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/GeocodedWaypointStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/GeocodedWaypointStatus;

.field public static final enum OK:Lcom/google/maps/model/GeocodedWaypointStatus;

.field public static final enum ZERO_RESULTS:Lcom/google/maps/model/GeocodedWaypointStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 26
    new-instance v0, Lcom/google/maps/model/GeocodedWaypointStatus;

    const-string v1, "OK"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/GeocodedWaypointStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/GeocodedWaypointStatus;->OK:Lcom/google/maps/model/GeocodedWaypointStatus;

    .line 29
    new-instance v0, Lcom/google/maps/model/GeocodedWaypointStatus;

    const-string v1, "ZERO_RESULTS"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/GeocodedWaypointStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/GeocodedWaypointStatus;->ZERO_RESULTS:Lcom/google/maps/model/GeocodedWaypointStatus;

    .line 24
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/google/maps/model/GeocodedWaypointStatus;

    sget-object v1, Lcom/google/maps/model/GeocodedWaypointStatus;->OK:Lcom/google/maps/model/GeocodedWaypointStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/GeocodedWaypointStatus;->ZERO_RESULTS:Lcom/google/maps/model/GeocodedWaypointStatus;

    aput-object v1, v0, v3

    sput-object v0, Lcom/google/maps/model/GeocodedWaypointStatus;->$VALUES:[Lcom/google/maps/model/GeocodedWaypointStatus;

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

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/GeocodedWaypointStatus;
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/google/maps/model/GeocodedWaypointStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/GeocodedWaypointStatus;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/GeocodedWaypointStatus;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/google/maps/model/GeocodedWaypointStatus;->$VALUES:[Lcom/google/maps/model/GeocodedWaypointStatus;

    invoke-virtual {v0}, [Lcom/google/maps/model/GeocodedWaypointStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/GeocodedWaypointStatus;

    return-object v0
.end method
