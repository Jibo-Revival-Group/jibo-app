.class public Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;
.super Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;
.source "SmartStoreUpgradeManager.java"


# static fields
.field private static a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;-><init>()V

    return-void
.end method

.method public static declared-synchronized f()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;
    .locals 2

    .prologue
    .line 58
    const-class v1, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    if-nez v0, :cond_0

    .line 59
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    .line 61
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a:Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 58
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public b()V
    .locals 0

    .prologue
    .line 66
    invoke-super {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;->b()V

    .line 67
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->g()V

    .line 68
    return-void
.end method

.method protected e()V
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 103
    invoke-super {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;->e()V

    .line 110
    const-string v0, "smartstore%s.db"

    new-array v1, v3, [Ljava/lang/Object;

    const-string v2, ""

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 111
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    .line 118
    if-eqz v1, :cond_0

    .line 119
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 120
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 121
    const-string v2, "smartstore%s.db"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 122
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->k()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/databases"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 124
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    invoke-virtual {v3, v0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 130
    :cond_0
    return-void
.end method

.method protected declared-synchronized g()V
    .locals 3

    .prologue
    .line 75
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->h()Ljava/lang/String;

    move-result-object v0

    .line 76
    const-string v1, "5.3.0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-eqz v1, :cond_1

    .line 90
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 81
    :cond_1
    :try_start_1
    const-string v1, "smart_store_version"

    const-string v2, "5.3.0"

    invoke-virtual {p0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->h()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 75
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    const-string v0, "smart_store_version"

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
