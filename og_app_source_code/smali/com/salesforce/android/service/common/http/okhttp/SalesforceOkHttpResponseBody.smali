.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;
.super Ljava/lang/Object;
.source "SalesforceOkHttpResponseBody.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpResponseBody;


# instance fields
.field private final a:Lokhttp3/ResponseBody;


# direct methods
.method constructor <init>(Lokhttp3/ResponseBody;)V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a:Lokhttp3/ResponseBody;

    .line 53
    return-void
.end method

.method public static a(Lokhttp3/ResponseBody;)Lcom/salesforce/android/service/common/http/HttpResponseBody;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;-><init>(Lokhttp3/ResponseBody;)V

    return-object v0
.end method


# virtual methods
.method public a()Lokio/BufferedSource;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a:Lokhttp3/ResponseBody;

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->c()Lokio/BufferedSource;

    move-result-object v0

    return-object v0
.end method

.method public b()Ljava/io/Reader;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a:Lokhttp3/ResponseBody;

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->e()Ljava/io/Reader;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a:Lokhttp3/ResponseBody;

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->f()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponseBody;->a:Lokhttp3/ResponseBody;

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->close()V

    .line 85
    return-void
.end method
