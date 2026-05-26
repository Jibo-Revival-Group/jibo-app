.class Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;
.super Ljava/lang/Thread;
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
.field final synthetic a:Landroid/content/BroadcastReceiver;

.field final synthetic b:Lcom/salesforce/androidsdk/rest/ClientManager;

.field final synthetic c:Z

.field final synthetic d:Ljava/lang/String;

.field final synthetic e:Ljava/lang/String;

.field final synthetic f:Ljava/lang/String;

.field final synthetic g:Landroid/accounts/Account;

.field final synthetic h:Landroid/app/Activity;

.field final synthetic i:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 818
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->i:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iput-object p2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->a:Landroid/content/BroadcastReceiver;

    iput-object p3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    iput-boolean p4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->c:Z

    iput-object p5, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->d:Ljava/lang/String;

    iput-object p6, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->e:Ljava/lang/String;

    iput-object p7, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->f:Ljava/lang/String;

    iput-object p8, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->g:Landroid/accounts/Account;

    iput-object p9, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->h:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 820
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 821
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v0

    const-wide/16 v4, 0x7530

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->i:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-static {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 824
    const-wide/16 v2, 0x1f4

    invoke-static {v2, v3}, Landroid/os/SystemClock;->sleep(J)V

    goto :goto_0

    .line 826
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->i:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->a:Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-boolean v3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->c:Z

    iget-object v4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->d:Ljava/lang/String;

    iget-object v5, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->e:Ljava/lang/String;

    iget-object v6, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->f:Ljava/lang/String;

    iget-object v7, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->g:Landroid/accounts/Account;

    iget-object v8, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->h:Landroid/app/Activity;

    invoke-static/range {v0 .. v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 828
    return-void
.end method
