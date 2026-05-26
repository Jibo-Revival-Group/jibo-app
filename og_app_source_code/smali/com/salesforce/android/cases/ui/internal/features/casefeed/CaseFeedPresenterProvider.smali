.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenterProvider;
.super Ljava/lang/Object;
.source "CaseFeedPresenterProvider.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;
    .locals 1

    .prologue
    .line 39
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-direct {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;-><init>(Lcom/salesforce/android/cases/ui/CaseUIClient;)V

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
    .line 35
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-virtual {p1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    return v0
.end method

.method public synthetic b(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;
    .locals 1

    .prologue
    .line 32
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenterProvider;->a(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    move-result-object v0

    return-object v0
.end method
