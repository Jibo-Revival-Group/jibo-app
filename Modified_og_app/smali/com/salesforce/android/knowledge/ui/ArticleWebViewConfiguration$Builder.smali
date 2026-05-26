.class public Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;
.super Ljava/lang/Object;
.source "ArticleWebViewConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

.field c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

.field d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)V
    .locals 0

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    .line 100
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;)Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    .line 117
    return-object p0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 125
    return-object p0
.end method

.method public a()Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/CssProviderWrapper;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;)Lcom/salesforce/android/knowledge/ui/internal/CssProviderWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    .line 143
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 144
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/WebResourcesErrorListenerWrapper;-><init>(Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    .line 146
    new-instance v0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;-><init>(Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;)V

    return-object v0
.end method
