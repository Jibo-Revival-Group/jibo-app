.class public Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;
.source "ArticleDetailRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder",
        "<",
        "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field b:Z


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;-><init>()V

    .line 109
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->b:Z

    .line 112
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->a:Ljava/lang/String;

    .line 113
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;
    .locals 1

    .prologue
    .line 148
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->a()Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;->e()Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected e()Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest$Builder;
    .locals 0

    .prologue
    .line 155
    return-object p0
.end method
