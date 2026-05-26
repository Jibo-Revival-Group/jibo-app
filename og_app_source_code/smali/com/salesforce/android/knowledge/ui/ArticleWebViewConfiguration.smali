.class public Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;
.super Ljava/lang/Object;
.source "ArticleWebViewConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field final b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

.field final c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

.field final d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;)V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    .line 45
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    .line 46
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 47
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    .line 48
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/KnowledgeClient;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;->d:Lcom/salesforce/android/knowledge/ui/ArticleWebView$WebResourceErrorListener;

    return-object v0
.end method
