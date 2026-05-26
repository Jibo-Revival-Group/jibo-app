.class public Lcom/salesforce/androidsdk/push/PushService;
.super Landroid/app/IntentService;
.source "PushService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/push/PushService$SFDCRegistrationRetryAlarmReceiver;
    }
.end annotation


# static fields
.field private static a:Landroid/os/PowerManager$WakeLock;


# instance fields
.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 122
    const-string v0, "PushService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 123
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    .line 124
    return-void
.end method

.method private a(JLcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 7

    .prologue
    .line 192
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 193
    const/16 v0, 0xe

    long-to-int v2, p1

    invoke-virtual {v1, v0, v2}, Ljava/util/Calendar;->add(II)V

    .line 194
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    const-class v3, Lcom/salesforce/androidsdk/push/PushService$SFDCRegistrationRetryAlarmReceiver;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 195
    if-nez p3, :cond_0

    .line 196
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 197
    const-string v3, "account_bundle"

    const-string v4, "all_accounts"

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    const-string v3, "account_bundle"

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 202
    :goto_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    const/4 v3, 0x1

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v2, v3, v0, v4}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 204
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    const-string v3, "alarm"

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 205
    const/4 v3, 0x0

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v0, v3, v4, v5, v2}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 206
    return-void

    .line 200
    :cond_0
    const-string v2, "account_bundle"

    invoke-virtual {p3}, Lcom/salesforce/androidsdk/accounts/UserAccount;->w()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
.end method

