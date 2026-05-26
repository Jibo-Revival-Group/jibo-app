.class public Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;
.source "ArticleDetailRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;
    }
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field final b:Z


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;)V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;)V

    .line 50
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->a:Ljava/lang/String;

    .line 51
    iget-boolean v0, p1, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->b:Z

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->b:Z

    .line 52
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;
    .locals 2

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;

    invoke-interface {p0}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->g()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 96
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->b:Z

    return v0
.end method
