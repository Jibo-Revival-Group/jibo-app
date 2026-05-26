.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Z)V

    .line 439
    return-void
.end method
