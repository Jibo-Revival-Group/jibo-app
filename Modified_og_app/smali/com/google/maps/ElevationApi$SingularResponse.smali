.class Lcom/google/maps/ElevationApi$SingularResponse;
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
    name = "SingularResponse"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<",
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
    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/google/maps/ElevationApi$SingularResponse;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    const/4 v0, 0x0

    .line 133
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/ElevationApi$SingularResponse;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/ElevationApi$SingularResponse;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public getResult()Lcom/google/maps/model/ElevationResult;
    .locals 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/google/maps/ElevationApi$SingularResponse;->results:[Lcom/google/maps/model/ElevationResult;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 113
    invoke-virtual {p0}, Lcom/google/maps/ElevationApi$SingularResponse;->getResult()Lcom/google/maps/model/ElevationResult;

    move-result-object v0

    return-object v0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 120
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/ElevationApi$SingularResponse;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
