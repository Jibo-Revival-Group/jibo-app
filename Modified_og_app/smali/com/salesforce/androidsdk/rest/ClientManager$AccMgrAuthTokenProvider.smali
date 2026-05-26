.class public Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;
.super Ljava/lang/Object;
.source "ClientManager.java"

# interfaces
.implements Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/rest/ClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccMgrAuthTokenProvider"
.end annotation


# instance fields
.field private a:Z

.field private final b:Ljava/lang/Object;

.field private final c:Lcom/salesforce/androidsdk/rest/ClientManager;

.field private d:Ljava/lang/String;

.field private final e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:J


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/rest/ClientManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 624
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 611
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    .line 616
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->g:J

    .line 625
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->c:Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 626
    iput-object p4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->e:Ljava/lang/String;

    .line 627
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->d:Ljava/lang/String;

    .line 628
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    .line 629
    return-void
.end method

.method private a(Landroid/accounts/Account;)Landroid/os/Bundle;
    .locals 14
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 729
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v8

    .line 730
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 731
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v9

    .line 732
    invoke-static {v9}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v10

    .line 733
    invoke-virtual {v10, p1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 734
    const-string v1, "loginUrl"

    invoke-virtual {v10, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 736
    const-string v1, "clientId"

    invoke-virtual {v10, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 738
    const-string v1, "instanceUrl"

    invoke-virtual {v10, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 740
    const-string v1, "clientSecret"

    invoke-virtual {v10, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 742
    if-eqz v1, :cond_8

    .line 743
    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 745
    :goto_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v13

    .line 747
    if-eqz v13, :cond_7

    invoke-interface {v13}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    .line 748
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 749
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 750
    invoke-virtual {v10, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 751
    if-eqz v6, :cond_0

    .line 752
    invoke-static {v6, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 753
    invoke-interface {v1, v0, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_1
    move-object v6, v1

    .line 757
    :goto_2
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h()Ljava/util/Map;

    move-result-object v5

    .line 759
    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    new-instance v1, Ljava/net/URI;

    invoke-direct {v1, v11}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-static/range {v0 .. v5}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Lcom/salesforce/androidsdk/auth/HttpAccess;Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    move-result-object v2

    .line 761
    iget-object v0, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 762
    const-string v0, "instanceUrl"

    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    .line 763
    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 762
    invoke-virtual {v10, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 765
    :cond_2
    const-string v0, "authtoken"

    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 766
    const-string v0, "authtoken"

    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 767
    const-string v0, "instanceUrl"

    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 768
    if-eqz v13, :cond_6

    invoke-interface {v13}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_6

    .line 769
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 770
    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    if-eqz v1, :cond_4

    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 771
    iget-object v1, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 772
    if-eqz v1, :cond_3

    .line 773
    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 774
    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 775
    invoke-virtual {v10, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_3

    .line 786
    :catch_0
    move-exception v0

    .line 787
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 788
    const-string v1, "ClientManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid Refresh Token: (Error: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 789
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b()Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    move-result-object v3

    iget-object v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", Status Code: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 790
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->c()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 788
    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 791
    invoke-direct {p0, v9}, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v0

    .line 799
    :goto_4
    return-object v0

    .line 777
    :cond_4
    if-eqz v6, :cond_3

    :try_start_1
    invoke-interface {v6, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 778
    invoke-interface {v6, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 779
    if-eqz v1, :cond_3

    .line 780
    invoke-static {v1, v8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 781
    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_3

    .line 795
    :catch_1
    move-exception v0

    .line 796
    const-string v1, "ClientManager"

    const-string v2, "Exception thrown while getting new auth token"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 797
    new-instance v1, Landroid/accounts/NetworkErrorException;

    invoke-direct {v1, v0}, Landroid/accounts/NetworkErrorException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 793
    :cond_5
    const-string v1, "errorCode"

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b()Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    move-result-object v2

    iget-object v2, v2, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->a:Ljava/lang/String;

    invoke-virtual {v7, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 794
    const-string v1, "errorMessage"

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b()Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    move-result-object v0

    iget-object v0, v0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->b:Ljava/lang/String;

    invoke-virtual {v7, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_6
    move-object v0, v7

    .line 799
    goto :goto_4

    :cond_7
    move-object v6, v0

    goto/16 :goto_2

    :cond_8
    move-object v4, v0

    goto/16 :goto_0
.end method

.method private a(Landroid/content/Context;)Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 803
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 804
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f()Ljava/lang/Class;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 805
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 806
    const/high16 v2, 0x20000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 807
    const-string v2, "intent"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 808
    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v0, 0x0

    .line 638
    const-string v1, "ClientManager"

    const-string v2, "Need new access token"

    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->c:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->c()Landroid/accounts/Account;

    move-result-object v1

    .line 640
    if-nez v1, :cond_0

    .line 712
    :goto_0
    return-object v0

    .line 645
    :cond_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    monitor-enter v2

    .line 646
    :try_start_0
    iget-boolean v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_1

    .line 648
    :try_start_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 652
    :goto_1
    :try_start_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->d:Ljava/lang/String;

    monitor-exit v2

    goto :goto_0

    .line 655
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 649
    :catch_0
    move-exception v0

    .line 650
    :try_start_3
    const-string v1, "ClientManager"

    const-string v3, "Exception thrown while getting new auth token"

    invoke-static {v1, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 654
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a:Z

    .line 655
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 658
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->c:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {v2, v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestClient;->a()Ljava/lang/String;

    move-result-object v2

    .line 659
    iget-object v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->c:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {v3, v2}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Ljava/lang/String;)V

    .line 663
    :try_start_4
    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a(Landroid/accounts/Account;)Landroid/os/Bundle;

    move-result-object v2

    .line 664
    if-nez v2, :cond_2

    .line 665
    const-string v1, "ClientManager"

    const-string v2, "Bundle was null while getting auth token"

    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_5

    move-object v1, v0

    .line 704
    :goto_2
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    monitor-enter v2

    .line 705
    const/4 v3, 0x0

    :try_start_5
    iput-boolean v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a:Z

    .line 706
    iput-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->d:Ljava/lang/String;

    .line 707
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    .line 708
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->g:J

    .line 709
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 710
    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    :goto_3
    move-object v0, v1

    .line 712
    goto :goto_0

    .line 667
    :cond_2
    :try_start_6
    const-string v1, "authtoken"

    invoke-virtual {v2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 668
    if-eqz v1, :cond_8

    .line 669
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    move-result-object v1

    .line 671
    :goto_4
    :try_start_7
    const-string v3, "instanceUrl"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 672
    if-eqz v2, :cond_3

    .line 673
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3
    .catchall {:try_start_7 .. :try_end_7} :catchall_6

    move-result-object v0

    .line 676
    :cond_3
    if-nez v1, :cond_6

    .line 677
    :try_start_8
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->c:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-static {v2}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Lcom/salesforce/androidsdk/rest/ClientManager;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 680
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v2

    if-nez v2, :cond_4

    .line 681
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 683
    :cond_4
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;Z)V

    .line 687
    :cond_5
    new-instance v2, Landroid/content/Intent;

    const-string v3, "access_token_revoked"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 698
    :goto_5
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 699
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_1
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    goto :goto_2

    .line 701
    :catch_1
    move-exception v2

    move-object v7, v2

    move-object v2, v0

    move-object v0, v7

    .line 702
    :goto_6
    :try_start_9
    const-string v3, "ClientManager"

    const-string v4, "Exception thrown while getting auth token"

    invoke-static {v3, v4, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_7

    .line 704
    iget-object v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    monitor-enter v3

    .line 705
    const/4 v0, 0x0

    :try_start_a
    iput-boolean v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a:Z

    .line 706
    iput-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->d:Ljava/lang/String;

    .line 707
    iput-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    .line 708
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->g:J

    .line 709
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 710
    monitor-exit v3

    goto/16 :goto_3

    :catchall_1
    move-exception v0

    monitor-exit v3
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    throw v0

    .line 688
    :cond_6
    if-eqz v0, :cond_7

    :try_start_b
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_7

    .line 691
    new-instance v2, Landroid/content/Intent;

    const-string v3, "instance_url_updated"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    goto :goto_5

    .line 704
    :catchall_2
    move-exception v2

    move-object v7, v2

    move-object v2, v0

    move-object v0, v7

    :goto_7
    iget-object v3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    monitor-enter v3

    .line 705
    const/4 v4, 0x0

    :try_start_c
    iput-boolean v4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->a:Z

    .line 706
    iput-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->d:Ljava/lang/String;

    .line 707
    iput-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    .line 708
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->g:J

    .line 709
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->b:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 710
    monitor-exit v3
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_4

    throw v0

    .line 695
    :cond_7
    :try_start_d
    new-instance v2, Landroid/content/Intent;

    const-string v3, "access_token_refeshed"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 696
    const-string v3, "tokenRefresh"

    const/4 v4, 0x0

    const-string v5, "ClientManager"

    const/4 v6, 0x0

    invoke-static {v3, v4, v5, v6}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_1
    .catchall {:try_start_d .. :try_end_d} :catchall_2

    goto :goto_5

    .line 710
    :catchall_3
    move-exception v0

    :try_start_e
    monitor-exit v2
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_3

    throw v0

    :catchall_4
    move-exception v0

    :try_start_f
    monitor-exit v3
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_4

    throw v0

    .line 704
    :catchall_5
    move-exception v1

    move-object v2, v0

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_7

    :catchall_6
    move-exception v2

    move-object v7, v2

    move-object v2, v0

    move-object v0, v7

    goto :goto_7

    :catchall_7
    move-exception v0

    goto :goto_7

    .line 701
    :catch_2
    move-exception v1

    move-object v2, v0

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_6

    :catch_3
    move-exception v2

    move-object v7, v2

    move-object v2, v0

    move-object v0, v7

    goto :goto_6

    :cond_8
    move-object v1, v0

    goto/16 :goto_4
.end method

.method public b()J
    .locals 2

    .prologue
    .line 722
    iget-wide v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->g:J

    return-wide v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 726
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrAuthTokenProvider;->f:Ljava/lang/String;

    return-object v0
.end method
