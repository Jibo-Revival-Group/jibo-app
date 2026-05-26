.class public Lcom/salesforce/android/knowledge/ui/ArticleWebView;
.super Landroid/webkit/WebView;
.source "ArticleWebView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;,
        Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;
    }
.end annotation


# instance fields
.field a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field b:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 78
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 79
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 89
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 101
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 102
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            "Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 134
    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->d()Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->b:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    .line 136
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_contrast_inverted:I

    invoke-static {v0, v1}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->setBackgroundColor(I)V

    .line 138
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 139
    const-string v1, "utf-8"

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V

    .line 140
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 142
    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->a()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    move-result-object v0

    .line 143
    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;

    move-result-object v0

    .line 144
    new-instance v1, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;-><init>(Lcom/salesforce/android/knowledge/ui/ArticleWebView;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient;->a(Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;)V

    .line 145
    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 147
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    move-result-object v1

    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->c()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    move-result-object v2

    invoke-static {v0, p1, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->a(Landroid/content/Context;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;

    move-result-object v0

    .line 149
    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->a()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "text/html"

    sget-object v0, Landroid/util/Xml$Encoding;->UTF_8:Landroid/util/Xml$Encoding;

    invoke-virtual {v0}, Landroid/util/Xml$Encoding;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method public a()V
    .locals 2

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 158
    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_0

    .line 159
    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 161
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->clearHistory()V

    .line 162
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->clearCache(Z)V

    .line 163
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->destroy()V

    .line 165
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 111
    invoke-super {p0}, Landroid/webkit/WebView;->onDetachedFromWindow()V

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c()V

    .line 117
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 118
    return-void
.end method
