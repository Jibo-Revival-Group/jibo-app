.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a(Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;)V
    .locals 0

    .prologue
    .line 264
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 268
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->s()V

    .line 274
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 285
    return-void
.end method
