.class public Lcom/google/maps/PhotoRequest;
.super Lcom/google/maps/PendingResultBase;
.source "PhotoRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/PhotoRequest$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/maps/PendingResultBase",
        "<",
        "Lcom/google/maps/model/PhotoResult;",
        "Lcom/google/maps/PhotoRequest;",
        "Lcom/google/maps/PhotoRequest$Response;",
        ">;"
    }
.end annotation


# static fields
.field static final API_CONFIG:Lcom/google/maps/internal/ApiConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    new-instance v0, Lcom/google/maps/internal/ApiConfig;

    const-string v1, "/maps/api/place/photo"

    invoke-direct {v0, v1}, Lcom/google/maps/internal/ApiConfig;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/maps/PhotoRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    return-void
.end method

.method public constructor <init>(Lcom/google/maps/GeoApiContext;)V
    .locals 2

    .prologue
    .line 33
    sget-object v0, Lcom/google/maps/PhotoRequest;->API_CONFIG:Lcom/google/maps/internal/ApiConfig;

    const-class v1, Lcom/google/maps/PhotoRequest$Response;

    invoke-direct {p0, p1, v0, v1}, Lcom/google/maps/PendingResultBase;-><init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V

    .line 34
    return-void
.end method


# virtual methods
.method public maxHeight(I)Lcom/google/maps/PhotoRequest;
    .locals 2

    .prologue
    .line 65
    const-string v0, "maxheight"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/PhotoRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PhotoRequest;

    return-object v0
.end method

.method public maxWidth(I)Lcom/google/maps/PhotoRequest;
    .locals 2

    .prologue
    .line 76
    const-string v0, "maxwidth"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/google/maps/PhotoRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PhotoRequest;

    return-object v0
.end method

.method public photoReference(Ljava/lang/String;)Lcom/google/maps/PhotoRequest;
    .locals 1

    .prologue
    .line 54
    const-string v0, "photoreference"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PhotoRequest;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    check-cast v0, Lcom/google/maps/PhotoRequest;

    return-object v0
.end method

.method protected validateRequest()V
    .locals 2

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/google/maps/PhotoRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "photoreference"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'photoReference\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/PhotoRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "maxheight"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/google/maps/PhotoRequest;->params()Ljava/util/Map;

    move-result-object v0

    const-string v1, "maxwidth"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must contain \'maxHeight\' or \'maxWidth\'."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_1
    return-void
.end method
