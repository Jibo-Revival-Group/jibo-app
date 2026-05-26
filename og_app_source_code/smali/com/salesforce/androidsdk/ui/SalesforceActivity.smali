.class public abstract Lcom/salesforce/androidsdk/ui/SalesforceActivity;
.super Landroid/app/Activity;
.source "SalesforceActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;,
        Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/androidsdk/security/PasscodeManager;

.field private b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

.field private c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 4

    .prologue
    .line 128
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v0

    .line 132
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v1

    .line 135
    new-instance v2, Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 136
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v3

    invoke-direct {v2, p0, v0, v1, v3}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$2;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$2;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V

    invoke-virtual {v2, p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/app/Activity;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V

    .line 151
    :cond_0
    return-void
.end method

.method public abstract a(Lcom/salesforce/androidsdk/rest/RestClient;)V
.end method

.method protected b()V
    .locals 0

    .prologue
    .line 157
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 63
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 66
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 67
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;

    invoke-direct {v0, p0, v3}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    .line 68
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.USERSWITCHED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 69
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;

    invoke-direct {v0, p0, v3}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    .line 70
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.LOGOUT_COMPLETE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 73
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->MainActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1, p0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 74
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 120
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 121
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 122
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 113
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 114
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/app/Activity;)V

    .line 115
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 78
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 81
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v0

    .line 85
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v1

    .line 88
    new-instance v2, Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 89
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v3

    invoke-direct {v2, p0, v0, v1, v3}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V

    invoke-virtual {v2, p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/app/Activity;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V

    .line 104
    :cond_0
    return-void
.end method

.method public onUserInteraction()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->f()V

    .line 109
    return-void
.end method
