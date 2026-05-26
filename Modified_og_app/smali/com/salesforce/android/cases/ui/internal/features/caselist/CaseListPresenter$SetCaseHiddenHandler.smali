.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;
.super Ljava/lang/Object;
.source "CaseListPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SetCaseHiddenHandler"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

.field private final b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

.field private final c:Z


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;Z)V
    .locals 0

    .prologue
    .line 450
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 451
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    .line 452
    iput-boolean p3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->c:Z

    .line 453
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 456
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    const-string v1, "Successfully set case {} hidden to {}."

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {v4}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-boolean v4, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->c:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 457
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->c:Z

    if-eqz v0, :cond_0

    .line 458
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 462
    :goto_0
    return-void

    .line 460
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 465
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    const-string v1, "An error occurred while trying to set case {} hidden to {}.\n\n{}"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    .line 466
    invoke-virtual {v4}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-boolean v4, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;->c:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 465
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 467
    return-void
.end method
