.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 327
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->f()V

    .line 328
    return-void
.end method
