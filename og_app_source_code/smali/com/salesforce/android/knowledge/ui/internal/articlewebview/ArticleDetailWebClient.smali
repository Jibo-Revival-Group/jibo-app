.class public Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;
.super Landroid/webkit/WebViewClient;
.source "ArticleDetailWebClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;,
        Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;
    }
.end annotation


# static fields
.field private static final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

.field private final c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

.field private final d:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;)V
    .locals 0

    .prologue
    .line 85
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 86
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    .line 87
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->d:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;

    .line 88
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;
    .locals 2

    .prologue
    .line 82
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;

    invoke-direct {v1}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;-><init>()V

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;-><init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;)V

    return-object v0
.end method

.method private a(ILjava/lang/String;Landroid/net/Uri;)V
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

    invoke-interface {v0, p3, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;->a(Landroid/net/Uri;ILjava/lang/String;)V

    .line 187
    :cond_0
    return-void
.end method


# virtual methods
.method a(Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
    .locals 6

    .prologue
    .line 195
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    .line 197
    :try_start_0
    new-instance v0, Landroid/webkit/WebResourceResponse;

    const-string v2, "text/css"

    const-string v3, "utf-8"

    const-string v4, "knowledge_article_details.css"

    invoke-virtual {v1, v4}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v0, v2, v3, v1}, Landroid/webkit/WebResourceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 200
    :goto_0
    return-object v0

    .line 198
    :catch_0
    move-exception v0

    .line 199
    sget-object v1, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unable to load CSS asset file {}: {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "knowledge_article_details.css"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 200
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

    .line 96
    return-void
.end method

.method a(Landroid/net/Uri;)Z
    .locals 2

    .prologue
    .line 190
    invoke-virtual {p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    .line 191
    if-eqz v0, :cond_0

    const-string v1, "CSS_FILE_PLACEHOLDER"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;->a()V

    .line 161
    :cond_0
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 173
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 174
    invoke-static {p4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 175
    invoke-direct {p0, p2, p3, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(ILjava/lang/String;Landroid/net/Uri;)V

    .line 176
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0x17
    .end annotation

    .prologue
    .line 166
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V

    .line 167
    invoke-interface {p2}, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;

    move-result-object v0

    .line 168
    invoke-virtual {p3}, Landroid/webkit/WebResourceError;->getErrorCode()I

    move-result v1

    invoke-virtual {p3}, Landroid/webkit/WebResourceError;->getDescription()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(ILjava/lang/String;Landroid/net/Uri;)V

    .line 169
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 142
    invoke-interface {p2}, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;

    move-result-object v0

    .line 143
    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 144
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Landroid/content/Context;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    .line 153
    :goto_0
    return-object v0

    .line 147
    :cond_0
    invoke-interface {p2}, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 148
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 149
    if-eqz v1, :cond_1

    .line 150
    new-instance v0, Landroid/webkit/WebResourceResponse;

    invoke-direct {v0, v2, v2, v1}, Landroid/webkit/WebResourceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V

    goto :goto_0

    .line 153
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 110
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 111
    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Landroid/content/Context;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    .line 120
    :goto_0
    return-object v0

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->c:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 116
    if-eqz v1, :cond_1

    .line 117
    new-instance v0, Landroid/webkit/WebResourceResponse;

    invoke-direct {v0, v2, v2, v1}, Landroid/webkit/WebResourceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V

    goto :goto_0

    .line 120
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z
    .locals 3

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->d:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;

    const-string v1, "android.intent.action.VIEW"

    invoke-interface {p2}, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;->a(Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    .line 135
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 136
    const/4 v0, 0x1

    return v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->d:Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;

    const-string v1, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$IntentFactory;->a(Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    .line 127
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 128
    const/4 v0, 0x1

    return v0
.end method
