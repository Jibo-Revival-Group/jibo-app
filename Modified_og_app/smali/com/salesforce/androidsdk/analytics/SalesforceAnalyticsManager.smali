.class public Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;
.super Ljava/lang/Object;
.source "SalesforceAnalyticsManager.java"


# static fields
.field private static a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;",
            ">;"
        }
    .end annotation
.end field

.field private static b:Z

.field private static c:Ljava/util/concurrent/ScheduledFuture;

.field private static d:I


# instance fields
.field private e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

.field private f:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

.field private g:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private h:Z

.field private i:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/analytics/transform/Transform;",
            ">;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/analytics/AnalyticsPublisher;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    const/16 v0, 0x8

    sput v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->d:I

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 385
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 386
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 387
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->d()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    move-result-object v0

    .line 388
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    .line 389
    new-instance v2, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->v()Ljava/lang/String;

    move-result-object v3

    .line 390
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v4

    .line 391
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v3, v4, v1, v0}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;)V

    iput-object v2, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    .line 393
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->d()Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->f:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    .line 394
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->i:Ljava/util/Map;

    .line 395
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->i:Ljava/util/Map;

    const-class v1, Lcom/salesforce/androidsdk/analytics/transform/AILTNTransform;

    const-class v2, Lcom/salesforce/androidsdk/analytics/AILTNPublisher;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 398
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e()V

    .line 399
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->h:Z

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Z)V

    .line 400
    return-void
.end method

