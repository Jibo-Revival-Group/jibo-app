.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;
.super Ljava/lang/Object;
.source "BaseEventSerializer.java"

# interfaces
.implements Lcom/google/gson/JsonSerializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonSerializer",
        "<",
        "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 6

    .prologue
    .line 51
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->a()Ljava/util/Date;

    move-result-object v0

    .line 54
    new-instance v1, Lcom/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/google/gson/JsonObject;-><init>()V

    .line 55
    const-string v2, "service"

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    const-string v2, "clientType"

    const-string v3, "android"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    const-string v2, "organizationId"

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    const-string v2, "correlationId"

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->c()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string v2, "clientTimestamp"

    invoke-interface {p3, v0}, Lcom/google/gson/JsonSerializationContext;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 61
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Serializing BaseEvent {} with correlation ID {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->c()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 63
    invoke-interface {p3, p1}, Lcom/google/gson/JsonSerializationContext;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 66
    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v2

    const-string v3, "basicInfo"

    invoke-virtual {v2, v3, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 68
    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 1

    .prologue
    .line 45
    check-cast p1, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/android/service/common/liveagentlogging/internal/json/BaseEventSerializer;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;

    move-result-object v0

    return-object v0
.end method
