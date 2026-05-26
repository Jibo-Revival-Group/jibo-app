.class Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;
.super Ljava/lang/Object;
.source "BaseLoopInviteFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 241
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 242
    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-boolean v1, v1, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->o:Z

    if-eqz v1, :cond_0

    .line 243
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 245
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 246
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 247
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->k(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 248
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/invite/CongratsFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 249
    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 250
    const-string v1, "ARG_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 251
    const/16 v1, 0x3f9

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 253
    :cond_1
    return-void
.end method
