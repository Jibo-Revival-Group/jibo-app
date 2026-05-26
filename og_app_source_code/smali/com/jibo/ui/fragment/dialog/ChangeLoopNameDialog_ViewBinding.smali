.class public Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;
.super Ljava/lang/Object;
.source "ChangeLoopNameDialog_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    .line 28
    const v0, 0x7f0901ea

    const-string v1, "field \'nameEdit\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    .line 29
    const v0, 0x7f0902ed

    const-string v1, "field \'tipText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->tipText:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f0900a8

    const-string v1, "method \'onCancelClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 31
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v1, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const v0, 0x7f090275

    const-string v1, "method \'onSetClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 39
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->d:Landroid/view/View;

    .line 40
    new-instance v1, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    .line 52
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    .line 55
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->tipText:Landroid/widget/TextView;

    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->c:Landroid/view/View;

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;->d:Landroid/view/View;

    .line 62
    return-void
.end method
