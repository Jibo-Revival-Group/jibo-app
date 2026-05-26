.class public Lcom/google/maps/model/WifiAccessPoint;
.super Ljava/lang/Object;
.source "WifiAccessPoint.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/WifiAccessPoint$WifiAccessPointBuilder;
    }
.end annotation


# instance fields
.field public age:Ljava/lang/Integer;

.field public channel:Ljava/lang/Integer;

.field public macAddress:Ljava/lang/String;

.field public signalStrength:Ljava/lang/Integer;

.field public signalToNoiseRatio:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->signalStrength:Ljava/lang/Integer;

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->age:Ljava/lang/Integer;

    .line 55
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->channel:Ljava/lang/Integer;

    .line 57
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->signalToNoiseRatio:Ljava/lang/Integer;

    .line 29
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->signalStrength:Ljava/lang/Integer;

    .line 53
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->age:Ljava/lang/Integer;

    .line 55
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->channel:Ljava/lang/Integer;

    .line 57
    iput-object v0, p0, Lcom/google/maps/model/WifiAccessPoint;->signalToNoiseRatio:Ljava/lang/Integer;

    .line 38
    iput-object p1, p0, Lcom/google/maps/model/WifiAccessPoint;->macAddress:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/google/maps/model/WifiAccessPoint;->signalStrength:Ljava/lang/Integer;

    .line 40
    iput-object p3, p0, Lcom/google/maps/model/WifiAccessPoint;->age:Ljava/lang/Integer;

    .line 41
    iput-object p4, p0, Lcom/google/maps/model/WifiAccessPoint;->channel:Ljava/lang/Integer;

    .line 42
    iput-object p5, p0, Lcom/google/maps/model/WifiAccessPoint;->signalToNoiseRatio:Ljava/lang/Integer;

    .line 43
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/maps/model/WifiAccessPoint$1;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct/range {p0 .. p5}, Lcom/google/maps/model/WifiAccessPoint;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V

    return-void
.end method
