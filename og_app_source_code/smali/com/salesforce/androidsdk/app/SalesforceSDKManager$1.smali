.class Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;
.super Landroid/content/BroadcastReceiver;
.source "SalesforceSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/rest/ClientManager;

.field final synthetic b:Z

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Ljava/lang/String;

.field final synthetic e:Ljava/lang/String;

.field final synthetic f:Landroid/accounts/Account;

.field final synthetic g:Landroid/app/Activity;

.field final synthetic h:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 798
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->h:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iput-object p2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->a:Lcom/salesforce/androidsdk/rest/ClientManager;

    iput-boolean p3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->b:Z

    iput-object p4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->c:Ljava/lang/String;

    iput-object p5, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->d:Ljava/lang/String;

    iput-object p6, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->e:Ljava/lang/String;

    iput-object p7, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->f:Landroid/accounts/Account;

    iput-object p8, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->g:Landroid/app/Activity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 9

    .prologue
    .line 802
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.salesfore.mobilesdk.c2dm.UNREGISTERED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 803
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->h:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->a:Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-boolean v3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->b:Z

    iget-object v4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->c:Ljava/lang/String;

    iget-object v5, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->d:Ljava/lang/String;

    iget-object v6, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->e:Ljava/lang/String;

    iget-object v7, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->f:Landroid/accounts/Account;

    iget-object v8, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;->g:Landroid/app/Activity;

    move-object v1, p0

    invoke-static/range {v0 .. v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 806
    :cond_0
    return-void
.end method
