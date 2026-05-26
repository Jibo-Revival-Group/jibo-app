.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->run()V
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
        "Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;)V
    .locals 0

    .prologue
    .line 236
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;)V
    .locals 4

    .prologue
    .line 258
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 287
    :goto_0
    return-void

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iput-object p2, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    .line 261
    const-string v0, "TOKEN"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "NEW TOKEN:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->i(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 264
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 239
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 242
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    const-string v1, "prepareRobot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 243
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 244
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 245
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Runnable;)V

    .line 254
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 236
    check-cast p1, Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a(Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;)V

    return-void
.end method
