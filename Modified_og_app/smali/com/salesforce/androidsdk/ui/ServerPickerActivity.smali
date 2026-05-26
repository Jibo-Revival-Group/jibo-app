.class public Lcom/salesforce/androidsdk/ui/ServerPickerActivity;
.super Landroid/app/Activity;
.source "ServerPickerActivity.java"

# interfaces
.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;


# instance fields
.field private a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

.field private b:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private c:Lcom/salesforce/androidsdk/config/LoginServerManager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private a(Landroid/widget/RadioGroup;Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V
    .locals 4

    .prologue
    .line 206
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;

    iget-object v1, p2, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->a:Ljava/lang/String;

    iget-object v2, p2, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->b:Ljava/lang/String;

    iget-boolean v3, p2, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->c:Z

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 208
    invoke-virtual {p1, v0}, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V

    .line 209
    return-void
.end method

.method private d()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->b()V

    .line 67
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c()V

    .line 68
    new-instance v0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    .line 69
    return-void
.end method


# virtual methods
.method protected a()I
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->W()I

    move-result v0

    return v0
.end method

.method protected b()V
    .locals 3

    .prologue
    .line 215
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 216
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/LoginServerManager;->c()Ljava/util/List;

    move-result-object v1

    .line 217
    if-eqz v1, :cond_0

    .line 218
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 219
    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a(Landroid/widget/RadioGroup;Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V

    goto :goto_0

    .line 222
    :cond_0
    return-void
.end method

.method public c()V
    .locals 9

    .prologue
    .line 228
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 229
    invoke-virtual {v0}, Landroid/widget/RadioGroup;->removeAllViews()V

    .line 230
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b()V

    .line 233
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a()Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    move-result-object v3

    .line 234
    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getChildCount()I

    move-result v4

    .line 235
    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v4, :cond_1

    .line 236
    invoke-virtual {v0, v2}, Landroid/widget/RadioGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;

    .line 237
    if-eqz v1, :cond_0

    .line 238
    new-instance v5, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b()Z

    move-result v8

    invoke-direct {v5, v6, v7, v8}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 239
    invoke-virtual {v5, v3}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 240
    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->setChecked(Z)V

    .line 235
    :cond_0
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_0

    .line 244
    :cond_1
    return-void
.end method

.method public onCheckedChanged(Landroid/widget/RadioGroup;I)V
    .locals 5

    .prologue
    .line 82
    if-eqz p1, :cond_0

    .line 83
    invoke-virtual {p1, p2}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;

    .line 84
    if-eqz v0, :cond_0

    .line 85
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->getName()Ljava/lang/String;

    move-result-object v1

    .line 86
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 87
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b()Z

    move-result v0

    .line 88
    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    new-instance v4, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-direct {v4, v1, v2, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v3, v4}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V

    .line 92
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.ServerPickerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 114
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 115
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 116
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l()Lcom/salesforce/androidsdk/config/LoginServerManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    .line 117
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->X()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->setContentView(I)V

    .line 123
    sget v0, Lcom/salesforce/androidsdk/R$id;->sf__show_custom_url_edit:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 124
    if-eqz v0, :cond_0

    .line 125
    invoke-static {p0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v1

    sget-object v2, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->OnlyShowAuthorizedHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 126
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 129
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 130
    invoke-virtual {v0, p0}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 131
    new-instance v0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    .line 132
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->setRetainInstance(Z)V

    .line 133
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2

    .prologue
    .line 151
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->aa()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 152
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 143
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 144
    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 145
    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    .line 146
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 147
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 157
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->ab()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 158
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->d()V

    .line 159
    const/4 v0, 0x1

    .line 161
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResetClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->d()V

    .line 101
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.ui.ServerPickerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 137
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 138
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c()V

    .line 139
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.ServerPickerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    return-void
.end method

.method public setCancelReturnValue(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->onBackPressed()V

    .line 78
    return-void
.end method

.method public setPositiveReturnValue(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 172
    const/4 v0, -0x1

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->setResult(ILandroid/content/Intent;)V

    .line 173
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->finish()V

    .line 174
    return-void
.end method

.method public showCustomUrlDialog(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 185
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->isAdded()Z

    move-result v1

    if-nez v1, :cond_0

    .line 186
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    const-string v2, "custom_server_dialog"

    invoke-virtual {v1, v0, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 188
    :cond_0
    return-void
.end method
