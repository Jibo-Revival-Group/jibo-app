.class Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;
.super Ljava/lang/Object;
.source "AvatarBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 241
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;)V

    .line 244
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    if-eqz v0, :cond_0

    .line 245
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 246
    sget-object v1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 247
    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/app/Activity;Landroid/os/Bundle;)V

    .line 255
    :goto_0
    return-void

    .line 252
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Ljava/lang/String;)V

    .line 254
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method
