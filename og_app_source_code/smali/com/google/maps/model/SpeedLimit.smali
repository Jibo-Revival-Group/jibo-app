.class public Lcom/google/maps/model/SpeedLimit;
.super Ljava/lang/Object;
.source "SpeedLimit.java"


# instance fields
.field public placeId:Ljava/lang/String;

.field public speedLimit:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public speedLimitMph()J
    .locals 4

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/google/maps/model/SpeedLimit;->speedLimit:D

    const-wide v2, 0x3fe3e2456f75d9a1L    # 0.621371

    mul-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    return-wide v0
.end method
