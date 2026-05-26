.class public Lcom/google/maps/model/CellTower;
.super Ljava/lang/Object;
.source "CellTower.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/CellTower$CellTowerBuilder;
    }
.end annotation


# instance fields
.field public age:Ljava/lang/Integer;

.field public cellId:Ljava/lang/Integer;

.field public locationAreaCode:Ljava/lang/Integer;

.field public mobileCountryCode:Ljava/lang/Integer;

.field public mobileNetworkCode:Ljava/lang/Integer;

.field public signalStrength:Ljava/lang/Integer;

.field public timingAdvance:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->cellId:Ljava/lang/Integer;

    .line 58
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->locationAreaCode:Ljava/lang/Integer;

    .line 60
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->mobileCountryCode:Ljava/lang/Integer;

    .line 65
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->mobileNetworkCode:Ljava/lang/Integer;

    .line 71
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->age:Ljava/lang/Integer;

    .line 73
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->signalStrength:Ljava/lang/Integer;

    .line 75
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->timingAdvance:Ljava/lang/Integer;

    .line 28
    return-void
.end method

.method private constructor <init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->cellId:Ljava/lang/Integer;

    .line 58
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->locationAreaCode:Ljava/lang/Integer;

    .line 60
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->mobileCountryCode:Ljava/lang/Integer;

    .line 65
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->mobileNetworkCode:Ljava/lang/Integer;

    .line 71
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->age:Ljava/lang/Integer;

    .line 73
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->signalStrength:Ljava/lang/Integer;

    .line 75
    iput-object v0, p0, Lcom/google/maps/model/CellTower;->timingAdvance:Ljava/lang/Integer;

    .line 39
    iput-object p1, p0, Lcom/google/maps/model/CellTower;->cellId:Ljava/lang/Integer;

    .line 40
    iput-object p2, p0, Lcom/google/maps/model/CellTower;->locationAreaCode:Ljava/lang/Integer;

    .line 41
    iput-object p3, p0, Lcom/google/maps/model/CellTower;->mobileCountryCode:Ljava/lang/Integer;

    .line 42
    iput-object p4, p0, Lcom/google/maps/model/CellTower;->mobileNetworkCode:Ljava/lang/Integer;

    .line 43
    iput-object p5, p0, Lcom/google/maps/model/CellTower;->age:Ljava/lang/Integer;

    .line 44
    iput-object p6, p0, Lcom/google/maps/model/CellTower;->signalStrength:Ljava/lang/Integer;

    .line 45
    iput-object p7, p0, Lcom/google/maps/model/CellTower;->timingAdvance:Ljava/lang/Integer;

    .line 46
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/maps/model/CellTower$1;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct/range {p0 .. p7}, Lcom/google/maps/model/CellTower;-><init>(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V

    return-void
.end method
