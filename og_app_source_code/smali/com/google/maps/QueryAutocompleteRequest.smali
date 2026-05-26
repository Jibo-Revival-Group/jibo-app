.class public Lcom/google/maps/QueryAutocompleteRequest;
.super Lcom/google/maps/PendingResultBase;
.source "QueryAutocompleteRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/QueryAutocompleteRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<[",
        "Lcom/google/maps/model/AutocompletePrediction;",
        "Lcom/google/maps/QueryAutocompleteRequest;",
        "Lcom/google/maps/QueryAutocompleteRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/queryautocomplete/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 36
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/QueryAutocompleteRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 34
    return-void
.end method

.method protected constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 39
    sget-object v0, Lcom/google/maps/QueryAutocompleteRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/QueryAutocompleteRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 40
    return-void
.end method


# virtual methods
.method public input(Ljava/lang/String;)Lcom/google/maps/QueryAutocompleteRequest;
    .locals 1

    .prologue
    .line 57
    const-string v0, "input"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/QueryAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/QueryAutocompleteRequest;

    return-object v0
.end method

.method public location(Lcom/google/maps/model/LatLng;)Lcom/google/maps/QueryAutocompleteRequest;
    .locals 1

    .prologue
    .line 80
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/QueryAutocompleteRequest;->param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/QueryAutocompleteRequest;

    return-object v0
.end method

.method public offset(I)Lcom/google/maps/QueryAutocompleteRequest;
    .locals 2

    .prologue
    .line 70
    const-string v0, "offset"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/QueryAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/QueryAutocompleteRequest;

    return-object v0
.end method

.method public radius(I)Lcom/google/maps/QueryAutocompleteRequest;
    .locals 2

    .prologue
    .line 91
    const-string v0, "radius"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/QueryAutocompleteRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/QueryAutocompleteRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/google/maps/QueryAutocompleteRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "input"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 45
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'input\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_0
    return-void
.end method
