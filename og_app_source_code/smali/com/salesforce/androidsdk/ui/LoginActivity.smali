.class public Lcom/salesforce/androidsdk/ui/LoginActivity;
.super Landroid/accounts/AccountAuthenticatorActivity;
.source "LoginActivity.java"

# interfaces
.implements Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;


# instance fields
.field private a:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private b:Z

.field private c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0}, Landroid/accounts/AccountAuthenticatorActivity;-><init>()V

    return-void
.end method

.method private d()V
    .locals 1

    .prologue
    .line 333
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 334
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;

    move-result-object v0

    .line 335
    if-eqz v0, :cond_0

    .line 336
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b()V

    .line 338
    :cond_0
    return-void
.end method


# virtual methods
.method protected a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Landroid/webkit/WebView;Landroid/os/Bundle;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
    .locals 6

    .prologue
    .line 143
    new-instance v0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;-><init>(Landroid/app/Activity;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Landroid/webkit/WebView;Landroid/os/Bundle;)V

    return-object v0
.end method

.method protected a()V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 118
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    invoke-static {p0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCertAlias:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;

    move-result-object v6

    .line 120
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v3, v2

    move-object v4, v2

    invoke-static/range {v0 .. v6}, Landroid/security/KeyChain;->choosePrivateKeyAlias(Landroid/app/Activity;Landroid/security/KeyChainAliasCallback;[Ljava/lang/String;[Ljava/security/Principal;Ljava/lang/String;ILjava/lang/String;)V

    .line 124
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    goto :goto_0
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 256
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->setAccountAuthenticatorResult(Landroid/os/Bundle;)V

    .line 257
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 236
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 237
    if-eqz v0, :cond_0

    .line 238
    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 240
    :cond_0
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 250
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->setProgressBarIndeterminateVisibility(Z)V

    .line 251
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->setProgressBarIndeterminate(Z)V

    .line 252
    return-void
.end method

.method protected a(I)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 178
    const/4 v1, 0x4

    if-ne p1, v1, :cond_1

    .line 185
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    .line 186
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v1

    if-nez v1, :cond_0

    .line 187
    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->b:Z

    .line 188
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->moveTaskToBack(Z)Z

    .line 196
    :goto_0
    return v0

    .line 191
    :cond_0
    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->b:Z

    .line 192
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->finish()V

    goto :goto_0

    .line 196
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected b()V
    .locals 2

    .prologue
    .line 128
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/view/Window;->requestFeature(I)Z

    .line 129
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/view/Window;->requestFeature(I)Z

    .line 130
    return-void
.end method

.method public b(I)V
    .locals 1

    .prologue
    .line 244
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->a(Z)V

    .line 245
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->setProgress(I)V

    .line 246
    return-void
.end method

.method protected c()Z
    .locals 2

    .prologue
    .line 138
    invoke-static {p0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->RequireCertAuth:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public finish()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 311
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->d()V

    .line 312
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v3

    .line 313
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v2

    .line 314
    if-nez v2, :cond_0

    move v2, v0

    .line 317
    :goto_0
    if-ne v2, v1, :cond_1

    .line 328
    :goto_1
    const/4 v1, 0x0

    invoke-virtual {v3, v0, v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(ILandroid/os/Bundle;)V

    .line 329
    invoke-super {p0}, Landroid/accounts/AccountAuthenticatorActivity;->finish()V

    .line 330
    return-void

    .line 314
    :cond_0
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    goto :goto_0

    .line 320
    :cond_1
    if-le v2, v1, :cond_2

    move v0, v1

    .line 322
    goto :goto_1

    .line 325
    :cond_2
    const/4 v0, -0x1

    goto :goto_1
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 300
    const/16 v0, 0xa

    if-ne p1, v0, :cond_0

    if-ne p2, v1, :cond_0

    .line 301
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    .line 307
    :goto_0
    return-void

    .line 302
    :cond_0
    const/16 v0, 0x309

    if-ne p1, v0, :cond_1

    if-ne p2, v1, :cond_1

    .line 303
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->c()V

    goto :goto_0

    .line 305
    :cond_1
    invoke-super {p0, p1, p2, p3}, Landroid/accounts/AccountAuthenticatorActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onClearCookiesClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a()V

    .line 272
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    .line 273
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/16 v2, 0x2000

    const/4 v3, 0x1

    const-string v0, "com.salesforce.androidsdk.ui.LoginActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 84
    invoke-super {p0, p1}, Landroid/accounts/AccountAuthenticatorActivity;->onCreate(Landroid/os/Bundle;)V

    .line 87
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 90
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Landroid/os/Bundle;)Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v1

    .line 92
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->b()V

    .line 95
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v2, v2}, Landroid/view/Window;->setFlags(II)V

    .line 99
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->b()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->setContentView(I)V

    .line 102
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->c()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    .line 103
    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    .line 104
    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 105
    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setAllowFileAccessFromFileURLs(Z)V

    .line 106
    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V

    .line 107
    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 108
    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 109
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v2

    sget-object v3, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v2, v3, v0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 110
    invoke-virtual {p0, p0, v1, v0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Landroid/webkit/WebView;Landroid/os/Bundle;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    .line 113
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LoginActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1, p0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 114
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->a()V

    .line 115
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/LoginActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->i()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 208
    invoke-super {p0, p1}, Landroid/accounts/AccountAuthenticatorActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 165
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->a(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 166
    const/4 v0, 0x1

    .line 168
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/accounts/AccountAuthenticatorActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v0, 0x1

    .line 213
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    .line 214
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->j()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 215
    invoke-virtual {p0, v3}, Lcom/salesforce/androidsdk/ui/LoginActivity;->onClearCookiesClick(Landroid/view/View;)V

    .line 224
    :goto_0
    return v0

    .line 217
    :cond_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->k()I

    move-result v2

    if-ne v1, v2, :cond_1

    .line 218
    invoke-virtual {p0, v3}, Lcom/salesforce/androidsdk/ui/LoginActivity;->onPickServerClick(Landroid/view/View;)V

    goto :goto_0

    .line 220
    :cond_1
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->a:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->l()I

    move-result v2

    if-ne v1, v2, :cond_2

    .line 221
    invoke-virtual {p0, v3}, Lcom/salesforce/androidsdk/ui/LoginActivity;->onReloadClick(Landroid/view/View;)V

    goto :goto_0

    .line 224
    :cond_2
    invoke-super {p0, p1}, Landroid/accounts/AccountAuthenticatorActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPickServerClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 290
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 291
    const/16 v1, 0xa

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/LoginActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 292
    return-void
.end method

.method public onReloadClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    .line 282
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.LoginActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 148
    invoke-super {p0}, Landroid/accounts/AccountAuthenticatorActivity;->onResume()V

    .line 149
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->b:Z

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->b()V

    .line 151
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    .line 152
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->b:Z

    .line 154
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 158
    invoke-super {p0, p1}, Landroid/accounts/AccountAuthenticatorActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 159
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/LoginActivity;->c:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Landroid/os/Bundle;)V

    .line 160
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.LoginActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/accounts/AccountAuthenticatorActivity;->onStart()V

    return-void
.end method
