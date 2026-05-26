.class Lcom/google/maps/ElevationApi$MultiResponse;
.super Ljava/lang/Object;
.source "ElevationApi.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/ElevationApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MultiResponse"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<[",
        "Lcom/google/maps/model/ElevationResult;",
        ">;"
    }
.end annotation


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public results:[Lcom/google/maps/model/ElevationResult;

.field public status:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/google/maps/ElevationApi$MultiResponse;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 168
    const/4 v0, 0x0

    .line 170
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/ElevationApi$MultiResponse;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/ElevationApi$MultiResponse;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/google/maps/ElevationApi$MultiResponse;->getResult()[Lcom/google/maps/model/ElevationResult;

    move-result-object v0

    return-object v0
.end method

.method public getResult()[Lcom/google/maps/model/ElevationResult;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/google/maps/ElevationApi$MultiResponse;->results:[Lcom/google/maps/model/ElevationResult;

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 157
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/ElevationApi$MultiResponse;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
