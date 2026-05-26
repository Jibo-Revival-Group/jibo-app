.class public Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;
.super Ljava/lang/Object;
.source "DataCategorySummaryModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:I

.field private final d:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a:Ljava/lang/String;

    .line 45
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->b:Ljava/lang/String;

    .line 46
    iput p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->c:I

    .line 47
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->d:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;
    .locals 3

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;->c()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-static {v0, v1, v2, p1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->c:I

    return v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->d:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->b:Ljava/lang/String;

    return-object v0
.end method
