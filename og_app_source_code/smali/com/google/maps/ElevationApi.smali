.class public Lcom/google/maps/ElevationApi;
.super Ljava/lang/Object;
.source "ElevationApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/ElevationApi$MultiResponse;,
        Lcom/google/maps/ElevationApi$SingularResponse;
    }
.end annotation


# static fields
.field private static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/elevation/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getByPath(Lcom/google/maps/GeoApiContext;ILcom/google/maps/model/EncodedPolyline;)Lcom/google/maps/PendingResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "I",
            "Lcom/google/maps/model/EncodedPolyline;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/ElevationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 84
    sget-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/ElevationApi$MultiResponse;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "samples"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 88
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "enc:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 90
    invoke-virtual {p2}, Lcom/google/maps/model/EncodedPolyline;->getEncodedPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 84
    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs getByPath(Lcom/google/maps/GeoApiContext;I[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "I[",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/ElevationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 64
    sget-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/ElevationApi$MultiResponse;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "samples"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 68
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "path"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    .line 70
    invoke-static {p2}, Lcom/google/maps/ElevationApi;->shortestParam([Lcom/google/maps/model/LatLng;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 64
    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static getByPoint(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<",
            "Lcom/google/maps/model/ElevationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    sget-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/ElevationApi$SingularResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "locations"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p1}, Lcom/google/maps/model/LatLng;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static getByPoints(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/EncodedPolyline;)Lcom/google/maps/PendingResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Lcom/google/maps/model/EncodedPolyline;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<[",
            "Lcom/google/maps/model/ElevationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    sget-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/ElevationApi$MultiResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "locations"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "enc:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 147
    invoke-virtual {p1}, Lcom/google/maps/model/EncodedPolyline;->getEncodedPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 146
    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method public static varargs getByPoints(Lcom/google/maps/GeoApiContext;[Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
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
            "Lcom/google/maps/model/ElevationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    sget-object v0, Lcom/google/maps/ElevationApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/ElevationApi$MultiResponse;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "locations"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p1}, Lcom/google/maps/ElevationApi;->shortestParam([Lcom/google/maps/model/LatLng;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method private static shortestParam([Lcom/google/maps/model/LatLng;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 97
    const/16 v0, 0x7c

    invoke-static {v0, p0}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v0

    .line 98
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "enc:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Lcom/google/maps/internal/PolylineEncoding;->encode([Lcom/google/maps/model/LatLng;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 99
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v2, v3, :cond_0

    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method
