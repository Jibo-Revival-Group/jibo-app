.class public abstract Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;
.super Landroid/app/ExpandableListActivity;
.source "SalesforceExpandableListActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;,
        Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityUserSwitchReceiver;
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
    .line 50
    invoke-direct {p0}, Landroid/app/ExpandableListActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 4

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 132
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v0

    .line 133
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v1

    .line 136
    new-instance v2, Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 137
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v3

    invoke-direct {v2, p0, v0, v1, v3}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$2;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$2;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;)V

    invoke-virtual {v2, p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/app/Activity;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V

    .line 152
    :cond_0
    return-void
.end method

.method public abstract a(Lcom/salesforce/androidsdk/rest/RestClient;)V
.end method

.method protected b()V
    .locals 0

    .prologue
    .line 158
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 65
    invoke-super {p0, p1}, Landroid/app/ExpandableListActivity;->onCreate(Landroid/os/Bundle;)V

    .line 68
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 69
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityUserSwitchReceiver;

    invoke-direct {v0, p0, v3}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityUserSwitchReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    .line 70
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.USERSWITCHED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 71
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;

    invoke-direct {v0, p0, v3}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    .line 72
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.LOGOUT_COMPLETE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 75
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->MainActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1, p0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 76
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->b:Lcom/salesforce/androidsdk/util/UserSwitchReceiver;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 121
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->c:Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 122
    invoke-super {p0}, Landroid/app/ExpandableListActivity;->onDestroy()V

    .line 123
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 114
    invoke-super {p0}, Landroid/app/ExpandableListActivity;->onPause()V

    .line 115
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/app/Activity;)V

    .line 116
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 80
    invoke-super {p0}, Landroid/app/ExpandableListActivity;->onResume()V

    .line 83
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v0

    .line 87
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v1

    .line 90
    new-instance v2, Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v3

    invoke-direct {v2, p0, v0, v1, v3}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$1;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$1;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;)V

    invoke-virtual {v2, p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/app/Activity;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V

    .line 105
    :cond_0
    return-void
.end method

.method public onUserInteraction()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->f()V

    .line 110
    return-void
.end method
