.class Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;
.super Ljava/lang/Object;
.source "ResourceDownload.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Ljava/lang/String;

.field private final c:Lcom/salesforce/android/service/common/http/HttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    const-class v0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/salesforce/android/service/common/http/HttpClient;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->b:Ljava/lang/String;

    .line 48
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->c:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 49
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Z
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 52
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->b:Ljava/lang/String;

    invoke-static {v0}, Lokhttp3/HttpUrl;->e(Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    .line 53
    if-nez v0, :cond_0

    .line 54
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Invalid url"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 57
    :cond_0
    sget-object v1, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Starting download of resource at {}"

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->b:Ljava/lang/String;

    aput-object v4, v3, v7

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 60
    invoke-static {}, Lcom/salesforce/android/service/common/http/HttpFactory;->b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v1

    .line 61
    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    .line 62
    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpRequestBuilder;->c()Lcom/salesforce/android/service/common/http/HttpRequest;

    move-result-object v0

    .line 65
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->c:Lcom/salesforce/android/service/common/http/HttpClient;

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/http/HttpClient;->a(Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpCall;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpCall;->a()Lcom/salesforce/android/service/common/http/HttpResponse;

    move-result-object v1

    .line 66
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->c()Lcom/salesforce/android/service/common/http/HttpResponseBody;

    move-result-object v2

    .line 68
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->b()Z

    move-result v0

    .line 71
    if-eqz v0, :cond_1

    .line 72
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->b:Ljava/lang/String;

    invoke-interface {v2}, Lcom/salesforce/android/service/common/http/HttpResponseBody;->a()Lokio/BufferedSource;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a(Ljava/lang/String;Lokio/Source;)Z

    move-result v0

    .line 77
    :goto_0
    invoke-interface {v2}, Lcom/salesforce/android/service/common/http/HttpResponseBody;->close()V

    .line 78
    return v0

    .line 74
    :cond_1
    sget-object v3, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v4, "Error downloading {}. Code {}"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->b:Ljava/lang/String;

    aput-object v6, v5, v7

    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->a()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v5, v8

    invoke-interface {v3, v4, v5}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
