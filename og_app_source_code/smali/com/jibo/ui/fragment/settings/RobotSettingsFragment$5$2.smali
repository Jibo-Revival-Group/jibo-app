.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
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
    .line 415
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 418
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->g()V

    .line 420
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getLocation(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 421
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getTimeZone(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 423
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->imgJiboAvatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 425
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;->getConnected()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 426
    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getWifiName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    .line 425
    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 427
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    .line 428
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;->getConnected()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    const v0, 0x7f0600c6

    .line 427
    :goto_1
    invoke-static {v2, v0}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 430
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboLocation:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->f(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const v2, 0x7f10031a

    .line 431
    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 430
    :goto_2
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 434
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->g(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    .line 435
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->mRemoteSwitch:Landroid/widget/Switch;

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;)V

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 449
    return-void

    .line 426
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const v2, 0x7f1001b4

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 428
    :cond_2
    const v0, 0x7f060074

    goto :goto_1

    .line 431
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 432
    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Ljava/lang/String;

    move-result-object v0

    goto :goto_2
.end method
