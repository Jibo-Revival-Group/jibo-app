.class public Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;
.super Ljava/lang/Object;
.source "DeviceAppAttributes.java"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->a:Ljava/lang/String;

    .line 80
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->b:Ljava/lang/String;

    .line 81
    iput-object p3, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->c:Ljava/lang/String;

    .line 82
    iput-object p4, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->d:Ljava/lang/String;

    .line 83
    iput-object p5, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->e:Ljava/lang/String;

    .line 84
    iput-object p6, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->f:Ljava/lang/String;

    .line 85
    iput-object p7, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->g:Ljava/lang/String;

    .line 86
    iput-object p8, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->h:Ljava/lang/String;

    .line 87
    iput-object p9, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->i:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 1

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    if-eqz p1, :cond_0

    .line 99
    const-string v0, "appVersion"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->a:Ljava/lang/String;

    .line 100
    const-string v0, "appName"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->b:Ljava/lang/String;

    .line 101
    const-string v0, "osVersion"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->c:Ljava/lang/String;

    .line 102
    const-string v0, "osName"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->d:Ljava/lang/String;

    .line 103
    const-string v0, "nativeAppType"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->e:Ljava/lang/String;

    .line 104
    const-string v0, "mobileSdkVersion"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->f:Ljava/lang/String;

    .line 105
    const-string v0, "deviceModel"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->g:Ljava/lang/String;

    .line 106
    const-string v0, "deviceId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->h:Ljava/lang/String;

    .line 107
    const-string v0, "clientId"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->i:Ljava/lang/String;

    .line 109
    :cond_0
    return-void
.end method


# virtual methods
.method public a()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 198
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 200
    :try_start_0
    const-string v0, "appVersion"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 201
    const-string v0, "appName"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->b:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 202
    const-string v0, "osVersion"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->c:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 203
    const-string v0, "osName"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->d:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 204
    const-string v0, "nativeAppType"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->e:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 205
    const-string v0, "mobileSdkVersion"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 206
    const-string v0, "deviceModel"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->g:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 207
    const-string v0, "deviceId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->h:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 208
    const-string v0, "clientId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;->i:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    :goto_0
    return-object v1

    .line 209
    :catch_0
    move-exception v0

    .line 210
    const/4 v2, 0x0

    const-string v3, "DeviceAppAttributes"

    const-string v4, "Exception thrown while attempting to convert to JSON"

    invoke-static {v2, v3, v4, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
