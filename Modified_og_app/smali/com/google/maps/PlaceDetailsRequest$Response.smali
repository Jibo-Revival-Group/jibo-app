.class public Lcom/google/maps/PlaceDetailsRequest$Response;
.super Ljava/lang/Object;
.source "PlaceDetailsRequest.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/PlaceDetailsRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Response"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<",
        "Lcom/google/maps/model/PlaceDetails;",
        ">;"
    }
.end annotation


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public htmlAttributions:[Ljava/lang/String;

.field public result:Lcom/google/maps/model/PlaceDetails;

.field public status:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
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
    .line 77
    invoke-virtual {p0}, Lcom/google/maps/PlaceDetailsRequest$Response;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    const/4 v0, 0x0

    .line 80
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public getResult()Lcom/google/maps/model/PlaceDetails;
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->result:Lcom/google/maps/model/PlaceDetails;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->result:Lcom/google/maps/model/PlaceDetails;

    iget-object v1, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->htmlAttributions:[Ljava/lang/String;

    iput-object v1, v0, Lcom/google/maps/model/PlaceDetails;->htmlAttributions:[Ljava/lang/String;

    .line 72
    :cond_0
    iget-object v0, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->result:Lcom/google/maps/model/PlaceDetails;

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/google/maps/PlaceDetailsRequest$Response;->getResult()Lcom/google/maps/model/PlaceDetails;

    move-result-object v0

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 64
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "ZERO_RESULTS"

    iget-object v1, p0, Lcom/google/maps/PlaceDetailsRequest$Response;->status:Ljava/lang/String;

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
