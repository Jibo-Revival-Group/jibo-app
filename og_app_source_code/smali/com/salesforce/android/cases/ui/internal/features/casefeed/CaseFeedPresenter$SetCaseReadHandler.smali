.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;
.super Ljava/lang/Object;
.source "CaseFeedPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SetCaseReadHandler"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

.field private final b:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 322
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->b:Ljava/lang/String;

    .line 323
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
    .line 326
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    const-string v1, "Successfully updated case {} last read date."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->b:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 327
    return-void
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
    .line 330
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    const-string v1, "An error occurred while trying to update case {} last read date.\n\n{}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;->b:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 331
    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 330
    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 332
    return-void
.end method
