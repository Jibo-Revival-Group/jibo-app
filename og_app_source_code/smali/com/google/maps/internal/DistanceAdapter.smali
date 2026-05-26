.class public Lcom/google/maps/internal/DistanceAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "DistanceAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lcom/google/maps/model/Distance;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/model/Distance;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->f()Lcom/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_0

    .line 48
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->j()V

    .line 49
    const/4 v0, 0x0

    .line 65
    :goto_0
    return-object v0

    .line 52
    :cond_0
    new-instance v0, Lcom/google/maps/model/Distance;

    invoke-direct {v0}, Lcom/google/maps/model/Distance;-><init>()V

    .line 54
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    .line 55
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 56
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v1

    .line 57
    const-string v2, "text"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 58
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/google/maps/model/Distance;->humanReadable:Ljava/lang/String;

    goto :goto_1

    .line 59
    :cond_2
    const-string v2, "value"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->l()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/google/maps/model/Distance;->inMeters:J

    goto :goto_1

    .line 63
    :cond_3
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

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
    .line 32
    invoke-virtual {p0, p1}, Lcom/google/maps/internal/DistanceAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/model/Distance;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/model/Distance;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Unimplemented method"

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
    .line 32
    check-cast p2, Lcom/google/maps/model/Distance;

    invoke-virtual {p0, p1, p2}, Lcom/google/maps/internal/DistanceAdapter;->write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/model/Distance;)V

    return-void
.end method
