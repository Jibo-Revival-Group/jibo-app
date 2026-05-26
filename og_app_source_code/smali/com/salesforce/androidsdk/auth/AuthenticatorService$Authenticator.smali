.class Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;
.super Landroid/accounts/AbstractAccountAuthenticator;
.source "AuthenticatorService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/auth/AuthenticatorService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Authenticator"
.end annotation


# instance fields
.field private final a:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 100
    invoke-direct {p0, p1}, Landroid/accounts/AbstractAccountAuthenticator;-><init>(Landroid/content/Context;)V

    .line 101
    iput-object p1, p0, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a:Landroid/content/Context;

    .line 102
    return-void
.end method

.method private a(Landroid/accounts/AccountAuthenticatorResponse;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 4

    .prologue
    .line 285
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 286
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a:Landroid/content/Context;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f()Ljava/lang/Class;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 287
    iget-object v2, p0, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 288
    const/high16 v2, 0x20000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 289
    const-string v2, "accountAuthenticatorResponse"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 290
    if-eqz p2, :cond_0

    .line 291
    invoke-virtual {v1, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 293
    :cond_0
    const-string v2, "intent"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 294
    return-object v0
.end method

.method private a(Landroid/os/Bundle;)Z
    .locals 2

    .prologue
    .line 118
    const-string v0, "androidPackageName"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "com.android.settings"

    const-string v1, "androidPackageName"

    .line 119
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 118
    :goto_0
    return v0

    .line 119
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addAccount(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    .line 111
    invoke-direct {p0, p5}, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a(Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->i()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p5, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 114
    :cond_0
    invoke-direct {p0, p1, p5}, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a(Landroid/accounts/AccountAuthenticatorResponse;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public confirmCredentials(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    .line 306
    const/4 v0, 0x0

    return-object v0
.end method

.method public editProperties(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 311
    const/4 v0, 0x0

    return-object v0
.end method

.method public getAuthToken(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 27
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    .line 125
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a:Landroid/content/Context;

    invoke-static {v3}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v17

    .line 126
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v18

    .line 127
    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 128
    const-string v3, "loginUrl"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 129
    const-string v3, "clientId"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 130
    const-string v3, "instanceUrl"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 131
    const-string v3, "userId"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 132
    const-string v3, "orgId"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 133
    const-string v3, "username"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 134
    const-string v3, "last_name"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 135
    const-string v3, "email"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 136
    const-string v3, "first_name"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 137
    const/4 v3, 0x0

    .line 138
    if-eqz v4, :cond_15

    .line 139
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v9, v3

    .line 141
    :goto_0
    const-string v3, "display_name"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 142
    const/4 v3, 0x0

    .line 143
    if-eqz v4, :cond_14

    .line 144
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v10, v3

    .line 146
    :goto_1
    const-string v3, "photoUrl"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 147
    const/4 v3, 0x0

    .line 148
    if-eqz v4, :cond_13

    .line 149
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v11, v3

    .line 151
    :goto_2
    const-string v3, "thumbnailUrl"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 152
    const/4 v3, 0x0

    .line 153
    if-eqz v4, :cond_12

    .line 154
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v12, v3

    .line 156
    :goto_3
    const-string v3, "clientSecret"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 157
    const/4 v7, 0x0

    .line 158
    if-eqz v3, :cond_0

    .line 159
    move-object/from16 v0, v18

    invoke-static {v3, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 161
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v26

    .line 162
    const/4 v3, 0x0

    .line 163
    if-eqz v26, :cond_11

    invoke-interface/range {v26 .. v26}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_11

    .line 164
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 165
    invoke-interface/range {v26 .. v26}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_4
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 166
    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 167
    if-eqz v13, :cond_1

    .line 169
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v14

    invoke-virtual {v14}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v14

    .line 168
    invoke-static {v13, v14}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 170
    invoke-interface {v4, v3, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    :cond_2
    move-object v13, v4

    .line 174
    :goto_5
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h()Ljava/util/Map;

    move-result-object v8

    .line 175
    const-string v3, "communityId"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 176
    const/4 v3, 0x0

    .line 177
    if-eqz v4, :cond_10

    .line 179
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v3

    .line 178
    invoke-static {v4, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v14, v3

    .line 181
    :goto_6
    const-string v3, "communityUrl"

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 182
    const/4 v3, 0x0

    .line 183
    if-eqz v4, :cond_f

    .line 185
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v3

    .line 184
    invoke-static {v4, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v15, v3

    .line 187
    :goto_7
    new-instance v16, Landroid/os/Bundle;

    invoke-direct/range {v16 .. v16}, Landroid/os/Bundle;-><init>()V

    .line 189
    :try_start_0
    sget-object v3, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    new-instance v4, Ljava/net/URI;

    move-object/from16 v0, v19

    invoke-direct {v4, v0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-static/range {v3 .. v8}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Lcom/salesforce/androidsdk/auth/HttpAccess;Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    move-result-object v6

    .line 193
    iget-object v3, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 194
    const-string v3, "instanceUrl"

    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    :cond_3
    const-string v3, "authtoken"

    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    const-string v3, "authAccount"

    move-object/from16 v0, p2

    iget-object v4, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    const-string v3, "accountType"

    move-object/from16 v0, p2

    iget-object v4, v0, Landroid/accounts/Account;->type:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v3, "authtoken"

    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const-string v3, "loginUrl"

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    const-string v3, "instanceUrl"

    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    const-string v3, "clientId"

    move-object/from16 v0, v18

    invoke-static {v5, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    const-string v3, "username"

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    const-string v3, "userId"

    move-object/from16 v0, v21

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    const-string v3, "orgId"

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    const-string v3, "last_name"

    move-object/from16 v0, v24

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    const-string v3, "email"

    move-object/from16 v0, v25

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    const/4 v3, 0x0

    .line 211
    if-eqz v9, :cond_4

    .line 212
    move-object/from16 v0, v18

    invoke-static {v9, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 214
    :cond_4
    const-string v4, "first_name"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    const/4 v3, 0x0

    .line 216
    if-eqz v10, :cond_5

    .line 217
    move-object/from16 v0, v18

    invoke-static {v10, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 219
    :cond_5
    const-string v4, "display_name"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    const/4 v3, 0x0

    .line 221
    if-eqz v11, :cond_6

    .line 222
    move-object/from16 v0, v18

    invoke-static {v11, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 224
    :cond_6
    const-string v4, "photoUrl"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    const/4 v3, 0x0

    .line 226
    if-eqz v12, :cond_e

    .line 227
    move-object/from16 v0, v18

    invoke-static {v12, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v5, v3

    .line 235
    :goto_8
    if-eqz v26, :cond_9

    invoke-interface/range {v26 .. v26}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_9

    .line 236
    invoke-interface/range {v26 .. v26}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_7
    :goto_9
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_9

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 237
    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    if-eqz v4, :cond_8

    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 238
    iget-object v4, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 239
    if-eqz v4, :cond_7

    .line 240
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 241
    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_9

    .line 269
    :catch_0
    move-exception v3

    .line 270
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 271
    const-string v4, "AuthenticatorService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid Refresh Token: (Error: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, v3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    iget-object v6, v6, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->a:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", Status Code: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, v3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v3}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 273
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p4

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->a(Landroid/accounts/AccountAuthenticatorResponse;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 281
    :goto_a
    return-object v3

    .line 244
    :cond_8
    if-eqz v13, :cond_7

    :try_start_1
    invoke-interface {v13, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 245
    invoke-interface {v13, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 246
    if-eqz v4, :cond_7

    .line 247
    move-object/from16 v0, v18

    invoke-static {v4, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 248
    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_9

    .line 277
    :catch_1
    move-exception v3

    .line 278
    const-string v4, "AuthenticatorService"

    const-string v5, "Exception thrown while getting new auth token"

    invoke-static {v4, v5, v3}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 279
    new-instance v4, Landroid/accounts/NetworkErrorException;

    invoke-direct {v4, v3}, Landroid/accounts/NetworkErrorException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 253
    :cond_9
    :try_start_2
    const-string v3, "thumbnailUrl"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    const/4 v3, 0x0

    .line 255
    if-eqz v7, :cond_a

    .line 256
    move-object/from16 v0, v18

    invoke-static {v7, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 258
    :cond_a
    const-string v4, "clientSecret"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    const/4 v3, 0x0

    .line 260
    if-eqz v14, :cond_b

    .line 261
    move-object/from16 v0, v18

    invoke-static {v14, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 263
    :cond_b
    const-string v4, "communityId"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    const/4 v3, 0x0

    .line 265
    if-eqz v15, :cond_c

    .line 266
    move-object/from16 v0, v18

    invoke-static {v15, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 268
    :cond_c
    const-string v4, "communityUrl"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :goto_b
    move-object/from16 v3, v16

    .line 281
    goto :goto_a

    .line 275
    :cond_d
    const-string v4, "errorCode"

    iget-object v5, v3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    iget-object v5, v5, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->a:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 276
    const-string v4, "errorMessage"

    iget-object v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    iget-object v3, v3, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->b:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_b

    :cond_e
    move-object v5, v3

    goto/16 :goto_8

    :cond_f
    move-object v15, v3

    goto/16 :goto_7

    :cond_10
    move-object v14, v3

    goto/16 :goto_6

    :cond_11
    move-object v13, v3

    goto/16 :goto_5

    :cond_12
    move-object v12, v3

    goto/16 :goto_3

    :cond_13
    move-object v11, v3

    goto/16 :goto_2

    :cond_14
    move-object v10, v3

    goto/16 :goto_1

    :cond_15
    move-object v9, v3

    goto/16 :goto_0
.end method

.method public getAuthTokenLabel(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 316
    const/4 v0, 0x0

    return-object v0
.end method

.method public hasFeatures(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;[Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    .line 322
    const/4 v0, 0x0

    return-object v0
.end method

.method public updateCredentials(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/NetworkErrorException;
        }
    .end annotation

    .prologue
    .line 300
    const/4 v0, 0x0

    return-object v0
.end method
