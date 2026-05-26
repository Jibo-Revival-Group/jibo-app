.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;
.super Ljava/lang/Object;
.source "BatchedEventsSerializer.java"

# interfaces
.implements Lcom/google/gson/JsonSerializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonSerializer",
        "<",
        "Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-class v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 80
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 81
    const-class v1, Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 82
    const-class v1, Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;

    .line 83
    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;->a()Ljava/lang/String;

    move-result-object v0

    .line 86
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 7

    .prologue
    .line 54
    new-instance v1, Lcom/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/google/gson/JsonObject;-><init>()V

    .line 56
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    .line 58
    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 61
    if-nez v3, :cond_0

    .line 62
    sget-object v3, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v4, "Ignoring unknown batched event {}"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-interface {v3, v4, v5}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 66
    :cond_0
    invoke-virtual {v1, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 68
    new-instance v4, Lcom/google/gson/JsonArray;

    invoke-direct {v4}, Lcom/google/gson/JsonArray;-><init>()V

    invoke-virtual {v1, v3, v4}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 72
    :cond_1
    const-class v4, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    invoke-interface {p3, v0, v4}, Lcom/google/gson/JsonSerializationContext;->a(Ljava/lang/Object;Ljava/lang/reflect/Type;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 73
    invoke-virtual {v1, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->m()Lcom/google/gson/JsonArray;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/google/gson/JsonArray;->a(Lcom/google/gson/JsonElement;)V

    goto :goto_0

    .line 76
    :cond_2
    return-object v1
.end method

.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 1

    .prologue
    .line 47
    check-cast p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;

    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BatchedEventsSerializer;->a(Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;

    move-result-object v0

    return-object v0
.end method
