.class public Lcom/google/maps/model/SnappedPoint;
.super Ljava/lang/Object;
.source "SnappedPoint.java"


# instance fields
.field public location:Lcom/google/maps/model/LatLng;

.field public originalIndex:I

.field public placeId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    const/4 v0, -0x1

    iput v0, p0, Lcom/google/maps/model/SnappedPoint;->originalIndex:I

    return-void
.end method
