.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b(Z)V
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
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Z)V
    .locals 0

    .prologue
    .line 371
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iput-boolean p2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 3

    .prologue
    .line 381
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->a:Z

    if-eqz v0, :cond_0

    const v0, 0x7f100267

    :goto_0
    invoke-virtual {v2, v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 382
    return-void

    .line 381
    :cond_0
    const v0, 0x7f100265

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 374
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "remoteEnabled"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 375
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "remoteEnabled"

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->a:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 376
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const v2, 0x7f100268

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 377
    return-void

    .line 375
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 371
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
