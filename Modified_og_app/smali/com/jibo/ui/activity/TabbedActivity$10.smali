.class Lcom/jibo/ui/activity/TabbedActivity$10;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
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
.field final synthetic a:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 0

    .prologue
    .line 647
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$10;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 655
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$10;->a:Lcom/jibo/ui/activity/TabbedActivity;

    new-instance v1, Lcom/jibo/ui/activity/TabbedActivity$10$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/ui/activity/TabbedActivity$10$1;-><init>(Lcom/jibo/ui/activity/TabbedActivity$10;Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 661
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 650
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$10;->a:Lcom/jibo/ui/activity/TabbedActivity;

    const-string v1, "get robot"

    invoke-virtual {v0, p1, v1}, Lcom/jibo/ui/activity/TabbedActivity;->a(Ljava/lang/Exception;Ljava/lang/String;)V

    .line 651
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 647
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/activity/TabbedActivity$10;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
