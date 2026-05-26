.class public interface abstract Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.super Ljava/lang/Object;
.source "HttpClientBuilder.java"


# virtual methods
.method public abstract a()Lcom/salesforce/android/service/common/http/HttpClient;
.end method

.method public abstract a(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method

.method public abstract a(Ljava/util/List;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
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
.end method

.method public abstract a(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method

.method public abstract a(Lokhttp3/Cache;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method

.method public abstract a(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method

.method public abstract b(JLjava/util/concurrent/TimeUnit;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method

.method public abstract b(Lokhttp3/Interceptor;)Lcom/salesforce/android/service/common/http/HttpClientBuilder;
.end method
