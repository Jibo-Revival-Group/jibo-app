.class public Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "DefaultValuesResponseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/google/gson/Gson;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 48
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a:Lcom/google/gson/Gson;

    .line 49
    return-void
.end method

.method public static a()Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;
    .locals 1

    .prologue
    .line 52
    new-instance v0, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/google/gson/stream/JsonReader;)Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a:Lcom/google/gson/Gson;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a:Lcom/google/gson/Gson;

    const-class v2, Ljava/lang/Object;

    invoke-virtual {v1, p1, v2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a:Lcom/google/gson/Gson;

    const-class v2, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    .line 69
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 70
    invoke-virtual {v1}, Lcom/google/gson/JsonObject;->a()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 71
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 72
    const-string v5, "attributes"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 73
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/gson/JsonElement;

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 78
    :cond_1
    invoke-virtual {v0, v3}, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;->a(Ljava/util/Map;)V

    .line 80
    return-object v0
.end method

.method public a(Lcom/google/gson/stream/JsonWriter;Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    return-void
.end method

.method public synthetic read(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a(Lcom/google/gson/stream/JsonReader;)Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    move-result-object v0

    return-object v0
.end method

.method public synthetic write(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 43
    check-cast p2, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/http/util/DefaultValuesResponseAdapter;->a(Lcom/google/gson/stream/JsonWriter;Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;)V

    return-void
.end method
