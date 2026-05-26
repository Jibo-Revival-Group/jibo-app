.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;
.super Ljava/lang/Object;
.source "SalesforceOkHttpClient.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;
    }
.end annotation


# instance fields
.field protected final a:Lokhttp3/OkHttpClient;


# direct methods
.method constructor <init>(Lokhttp3/OkHttpClient;)V
    .locals 0

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a:Lokhttp3/OkHttpClient;

    .line 74
    return-void
.end method

.method public static a(Lokhttp3/OkHttpClient;)Lcom/salesforce/android/service/common/http/HttpClient;
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;-><init>(Lokhttp3/OkHttpClient;)V

    return-object v0
.end method

.method public static b()Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpCall;
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;->a:Lokhttp3/OkHttpClient;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/http/HttpRequest;->b()Lokhttp3/Request;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient;->a(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;->a(Lokhttp3/Call;)Lcom/salesforce/android/service/common/http/HttpCall;

    move-result-object v0

    return-object v0
.end method

.method public a()Lcom/salesforce/android/service/common/http/HttpClientBuilder;
    .locals 1

    .prologue
    .line 173
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient$Builder;-><init>(Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpClient;)V

    return-object v0
.end method
