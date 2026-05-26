.class public Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "ChangeLoopNameDialog.java"


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field nameEdit:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tipText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method

.method private a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 99
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " Jibo"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public onCancelClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->dismiss()V

    .line 76
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 45
    if-eqz p1, :cond_1

    .line 46
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 50
    :cond_0
    :goto_0
    new-instance v0, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x1030134

    invoke-direct {v0, v1, v2}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 52
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0047

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 53
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v2

    iput-object v2, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->a:Lbutterknife/Unbinder;

    .line 55
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 56
    invoke-virtual {v0, v5}, Landroid/support/v7/app/AppCompatDialog;->setCancelable(Z)V

    .line 58
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->tipText:Landroid/widget/TextView;

    const v2, 0x7f1000f4

    new-array v3, v5, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 59
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, " Jibo"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 61
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    new-array v2, v5, [Landroid/text/InputFilter;

    new-instance v3, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v3}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v3, v2, v6

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 63
    return-object v0

    .line 47
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 48
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 68
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 71
    return-void
.end method

.method public onSetClicked(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->nameEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 81
    const v0, 0x7f10024d

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0, v2}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;Ljava/lang/CharSequence;I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 82
    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 96
    :goto_0
    return-void

    .line 84
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x1b

    if-le v0, v1, :cond_1

    .line 85
    const v0, 0x7f1002d9

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0, v2}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;Ljava/lang/CharSequence;I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 86
    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    goto :goto_0

    .line 90
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    if-eqz v0, :cond_2

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->getTargetRequestCode()I

    move-result v1

    .line 92
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->a()Ljava/lang/String;

    move-result-object v3

    .line 91
    invoke-interface {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;->a(IILjava/lang/Object;)V

    .line 95
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->dismiss()V

    goto :goto_0
.end method
