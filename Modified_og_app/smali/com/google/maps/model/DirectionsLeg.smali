.class public Lcom/google/maps/model/DirectionsLeg;
.super Ljava/lang/Object;
.source "DirectionsLeg.java"


# instance fields
.field public arrivalTime:Lorg/joda/time/DateTime;

.field public departureTime:Lorg/joda/time/DateTime;

.field public distance:Lcom/google/maps/model/Distance;

.field public duration:Lcom/google/maps/model/Duration;

.field public durationInTraffic:Lcom/google/maps/model/Duration;

.field public endAddress:Ljava/lang/String;

.field public endLocation:Lcom/google/maps/model/LatLng;

.field public startAddress:Ljava/lang/String;

.field public startLocation:Lcom/google/maps/model/LatLng;

.field public steps:[Lcom/google/maps/model/DirectionsStep;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
