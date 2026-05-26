.class Lcom/google/maps/DirectionsApi$Response;
.super Ljava/lang/Object;
.source "DirectionsApi.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/DirectionsApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Response"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<",
        "Lcom/google/maps/model/DirectionsResult;",
        ">;"
    }
.end annotation


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public geocodedWaypoints:[Lcom/google/maps/model/GeocodedWaypoint;

.field public routes:[Lcom/google/maps/model/DirectionsRoute;

.field public status:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApi$Response;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 72
    const/4 v0, 0x0

    .line 74
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/DirectionsApi$Response;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/DirectionsApi$Response;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public getResult()Lcom/google/maps/model/DirectionsResult;
    .locals 2

    .prologue
    .line 63
    new-instance v0, Lcom/google/maps/model/DirectionsResult;

    invoke-direct {v0}, Lcom/google/maps/model/DirectionsResult;-><init>()V

    .line 64
    iget-object v1, p0, Lcom/google/maps/DirectionsApi$Response;->geocodedWaypoints:[Lcom/google/maps/model/GeocodedWaypoint;

    iput-object v1, v0, Lcom/google/maps/model/DirectionsResult;->geocodedWaypoints:[Lcom/google/maps/model/GeocodedWaypoint;

    .line 65
    iget-object v1, p0, Lcom/google/maps/DirectionsApi$Response;->routes:[Lcom/google/maps/model/DirectionsRoute;

    iput-object v1, v0, Lcom/google/maps/model/DirectionsResult;->routes:[Lcom/google/maps/model/DirectionsRoute;

    .line 66
    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/google/maps/DirectionsApi$Response;->getResult()Lcom/google/maps/model/DirectionsResult;

    move-result-object v0

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 58
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/DirectionsApi$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "ZERO_RESULTS"

    iget-object v1, p0, Lcom/google/maps/DirectionsApi$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
