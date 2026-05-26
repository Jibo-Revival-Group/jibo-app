.class Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;
.super Ljava/lang/Object;
.source "AvatarsLocationBaseFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->onClick(Landroid/view/View;)V
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
.field final synthetic a:I

.field final synthetic b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;I)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iput p2, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Ljava/lang/Runnable;)V

    .line 109
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const-string v1, "robot update"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->a(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const v1, 0x7f10003b

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 90
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->e(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->b:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1;->a:Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->c(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 92
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 85
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
