.class public abstract Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "AbstractItemRecycleViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field protected mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->mItems:Ljava/util/List;

    .line 26
    iput-object p1, p0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->mItems:Ljava/util/List;

    .line 27
    return-void
.end method


# virtual methods
.method public getItemCount()I
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getItemType()Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    return v0
.end method

.method protected getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 2

    .prologue
    .line 49
    sget-object v0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$1;->a:[I

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 80
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 51
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$JiboHeaderViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$JiboHeaderViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 53
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SubheaderViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SubheaderViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 55
    :pswitch_2
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 57
    :pswitch_3
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$JiboSettingsViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$JiboSettingsViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 64
    :pswitch_4
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 66
    :pswitch_5
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 68
    :pswitch_6
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 70
    :pswitch_7
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 72
    :pswitch_8
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 75
    :pswitch_9
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 77
    :pswitch_a
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 79
    :pswitch_b
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 49
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method public bridge synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 21
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 39
    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 4

    .prologue
    .line 31
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    aget-object v0, v0, p2

    .line 32
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->getLayoutId()I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 33
    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method
