.class public Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "EmailInviteInfoFragment.java"


# instance fields
.field private a:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field private r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 98
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    .line 99
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 101
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->d:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    move-object v1, v0

    .line 103
    :goto_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->title:Landroid/widget/TextView;

    const v3, 0x7f10011c

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-nez v0, :cond_2

    .line 107
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    .line 112
    :goto_2
    const v2, 0x7f10037a

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 114
    sget-object v3, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    if-ne v0, v3, :cond_3

    .line 115
    const v0, 0x7f10016c

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 119
    :goto_3
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->text:Landroid/widget/TextView;

    const v3, 0x7f10011b

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    aput-object v0, v4, v6

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    return-void

    .line 99
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 100
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 101
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->d:Ljava/lang/String;

    goto :goto_1

    .line 109
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    goto :goto_2

    .line 116
    :cond_3
    sget-object v3, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    if-ne v0, v3, :cond_4

    .line 117
    const v0, 0x7f100160

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    :cond_4
    move-object v0, v2

    goto :goto_3
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 91
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 92
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->k()V

    .line 93
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 124
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Landroid/os/Bundle;)V

    .line 53
    const-string v0, "ARG_MODE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 54
    invoke-static {}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->values()[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    move-result-object v0

    const-string v1, "ARG_MODE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->a:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    .line 56
    :cond_0
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 59
    :cond_1
    return-void
.end method

.method public dontGoToEMail(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->a:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v0, v1, :cond_0

    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 82
    :goto_0
    return-void

    .line 80
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    .line 81
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->q()V

    goto :goto_0
.end method

.method public goToEmail(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->a:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v0, v1, :cond_0

    .line 64
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 65
    const-string v1, "ARG_MODE"

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 66
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 67
    const-class v1, Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 71
    :goto_0
    return-void

    .line 69
    :cond_0
    const-class v0, Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->a(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    const v0, 0x7f100177

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreate(Landroid/os/Bundle;)V

    .line 41
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    const v0, 0x7f0b006b

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
