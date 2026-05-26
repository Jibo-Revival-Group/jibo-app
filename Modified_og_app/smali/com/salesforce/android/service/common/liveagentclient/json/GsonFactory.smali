.class public Lcom/salesforce/android/service/common/liveagentclient/json/GsonFactory;
.super Ljava/lang/Object;
.source "GsonFactory.java"


# direct methods
.method public static a(Lcom/google/gson/GsonBuilder;Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;Z)Lcom/google/gson/Gson;
    .locals 3

    .prologue
    .line 44
    if-eqz p2, :cond_0

    .line 45
    const-class v0, Ljava/util/Collection;

    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/json/CollectionSerializer;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentclient/json/CollectionSerializer;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/Class;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    .line 48
    :cond_0
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/response/LiveAgentStringResponse;

    new-instance v1, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentStringResponseDeserializer;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentStringResponseDeserializer;-><init>()V

    .line 49
    invoke-virtual {p0, v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;

    new-instance v2, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;

    invoke-direct {v2, p1}, Lcom/salesforce/android/service/common/liveagentclient/json/LiveAgentMessageDeserializer;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;)V

    .line 50
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/Class;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 51
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    .line 48
    return-object v0
.end method
