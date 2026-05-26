.class Lcom/google/maps/DistanceMatrixApi$Response;
.super Ljava/lang/Object;
.source "DistanceMatrixApi.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/DistanceMatrixApi;
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
        "Lcom/google/maps/model/DistanceMatrix;",
        ">;"
    }
.end annotation


# instance fields
.field public destinationAddresses:[Ljava/lang/String;

.field public errorMessage:Ljava/lang/String;

.field public originAddresses:[Ljava/lang/String;

.field public rows:[Lcom/google/maps/model/DistanceMatrixRow;

.field public status:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 70
    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApi$Response;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    const/4 v0, 0x0

    .line 73
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/DistanceMatrixApi$Response;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/DistanceMatrixApi$Response;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public getResult()Lcom/google/maps/model/DistanceMatrix;
    .locals 4

    .prologue
    .line 78
    new-instance v0, Lcom/google/maps/model/DistanceMatrix;

    iget-object v1, p0, Lcom/google/maps/DistanceMatrixApi$Response;->originAddresses:[Ljava/lang/String;

    iget-object v2, p0, Lcom/google/maps/DistanceMatrixApi$Response;->destinationAddresses:[Ljava/lang/String;

    iget-object v3, p0, Lcom/google/maps/DistanceMatrixApi$Response;->rows:[Lcom/google/maps/model/DistanceMatrixRow;

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/DistanceMatrix;-><init>([Ljava/lang/String;[Ljava/lang/String;[Lcom/google/maps/model/DistanceMatrixRow;)V

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/google/maps/DistanceMatrixApi$Response;->getResult()Lcom/google/maps/model/DistanceMatrix;

    move-result-object v0

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 65
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/DistanceMatrixApi$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
