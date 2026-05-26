.class public Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;
.super Ljava/lang/Object;
.source "DataCategoryListModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategoryList;


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 45
    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 46
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;->a:Ljava/util/List;

    .line 47
    return-void
.end method

.method public static a(Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;",
            ">;)",
            "Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;"
        }
    .end annotation

    .prologue
    .line 50
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;-><init>(Ljava/util/List;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;->a:Ljava/util/List;

    return-object v0
.end method
