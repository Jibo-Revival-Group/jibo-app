.class public Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "SelectGuardianFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private r:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

.field private s:Z

.field private t:Landroid/view/View$OnClickListener;

.field private u:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->s:Z

    .line 60
    new-instance v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->t:Landroid/view/View$OnClickListener;

    .line 202
    new-instance v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->u:Landroid/view/View$OnClickListener;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 139
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberForAccount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    .line 141
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    .line 143
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 144
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    new-instance v4, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v5, 0x7f100157

    invoke-direct {v4, v5}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 145
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v3, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->sortMembers(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Ljava/util/List;

    move-result-object v0

    .line 146
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 149
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 150
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v4

    sget-object v5, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-eq v4, v5, :cond_1

    .line 151
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 152
    :cond_1
    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    new-instance v5, Lcom/jibo/ui/helpers/Items$MemberItem;

    iget-object v6, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->t:Landroid/view/View$OnClickListener;

    iget-object v7, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v5, v6, v7, v0}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 156
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getActiveMembersCount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v0

    .line 158
    if-eqz v2, :cond_3

    const/16 v2, 0x10

    if-ge v0, v2, :cond_3

    .line 160
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v3, Lcom/jibo/ui/helpers/Items$ItemType;->invite:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v4, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V

    const v5, 0x7f100314

    invoke-direct {v2, v3, v4, v5}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 172
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$FooterItem;

    const v3, 0x7f1001f2

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v3, Lcom/jibo/ui/helpers/Items$ItemType;->text_button:Lcom/jibo/ui/helpers/Items$ItemType;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->u:Landroid/view/View$OnClickListener;

    const v5, 0x7f1000f2

    invoke-direct {v2, v3, v4, v5}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 175
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v0, v2, v3, v1}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;-><init>(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->r:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v8}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v8, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, -0x1

    const v4, 0x7f07004f

    const v5, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->r:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 182
    return-void
.end method

.method public a(IILjava/lang/Object;)V
    .locals 4

    .prologue
    .line 120
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(IILjava/lang/Object;)V

    .line 123
    const/16 v0, 0x77

    if-ne p1, v0, :cond_0

    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 124
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->b:Ljava/lang/Boolean;

    .line 125
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 126
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 127
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 128
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/db/EntityData;->a(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    .line 127
    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 129
    const-string v0, "ARG_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 131
    const-string v0, "ARG_IS_PARENT"

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 132
    const-string v0, "ARG_MODE"

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->set_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 133
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 135
    :cond_0
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 191
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 192
    const v0, 0x7f08005e

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 193
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 194
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 195
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 187
    return-void
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    const v0, 0x7f100427

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 86
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreate(Landroid/os/Bundle;)V

    .line 87
    if-eqz p1, :cond_0

    .line 88
    const-string v0, "ARG_DIALOGSHOWN"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->s:Z

    .line 90
    :cond_0
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->setHasOptionsMenu(Z)V

    .line 91
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 97
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 102
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onResume()V

    .line 104
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->s:Z

    if-nez v0, :cond_0

    .line 105
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->s:Z

    .line 106
    const/16 v0, 0x67

    const v1, 0x7f100104

    .line 107
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1000fc

    .line 108
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 106
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 110
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 115
    const-string v0, "ARG_DIALOGSHOWN"

    iget-boolean v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->s:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 116
    return-void
.end method
