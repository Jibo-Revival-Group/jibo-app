.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;)V
    .locals 0

    .prologue
    .line 398
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 401
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    const v1, 0x7f1001b4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 402
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060074

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 403
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboLocation:Landroid/widget/TextView;

    const v1, 0x7f10031a

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 406
    return-void
.end method
