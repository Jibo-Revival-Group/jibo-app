.class public Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;
.super Ljava/lang/Object;
.source "DataCategoryGroupModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->a:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->b:Ljava/lang/String;

    .line 48
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->c:Ljava/util/List;

    .line 49
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;
    .locals 4

    .prologue
    .line 53
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 54
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;->c()Ljava/util/List;

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

    .line 55
    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategory;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 58
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/DataCategoryGroupsResponse$DataCategoryGroup;->a()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3, v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;)",
            "Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;"
        }
    .end annotation

    .prologue
    .line 62
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;

    invoke-direct {v0, p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->c:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->b:Ljava/lang/String;

    return-object v0
.end method
