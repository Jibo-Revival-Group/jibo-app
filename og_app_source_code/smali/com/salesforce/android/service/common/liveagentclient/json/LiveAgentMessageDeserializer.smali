.class Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;
.super Ljava/lang/Object;
.source "LiveAgentMessageDeserializer.java"

# interfaces
.implements Lcom/google/gson/JsonDeserializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonDeserializer",
        "<",
        "Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;)V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    .line 55
    return-void
.end method


# virtual methods
.method public a(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 59
    if-nez p1, :cond_0

    .line 60
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Unable to deserialize LiveAgentMessage - Element is null"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 61
    const/4 v0, 0x0

    .line 76
    :goto_0
    return-object v0

    .line 64
    :cond_0
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    .line 66
    const-string v1, "type"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v1

    .line 67
    const-string v2, "message"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->b:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    .line 70
    if-nez v3, :cond_1

    .line 71
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Unregistered LiveAgent Message encountered. Type[{}] - Content[{}] "

    new-array v4, v8, [Ljava/lang/Object;

    aput-object v1, v4, v6

    aput-object v2, v4, v7

    invoke-interface {v0, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 72
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;-><init>(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    goto :goto_0

    .line 75
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v4, "De-serializing LiveAgentMessage - Type[{}] - Class[{}] - Content[{}]"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    aput-object v2, v5, v8

    invoke-interface {v0, v4, v5}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 76
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;

    invoke-interface {p3, v2, v3}, Lcom/google/gson/JsonDeserializationContext;->a(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public synthetic deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 47
    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;->a(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;

    move-result-object v0

    return-object v0
.end method
