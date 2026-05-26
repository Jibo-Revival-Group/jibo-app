.class Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;
.super Ljava/lang/Object;
.source "AvatarBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment$4;)V
    .locals 0

    .prologue
    .line 340
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 343
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->g()V

    .line 346
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    instance-of v0, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    if-eqz v0, :cond_0

    .line 347
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 348
    sget-object v1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 349
    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/app/Activity;Landroid/os/Bundle;)V

    .line 352
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->c(Landroid/content/Context;)V

    .line 353
    return-void
.end method
