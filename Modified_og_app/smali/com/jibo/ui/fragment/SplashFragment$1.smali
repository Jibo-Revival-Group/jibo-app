.class Lcom/jibo/ui/fragment/SplashFragment$1;
.super Ljava/lang/Object;
.source "SplashFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/SplashFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/SplashFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/SplashFragment;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 117
    :goto_0
    return-void

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 42
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 43
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    .line 42
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 45
    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 48
    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/SplashFragment;->i()V

    .line 51
    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/SplashFragment$1$1;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/SplashFragment$1$1;-><init>(Lcom/jibo/ui/fragment/SplashFragment$1;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    goto :goto_0

    .line 113
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Lcom/jibo/ui/fragment/SplashFragment;)V

    goto :goto_0
.end method
