.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
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
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Ljava/lang/Runnable;)V

    .line 176
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 162
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    const-string v1, "get robot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 163
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 158
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