.method public static declared-synchronized a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;
    .locals 2

    .prologue
    .line 94
    const-class v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized a(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 105
    const-class v2, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    monitor-enter v2

    if-nez p0, :cond_0

    .line 106
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object p0

    .line 108
    :cond_0
    if-nez p0, :cond_2

    .line 136
    :cond_1
    :goto_0
    monitor-exit v2

    return-object v0

    .line 111
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v1

    .line 112
    const-string v3, "000000000000000AAA"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object p1, v0

    .line 115
    :cond_3
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 116
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 119
    :cond_4
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    if-nez v0, :cond_6

    .line 120
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    .line 121
    new-instance v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;-><init>(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 122
    sget-object v3, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v3, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    :goto_1
    if-nez v0, :cond_5

    .line 127
    new-instance v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;-><init>(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V

    .line 128
    sget-object v3, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v3, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_5
    sget-boolean v1, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b:Z

    if-nez v1, :cond_1

    .line 133
    invoke-static {}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g()Ljava/util/concurrent/ScheduledFuture;

    move-result-object v1

    sput-object v1, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->c:Ljava/util/concurrent/ScheduledFuture;

    .line 134
    const/4 v1, 0x1

    sput-boolean v1, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 105
    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0

    .line 124
    :cond_6
    :try_start_2
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public static declared-synchronized a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 185
    const-class v1, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 186
    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 187
    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 188
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    if-eqz v0, :cond_1

    .line 189
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 190
    if-eqz v0, :cond_1

    .line 191
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 192
    sget-object v5, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    .line 193
    if-eqz v0, :cond_0

    .line 194
    iget-object v0, v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v0, v2, v3}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 185
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 200
    :cond_1
    monitor-exit v1

    return-void
.end method

.method public static declared-synchronized b(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 145
    const-class v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 146
    monitor-exit v0

    return-void

    .line 145
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized b(Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 155
    const-class v2, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    monitor-enter v2

    if-nez p0, :cond_0

    .line 156
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object p0

    .line 158
    :cond_0
    if-eqz p0, :cond_3

    .line 159
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    .line 160
    const-string v1, "000000000000000AAA"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 161
    const/4 p1, 0x0

    .line 163
    :cond_1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 164
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 166
    :goto_0
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    if-eqz v0, :cond_3

    .line 167
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    .line 168
    if-eqz v0, :cond_2

    .line 169
    iget-object v3, v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;->a()V

    .line 170
    invoke-direct {v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->f()V

    .line 172
    :cond_2
    sget-object v0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    :cond_3
    monitor-exit v2

    return-void

    .line 155
    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0

    :cond_4
    move-object v1, v0

    goto :goto_0
.end method

.method private declared-synchronized b(Z)V
    .locals 3

    .prologue
    .line 430
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    .line 431
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ailtn_policy"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->u()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 432
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 433
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 434
    const-string v1, "ailtn_enabled"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 435
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 436
    iput-boolean p1, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->h:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 437
    monitor-exit p0

    return-void

    .line 430
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private d()Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;
    .locals 10

    .prologue
    .line 403
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v4

    .line 404
    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v6

    .line 405
    const-string v1, ""

    .line 406
    const-string v2, ""

    .line 408
    :try_start_0
    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v5, 0x0

    invoke-virtual {v0, v3, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 409
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 410
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c()Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 418
    :goto_0
    sget-object v3, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 419
    const-string v0, "android"

    .line 420
    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->z()Ljava/lang/String;

    move-result-object v5

    .line 421
    const-string v0, "5.3.0"

    .line 422
    sget-object v7, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 423
    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->g()Ljava/lang/String;

    move-result-object v8

    .line 424
    invoke-static {v6}, Lcom/salesforce/androidsdk/config/BootConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/BootConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/BootConfig;->a()Ljava/lang/String;

    move-result-object v9

    .line 425
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;

    const-string v4, "android"

    const-string v6, "5.3.0"

    invoke-direct/range {v0 .. v9}, Lcom/salesforce/androidsdk/analytics/model/DeviceAppAttributes;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 411
    :catch_0
    move-exception v0

    .line 412
    const-string v3, "AnalyticsManager"

    const-string v5, "Could not read package info"

    invoke-static {v3, v5, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 413
    :catch_1
    move-exception v0

    .line 416
    const-string v3, "AnalyticsManager"

    const-string v5, "Could not read package info"

    invoke-static {v3, v5, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private e()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 440
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    .line 441
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ailtn_policy"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->u()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 442
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 443
    const-string v1, "ailtn_enabled"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 444
    invoke-direct {p0, v3}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b(Z)V

    .line 446
    :cond_0
    const-string v1, "ailtn_enabled"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->h:Z

    .line 447
    return-void
.end method

.method private f()V
    .locals 3

    .prologue
    .line 450
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    .line 451
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ailtn_policy"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->u()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 452
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 453
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 454
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 455
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 456
    return-void
.end method

.method private static g()Ljava/util/concurrent/ScheduledFuture;
    .locals 7

    .prologue
    .line 459
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    .line 460
    new-instance v1, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager$1;

    invoke-direct {v1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager$1;-><init>()V

    .line 467
    const-wide/16 v2, 0x0

    sget v4, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->d:I

    int-to-long v4, v4

    sget-object v6, Ljava/util/concurrent/TimeUnit;->HOURS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->e:Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;

    return-object v0
.end method

.method public declared-synchronized a(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 302
    monitor-enter p0

    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 351
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 305
    :cond_1
    :try_start_1
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 306
    const/4 v2, 0x1

    .line 307
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->i:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 308
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 311
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/analytics/transform/Transform;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-object v4, v1

    .line 315
    :goto_2
    if-eqz v4, :cond_5

    .line 316
    :try_start_3
    new-instance v7, Lorg/json/JSONArray;

    invoke-direct {v7}, Lorg/json/JSONArray;-><init>()V

    .line 317
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_2
    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    .line 318
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v5, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 319
    invoke-interface {v4, v1}, Lcom/salesforce/androidsdk/analytics/transform/Transform;->a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject;

    move-result-object v1

    .line 320
    if-eqz v1, :cond_2

    .line 321
    invoke-virtual {v7, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_3

    .line 302
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 312
    :catch_0
    move-exception v1

    .line 313
    :try_start_4
    const-string v4, "AnalyticsManager"

    const-string v7, "Exception thrown while instantiating class"

    invoke-static {v4, v7, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-object v4, v3

    goto :goto_2

    .line 326
    :cond_3
    :try_start_5
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->i:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/AnalyticsPublisher;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 330
    :goto_4
    if-eqz v0, :cond_5

    .line 331
    :try_start_6
    invoke-interface {v0, v7}, Lcom/salesforce/androidsdk/analytics/AnalyticsPublisher;->a(Lorg/json/JSONArray;)Z

    move-result v0

    .line 338
    if-eqz v2, :cond_5

    :goto_5
    move v2, v0

    .line 343
    goto :goto_1

    .line 327
    :catch_1
    move-exception v0

    .line 328
    const-string v1, "AnalyticsManager"

    const-string v4, "Exception thrown while instantiating class"

    invoke-static {v1, v4, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v3

    goto :goto_4

    .line 348
    :cond_4
    if-eqz v2, :cond_0

    .line 349
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->f:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-virtual {v0, v5}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b(Ljava/util/List;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_0

    :cond_5
    move v0, v2

    goto :goto_5
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 249
    if-eqz p1, :cond_0

    .line 250
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "AI"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 254
    :goto_0
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b(Z)V

    .line 255
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->f:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Z)V

    .line 256
    return-void

    .line 252
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "AI"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public b()V
    .locals 3

    .prologue
    .line 262
    new-instance v0, Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/config/AdminSettingsManager;-><init>()V

    .line 263
    const-string v1, "ailtn_enabled"

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/config/AdminSettingsManager;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;

    move-result-object v0

    .line 264
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 265
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 266
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Z)V

    .line 271
    :cond_0
    :goto_0
    return-void

    .line 268
    :cond_1
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Z)V

    goto :goto_0
.end method

.method public declared-synchronized c()V
    .locals 1

    .prologue
    .line 289
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->f:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a()Ljava/util/List;

    move-result-object v0

    .line 290
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Ljava/util/List;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 291
    monitor-exit p0

    return-void

    .line 289
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
