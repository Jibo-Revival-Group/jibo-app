.class public Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "NetworkPwdFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090093

    .line 21
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    .line 26
    const v0, 0x7f09011b

    const-string v1, "field \'editPassword\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    .line 27
    const v0, 0x7f090314

    const-string v1, "field \'txtPasswordHint\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    .line 28
    const-string v0, "field \'btnStaticOptions\' and method \'onStaticClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 29
    const-string v0, "field \'btnStaticOptions\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->btnStaticOptions:Landroid/widget/TextView;

    .line 30
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->c:Landroid/view/View;

    .line 31
    new-instance v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    .line 42
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->btnStaticOptions:Landroid/widget/TextView;

    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 50
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment_ViewBinding;->c:Landroid/view/View;

    .line 52
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 53
    return-void
.end method
