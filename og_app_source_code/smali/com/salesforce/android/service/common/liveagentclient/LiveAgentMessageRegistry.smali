.class public Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;
.super Ljava/lang/Object;
.source "LiveAgentMessageRegistry.java"


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->b:Ljava/util/Map;

    .line 61
    const-string v0, "AsyncResult"

    const-class v1, Lcom/salesforce/android/service/common/liveagentclient/response/message/AsyncResult;

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->a(Ljava/lang/String;Ljava/lang/Class;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    .line 62
    const-string v0, "SwitchServer"

    const-class v1, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->a(Ljava/lang/String;Ljava/lang/Class;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    .line 63
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/Class;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;
    .locals 5

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->b:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Registered LiveAgentMessage content type {} as class {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 79
    return-object p0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/Class;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    return-object v0
.end method
