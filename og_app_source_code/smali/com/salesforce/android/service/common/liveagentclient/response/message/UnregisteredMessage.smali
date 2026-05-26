.class public Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;
.super Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;
.source "UnregisteredMessage.java"


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/google/gson/JsonElement;)V
    .locals 1

    .prologue
    .line 48
    const-string v0, "UNKNOWN"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 49
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;->a:Ljava/lang/String;

    .line 50
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 53
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    const-string v1, "Unregistered Live Agent Message. Type[%s] - Content[%s]"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;->a:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-class v4, Lcom/google/gson/JsonElement;

    .line 54
    invoke-virtual {p0, v4}, Lcom/salesforce/android/service/common/liveagentclient/response/message/UnregisteredMessage;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v2, v3

    .line 53
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
