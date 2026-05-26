.class public Lcom/google/maps/DistanceMatrixApiRequest;
.super Lcom/google/maps/PendingResultBase;
.source "DistanceMatrixApiRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/DistanceMatrix;",
        "Lcom/google/maps/DistanceMatrixApiRequest;",
        "Lcom/google/maps/DistanceMatrixApi$Response;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 36
    sget-object v0, Lcom/google/maps/DistanceMatrixApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/DistanceMatrixApi$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 37
    return-void
.end method


# virtual methods
.method public arrivalTime(Lorg/joda/time/ReadableInstant;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 6

    .prologue
    .line 183
    const-string v0, "arrival_time"

    invoke-interface {p1}, Lorg/joda/time/ReadableInstant;->c()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public avoid(Lcom/google/maps/DirectionsApi$RouteRestriction;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 124
    const-string v0, "avoid"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public departureTime(Lorg/joda/time/ReadableInstant;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 6

    .prologue
    .line 161
    const-string v0, "departure_time"

    invoke-interface {p1}, Lorg/joda/time/ReadableInstant;->c()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public varargs destinations([Lcom/google/maps/model/LatLng;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 93
    const-string v0, "destinations"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public varargs destinations([Ljava/lang/String;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 83
    const-string v0, "destinations"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public mode(Lcom/google/maps/model/TravelMode;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 106
    sget-object v0, Lcom/google/maps/model/TravelMode;->DRIVING:Lcom/google/maps/model/TravelMode;

    invoke-virtual {v0, p1}, Lcom/google/maps/model/TravelMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/maps/model/TravelMode;->WALKING:Lcom/google/maps/model/TravelMode;

    .line 107
    invoke-virtual {v0, p1}, Lcom/google/maps/model/TravelMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/maps/model/TravelMode;->BICYCLING:Lcom/google/maps/model/TravelMode;

    .line 108
    invoke-virtual {v0, p1}, Lcom/google/maps/model/TravelMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/maps/model/TravelMode;->TRANSIT:Lcom/google/maps/model/TravelMode;

    .line 109
    invoke-virtual {v0, p1}, Lcom/google/maps/model/TravelMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 110
    :cond_0
    const-string v0, "mode"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0

    .line 112
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Distance Matrix API travel modes must be Driving, Transit, Walking or Bicycling"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public varargs origins([Lcom/google/maps/model/LatLng;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 72
    const-string v0, "origins"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public varargs origins([Ljava/lang/String;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 62
    const-string v0, "origins"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public trafficModel(Lcom/google/maps/model/TrafficModel;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 172
    const-string v0, "traffic_model"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public varargs transitModes([Lcom/google/maps/model/TransitMode;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 2

    .prologue
    .line 194
    const-string v0, "transit_mode"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public transitRoutingPreference(Lcom/google/maps/model/TransitRoutingPreference;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 205
    const-string v0, "transit_routing_preference"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method public units(Lcom/google/maps/model/Unit;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 138
    const-string v0, "units"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DistanceMatrixApiRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 3

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "origins"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'origins\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "destinations"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 45
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'destinations\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_1
    sget-object v0, Lcom/google/maps/model/TravelMode;->TRANSIT:Lcom/google/maps/model/TravelMode;

    invoke-virtual {v0}, Lcom/google/maps/model/TravelMode;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApiRequest;->params()Ljava/util/Map;

    move-result-object v1

    const-string v2, "mode"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 48
    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "arrival_time"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "departure_time"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 49
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Transit request must not contain both a departureTime and an arrivalTime"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_2
    return-void
.end method
