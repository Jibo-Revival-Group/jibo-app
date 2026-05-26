.class public abstract Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "BaseLoopInviteFragment.java"


# instance fields
.field b:Ljava/lang/Boolean;

.field c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field d:Ljava/lang/String;

.field e:Ljava/lang/String;

.field l:Ljava/lang/String;

.field m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

.field o:Z

.field p:Landroid/view/MenuItem;

.field q:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 39
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 39
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 69
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 71
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_1

    .line 72
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 74
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    if-eqz v0, :cond_2

    .line 75
    const-string v0, "ARG_IS_CHILD"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 77
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 78
    const-string v0, "ARG_NICKNAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->l:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 81
    const-string v0, "ARG_NAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 84
    const-string v0, "ARG_PHONETIC_NAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_6

    .line 87
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 89
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    if-eqz v0, :cond_7

    .line 90
    const-string v0, "ARG_IS_PARENT"

    iget-boolean v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->o:Z

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 92
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v0, :cond_8

    .line 93
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 95
    :cond_8
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0, p1, p2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 96
    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 39
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method


# virtual methods
.method public abstract a()V
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 160
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 161
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 162
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 163
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->n()V

    .line 164
    return-void
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 5

    .prologue
    .line 321
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->o:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 322
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 323
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 327
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    new-instance v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 346
    return-void
.end method

.method public a(Ljava/lang/Class;)V
    .locals 1

    .prologue
    .line 106
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 107
    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 108
    return-void
.end method

.method public a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 99
    if-nez p2, :cond_0

    .line 100
    new-instance p2, Landroid/os/Bundle;

    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    .line 102
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 103
    return-void
.end method

.method public abstract b()V
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 131
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 132
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 135
    :cond_0
    const-string v0, "ARG_IS_CHILD"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 136
    const-string v0, "ARG_IS_CHILD"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    .line 138
    :cond_1
    const-string v0, "ARG_IS_PARENT"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 139
    const-string v0, "ARG_IS_PARENT"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->o:Z

    .line 141
    :cond_2
    const-string v0, "ARG_NICKNAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 142
    const-string v0, "ARG_NICKNAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    .line 144
    :cond_3
    const-string v0, "ARG_PHONETIC_NAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 145
    const-string v0, "ARG_PHONETIC_NAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e:Ljava/lang/String;

    .line 147
    :cond_4
    const-string v0, "ARG_NAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 148
    const-string v0, "ARG_NAME"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->l:Ljava/lang/String;

    .line 150
    :cond_5
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 151
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 153
    :cond_6
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 154
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    .line 156
    :cond_7
    return-void
.end method

.method public b(Z)V
    .locals 3

    .prologue
    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->p:Landroid/view/MenuItem;

    if-nez v0, :cond_0

    .line 176
    :goto_0
    return-void

    .line 172
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->p:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 174
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->p:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->p:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f0600df

    :goto_1
    invoke-static {v1, v2, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    goto :goto_0

    :cond_1
    const v0, 0x7f060035

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-nez v0, :cond_0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;-><init>()V

    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 116
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 117
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 118
    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->q:I

    .line 120
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->setHasOptionsMenu(Z)V

    .line 121
    return-void

    .line 114
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 203
    const v0, 0x7f0c0003

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 204
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 205
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 206
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->p:Landroid/view/MenuItem;

    .line 207
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 213
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 214
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b()V

    .line 215
    const/4 v0, 0x1

    .line 217
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 180
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_0

    .line 182
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    if-eqz v0, :cond_1

    .line 185
    const-string v0, "ARG_IS_CHILD"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 187
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 188
    const-string v0, "ARG_NICKNAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 191
    const-string v0, "ARG_PHONETIC_NAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->l:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 194
    const-string v0, "ARG_NAME"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->l:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_5

    .line 197
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 199
    :cond_5
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 125
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 126
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a()V

    .line 127
    return-void
.end method

.method protected q()V
    .locals 10

    .prologue
    const/4 v8, 0x0

    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_0

    .line 224
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Ljava/lang/String;J)V

    .line 226
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 231
    const v0, 0x7f100284

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 237
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 255
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 258
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 259
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 260
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v6

    iget-boolean v7, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->o:Z

    .line 261
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V

    .line 258
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 316
    return-void

    .line 233
    :cond_1
    const v0, 0x7f1002f2

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 234
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    .line 233
    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
