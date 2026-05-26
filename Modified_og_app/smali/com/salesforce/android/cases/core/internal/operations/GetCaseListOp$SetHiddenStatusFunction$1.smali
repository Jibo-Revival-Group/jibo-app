.class Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;
.super Ljava/lang/Object;
.source "GetCaseListOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;->b(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Ljava/util/Map",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Boolean;",
        ">;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;

    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/util/Map;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 160
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseListRecord;

    .line 161
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v1

    .line 162
    invoke-interface {p1, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 163
    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 164
    if-eqz v1, :cond_2

    .line 166
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->e()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 167
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 168
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;

    iget-object v1, v1, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction;->a:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;

    iget-object v1, v1, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0, v4}, Lcom/salesforce/android/cases/core/internal/local/LocalRepository;->a(Ljava/lang/String;Z)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0

    .line 171
    :cond_1
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b(Z)V

    goto :goto_0

    .line 174
    :cond_2
    invoke-interface {v0, v4}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b(Z)V

    goto :goto_0

    .line 178
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->a:Ljava/util/List;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 158
    check-cast p1, Ljava/util/Map;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetHiddenStatusFunction$1;->a(Ljava/util/Map;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
