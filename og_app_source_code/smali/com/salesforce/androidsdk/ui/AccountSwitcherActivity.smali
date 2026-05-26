.class public Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;
.super Landroid/app/Activity;
.source "AccountSwitcherActivity.java"


# instance fields
.field private a:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private a()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 99
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->al()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 100
    invoke-virtual {v0}, Landroid/widget/RadioGroup;->removeAllViews()V

    .line 101
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    .line 102
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v5

    .line 103
    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 127
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    if-nez v1, :cond_4

    .line 107
    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-object v2, v1

    :goto_1
    move v4, v3

    .line 110
    :goto_2
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v1

    if-ge v3, v1, :cond_3

    .line 111
    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 112
    if-eqz v1, :cond_2

    .line 113
    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a(Landroid/widget/RadioGroup;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 114
    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    move v4, v3

    .line 110
    :cond_2
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_2

    .line 123
    :cond_3
    invoke-virtual {v0, v4}, Landroid/widget/RadioGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;

    .line 124
    if-eqz v0, :cond_0

    .line 125
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->setChecked(Z)V

    goto :goto_0

    :cond_4
    move-object v2, v1

    goto :goto_1
.end method

.method private a(Landroid/widget/RadioGroup;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 1

    .prologue
    .line 136
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;

    invoke-direct {v0, p0, p2}, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;-><init>(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 137
    invoke-virtual {p1, v0}, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V

    .line 138
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.AccountSwitcherActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 54
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 55
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 56
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    .line 57
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ak()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->setContentView(I)V

    .line 58
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.AccountSwitcherActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 62
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 63
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a()V

    .line 64
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.AccountSwitcherActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    return-void
.end method

.method public switchToExistingAccount(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->al()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 75
    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v1

    .line 76
    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;

    .line 77
    if-eqz v0, :cond_0

    .line 78
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->getAccount()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 79
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;ILandroid/os/Bundle;)V

    .line 81
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->finish()V

    .line 82
    return-void
.end method

.method public switchToNewAccount(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->b:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->e()V

    .line 92
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;->finish()V

    .line 93
    return-void
.end method
