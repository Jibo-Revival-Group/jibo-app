.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;",
        "Lcom/jibo/aws/integration/aws/services/key/model/Backup;",
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
    .line 264
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iput-boolean p2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
    .locals 2

    .prologue
    .line 287
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 303
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 267
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 283
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 264
    check-cast p1, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V

    return-void
.end method
