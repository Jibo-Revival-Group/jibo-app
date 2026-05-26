.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;",
        "Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V
    .locals 0

    .prologue
    .line 315
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    .line 337
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 319
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const-string v1, "notification get status"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 321
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 322
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 324
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 330
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    .line 332
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 315
    check-cast p1, Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;->a(Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    return-void
.end method
