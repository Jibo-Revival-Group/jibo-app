.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "CaseFeedActivity.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/shared/CasesSdkActivity;


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

.field private b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 46
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 55
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    const-string v1, "EXTRA_CASE_ID"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 57
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 58
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    return-object v0
.end method

.method public finish()V
    .locals 1

    .prologue
    .line 87
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 88
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->e()V

    .line 89
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    :goto_0
    return-void

    .line 83
    :cond_0
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const-string v0, "com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 61
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 62
    sget v0, Lcom/salesforce/android/cases/R$layout;->activity_case_feed:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->setContentView(I)V

    .line 63
    invoke-static {p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/app/Activity;)V

    .line 64
    sget v0, Lcom/salesforce/android/cases/R$id;->case_feed_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a(Landroid/os/Bundle;)V

    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "EXTRA_CASE_ID"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->setCaseId(Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a()V

    .line 77
    return-void
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 70
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 71
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b(Landroid/os/Bundle;)V

    .line 72
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    return-void
.end method
