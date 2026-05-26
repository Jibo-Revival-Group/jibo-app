.class public Lcom/salesforce/androidsdk/accounts/UserAccountManager;
.super Ljava/lang/Object;
.source "UserAccountManager.java"


# static fields
.field private static a:Lcom/salesforce/androidsdk/accounts/UserAccountManager;


# instance fields
.field private b:Landroid/content/Context;

.field private c:Landroid/accounts/AccountManager;

.field private d:Ljava/lang/String;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 134
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    .line 135
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    .line 136
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public static a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;
    .locals 1

    .prologue
    .line 124
    sget-object v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    if-nez v0, :cond_0

    .line 125
    new-instance v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    .line 127
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a:Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    return-object v0
.end method

.method private a(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 336
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 337
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f()Ljava/lang/Class;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 338
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 339
    invoke-virtual {v1, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 340
    const-string v2, "intent"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 341
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 342
    return-void
.end method


# virtual methods
.method public a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 24

    .prologue
    .line 395
    if-nez p1, :cond_0

    .line 396
    const/4 v2, 0x0

    .line 461
    :goto_0
    return-object v2

    .line 398
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v22

    .line 399
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v3, "authtoken"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 400
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 401
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v5, "loginUrl"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 402
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v6, "id"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v6}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 403
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v7, "instanceUrl"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v7}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 404
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v8, "orgId"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v8}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 405
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v9, "userId"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v9}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 406
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v10, "username"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v10}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 407
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v11, "authAccount"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v11}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 408
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v12, "clientId"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v12}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 409
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "last_name"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 410
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "email"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 411
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "first_name"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 412
    const/4 v15, 0x0

    .line 413
    if-eqz v2, :cond_1

    .line 414
    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 416
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "display_name"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 417
    const/16 v17, 0x0

    .line 418
    if-eqz v2, :cond_2

    .line 419
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "display_name"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 421
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "photoUrl"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 422
    const/16 v19, 0x0

    .line 423
    if-eqz v2, :cond_3

    .line 424
    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 426
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "thumbnailUrl"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 427
    const/16 v20, 0x0

    .line 428
    if-eqz v2, :cond_4

    .line 429
    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 431
    :cond_4
    const/16 v21, 0x0

    .line 432
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v2

    .line 433
    if-eqz v2, :cond_7

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_7

    .line 434
    new-instance v21, Ljava/util/HashMap;

    invoke-direct/range {v21 .. v21}, Ljava/util/HashMap;-><init>()V

    .line 435
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_5
    :goto_1
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 436
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v13

    if-nez v13, :cond_5

    .line 437
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    move-object/from16 v0, p1

    invoke-virtual {v13, v0, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 438
    const/4 v13, 0x0

    .line 439
    if-eqz v23, :cond_6

    .line 440
    move-object/from16 v0, v23

    move-object/from16 v1, v22

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 442
    :cond_6
    move-object/from16 v0, v21

    invoke-interface {v0, v2, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 446
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v13, "communityId"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v13}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 447
    const/4 v13, 0x0

    .line 448
    if-eqz v2, :cond_8

    .line 449
    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 452
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v14, "communityUrl"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v14}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 453
    const/4 v14, 0x0

    .line 454
    if-eqz v2, :cond_9

    .line 455
    move-object/from16 v0, v22

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 458
    :cond_9
    if-eqz v3, :cond_a

    if-eqz v7, :cond_a

    if-eqz v9, :cond_a

    if-nez v8, :cond_b

    .line 459
    :cond_a
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 461
    :cond_b
    new-instance v2, Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct/range {v2 .. v21}, Lcom/salesforce/androidsdk/accounts/UserAccount;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0
.end method

