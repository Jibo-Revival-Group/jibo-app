.class public Lcom/google/maps/model/CellTower$CellTowerBuilder;
.super Ljava/lang/Object;
.source "CellTower.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/CellTower;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CellTowerBuilder"
.end annotation


# instance fields
.field private _age:Ljava/lang/Integer;

.field private _cellId:Ljava/lang/Integer;

.field private _locationAreaCode:Ljava/lang/Integer;

.field private _mobileCountryCode:Ljava/lang/Integer;

.field private _mobileNetworkCode:Ljava/lang/Integer;

.field private _signalStrength:Ljava/lang/Integer;

.field private _timingAdvance:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_cellId:Ljava/lang/Integer;

    .line 79
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_locationAreaCode:Ljava/lang/Integer;

    .line 80
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileCountryCode:Ljava/lang/Integer;

    .line 81
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileNetworkCode:Ljava/lang/Integer;

    .line 82
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_age:Ljava/lang/Integer;

    .line 83
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_signalStrength:Ljava/lang/Integer;

    .line 84
    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_timingAdvance:Ljava/lang/Integer;

    return-void
.end method


# virtual methods
.method public Age(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 119
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_age:Ljava/lang/Integer;

    .line 120
    return-object p0
.end method

.method public CellId(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 99
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_cellId:Ljava/lang/Integer;

    .line 100
    return-object p0
.end method

.method public LocationAreaCode(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 104
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_locationAreaCode:Ljava/lang/Integer;

    .line 105
    return-object p0
.end method

.method public MobileCountryCode(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 109
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileCountryCode:Ljava/lang/Integer;

    .line 110
    return-object p0
.end method

.method public MobileNetworkCode(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 114
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileNetworkCode:Ljava/lang/Integer;

    .line 115
    return-object p0
.end method

.method public SignalStrength(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 124
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_signalStrength:Ljava/lang/Integer;

    .line 125
    return-object p0
.end method

.method public TimingAdvance(I)Lcom/google/maps/model/CellTower$CellTowerBuilder;
    .locals 1

    .prologue
    .line 129
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p1}, Ljava/lang/Integer;-><init>(I)V

    iput-object v0, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_timingAdvance:Ljava/lang/Integer;

    .line 130
    return-object p0
.end method

.method public createCellTower()Lcom/google/maps/model/CellTower;
    .locals 9

    .prologue
    .line 88
    new-instance v0, Lcom/google/maps/model/CellTower;

    iget-object v1, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_cellId:Ljava/lang/Integer;

    iget-object v2, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_locationAreaCode:Ljava/lang/Integer;

    iget-object v3, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileCountryCode:Ljava/lang/Integer;

    iget-object v4, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_mobileNetworkCode:Ljava/lang/Integer;

    iget-object v5, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_age:Ljava/lang/Integer;

    iget-object v6, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_signalStrength:Ljava/lang/Integer;

    iget-object v7, p0, Lcom/google/maps/model/CellTower$CellTowerBuilder;->_timingAdvance:Ljava/lang/Integer;

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/google/maps/model/CellTower;-><init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/maps/model/CellTower$1;)V

    return-object v0
.end method
