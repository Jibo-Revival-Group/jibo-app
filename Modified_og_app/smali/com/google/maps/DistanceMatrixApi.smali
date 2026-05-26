.class public Lcom/google/maps/DistanceMatrixApi;
.super Ljava/lang/Object;
.source "DistanceMatrixApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/DistanceMatrixApi$Response;
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 43
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/distancematrix/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/maps/DistanceMatrixApi;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDistanceMatrix(Lcom/google/maps/GeoApiContext;[Ljava/lang/String;[Ljava/lang/String;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 53
    invoke-static {p0}, Lcom/google/maps/DistanceMatrixApi;->newRequest(Lcom/google/maps/GeoApiContext;)Lcom/google/maps/DistanceMatrixApiRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/maps/DistanceMatrixApiRequest;->origins([Ljava/lang/String;)Lcom/google/maps/DistanceMatrixApiRequest;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/google/maps/DistanceMatrixApiRequest;->destinations([Ljava/lang/String;)Lcom/google/maps/DistanceMatrixApiRequest;

    move-result-object v0

    return-object v0
.end method

.method public static newRequest(Lcom/google/maps/GeoApiContext;)Lcom/google/maps/DistanceMatrixApiRequest;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/google/maps/DistanceMatrixApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/DistanceMatrixApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    return-object v0
.end method
