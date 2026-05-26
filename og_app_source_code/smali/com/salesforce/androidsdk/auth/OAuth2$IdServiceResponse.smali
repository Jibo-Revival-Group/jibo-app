.class public Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;
.super Ljava/lang/Object;
.source "OAuth2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/auth/OAuth2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IdServiceResponse"
.end annotation


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:I

.field public i:I

.field public j:Lorg/json/JSONObject;

.field public k:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Lokhttp3/Response;)V
    .locals 3

    .prologue
    const/4 v0, -0x1

    .line 580
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 575
    iput v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->h:I

    .line 576
    iput v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->i:I

    .line 582
    :try_start_0
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestResponse;

    invoke-direct {v0, p1}, Lcom/salesforce/androidsdk/rest/RestResponse;-><init>(Lokhttp3/Response;)V

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestResponse;->f()Lorg/json/JSONObject;

    move-result-object v0

    .line 583
    const-string v1, "username"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->a:Ljava/lang/String;

    .line 584
    const-string v1, "email"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->b:Ljava/lang/String;

    .line 585
    const-string v1, "first_name"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->c:Ljava/lang/String;

    .line 586
    const-string v1, "last_name"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->d:Ljava/lang/String;

    .line 587
    const-string v1, "display_name"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->e:Ljava/lang/String;

    .line 588
    const-string v1, "photos"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 589
    if-eqz v1, :cond_0

    .line 590
    const-string v2, "picture"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->f:Ljava/lang/String;

    .line 591
    const-string v2, "thumbnail"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->g:Ljava/lang/String;

    .line 593
    :cond_0
    const-string v1, "custom_attributes"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->j:Lorg/json/JSONObject;

    .line 594
    const-string v1, "custom_permissions"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->k:Lorg/json/JSONObject;

    .line 595
    const-string v1, "mobile_policy"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 596
    const-string v1, "mobile_policy"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "pin_length"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->h:I

    .line 597
    const-string v1, "mobile_policy"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "screen_lock"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->i:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 602
    :cond_1
    :goto_0
    return-void

    .line 599
    :catch_0
    move-exception v0

    .line 600
    const-string v1, "OAuth2"

    const-string v2, "Could not parse identity response"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
