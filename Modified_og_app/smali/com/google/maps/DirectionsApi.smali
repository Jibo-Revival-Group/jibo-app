.class public Lcom/google/maps/DirectionsApi;
.super Ljava/lang/Object;
.source "DirectionsApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/DirectionsApi$RouteRestriction;,
        Lcom/google/maps/DirectionsApi$Response;
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/directions/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/maps/DirectionsApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDirections(Lcom/google/maps/GeoApiContext;Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lcom/google/maps/DirectionsApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/DirectionsApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    invoke-virtual {v0, p1}, Lcom/google/maps/DirectionsApiRequest;->origin(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/google/maps/DirectionsApiRequest;->destination(Ljava/lang/String;)Lcom/google/maps/DirectionsApiRequest;

    move-result-object v0

    return-object v0
.end method

.method public static newRequest(Lcom/google/maps/GeoApiContext;)Lcom/google/maps/DirectionsApiRequest;
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/google/maps/DirectionsApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/DirectionsApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    return-object v0
.end method
