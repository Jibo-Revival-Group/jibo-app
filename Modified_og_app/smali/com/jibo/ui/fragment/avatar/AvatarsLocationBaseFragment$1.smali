.class Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;
.super Ljava/lang/Object;
.source "AvatarsLocationBaseFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 73
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const v1, 0x7f10003c

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 80
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->c(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->d(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 83
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 84
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "avatar"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    new-instance v3, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;

    invoke-direct {v3, p0, v0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;-><init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;I)V

    invoke-virtual {v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 111
    return-void
.end method
