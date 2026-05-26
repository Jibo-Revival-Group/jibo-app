.class public Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "AlreadyInTheLoopDialog.java"


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field private c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field textView:Landroid/widget/TextView;
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


# virtual methods
.method public onAdultClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->dismiss()V

    .line 78
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 42
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 43
    const v1, 0x7f10011f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 44
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0044

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 45
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 46
    invoke-virtual {v2, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 47
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    .line 49
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->a:Lbutterknife/Unbinder;

    .line 51
    if-eqz p1, :cond_1

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 52
    :goto_0
    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 53
    if-eqz p1, :cond_2

    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 54
    :goto_1
    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_0

    .line 57
    const v0, 0x7f100114

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v5

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v4

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 59
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 60
    new-instance v0, Landroid/text/style/StyleSpan;

    invoke-direct {v0, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 61
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x21

    .line 60
    invoke-virtual {v1, v0, v5, v3, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->textView:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 65
    :cond_0
    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    .line 52
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    goto :goto_0

    .line 54
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    goto :goto_1
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 70
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 73
    return-void
.end method

.method public onViewProfileClicked(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 82
    const/4 v1, 0x0

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getMembers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 84
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 85
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    .line 86
    if-eqz v3, :cond_2

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    :goto_1
    move-object v1, v0

    .line 90
    goto :goto_0

    .line 91
    :cond_0
    if-nez v1, :cond_1

    .line 102
    :goto_2
    return-void

    .line 95
    :cond_1
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-class v3, Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 96
    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 97
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v1

    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 98
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v1

    const-string v2, "ARGS_ALLOW_EDIT"

    const/4 v3, 0x0

    .line 99
    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 100
    const/16 v1, 0x3ef

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 101
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->dismiss()V

    goto :goto_2

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method
