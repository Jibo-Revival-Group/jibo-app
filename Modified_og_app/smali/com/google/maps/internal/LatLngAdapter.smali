.class public Lcom/google/maps/internal/LatLngAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "LatLngAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lcom/google/maps/model/LatLng;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/model/LatLng;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v0, 0x0

    const-wide/16 v2, 0x0

    .line 42
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->f()Lcom/google/gson/stream/JsonToken;

    move-result-object v1

    sget-object v4, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    if-ne v1, v4, :cond_0

    .line 43
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->j()V

    move-object v0, v7

    .line 68
    :goto_0
    return-object v0

    .line 52
    :cond_0
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    move v1, v0

    move-wide v4, v2

    .line 53
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 54
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v8

    .line 55
    const-string v9, "lat"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    const-string v9, "latitude"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 56
    :cond_2
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->k()D

    move-result-wide v4

    move v1, v6

    .line 57
    goto :goto_1

    .line 58
    :cond_3
    const-string v9, "lng"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_4

    const-string v9, "longitude"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 59
    :cond_4
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->k()D

    move-result-wide v2

    move v0, v6

    .line 60
    goto :goto_1

    .line 63
    :cond_5
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

    .line 65
    if-eqz v1, :cond_6

    if-eqz v0, :cond_6

    .line 66
    new-instance v0, Lcom/google/maps/model/LatLng;

    invoke-direct {v0, v4, v5, v2, v3}, Lcom/google/maps/model/LatLng;-><init>(DD)V

    goto :goto_0

    :cond_6
    move-object v0, v7

    .line 68
    goto :goto_0
.end method

.method public bridge synthetic read(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 26
    invoke-virtual {p0, p1}, Lcom/google/maps/internal/LatLngAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/model/LatLng;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/model/LatLng;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Unimplemented method."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public bridge synthetic write(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 26
    check-cast p2, Lcom/google/maps/model/LatLng;

    invoke-virtual {p0, p1, p2}, Lcom/google/maps/internal/LatLngAdapter;->write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/model/LatLng;)V

    return-void
.end method
