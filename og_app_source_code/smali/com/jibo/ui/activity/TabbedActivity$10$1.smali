.class Lcom/jibo/ui/activity/TabbedActivity$10$1;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity$10;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field final synthetic c:Lcom/jibo/ui/activity/TabbedActivity$10;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity$10;Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 0

    .prologue
    .line 655
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->c:Lcom/jibo/ui/activity/TabbedActivity$10;

    iput-object p2, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    iput-object p3, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 658
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->c:Lcom/jibo/ui/activity/TabbedActivity$10;

    iget-object v0, v0, Lcom/jibo/ui/activity/TabbedActivity$10;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/TabbedActivity;->c(Lcom/jibo/ui/activity/TabbedActivity;)Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity$10$1;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    .line 659
    return-void
.end method
