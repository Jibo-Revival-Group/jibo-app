.class public Lcom/salesforce/androidsdk/rest/RestResponse;
.super Ljava/lang/Object;
.source "RestResponse.java"


# instance fields
.field private final a:Lokhttp3/Response;

.field private b:Z

.field private c:[B

.field private d:Ljava/nio/charset/Charset;

.field private e:Ljava/lang/String;

.field private f:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Lokhttp3/Response;)V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    .line 75
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->c()I

    move-result v0

    return v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->d()Z

    move-result v0

    return v0
.end method

.method public c()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->b:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    if-eqz v0, :cond_2

    .line 115
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->h()Lokhttp3/ResponseBody;

    move-result-object v0

    .line 116
    if-eqz v0, :cond_4

    .line 117
    invoke-virtual {v0}, Lokhttp3/ResponseBody;->a()Lokhttp3/MediaType;

    move-result-object v1

    .line 118
    invoke-virtual {v0}, Lokhttp3/ResponseBody;->d()[B

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    .line 119
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lokhttp3/MediaType;->b()Ljava/nio/charset/Charset;

    move-result-object v0

    if-nez v0, :cond_3

    :cond_0
    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    :goto_0
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->d:Ljava/nio/charset/Charset;

    .line 120
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    array-length v0, v0

    if-lez v0, :cond_1

    .line 121
    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->d:Ljava/nio/charset/Charset;

    invoke-direct {v0, v1, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->e:Ljava/lang/String;

    .line 128
    :cond_1
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->b:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 130
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->close()V

    .line 133
    :cond_2
    return-void

    .line 119
    :cond_3
    :try_start_1
    invoke-virtual {v1}, Lokhttp3/MediaType;->b()Ljava/nio/charset/Charset;

    move-result-object v0

    goto :goto_0

    .line 124
    :cond_4
    const/4 v0, 0x0

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    .line 125
    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->d:Ljava/nio/charset/Charset;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 130
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v1}, Lokhttp3/Response;->close()V

    throw v0
.end method

.method public d()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 152
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    if-nez v0, :cond_0

    .line 153
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestResponse;->c()V

    .line 155
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->c:[B

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 193
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->e:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 194
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestResponse;->d()[B

    move-result-object v0

    .line 195
    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->d:Ljava/nio/charset/Charset;

    invoke-direct {v1, v0, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    iput-object v1, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->e:Ljava/lang/String;

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->e:Ljava/lang/String;

    return-object v0
.end method

.method public f()Lorg/json/JSONObject;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->f:Lorg/json/JSONObject;

    if-nez v0, :cond_0

    .line 209
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestResponse;->e()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->f:Lorg/json/JSONObject;

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->f:Lorg/json/JSONObject;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 258
    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestResponse;->e()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 261
    :goto_0
    return-object v0

    .line 259
    :catch_0
    move-exception v0

    .line 260
    const-string v1, "RestResponse"

    const-string v2, "Exception thrown while converting to string"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 261
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    if-nez v0, :cond_0

    const-string v0, ""

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestResponse;->a:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
