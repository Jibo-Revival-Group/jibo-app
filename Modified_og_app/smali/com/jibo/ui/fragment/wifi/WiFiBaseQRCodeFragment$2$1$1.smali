.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$1;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->onError(Ljava/lang/Exception;)V
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
    .line 245
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 249
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 251
    return-void
.end method
