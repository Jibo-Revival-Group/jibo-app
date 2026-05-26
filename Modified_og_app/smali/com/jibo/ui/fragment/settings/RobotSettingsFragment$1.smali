.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->onResume()V
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
    .line 144
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 148
    return-void
.end method
