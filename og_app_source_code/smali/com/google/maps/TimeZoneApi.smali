.class public Lcom/google/maps/TimeZoneApi;
.super Ljava/lang/Object;
.source "TimeZoneApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/TimeZoneApi$Response;
    }
.end annotation


# static fields
.field private static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 33
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/timezone/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/google/gson/FieldNamingPolicy;

    .line 34
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/TimeZoneApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 33
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getTimeZone(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Lcom/google/maps/model/LatLng;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<",
            "Ljava/util/TimeZone;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    sget-object v0, Lcom/google/maps/TimeZoneApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/TimeZoneApi$Response;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "location"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 50
    invoke-virtual {p1}, Lcom/google/maps/model/LatLng;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "timestamp"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string v4, "0"

    aput-object v4, v2, v3

    .line 46
    invoke-virtual {p0, v0, v1, v2}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method
