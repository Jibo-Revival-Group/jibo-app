.class public Lcom/salesforce/androidsdk/analytics/AILTNPublisher;
.super Ljava/lang/Object;
.source "AILTNPublisher.java"

# interfaces
.implements Lcom/salesforce/androidsdk/analytics/AnalyticsPublisher;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 148
    new-instance v0, Lokio/Buffer;

    invoke-direct {v0}, Lokio/Buffer;-><init>()V

    .line 149
    invoke-virtual {p1, v0}, Lokhttp3/RequestBody;->a(Lokio/BufferedSink;)V

    .line 150
    new-instance v1, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;

    invoke-direct {v1, p0, p1, v0}, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;-><init>(Lcom/salesforce/androidsdk/analytics/AILTNPublisher;Lokhttp3/RequestBody;Lokio/Buffer;)V

    return-object v1
.end method

.method private b(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;
    .locals 1

    .prologue
    .line 170
    new-instance v0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;-><init>(Lcom/salesforce/androidsdk/analytics/AILTNPublisher;Lokhttp3/RequestBody;)V

    return-object v0
.end method


# virtual methods
.method public a(Lorg/json/JSONArray;)Z
    .locals 8

    .prologue
    const/4 v0, 0x0

    .line 73
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 74
    :cond_0
    const/4 v0, 0x1

    .line 98
    :goto_0
    return v0

    .line 78
    :cond_1
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    move v1, v0

    .line 80
    :goto_1
    :try_start_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 81
    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 82
    if-eqz v3, :cond_2

    .line 83
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 84
    const-string v5, "code"

    const-string v6, "ailtn"

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 85
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 86
    const-string v6, "schemaType"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 87
    const-string v7, "schemaType"

    invoke-virtual {v5, v7, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 88
    const-string v6, "schemaType"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 89
    const-string v6, "payload"

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v6, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 90
    const-string v3, "data"

    invoke-virtual {v4, v3, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 91
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 94
    :catch_0
    move-exception v1

    .line 95
    const-string v2, "AILTNPublisher"

    const-string v3, "Exception thrown while constructing event payload"

    invoke-static {v2, v3, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 98
    :cond_3
    invoke-virtual {p0, v2}, Lcom/salesforce/androidsdk/analytics/AILTNPublisher;->b(Lorg/json/JSONArray;)Z

    move-result v0

    goto :goto_0
.end method

.method public b(Lorg/json/JSONArray;)Z
    .locals 10

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 102
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 104
    :try_start_0
    const-string v3, "logLines"

    invoke-virtual {v2, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 109
    const/4 v3, 0x0

    .line 111
    :try_start_1
    const-string v4, "/services/data/%s/connect/proxy/app-analytics-logging"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    .line 112
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7}, Lcom/salesforce/androidsdk/rest/ApiVersionStrings;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    .line 111
    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 113
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/rest/ClientManager;->b()Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v5

    .line 119
    invoke-virtual {v5}, Lcom/salesforce/androidsdk/rest/RestClient;->d()Lokhttp3/OkHttpClient;
    :try_end_1
    .catch Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v6

    if-nez v6, :cond_1

    .line 144
    :cond_0
    :goto_0
    return v0

    .line 105
    :catch_0
    move-exception v1

    .line 106
    const-string v2, "AILTNPublisher"

    const-string v3, "Exception thrown while constructing event payload"

    invoke-static {v2, v3, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 128
    :cond_1
    :try_start_2
    sget-object v6, Lcom/salesforce/androidsdk/rest/RestRequest;->a:Lokhttp3/MediaType;

    .line 129
    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    .line 128
    invoke-static {v6, v2}, Lokhttp3/RequestBody;->a(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/analytics/AILTNPublisher;->b(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/analytics/AILTNPublisher;->a(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;

    move-result-object v2

    .line 130
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 131
    const-string v7, "Content-Encoding"

    const-string v8, "gzip"

    invoke-interface {v6, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    const-string v7, "Content-Length"

    invoke-virtual {v2}, Lokhttp3/RequestBody;->b()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    new-instance v7, Lcom/salesforce/androidsdk/rest/RestRequest;

    sget-object v8, Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;->POST:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    invoke-direct {v7, v8, v4, v2, v6}, Lcom/salesforce/androidsdk/rest/RestRequest;-><init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lokhttp3/RequestBody;Ljava/util/Map;)V

    .line 135
    invoke-virtual {v5, v7}, Lcom/salesforce/androidsdk/rest/RestClient;->b(Lcom/salesforce/androidsdk/rest/RestRequest;)Lcom/salesforce/androidsdk/rest/RestResponse;
    :try_end_2
    .catch Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v2

    .line 141
    :goto_1
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestResponse;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    .line 142
    goto :goto_0

    .line 136
    :catch_1
    move-exception v2

    .line 137
    const-string v4, "AILTNPublisher"

    const-string v5, "Exception thrown while constructing rest client"

    invoke-static {v4, v5, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v2, v3

    .line 140
    goto :goto_1

    .line 138
    :catch_2
    move-exception v2

    .line 139
    const-string v4, "AILTNPublisher"

    const-string v5, "Exception thrown while making network request"

    invoke-static {v4, v5, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v2, v3

    goto :goto_1
.end method
