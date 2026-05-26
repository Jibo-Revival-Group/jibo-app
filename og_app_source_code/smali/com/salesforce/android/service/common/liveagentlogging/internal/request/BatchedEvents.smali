.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;
.super Ljava/lang/Object;
.source "BatchedEvents.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentSessionRequest;


# instance fields
.field private final transient b:Ljava/lang/String;

.field private final transient c:Ljava/lang/String;

.field private final transient d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->b:Ljava/lang/String;

    .line 74
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->c:Ljava/lang/String;

    .line 75
    iput-object p3, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->d:Ljava/util/List;

    .line 76
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 3

    .prologue
    .line 110
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 111
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept"

    const-string v2, "application/json; charset=utf-8"

    .line 112
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-api-version"

    const-string v2, "37"

    .line 113
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-session-key"

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->b:Ljava/lang/String;

    .line 114
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-affinity"

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->c:Ljava/lang/String;

    .line 115
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-sequence"

    .line 116
    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->a:Lokhttp3/MediaType;

    .line 117
    invoke-virtual {p0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->a(Lcom/google/gson/Gson;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lokhttp3/RequestBody;->a(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Lokhttp3/RequestBody;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 118
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 110
    return-object v0
.end method

.method public a(Lcom/google/gson/Gson;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p1, p0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 99
    const-string v0, "https://%s/chat/rest/%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "LiveAgent Pod must not be null"

    .line 100
    invoke-static {p1, v3}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "WebEvent/BatchedEvents"

    aput-object v3, v1, v2

    .line 99
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;->d:Ljava/util/List;

    return-object v0
.end method
