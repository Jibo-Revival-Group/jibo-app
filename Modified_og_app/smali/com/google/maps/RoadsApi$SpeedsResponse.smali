.class Lcom/google/maps/RoadsApi$SpeedsResponse;
.super Ljava/lang/Object;
.source "RoadsApi.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/RoadsApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SpeedsResponse"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<[",
        "Lcom/google/maps/model/SpeedLimit;",
        ">;"
    }
.end annotation


# instance fields
.field private error:Lcom/google/maps/errors/ApiError;

.field private speedLimits:[Lcom/google/maps/model/SpeedLimit;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 186
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 202
    iget-object v0, p0, Lcom/google/maps/RoadsApi$SpeedsResponse;->error:Lcom/google/maps/errors/ApiError;

    iget-object v0, v0, Lcom/google/maps/errors/ApiError;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/RoadsApi$SpeedsResponse;->error:Lcom/google/maps/errors/ApiError;

    iget-object v1, v1, Lcom/google/maps/errors/ApiError;->message:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 186
    invoke-virtual {p0}, Lcom/google/maps/RoadsApi$SpeedsResponse;->getResult()[Lcom/google/maps/model/SpeedLimit;

    move-result-object v0

    return-object v0
.end method

.method public getResult()[Lcom/google/maps/model/SpeedLimit;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/google/maps/RoadsApi$SpeedsResponse;->speedLimits:[Lcom/google/maps/model/SpeedLimit;

    return-object v0
.end method

.method public successful()Z
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/google/maps/RoadsApi$SpeedsResponse;->error:Lcom/google/maps/errors/ApiError;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
