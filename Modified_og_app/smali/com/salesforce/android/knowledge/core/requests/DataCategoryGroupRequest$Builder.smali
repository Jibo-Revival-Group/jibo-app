.class public Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;
.source "DataCategoryGroupRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder",
        "<",
        "Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;-><init>()V

    .line 82
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;->a:Ljava/lang/String;

    .line 83
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;
    .locals 1

    .prologue
    .line 102
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;)V

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
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;->a()Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;->e()Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected e()Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;
    .locals 0

    .prologue
    .line 106
    return-object p0
.end method
