.class public Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "CaseDetailResponseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter",
        "<",
        "Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/google/gson/Gson;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 49
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a:Lcom/google/gson/Gson;

    .line 50
    return-void
.end method

.method public static a()Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/google/gson/stream/JsonReader;)Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a:Lcom/google/gson/Gson;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a:Lcom/google/gson/Gson;

    const-class v2, Ljava/lang/Object;

    invoke-virtual {v1, p1, v2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a:Lcom/google/gson/Gson;

    const-class v2, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    .line 70
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 71
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

    .line 72
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 73
    const-string v5, "__c"

    invoke-virtual {v2, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 74
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/gson/JsonElement;

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 79
    :cond_1
    invoke-virtual {v0, v3}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->a(Ljava/util/Map;)V

    .line 81
    return-object v0
.end method

.method public a(Lcom/google/gson/stream/JsonWriter;Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
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
    .line 44
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a(Lcom/google/gson/stream/JsonReader;)Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

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
    .line 44
    check-cast p2, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/http/util/CaseDetailResponseAdapter;->a(Lcom/google/gson/stream/JsonWriter;Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)V

    return-void
.end method
