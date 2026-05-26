.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;
.super Ljava/lang/Object;
.source "OauthFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f1002e2

    const/4 v2, -0x1

    invoke-static {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    .line 118
    add-int/lit8 v1, v0, -0x2

    if-lez v1, :cond_0

    .line 120
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    add-int/lit8 v0, v0, -0x2

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->b(I)Landroid/support/v4/app/FragmentManager$BackStackEntry;

    move-result-object v0

    invoke-interface {v0}, Landroid/support/v4/app/FragmentManager$BackStackEntry;->a()I

    move-result v0

    .line 121
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/FragmentManager;->b(II)Z

    .line 126
    :goto_0
    return-void

    .line 124
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    goto :goto_0
.end method
