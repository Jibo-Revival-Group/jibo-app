.class Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SalesforceSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CleanupReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;)V
    .locals 0

    .prologue
    .line 1243
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;->a:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;)V
    .locals 0

    .prologue
    .line 1243
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 1247
    if-eqz p2, :cond_1

    .line 1248
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.salesforce.CLEANUP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "processId"

    .line 1249
    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->G()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1251
    const/4 v0, 0x0

    .line 1252
    const-string v1, "userAccount"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1253
    new-instance v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    const-string v1, "userAccount"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Landroid/os/Bundle;)V

    .line 1255
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;->a:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 1257
    :cond_1
    return-void
.end method
