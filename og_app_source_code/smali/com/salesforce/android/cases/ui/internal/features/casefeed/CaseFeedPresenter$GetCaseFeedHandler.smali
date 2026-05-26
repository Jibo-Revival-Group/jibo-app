.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;
.source "CaseFeedPresenter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "GetCaseFeedHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

.field private b:Z


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 287
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v1

    new-instance v0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v2, v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    .line 289
    invoke-static {v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v3

    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    .line 290
    invoke-static {v4}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v4

    invoke-interface {v4}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;

    .line 291
    invoke-virtual {v0, v5}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;

    .line 292
    invoke-virtual {v0, v5}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;

    .line 293
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    move-result-object v0

    .line 288
    invoke-interface {v1, v0}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v2, v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    .line 294
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;-><init>(Landroid/content/Context;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 287
    return-object v0
.end method

.method protected a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iput-object p1, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    .line 305
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V

    .line 306
    return-void
.end method

.method protected bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 277
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V

    return-void
.end method

.method protected a(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->e(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    .line 314
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 282
    iput-boolean p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->b:Z

    .line 283
    invoke-super {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/AbstractHandler;->d()V

    .line 284
    return-void
.end method

.method protected b()V
    .locals 1

    .prologue
    .line 298
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->b:Z

    if-eqz v0, :cond_0

    .line 299
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    .line 301
    :cond_0
    return-void
.end method

.method protected c()V
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    .line 310
    return-void
.end method
