.class public Lcom/google/maps/model/TransitDetails;
.super Ljava/lang/Object;
.source "TransitDetails.java"


# instance fields
.field public arrivalStop:Lcom/google/maps/model/StopDetails;

.field public arrivalTime:Lorg/joda/time/DateTime;

.field public departureStop:Lcom/google/maps/model/StopDetails;

.field public departureTime:Lorg/joda/time/DateTime;

.field public headsign:Ljava/lang/String;

.field public headway:J

.field public line:Lcom/google/maps/model/TransitLine;

.field public numStops:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
