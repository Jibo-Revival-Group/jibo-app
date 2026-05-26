.class public abstract Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;
.super Landroid/os/AsyncTask;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x404
    name = "BaseFinishAuthFlowTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<RequestType:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/os/AsyncTask",
        "<TRequestType;",
        "Ljava/lang/Boolean;",
        "Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;",
        ">;"
    }
.end annotation


# instance fields
.field protected volatile a:Ljava/lang/Exception;

.field protected volatile b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

.field final synthetic c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 1

    .prologue
    .line 471
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 469
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    .line 472
    return-void
.end method


# virtual methods
.method protected abstract a(Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TRequestType;)",
            "Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method protected final varargs a([Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TRequestType;)",
            "Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .prologue
    .line 478
    const/4 v0, 0x1

    :try_start_0
    new-array v0, v0, [Ljava/lang/Boolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->publishProgress([Ljava/lang/Object;)V

    .line 479
    const/4 v0, 0x0

    aget-object v0, p1, v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a(Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 483
    :goto_0
    return-object v0

    .line 480
    :catch_0
    move-exception v0

    .line 481
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a(Ljava/lang/Exception;)V

    .line 483
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V
    .locals 22

    .prologue
    .line 490
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v21

    .line 493
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a:Ljava/lang/Exception;

    if-eqz v1, :cond_1

    .line 494
    const-string v1, "OAuthWebViewHelper"

    const-string v2, "Exception thrown while retrieving token response"

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a:Ljava/lang/Exception;

    invoke-static {v1, v2, v3}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 495
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v2

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/SalesforceR;->e()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 496
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v3

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/ui/SalesforceR;->f()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a:Ljava/lang/Exception;

    .line 495
    invoke-virtual {v1, v2, v3, v4}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 497
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    .line 570
    :cond_0
    :goto_0
    return-void

    .line 500
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v1, v1, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->k:Lorg/json/JSONObject;

    if-eqz v1, :cond_2

    .line 501
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v1, v1, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->k:Lorg/json/JSONObject;

    const-string v2, "must_be_managed_app"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 502
    if-eqz v1, :cond_2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a()Z

    move-result v1

    if-nez v1, :cond_2

    .line 503
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v2

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/SalesforceR;->e()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 504
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v3

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/ui/SalesforceR;->h()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a:Ljava/lang/Exception;

    .line 503
    invoke-virtual {v1, v2, v3, v4}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 505
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    goto :goto_0

    .line 511
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v18, v0

    new-instance v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v2, v2, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->a:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->b:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v4, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->f:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v8, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->g:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v9, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->i:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v10, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->j:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v11, v11, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v12, v12, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->d:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v13, v13, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v14, v14, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->b:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v15, v15, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->f:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->g:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    move-object/from16 v17, v0

    invoke-direct/range {v1 .. v17}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    move-object/from16 v0, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    .line 517
    new-instance v1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v2}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v2

    iget-object v2, v2, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 518
    invoke-static {v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v3

    iget-object v3, v3, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->b:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v4, v4, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 519
    invoke-static {v5}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v5

    iget-object v5, v5, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->d:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v6}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v6

    iget-object v6, v6, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 520
    invoke-static {v7}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v7

    iget-object v7, v7, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->f:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v8}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v8

    iget-object v8, v8, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 521
    invoke-static {v9}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v9

    iget-object v9, v9, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v11}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v11

    iget-object v11, v11, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 522
    invoke-static {v12}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v12

    iget-object v12, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    .line 521
    invoke-virtual {v10, v11, v12}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v11, v11, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 522
    invoke-virtual {v11}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 523
    invoke-static {v12}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v12

    iget-object v12, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v13}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v13

    iget-object v13, v13, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 524
    invoke-static {v14}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v14

    iget-object v14, v14, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->j:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v15}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v15

    iget-object v15, v15, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->k:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v16, v0

    invoke-static/range {v16 .. v16}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v16

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->l:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v17, v0

    .line 525
    invoke-static/range {v17 .. v17}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v17

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->m:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v18

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->n:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v19, v0

    .line 526
    invoke-static/range {v19 .. v19}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v19

    move-object/from16 v0, v19

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->o:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object/from16 v20, v0

    invoke-static/range {v20 .. v20}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v20

    move-object/from16 v0, v20

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->p:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-direct/range {v1 .. v20}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 527
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v2, v2, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->j:Lorg/json/JSONObject;

    if-eqz v2, :cond_3

    .line 528
    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->p()Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->j:Lorg/json/JSONObject;

    invoke-virtual {v2, v3, v1}, Lcom/salesforce/androidsdk/config/AdminSettingsManager;->a(Lorg/json/JSONObject;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 530
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v2, v2, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->k:Lorg/json/JSONObject;

    if-eqz v2, :cond_4

    .line 531
    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q()Lcom/salesforce/androidsdk/config/AdminPermsManager;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget-object v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->k:Lorg/json/JSONObject;

    invoke-virtual {v2, v3, v1}, Lcom/salesforce/androidsdk/config/AdminPermsManager;->a(Lorg/json/JSONObject;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 535
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget v2, v2, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->i:I

    if-lez v2, :cond_6

    .line 538
    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v2

    .line 539
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->i:I

    mul-int/lit16 v3, v3, 0x3e8

    mul-int/lit8 v3, v3, 0x3c

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget v4, v4, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->h:I

    invoke-virtual {v2, v1, v3, v4}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;II)V

    .line 540
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget v1, v1, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->i:I

    mul-int/lit16 v1, v1, 0x3e8

    mul-int/lit8 v1, v1, 0x3c

    invoke-virtual {v2, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(I)V

    .line 541
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    iget v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;->h:I

    invoke-virtual {v2, v1, v3}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;I)Z

    move-result v1

    .line 552
    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 554
    const/4 v1, 0x1

    invoke-virtual {v2, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Z)V

    .line 555
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    const/4 v3, 0x1

    invoke-virtual {v2, v1, v3}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/app/Activity;Z)Z

    goto/16 :goto_0

    .line 556
    :cond_5
    if-nez v1, :cond_0

    .line 557
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v1, v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d(Ljava/lang/String;)V

    .line 558
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->k()V

    .line 559
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    goto/16 :goto_0

    .line 564
    :cond_6
    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v2

    .line 565
    const/4 v3, 0x0

    const/4 v4, 0x4

    invoke-virtual {v2, v1, v3, v4}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;II)V

    .line 566
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v1, v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual/range {v21 .. v21}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d(Ljava/lang/String;)V

    .line 567
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->k()V

    .line 568
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    goto/16 :goto_0
.end method

.method protected a(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 573
    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 574
    const-string v0, "OAuthWebViewHelper"

    const-string v1, "Exception thrown"

    invoke-static {v0, v1, p1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 576
    :cond_0
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a:Ljava/lang/Exception;

    .line 577
    return-void
.end method

.method protected varargs a([Ljava/lang/Boolean;)V
    .locals 2

    .prologue
    .line 581
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->a(Z)V

    .line 582
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .prologue
    .line 466
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a([Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 466
    check-cast p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V

    return-void
.end method

.method protected synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 466
    check-cast p1, [Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;->a([Ljava/lang/Boolean;)V

    return-void
.end method
