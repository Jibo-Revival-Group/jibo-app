.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->g()V

    .line 165
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 166
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 169
    :cond_0
    return-void
.end method
