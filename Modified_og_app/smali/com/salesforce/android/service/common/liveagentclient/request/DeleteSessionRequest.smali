.class public Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;
.super Ljava/lang/Object;
.source "DeleteSessionRequest.java"

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
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->b:Ljava/lang/String;

    .line 46
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->c:Ljava/lang/String;

    .line 47
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 3

    .prologue
    .line 71
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 72
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept"

    const-string v2, "application/json; charset=utf-8"

    .line 73
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-api-version"

    const-string v2, "37"

    .line 74
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-session-key"

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->b:Ljava/lang/String;

    .line 75
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-affinity"

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->c:Ljava/lang/String;

    .line 76
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 77
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 78
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 71
    return-object v0
.end method

.method public a(Lcom/google/gson/Gson;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    invoke-virtual {p1, p0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 58
    const-string v0, "https://%s/chat/rest/%s/%s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "LiveAgent Pod must not be null"

    .line 59
    invoke-static {p1, v3}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "System/SessionId"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/request/DeleteSessionRequest;->b:Ljava/lang/String;

    aput-object v3, v1, v2

    .line 58
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