.method static a(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 105
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    .line 106
    sget-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    if-nez v0, :cond_0

    .line 107
    const-string v0, "power"

    invoke-virtual {v1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    .line 108
    const/4 v2, 0x1

    const-string v3, "PushService"

    invoke-virtual {v0, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    .line 110
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 111
    const-class v0, Lcom/salesforce/androidsdk/push/PushService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v1, v0}, Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    .line 112
    invoke-virtual {v1, p0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    move-result-object v0

    .line 113
    if-nez v0, :cond_1

    .line 114
    const-string v0, "PushService"

    const-string v1, "Could not start GCM service"

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    :cond_1
    return-void
.end method

.method private a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 4

    .prologue
    .line 243
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->g(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    .line 244
    invoke-direct {p0, v0, p1}, Lcom/salesforce/androidsdk/push/PushService;->c(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 248
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->h(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 249
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.salesfore.mobilesdk.c2dm.UNREGISTERED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 250
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.salesfore.mobilesdk.c2dm.ACTUAL_UNREGISTERED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 252
    :goto_0
    return-void

    .line 245
    :catch_0
    move-exception v0

    .line 246
    :try_start_1
    const-string v1, "PushService"

    const-string v2, "Error occurred during SFDC unregistration"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 248
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->h(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 249
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.salesfore.mobilesdk.c2dm.UNREGISTERED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 250
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.salesfore.mobilesdk.c2dm.ACTUAL_UNREGISTERED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    .line 248
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v1, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->h(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 249
    iget-object v1, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v2, Landroid/content/Intent;

    const-string v3, "com.salesfore.mobilesdk.c2dm.UNREGISTERED"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 250
    iget-object v1, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    new-instance v2, Landroid/content/Intent;

    const-string v3, "com.salesfore.mobilesdk.c2dm.ACTUAL_UNREGISTERED"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    throw v0
.end method

.method private a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 215
    if-nez p2, :cond_0

    .line 216
    const-string v0, "PushService"

    const-string v1, "Account is null, will retry registration later"

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    :goto_0
    return-void

    .line 219
    :cond_0
    const-wide/16 v0, 0x7530

    .line 221
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/salesforce/androidsdk/push/PushService;->b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v2

    .line 222
    if-eqz v2, :cond_1

    .line 223
    const-wide/32 v0, 0x1ee62800

    .line 224
    iget-object v3, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v3, p1, v2, p2}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 232
    :goto_1
    invoke-direct {p0, v0, v1, v5}, Lcom/salesforce/androidsdk/push/PushService;->a(JLcom/salesforce/androidsdk/accounts/UserAccount;)V

    goto :goto_0

    .line 227
    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v2, p1, p2}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 229
    :catch_0
    move-exception v2

    move-object v6, v2

    move-wide v2, v0

    move-object v0, v6

    .line 230
    :try_start_2
    const-string v1, "PushService"

    const-string v4, "Error occurred during SFDC registration"

    invoke-static {v1, v4, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 232
    invoke-direct {p0, v2, v3, v5}, Lcom/salesforce/androidsdk/push/PushService;->a(JLcom/salesforce/androidsdk/accounts/UserAccount;)V

    goto :goto_0

    :catchall_0
    move-exception v2

    move-object v6, v2

    move-wide v2, v0

    move-object v0, v6

    :goto_2
    invoke-direct {p0, v2, v3, v5}, Lcom/salesforce/androidsdk/push/PushService;->a(JLcom/salesforce/androidsdk/accounts/UserAccount;)V

    throw v0

    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method private a(ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 1

    .prologue
    .line 175
    if-eqz p1, :cond_1

    .line 176
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v0, p2}, Lcom/salesforce/androidsdk/push/PushMessaging;->e(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    .line 177
    if-eqz v0, :cond_0

    .line 178
    invoke-direct {p0, v0, p2}, Lcom/salesforce/androidsdk/push/PushService;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 183
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/push/PushService;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    goto :goto_0
.end method

.method private b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;
    .locals 21

    .prologue
    .line 332
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->E()Lcom/salesforce/androidsdk/rest/ClientManager;

    move-result-object v1

    .line 333
    const/16 v19, 0x0

    .line 341
    if-eqz v1, :cond_0

    .line 343
    :try_start_0
    new-instance v20, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;

    .line 344
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->b()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v20

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;-><init>(Lcom/salesforce/androidsdk/rest/ClientManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 345
    new-instance v1, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->j()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/net/URI;

    .line 346
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->e()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    new-instance v4, Ljava/net/URI;

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->c()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    new-instance v5, Ljava/net/URI;

    .line 347
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->d()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->i()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->h()Ljava/lang/String;

    move-result-object v7

    .line 348
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v8

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v9

    .line 349
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->k()Ljava/lang/String;

    move-result-object v10

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->l()Ljava/lang/String;

    move-result-object v11

    .line 350
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->m()Ljava/lang/String;

    move-result-object v12

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->o()Ljava/lang/String;

    move-result-object v13

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->n()Ljava/lang/String;

    move-result-object v14

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->p()Ljava/lang/String;

    move-result-object v15

    .line 351
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->q()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->r()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->s()Ljava/util/Map;

    move-result-object v18

    invoke-direct/range {v1 .. v18}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;-><init>(Ljava/lang/String;Ljava/net/URI;Ljava/net/URI;Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 352
    new-instance v2, Lcom/salesforce/androidsdk/rest/RestClient;

    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    move-object/from16 v0, v20

    invoke-direct {v2, v1, v3, v4, v0}, Lcom/salesforce/androidsdk/rest/RestClient;-><init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/auth/HttpAccess;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v1, v2

    .line 358
    :goto_0
    return-object v1

    .line 354
    :catch_0
    move-exception v1

    .line 355
    const-string v2, "PushService"

    const-string v3, "Failed to get rest client"

    invoke-static {v2, v3, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_0
    move-object/from16 v1, v19

    goto :goto_0
.end method

.method private b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 263
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 264
    const-string v2, "ConnectionToken"

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    const-string v2, "ServiceType"

    const-string v3, "androidGcm"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    :try_start_0
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/push/PushService;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v2

    .line 268
    iget-object v3, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v3}, Lcom/salesforce/androidsdk/rest/ApiVersionStrings;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "MobilePushServiceDevice"

    invoke-static {v3, v4, v0}, Lcom/salesforce/androidsdk/rest/RestRequest;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/androidsdk/rest/RestRequest;

    move-result-object v0

    .line 270
    if-eqz v2, :cond_0

    .line 271
    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/rest/RestClient;->b(Lcom/salesforce/androidsdk/rest/RestRequest;)Lcom/salesforce/androidsdk/rest/RestResponse;

    move-result-object v2

    .line 281
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestResponse;->a()I

    move-result v0

    const/16 v3, 0xc9

    if-ne v0, v3, :cond_1

    .line 282
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestResponse;->f()Lorg/json/JSONObject;

    move-result-object v0

    .line 283
    if-eqz v0, :cond_2

    .line 284
    const-string v3, "id"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 289
    :goto_0
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestResponse;->c()V

    .line 290
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    const-string v3, "PN"

    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    move-object v1, v0

    .line 296
    :cond_0
    :goto_1
    return-object v1

    .line 286
    :cond_1
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestResponse;->a()I

    move-result v0

    const/16 v3, 0x194

    if-ne v0, v3, :cond_2

    .line 287
    const-string v0, "not_enabled"
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 293
    :catch_0
    move-exception v0

    .line 294
    const-string v2, "PushService"

    const-string v3, "Push notification registration failed"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method private c(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z
    .locals 3

    .prologue
    .line 308
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushService;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/androidsdk/rest/ApiVersionStrings;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MobilePushServiceDevice"

    invoke-static {v0, v1, p1}, Lcom/salesforce/androidsdk/rest/RestRequest;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/androidsdk/rest/RestRequest;

    move-result-object v0

    .line 311
    :try_start_0
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/push/PushService;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v1

    .line 312
    if-eqz v1, :cond_1

    .line 313
    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/rest/RestClient;->b(Lcom/salesforce/androidsdk/rest/RestRequest;)Lcom/salesforce/androidsdk/rest/RestResponse;

    move-result-object v0

    .line 314
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestResponse;->a()I

    move-result v1

    const/16 v2, 0xcc

    if-ne v1, v2, :cond_0

    .line 315
    const/4 v0, 0x1

    .line 322
    :goto_0
    return v0

    .line 317
    :cond_0
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestResponse;->c()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 322
    :cond_1
    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    .line 319
    :catch_0
    move-exception v0

    .line 320
    const-string v1, "PushService"

    const-string v2, "Push notification unregistration failed"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 7

    .prologue
    .line 133
    const-string v0, "account_bundle"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .line 134
    const/4 v1, 0x0

    .line 135
    const/4 v0, 0x0

    .line 136
    if-eqz v2, :cond_0

    .line 137
    const-string v3, "account_bundle"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 138
    const-string v4, "all_accounts"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 139
    const/4 v0, 0x1

    .line 144
    :cond_0
    :goto_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v2

    .line 145
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v3

    .line 147
    :try_start_0
    const-string v4, "com.salesforce.mobilesdk.c2dm.intent.RETRY"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 148
    const-string v5, "com.salesforce.mobilesdk.c2dm.intent.UNREGISTER"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    .line 149
    if-nez v4, :cond_1

    if-eqz v5, :cond_6

    .line 150
    :cond_1
    if-eqz v0, :cond_4

    .line 151
    if-eqz v3, :cond_6

    .line 152
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 154
    invoke-direct {p0, v4, v0}, Lcom/salesforce/androidsdk/push/PushService;->a(ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 168
    :catchall_0
    move-exception v0

    sget-object v1, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    if-eqz v1, :cond_2

    sget-object v1, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 169
    sget-object v1, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1}, Landroid/os/PowerManager$WakeLock;->release()V

    :cond_2
    throw v0

    .line 141
    :cond_3
    new-instance v1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {v1, v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Landroid/os/Bundle;)V

    goto :goto_0

    .line 158
    :cond_4
    if-nez v1, :cond_5

    .line 159
    :try_start_1
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    .line 162
    :cond_5
    invoke-direct {p0, v4, v1}, Lcom/salesforce/androidsdk/push/PushService;->a(ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 168
    :cond_6
    sget-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    if-eqz v0, :cond_7

    sget-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 169
    sget-object v0, Lcom/salesforce/androidsdk/push/PushService;->a:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 172
    :cond_7
    return-void
.end method
