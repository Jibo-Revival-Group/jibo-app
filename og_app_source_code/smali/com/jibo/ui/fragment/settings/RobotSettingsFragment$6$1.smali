.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 470
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->h(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const v2, 0x7f100213

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 472
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->i(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 473
    return-void
.end method
