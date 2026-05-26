.class public Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AuthWebViewClient"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method protected constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 0

    .prologue
    .line 360
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 364
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1, p2}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 365
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 366
    return-void
.end method

.method public onReceivedClientCertRequest(Landroid/webkit/WebView;Landroid/webkit/ClientCertRequest;)V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 414
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->b(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Ljava/security/PrivateKey;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->c(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)[Ljava/security/cert/X509Certificate;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/webkit/ClientCertRequest;->proceed(Ljava/security/PrivateKey;[Ljava/security/cert/X509Certificate;)V

    .line 415
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 391
    invoke-virtual {p3}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v1

    .line 394
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v2

    .line 395
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ah()I

    move-result v0

    .line 396
    packed-switch v1, :pswitch_data_0

    .line 404
    :goto_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ac()I

    move-result v2

    new-array v3, v6, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 407
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->f()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 408
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->cancel()V

    .line 409
    return-void

    .line 397
    :pswitch_0
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ad()I

    move-result v0

    goto :goto_0

    .line 398
    :pswitch_1
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ae()I

    move-result v0

    goto :goto_0

    .line 399
    :pswitch_2
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->af()I

    move-result v0

    goto :goto_0

    .line 400
    :pswitch_3
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ag()I

    move-result v0

    goto :goto_0

    .line 396
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5

    .prologue
    .line 370
    const-string v0, "///"

    const-string v1, "/"

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v1, v1, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c()Ljava/lang/String;

    move-result-object v1

    const-string v2, "///"

    const-string v3, "/"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    .line 371
    if-eqz v2, :cond_0

    .line 372
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 373
    invoke-static {v0}, Lcom/salesforce/androidsdk/util/UriFragmentParser;->a(Landroid/net/Uri;)Ljava/util/Map;

    move-result-object v1

    .line 374
    const-string v0, "error"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 376
    if-eqz v0, :cond_1

    .line 377
    const-string v3, "error_description"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 378
    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    const/4 v4, 0x0

    invoke-virtual {v3, v0, v1, v4}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 386
    :cond_0
    :goto_0
    return v2

    .line 382
    :cond_1
    new-instance v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;-><init>(Ljava/util/Map;)V

    .line 383
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebViewClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)V

    goto :goto_0
.end method
