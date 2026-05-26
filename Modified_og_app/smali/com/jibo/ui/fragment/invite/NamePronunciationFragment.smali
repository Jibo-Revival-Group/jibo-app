.class public Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "NamePronunciationFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field mPhoneticNameTip:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mPhoneticNameView:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mTitleView:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field s:I

.field private t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field private u:Z

.field private v:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-class v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 45
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    .line 63
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->u:Z

    .line 65
    iput v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->s:I

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method public static a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 3

    .prologue
    .line 73
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    .line 74
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 75
    const-string v1, "ARGS_SHOULD_RETURN_VALUE"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 76
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 77
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 78
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 79
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 80
    const-string v1, "ARG_PHONETIC_NAME"

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 82
    :cond_0
    const/16 v1, 0x3fd

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 84
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 45
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private r()V
    .locals 1

    .prologue
    .line 227
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->u:Z

    if-eqz v0, :cond_1

    .line 235
    :cond_0
    :goto_0
    return-void

    .line 231
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->p:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mPhoneticNameView:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->b(Z)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 146
    new-instance v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e:Ljava/lang/String;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->v:Ljava/lang/String;

    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mPhoneticNameView:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mTitleView:Landroid/widget/TextView;

    const v1, 0x7f10015e

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 165
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mPhoneticNameTip:Landroid/widget/TextView;

    const v2, 0x7f100258

    const/4 v0, 0x1

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    :goto_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r()V

    .line 173
    return-void

    .line 165
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 167
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mTitleView:Landroid/widget/TextView;

    const v1, 0x7f10015f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mPhoneticNameTip:Landroid/widget/TextView;

    const v1, 0x7f100259

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 130
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 131
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 132
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 134
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 136
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->n()V

    .line 137
    return-void
.end method

.method public b()V
    .locals 5

    .prologue
    .line 177
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e()V

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f10025d

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 184
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->t:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 200
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->mPhoneticNameView:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e:Ljava/lang/String;

    .line 202
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e:Ljava/lang/String;

    new-instance v4, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updatePhoneticName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 224
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 122
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Landroid/os/Bundle;)V

    .line 123
    const-string v0, "ARGS_SHOULD_RETURN_VALUE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->u:Z

    .line 124
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    .line 125
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 126
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    const v0, 0x7f100417

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3

    .prologue
    .line 113
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->p:Landroid/view/MenuItem;

    const v1, 0x7f08011a

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->p:Landroid/view/MenuItem;

    const v2, 0x7f0600df

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 117
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->r()V

    .line 118
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 90
    iput v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->s:I

    .line 91
    const v0, 0x7f0b007d

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 103
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->b()V

    .line 105
    const/4 v0, 0x1

    .line 107
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 96
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 98
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->l()V

    .line 99
    return-void
.end method
