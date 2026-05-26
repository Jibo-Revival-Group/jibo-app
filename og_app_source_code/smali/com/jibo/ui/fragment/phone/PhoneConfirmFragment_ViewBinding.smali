.class public Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    .line 26
    const v0, 0x7f0900ce

    const-string v1, "field \'code\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    .line 27
    const v0, 0x7f09013b

    const-string v1, "field \'footer_error\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f09013a

    const-string v1, "field \'footer1\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer1:Landroid/widget/TextView;

    .line 29
    const v0, 0x7f09023b

    const-string v1, "method \'onResendCode\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 30
    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->c:Landroid/view/View;

    .line 31
    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    .line 43
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    .line 48
    iput-object v1, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer1:Landroid/widget/TextView;

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    iput-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment_ViewBinding;->c:Landroid/view/View;

    .line 52
    return-void
.end method
