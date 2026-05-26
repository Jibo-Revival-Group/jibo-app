.class public Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;
.super Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;
.source "LoopMembersListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;
    }
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field private b:Landroid/view/View$OnLongClickListener;

.field private c:Lcom/jibo/aws/integration/aws/services/account/model/Account;


# direct methods
.method public constructor <init>(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ")V"
        }
    .end annotation

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;-><init>(Ljava/util/List;)V

    .line 37
    iput-object p3, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 38
    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 39
    return-void
.end method


# virtual methods
.method public a(Landroid/view/View$OnLongClickListener;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->b:Landroid/view/View$OnLongClickListener;

    .line 33
    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 84
    return-void
.end method

.method protected getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 2

    .prologue
    .line 43
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$1;->a:[I

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 50
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    :goto_0
    return-object v0

    .line 45
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;-><init>(Landroid/view/View;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    goto :goto_0

    .line 47
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 49
    :pswitch_2
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$DateViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$DateViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 43
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public bridge synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 25
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V
    .locals 3

    .prologue
    .line 56
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    .line 57
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 58
    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$1;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 80
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 61
    :pswitch_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getOwner()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 62
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->b:Landroid/view/View$OnLongClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    goto :goto_0

    :pswitch_2
    move-object v0, p1

    .line 67
    check-cast v0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;

    iget-object v1, p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    .line 68
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0600c6

    .line 67
    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->a(I)V

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getOwner()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->doesLoopHavePlace(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->getItemCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne p2, v0, :cond_0

    move-object v0, p1

    .line 74
    check-cast v0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;

    iget-object v1, p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    .line 75
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060074

    .line 74
    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->a(I)V

    goto :goto_0

    .line 58
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
