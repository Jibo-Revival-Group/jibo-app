.class public Lcom/google/maps/model/DirectionsStep;
.super Ljava/lang/Object;
.source "DirectionsStep.java"


# instance fields
.field public distance:Lcom/google/maps/model/Distance;

.field public duration:Lcom/google/maps/model/Duration;

.field public endLocation:Lcom/google/maps/model/LatLng;

.field public htmlInstructions:Ljava/lang/String;

.field public maneuver:Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public polyline:Lcom/google/maps/model/EncodedPolyline;

.field public startLocation:Lcom/google/maps/model/LatLng;

.field public steps:[Lcom/google/maps/model/DirectionsStep;

.field public transitDetails:Lcom/google/maps/model/TransitDetails;

.field public travelMode:Lcom/google/maps/model/TravelMode;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
