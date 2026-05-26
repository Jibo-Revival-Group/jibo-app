.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 277
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 279
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 280
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 283
    :cond_0
    return-void
.end method
