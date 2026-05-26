.class public Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;
.super Ljava/lang/Object;
.source "StaticOptionsDialogFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

    .line 28
    const v0, 0x7f09011a

    const-string v1, "field \'editIpAddress\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    .line 29
    const v0, 0x7f09011f

    const-string v1, "field \'editSubnetMask\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    .line 30
    const v0, 0x7f09011d

    const-string v1, "field \'editRouter\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    .line 31
    const v0, 0x7f090118

    const-string v1, "field \'editDns1\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns1:Landroid/widget/EditText;

    .line 32
    const v0, 0x7f090119

    const-string v1, "field \'editDns2\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns2:Landroid/widget/EditText;

    .line 33
    const v0, 0x7f0900a8

    const-string v1, "method \'onCancelClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 34
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->c:Landroid/view/View;

    .line 35
    new-instance v1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    const v0, 0x7f090275

    const-string v1, "method \'onSetClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 42
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->d:Landroid/view/View;

    .line 43
    new-instance v1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

    .line 55
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    .line 59
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    .line 60
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns1:Landroid/widget/EditText;

    .line 62
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns2:Landroid/widget/EditText;

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->c:Landroid/view/View;

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment_ViewBinding;->d:Landroid/view/View;

    .line 68
    return-void
.end method
