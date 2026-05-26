.class public Lcom/salesforce/androidsdk/push/PushService$SFDCRegistrationRetryAlarmReceiver;
.super Landroid/content/BroadcastReceiver;
.source "PushService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/push/PushService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SFDCRegistrationRetryAlarmReceiver"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 366
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 370
    if-eqz p2, :cond_0

    .line 371
    const-string v0, "account_bundle"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 372
    if-eqz v0, :cond_0

    .line 373
    const-string v1, "account_bundle"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 374
    const-string v2, "all_accounts"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 375
    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/salesforce/androidsdk/push/PushMessaging;->c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 381
    :cond_0
    :goto_0
    return-void

    .line 377
    :cond_1
    new-instance v1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {v1, v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Landroid/os/Bundle;)V

    invoke-static {p1, v1}, Lcom/salesforce/androidsdk/push/PushMessaging;->c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    goto :goto_0
.end method
