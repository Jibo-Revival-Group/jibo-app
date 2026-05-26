.class public Lcom/salesforce/android/knowledge/ui/internal/models/Models;
.super Ljava/lang/Object;
.source "Models.java"


# direct methods
.method public static a(I)Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;
    .locals 1

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/models/Models$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/models/Models$1;-><init>(I)V

    return-object v0
.end method

.method public static a(Ljava/util/Collection;Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+",
            "Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;",
            ">;",
            "Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v0

    invoke-direct {v3, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 45
    const/4 v0, 0x0

    .line 46
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v0

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;

    .line 47
    add-int/lit8 v2, v1, 0x1

    .line 49
    invoke-interface {p1, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;->a(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;I)I

    move-result v1

    .line 47
    invoke-static {v0, v1, p2}, Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;->a(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;ILcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v1, v2

    .line 52
    goto :goto_0

    .line 54
    :cond_0
    return-object v3
.end method
