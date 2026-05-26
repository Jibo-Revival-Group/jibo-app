.class public Lcom/google/maps/RadarSearchRequest;
.super Lcom/google/maps/PendingResultBase;
.source "RadarSearchRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/RadarSearchRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/PlacesSearchResponse;",
        "Lcom/google/maps/RadarSearchRequest;",
        "Lcom/google/maps/RadarSearchRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/radarsearch/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 34
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/RadarSearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 32
    return-void
.end method

.method protected constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 37
    sget-object v0, Lcom/google/maps/RadarSearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RadarSearchRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 38
    return-void
.end method


# virtual methods
.method public keyword(Ljava/lang/String;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 73
    const-string v0, "keyword"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 47
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public maxPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 93
    const-string v0, "maxprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public minPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 83
    const-string v0, "minprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public name(Ljava/lang/String;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 103
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public openNow(Z)Lcom/google/maps/RadarSearchRequest;
    .locals 2

    .prologue
    .line 114
    const-string v0, "opennow"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public radius(I)Lcom/google/maps/RadarSearchRequest;
    .locals 2

    .prologue
    .line 58
    const v0, 0xc350

    if-le p1, v0, :cond_0

    .line 59
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The maximum allowed radius is 50,000 meters."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 61
    :cond_0
    const-string v0, "radius"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method public type(Lcom/google/maps/model/PlaceType;)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 124
    const-string v0, "type"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/RadarSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/RadarSearchRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/google/maps/RadarSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "keyword"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/google/maps/RadarSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "name"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 131
    invoke-virtual {p0}, Lcom/google/maps/RadarSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "type"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 132
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'keyword\', \'name\' or \'type\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 134
    :cond_0
    return-void
.end method
