.class Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;
.source "CasePublisherPresenter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CreateCaseHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler",
        "<",
        "Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;",
        ">;"
    }
.end annotation


# instance fields
.field a:Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 489
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 494
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    .line 496
    invoke-static {v2}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->a:Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;

    invoke-direct {v1, v2, v3}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;-><init>(Ljava/lang/String;Lcom/salesforce/android/cases/core/model/CreateCaseRecord;)V

    invoke-virtual {v1}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;

    move-result-object v1

    .line 495
    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 494
    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;)V
    .locals 2

    .prologue
    .line 504
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;Ljava/lang/String;)V

    .line 505
    return-void
.end method

.method protected bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 489
    check-cast p1, Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->a(Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;)V

    return-void
.end method

.method protected a(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 512
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    .line 513
    return-void
.end method

.method protected b()V
    .locals 1

    .prologue
    .line 500
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->e(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    .line 501
    return-void
.end method

.method protected c()V
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    .line 509
    return-void
.end method
