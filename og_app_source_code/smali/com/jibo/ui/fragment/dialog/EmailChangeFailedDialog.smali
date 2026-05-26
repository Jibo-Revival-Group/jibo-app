.class public Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "EmailChangeFailedDialog.java"


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:Ljava/lang/String;

.field email:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textView:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancelClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->dismiss()V

    .line 68
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 41
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 42
    const v1, 0x7f100115

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 43
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b004a

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 44
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 45
    invoke-virtual {v2, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 46
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    .line 48
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->a:Lbutterknife/Unbinder;

    .line 50
    if-eqz p1, :cond_0

    const-string v0, "ARGS_EMAIL"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->b:Ljava/lang/String;

    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->email:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    .line 51
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_EMAIL"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 60
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 63
    return-void
.end method

.method public onTryAgainClicked(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    if-eqz v0, :cond_0

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->getTargetRequestCode()I

    move-result v1

    .line 74
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    const/4 v3, 0x0

    .line 73
    invoke-interface {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;->a(IILjava/lang/Object;)V

    .line 76
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->dismiss()V

    .line 77
    return-void
.end method
