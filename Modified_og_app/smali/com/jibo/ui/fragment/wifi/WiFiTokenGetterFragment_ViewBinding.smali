.class public Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "WiFiTokenGetterFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;

    .line 28
    const v0, 0x1020027

    const-string v1, "method \'onCloseClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 29
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->c:Landroid/view/View;

    .line 30
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    const v0, 0x7f090069

    const-string v1, "method \'onBtnHelpClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 37
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->d:Landroid/view/View;

    .line 38
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    const v0, 0x7f09005d

    const-string v1, "method \'onBtnContinueClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 45
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->e:Landroid/view/View;

    .line 46
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 57
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment;

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->c:Landroid/view/View;

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->d:Landroid/view/View;

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiTokenGetterFragment_ViewBinding;->e:Landroid/view/View;

    .line 67
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 68
    return-void
.end method
