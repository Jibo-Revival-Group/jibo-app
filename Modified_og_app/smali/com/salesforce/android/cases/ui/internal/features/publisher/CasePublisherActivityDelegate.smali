.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;
.source "CasePublisherActivityDelegate.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;",
        ">;",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

.field private b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;)V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;-><init>(Landroid/support/v7/app/AppCompatActivity;Ljava/lang/Class;)V

    .line 39
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

    .line 40
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->f()V

    .line 61
    :cond_0
    return-void
.end method

.method protected a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;)V
    .locals 2

    .prologue
    .line 43
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    .line 46
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;)V

    .line 49
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;->a()Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

    invoke-virtual {v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->setFragmentManager(Landroid/support/v4/app/FragmentManager;)V

    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;->a()Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V

    .line 53
    return-void
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;)V
    .locals 0

    .prologue
    .line 30
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;)V

    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->g()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherActivity;->finish()V

    .line 73
    return-void
.end method
