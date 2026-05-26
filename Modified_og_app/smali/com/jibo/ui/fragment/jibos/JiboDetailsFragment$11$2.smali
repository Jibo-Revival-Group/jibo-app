.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a(Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
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
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

.field final synthetic b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 0

    .prologue
    .line 663
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 689
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 690
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 708
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 667
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const-string v1, "get robot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 669
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 670
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 671
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 685
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 663
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
