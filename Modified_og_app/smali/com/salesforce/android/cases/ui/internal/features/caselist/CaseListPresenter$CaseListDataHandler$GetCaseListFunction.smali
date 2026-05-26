.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;
.super Ljava/lang/Object;
.source "CaseListPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GetCaseListFunction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<+",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;)V
    .locals 0

    .prologue
    .line 390
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;)V
    .locals 0

    .prologue
    .line 390
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;)V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/ListViewDescribe;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<+",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 395
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    .line 398
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/ListViewDescribe;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/requests/CaseListRequest;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/requests/CaseListRequest;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$CreateCaseListItemViewModelsFunction;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$CreateCaseListItemViewModelsFunction;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;)V

    .line 401
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 395
    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 390
    check-cast p1, Lcom/salesforce/android/cases/core/model/ListViewDescribe;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler$GetCaseListFunction;->a(Lcom/salesforce/android/cases/core/model/ListViewDescribe;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
