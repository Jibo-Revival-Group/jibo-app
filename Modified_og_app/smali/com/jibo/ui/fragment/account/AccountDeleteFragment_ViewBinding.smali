.class public Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;
.super Ljava/lang/Object;
.source "AccountDeleteFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    .line 27
    const v0, 0x7f0901b3

    const-string v1, "field \'mLeaveReasonGroup\'"

    const-class v2, Landroid/widget/RadioGroup;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    .line 28
    const v0, 0x7f090108

    const-string v1, "field \'reason1\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason1:Landroid/widget/RadioButton;

    .line 29
    const v0, 0x7f090109

    const-string v1, "field \'reason2\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason2:Landroid/widget/RadioButton;

    .line 30
    const v0, 0x7f09010a

    const-string v1, "field \'reason3\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason3:Landroid/widget/RadioButton;

    .line 31
    const v0, 0x7f09010b

    const-string v1, "field \'reason4\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason4:Landroid/widget/RadioButton;

    .line 32
    const v0, 0x7f090139

    const-string v1, "field \'footer\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->footer:Landroid/widget/TextView;

    .line 33
    const v0, 0x7f09005f

    const-string v1, "field \'btnDelete\' and method \'onBtnDelete\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 34
    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->btnDelete:Landroid/view/View;

    .line 35
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->c:Landroid/view/View;

    .line 36
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 47
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    .line 48
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    .line 51
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    .line 52
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason1:Landroid/widget/RadioButton;

    .line 53
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason2:Landroid/widget/RadioButton;

    .line 54
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason3:Landroid/widget/RadioButton;

    .line 55
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason4:Landroid/widget/RadioButton;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->footer:Landroid/widget/TextView;

    .line 57
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->btnDelete:Landroid/view/View;

    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 60
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;->c:Landroid/view/View;

    .line 61
    return-void
.end method
