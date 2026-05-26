.class public Lcom/jibo/ui/fragment/invite/CongratsFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "CongratsFragment.java"


# instance fields
.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field video:Landroid/widget/VideoView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    return-void
.end method

.method private r()V
    .locals 2

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 81
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 82
    return-void
.end method

.method private s()I
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 109
    const v0, 0x7f10016c

    .line 113
    :goto_0
    return v0

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 111
    const v0, 0x7f100160

    goto :goto_0

    .line 113
    :cond_1
    const v0, 0x7f10037a

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 99
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->title:Landroid/widget/TextView;

    const v2, 0x7f100173

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->text:Landroid/widget/TextView;

    const v2, 0x7f100172

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->s()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    return-void

    .line 97
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->d:Ljava/lang/String;

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 91
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 92
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->k()V

    .line 93
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 105
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    const v0, 0x7f100432

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 49
    const v0, 0x7f0b0072

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDontShowAgain(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->l(Landroid/content/Context;)V

    .line 76
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->r()V

    .line 77
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 54
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 56
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/CongratsFragment;)V

    const-wide/16 v2, 0x320

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 66
    return-void
.end method

.method public onViewMyLoop(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->r()V

    .line 71
    return-void
.end method
