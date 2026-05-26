.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;
.super Ljava/lang/Object;
.source "SalesforceOkHttpRequest.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpRequest;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;
    }
.end annotation


# instance fields
.field protected a:Lokhttp3/Request;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;)V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;->a:Lokhttp3/Request$Builder;

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a:Lokhttp3/Request;

    .line 64
    return-void
.end method

.method constructor <init>(Lokhttp3/Request;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a:Lokhttp3/Request;

    .line 60
    return-void
.end method

.method public static a(Lokhttp3/Request;)Lcom/salesforce/android/service/common/http/HttpRequest;
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;-><init>(Lokhttp3/Request;)V

    return-object v0
.end method

.method public static c()Lcom/salesforce/android/service/common/http/HttpRequestBuilder;
    .locals 1

    .prologue
    .line 51
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest$Builder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/http/HttpUrl;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a:Lokhttp3/Request;

    invoke-virtual {v0}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;

    move-result-object v0

    return-object v0
.end method

.method public b()Lokhttp3/Request;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a:Lokhttp3/Request;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpRequest;->a:Lokhttp3/Request;

    invoke-virtual {v0}, Lokhttp3/Request;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
