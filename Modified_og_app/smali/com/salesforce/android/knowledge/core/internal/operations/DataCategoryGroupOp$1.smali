.class Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$1;
.super Ljava/lang/Object;
.source "DataCategoryGroupOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;",
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$1;->a:Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;
    .locals 4

    .prologue
    .line 58
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;

    .line 59
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;->a()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$1;->a:Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;

    iget-object v3, v3, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 60
    return-object v0

    .line 64
    :cond_1
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$DataCategoryGroupNotFoundException;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$1;->a:Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;

    iget-object v1, v1, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;->a:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$DataCategoryGroupNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 56
    check-cast p1, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp$1;->a(Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;

    move-result-object v0

    return-object v0
.end method
