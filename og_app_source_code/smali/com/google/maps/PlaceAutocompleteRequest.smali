.class public Lcom/google/maps/PlaceAutocompleteRequest;
.super Lcom/google/maps/PendingResultBase;
.source "PlaceAutocompleteRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/PlaceAutocompleteRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<[",
        "Lcom/google/maps/model/AutocompletePrediction;",
        "Lcom/google/maps/PlaceAutocompleteRequest;",
        "Lcom/google/maps/PlaceAutocompleteRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/autocomplete/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 40
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/PlaceAutocompleteRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 38
    return-void
.end method

.method protected constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 43
    sget-object v0, Lcom/google/maps/PlaceAutocompleteRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/PlaceAutocompleteRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 44
    return-void
.end method


# virtual methods
.method public varargs components([Lcom/google/maps/model/ComponentFilter;)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 2

    .prologue
    .line 109
    const-string v0, "components"

    const/16 v1, 0x7c

    invoke-static {v1, p1}, Lcom/google/maps/internal/StringJoin;->join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method public input(Ljava/lang/String;)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 1

    .prologue
    .line 54
    const-string v0, "input"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method public location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 1

    .prologue
    .line 77
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method public offset(I)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 2

    .prologue
    .line 67
    const-string v0, "offset"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method public radius(I)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 2

    .prologue
    .line 88
    const-string v0, "radius"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method public type(Lcom/google/maps/model/PlaceAutocompleteType;)Lcom/google/maps/PlaceAutocompleteRequest;
    .locals 1

    .prologue
    .line 98
    const-string v0, "types"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PlaceAutocompleteRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceAutocompleteRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/google/maps/PlaceAutocompleteRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "input"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 115
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'input\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 117
    :cond_0
    return-void
.end method