.method public final a(ILandroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 520
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.USERSWITCHED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 521
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 522
    const-string v1, "com.salesforce.USER_SWITCH_TYPE"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 523
    if-eqz p2, :cond_0

    .line 524
    invoke-virtual {v0, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 526
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 527
    return-void
.end method

.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 350
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;)V

    .line 351
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;ILandroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 289
    if-eqz p1, :cond_0

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 290
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->e()V

    .line 308
    :cond_1
    :goto_0
    return-void

    .line 293
    :cond_2
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 299
    invoke-virtual {p1, v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 302
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d:Ljava/lang/String;

    .line 303
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v3

    const/4 v4, 0x1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    .line 304
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->b(Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v1

    .line 305
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 306
    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;

    .line 307
    invoke-virtual {p0, p2, p3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(ILandroid/os/Bundle;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 371
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Landroid/accounts/Account;

    move-result-object v0

    .line 372
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1, v0, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 373
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/app/Activity;Z)V
    .locals 2

    .prologue
    .line 384
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Landroid/accounts/Account;

    move-result-object v0

    .line 385
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1, v0, p2, p3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/accounts/Account;Landroid/app/Activity;Z)V

    .line 386
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    const-string v1, "current_user_info"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 148
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 149
    const-string v1, "user_id"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 150
    const-string v1, "org_id"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 151
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 152
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 249
    if-nez p1, :cond_0

    move v0, v1

    .line 261
    :goto_0
    return v0

    .line 252
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v0

    .line 253
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_2

    :cond_1
    move v0, v1

    .line 254
    goto :goto_0

    .line 256
    :cond_2
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 257
    invoke-virtual {p1, v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 258
    const/4 v0, 0x1

    goto :goto_0

    :cond_4
    move v0, v1

    .line 261
    goto :goto_0
.end method

.method public b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Landroid/accounts/Account;
    .locals 11

    .prologue
    const/4 v2, 0x0

    .line 474
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v5

    .line 475
    if-nez p1, :cond_0

    move-object v0, v2

    .line 500
    :goto_0
    return-object v0

    .line 478
    :cond_0
    if-eqz v5, :cond_1

    array-length v0, v5

    if-nez v0, :cond_2

    :cond_1
    move-object v0, v2

    .line 479
    goto :goto_0

    .line 483
    :cond_2
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    const-string v0, ""

    .line 484
    :goto_1
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_4

    const-string v1, ""

    .line 485
    :goto_2
    array-length v6, v5

    const/4 v3, 0x0

    move v4, v3

    :goto_3
    if-ge v4, v6, :cond_6

    aget-object v3, v5, v4

    .line 486
    if-eqz v3, :cond_5

    .line 489
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v7

    .line 490
    iget-object v8, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v9, "orgId"

    invoke-virtual {v8, v3, v9}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8, v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 492
    iget-object v9, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v10, "userId"

    invoke-virtual {v9, v3, v10}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 494
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 495
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    move-object v0, v3

    .line 496
    goto :goto_0

    .line 483
    :cond_3
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 484
    :cond_4
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 485
    :cond_5
    add-int/lit8 v3, v4, 0x1

    move v4, v3

    goto :goto_3

    :cond_6
    move-object v0, v2

    .line 500
    goto :goto_0
.end method

.method public b()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c()Landroid/accounts/Account;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    return-object v0
.end method

.method public c()Landroid/accounts/Account;
    .locals 11

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 191
    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    iget-object v3, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v3

    .line 192
    if-eqz v3, :cond_0

    array-length v2, v3

    if-nez v2, :cond_2

    :cond_0
    move-object v0, v1

    .line 216
    :cond_1
    :goto_0
    return-object v0

    .line 197
    :cond_2
    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b:Landroid/content/Context;

    const-string v4, "current_user_info"

    invoke-virtual {v2, v4, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 199
    const-string v4, "user_id"

    const-string v5, ""

    invoke-interface {v2, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 200
    const-string v5, "org_id"

    const-string v6, ""

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 201
    array-length v6, v3

    move v2, v0

    :goto_1
    if-ge v2, v6, :cond_4

    aget-object v0, v3, v2

    .line 202
    if-eqz v0, :cond_3

    .line 205
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v7

    .line 206
    iget-object v8, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v9, "orgId"

    invoke-virtual {v8, v0, v9}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8, v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 208
    iget-object v9, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    const-string v10, "userId"

    invoke-virtual {v9, v0, v10}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 210
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 211
    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 201
    :cond_3
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_4
    move-object v0, v1

    .line 216
    goto :goto_0
.end method

.method public d()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 225
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->c:Landroid/accounts/AccountManager;

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v3

    .line 226
    if-eqz v3, :cond_0

    array-length v1, v3

    if-nez v1, :cond_1

    .line 239
    :cond_0
    :goto_0
    return-object v0

    .line 229
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 230
    array-length v4, v3

    const/4 v2, 0x0

    :goto_1
    if-ge v2, v4, :cond_3

    aget-object v5, v3, v2

    .line 231
    invoke-virtual {p0, v5}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v5

    .line 232
    if-eqz v5, :cond_2

    .line 233
    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 236
    :cond_3
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 239
    goto :goto_0
.end method

.method public e()V
    .locals 1

    .prologue
    .line 317
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->i()Landroid/os/Bundle;

    move-result-object v0

    .line 318
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/os/Bundle;)V

    .line 319
    return-void
.end method
