.class public Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "WiFiHelpFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 27
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    .line 30
    const v0, 0x7f090098

    const-string v1, "method \'btnWiFiError1Click\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 31
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const v0, 0x7f090099

    const-string v1, "method \'btnWiFiError2Click\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 39
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->d:Landroid/view/View;

    .line 40
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    const v0, 0x7f09009a

    const-string v1, "method \'btnWiFiError3Click\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 47
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->e:Landroid/view/View;

    .line 48
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    const v0, 0x7f09009b

    const-string v1, "method \'btnWiFiError4Click\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 55
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->f:Landroid/view/View;

    .line 56
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->c:Landroid/view/View;

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->d:Landroid/view/View;

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->e:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;->f:Landroid/view/View;

    .line 79
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 80
    return-void
.end method
