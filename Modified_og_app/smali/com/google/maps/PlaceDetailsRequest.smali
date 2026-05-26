.class public Lcom/google/maps/PlaceDetailsRequest;
.super Lcom/google/maps/PendingResultBase;
.source "PlaceDetailsRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/PlaceDetailsRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/PlaceDetails;",
        "Lcom/google/maps/PlaceDetailsRequest;",
        "Lcom/google/maps/PlaceDetailsRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/details/json"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/google/gson/FieldNamingPolicy;

    .line 33
    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/maps/internal/ApiConfig;

    move-result-object v0

    sput-object v0, Lcom/google/maps/PlaceDetailsRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    .line 31
    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 36
    sget-object v0, Lcom/google/maps/PlaceDetailsRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/PlaceDetailsRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 37
    return-void
.end method


# virtual methods
.method public placeId(Ljava/lang/String;)Lcom/google/maps/PlaceDetailsRequest;
    .locals 1

    .prologue
    .line 46
    const-string v0, "placeid"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PlaceDetailsRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PlaceDetailsRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/google/maps/PlaceDetailsRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "placeid"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 52
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'placeId\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_0
    return-void
.end method
