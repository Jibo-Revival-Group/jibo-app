.class public Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;
.super Ljava/lang/Object;
.source "DataCategoryGroupListModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;->a:Ljava/util/List;

    .line 45
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;
    .locals 3

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse;->a()Ljava/util/List;

    move-result-object v0

    .line 53
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 55
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;

    .line 56
    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 59
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method public static a(Ljava/util/List;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;)",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;"
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method public static varargs a([Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;
    .locals 2

    .prologue
    .line 48
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;

    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;-><init>(Ljava/util/List;)V

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
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;->a:Ljava/util/List;

    return-object v0
.end method
