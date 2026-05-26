.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;
.super Landroid/webkit/WebViewClient;
.source "OauthFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SignInViewClient"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

.field private final b:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/jibo/ui/fragment/account/skills/OauthFragment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V
    .locals 1

    .prologue
    .line 327
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 328
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->b:Ljava/lang/ref/WeakReference;

    .line 329
    return-void
.end method


# virtual methods
.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 333
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 334
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->b:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    .line 336
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move v0, v6

    .line 352
    :goto_0
    return v0

    .line 340
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosCallbackUri()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 341
    const-string v0, "code"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 342
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    .line 344
    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServiceAccountName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    .line 345
    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServiceName()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    .line 347
    invoke-static {v4}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getIosClientId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    .line 348
    invoke-static {v5}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getOauthParams()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getScopes()[Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 349
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->f(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$SignInViewClient;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->e(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v0, v3}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    move v0, v6

    .line 350
    goto :goto_0

    .line 352
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
