.class public Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;
.source "DataCategoriesRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder",
        "<",
        "Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field final b:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;-><init>()V

    .line 98
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->a:Ljava/lang/String;

    .line 99
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->b:Ljava/lang/String;

    .line 100
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;
    .locals 1

    .prologue
    .line 119
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;)V

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
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->a()Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 92
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->e()Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected e()Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;
    .locals 0

    .prologue
    .line 123
    return-object p0
.end method
