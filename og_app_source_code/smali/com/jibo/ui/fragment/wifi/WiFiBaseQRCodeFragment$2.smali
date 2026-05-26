.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;
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

.field private final b:J


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V
    .locals 2

    .prologue
    .line 198
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    const-wide/16 v0, 0x2710

    iput-wide v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->b:J

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 203
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v1

    if-nez v1, :cond_0

    .line 289
    :goto_0
    return-void

    .line 205
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 207
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;->getExpires()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x7530

    sub-long/2addr v2, v4

    .line 208
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-lez v1, :cond_4

    .line 209
    const-string v1, "TOKEN"

    const-string v2, "TOKEN IS ALIVE"

    invoke-static {v1, v2}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 212
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V

    .line 215
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->s()V

    .line 216
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v1, :cond_3

    .line 217
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 218
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iput-object v0, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 221
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, p0, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 224
    :cond_4
    const-string v1, "TOKEN"

    const-string v2, "TOKEN EXPIRED"

    invoke-static {v1, v2}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v1, :cond_5

    .line 226
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v2, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v2, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 228
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const-string v2, ""

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 229
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    const-string v3, "CircleFragment"

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 233
    :cond_5
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->f(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->g(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->h(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    .line 236
    :cond_6
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    new-instance v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;)V

    invoke-virtual {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->prepareRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto/16 :goto_0
.end method
