.class public Lcom/salesforce/androidsdk/rest/ClientManager;
.super Ljava/lang/Object;
.source "ClientManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;,
        Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;,
        Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;,
        Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;,
        Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;
    }
.end annotation


# instance fields
.field private final a:Landroid/accounts/AccountManager;

.field private final b:Ljava/lang/String;

.field private final c:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

.field private final d:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V
    .locals 1

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    invoke-static {p1}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    .line 84
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->b:Ljava/lang/String;

    .line 85
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->c:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 86
    iput-boolean p4, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->d:Z

    .line 87
    return-void
.end method

.method public static declared-synchronized a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 30

    .prologue
    .line 427
    const-class v13, Lcom/salesforce/androidsdk/rest/ClientManager;

    monitor-enter v13

    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v14

    .line 428
    if-eqz v14, :cond_b

    .line 429
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v2}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v15

    .line 430
    if-eqz v15, :cond_b

    array-length v2, v15

    if-lez v2, :cond_b

    .line 431
    array-length v0, v15

    move/from16 v16, v0

    const/4 v2, 0x0

    move v12, v2

    :goto_0
    move/from16 v0, v16

    if-ge v12, v0, :cond_b

    aget-object v17, v15, v12

    .line 434
    const-string v2, "authtoken"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 435
    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 436
    const-string v2, "loginUrl"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 437
    const-string v2, "id"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 438
    const-string v2, "instanceUrl"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 439
    const-string v2, "orgId"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 440
    const-string v2, "userId"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 441
    const-string v2, "username"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 442
    const-string v2, "clientId"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 443
    const-string v2, "last_name"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    .line 444
    const-string v2, "email"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v28

    .line 445
    const-string v2, "first_name"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 446
    const/4 v2, 0x0

    .line 447
    if-eqz v3, :cond_13

    .line 448
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v11, v2

    .line 450
    :goto_1
    const-string v2, "display_name"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 451
    const/4 v2, 0x0

    .line 452
    if-eqz v3, :cond_12

    .line 453
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v10, v2

    .line 455
    :goto_2
    const-string v2, "photoUrl"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 456
    const/4 v2, 0x0

    .line 457
    if-eqz v3, :cond_11

    .line 458
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v9, v2

    .line 460
    :goto_3
    const-string v2, "thumbnailUrl"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 461
    const/4 v2, 0x0

    .line 462
    if-eqz v3, :cond_10

    .line 463
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v8, v2

    .line 465
    :goto_4
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v29

    .line 466
    const/4 v2, 0x0

    .line 467
    if-eqz v29, :cond_f

    invoke-interface/range {v29 .. v29}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_f

    .line 468
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 469
    invoke-interface/range {v29 .. v29}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_5
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 470
    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 471
    if-eqz v5, :cond_0

    .line 473
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v6

    invoke-virtual {v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v6

    .line 472
    invoke-static {v5, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 474
    invoke-interface {v3, v2, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_5

    .line 427
    :catchall_0
    move-exception v2

    monitor-exit v13

    throw v2

    :cond_1
    move-object v7, v3

    .line 478
    :goto_6
    :try_start_1
    const-string v2, "clientSecret"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 479
    const/4 v2, 0x0

    .line 480
    if-eqz v3, :cond_e

    .line 481
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v6, v2

    .line 483
    :goto_7
    const-string v2, "communityId"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 484
    const/4 v2, 0x0

    .line 485
    if-eqz v3, :cond_d

    .line 486
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v5, v2

    .line 488
    :goto_8
    const-string v2, "communityUrl"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 489
    const/4 v2, 0x0

    .line 490
    if-eqz v3, :cond_c

    .line 491
    move-object/from16 v0, p0

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v4, v2

    .line 495
    :goto_9
    const-string v2, "authtoken"

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 496
    move-object/from16 v0, v19

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2}, Landroid/accounts/AccountManager;->setPassword(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 497
    const-string v2, "loginUrl"

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 498
    const-string v2, "id"

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 499
    const-string v2, "instanceUrl"

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 500
    const-string v2, "orgId"

    move-object/from16 v0, v23

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    const-string v2, "userId"

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    const-string v2, "username"

    move-object/from16 v0, v25

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    const-string v2, "clientId"

    move-object/from16 v0, v26

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 504
    const-string v2, "last_name"

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 505
    const-string v2, "email"

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 506
    if-eqz v11, :cond_2

    .line 507
    const-string v2, "first_name"

    move-object/from16 v0, p1

    invoke-static {v11, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 509
    :cond_2
    if-eqz v10, :cond_3

    .line 510
    const-string v2, "display_name"

    move-object/from16 v0, p1

    invoke-static {v10, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 512
    :cond_3
    if-eqz v9, :cond_4

    .line 513
    const-string v2, "photoUrl"

    move-object/from16 v0, p1

    invoke-static {v9, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 515
    :cond_4
    if-eqz v8, :cond_5

    .line 516
    const-string v2, "thumbnailUrl"

    move-object/from16 v0, p1

    invoke-static {v8, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 518
    :cond_5
    if-eqz v7, :cond_7

    invoke-interface {v7}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_7

    .line 519
    invoke-interface/range {v29 .. v29}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_6
    :goto_a
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 520
    invoke-interface {v7, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 521
    if-eqz v3, :cond_6

    .line 522
    move-object/from16 v0, p1

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_a

    .line 526
    :cond_7
    if-eqz v6, :cond_8

    .line 527
    const-string v2, "clientSecret"

    move-object/from16 v0, p1

    invoke-static {v6, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 529
    :cond_8
    if-eqz v5, :cond_9

    .line 530
    const-string v2, "communityId"

    move-object/from16 v0, p1

    invoke-static {v5, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 532
    :cond_9
    if-eqz v4, :cond_a

    .line 533
    const-string v2, "communityUrl"

    move-object/from16 v0, p1

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v14, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 431
    :cond_a
    add-int/lit8 v2, v12, 0x1

    move v12, v2

    goto/16 :goto_0

    .line 538
    :cond_b
    monitor-exit v13

    return-void

    :cond_c
    move-object v4, v2

    goto/16 :goto_9

    :cond_d
    move-object v5, v2

    goto/16 :goto_8

    :cond_e
    move-object v6, v2

    goto/16 :goto_7

    :cond_f
    move-object v7, v2

    goto/16 :goto_6

    :cond_10
    move-object v8, v2

    goto/16 :goto_4

    :cond_11
    move-object v9, v2

    goto/16 :goto_3

    :cond_12
    move-object v10, v2

    goto/16 :goto_2

    :cond_13
    move-object v11, v2

    goto/16 :goto_1
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/rest/ClientManager;)Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->d:Z

    return v0
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/os/Bundle;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/os/Bundle;"
        }
    .end annotation

    .prologue
    .line 356
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 357
    const-string v2, "authAccount"

    invoke-virtual {v4, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    const-string v2, "accountType"

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 359
    const-string v2, "username"

    move-object/from16 v0, p11

    invoke-static {p2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    const-string v2, "loginUrl"

    move-object/from16 v0, p11

    invoke-static {p6, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 361
    const-string v2, "id"

    move-object/from16 v0, p11

    invoke-static {p7, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 362
    const-string v2, "instanceUrl"

    move-object/from16 v0, p11

    invoke-static {p5, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 363
    const-string v2, "clientId"

    move-object/from16 v0, p8

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    const-string v2, "orgId"

    move-object/from16 v0, p9

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 365
    const-string v2, "userId"

    invoke-static/range {p10 .. p11}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 366
    if-eqz p12, :cond_0

    .line 367
    const-string v2, "clientSecret"

    move-object/from16 v0, p12

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    :cond_0
    if-eqz p13, :cond_1

    .line 370
    const-string v2, "communityId"

    move-object/from16 v0, p13

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    :cond_1
    if-eqz p14, :cond_2

    .line 373
    const-string v2, "communityUrl"

    move-object/from16 v0, p14

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    :cond_2
    const-string v2, "authtoken"

    move-object/from16 v0, p11

    invoke-static {p4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 376
    const-string v2, "first_name"

    move-object/from16 v0, p15

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 377
    const-string v2, "last_name"

    move-object/from16 v0, p16

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 378
    const-string v2, "display_name"

    move-object/from16 v0, p17

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    const-string v2, "email"

    move-object/from16 v0, p18

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    const-string v2, "photoUrl"

    move-object/from16 v0, p19

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    const-string v2, "thumbnailUrl"

    move-object/from16 v0, p20

    move-object/from16 v1, p11

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v2

    .line 383
    if-eqz p21, :cond_4

    invoke-interface/range {p21 .. p21}, Ljava/util/Map;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 384
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_3
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 385
    move-object/from16 v0, p21

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 386
    if-eqz v3, :cond_3

    .line 387
    move-object/from16 v0, p11

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 388
    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 392
    :cond_4
    new-instance v3, Landroid/accounts/Account;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->d()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, p1, v2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 393
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    move-object/from16 v0, p11

    invoke-static {p3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v2, v3, v5, v6}, Landroid/accounts/AccountManager;->addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z

    .line 397
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "authtoken"

    move-object/from16 v0, p11

    invoke-static {p4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v3, v5, v6}, Landroid/accounts/AccountManager;->setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    invoke-virtual {v4}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 404
    iget-object v6, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    invoke-virtual {v4, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v3, v2, v7}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 406
    :cond_5
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v2

    move-object/from16 v0, p10

    move-object/from16 v1, p9

    invoke-virtual {v2, v0, v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    return-object v4
.end method

.method public a()Lcom/salesforce/androidsdk/rest/RestClient;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 136
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestClient;

    new-instance v1, Lcom/salesforce/androidsdk/rest/RestClient$UnauthenticatedClientInfo;

    invoke-direct {v1}, Lcom/salesforce/androidsdk/rest/RestClient$UnauthenticatedClientInfo;-><init>()V

    sget-object v2, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    invoke-direct {v0, v1, v3, v2, v3}, Lcom/salesforce/androidsdk/rest/RestClient;-><init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/auth/HttpAccess;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V

    return-object v0
.end method

.method public a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;
    .locals 26

    .prologue
    .line 155
    if-nez p1, :cond_0

    .line 156
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "No user account found"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    .line 157
    const-string v5, "ClientManager"

    const-string v6, "No user account found"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 158
    throw v4

    .line 160
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->D()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 161
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "User is logging out"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    .line 162
    const-string v5, "ClientManager"

    const-string v6, "User is logging out"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 163
    throw v4

    .line 165
    :cond_1
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->C()Z

    move-result v4

    if-eqz v4, :cond_7

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->c:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-static {v4}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;)Ljava/lang/String;

    move-result-object v4

    move-object v6, v4

    .line 166
    :goto_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "authtoken"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 167
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 170
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "loginUrl"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 171
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "id"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 172
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "instanceUrl"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 173
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "orgId"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 174
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "userId"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 175
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "username"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 176
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "authAccount"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 177
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v5, "clientId"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 178
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "last_name"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 179
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "email"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 180
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "first_name"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 181
    const/4 v15, 0x0

    .line 182
    if-eqz v4, :cond_2

    .line 183
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 185
    :cond_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "display_name"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 186
    const/16 v17, 0x0

    .line 187
    if-eqz v4, :cond_3

    .line 188
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 190
    :cond_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "photoUrl"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 191
    const/16 v19, 0x0

    .line 192
    if-eqz v4, :cond_4

    .line 193
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 195
    :cond_4
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "thumbnailUrl"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 196
    const/16 v20, 0x0

    .line 197
    if-eqz v4, :cond_5

    .line 198
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 200
    :cond_5
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v4

    .line 201
    const/16 v21, 0x0

    .line 202
    if-eqz v4, :cond_8

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_8

    .line 203
    new-instance v21, Ljava/util/HashMap;

    invoke-direct/range {v21 .. v21}, Ljava/util/HashMap;-><init>()V

    .line 204
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_6
    :goto_1
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 205
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v4}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 206
    if-eqz v14, :cond_6

    .line 208
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v25

    .line 207
    move-object/from16 v0, v25

    invoke-static {v14, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 209
    move-object/from16 v0, v21

    invoke-interface {v0, v4, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 165
    :cond_7
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v4

    move-object v6, v4

    goto/16 :goto_0

    .line 213
    :cond_8
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v13, "communityId"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 214
    const/4 v13, 0x0

    .line 215
    if-eqz v4, :cond_9

    .line 216
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 218
    :cond_9
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const-string v14, "communityUrl"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v14}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 219
    const/4 v14, 0x0

    .line 220
    if-eqz v4, :cond_a

    .line 221
    invoke-static {v4, v6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 223
    :cond_a
    if-nez v22, :cond_b

    .line 224
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "authtoken"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 226
    :cond_b
    if-nez v24, :cond_c

    .line 227
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "instanceUrl"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 229
    :cond_c
    if-nez v11, :cond_d

    .line 230
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "userId"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 232
    :cond_d
    if-nez v12, :cond_e

    .line 233
    new-instance v4, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v5, "orgId"

    invoke-direct {v4, v5}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 236
    :cond_e
    :try_start_0
    new-instance v25, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v24

    move-object/from16 v3, v22

    invoke-direct {v0, v1, v2, v3, v7}, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;-><init>(Lcom/salesforce/androidsdk/rest/ClientManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    new-instance v4, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    new-instance v6, Ljava/net/URI;

    move-object/from16 v0, v24

    invoke-direct {v6, v0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    new-instance v7, Ljava/net/URI;

    invoke-direct {v7, v8}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    new-instance v8, Ljava/net/URI;

    move-object/from16 v0, v23

    invoke-direct {v8, v0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-direct/range {v4 .. v21}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;-><init>(Ljava/lang/String;Ljava/net/URI;Ljava/net/URI;Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 242
    new-instance v5, Lcom/salesforce/androidsdk/rest/RestClient;

    sget-object v6, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-direct {v5, v4, v0, v6, v1}, Lcom/salesforce/androidsdk/rest/RestClient;-><init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/auth/HttpAccess;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v5

    .line 243
    :catch_0
    move-exception v4

    .line 244
    const-string v5, "ClientManager"

    const-string v6, "Invalid server URL"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 245
    new-instance v5, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;

    const-string v6, "invalid server url"

    invoke-direct {v5, v6, v4}, Lcom/salesforce/androidsdk/rest/ClientManager$AccountInfoNotFoundException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;
    .locals 1

    .prologue
    .line 151
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->i()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->b(Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 556
    if-eqz p1, :cond_0

    .line 557
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Landroid/accounts/AccountManager;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 559
    :cond_0
    return-void
.end method

.method public a(Landroid/app/Activity;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 102
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->c()Landroid/accounts/Account;

    move-result-object v0

    .line 105
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->c:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->i()Landroid/os/Bundle;

    move-result-object v4

    .line 108
    if-nez v0, :cond_0

    .line 109
    const-string v0, "ClientManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "No account of type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " found"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->d()Ljava/lang/String;

    move-result-object v1

    const-string v2, "authtoken"

    new-instance v6, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;

    invoke-direct {v6, p0, p2}, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;-><init>(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V

    move-object v5, p1

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/accounts/AccountManager;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 120
    :goto_0
    return-void

    .line 116
    :cond_0
    const-string v0, "ClientManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Found account of type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->b()Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    .line 118
    invoke-interface {p2, v0}, Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;->a(Lcom/salesforce/androidsdk/rest/RestClient;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 253
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/accounts/AccountManager;->invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    return-void
.end method

.method public a([Landroid/accounts/Account;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 294
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 295
    array-length v2, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, p1, v0

    .line 296
    iget-object v4, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    invoke-virtual {v4, v3, v5, v5}, Landroid/accounts/AccountManager;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 295
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 298
    :cond_0
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/AccountManagerFuture;

    .line 300
    :try_start_0
    invoke-interface {v0}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 301
    :catch_0
    move-exception v0

    .line 302
    const-string v2, "ClientManager"

    const-string v3, "Exception removing old account"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 305
    :cond_1
    return-void
.end method

.method public b(Ljava/lang/String;)Landroid/accounts/Account;
    .locals 5

    .prologue
    .line 270
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->a:Landroid/accounts/AccountManager;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v2

    .line 271
    if-eqz v2, :cond_1

    .line 272
    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 273
    iget-object v4, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 278
    :goto_1
    return-object v0

    .line 272
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 278
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public b()Lcom/salesforce/androidsdk/rest/RestClient;
    .locals 1

    .prologue
    .line 140
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/ClientManager;->c()Landroid/accounts/Account;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    return-object v0
.end method

.method public c()Landroid/accounts/Account;
    .locals 1

    .prologue
    .line 262
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c()Landroid/accounts/Account;

    move-result-object v0

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager;->b:Ljava/lang/String;

    return-object v0
.end method
