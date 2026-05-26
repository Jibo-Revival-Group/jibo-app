.class public Lcom/google/maps/DirectionsApiRequest;
.super Lcom/google/maps/PendingResultBase;
.source "DirectionsApiRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/DirectionsResult;",
        "Lcom/google/maps/DirectionsApiRequest;",
        "Lcom/google/maps/DirectionsApi$Response;",
        ">;"
    }
.end annotation


# instance fields
.field protected optimizeWaypoints:Z

.field protected waypoints:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 34
    sget-object v0, Lcom/google/maps/DirectionsApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/DirectionsApi$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 35
    return-void
.end method


# virtual methods
.method public alternatives(Z)Lcom/google/maps/DirectionsApiRequest;
    .locals 2

    .prologue
    .line 235
    if-eqz p1, :cond_0

    .line 236
    const-string v0, "alternatives"

    const-string v1, "true"

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    .line 238
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "alternatives"

    const-string v1, "false"

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    goto :goto_0
.end method

.method public arrivalTime(Lorg/joda/time/ReadableInstant;)Lcom/google/maps/DirectionsApiRequest;
    .locals 6

    .prologue
    .line 153
    const-string v0, "arrival_time"

    invoke-interface {p1}, Lorg/joda/time/ReadableInstant;->c()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public varargs avoid([Lcom/google/maps/DirectionsApi$RouteRestriction;)Lcom/google/maps/DirectionsApiRequest;
    .locals 2

    .prologue
    .line 125
    const-string v0, "avoid"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public departureTime(Lorg/joda/time/ReadableInstant;)Lcom/google/maps/DirectionsApiRequest;
    .locals 6

    .prologue
    .line 165
    const-string v0, "departure_time"

    invoke-interface {p1}, Lorg/joda/time/ReadableInstant;->c()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public destination(Lcom/google/maps/model/LatLng;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 102
    invoke-virtual {p1}, Lcom/google/maps/model/LatLng;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/maps/DirectionsApiRequest;->destination(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object v0

    return-object v0
.end method

.method public destination(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 82
    const-string v0, "destination"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public mode(Lcom/google/maps/model/TravelMode;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 114
    const-string v0, "mode"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public optimizeWaypoints(Z)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 218
    iput-boolean p1, p0, Lcom/google/maps/DirectionsApiRequest;->optimizeWaypoints:Z

    .line 219
    iget-object v0, p0, Lcom/google/maps/DirectionsApiRequest;->waypoints:[Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 220
    iget-object v0, p0, Lcom/google/maps/DirectionsApiRequest;->waypoints:[Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/google/maps/DirectionsApiRequest;->waypoints([Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object p0

    .line 222
    :cond_0
    return-object p0
.end method

.method public origin(Lcom/google/maps/model/LatLng;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 92
    invoke-virtual {p1}, Lcom/google/maps/model/LatLng;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/maps/DirectionsApiRequest;->origin(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object v0

    return-object v0
.end method

.method public origin(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 69
    const-string v0, "origin"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public region(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 143
    const-string v0, "region"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public trafficModel(Lcom/google/maps/model/TrafficModel;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 272
    const-string v0, "traffic_model"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public varargs transitMode([Lcom/google/maps/model/TransitMode;)Lcom/google/maps/DirectionsApiRequest;
    .locals 2

    .prologue
    .line 250
    const-string v0, "transit_mode"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public transitRoutingPreference(Lcom/google/maps/model/TransitRoutingPreference;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 261
    const-string v0, "transit_routing_preference"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method public units(Lcom/google/maps/model/Unit;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 135
    const-string v0, "units"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 3

    .prologue
    .line 42
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "origin"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'origin\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "destination"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 46
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'destination\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 48
    :cond_1
    sget-object v0, Lcom/google/maps/model/TravelMode;->TRANSIT:Lcom/google/maps/model/TravelMode;

    invoke-virtual {v0}, Lcom/google/maps/model/TravelMode;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v1

    const-string v2, "mode"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 49
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "arrival_time"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "departure_time"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 50
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Transit request must not contain both a departureTime and an arrivalTime"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_2
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "traffic_model"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/google/maps/DirectionsApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "departure_time"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 54
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Specifying a traffic model requires that departure time be provided."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 57
    :cond_3
    return-void
.end method

.method public varargs waypoints([Lcom/google/maps/model/LatLng;)Lcom/google/maps/DirectionsApiRequest;
    .locals 4

    .prologue
    .line 199
    if-nez p1, :cond_0

    .line 207
    :goto_0
    return-object p0

    .line 202
    :cond_0
    array-length v1, p1

    .line 203
    new-array v2, v1, [Ljava/lang/String;

    .line 204
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v1, :cond_1

    .line 205
    aget-object v3, p1, v0

    invoke-virtual {v3}, Lcom/google/maps/model/LatLng;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    .line 204
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 207
    :cond_1
    invoke-virtual {p0, v2}, Lcom/google/maps/DirectionsApiRequest;->waypoints([Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object p0

    goto :goto_0
.end method

.method public varargs waypoints([Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;
    .locals 3

    .prologue
    .line 182
    iput-object p1, p0, Lcom/google/maps/DirectionsApiRequest;->waypoints:[Ljava/lang/String;

    .line 183
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    :cond_0
    move-object v0, p0

    .line 188
    :goto_0
    return-object v0

    .line 185
    :cond_1
    array-length v0, p1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 186
    const-string v0, "waypoints"

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    goto :goto_0

    .line 188
    :cond_2
    const-string v1, "waypoints"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-boolean v0, p0, Lcom/google/maps/DirectionsApiRequest;->optimizeWaypoints:Z

    if-eqz v0, :cond_3

    const-string v0, "optimize:true|"

    :goto_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0x7c

    invoke-static {v2, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v1, v0}, Lcom/google/maps/DirectionsApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApiRequest;

    goto :goto_0

    :cond_3
    const-string v0, ""

    goto :goto_1
.end method
