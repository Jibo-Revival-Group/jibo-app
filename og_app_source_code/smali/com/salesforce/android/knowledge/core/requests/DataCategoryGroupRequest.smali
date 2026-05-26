.class public Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;
.source "DataCategoryGroupRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;)V

    .line 43
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;->a:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest$Builder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;->a:Ljava/lang/String;

    return-object v0
.end method
