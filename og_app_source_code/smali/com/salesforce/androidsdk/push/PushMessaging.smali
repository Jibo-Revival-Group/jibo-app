.class public Lcom/salesforce/androidsdk/push/PushMessaging;
.super Ljava/lang/Object;
.source "PushMessaging.java"


# static fields
.field private static final a:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 77
    const/4 v0, 0x2

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/push/PushMessaging;->a:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method private static a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 372
    const-string v0, "gcm_prefs"

    .line 373
    if-eqz p0, :cond_0

    .line 374
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->u()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 376
    :cond_0
    return-object v0
.end method

.method public static a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 95
    if-eqz p1, :cond_1

    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->f(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 96
    const/4 v0, 0x1

    invoke-static {p0, v0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;ZLcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 97
    invoke-static {p0}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/androidsdk/push/SFDCRegistrationIntentService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 100
    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 103
    :cond_1
    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    goto :goto_0
.end method

.method private static a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 160
    if-nez p1, :cond_1

    .line 161
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 162
    const-string v1, "account_bundle"

    const-string v2, "all_accounts"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    const-string v1, "account_bundle"

    invoke-virtual {p2, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 164
    invoke-static {p2}, Lcom/salesforce/androidsdk/push/PushService;->a(Landroid/content/Intent;)V

    .line 169
    :cond_0
    :goto_0
    return-void

    .line 165
    :cond_1
    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->f(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 166
    const-string v0, "account_bundle"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->w()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 167
    invoke-static {p2}, Lcom/salesforce/androidsdk/push/PushService;->a(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 4

    .prologue
    .line 194
    invoke-static {p2}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 196
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 197
    const-string v1, "c2dm_registration_id"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 198
    const-string v1, "backoff"

    const-wide/16 v2, 0x7530

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 199
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 200
    return-void
.end method

.method static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 354
    invoke-static {p3}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 356
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 357
    const-string v1, "c2dm_registration_id"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 358
    const-string v1, "deviceId"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 359
    const-string v1, "backoff"

    const-wide/16 v2, 0x7530

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 360
    const-string v1, "last_registration_change"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 361
    const-string v1, "inprogress"

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 362
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 363
    return-void
.end method

.method public static a(Landroid/content/Context;ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 282
    invoke-static {p2}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 284
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 285
    const-string v1, "inprogress"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 286
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 287
    return-void
.end method

.method private static a(Landroid/content/Context;)Z
    .locals 1

    .prologue
    .line 399
    invoke-static {}, Lcom/google/android/gms/common/GoogleApiAvailability;->a()Lcom/google/android/gms/common/GoogleApiAvailability;

    move-result-object v0

    .line 400
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/GoogleApiAvailability;->a(Landroid/content/Context;)I

    move-result v0

    .line 401
    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 3

    .prologue
    .line 117
    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->f(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    const/4 v0, 0x1

    invoke-static {p0, v0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;ZLcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 119
    invoke-static {p0}, Lcom/google/android/gms/iid/InstanceID;->c(Landroid/content/Context;)Lcom/google/android/gms/iid/InstanceID;

    move-result-object v0

    .line 121
    sget-object v1, Lcom/salesforce/androidsdk/push/PushMessaging;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v2, Lcom/salesforce/androidsdk/push/PushMessaging$1;

    invoke-direct {v2, v0}, Lcom/salesforce/androidsdk/push/PushMessaging$1;-><init>(Lcom/google/android/gms/iid/InstanceID;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 133
    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->d(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 135
    :cond_0
    return-void
.end method

.method public static c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 144
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.mobilesdk.c2dm.intent.RETRY"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 145
    invoke-static {p0, p1, v0}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/content/Intent;)V

    .line 146
    return-void
.end method

.method public static d(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 155
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.mobilesdk.c2dm.intent.UNREGISTER"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 156
    invoke-static {p0, p1, v0}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/content/Intent;)V

    .line 157
    return-void
.end method

.method public static e(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 180
    invoke-static {p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 182
    const-string v1, "c2dm_registration_id"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static f(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 210
    invoke-static {p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 212
    const-string v2, "c2dm_registration_id"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public static g(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 250
    invoke-static {p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 252
    const-string v1, "deviceId"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static h(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 309
    invoke-static {p1}, Lcom/salesforce/androidsdk/push/PushMessaging;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 311
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 312
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 313
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 314
    return-void
.end method
