.class public Lcom/jibo/ui/fragment/invite/PreferredNameFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "PreferredNameFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field mChangePronunciationName:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mPreferredNameTip:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mViewLoopMembers:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field nickname:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field nicknameSkip:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

.field private s:Z

.field private t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

.field private u:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    const-class v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    .line 78
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    return-void
.end method

.method public static a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 3

    .prologue
    .line 88
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    .line 89
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 90
    const-string v1, "ARGS_SHOULD_RETURN_VALUE"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 91
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 92
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 93
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 94
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 95
    const-string v1, "ARG_NICKNAME"

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 97
    :cond_0
    const/16 v1, 0x3f3

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 98
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 58
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    return v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    return-object v0
.end method

.method private r()V
    .locals 1

    .prologue
    .line 339
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    if-eqz v0, :cond_1

    .line 347
    :cond_0
    :goto_0
    return-void

    .line 343
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->p:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 346
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

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
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b(Z)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public a()V
    .locals 8

    .prologue
    const v7, 0x7f10024f

    const/16 v1, 0x8

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 171
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->u:Ljava/lang/String;

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    const/4 v3, 0x2

    new-array v3, v3, [Landroid/text/InputFilter;

    new-instance v4, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v4}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v4, v3, v2

    new-instance v4, Landroid/text/InputFilter$LengthFilter;

    const/16 v5, 0x14

    invoke-direct {v4, v5}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v4, v3, v6

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 174
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nicknameSkip:Landroid/widget/TextView;

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    if-eqz v0, :cond_2

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    new-instance v3, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 197
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f06001f

    invoke-static {v3, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 200
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->l:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->l:Ljava/lang/String;

    aput-object v4, v3, v2

    invoke-virtual {p0, v7, v3}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 206
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-nez v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mChangePronunciationName:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 210
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r()V

    .line 212
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getActiveMembersCount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v0

    if-ne v0, v6, :cond_1

    .line 213
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mViewLoopMembers:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 215
    :cond_1
    return-void

    :cond_2
    move v0, v2

    .line 174
    goto :goto_0

    .line 203
    :cond_3
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    new-array v4, v6, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    :goto_2
    aput-object v0, v4, v2

    invoke-virtual {p0, v7, v4}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    goto :goto_2
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 155
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 156
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 157
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 159
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 161
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->n()V

    .line 162
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 219
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->e()V

    .line 221
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Z)V

    .line 222
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b(Z)V

    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 227
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    .line 229
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMembersNicknames(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/List;

    move-result-object v1

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v0, :cond_1

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 233
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->u:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 235
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 237
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_4

    iget-boolean v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    if-eqz v2, :cond_4

    .line 238
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 239
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_PHONETIC_NAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 240
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 298
    :goto_1
    return-void

    .line 235
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    goto :goto_0

    .line 244
    :cond_4
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    new-instance v3, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    invoke-virtual {v2, v1, v0, v3}, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;->match(Ljava/util/List;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_1
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 148
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Landroid/os/Bundle;)V

    .line 149
    const-string v0, "ARGS_SHOULD_RETURN_VALUE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->s:Z

    .line 150
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    .line 151
    return-void
.end method

.method changePronunciationName(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 314
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 315
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 316
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 317
    return-void
.end method

.method public h()Z
    .locals 3

    .prologue
    .line 141
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->u:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 142
    const/4 v0, 0x0

    return v0
.end method

.method public nicknameSkip(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 302
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b()V

    .line 303
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    const v0, 0x7f10041f

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3

    .prologue
    .line 321
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 322
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 323
    packed-switch p1, :pswitch_data_0

    .line 336
    :cond_0
    :goto_0
    return-void

    .line 325
    :pswitch_0
    const-string v0, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 326
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->e:Ljava/lang/String;

    .line 327
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setPhoneticName(Ljava/lang/String;)V

    .line 328
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 332
    :cond_1
    const/16 v0, 0x3fd

    if-ne p1, v0, :cond_0

    .line 333
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->e:Ljava/lang/String;

    goto :goto_0

    .line 323
    :pswitch_data_0
    .packed-switch 0x3fd
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3

    .prologue
    .line 133
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->p:Landroid/view/MenuItem;

    const v1, 0x7f08011a

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 136
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->p:Landroid/view/MenuItem;

    const v2, 0x7f0600df

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 137
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->r()V

    .line 138
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 104
    const v0, 0x7f0b0081

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 123
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b()V

    .line 125
    const/4 v0, 0x1

    .line 127
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 109
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->l()V

    .line 113
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 114
    if-eqz v0, :cond_0

    .line 115
    new-instance v1, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 116
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 117
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    .line 115
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 119
    :cond_0
    return-void
.end method

.method viewLoopMembers(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 307
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 308
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 309
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 310
    return-void
.end method
