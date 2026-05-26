.class public Lcom/google/maps/NearbySearchRequest;
.super Lcom/google/maps/PendingResultBase;
.source "NearbySearchRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/NearbySearchRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/PlacesSearchResponse;",
        "Lcom/google/maps/NearbySearchRequest;",
        "Lcom/google/maps/NearbySearchRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 39
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/nearbysearch/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 41
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/NearbySearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 39
    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 49
    sget-object v0, Lcom/google/maps/NearbySearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/NearbySearchRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 50
    return-void
.end method


# virtual methods
.method public keyword(Ljava/lang/String;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 96
    const-string v0, "keyword"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 59
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public maxPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 116
    const-string v0, "maxprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public minPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 106
    const-string v0, "minprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public name(Ljava/lang/String;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 126
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public openNow(Z)Lcom/google/maps/NearbySearchRequest;
    .locals 2

    .prologue
    .line 136
    const-string v0, "opennow"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public pageToken(Ljava/lang/String;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 148
    const-string v0, "pagetoken"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public radius(I)Lcom/google/maps/NearbySearchRequest;
    .locals 2

    .prologue
    .line 71
    const v0, 0xc350

    if-le p1, v0, :cond_0

    .line 72
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The maximum allowed radius is 50,000 meters."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 74
    :cond_0
    const-string v0, "radius"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public rankby(Lcom/google/maps/model/RankBy;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 84
    const-string v0, "rankby"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public type(Lcom/google/maps/model/PlaceType;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 158
    const-string v0, "type"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method public varargs type([Lcom/google/maps/model/PlaceType;)Lcom/google/maps/NearbySearchRequest;
    .locals 2

    .prologue
    .line 169
    const-string v0, "type"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/NearbySearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/NearbySearchRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 176
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "pagetoken"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 196
    :cond_0
    return-void

    .line 181
    :cond_1
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "rankby"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 182
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "rankby"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v1, Lcom/google/maps/model/RankBy;->DISTANCE:Lcom/google/maps/model/RankBy;

    invoke-virtual {v1}, Lcom/google/maps/model/RankBy;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 183
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "radius"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 184
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must not contain radius with rankby=distance"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 188
    :cond_2
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "rankby"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 189
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "rankby"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v1, Lcom/google/maps/model/RankBy;->DISTANCE:Lcom/google/maps/model/RankBy;

    invoke-virtual {v1}, Lcom/google/maps/model/RankBy;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 190
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "keyword"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 191
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "name"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 192
    invoke-virtual {p0}, Lcom/google/maps/NearbySearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "type"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 193
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "With rankby=distance is specified, then one or more of keyword, name, or type is required"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
