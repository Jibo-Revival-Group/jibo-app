.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;
.super Ljava/lang/Object;
.source "SalesforceOkHttpRequest.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpRequestBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected final a:Lokhttp3/Request$Builder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 118
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 119
    new-instance v0, Lokhttp3/Request$Builder;

    invoke-direct {v0}, Lokhttp3/Request$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    .line 120
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->a()Lokhttp3/Request$Builder;

    .line 173
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->a(Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 143
    return-object p0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 128
    return-object p0
.end method

.method public a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    .line 138
    return-object p0
.end method

.method public a(Lokhttp3/RequestBody;)Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->a(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    .line 183
    return-object p0
.end method

.method public b()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->b()Lokhttp3/Request$Builder;

    .line 203
    return-object p0
.end method

.method public c()Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 1

    .prologue
    .line 242
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;-><init>(Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;)V

    return-object v0
.end method
