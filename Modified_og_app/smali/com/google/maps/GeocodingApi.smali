.class public Lcom/google/maps/GeocodingApi;
.super Ljava/lang/Object;
.source "GeocodingApi.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/GeocodingApi$Response;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static geocode(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/google/maps/GeocodingApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/GeocodingApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 54
    invoke-virtual {v0, p1}, Lcom/google/maps/GeocodingApiRequest;->address(Ljava/lang/String;)Lcom/google/maps/GeocodingApiRequest;

    .line 55
    return-object v0
.end method

.method public static newRequest(Lcom/google/maps/GeoApiContext;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/google/maps/GeocodingApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/GeocodingApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    return-object v0
.end method

.method public static reverseGeocode(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;)Lcom/google/maps/GeocodingApiRequest;
    .locals 1

    .prologue
    .line 66
    new-instance v0, Lcom/google/maps/GeocodingApiRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/GeocodingApiRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 67
    invoke-virtual {v0, p1}, Lcom/google/maps/GeocodingApiRequest;->latlng(Lcom/google/maps/model/LatLng;)Lcom/google/maps/GeocodingApiRequest;

    .line 68
    return-object v0
.end method
