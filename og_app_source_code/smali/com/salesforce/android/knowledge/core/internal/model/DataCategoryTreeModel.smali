.class public Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;
.super Ljava/lang/Object;
.source "DataCategoryTreeModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

.field private b:Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

.field private final c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;)V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c:Ljava/util/Set;

    .line 42
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c:Ljava/util/Set;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->d:Ljava/util/Set;

    .line 45
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a:Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    .line 46
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;
    .locals 1

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;
    .locals 4

    .prologue
    .line 68
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    invoke-static {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;-><init>(Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;)V

    .line 70
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;

    .line 71
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;

    move-result-object v3

    invoke-interface {v3}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->a()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    move-result-object v0

    .line 72
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a(Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    goto :goto_0

    .line 74
    :cond_0
    return-object v1
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->b:Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->b:Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 53
    :cond_0
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 54
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->b:Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    .line 55
    return-object p0
.end method

.method public a()Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->b:Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    return-object v0
.end method

.method public b()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->d:Ljava/util/Set;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a:Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    return-object v0
.end method
