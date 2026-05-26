.class public Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.super Ljava/lang/Object;
.source "OAuthWebviewHelper.java"

# interfaces
.implements Landroid/security/KeyChainAliasCallback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;,
        Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;
    }
.end annotation


# static fields
.field static final synthetic b:Z


# instance fields
.field protected final a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

.field private final c:Ljava/util/concurrent/ExecutorService;

.field private final d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

.field private final e:Landroid/webkit/WebView;

.field private f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

.field private g:Landroid/app/Activity;

.field private h:Ljava/security/PrivateKey;

.field private i:[Ljava/security/cert/X509Certificate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 97
    const-class v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->b:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Landroid/webkit/WebView;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 141
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->c:Ljava/util/concurrent/ExecutorService;

    .line 142
    sget-boolean v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->b:Z

    if-nez v0, :cond_1

    if-eqz p3, :cond_0

    if-eqz p2, :cond_0

    if-eqz p4, :cond_0

    if-nez p1, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 143
    :cond_1
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g:Landroid/app/Activity;

    .line 144
    iput-object p2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    .line 145
    iput-object p3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 146
    iput-object p4, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    .line 147
    invoke-virtual {p4}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 148
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 149
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->y()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 150
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d()Landroid/webkit/WebViewClient;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 151
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e()Landroid/webkit/WebChromeClient;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 158
    if-eqz p5, :cond_2

    .line 159
    invoke-virtual {p4, p5}, Landroid/webkit/WebView;->restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 160
    const-string v0, "accountOptions"

    invoke-virtual {p5, v0}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a(Landroid/os/Bundle;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    .line 164
    :goto_0
    return-void

    .line 162
    :cond_2
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    return-object p1
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    return-object v0
.end method

.method private a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 4

    .prologue
    .line 683
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 685
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l()Lcom/salesforce/androidsdk/config/LoginServerManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->c()Ljava/util/List;

    move-result-object v2

    .line 686
    const-string v3, "numLoginServers"

    if-nez v2, :cond_1

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v3, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 687
    if-eqz v2, :cond_3

    .line 688
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 689
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 690
    if-eqz v0, :cond_0

    .line 691
    iget-object v0, v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->b:Ljava/lang/String;

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 697
    :catch_0
    move-exception v0

    .line 698
    const-string v1, "OAuthWebViewHelper"

    const-string v2, "Exception thrown while creating JSON"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 700
    :goto_2
    return-void

    .line 686
    :cond_1
    :try_start_1
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 694
    :cond_2
    const-string v0, "loginServers"

    invoke-virtual {v1, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 696
    :cond_3
    const-string v0, "addUser"

    const-string v2, "OAuthWebViewHelper"

    invoke-static {v0, p1, v2, v1}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Z)V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Z)V

    return-void
.end method

.method private a(Z)V
    .locals 3

    .prologue
    .line 300
    :try_start_0
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/Boolean;)Ljava/net/URI;

    move-result-object v0

    .line 301
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->a(Ljava/lang/String;)V

    .line 302
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 306
    :goto_0
    return-void

    .line 303
    :catch_0
    move-exception v0

    .line 304
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method static synthetic b(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Ljava/security/PrivateKey;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->h:Ljava/security/PrivateKey;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)[Ljava/security/cert/X509Certificate;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->i:[Ljava/security/cert/X509Certificate;

    return-object v0
.end method

.method static synthetic d(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    return-object v0
.end method


# virtual methods
.method protected a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 706
    const-string v0, "%s (%s) (%s)"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    const/4 v2, 0x2

    .line 707
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->u()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 706
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected a(Ljava/lang/Boolean;)Ljava/net/URI;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 313
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 314
    new-instance v0, Ljava/net/URI;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 315
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 316
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->h()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 317
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 318
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->e()[Ljava/lang/String;

    move-result-object v3

    .line 320
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->i()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v6}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v7}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v8}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h()Ljava/util/Map;

    move-result-object v8

    .line 314
    invoke-static/range {v0 .. v8}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/net/URI;

    move-result-object v0

    .line 322
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/net/URI;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 323
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 324
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->h()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 325
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 326
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->e()[Ljava/lang/String;

    move-result-object v3

    .line 328
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->i()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v6}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h()Ljava/util/Map;

    move-result-object v6

    .line 322
    invoke-static/range {v0 .. v6}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/net/URI;

    move-result-object v0

    goto :goto_0
.end method

.method public a()V
    .locals 1

    .prologue
    .line 187
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->F()V

    .line 188
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 175
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 176
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    if-eqz v0, :cond_0

    .line 178
    const-string v0, "accountOptions"

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 180
    :cond_0
    return-void
.end method

.method protected a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V
    .locals 3

    .prologue
    .line 423
    new-instance v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;)V

    .line 424
    const/4 v1, 0x1

    new-array v1, v1, [Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 425
    return-void
.end method

.method protected a(Ljava/lang/Exception;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 279
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v0

    .line 280
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->d()I

    move-result v2

    new-array v3, v6, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 279
    invoke-static {v0, v1, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 281
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 282
    return-void
.end method

.method protected a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 6

    .prologue
    .line 238
    const-string v0, "OAuthWebViewHelper"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p3}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 241
    const-string v0, "access_denied"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "end-user denied authorization"

    .line 242
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 243
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    new-instance v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->post(Ljava/lang/Runnable;)Z

    .line 262
    :goto_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.auth.intent.AUTHENTICATION_ERROR"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 263
    if-eqz p3, :cond_0

    instance-of v1, p3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;

    if-eqz v1, :cond_0

    .line 264
    check-cast p3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;

    .line 265
    invoke-virtual {p3}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->c()I

    move-result v1

    .line 266
    const-string v2, "com.salesforce.auth.intent.HTTP_RESPONSE_CODE"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 267
    invoke-virtual {p3}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b()Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    move-result-object v1

    .line 268
    if-eqz v1, :cond_0

    .line 269
    iget-object v2, v1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->a:Ljava/lang/String;

    .line 270
    iget-object v1, v1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->b:Ljava/lang/String;

    .line 271
    const-string v3, "com.salesforce.auth.intent.RESPONSE_ERROR"

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 272
    const-string v2, "com.salesforce.auth.intent.RESPONSE_ERROR_DESCRIPTION"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 275
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 276
    return-void

    .line 252
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 254
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    new-instance v2, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$2;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$2;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    .line 259
    invoke-virtual {v0}, Landroid/widget/Toast;->getDuration()I

    move-result v3

    int-to-long v4, v3

    .line 254
    invoke-virtual {v1, v2, v4, v5}, Landroid/webkit/WebView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 260
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public alias(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 839
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g:Landroid/app/Activity;

    invoke-static {v0, p1}, Landroid/security/KeyChain;->getCertificateChain(Landroid/content/Context;Ljava/lang/String;)[Ljava/security/cert/X509Certificate;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->i:[Ljava/security/cert/X509Certificate;

    .line 840
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g:Landroid/app/Activity;

    invoke-static {v0, p1}, Landroid/security/KeyChain;->getPrivateKey(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PrivateKey;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->h:Ljava/security/PrivateKey;

    .line 841
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g:Landroid/app/Activity;

    new-instance v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$4;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$4;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Landroid/security/KeyChainException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1

    .line 853
    :goto_0
    return-void

    .line 848
    :catch_0
    move-exception v0

    .line 849
    const-string v1, "OAuthWebViewHelper"

    const-string v2, "Exception thrown while retrieving X.509 certificate"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 850
    :catch_1
    move-exception v0

    .line 851
    const-string v1, "OAuthWebViewHelper"

    const-string v2, "Exception thrown while retrieving X.509 certificate"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 191
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    const-string v1, "about:blank"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 192
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d(Ljava/lang/String;)V

    .line 210
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->k()V

    .line 211
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    invoke-interface {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    .line 213
    :cond_0
    return-void
.end method

.method protected d()Landroid/webkit/WebViewClient;
    .locals 1

    .prologue
    .line 217
    new-instance v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-object v0
.end method

.method protected e()Landroid/webkit/WebChromeClient;
    .locals 1

    .prologue
    .line 222
    new-instance v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-object v0
.end method

.method protected f()Landroid/content/Context;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->e:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public g()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 290
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 291
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->j()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c(Ljava/lang/String;)V

    .line 292
    invoke-direct {p0, v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Z)V

    .line 296
    :goto_0
    return-void

    .line 294
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;)V

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$SwapJWTForAccessTokenTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method protected h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected i()Ljava/lang/String;
    .locals 2

    .prologue
    .line 345
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/salesforce/androidsdk/R$string;->oauth_display_type:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 353
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l()Lcom/salesforce/androidsdk/config/LoginServerManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a()Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    move-result-object v0

    iget-object v0, v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected k()V
    .locals 25

    .prologue
    .line 604
    new-instance v1, Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v2

    .line 605
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 606
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v5

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    .line 609
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v2, v2, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v3, v3, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 613
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v3, v3, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v4, v4, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->b:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v5, v5, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v6, v6, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 618
    invoke-virtual {v7}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v8, v8, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->d:Ljava/lang/String;

    .line 620
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->h()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v10, v10, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->f:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v11, v11, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 623
    invoke-virtual {v12}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b()Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 624
    invoke-virtual {v13}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v14, v14, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v15, v15, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->j:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->k:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->l:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->m:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->n:Ljava/lang/String;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->o:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->p:Ljava/util/Map;

    move-object/from16 v22, v0

    .line 613
    invoke-virtual/range {v1 .. v22}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/os/Bundle;

    move-result-object v23

    .line 640
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    .line 641
    invoke-static {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/BootConfig;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/config/BootConfig;->d()Ljava/lang/String;

    move-result-object v24

    .line 642
    new-instance v3, Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v4, v4, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v5, v5, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->b:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 643
    invoke-virtual {v6}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v7, v7, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->d:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v8, v8, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v9, v9, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->f:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v10, v10, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v11, v11, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 647
    invoke-virtual {v12}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v14, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v15, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->j:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->k:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->l:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->m:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->n:Ljava/lang/String;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->o:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    iget-object v0, v12, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->p:Ljava/util/Map;

    move-object/from16 v22, v0

    move-object v12, v2

    invoke-direct/range {v3 .. v22}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 651
    invoke-static/range {v24 .. v24}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 652
    invoke-static {v1, v3}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 656
    :cond_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 658
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v1

    .line 659
    const-string v4, "numUsers"

    if-nez v1, :cond_1

    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v2, v4, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 664
    :goto_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-object/from16 v0, v23

    invoke-interface {v1, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->a(Landroid/os/Bundle;)V

    .line 666
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->C()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 667
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 676
    :goto_2
    return-void

    .line 659
    :cond_1
    :try_start_1
    invoke-interface {v1}, Ljava/util/List;->size()I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v1

    goto :goto_0

    .line 660
    :catch_0
    move-exception v1

    .line 661
    const-string v2, "OAuthWebViewHelper"

    const-string v4, "Exception thrown while creating JSON"

    invoke-static {v2, v4, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 669
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->c:Ljava/util/concurrent/ExecutorService;

    new-instance v2, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;

    move-object/from16 v0, p0

    invoke-direct {v2, v0, v3}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_2
.end method
