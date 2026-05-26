.class public Lcom/google/maps/model/GeolocationPayload;
.super Ljava/lang/Object;
.source "GeolocationPayload.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    }
.end annotation


# instance fields
.field public carrier:Ljava/lang/String;

.field public cellTowers:[Lcom/google/maps/model/CellTower;

.field public considerIp:Ljava/lang/Boolean;

.field public homeMobileCountryCode:Ljava/lang/Integer;

.field public homeMobileNetworkCode:Ljava/lang/Integer;

.field public radioType:Ljava/lang/String;

.field public wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileCountryCode:Ljava/lang/Integer;

    .line 55
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileNetworkCode:Ljava/lang/Integer;

    .line 61
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->radioType:Ljava/lang/String;

    .line 63
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->carrier:Ljava/lang/String;

    .line 69
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->considerIp:Ljava/lang/Boolean;

    .line 33
    return-void
.end method

.method private constructor <init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[Lcom/google/maps/model/CellTower;[Lcom/google/maps/model/WifiAccessPoint;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileCountryCode:Ljava/lang/Integer;

    .line 55
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileNetworkCode:Ljava/lang/Integer;

    .line 61
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->radioType:Ljava/lang/String;

    .line 63
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->carrier:Ljava/lang/String;

    .line 69
    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload;->considerIp:Ljava/lang/Boolean;

    .line 44
    iput-object p1, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileCountryCode:Ljava/lang/Integer;

    .line 45
    iput-object p2, p0, Lcom/google/maps/model/GeolocationPayload;->homeMobileNetworkCode:Ljava/lang/Integer;

    .line 46
    iput-object p3, p0, Lcom/google/maps/model/GeolocationPayload;->radioType:Ljava/lang/String;

    .line 47
    iput-object p4, p0, Lcom/google/maps/model/GeolocationPayload;->carrier:Ljava/lang/String;

    .line 48
    iput-object p5, p0, Lcom/google/maps/model/GeolocationPayload;->considerIp:Ljava/lang/Boolean;

    .line 49
    iput-object p6, p0, Lcom/google/maps/model/GeolocationPayload;->cellTowers:[Lcom/google/maps/model/CellTower;

    .line 50
    iput-object p7, p0, Lcom/google/maps/model/GeolocationPayload;->wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    .line 51
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[Lcom/google/maps/model/CellTower;[Lcom/google/maps/model/WifiAccessPoint;Lcom/google/maps/model/GeolocationPayload$1;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct/range {p0 .. p7}, Lcom/google/maps/model/GeolocationPayload;-><init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[Lcom/google/maps/model/CellTower;[Lcom/google/maps/model/WifiAccessPoint;)V

    return-void
.end method
