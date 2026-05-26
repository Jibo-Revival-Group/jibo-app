.class public Lcom/google/maps/GeocodingApiRequest;
.super Lcom/google/maps/PendingResultBase;
.source "GeocodingApiRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<[",
        "Lcom/google/maps/model/GeocodingResult;",
        "Lcom/google/maps/GeocodingApiRequest;",
        "Lcom/google/maps/GeocodingApi$Response;",
        ">;"
    }
.end annotation


# static fields
.field private static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/geocode/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/maps/GeocodingApiRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 34
    sget-object v0, Lcom/google/maps/GeocodingApiRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/GeocodingApi$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 35
    return-void
.end method


# virtual methods
.method public address(Ljava/lang/String;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 64
    const-string v0, "address"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public bounds(Lcom/google/maps/model/LatLng;Lcom/google/maps/model/LatLng;)Lcom/google/maps/GeocodingApiRequest;
    .locals 4

    .prologue
    .line 100
    const-string v0, "bounds"

    const/16 v1, 0x7c

    const/4 v2, 0x2

    new-array v2, v2, [Lcom/google/maps/internal/StringJoin$UrlValue;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public varargs components([Lcom/google/maps/model/ComponentFilter;)Lcom/google/maps/GeocodingApiRequest;
    .locals 2

    .prologue
    .line 130
    const-string v0, "components"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public latlng(Lcom/google/maps/model/LatLng;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 84
    const-string v0, "latlng"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public varargs locationType([Lcom/google/maps/model/LocationType;)Lcom/google/maps/GeocodingApiRequest;
    .locals 2

    .prologue
    .line 152
    const-string v0, "location_type"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public place(Ljava/lang/String;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 74
    const-string v0, "place_id"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public region(Ljava/lang/String;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 115
    const-string v0, "region"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method public varargs resultType([Lcom/google/maps/model/AddressType;)Lcom/google/maps/GeocodingApiRequest;
    .locals 2

    .prologue
    .line 141
    const-string v0, "result_type"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/GeocodingApiRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/GeocodingApiRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "latlng"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "address"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 42
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "place_id"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain only one of \'address\', \'latlng\' or \'place_id\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 48
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "latlng"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 49
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "address"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 50
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "components"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 51
    invoke-virtual {p0}, Lcom/google/maps/GeocodingApiRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "place_id"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 52
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain at least one of \'address\', \'latlng\', \'place_id\' and \'components\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_1
    return-void
.end method
