.class public Lcom/jibo/ui/fragment/wifi/NetworkNameFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "NetworkNameFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;

    .line 22
    const v0, 0x7f09011e

    const-string v1, "field \'editSSID\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    .line 23
    const v0, 0x7f090139

    const-string v1, "field \'footer\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->footer:Landroid/widget/TextView;

    .line 24
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;

    .line 29
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;

    .line 32
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    .line 33
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->footer:Landroid/widget/TextView;

    .line 35
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 36
    return-void
.end method
