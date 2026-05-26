.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 171
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3$1;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    .line 174
    :cond_0
    return-void
.end method
