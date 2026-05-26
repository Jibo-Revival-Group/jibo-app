.class public Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "WiFiSuccessFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f09005d

    .line 22
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    .line 27
    const v0, 0x1020016

    const-string v1, "field \'txtTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtTitle:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f09030e

    const-string v1, "field \'txtInfo\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtInfo:Landroid/widget/TextView;

    .line 29
    const-string v0, "field \'btnContinue\' and method \'onBtnContinueClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 30
    const-string v0, "field \'btnContinue\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontButton;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 31
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const v0, 0x7f090170

    const-string v1, "field \'jiboImage\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->jiboImage:Landroid/widget/ImageView;

    .line 39
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 43
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    .line 44
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtTitle:Landroid/widget/TextView;

    .line 48
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->txtInfo:Landroid/widget/TextView;

    .line 49
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->btnContinue:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 50
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;->jiboImage:Landroid/widget/ImageView;

    .line 52
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment_ViewBinding;->c:Landroid/view/View;

    .line 55
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 56
    return-void
.end method
