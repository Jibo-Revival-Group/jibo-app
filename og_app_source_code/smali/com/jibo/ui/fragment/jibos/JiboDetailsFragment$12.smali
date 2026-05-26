.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;
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
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 715
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 724
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 725
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 732
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 719
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const-string v1, "get robot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 720
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 715
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
