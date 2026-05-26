.class public Lcom/salesforce/android/service/common/http/HttpFactory;
.super Ljava/lang/Object;
.source "HttpFactory.java"


# direct methods
.method public static a()Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 49
    invoke-static {}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->b()Lcom/salesforce/android/service/common/http/HttpClientBuilder;

    move-result-object v0

    return-object v0
.end method

.method public static b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 53
    invoke-static {}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->c()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;

    move-result-object v0

    return-object v0
.end method
