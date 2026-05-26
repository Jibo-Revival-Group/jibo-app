.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;
.super Ljava/lang/Object;
.source "SalesforceHttpCall.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpCall;


# instance fields
.field private final a:Lokhttp3/Call;


# direct methods
.method constructor <init>(Lokhttp3/Call;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;->a:Lokhttp3/Call;

    .line 52
    return-void
.end method

.method public static a(Lokhttp3/Call;)Lcom/salesforce/android/service/common/http/HttpCall;
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;-><init>(Lokhttp3/Call;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/http/HttpResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpCall;->a:Lokhttp3/Call;

    invoke-static {v0}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->execute(Lokhttp3/Call;)Lokhttp3/Response;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceOkHttpResponse;->a(Lokhttp3/Response;)Lcom/salesforce/android/service/common/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method
