.class public Lcom/jibo/ui/fragment/account/skills/OauthFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "OauthFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;,
        Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;
    }
.end annotation


# instance fields
.field private a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

.field private b:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

.field private c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

.field private d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field private e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

.field private l:Z

.field private m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

.field webview:Landroid/webkit/WebView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 66
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    .line 68
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->l:Z

    .line 70
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    return-object v0
.end method

.method private a()V
    .locals 3

    .prologue
    .line 296
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->l:Z

    .line 297
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->b()Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 298
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->startActivity(Landroid/content/Intent;)V

    .line 299
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/OauthFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 44
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()Landroid/net/Uri;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 302
    const-string v0, ""

    .line 303
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, v1

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 304
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getAuthorizationUri()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 305
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosClientId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 306
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosCallbackUri()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 307
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 308
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 309
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getAuthorizationUri()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?client_id="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 310
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServerClientId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&redirect_uri="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "https://www.jibo.com/google-oauth-callback"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&response_type=code&scope="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    move v0, v1

    .line 312
    :goto_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v3

    array-length v3, v3

    if-ge v0, v3, :cond_0

    .line 313
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v3

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 312
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 315
    :cond_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v2, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 316
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&response_mode=query&prompt=select_account consent&access_type=offline"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 319
    :cond_1
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a()V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    return-object v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 2

    .prologue
    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    sget-object v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    if-eq v0, v1, :cond_0

    .line 205
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 207
    :cond_0
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 268
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 270
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isCreated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 288
    :goto_0
    return-void

    .line 274
    :cond_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    .line 276
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 277
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    .line 278
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 280
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 283
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string v1, "google"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 284
    sget-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    goto :goto_0

    .line 286
    :cond_1
    sget-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Other:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 135
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 136
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    sget-object v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    if-ne v0, v1, :cond_0

    new-instance v0, Landroid/view/View;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    :goto_0
    return-object v0

    :cond_0
    const v0, 0x7f0b0095

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 292
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 293
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    const-wide/16 v4, 0x32

    const/4 v6, 0x0

    const/4 v2, 0x0

    .line 216
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 219
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    if-nez v0, :cond_0

    .line 220
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$3;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    invoke-virtual {v0, v1, v4, v5}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 228
    :cond_0
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->n:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 229
    iput-boolean v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->l:Z

    .line 230
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->n:Ljava/lang/String;

    .line 231
    sput-object v6, Lcom/jibo/ui/activity/OnBoardingActivity;->n:Ljava/lang/String;

    .line 232
    const-string v1, "https://www.jibo.com/google-oauth-callback"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 233
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 234
    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 235
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 237
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServiceAccountName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 238
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServiceName()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 240
    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServerClientId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 241
    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 242
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-interface {v1, v2, v0, v6}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 256
    :cond_1
    :goto_0
    return-void

    .line 247
    :cond_2
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->l:Z

    if-eqz v0, :cond_1

    .line 248
    iput-boolean v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->l:Z

    .line 249
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$4;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    invoke-virtual {v0, v1, v4, v5}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 260
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 261
    const-class v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a:Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    const-class v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    const-string v0, "ARGS_SKILL_FRAGMENT"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 264
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 146
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 148
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isCreated()Z

    move-result v0

    if-nez v0, :cond_1

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 152
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    sget-object v3, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    if-ne v0, v3, :cond_2

    .line 153
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 154
    const v1, 0x7f100235

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(I)Landroid/support/v7/app/AlertDialog$Builder;

    .line 155
    const v1, 0x7f100231

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 156
    new-instance v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$2;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/content/DialogInterface$OnDismissListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 162
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 164
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 193
    :goto_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 194
    if-eqz v0, :cond_0

    .line 195
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 196
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 197
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 195
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    goto :goto_0

    .line 167
    :cond_2
    const v0, 0x7f090334

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->webview:Landroid/webkit/WebView;

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->webview:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 169
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->webview:Landroid/webkit/WebView;

    new-instance v3, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;

    invoke-direct {v3, p0, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    invoke-virtual {v0, v3}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v0

    aget-object v0, v0, v1

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 175
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getAuthorizationUri()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 176
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosClientId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 177
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosCallbackUri()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 178
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 179
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 180
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getAuthorizationUri()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?client_id="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 181
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosClientId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&redirect_uri="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    .line 182
    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosCallbackUri()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&response_type=code&scope="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    move v0, v1

    .line 183
    :goto_2
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v3

    array-length v3, v3

    if-ge v0, v3, :cond_3

    .line 184
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v3

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "%20"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 183
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 186
    :cond_3
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x3

    invoke-virtual {v2, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 187
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&response_mode=query"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 190
    :goto_3
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->webview:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_4
    move-object v0, v2

    goto :goto_3
.end method
