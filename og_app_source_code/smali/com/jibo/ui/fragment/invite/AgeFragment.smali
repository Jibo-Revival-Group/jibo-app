.class public Lcom/jibo/ui/fragment/invite/AgeFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "AgeFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field mChild:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mTeenageOrAdult:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/jibo/ui/fragment/invite/AgeFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/AgeFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mTeenageOrAdult:Landroid/widget/RadioButton;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f100429

    .line 59
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f100031

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 58
    invoke-static {v1, v2, v3}, Lcom/jibo/utils/UIUtils;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mChild:Landroid/widget/RadioButton;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f1003fe

    .line 61
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f100032

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 60
    invoke-static {v1, v2, v3}, Lcom/jibo/utils/UIUtils;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mTeenageOrAdult:Landroid/widget/RadioButton;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 63
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mChild:Landroid/widget/RadioButton;

    invoke-virtual {v0}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->b:Ljava/lang/Boolean;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 73
    const-class v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/AgeFragment;->a(Ljava/lang/Class;)V

    .line 77
    :goto_0
    return-void

    .line 75
    :cond_0
    const-class v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/AgeFragment;->a(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    const v0, 0x7f100406

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/AgeFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 47
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment;->p:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 49
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 42
    const v0, 0x7f0b0060

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
