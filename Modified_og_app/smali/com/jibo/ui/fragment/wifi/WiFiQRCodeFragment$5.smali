.class Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;
.super Ljava/lang/Object;
.source "WiFiQRCodeFragment.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->u()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V
    .locals 0

    .prologue
    .line 495
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;->a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 3

    .prologue
    .line 498
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;->a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 499
    int-to-float v1, p2

    const/high16 v2, 0x42c80000    # 100.0f

    div-float/2addr v1, v2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 500
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;->a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 501
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0

    .prologue
    .line 506
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0

    .prologue
    .line 511
    return-void
.end method
