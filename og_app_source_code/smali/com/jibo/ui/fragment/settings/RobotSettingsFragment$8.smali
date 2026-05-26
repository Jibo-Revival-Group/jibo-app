.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V
    .locals 0

    .prologue
    .line 502
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 505
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 506
    invoke-static {v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->j(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 505
    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 507
    return-void
.end method
