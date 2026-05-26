.class public Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
.super Ljava/lang/Object;
.source "GeolocationPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/GeolocationPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GeolocationPayloadBuilder"
.end annotation


# instance fields
.field private _addedCellTowers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/CellTower;",
            ">;"
        }
    .end annotation
.end field

.field private _addedWifiAccessPoints:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/WifiAccessPoint;",
            ">;"
        }
    .end annotation
.end field

.field private _carrier:Ljava/lang/String;

.field private _cellTowers:[Lcom/google/maps/model/CellTower;

.field private _considerIp:Ljava/lang/Boolean;

.field private _homeMobileCountryCode:Ljava/lang/Integer;

.field private _homeMobileNetworkCode:Ljava/lang/Integer;

.field private _radioType:Ljava/lang/String;

.field private _wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileCountryCode:Ljava/lang/Integer;

    .line 77
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileNetworkCode:Ljava/lang/Integer;

    .line 78
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_radioType:Ljava/lang/String;

    .line 79
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_carrier:Ljava/lang/String;

    .line 80
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_considerIp:Ljava/lang/Boolean;

    .line 81
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_cellTowers:[Lcom/google/maps/model/CellTower;

    .line 82
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedCellTowers:Ljava/util/List;

    .line 83
    iput-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    .line 84
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedWifiAccessPoints:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public AddCellTower(Lcom/google/maps/model/CellTower;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedCellTowers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    return-object p0
.end method

.method public AddWifiAccessPoint(Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedWifiAccessPoints:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 150
    return-object p0
.end method

.method public Carrier(Ljava/lang/String;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_carrier:Ljava/lang/String;

    .line 125
    return-object p0
.end method

.method public CellTowers([Lcom/google/maps/model/CellTower;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_cellTowers:[Lcom/google/maps/model/CellTower;

    .line 135
    return-object p0
.end method

.method public ConsiderIp(Z)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 1

    .prologue
    .line 129
    new-instance v0, Ljava/lang/Boolean;

    invoke-direct {v0, p1}, Ljava/lang/Boolean;-><init>(Z)V

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_considerIp:Ljava/lang/Boolean;

    .line 130
    return-object p0
.end method

.method public HomeMobileCountryCode(I)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 1

    .prologue
    .line 109
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileCountryCode:Ljava/lang/Integer;

    .line 110
    return-object p0
.end method

.method public HomeMobileNetworkCode(I)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 1

    .prologue
    .line 114
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileNetworkCode:Ljava/lang/Integer;

    .line 115
    return-object p0
.end method

.method public RadioType(Ljava/lang/String;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 0

    .prologue
    .line 119
    iput-object p1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_radioType:Ljava/lang/String;

    .line 120
    return-object p0
.end method

.method public WifiAccessPoints([Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    .line 145
    return-object p0
.end method

.method public createGeolocationPayload()Lcom/google/maps/model/GeolocationPayload;
    .locals 9

    .prologue
    const/4 v2, 0x0

    .line 88
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedWifiAccessPoints:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 90
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedWifiAccessPoints:Ljava/util/List;

    new-array v1, v2, [Lcom/google/maps/model/WifiAccessPoint;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/WifiAccessPoint;

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    .line 94
    :cond_0
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedCellTowers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 95
    iget-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_addedCellTowers:Ljava/util/List;

    new-array v1, v2, [Lcom/google/maps/model/CellTower;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/CellTower;

    iput-object v0, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_cellTowers:[Lcom/google/maps/model/CellTower;

    .line 98
    :cond_1
    new-instance v0, Lcom/google/maps/model/GeolocationPayload;

    iget-object v1, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileCountryCode:Ljava/lang/Integer;

    iget-object v2, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_homeMobileNetworkCode:Ljava/lang/Integer;

    iget-object v3, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_radioType:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_carrier:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_considerIp:Ljava/lang/Boolean;

    iget-object v6, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_cellTowers:[Lcom/google/maps/model/CellTower;

    iget-object v7, p0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->_wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/google/maps/model/GeolocationPayload;-><init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[Lcom/google/maps/model/CellTower;[Lcom/google/maps/model/WifiAccessPoint;Lcom/google/maps/model/GeolocationPayload$1;)V

    return-object v0
.end method
