.class public Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;
.source "ArticleListRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder",
        "<",
        "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field a:Ljava/lang/String;

.field b:Ljava/lang/String;

.field c:I

.field d:I

.field e:I

.field f:Ljava/lang/CharSequence;

.field g:I

.field h:I


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 289
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;-><init>()V

    .line 282
    iput v1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->c:I

    .line 283
    const/4 v0, 0x3

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->d:I

    .line 284
    iput v1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->e:I

    .line 286
    iput v1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->g:I

    .line 287
    const/4 v0, 0x2

    iput v0, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->h:I

    .line 290
    return-void
.end method


# virtual methods
.method public a(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 301
    if-lt p1, v0, :cond_0

    :goto_0
    const-string v1, "Page number must be greater than zero."

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(ZLjava/lang/String;)V

    .line 302
    iput p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->c:I

    .line 303
    return-object p0

    .line 301
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Ljava/lang/CharSequence;)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 0

    .prologue
    .line 356
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->f:Ljava/lang/CharSequence;

    .line 357
    return-object p0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 0

    .prologue
    .line 339
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a:Ljava/lang/String;

    .line 340
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->b:Ljava/lang/String;

    .line 341
    return-object p0
.end method

.method public a()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;
    .locals 1

    .prologue
    .line 402
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;)V

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
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 392
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->a()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public b(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 314
    if-lt p1, v0, :cond_0

    :goto_0
    const-string v1, "Page size must be greater than zero."

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(ZLjava/lang/String;)V

    .line 315
    iput p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->d:I

    .line 316
    return-object p0

    .line 314
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c(I)Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 0

    .prologue
    .line 326
    iput p1, p0, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->e:I

    .line 327
    return-object p0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 257
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;->e()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected e()Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest$Builder;
    .locals 0

    .prologue
    .line 406
    return-object p0
.end method
