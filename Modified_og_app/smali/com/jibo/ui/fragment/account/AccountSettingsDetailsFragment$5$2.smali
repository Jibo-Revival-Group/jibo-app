.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 452
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 455
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 456
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->t()V

    .line 457
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 458
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 459
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 461
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 463
    return-void
.end method
