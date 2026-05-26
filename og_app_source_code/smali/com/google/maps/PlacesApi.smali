.class public Lcom/google/maps/PlacesApi;
.super Ljava/lang/Object;
.source "PlacesApi.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static nearbySearchNextPage(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 57
    new-instance v0, Lcom/google/maps/NearbySearchRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/NearbySearchRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 58
    invoke-virtual {v0, p1}, Lcom/google/maps/NearbySearchRequest;->pageToken(Ljava/lang/String;)Lcom/google/maps/NearbySearchRequest;

    .line 59
    return-object v0
.end method

.method public static nearbySearchQuery(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;)Lcom/google/maps/NearbySearchRequest;
    .locals 1

    .prologue
    .line 41
    new-instance v0, Lcom/google/maps/NearbySearchRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/NearbySearchRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 42
    invoke-virtual {v0, p1}, Lcom/google/maps/NearbySearchRequest;->location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/NearbySearchRequest;

    .line 43
    return-object v0
.end method

.method public static photo(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/PhotoRequest;
    .locals 1

    .prologue
    .line 145
    new-instance v0, Lcom/google/maps/PhotoRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/PhotoRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 146
    invoke-virtual {v0, p1}, Lcom/google/maps/PhotoRequest;->photoReference(Ljava/lang/String;)Lcom/google/maps/PhotoRequest;

    .line 147
    return-object v0
.end method

.method public static placeAutocomplete(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 1

    .prologue
    .line 160
    new-instance v0, Lcom/google/maps/PlaceAutocompleteRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/PlaceAutocompleteRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 161
    invoke-virtual {v0, p1}, Lcom/google/maps/PlaceAutocompleteRequest;->input(Ljava/lang/String;)Lcom/google/maps/PlaceAutocompleteRequest;

    .line 162
    return-object v0
.end method

.method public static placeDetails(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/PlaceDetailsRequest;
    .locals 1

    .prologue
    .line 125
    new-instance v0, Lcom/google/maps/PlaceDetailsRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/PlaceDetailsRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 126
    invoke-virtual {v0, p1}, Lcom/google/maps/PlaceDetailsRequest;->placeId(Ljava/lang/String;)Lcom/google/maps/PlaceDetailsRequest;

    .line 127
    return-object v0
.end method

.method public static queryAutocomplete(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/QueryAutocompleteRequest;
    .locals 1

    .prologue
    .line 173
    new-instance v0, Lcom/google/maps/QueryAutocompleteRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/QueryAutocompleteRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 174
    invoke-virtual {v0, p1}, Lcom/google/maps/QueryAutocompleteRequest;->input(Ljava/lang/String;)Lcom/google/maps/QueryAutocompleteRequest;

    .line 175
    return-object v0
.end method

.method public static radarSearchQuery(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;I)Lcom/google/maps/RadarSearchRequest;
    .locals 1

    .prologue
    .line 106
    new-instance v0, Lcom/google/maps/RadarSearchRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/RadarSearchRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 107
    invoke-virtual {v0, p1}, Lcom/google/maps/RadarSearchRequest;->location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/RadarSearchRequest;

    .line 108
    invoke-virtual {v0, p2}, Lcom/google/maps/RadarSearchRequest;->radius(I)Lcom/google/maps/RadarSearchRequest;

    .line 109
    return-object v0
.end method

.method public static textSearchNextPage(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 86
    new-instance v0, Lcom/google/maps/TextSearchRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/TextSearchRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 87
    invoke-virtual {v0, p1}, Lcom/google/maps/TextSearchRequest;->pageToken(Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;

    .line 88
    return-object v0
.end method

.method public static textSearchQuery(Lcom/google/maps/GeoApiContext;Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;
    .locals 1

    .prologue
    .line 71
    new-instance v0, Lcom/google/maps/TextSearchRequest;

    invoke-direct {v0, p0}, Lcom/google/maps/TextSearchRequest;-><init>(Lcom/google/maps/GeoApiContext;)V

    .line 72
    invoke-virtual {v0, p1}, Lcom/google/maps/TextSearchRequest;->query(Ljava/lang/String;)Lcom/google/maps/TextSearchRequest;

    .line 73
    return-object v0
.end method
