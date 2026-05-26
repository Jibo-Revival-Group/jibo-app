.class public Lcom/google/maps/internal/GeolocationResponseAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "GeolocationResponseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lcom/google/maps/GeolocationApi$Response;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Ljava/util/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    const-class v0, Lcom/google/maps/GeolocationApi$Response;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/maps/internal/GeolocationResponseAdapter;->LOG:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/GeolocationApi$Response;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->f()Lcom/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_0

    .line 71
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->j()V

    .line 72
    const/4 v0, 0x0

    .line 127
    :goto_0
    return-object v0

    .line 74
    :cond_0
    new-instance v0, Lcom/google/maps/GeolocationApi$Response;

    invoke-direct {v0}, Lcom/google/maps/GeolocationApi$Response;-><init>()V

    .line 75
    new-instance v1, Lcom/google/maps/internal/LatLngAdapter;

    invoke-direct {v1}, Lcom/google/maps/internal/LatLngAdapter;-><init>()V

    .line 77
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    .line 78
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v2

    if-eqz v2, :cond_10

    .line 79
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v2

    .line 82
    const-string v3, "location"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 84
    invoke-virtual {v1, p1}, Lcom/google/maps/internal/LatLngAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/model/LatLng;

    move-result-object v2

    iput-object v2, v0, Lcom/google/maps/GeolocationApi$Response;->location:Lcom/google/maps/model/LatLng;

    goto :goto_1

    .line 85
    :cond_2
    const-string v3, "accuracy"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 86
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->k()D

    move-result-wide v2

    iput-wide v2, v0, Lcom/google/maps/GeolocationApi$Response;->accuracy:D

    goto :goto_1

    .line 87
    :cond_3
    const-string v3, "error"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 88
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    .line 89
    :cond_4
    :goto_2
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v2

    if-eqz v2, :cond_f

    .line 90
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v2

    .line 92
    const-string v3, "code"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 93
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->m()I

    move-result v2

    iput v2, v0, Lcom/google/maps/GeolocationApi$Response;->code:I

    goto :goto_2

    .line 94
    :cond_5
    const-string v3, "message"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 95
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/google/maps/GeolocationApi$Response;->message:Ljava/lang/String;

    goto :goto_2

    .line 96
    :cond_6
    const-string v3, "errors"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 97
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->a()V

    .line 98
    :goto_3
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v2

    if-eqz v2, :cond_e

    .line 99
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->c()V

    .line 100
    :cond_7
    :goto_4
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->e()Z

    move-result v2

    if-eqz v2, :cond_d

    .line 101
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->g()Ljava/lang/String;

    move-result-object v2

    .line 103
    const-string v3, "reason"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 104
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/google/maps/GeolocationApi$Response;->reason:Ljava/lang/String;

    goto :goto_4

    .line 105
    :cond_8
    const-string v3, "domain"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 106
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/google/maps/GeolocationApi$Response;->domain:Ljava/lang/String;

    goto :goto_4

    .line 107
    :cond_9
    const-string v3, "debugInfo"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 108
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/google/maps/GeolocationApi$Response;->debugInfo:Ljava/lang/String;

    goto :goto_4

    .line 109
    :cond_a
    const-string v3, "message"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 111
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    goto :goto_4

    .line 112
    :cond_b
    const-string v3, "location"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 113
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    goto :goto_4

    .line 114
    :cond_c
    const-string v3, "locationType"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 115
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->h()Ljava/lang/String;

    goto :goto_4

    .line 118
    :cond_d
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

    goto :goto_3

    .line 120
    :cond_e
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->b()V

    goto/16 :goto_2

    .line 123
    :cond_f
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

    goto/16 :goto_1

    .line 126
    :cond_10
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->d()V

    goto/16 :goto_0
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
    invoke-virtual {p0, p1}, Lcom/google/maps/internal/GeolocationResponseAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lcom/google/maps/GeolocationApi$Response;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/GeolocationApi$Response;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
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
    check-cast p2, Lcom/google/maps/GeolocationApi$Response;

    invoke-virtual {p0, p1, p2}, Lcom/google/maps/internal/GeolocationResponseAdapter;->write(Lcom/google/gson/stream/JsonWriter;Lcom/google/maps/GeolocationApi$Response;)V

    return-void
.end method
