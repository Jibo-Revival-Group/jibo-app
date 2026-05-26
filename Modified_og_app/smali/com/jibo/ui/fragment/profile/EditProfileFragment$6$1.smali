.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;->a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 569
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 573
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 575
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 576
    const-string v1, "ARGS_REMOVED_FROM_LOOP"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 577
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;

    iget-object v1, v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 578
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 579
    return-void
.end method
