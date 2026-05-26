.class Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;
.super Ljava/lang/Object;
.source "ArticleWebView.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailWebClient$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/ArticleWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ArticleWebViewResultsListener"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/ArticleWebView;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 188
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    if-eqz v0, :cond_0

    .line 189
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 190
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 192
    :cond_0
    return-void
.end method

.method public a(Landroid/net/Uri;ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebView$ArticleWebViewResultsListener;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->b:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;->a(Landroid/net/Uri;ILjava/lang/String;)V

    .line 196
    return-void
.end method
