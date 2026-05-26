.class Lcom/google/maps/TimeZoneApi$Response;
.super Ljava/lang/Object;
.source "TimeZoneApi.java"

# interfaces
.implements Lcom/google/maps/internal/ApiResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/TimeZoneApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Response"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/maps/internal/ApiResponse",
        "<",
        "Ljava/util/TimeZone;",
        ">;"
    }
.end annotation


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public status:Ljava/lang/String;

.field private timeZoneId:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getError()Lcom/google/maps/errors/ApiException;
    .locals 2

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/google/maps/TimeZoneApi$Response;->successful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 79
    const/4 v0, 0x0

    .line 81
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/TimeZoneApi$Response;->status:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/TimeZoneApi$Response;->errorMessage:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/maps/errors/ApiException;->from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/google/maps/TimeZoneApi$Response;->getResult()Ljava/util/TimeZone;

    move-result-object v0

    return-object v0
.end method

.method public getResult()Ljava/util/TimeZone;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/google/maps/TimeZoneApi$Response;->timeZoneId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 71
    const/4 v0, 0x0

    .line 73
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/maps/TimeZoneApi$Response;->timeZoneId:Ljava/lang/String;

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    goto :goto_0
.end method

.method public successful()Z
    .locals 2

    .prologue
    .line 65
    const-string v0, "OK"

    iget-object v1, p0, Lcom/google/maps/TimeZoneApi$Response;->status:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
