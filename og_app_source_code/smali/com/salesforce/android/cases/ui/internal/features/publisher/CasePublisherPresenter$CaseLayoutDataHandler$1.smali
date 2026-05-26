.class Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;
.super Ljava/lang/Object;
.source "CasePublisherPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;->a()Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/cases/core/model/DefaultValues;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<+",
        "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;)V
    .locals 0

    .prologue
    .line 443
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<+",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 447
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    iget-object v1, v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    .line 449
    invoke-static {v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;

    move-result-object v1

    .line 448
    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;Lcom/salesforce/android/cases/core/model/DefaultValues;)V

    .line 451
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 447
    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 443
    check-cast p1, Lcom/salesforce/android/cases/core/model/DefaultValues;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;->a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
