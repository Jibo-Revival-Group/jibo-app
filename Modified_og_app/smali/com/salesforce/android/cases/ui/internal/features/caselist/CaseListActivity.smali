.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "CaseListActivity.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/shared/CasesSdkActivity;


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

.field private b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 44
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    return-void
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 52
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 53
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    return-object v0
.end method

.method public finish()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 87
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->e()V

    .line 88
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    :goto_0
    return-void

    .line 82
    :cond_0
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 56
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 57
    sget v0, Lcom/salesforce/android/cases/R$layout;->activity_case_list:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->setContentView(I)V

    .line 58
    invoke-static {p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/app/Activity;)V

    .line 59
    sget v0, Lcom/salesforce/android/cases/R$id;->case_list_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a(Landroid/os/Bundle;)V

    .line 61
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->a()V

    .line 76
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 69
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 70
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->g_()V

    .line 71
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 64
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListActivityDelegate;->b(Landroid/os/Bundle;)V

    .line 66
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    return-void
.end method
