.class public Lcom/google/maps/GeolocationApi;
.super Ljava/lang/Object;
.source "GeolocationApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/GeolocationApi$Response;
    }
.end annotation


# static fields
.field private static final API_BASE_URL:Ljava/lang/String; = "https://www.googleapis.com"

.field static final GEOLOCATION_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

.field private static final LOG:Ljava/util/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    const-class v0, Lcom/google/maps/GeolocationApi;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/maps/GeolocationApi;->LOG:Ljava/util/logging/Logger;

    .line 40
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/geolocation/v1/geolocate"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    const-string v1, "https://www.googleapis.com"

    .line 42
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->hostName(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    const/4 v1, 0x0

    .line 43
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->supportsClientId(Z)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/google/gson/FieldNamingPolicy;

    .line 44
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    const-string v1, "POST"

    .line 45
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->requestVerb(Ljava/lang/String;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/GeolocationApi;->GEOLOCATION_API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 40
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static geolocate(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/GeolocationPayload;)Lcom/google/maps/PendingResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Lcom/google/maps/model/GeolocationPayload;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<",
            "Lcom/google/maps/model/GeolocationResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    new-instance v0, Lcom/google/maps/GeolocationApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/GeolocationApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    invoke-virtual {v0, p1}, Lcom/google/maps/GeolocationApiRequest;->Payload(Lcom/google/maps/model/GeolocationPayload;)Lcom/google/maps/GeolocationApiRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/maps/GeolocationApiRequest;->CreatePayload()Lcom/google/maps/GeolocationApiRequest;

    move-result-object v0

    return-object v0
.end method

.method public static newRequest(Lcom/google/maps/GeoApiContext;)Lcom/google/maps/GeolocationApiRequest;
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/google/maps/GeolocationApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/GeolocationApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    return-object v0
.end method
