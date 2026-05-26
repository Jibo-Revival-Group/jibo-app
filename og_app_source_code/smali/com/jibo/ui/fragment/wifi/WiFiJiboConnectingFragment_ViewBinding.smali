.class public Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "WiFiJiboConnectingFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

    .line 27
    const v0, 0x7f09007b

    const-string v1, "method \'onBtnNoScreenClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 28
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->c:Landroid/view/View;

    .line 29
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    const v0, 0x7f090064

    const-string v1, "method \'onBtnEditWifiClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 36
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->d:Landroid/view/View;

    .line 37
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 47
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 48
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

    .line 51
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->c:Landroid/view/View;

    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment_ViewBinding;->d:Landroid/view/View;

    .line 56
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 57
    return-void
.end method
