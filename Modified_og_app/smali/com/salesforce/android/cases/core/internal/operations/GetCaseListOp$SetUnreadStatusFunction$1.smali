.class Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;
.super Ljava/lang/Object;
.source "GetCaseListOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->b(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Ljava/util/Date;",
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

.field final synthetic b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;

    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->a:Ljava/util/List;

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
            "Ljava/util/Date;",
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
    .line 96
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    .line 98
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v2

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseListRecord;

    .line 100
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v1

    .line 101
    invoke-interface {p1, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 102
    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;

    .line 103
    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Date;

    invoke-static {v4, v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;Lcom/salesforce/android/cases/core/model/CaseListRecord;Ljava/util/Date;Ljava/util/List;)Z

    move-result v1

    .line 102
    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->a(Z)V

    goto :goto_0

    .line 106
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;

    sget-object v4, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->a:Ljava/util/Date;

    invoke-static {v1, v0, v4, v2}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;Lcom/salesforce/android/cases/core/model/CaseListRecord;Ljava/util/Date;Ljava/util/List;)Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->a(Z)V

    goto :goto_0

    .line 109
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->a:Ljava/util/List;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 94
    check-cast p1, Ljava/util/Map;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;->a(Ljava/util/Map;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
