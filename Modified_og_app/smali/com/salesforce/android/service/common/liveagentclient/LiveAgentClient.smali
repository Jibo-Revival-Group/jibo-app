.class public Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;
.super Ljava/lang/Object;
.source "LiveAgentClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;
    }
.end annotation


# static fields
.field private static final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field a:Ljava/lang/String;

.field private final c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private final d:Lcom/salesforce/android/service/common/http/HttpClient;

.field private final e:Lcom/google/gson/Gson;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;)V
    .locals 5

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Initializing LiveAgentClient for pod {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    .line 90
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->c:Lcom/salesforce/android/service/common/http/HttpClient;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 91
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 92
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->d:Lcom/google/gson/Gson;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->e:Lcom/google/gson/Gson;

    .line 93
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 122
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/http/HttpClient;I)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;I)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;I)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/http/HttpClient;I)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;J)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;J)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 153
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->d:Lcom/salesforce/android/service/common/http/HttpClient;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClient;->a()Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 154
    invoke-interface {v0, p3, p4, v1}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->b(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 155
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    .line 156
    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/http/HttpClient;I)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/http/HttpClient;I)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/salesforce/android/service/common/http/HttpClient;",
            "I)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 183
    if-lez p4, :cond_0

    .line 184
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Sending #{} {} to LiveAgent: URL[{}] - Body[{}]"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    .line 185
    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    invoke-interface {p1, v3}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->e:Lcom/google/gson/Gson;

    invoke-interface {p1, v3}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a(Lcom/google/gson/Gson;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v7

    .line 184
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 191
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->e:Lcom/google/gson/Gson;

    invoke-interface {p1, v0, v1, p4}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 192
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->e:Lcom/google/gson/Gson;

    invoke-static {p3, v0, p2, v2}, Lcom/salesforce/android/service/common/http/HttpJob;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0

    .line 187
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Sending {} to LiveAgent: URL[{}] - Body[{}]"

    new-array v2, v7, [Ljava/lang/Object;

    .line 188
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    invoke-interface {p1, v3}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->e:Lcom/google/gson/Gson;

    invoke-interface {p1, v3}, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a(Lcom/google/gson/Gson;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    .line 187
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 106
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Updating LiveAgentClient pod: {} --> {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 107
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;->a:Ljava/lang/String;

    .line 108
    return-void
.end method
