.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;
.super Ljava/lang/Object;
.source "SalesforceOkHttpClient.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpClientBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected final a:Lokhttp3/OkHttpClient$Builder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 180
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 181
    new-instance v0, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v0}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    .line 182
    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;)V
    .locals 1

    .prologue
    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a:Lokhttp3/OkHttpClient;

    invoke-virtual {v0}, Lokhttp3/OkHttpClient;->y()Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    .line 186
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/http/HttpClient;
    .locals 2

    .prologue
    .line 318
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;

    iget-object v1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v1}, Lokhttp3/OkHttpClient$Builder;->a()Lokhttp3/OkHttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;-><init>(Lokhttp3/OkHttpClient;)V

    return-object v0
.end method

.method public a(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2, p3}, Lokhttp3/OkHttpClient$Builder;->a(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 195
    return-object p0
.end method

.method public a(Ljava/util/List;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lokhttp3/ConnectionSpec;",
            ">;)",
            "Lcom/salesforce/android/service/common/http/HttpClientBuilder;"
        }
    .end annotation

    .prologue
    .line 300
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->a(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;

    .line 301
    return-object p0
.end method

.method public a(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/OkHttpClient$Builder;->a(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;

    .line 246
    return-object p0
.end method

.method public a(Lokhttp3/Cache;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;

    .line 225
    return-object p0
.end method

.method public a(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 190
    return-object p0
.end method

.method public b(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1, p2, p3}, Lokhttp3/OkHttpClient$Builder;->b(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 200
    return-object p0
.end method

.method public b(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;->a:Lokhttp3/OkHttpClient$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->b(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 314
    return-object p0
.end method
