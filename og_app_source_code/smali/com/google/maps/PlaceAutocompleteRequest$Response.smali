.class public Lcom/google/maps/PlaceAutocompleteRequest$Response;
.super Ljava/lang/Object;
.source "PlaceAutocompleteRequest.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/PlaceAutocompleteRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Response"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<[",
        "Lcom/google/maps/model/AutocompletePrediction;",
        ">;"
    }
.end annotation


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public predictions:[Lcom/google/maps/model/AutocompletePrediction;

.field public status:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 136
    invoke-virtual {p0}, Lcom/google/maps/PlaceAutocompleteRequest$Response;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    const/4 v0, 0x0

    .line 139
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/PlaceAutocompleteRequest$Response;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/PlaceAutocompleteRequest$Response;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/google/maps/PlaceAutocompleteRequest$Response;->getResult()[Lcom/google/maps/model/AutocompletePrediction;

    move-result-object v0

    return-object v0
.end method

.method public getResult()[Lcom/google/maps/model/AutocompletePrediction;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/google/maps/PlaceAutocompleteRequest$Response;->predictions:[Lcom/google/maps/model/AutocompletePrediction;

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 126
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/PlaceAutocompleteRequest$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "ZERO_RESULTS"

    iget-object v1, p0, Lcom/google/maps/PlaceAutocompleteRequest$Response;->status:Ljava/lang/String;

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
