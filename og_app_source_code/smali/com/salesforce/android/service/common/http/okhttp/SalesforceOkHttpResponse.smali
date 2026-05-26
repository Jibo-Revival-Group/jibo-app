.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;
.super Ljava/lang/Object;
.source "SalesforceOkHttpResponse.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpResponse;


# instance fields
.field private final a:Lokhttp3/Response;


# direct methods
.method constructor <init>(Lokhttp3/Response;)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    .line 57
    return-void
.end method

.method public static a(Lokhttp3/Response;)Lcom/salesforce/android/service/common/http/HttpResponse;
    .locals 1

    .prologue
    .line 52
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;-><init>(Lokhttp3/Response;)V

    return-object v0
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->c()I

    move-result v0

    return v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->d()Z

    move-result v0

    return v0
.end method

.method public c()Lcom/salesforce/android/service/common/http/HttpResponseBody;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->h()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a(Lokhttp3/ResponseBody;)Lcom/salesforce/android/service/common/http/HttpResponseBody;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->close()V

    .line 141
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
