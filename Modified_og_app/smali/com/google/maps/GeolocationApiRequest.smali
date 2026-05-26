.class public Lcom/google/maps/GeolocationApiRequest;
.super Lcom/google/maps/PendingResultBase;
.source "GeolocationApiRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/GeolocationResult;",
        "Lcom/google/maps/GeolocationApiRequest;",
        "Lcom/google/maps/GeolocationApi$Response;",
        ">;"
    }
.end annotation


# instance fields
.field private builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

.field private payload:Lcom/google/maps/model/GeolocationPayload;


# direct methods
.method constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 33
    sget-object v0, Lcom/google/maps/GeolocationApi;->GEOLOCATION_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/GeolocationApi$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 29
    iput-object v2, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    .line 30
    iput-object v2, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 34
    new-instance v0, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-direct {v0}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;-><init>()V

    iput-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 35
    return-void
.end method


# virtual methods
.method public AddCellTower(Lcom/google/maps/model/CellTower;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->AddCellTower(Lcom/google/maps/model/CellTower;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 79
    return-object p0
.end method

.method public AddWifiAccessPoint(Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->AddWifiAccessPoint(Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 89
    return-object p0
.end method

.method public Carrier(Ljava/lang/String;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->Carrier(Ljava/lang/String;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 64
    return-object p0
.end method

.method public CellTowers([Lcom/google/maps/model/CellTower;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->CellTowers([Lcom/google/maps/model/CellTower;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 74
    return-object p0
.end method

.method public ConsiderIp(Z)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->ConsiderIp(Z)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 69
    return-object p0
.end method

.method public CreatePayload()Lcom/google/maps/GeolocationApiRequest;
    .locals 2

    .prologue
    .line 98
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->createGeolocationPayload()Lcom/google/maps/model/GeolocationPayload;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    .line 104
    :cond_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 105
    iget-object v1, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    invoke-virtual {v0, v1}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 106
    const-string v1, "_payload"

    invoke-virtual {p0, v1, v0}, Lcom/google/maps/GeolocationApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeolocationApiRequest;

    return-object v0
.end method

.method public HomeMobileCountryCode(I)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->HomeMobileCountryCode(I)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 49
    return-object p0
.end method

.method public HomeMobileNetworkCode(I)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->HomeMobileNetworkCode(I)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 54
    return-object p0
.end method

.method public Payload(Lcom/google/maps/model/GeolocationPayload;)Lcom/google/maps/GeolocationApiRequest;
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    .line 94
    return-object p0
.end method

.method public RadioType(Ljava/lang/String;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->RadioType(Ljava/lang/String;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 59
    return-object p0
.end method

.method public WifiAccessPoints([Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->builder:Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;->WifiAccessPoints([Lcom/google/maps/model/WifiAccessPoint;)Lcom/google/maps/model/GeolocationPayload$GeolocationPayloadBuilder;

    .line 84
    return-object p0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    iget-object v0, v0, Lcom/google/maps/model/GeolocationPayload;->considerIp:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    iget-object v0, v0, Lcom/google/maps/model/GeolocationPayload;->considerIp:Ljava/lang/Boolean;

    .line 40
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    iget-object v0, v0, Lcom/google/maps/model/GeolocationPayload;->wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/maps/GeolocationApiRequest;->payload:Lcom/google/maps/model/GeolocationPayload;

    iget-object v0, v0, Lcom/google/maps/model/GeolocationPayload;->wifiAccessPoints:[Lcom/google/maps/model/WifiAccessPoint;

    array-length v0, v0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain two or more \'Wifi Access Points\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    return-void
.end method
