.class Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;
.super Ljava/lang/Object;
.source "AvatarSelectionFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1$1;-><init>(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Ljava/lang/Runnable;)V

    .line 153
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a:Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    const-string v1, "get robot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;->a(Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 136
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 131
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
