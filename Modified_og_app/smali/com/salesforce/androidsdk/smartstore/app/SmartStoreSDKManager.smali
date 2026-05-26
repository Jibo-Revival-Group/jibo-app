.class public Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;
.super Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
.source "SmartStoreSDKManager.java"


# direct methods
.method protected constructor <init>(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 69
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;-><init>(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V

    .line 70
    return-void
.end method

.method public static H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;
    .locals 2

    .prologue
    .line 130
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    if-eqz v0, :cond_0

    .line 131
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    return-object v0

    .line 133
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Applications need to call SalesforceSDKManagerWithSmartStore.init() first."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 105
    const-class v0, Lcom/salesforce/androidsdk/ui/LoginActivity;

    invoke-static {p0, p1, p2, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V

    .line 107
    return-void
.end method

.method private static a(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 84
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    if-nez v0, :cond_0

    .line 85
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;-><init>(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    .line 87
    :cond_0
    invoke-static {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Landroid/content/Context;)V

    .line 90
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->f()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager;->b()V

    .line 91
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V

    .line 92
    return-void
.end method


# virtual methods
.method public I()V
    .locals 1

    .prologue
    .line 333
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 334
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
    .locals 1

    .prologue
    .line 230
    const-string v0, "smartstore"

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
    .locals 3

    .prologue
    .line 244
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 245
    const-string p1, "smartstore"

    .line 247
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "US"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 248
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->t()Ljava/lang/String;

    move-result-object v0

    .line 249
    if-nez v0, :cond_1

    const/4 v0, 0x0

    .line 250
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 251
    :cond_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c:Landroid/content/Context;

    invoke-static {v1, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    move-result-object v1

    .line 253
    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-direct {v2, v1, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;-><init>(Lnet/sqlcipher/database/SQLiteOpenHelper;Ljava/lang/String;)V

    return-object v2
.end method

.method protected a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 1

    .prologue
    .line 139
    if-eqz p1, :cond_0

    .line 141
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 146
    :goto_0
    invoke-super {p0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 147
    return-void

    .line 143
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
    .locals 1

    .prologue
    .line 218
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    return-object v0
.end method

.method public b(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 352
    const-string v0, "smartstore"

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 353
    return-void
.end method

.method public b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 364
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 365
    const-string p1, "smartstore"

    .line 367
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c:Landroid/content/Context;

    invoke-static {v0, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 368
    return-void
.end method

.method public declared-synchronized b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 151
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 152
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a()Ljava/util/Map;

    move-result-object v0

    .line 153
    if-eqz v0, :cond_1

    .line 154
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    .line 155
    if-eqz v0, :cond_1

    .line 156
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    .line 157
    if-eqz v0, :cond_0

    .line 160
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->getWritableDatabase(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    .line 163
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 151
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 168
    :cond_1
    :try_start_1
    invoke-super {p0, p1, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 170
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public c(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 1

    .prologue
    .line 342
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 343
    return-void
.end method

.method public g(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 190
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "GS"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 191
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 192
    const-string p1, "smartstore"

    .line 194
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->t()Ljava/lang/String;

    move-result-object v0

    .line 195
    if-nez v0, :cond_1

    .line 196
    invoke-virtual {p0, v2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 197
    :cond_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c:Landroid/content/Context;

    invoke-static {v1, p1, v2, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    move-result-object v1

    .line 199
    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-direct {v2, v1, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;-><init>(Lnet/sqlcipher/database/SQLiteOpenHelper;Ljava/lang/String;)V

    return-object v2
.end method

.method public h(Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 323
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 324
    const-string p1, "smartstore"

    .line 326
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->c:Landroid/content/Context;

    invoke-static {v0, p1, v1, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 327
    return-void
.end method
