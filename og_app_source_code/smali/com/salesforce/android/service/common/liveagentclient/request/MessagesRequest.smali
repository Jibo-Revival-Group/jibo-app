.class public Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;
.super Ljava/lang/Object;
.source "MessagesRequest.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentSessionRequest;


# instance fields
.field private final transient b:Ljava/lang/String;

.field private final transient c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->b:Ljava/lang/String;

    .line 46
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->c:Ljava/lang/String;

    .line 47
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 3

    .prologue
    .line 70
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 71
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept"

    const-string v2, "application/json; charset=utf-8"

    .line 72
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-api-version"

    const-string v2, "37"

    .line 73
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-session-key"

    .line 74
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-affinity"

    .line 75
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 76
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 77
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 70
    return-object v0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->b:Ljava/lang/String;

    return-object v0
.end method

.method public a(Lcom/google/gson/Gson;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p1, p0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 58
    const-string v0, "https://%s/chat/rest/%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "LiveAgent Pod must not be null"

    .line 59
    invoke-static {p1, v3}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "System/Messages"

    aput-object v3, v1, v2

    .line 58
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/request/MessagesRequest;->c:Ljava/lang/String;

    return-object v0
.end method
