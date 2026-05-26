.class Lcom/salesforce/androidsdk/config/RuntimeConfig$1;
.super Ljava/lang/Object;
.source "RuntimeConfig.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/config/RuntimeConfig;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/config/RuntimeConfig;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/config/RuntimeConfig;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;->a:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 95
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 97
    :try_start_0
    const-string v0, "mdmIsActive"

    iget-object v2, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;->a:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-static {v2}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Z

    move-result v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 98
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;->a:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-static {v0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 99
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 100
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;->a:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-static {v0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 101
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 102
    iget-object v4, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;->a:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-static {v4}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Landroid/os/Bundle;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Lorg/json/JSONObject;->wrap(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 106
    :catch_0
    move-exception v0

    .line 107
    const-string v2, "RuntimeConfig"

    const-string v3, "Exception thrown while creating JSON"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 109
    :cond_0
    :goto_1
    const-string v0, "mdmConfiguration"

    const/4 v2, 0x0

    const-string v3, "RuntimeConfig"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 110
    return-void

    .line 104
    :cond_1
    :try_start_1
    const-string v0, "mdmConfigs"

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
