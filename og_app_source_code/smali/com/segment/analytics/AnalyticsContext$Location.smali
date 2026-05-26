.class public Lcom/segment/analytics/AnalyticsContext$Location;
.super Lcom/segment/analytics/ValueMap;
.source "AnalyticsContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/AnalyticsContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Location"
.end annotation


# static fields
.field private static final LOCATION_LATITUDE_KEY:Ljava/lang/String; = "latitude"

.field private static final LOCATION_LONGITUDE_KEY:Ljava/lang/String; = "longitude"

.field private static final LOCATION_SPEED_KEY:Ljava/lang/String; = "speed"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 449
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

    return-void
.end method

.method private constructor <init>(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 453
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 454
    return-void
.end method


# virtual methods
.method public latitude()D
    .locals 4

    .prologue
    .line 468
    const-string v0, "latitude"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext$Location;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public longitude()D
    .locals 4

    .prologue
    .line 477
    const-string v0, "longitude"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext$Location;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public putLatitude(D)Lcom/segment/analytics/AnalyticsContext$Location;
    .locals 3

    .prologue
    .line 464
    const-string v0, "latitude"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext$Location;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Location;

    move-result-object v0

    return-object v0
.end method

.method public putLongitude(D)Lcom/segment/analytics/AnalyticsContext$Location;
    .locals 3

    .prologue
    .line 473
    const-string v0, "longitude"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext$Location;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Location;

    move-result-object v0

    return-object v0
.end method

.method public putSpeed(D)Lcom/segment/analytics/AnalyticsContext$Location;
    .locals 3

    .prologue
    .line 482
    const-string v0, "speed"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext$Location;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Location;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Location;
    .locals 0

    .prologue
    .line 458
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 459
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 442
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/AnalyticsContext$Location;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Location;

    move-result-object v0

    return-object v0
.end method

.method public speed()D
    .locals 4

    .prologue
    .line 486
    const-string v0, "speed"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext$Location;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method
