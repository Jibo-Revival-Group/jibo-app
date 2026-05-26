.class public Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;
.super Ljava/lang/Object;
.source "LiveAgentClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Ljava/lang/String;

.field protected b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field protected c:Lcom/salesforce/android/service/common/http/HttpClient;

.field protected d:Lcom/google/gson/Gson;

.field private e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

.field private f:Z

.field private g:Lcom/google/gson/GsonBuilder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 200
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 208
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->f:Z

    return-void
.end method


# virtual methods
.method public a(Lcom/google/gson/GsonBuilder;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;
    .locals 0

    .prologue
    .line 227
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->g:Lcom/google/gson/GsonBuilder;

    .line 228
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a:Ljava/lang/String;

    .line 213
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 242
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/String;)V

    .line 244
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_0

    .line 245
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v1

    invoke-static {v5, v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 248
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->c:Lcom/salesforce/android/service/common/http/HttpClient;

    if-nez v0, :cond_1

    .line 250
    new-instance v0, Lokhttp3/ConnectionSpec$Builder;

    sget-object v1, Lokhttp3/ConnectionSpec;->a:Lokhttp3/ConnectionSpec;

    invoke-direct {v0, v1}, Lokhttp3/ConnectionSpec$Builder;-><init>(Lokhttp3/ConnectionSpec;)V

    new-array v1, v4, [Lokhttp3/TlsVersion;

    sget-object v2, Lokhttp3/TlsVersion;->TLS_1_2:Lokhttp3/TlsVersion;

    aput-object v2, v1, v3

    .line 251
    invoke-virtual {v0, v1}, Lokhttp3/ConnectionSpec$Builder;->a([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;

    move-result-object v0

    .line 252
    invoke-virtual {v0}, Lokhttp3/ConnectionSpec$Builder;->a()Lokhttp3/ConnectionSpec;

    move-result-object v0

    .line 253
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->a()Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v1

    new-array v2, v5, [Lokhttp3/ConnectionSpec;

    aput-object v0, v2, v3

    sget-object v0, Lokhttp3/ConnectionSpec;->c:Lokhttp3/ConnectionSpec;

    aput-object v0, v2, v4

    .line 255
    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Ljava/util/List;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/service/common/http/TlsSocketFactory;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/http/TlsSocketFactory;-><init>()V

    .line 257
    invoke-static {}, Lcom/salesforce/android/service/common/http/TlsSocketFactory;->a()Ljavax/net/ssl/X509TrustManager;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    .line 258
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpClientBuilder;->a()Lcom/salesforce/android/service/common/http/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->c:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 261
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    if-nez v0, :cond_2

    .line 262
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    .line 265
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->g:Lcom/google/gson/GsonBuilder;

    if-nez v0, :cond_3

    .line 266
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->g:Lcom/google/gson/GsonBuilder;

    .line 269
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->g:Lcom/google/gson/GsonBuilder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;

    iget-boolean v2, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->f:Z

    invoke-static {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/json/GsonFactory;->a(Lcom/google/gson/GsonBuilder;Lcom/salesforce/android/service/common/liveagentclient/LiveAgentMessageRegistry;Z)Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->d:Lcom/google/gson/Gson;

    .line 271
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;-><init>(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;)V

    return-object v0
.end method
