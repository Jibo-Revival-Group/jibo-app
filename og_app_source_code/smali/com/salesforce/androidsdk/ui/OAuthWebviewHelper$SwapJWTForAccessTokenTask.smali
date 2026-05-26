.class Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;
.super Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SwapJWTForAccessTokenTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask",
        "<",
        "Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 0

    .prologue
    .line 427
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;)V
    .locals 0

    .prologue
    .line 427
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    .line 457
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 458
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/SalesforceR;->e()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 459
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->g()I

    move-result v0

    invoke-virtual {v3, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a:Ljava/lang/Exception;

    .line 458
    invoke-virtual {v1, v2, v0, v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 460
    return-void
.end method


# virtual methods
.method protected a(Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .locals 3

    .prologue
    .line 432
    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    new-instance v1, Ljava/net/URI;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/auth/OAuth2;->b(Lcom/salesforce/androidsdk/auth/HttpAccess;Ljava/net/URI;Ljava/lang/String;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 436
    :goto_0
    return-object v0

    .line 433
    :catch_0
    move-exception v0

    .line 434
    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a:Ljava/lang/Exception;

    .line 436
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic a(Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 427
    check-cast p1, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a(Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 441
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a:Ljava/lang/Exception;

    if-eqz v0, :cond_0

    .line 442
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a()V

    .line 443
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Ljava/lang/String;)V

    .line 454
    :goto_0
    return-void

    .line 446
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 447
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    iget-object v1, p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Ljava/lang/String;)V

    .line 448
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Z)V

    .line 453
    :goto_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 450
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Z)V

    .line 451
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a()V

    goto :goto_1
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 427
    check-cast p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V

    return-void
.end method
