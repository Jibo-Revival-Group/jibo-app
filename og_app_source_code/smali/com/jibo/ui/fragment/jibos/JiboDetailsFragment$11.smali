.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->s()V
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
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 639
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 3

    .prologue
    .line 662
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 663
    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    invoke-direct {v2, p0, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 710
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 642
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const-string v1, "notification get status"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 644
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 645
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 646
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 658
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 639
    check-cast p1, Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a(Lcom/jibo/aws/integration/aws/services/notification/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    return-void
.end method
