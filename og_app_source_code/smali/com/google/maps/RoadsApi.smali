.class public Lcom/google/maps/RoadsApi;
.super Ljava/lang/Object;
.source "RoadsApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/RoadsApi$CombinedResponse;,
        Lcom/google/maps/RoadsApi$SpeedsResponse;,
        Lcom/google/maps/RoadsApi$RoadsResponse;
    }
.end annotation


# static fields
.field static final API_BASE_URL:Ljava/lang/String; = "https://roads.googleapis.com"

.field static final NEAREST_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

.field static final SNAP_TO_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

.field static final SPEEDS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 40
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/v1/snapToRoads"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    const-string v1, "https://roads.googleapis.com"

    .line 42
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->hostName(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    .line 43
    invoke-virtual {v0, v2}, Lcom/google/maps/internal/ApiConfig;->supportsClientId(Z)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/google/gson/FieldNamingPolicy;

    .line 44
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/RoadsApi;->SNAP_TO_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 46
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/v1/speedLimits"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    const-string v1, "https://roads.googleapis.com"

    .line 48
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->hostName(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    .line 49
    invoke-virtual {v0, v2}, Lcom/google/maps/internal/ApiConfig;->supportsClientId(Z)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/google/gson/FieldNamingPolicy;

    .line 50
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/RoadsApi;->SPEEDS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 52
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/v1/nearestRoads"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    const-string v1, "https://roads.googleapis.com"

    .line 54
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->hostName(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    .line 55
    invoke-virtual {v0, v2}, Lcom/google/maps/internal/ApiConfig;->supportsClientId(Z)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/google/gson/FieldNamingPolicy;

    .line 56
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/RoadsApi;->NEAREST_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 52
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static varargs nearestRoads(Lcom/google/maps/GeoApiContext;[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/SnappedPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 163
    sget-object v0, Lcom/google/maps/RoadsApi;->NEAREST_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$RoadsResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "points"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const/16 v4, 0x7c

    invoke-static {v4, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs snapToRoads(Lcom/google/maps/GeoApiContext;Z[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Z[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/SnappedPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 88
    sget-object v0, Lcom/google/maps/RoadsApi;->SNAP_TO_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$RoadsResponse;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const/16 v4, 0x7c

    .line 92
    invoke-static {v4, p2}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "interpolate"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    .line 94
    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 88
    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs snapToRoads(Lcom/google/maps/GeoApiContext;[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/SnappedPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    sget-object v0, Lcom/google/maps/RoadsApi;->SNAP_TO_ROADS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$RoadsResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const/16 v4, 0x7c

    invoke-static {v4, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs snappedSpeedLimits(Lcom/google/maps/GeoApiContext;[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<",
            "Lcom/google/maps/model/SnappedSpeedLimitResponse;",
            ">;"
        }
    .end annotation

    .prologue
    .line 150
    sget-object v0, Lcom/google/maps/RoadsApi;->SPEEDS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$CombinedResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const/16 v4, 0x7c

    invoke-static {v4, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs speedLimits(Lcom/google/maps/GeoApiContext;[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/SpeedLimit;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    sget-object v0, Lcom/google/maps/RoadsApi;->SPEEDS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$SpeedsResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const/16 v4, 0x7c

    invoke-static {v4, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs speedLimits(Lcom/google/maps/GeoApiContext;[Ljava/lang/String;)Lcom/google/maps/PendingResult;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "[",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/SpeedLimit;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 131
    array-length v1, p1

    mul-int/lit8 v1, v1, 0x2

    new-array v2, v1, [Ljava/lang/String;

    .line 133
    array-length v3, p1

    move v1, v0

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, p1, v0

    .line 134
    add-int/lit8 v5, v1, 0x1

    const-string v6, "placeId"

    aput-object v6, v2, v1

    .line 135
    add-int/lit8 v1, v5, 0x1

    aput-object v4, v2, v5

    .line 133
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 138
    :cond_0
    sget-object v0, Lcom/google/maps/RoadsApi;->SPEEDS_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/RoadsApi$SpeedsResponse;

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method
