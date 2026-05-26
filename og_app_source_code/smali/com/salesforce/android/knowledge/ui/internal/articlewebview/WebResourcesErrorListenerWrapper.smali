.class public Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;
.super Ljava/lang/Object;
.source "WebResourcesErrorListenerWrapper.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    .line 43
    return-void
.end method


# virtual methods
.method public a(Landroid/net/Uri;ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;->a:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;->a(Landroid/net/Uri;ILjava/lang/String;)V

    .line 50
    :cond_0
    return-void
.end method
