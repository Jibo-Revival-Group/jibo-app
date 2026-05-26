.class public Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;
.super Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;
.source "DataCategoriesRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;)V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest;-><init>(Lcom/salesforce/android/knowledge/core/requests/KnowledgeRequest$KnowledgeRequestBuilder;)V

    .line 48
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->b:Ljava/lang/String;

    .line 49
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;
    .locals 1

    .prologue
    .line 60
    new-instance v0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a:Ljava/lang/String;

    return-object v0
.end method
