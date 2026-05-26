.class public Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;
.super Ljava/lang/Object;
.source "CreateSessionRequest.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 3

    .prologue
    .line 53
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 54
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/liveagentclient/request/CreateSessionRequest;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "Accept"

    const-string v2, "application/json; charset=utf-8"

    .line 55
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-api-version"

    const-string v2, "37"

    .line 56
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    const-string v1, "x-liveagent-affinity"

    const-string v2, "null"

    .line 57
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 58
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 59
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 53
    return-object v0
.end method

.method public a(Lcom/google/gson/Gson;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p1, p0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 41
    const-string v0, "https://%s/chat/rest/%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "LiveAgent Pod must not be null"

    .line 42
    invoke-static {p1, v3}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "System/SessionId"

    aput-object v3, v1, v2

    .line 41
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
