.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenterProvider;
.super Ljava/lang/Object;
.source "CasePublisherPresenterProvider.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;
    .locals 2

    .prologue
    .line 41
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;

    invoke-direct {v1}, Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;-><init>()V

    invoke-direct {v0, p1, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;-><init>(Lcom/salesforce/android/cases/ui/CaseUIClient;Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;)V

    return-object v0
.end method

.method public a(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 37
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-virtual {p1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    return v0
.end method

.method public synthetic b(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenterProvider;->a(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    move-result-object v0

    return-object v0
.end method
