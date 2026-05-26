.class public abstract Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;
.super Ljava/lang/Object;
.source "BaseActivityDelegate.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<A:",
        "Landroid/support/v7/app/AppCompatActivity;",
        "P::",
        "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private a:Landroid/support/v7/app/AppCompatActivity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TA;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TP;>;"
        }
    .end annotation
.end field

.field private c:Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

.field private d:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/AppCompatActivity;Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;",
            "Ljava/lang/Class",
            "<TP;>;)V"
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a:Landroid/support/v7/app/AppCompatActivity;

    .line 47
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->b:Ljava/lang/Class;

    .line 48
    return-void
.end method

.method private a(Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 2

    .prologue
    .line 93
    move-object v0, p1

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->g()Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->d:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->d:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->b:Ljava/lang/Class;

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->a(Lcom/salesforce/android/cases/ui/CaseUIClient;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a(Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;)V

    .line 100
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a(Lcom/salesforce/android/cases/ui/CaseUIClient;)V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a:Landroid/support/v7/app/AppCompatActivity;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/CaseUI;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUI;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 63
    return-void
.end method

.method protected abstract a(Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TP;)V"
        }
    .end annotation
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->c:Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;->d()V

    .line 75
    :cond_0
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    return v0
.end method

.method public e()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->d:Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->b:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->a(Ljava/lang/Class;)V

    .line 90
    return-void
.end method

.method public g_()V
    .locals 0

    .prologue
    .line 67
    return-void
.end method
