.class public Lcom/google/maps/internal/DateTimeAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "DateTimeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lorg/joda/time/DateTime;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic read(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/google/maps/internal/DateTimeAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lorg/joda/time/DateTime;

    move-result-object v0

    return-object v0
.end method

.method public read(Lcom/google/gson/stream/JsonReader;)Lorg/joda/time/DateTime;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->f()Lcom/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_0

    .line 51
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->j()V

    .line 52
    const/4 v0, 0x0

    .line 72
    :goto_0
    return-object v0

    .line 55
    :cond_0
    const-string v2, ""

    .line 56
    const-wide/16 v0, 0x0

    .line 58
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    .line 59
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 60
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v3

    .line 61
    const-string v4, "text"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 63
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    goto :goto_1

    .line 64
    :cond_2
    const-string v4, "time_zone"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 65
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 66
    :cond_3
    const-string v4, "value"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 67
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->l()J

    move-result-wide v0

    goto :goto_1

    .line 70
    :cond_4
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

    .line 72
    new-instance v3, Lorg/joda/time/DateTime;

    const-wide/16 v4, 0x3e8

    mul-long/2addr v0, v4

    invoke-static {v2}, Lorg/joda/time/DateTimeZone;->a(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;

    move-result-object v2

    invoke-direct {v3, v0, v1, v2}, Lorg/joda/time/DateTime;-><init>(JLorg/joda/time/DateTimeZone;)V

    move-object v0, v3

    goto :goto_0
.end method

.method public bridge synthetic write(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    check-cast p2, Lorg/joda/time/DateTime;

    invoke-virtual {p0, p1, p2}, Lcom/google/maps/internal/DateTimeAdapter;->write(Lcom/google/gson/stream/JsonWriter;Lorg/joda/time/DateTime;)V

    return-void
.end method

.method public write(Lcom/google/gson/stream/JsonWriter;Lorg/joda/time/DateTime;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Unimplemented method"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
