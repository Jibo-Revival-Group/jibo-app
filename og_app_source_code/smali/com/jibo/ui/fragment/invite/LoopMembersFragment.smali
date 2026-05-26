.class public Lcom/jibo/ui/fragment/invite/LoopMembersFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "LoopMembersFragment.java"


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


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->a:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 8

    .prologue
    const v7, 0x7f07004f

    const/4 v6, 0x1

    .line 55
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberForAccount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    .line 58
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 59
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v2, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->sortMembers(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Ljava/util/List;

    move-result-object v0

    .line 60
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 61
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->a:Ljava/util/List;

    new-instance v4, Lcom/jibo/ui/helpers/Items$MemberItem;

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v4, v5, v0}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 64
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->a:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v0, v2, v3, v1}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;-><init>(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->r:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v6}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v6, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f0700b6

    invoke-direct {v1, v2, v7, v7, v3}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->r:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 71
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 81
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 82
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 76
    return-void
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    const v0, 0x7f100431

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/LoopMembersFragment;->setHasOptionsMenu(Z)V

    .line 44
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 50
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
