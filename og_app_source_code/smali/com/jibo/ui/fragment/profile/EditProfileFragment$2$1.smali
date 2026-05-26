.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;)V
    .locals 0

    .prologue
    .line 450
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 453
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->g()V

    .line 454
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->d(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    .line 456
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 457
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 458
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v2

    .line 457
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 460
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 461
    return-void
.end method
