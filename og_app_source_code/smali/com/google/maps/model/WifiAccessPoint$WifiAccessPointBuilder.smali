.class public Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
.super Ljava/lang/Object;
.source "WifiAccessPoint.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/WifiAccessPoint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WifiAccessPointBuilder"
.end annotation


# instance fields
.field private _age:Ljava/lang/Integer;

.field private _channel:Ljava/lang/Integer;

.field private _macAddress:Ljava/lang/String;

.field private _signalStrength:Ljava/lang/Integer;

.field private _signalToNoiseRatio:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_macAddress:Ljava/lang/String;

    .line 61
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalStrength:Ljava/lang/Integer;

    .line 62
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_age:Ljava/lang/Integer;

    .line 63
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_channel:Ljava/lang/Integer;

    .line 64
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalToNoiseRatio:Ljava/lang/Integer;

    return-void
.end method


# virtual methods
.method public Age(I)Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    .locals 1

    .prologue
    .line 82
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_age:Ljava/lang/Integer;

    .line 83
    return-object p0
.end method

.method public Channel(I)Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    .locals 1

    .prologue
    .line 87
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_channel:Ljava/lang/Integer;

    .line 88
    return-object p0
.end method

.method public MacAddress(Ljava/lang/String;)Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_macAddress:Ljava/lang/String;

    .line 73
    return-object p0
.end method

.method public SignalStrength(I)Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    .locals 1

    .prologue
    .line 77
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalStrength:Ljava/lang/Integer;

    .line 78
    return-object p0
.end method

.method public SignalToNoiseRatio(I)Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    .locals 1

    .prologue
    .line 92
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalToNoiseRatio:Ljava/lang/Integer;

    .line 93
    return-object p0
.end method

.method public createWifiAccessPoint()Lcom/google/maps/model/WifiAccessPoint;
    .locals 7

    .prologue
    .line 68
    new-instance v0, Lcom/google/maps/model/WifiAccessPoint;

    iget-object v1, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_macAddress:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalStrength:Ljava/lang/Integer;

    iget-object v3, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_age:Ljava/lang/Integer;

    iget-object v4, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_channel:Ljava/lang/Integer;

    iget-object v5, p0, Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;->_signalToNoiseRatio:Ljava/lang/Integer;

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v6}, Lcom/google/maps/model/WifiAccessPoint;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/maps/model/WifiAccessPoint$1;)V

    return-object v0
.end method
