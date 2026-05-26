.class public Lcom/google/maps/TextSearchRequest;
.super Lcom/google/maps/PendingResultBase;
.source "TextSearchRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/TextSearchRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/PlacesSearchResponse;",
        "Lcom/google/maps/TextSearchRequest;",
        "Lcom/google/maps/TextSearchRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 36
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/textsearch/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 38
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/TextSearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 36
    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 41
    sget-object v0, Lcom/google/maps/TextSearchRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/TextSearchRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 42
    return-void
.end method


# virtual methods
.method public location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 61
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public maxPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 94
    const-string v0, "maxprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public minPrice(Lcom/google/maps/model/PriceLevel;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 84
    const-string v0, "minprice"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public name(Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 105
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public openNow(Z)Lcom/google/maps/TextSearchRequest;
    .locals 2

    .prologue
    .line 115
    const-string v0, "opennow"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public pageToken(Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 127
    const-string v0, "pagetoken"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public query(Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 51
    const-string v0, "query"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public radius(I)Lcom/google/maps/TextSearchRequest;
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

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public rankby(Lcom/google/maps/model/RankBy;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 137
    const-string v0, "rankby"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method public type(Lcom/google/maps/model/PlaceType;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 147
    const-string v0, "type"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/TextSearchRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/TextSearchRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 154
    invoke-virtual {p0}, Lcom/google/maps/TextSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "pagetoken"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 166
    :cond_0
    return-void

    .line 158
    :cond_1
    invoke-virtual {p0}, Lcom/google/maps/TextSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "query"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 159
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'query\' or a \'pageToken\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 162
    :cond_2
    invoke-virtual {p0}, Lcom/google/maps/TextSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "location"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/maps/TextSearchRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "radius"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 163
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'radius\' parameter when it contains a \'location\' parameter."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
