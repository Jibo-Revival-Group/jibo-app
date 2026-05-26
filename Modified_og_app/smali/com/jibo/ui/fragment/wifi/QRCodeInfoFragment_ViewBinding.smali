.class public Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "QRCodeInfoFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 21
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    .line 24
    const v0, 0x7f09005d

    const-string v1, "method \'onContinue\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 25
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->c:Landroid/view/View;

    .line 26
    new-instance v1, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 32
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 36
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment_ViewBinding;->c:Landroid/view/View;

    .line 43
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 44
    return-void
.end method
