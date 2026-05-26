.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V
    .locals 0

    .prologue
    .line 458
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 467
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 475
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 461
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const v2, 0x7f100212

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 462
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const-string v1, "update loop"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 463
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 458
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
