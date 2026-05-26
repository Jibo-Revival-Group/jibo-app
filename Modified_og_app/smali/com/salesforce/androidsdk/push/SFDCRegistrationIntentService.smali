.class public Lcom/salesforce/androidsdk/push/SFDCRegistrationIntentService;
.super Landroid/app/IntentService;
.source "SFDCRegistrationIntentService.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    const-string v0, "RegIntentService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 45
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 50
    :try_start_0
    invoke-static {p0}, Lcom/google/android/gms/iid/InstanceID;->c(Landroid/content/Context;)Lcom/google/android/gms/iid/InstanceID;

    move-result-object v0

    .line 51
    invoke-static {p0}, Lcom/salesforce/androidsdk/config/BootConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/BootConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->d()Ljava/lang/String;

    move-result-object v1

    const-string v2, "GCM"

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/iid/InstanceID;->b(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 54
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    .line 56
    invoke-static {p0, v0, v1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 58
    invoke-static {p0, v1}, Lcom/salesforce/androidsdk/push/PushMessaging;->c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    :goto_0
    return-void

    .line 59
    :catch_0
    move-exception v0

    .line 60
    const-string v1, "RegIntentService"

    const-string v2, "Error during GCM registration"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
