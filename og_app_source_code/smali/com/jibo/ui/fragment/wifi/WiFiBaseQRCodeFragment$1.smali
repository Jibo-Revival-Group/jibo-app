.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    if-eqz v0, :cond_0

    .line 67
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v1, "checkForNewRobotRunnable"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    if-nez v0, :cond_1

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0xfa0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 76
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;->getToken()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getStatus(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method
