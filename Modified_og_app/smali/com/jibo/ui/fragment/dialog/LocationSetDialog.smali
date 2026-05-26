.class public Lcom/jibo/ui/fragment/dialog/LocationSetDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "LocationSetDialog.java"


# instance fields
.field a:Lbutterknife/Unbinder;

.field location:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field timezone:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onBtnSetClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->dismiss()V

    .line 68
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 37
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 38
    const v1, 0x7f100151

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 39
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b004d

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 40
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 41
    invoke-virtual {v2, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 42
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    .line 44
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->a:Lbutterknife/Unbinder;

    .line 46
    if-eqz p1, :cond_1

    const-string v0, "ARGS_LOCATION"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 48
    :goto_0
    if-eqz p1, :cond_2

    const-string v0, "ARGS_TIMEZONE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    :goto_1
    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->location:Landroid/widget/TextView;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    const v1, 0x7f100278

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getString(I)Ljava/lang/String;

    move-result-object v1

    :cond_0
    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    if-eqz v0, :cond_3

    const-string v1, "\\/"

    const-string v3, "/"

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 53
    :goto_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->timezone:Landroid/widget/TextView;

    const v3, 0x7f10031a

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getTimeZoneFriendly(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    .line 47
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_LOCATION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 49
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "ARGS_TIMEZONE"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 52
    :cond_3
    const-string v0, ""

    goto :goto_2
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 60
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/LocationSetDialog;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 63
    return-void
.end method
