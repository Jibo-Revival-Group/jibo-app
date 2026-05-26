.class public Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;
.super Ljava/lang/Object;
.source "SalesforceHttpUrl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/http/HttpUrl;


# instance fields
.field private a:Lokhttp3/HttpUrl;


# direct methods
.method protected constructor <init>(Lokhttp3/HttpUrl;)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a:Lokhttp3/HttpUrl;

    .line 51
    return-void
.end method

.method public static a(Lokhttp3/HttpUrl;)Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;
    .locals 1

    .prologue
    .line 46
    new-instance v0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;-><init>(Lokhttp3/HttpUrl;)V

    return-object v0
.end method


# virtual methods
.method public a()Lokhttp3/HttpUrl;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a:Lokhttp3/HttpUrl;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    .prologue
    .line 175
    instance-of v0, p1, Lcom/salesforce/android/service/common/http/HttpUrl;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a:Lokhttp3/HttpUrl;

    check-cast p1, Lcom/salesforce/android/service/common/http/HttpUrl;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/http/HttpUrl;->a()Lokhttp3/HttpUrl;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/HttpUrl;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/okhttp/SalesforceHttpUrl;->a:Lokhttp3/HttpUrl;

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
