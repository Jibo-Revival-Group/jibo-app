.class public Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;
.super Landroid/app/Activity;
.source "ManageSpaceActivity.java"


# instance fields
.field private a:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private b:Landroid/app/AlertDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()Landroid/app/AlertDialog;
    .locals 3

    .prologue
    .line 70
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 71
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->aj()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 72
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->F()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$2;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$2;-><init>(Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 79
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->G()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$1;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$1;-><init>(Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 86
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 70
    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.ManageSpaceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 49
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 50
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 51
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ai()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->setContentView(I)V

    .line 52
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->b:Landroid/app/AlertDialog;

    .line 53
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->b:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 54
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->b:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 59
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 60
    return-void
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.ManageSpaceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.ManageSpaceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    return-void
.end method
