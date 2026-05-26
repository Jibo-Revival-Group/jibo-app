.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;
.source "CaseListActivityDelegate.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;",
        ">;",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

.field private b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;)V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;-><init>(Landroid/support/v7/app/AppCompatActivity;Ljava/lang/Class;)V

    .line 39
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

    .line 40
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->g()V

    .line 66
    :cond_0
    return-void
.end method

.method protected a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;)V
    .locals 1

    .prologue
    .line 43
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    .line 46
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;)V

    .line 49
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->a()Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V

    .line 50
    return-void
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;)V
    .locals 0

    .prologue
    .line 30
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;)V

    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->b()V

    .line 78
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->finish()V

    .line 72
    return-void
.end method

.method public g_()V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->i()V

    .line 58
    :cond_0
    return-void
.end method
